package com.cc.cart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cart {

    public Cart(final int cardGroupId, final int itemId, final int quantity) {
        super();
        this.cardGroupId = cardGroupId;
        this.itemId = itemId;
        Quantity = quantity;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    @Column
    private int cardGroupId;

    @Column
    private int itemId;

    @Column
    private int Quantity;

    public int getCardGroupId() {
        return cardGroupId;
    }

    public void setCardGroupId(final int cardGroupId) {
        this.cardGroupId = cardGroupId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(final int cardId) {
        this.cardId = cardId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(final int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(final int quantity) {
        Quantity = quantity;
    }

}
