package com.marketplace.entity;

import javax.persistence.*;

/**
 * @author salomao.marcos@gmail.com
 * @since 29/05/17
 */
@Entity
@Table(name = "ITEM")
public class Item extends SimpleEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    private Double quantity;

    private Double itemValue;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getItemValue() {
        return itemValue;
    }

    public void setItemValue(Double itemValue) {
        this.itemValue = itemValue;
    }

}
