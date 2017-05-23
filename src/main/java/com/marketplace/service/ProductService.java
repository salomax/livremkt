package com.marketplace.service;

import com.marketplace.entity.Product;
import com.marketplace.exception.EntityNotFoundException;
import com.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getById(@NotNull Integer id) throws EntityNotFoundException {

        Product product = this.productRepository.findOne(id);

        if (product == null) {
            throw new EntityNotFoundException(id);
        }

        return product;
    }
}
