package com.tap.DAO;

import java.util.List;

import com.tap.model.User;

public interface UserDAO {
	
	static boolean addUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}
	User getUser(int id);
	void updateUser(User u);
	void deleteUser(int id);
	List<User> getAllUser();
	User loginUser(String email, String password);
	boolean registerUser(User user);
}
