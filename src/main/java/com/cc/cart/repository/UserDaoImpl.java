package com.cc.cart.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.cc.cart.entity.UserDetails;


@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	public List<UserDetails> getUserDetails() {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(UserDetails.class);
		return criteria.list();
	}

}
