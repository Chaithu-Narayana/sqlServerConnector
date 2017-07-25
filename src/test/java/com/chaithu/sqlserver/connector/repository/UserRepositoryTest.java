/**
 * 
 */
package com.chaithu.sqlserver.connector.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chaithu.sqlserver.connector.entity.User;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	private static int count = 0;
	
	@Before
	public void setUp() throws Exception{
		User user1 = new User("Chaithu");
		User user2 = new User("Laddu");
		
		assertNull(user1.getId());
		assertNull(user2.getId());
		
		this.userRepository.save(user1);
		this.userRepository.save(user2);
		
		assertNotNull(user1.getId());
		assertNotNull(user2.getId());
	}
	
	@Test
	public void fetchUsers()
	{
		User user1 = userRepository.findByName("Chaithu");
		assertNotNull(user1);
		System.out.println(user1);
		
		//int count = 0;
		userRepository.findAll().forEach(user -> count++);
		userRepository.findAll().forEach(user -> System.out.println(user));
		userRepository.findAll().forEach(System.out::println);
		System.out.println("No. of users: "+count);
		/*
		 Iterable<User> users = userRepository.findAll();
		 for (User user : users) {
			count++;
		}*/
		
	}
}
