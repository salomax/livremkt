package com.marketplace.service;

import com.google.common.collect.Lists;
import com.marketplace.entity.Product;
import com.marketplace.exception.EntityNotFoundException;
import com.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getById(@NotNull String id) throws EntityNotFoundException {

        Product product = this.productRepository.findOne(id);

        if (product == null) {
            throw new EntityNotFoundException(id);
        }

        return product;
    }

    public List<Product> list() {
        return Lists.newArrayList(this.productRepository.findAll());
    }

    public Product save(Product product) throws EntityNotFoundException {
        if (product.getId() != null) {
            // check if exists or is a fake id
            Product productStored = this.getById(product.getId());
            product.setUserPermissions(productStored.getUserPermissions());
        }
        return this.productRepository.save(product);
    }

    public void delete(Product product) throws EntityNotFoundException {
        if (product.getId() != null) {
            // check if exists or is a fake id
            this.getById(product.getId());
        }
        this.productRepository.delete(product);
    }

}
