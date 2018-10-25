/**
 * 
 */
package com.cc.cart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.cart.entity.UserDetails;
import com.cc.cart.repository.UserDao;




@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public List<UserDetails> getUserDetails() {
		return userDao.getUserDetails();

	}

}
