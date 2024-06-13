package com.stackSimplify.restservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackSimplify.restservices.entities.AppUsers;
import com.stackSimplify.restservices.service.AppUserService;

@RestController
public class AppUserontroller {
	
	@Autowired
	private AppUserService userService;
	
	@GetMapping("/findAllUsers")
	public List<AppUsers> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@PostMapping("/createUser")
    public AppUsers createAppUser(@RequestBody AppUsers user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/getUserById/{userId}")
	public Optional<AppUsers> getUserById(@PathVariable Long userId){
		return userService.getUserById(userId);
		
	}
	
	@PutMapping("/updateUserById/{userId}")
	public AppUsers updateUserById(@PathVariable("userId") Long userId, @RequestBody AppUsers user)
	{
		return userService.updateUser(userId, user);
	}
	
	@DeleteMapping("/deleteUserById/{userId}")
	public void deleteUserById(@PathVariable ("userId") Long userId) {
		userService.deleteUserById(userId);
	}
	
	@GetMapping("/getUserByUserName/{userName}")
	public AppUsers getUserByUserName(@PathVariable("userName") String userName) {
		return userService.getUserByUserName(userName);
	}

}
