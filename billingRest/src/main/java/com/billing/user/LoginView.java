package com.billing.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginView {
	
	@ApiModelProperty(value = "Email of the user", required = false, dataType = "java.lang.String", example = "bala@gmail.com", position = 1)
	private String email ;
	
	@ApiModelProperty(value = "Password code of the user", required = false, dataType = "java.lang.String", example = "anything", position = 2)
	private String password;

	@ApiModelProperty(value = "session id sent from broswerr", required = false, dataType = "java.lang.String", example = "anything", position = 3)
	private String sessionId;
}
