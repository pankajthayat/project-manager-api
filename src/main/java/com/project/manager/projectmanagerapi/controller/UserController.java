package com.project.manager.projectmanagerapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.manager.projectmanagerapi.exception.UserNotFoundException;
import com.project.manager.projectmanagerapi.modal.User;
import com.project.manager.projectmanagerapi.repository.UserRepository;
import com.project.manager.projectmanagerapi.service.UserService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) throws Exception{
		System.out.println("post mapping : "+ userRepository.findByEmployeeId(user.getEmployeeId()));
		if(userRepository.findByEmployeeId(user.getEmployeeId())!= null)
			throw new RuntimeException("user already exist");
		return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
		
	}
	
	@GetMapping("/")
	public List<User> getAlluser(){
		return userRepository.findAll();
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<User> getUser(@PathVariable Long employeeId){
		User user =userRepository.findByEmployeeId(employeeId);
		if(user == null)
			throw new UserNotFoundException("user does not exit");
		return ResponseEntity.status(HttpStatus.FOUND).body(user);
	}
	
//	@PutMapping("/user")
//	public ResponseEntity updateUser(@Valid @RequestBody User user){
//		return ResponseEntity.status(
//				HttpStatus.CREATED)
//				.body(userService.updateUser(user)
//						);
//
//	}
    @PutMapping("/update")
	public ResponseEntity<User> updateUser(User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(user));
	}

	public ResponseEntity deleteUser(User user){
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(userRepository.deleteByEmployeeId(user.getEmployeeId()));
		} catch (Exception ex){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
	}

}
