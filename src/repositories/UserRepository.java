package repositories;

import java.util.Set;

import dto.UserDTO;

public interface UserRepository {
	
	Set<UserDTO> findAll();
	UserDTO findById(Long id);
	UserDTO findByName(String name);
	
}
