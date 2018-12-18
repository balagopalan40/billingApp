package com.billing.user;

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

import java.util.List;

@Api(value="/users", description="Operations for the user CRUD")
@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	private UserMongoRepository repository;
	
	@ApiOperation(value = "Returns the list of all users", notes = "", response = UserView.class)
	@ApiResponses({@ApiResponse(code = 200, message = "User list"), @ApiResponse(code = 400, message = "Invalid request")})
	@GetMapping(value = "/")
	public List<User> getAllUsers() {
	  return repository.findAll();
	}

	@ApiOperation(value = "Returns the list of all users", notes = "", response = UserView.class)
	@ApiResponses({@ApiResponse(code = 200, message = "Success insertion"), @ApiResponse(code = 400, message = "Invalid request")})
	@PostMapping(value = "/createUser" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@RequestBody final User user) {
		if(user.getName()!=null) {
	User obj = repository.findbyNameAndAge("Bala", 6);
	if(obj!=null) {
	obj.setAge(35);
	repository.save(obj);
	}
		}else {
			throw new NullPointerException("The name is not provided properly");
		}
			
	}
}
