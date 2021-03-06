package com.marketplace.service;

import com.marketplace.entity.Product;
import com.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@Service
public class ProductService extends AbstractUserEntityService<Product, ProductRepository> {

    @Autowired
    private ProductRepository productRepository;


    @Override
    protected ProductRepository getRepository() {
        return this.productRepository;
    }

}
