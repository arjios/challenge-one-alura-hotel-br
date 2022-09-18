package controllers;

import dto.UserDTO;
import service.UserService;

public class LoginController {

	private UserService userService = new UserService();
	private UserDTO userDTO = new UserDTO();
	
	public UserDTO isUser(String name, String senha) {
		userDTO = userService.findByName(name);
		return userDTO;
	}
	
}
