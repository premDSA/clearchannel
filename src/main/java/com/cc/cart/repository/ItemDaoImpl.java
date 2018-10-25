package com.cc.cart.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cc.cart.entity.Item;


@Repository
public class ItemDaoImpl implements ItemDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	public List<Item> getAllItem() {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Item.class);
		return criteria.list();
	}

	@Override
	public void addNewItem(Item newItem) {
		entityManager.unwrap(Session.class).save(newItem);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> getAllItemByID(List<Integer> itemIdList) {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Item.class);
		criteria.add(Restrictions.in("id", itemIdList));
		return criteria.list();
	}

	@Override
	public Item getItemByID(int itemId) {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Item.class);
		criteria.add(Restrictions.eq("id", itemId));
		return (Item) criteria.uniqueResult();
	}

}
