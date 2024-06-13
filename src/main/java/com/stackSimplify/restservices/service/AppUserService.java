/**
 * 
 */
package com.stackSimplify.restservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	public AppUsers createUser(AppUsers user){
		return appUserRepository.save(user);
	}
	
	public Optional<AppUsers> getUserById(Long id)
	{
		return appUserRepository.findById(id);
	}
	
	public AppUsers updateUser(Long id, AppUsers user)
	{
		user.setUserID(id);
		return appUserRepository.save(user);	
	}
	
	public void deleteUserById(Long id) {
		appUserRepository.deleteById(id);
	}
	
	public AppUsers getUserByUserName(String userName) {
		return appUserRepository.findByUserName(userName);
	}

}
