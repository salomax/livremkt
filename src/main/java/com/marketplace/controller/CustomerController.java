/*
 * Copyright 2017, Marcos Salomão.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.marketplace.controller;

import com.marketplace.entity.Customer;
import com.marketplace.exception.EntityNotFoundException;
import com.marketplace.repository.DefaultPage;
import com.marketplace.repository.SearchPageRequest;
import com.marketplace.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

import static java.lang.String.format;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@RestController
public class CustomerController {

    private static final Logger log = Logger.getLogger(CustomerController.class.getName());

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/api/customer", method = RequestMethod.GET)
    public DefaultPage<Customer> list(@RequestParam(defaultValue = "") String search,
                                     @RequestParam(defaultValue = "0") Integer offset,
                                     @RequestParam(defaultValue = SearchPageRequest.DEFAULT_LIMIT) Integer limit,
                                     @RequestParam(required = false) String sort,
                                     @RequestParam(defaultValue = "asc") String order)
            throws EntityNotFoundException {
        log.fine("List customers");
        SearchPageRequest pageRequest = new SearchPageRequest.Builder()
                .offset(offset).limit(limit).sort(sort).order(order).build();
        return this.customerService.list(search, pageRequest);
    }

    @RequestMapping(value = "/api/customer/{id}", method = RequestMethod.GET)
    public Customer get(@PathVariable String id) throws EntityNotFoundException {
        log.fine(format("Get customer %s", id));
        return this.customerService.getById(id);
    }

    @RequestMapping(value = "/api/customer", method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer) throws EntityNotFoundException {
        log.fine("Save customer");
        return this.customerService.save(customer);
    }

    @RequestMapping(value = "/api/customer/{id}", method = RequestMethod.PUT)
    public void save(@PathVariable String id, @RequestBody Customer customer) throws EntityNotFoundException {
        log.fine("Update customer");
        customer.setId(this.customerService.getById(id).getId());
        this.customerService.save(customer);
    }

    @RequestMapping(value = "/api/customer/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) throws EntityNotFoundException {
        log.fine("Delete customer");
        this.customerService.delete(this.customerService.getById(id));
    }

}
