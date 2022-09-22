package controllers;

import dto.UserDTO;
import service.UserService;

public class LoginController {

	static UserService userService = new UserService();
	
	public static UserDTO findUserByName(String name) {
		UserDTO userDTO = userService.findByName(name);
		return userDTO;
	}

}
