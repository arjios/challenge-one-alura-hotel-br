package repositories;

import entities.User;

public interface UserRepository {

	User findByName(String name);
	
}
