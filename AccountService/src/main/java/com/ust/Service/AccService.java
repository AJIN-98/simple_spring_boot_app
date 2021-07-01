package com.ust.Service;

import java.util.List;

import com.ust.model.User;

public interface AccService {

	boolean addUser(User user);
	boolean updateUser(User user);
	User getUserByid(int accountId);
	List<User> fnameSort();
	List<User> lnameSort();
	List<User> ageSort();
	
}
