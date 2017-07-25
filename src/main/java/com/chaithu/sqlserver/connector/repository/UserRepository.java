/**
 * 
 */
package com.chaithu.sqlserver.connector.repository;

import org.springframework.data.repository.CrudRepository;

import com.chaithu.sqlserver.connector.entity.User;

/**
 *
 */
public interface UserRepository extends CrudRepository<User, Integer>{
	
	User findByName(String name);
	User findByEmail(String email);
}
