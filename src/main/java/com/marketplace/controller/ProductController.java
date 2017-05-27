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

import com.marketplace.entity.Product;
import com.marketplace.exception.EntityNotFoundException;
import com.marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

import static java.lang.String.format;
    
/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@RestController
public class ProductController {

    private static final Logger log = Logger.getLogger(ProductController.class.getName());

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/api/product", method = RequestMethod.GET)
    public List<Product> list() throws EntityNotFoundException {
        log.fine("List products");
        return this.productService.list();
    }
    
    @RequestMapping(value = "/api/product/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable String id) throws EntityNotFoundException {
        log.fine(format("Get product %s", id));
        return this.productService.getById(id);
    }

    @RequestMapping(value = "/api/product", method = RequestMethod.POST)
    public Product save(@RequestBody Product product) throws EntityNotFoundException {
        log.fine("Save product");
        return this.productService.save(product);
    }

    @RequestMapping(value = "/api/product/{id}", method = RequestMethod.PUT)
    public void save(@PathVariable String id, @RequestBody Product product) throws EntityNotFoundException {
        log.fine("Update product");
        product.setId(this.productService.getById(id).getId());
        this.productService.save(product);
    }

    @RequestMapping(value = "/api/product/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) throws EntityNotFoundException {
        log.fine("Delete product");
        this.productService.delete(this.productService.getById(id));
    }

}
