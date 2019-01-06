package com.billing.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserView {
	
	@ApiModelProperty(value = "Name of the user", required = false, dataType = "java.lang.String", example = "Bala", position = 1)
	private String name;
	
	@ApiModelProperty(value = "Email of the user", required = false, dataType = "java.lang.String", example = "bala@gmail.com", position = 2)
	private String email ;
	
	@ApiModelProperty(value = "Phone number of the user", required = false, dataType = "java.lang.long", example = "9738379638", position = 3)
	private long phoneNumber;
	
	@ApiModelProperty(value = "Country code of the user", required = false, dataType = "java.lang.int", example = "91", position = 4)
	private int countryCode;
	
	@ApiModelProperty(value = "Password code of the user", required = false, dataType = "java.lang.String", example = "anything", position = 5)
	private String password;
	
	@ApiModelProperty(value = "Role of the user", required = false, dataType = "java.lang.String", example = "anything", position = 6)
	private String role;
	
	public User ToUser() {
		return User.builder().name(name).email(email).password(password).phoneNumber(phoneNumber).countryCode(countryCode).role(role).build();
	}
	
	public static UserView FromUser(User input) {
		return UserView.builder().name(input.getName()).email(input.getEmail()).password(input.getPassword()).phoneNumber(input.getPhoneNumber()).countryCode(input.getCountryCode()).role(input.getRole()).build();
	}
	
}
