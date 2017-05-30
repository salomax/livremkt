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

import com.marketplace.entity.Supplier;
import com.marketplace.exception.EntityNotFoundException;
import com.marketplace.repository.DefaultPage;
import com.marketplace.repository.SearchPageRequest;
import com.marketplace.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

import static java.lang.String.format;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@RestController
public class SupplierController {

    private static final Logger log = Logger.getLogger(SupplierController.class.getName());

    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = "/api/supplier", method = RequestMethod.GET)
    public DefaultPage<Supplier> list(@RequestParam(defaultValue = "") String search,
                                     @RequestParam(defaultValue = "0") Integer offset,
                                     @RequestParam(defaultValue = SearchPageRequest.DEFAULT_LIMIT) Integer limit,
                                     @RequestParam(required = false) String sort,
                                     @RequestParam(defaultValue = "asc") String order)
            throws EntityNotFoundException {
        log.fine("List suppliers");
        SearchPageRequest pageRequest = new SearchPageRequest.Builder()
                .offset(offset).limit(limit).sort(sort).order(order).build();
        return this.supplierService.list(search, pageRequest);
    }

    @RequestMapping(value = "/api/supplier/{id}", method = RequestMethod.GET)
    public Supplier get(@PathVariable String id) throws EntityNotFoundException {
        log.fine(format("Get supplier %s", id));
        return this.supplierService.getById(id);
    }

    @RequestMapping(value = "/api/supplier", method = RequestMethod.POST)
    public Supplier save(@RequestBody Supplier supplier) throws EntityNotFoundException {
        log.fine("Save supplier");
        return this.supplierService.save(supplier);
    }

    @RequestMapping(value = "/api/supplier/{id}", method = RequestMethod.PUT)
    public void save(@PathVariable String id, @RequestBody Supplier supplier) throws EntityNotFoundException {
        log.fine("Update supplier");
        supplier.setId(this.supplierService.getById(id).getId());
        this.supplierService.save(supplier);
    }

    @RequestMapping(value = "/api/supplier/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) throws EntityNotFoundException {
        log.fine("Delete supplier");
        this.supplierService.delete(this.supplierService.getById(id));
    }

}
