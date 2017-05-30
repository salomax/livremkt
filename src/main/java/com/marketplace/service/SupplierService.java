package com.marketplace.service;

import com.marketplace.entity.Product;
import com.marketplace.entity.Supplier;
import com.marketplace.repository.ProductRepository;
import com.marketplace.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@Service
public class SupplierService extends AbstractUserEntityService<Supplier, SupplierRepository> {

    @Autowired
    private SupplierRepository repository;


    @Override
    protected SupplierRepository getRepository() {
        return this.repository;
    }

}
