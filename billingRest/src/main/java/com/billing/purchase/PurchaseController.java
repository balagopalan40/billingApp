package com.billing.purchase;

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

@Api(value="/purchase-order", description="Operations for the purchase-oder CRUD")
@RestController
@RequestMapping("/purchase-order")

public class PurchaseController {
	
	@Autowired
	PurchaseMongoRepository purchaseMongoRepository;
	
	@ApiOperation(value = "Returns the list of all purchase order", notes = "", response = PurchaseView.class)
	@ApiResponses({@ApiResponse(code = 200, message = "Purchase order list"), @ApiResponse(code = 400, message = "Invalid request")})
	@GetMapping(value = "/")
	public List<PurchaseView> getAllPurchaseOrder() {
	  return purchaseMongoRepository.findAll().stream().map(PurchaseView::fromPurchase).collect(Collectors.toList());
	}
	
	@ApiOperation(value = "Returns a particular purchase order", notes = "", response = PurchaseView.class)
	@ApiResponses({@ApiResponse(code = 200, message = "Purchase order list"), @ApiResponse(code = 400, message = "Invalid request")})
	@GetMapping(value = "/{purchaseOrderId}")
	public PurchaseView getPurchaseOrder(@PathVariable String purchaseOrderId) {
		Purchase result = purchaseMongoRepository.findbyPurchaseOrderId(purchaseOrderId);
		return PurchaseView.fromPurchase(result);
	}

	@ApiOperation(value = "Creates a new purchase order", notes = "")
	@ApiResponses({@ApiResponse(code = 200, message = "Success insertion"), @ApiResponse(code = 400, message = "Invalid request")})
	@PostMapping(value = "/create-purchase-order" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@RequestBody final PurchaseView purchaseView) {
		if(purchaseView.getPurchaseOrderId()!=null) {
			purchaseMongoRepository.insert(purchaseView.toPurchase());
		}
	}
}
