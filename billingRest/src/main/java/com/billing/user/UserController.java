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

import java.time.LocalDate;
import java.util.List;

@Api(value="/users", description="Operations for the user CRUD")
@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	private UserMongoRepository userRepository;
	
	@Autowired
	private SessionMongoRepository sessionRepository;
	
	@ApiOperation(value = "Returns the list of all users", notes = "", response = UserView.class)
	@ApiResponses({@ApiResponse(code = 200, message = "User list"), @ApiResponse(code = 400, message = "Invalid request")})
	@GetMapping(value = "/")
	public List<User> getAllUsers() {
	  return userRepository.findAll();
	}

	@ApiOperation(value = "Returns the list of all users", notes = "")
	@ApiResponses({@ApiResponse(code = 200, message = "Success insertion"), @ApiResponse(code = 400, message = "Invalid request")})
	@PostMapping(value = "/createUser" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@RequestBody final UserView userView) {
		if(userView.getEmail()!=null && userView.getPassword()!=null&&userView.getName()!=null) {
			userRepository.insert(userView.ToUser());
		}
	}
	
	@ApiOperation(value = "Login api to check valid email and password", notes = "")
	@ApiResponses({@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Invalid credentials")})
	@PostMapping(value = "/login" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody final LoginView view) {
		String email = view.getEmail();
		String password = view.getPassword();
		String sessionId = view.getSessionId();
		User userDetails = userRepository.findbyEmailAndPassword(email, password);
		if(userDetails!=null) {
			sessionRepository.deleteByEmail(email);
			Session sessionDetails = Session.builder().email(userDetails.getEmail())
					.sessionId(sessionId).role(userDetails.getRole()).createdTime(LocalDate.now())
					.modifiedTime(LocalDate.now()).build();
			sessionRepository.insert(sessionDetails);
			return true;
		}else {
			throw new NullPointerException("The user name and password dont match , invalid user");
		}
	}
	
	public boolean checkSession(final String session) {
		if(sessionRepository.findBySessionId(session)!=null) {
		return true;
		}
	return false;	
	}
}
