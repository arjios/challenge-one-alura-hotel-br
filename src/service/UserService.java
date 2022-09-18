package service;

import dao.UserDAO;
import dto.UserDTO;
import repositories.UserRepository;

public class UserService {

	private UserRepository userRepository = new UserDAO();

	public UserService() {
	}

	public UserDTO findByName(String nome) {
		return userRepository.findByName(nome);
	}
}
