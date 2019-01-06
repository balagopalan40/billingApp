package com.billing.utils;

import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SupplierView {
	
	@ApiModelProperty(value = "Name of the supplier", required = false, dataType = "java.lang.String", example = "V V traders", position = 1)
	private String name;
	
	@ApiModelProperty(value = "Name of the state", required = false, dataType = "java.lang.String", example = "Tamil Nadu", position = 2)
	private String state;
	
	@ApiModelProperty(value = "Address of the supplier", required = false, dataType = "java.lang.String", example = "No.3 kovil street", position = 3)
	private String address;
	
	@ApiModelProperty(value = "Phone number of the supplier", required = false, dataType = "java.lang.long", example = "9738379638", position = 4)
	private long phoneNumber;
	
	public Supplier toSupplier() {
	return Supplier.builder().name(this.getName()).address(this.getName())
			.phoneNumber(this.getPhoneNumber()).state(this.getState()).stdCode(0422)
			.createdTime(LocalDate.now()).modifiedTime(LocalDate.now()).build();
	}
	
	public static SupplierView fromSupplier(Supplier input) {
		return SupplierView.builder().name(input.getName()).address(input.getName())
				.phoneNumber(input.getPhoneNumber()).state(input.getState()).build();
	}
}
