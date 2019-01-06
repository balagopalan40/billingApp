package com.billing.sales;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="/sales-order", description="Operations for the sales-order CRUD")
@RestController
@RequestMapping("/sales-order")

public class SalesController {
	
	@Autowired
	SalesMongoRepository salesMongoRepository;
	
	@ApiOperation(value = "Returns the list of all sales order", notes = "", response = SalesView.class)
	@ApiResponses({@ApiResponse(code = 200, message = "Sales order list"), @ApiResponse(code = 400, message = "Invalid request")})
	@GetMapping(value = "/")
	public List<SalesView> getAllSalesOrder() {
	  return salesMongoRepository.findAll().stream().map(SalesView::fromSales).collect(Collectors.toList());
	}
	
	@ApiOperation(value = "Returns a particular sales order", notes = "", response = SalesView.class)
	@ApiResponses({@ApiResponse(code = 200, message = "sales order list"), @ApiResponse(code = 400, message = "Invalid request")})
	@GetMapping(value = "/{salesOrderId}")
	public SalesView getSalesOrder(@PathVariable String salesOrderId) {
		Sales result = salesMongoRepository.findbySalesOrderId(salesOrderId);
		return SalesView.fromSales(result);
	}

	@ApiOperation(value = "Creates a new Sales order", notes = "")
	@ApiResponses({@ApiResponse(code = 200, message = "Success insertion"), @ApiResponse(code = 400, message = "Invalid request")})
	@PostMapping(value = "/create-sales-order" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@RequestBody final SalesView salesView) {
		if(salesView.getSalesOrderId()!=null) {
			salesMongoRepository.insert(salesView.toSales());
		}
	}
}
