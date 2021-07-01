package com.ust.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.Repository.AccountRepository;
import com.ust.model.User;

@Service
public class ServiceImpl implements AccService {

	@Autowired
	AccountRepository repository;
	@Override
	public boolean addUser(User user) {
		try {
			repository.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try {
			User us=repository.getByAccountId(user.getAccountId());
			if(us!=null) {
				us.setFirstName(user.getFirstName());
				us.setLastName(user.getLastName());
				us.setMiddleName(user.getMiddleName());
				us.setAge(user.getAge());
				repository.save(us);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User getUserByid(int accountId) {
		
			User us=repository.getByAccountId(accountId);
			return us;
		
	}

	@Override
	public List<User> fnameSort() {
		List<User> list=repository.findAll();
		list=list.stream().sorted(Comparator.comparing(User::getFirstName)).collect(Collectors.toList());
		return list;
	}

	@Override
	public List<User> lnameSort() {
		List<User> list=repository.findAll();
		list=list.stream().sorted(Comparator.comparing(User::getLastName)).collect(Collectors.toList());
		return list;
	}

	@Override
	public List<User> ageSort() {
		List<User> list=repository.findAll();
		list=list.stream().sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList());
		return list;
	}

}
