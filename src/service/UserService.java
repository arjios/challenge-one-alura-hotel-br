package service;

import dto.UserDTO;
import entities.User;
import repositories.UserRepository;

public class UserService {

	private UserRepository userRepository;
	
	public UserDTO findById(String nome) {
		User obj = userRepository.findByName(nome);
		return new UserDTO(obj);
	}
}
