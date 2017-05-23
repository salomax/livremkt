package com.marketplace.repository;

import com.marketplace.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
