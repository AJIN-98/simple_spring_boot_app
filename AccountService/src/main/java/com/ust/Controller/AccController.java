package com.ust.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.Service.ServiceImpl;
import com.ust.model.User;

@RestController
public class AccController {

@Autowired
ServiceImpl service;

@PostMapping("/account/user/create")
public ResponseEntity<String> Create(@RequestBody User user) {
try {
	service.addUser(user);
	return new ResponseEntity<String>("user added",HttpStatus.CREATED);
} catch (Exception e) {
	return new ResponseEntity<String>("Failed to create",HttpStatus.CONFLICT);
}
}
@PutMapping("/account/user/update")
public ResponseEntity<String> update(@RequestBody User user){
	try {
		service.updateUser(user);
		return new ResponseEntity<String>("user updated",HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<String>("Failed to update",HttpStatus.CONFLICT);
	}
}
@GetMapping("/account/user/{id}")
public ResponseEntity<?> getUserById(@PathVariable int id) {
	try {
		User user=service.getUserByid(id);
		if(user!=null) {
		return new ResponseEntity<User>(service.getUserByid(id), HttpStatus.OK);
		}
		return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
	} catch (Exception e) {
		return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
	}
}
@GetMapping("/account/user/fnamesort")
public ResponseEntity<?> fsort(){
	
		List<User> list =service.fnameSort();
		return new ResponseEntity <List<User>> (list, HttpStatus.OK);
	}
@GetMapping("/account/user/lnamesort")
public ResponseEntity<?> lsort(){
	
		List<User> list =(service.lnameSort());
		return new ResponseEntity <List<User>> (list, HttpStatus.OK);
	}
@GetMapping("/account/user/agesort")
public ResponseEntity<?> ageSort(){
	
		List<User> list =service.ageSort();
		return new ResponseEntity <List<User>> (list, HttpStatus.OK);
	}
}
