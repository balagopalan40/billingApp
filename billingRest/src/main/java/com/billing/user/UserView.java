package com.billing.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserView {
	
	@ApiModelProperty(value = "Name of the user", required = false, dataType = "java.lang.String", example = "Bala", position = 1)
	private String name;
	
	@ApiModelProperty(value = "Age of the user", required = false, dataType = "java.lang.int", example = "25", position = 2)
	private int age;
}
