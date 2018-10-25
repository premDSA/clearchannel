package com.cc.cart.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cc.cart.entity.CartOrder;
import com.cc.cart.entity.Item;
import com.cc.cart.entity.OrderDetails;

@Repository
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addOrder(final CartOrder order) {
        entityManager.unwrap(Session.class).save(order);
    }

    @Override
    public int getOrderIdByCartId(final int cartID) {
        @SuppressWarnings("deprecation")
        final Criteria criteria = entityManager.unwrap(Session.class).createCriteria(CartOrder.class);
        criteria.add(Restrictions.eq("cartGroupId", cartID));
        return (int) criteria.uniqueResult();
    }

    @Override
    public void addOrderDetail(final Item eachItem, final int orderId) {
        entityManager.unwrap(Session.class).save(new OrderDetails(orderId, eachItem.getId()));
    }

}
