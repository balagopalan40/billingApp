package com.billing.utils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="/utils", description="Operations for the addition and modification of suppliers , customers, brand and variety")
@RestController
@RequestMapping("/utils")
public class UtilsController {
	
	@Autowired
	UtilsMongoRepository utilsMongoRepository;
	
	@ApiOperation(value = "Returns the list of all supplies", notes = "", response = SupplierView.class)
	@ApiResponses({@ApiResponse(code = 200, message = "Supplier list"), @ApiResponse(code = 400, message = "Invalid request")})
	@GetMapping(value = "/supplier-list")
	public List<SupplierView> getAllSupplier() {
	  List<Utils> utils = utilsMongoRepository.findAll();
	  return utils.get(0).getSupplier().stream().map(SupplierView::fromSupplier).collect(Collectors.toList());
	}
	
	@ApiOperation(value = "Insert a new supplier", notes = "")
	@ApiResponses({@ApiResponse(code = 200, message = "Success insertion"), @ApiResponse(code = 400, message = "Invalid request")})
	@PostMapping(value = "/supplier/new" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@RequestBody final SupplierView supplierView) {
		List<Utils> utilsList = utilsMongoRepository.findAll();
		if(utilsList.size()>0) {
			utilsList.get(0).getSupplier().add(supplierView.toSupplier());
		} else {
			Utils utils = Utils.builder().customer(Arrays.asList("cutomer1")).brand(Arrays.asList("brand1")).variety(Arrays.asList("variety1"))
			.createdTime(LocalDate.now()).modifiedTime(LocalDate.now()).supplier(Arrays.asList(supplierView.toSupplier())).build();
			utilsList.add(utils);			
		}
		utilsMongoRepository.saveAll(utilsList);
	}
	
	

}
