package com.ust.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.model.User;

public interface AccountRepository extends JpaRepository<User, String>{

	User getByAccountId(int accountId);
	
}
