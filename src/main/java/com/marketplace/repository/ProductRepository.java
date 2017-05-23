package com.marketplace.repository;

import com.marketplace.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
//@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

//    @Autowired
//    private EntityManager entityManager;
//
//    public Product get(Integer id) {
//        Product product = entityManager.find(Product.class, id);
//        return product;
//    }

}
