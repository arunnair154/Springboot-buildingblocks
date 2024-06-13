/**
 * 
 */
package com.stackSimplify.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackSimplify.restservices.entities.AppUsers;

/**
 * 
 */

@Repository
public interface AppUserRepository extends JpaRepository<AppUsers, Long>{
	
	AppUsers findByUserName(String userName);

}
