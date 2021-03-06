package com.cc.cart.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cc.cart.entity.Cart;
import com.cc.cart.entity.Item;

@Repository
public class CartDaoImpl implements CartDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Item> getAllItem() {
        final Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Item.class);
        return criteria.list();
    }

    @Override
    public void deleteItemToCart(final int itemID, final int cartId) {

        entityManager.unwrap(Session.class).delete(new Cart(cartId, itemID, 1));

    }

    @Override
    public void addItemToCart(final Cart cart) {
        entityManager.unwrap(Session.class).save(cart);
    }

    @Override
    public List<Integer> listAllItemsInCart(final int cartID) {
        final Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Cart.class);
        criteria.add(Restrictions.eq("cardGroupId", cartID));
        criteria.setProjection(Projections.property("itemId"));
        return criteria.list();
    }

    @Override
    public int createCartGroupId() {
        // TODO Auto-generated method stub
        /*
         * Query q = entityManager.createNativeQuery("SELECT MAX(CARD_GROUP_ID)  FROM CART"); return
         * (int)q.executeUpdate();
         */
        final Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Cart.class);
        criteria.setProjection(Projections.max("cardGroupId"));
        return (int) criteria.uniqueResult();
    }

    /*
     * @Override public void addNewItem(Item newItem) {
     * entityManager.unwrap(Session.class).save(newItem); // TODO Auto-generated method stub
     * 
     * }
     */

}
