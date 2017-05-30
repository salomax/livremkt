package com.marketplace.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author salomao.marcos@gmail.com
 * @since 29/05/17
 */
@Entity
@Table(name = "ORDER")
public class Order extends AbstractUserEntity {

    @Temporal(TemporalType.DATE)
    private java.util.Date date;

    @ElementCollection
    @OrderColumn
    private List<Item> items = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "customer_id")
    private Customer customer;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
