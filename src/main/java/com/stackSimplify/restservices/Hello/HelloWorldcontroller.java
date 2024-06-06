package com.stackSimplify.restservices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldcontroller {
	
	
	//@RequestMapping(method = RequestMethod.GET , path ="/helloworld")
	
	@GetMapping("/helloworld1")
	public String helloworld()
	{
		return "Hello World !!!";
	}
	
	@GetMapping("/userDetails")
	public UserDetails getUserDetails()
	{
		return new UserDetails("Arun","Nair","Kochi");
	}

}
