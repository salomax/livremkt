package com.marketplace.service;

import com.marketplace.entity.Customer;
import com.marketplace.entity.Supplier;
import com.marketplace.repository.CustomerRepository;
import com.marketplace.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@Service
public class CustomerService extends AbstractUserEntityService<Customer, CustomerRepository> {

    @Autowired
    private CustomerRepository repository;


    @Override
    protected CustomerRepository getRepository() {
        return this.repository;
    }

}
