/**
 * 
 */
package com.stackSimplify.restservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.stackSimplify.restservices.Exceptions.UserExistsException;
import com.stackSimplify.restservices.Exceptions.UserNotFoundException;
import com.stackSimplify.restservices.entities.AppUsers;
import com.stackSimplify.restservices.repositories.AppUserRepository;

/**
 * 
 */

@Service
public class AppUserService {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	
	public List<AppUsers> getAllUsers(){
		return appUserRepository.findAll();
	}
	
	public AppUsers createUser(AppUsers user)throws UserExistsException{
		Optional<AppUsers> appUser = appUserRepository.findByUserName(user.getUserName());
	    if(appUser.isPresent()) {
	    	throw new UserExistsException("User Already Existis !!!");
	    }
	
		return appUserRepository.save(user);
	}
	
	public Optional<AppUsers> getUserById(Long id) throws UserNotFoundException
	{
		Optional<AppUsers> user = appUserRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("User No found in the repository");
		}
		
		return user;
	}
	
	public AppUsers updateUser(Long id, AppUsers user) throws UserNotFoundException
	{
		Optional<AppUsers> existingUser = appUserRepository.findById(id);
		
		if(!existingUser.isPresent())
		{
			throw new UserNotFoundException("User not found in the repository, please provide correct user id");
		}
		
		user.setUserID(id);
		return appUserRepository.save(user);	
	}
	
	public void deleteUserById(Long id) {
		Optional<AppUsers> user = appUserRepository.findById(id);
		if(!user.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not found !!!");
		}
		
		appUserRepository.deleteById(id);
	}
	
	public Optional<AppUsers> getUserByUserName(String userName) {
		return appUserRepository.findByUserName(userName);
	}

}
