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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product getProducts(@PathVariable Integer id) throws EntityNotFoundException {
        log.fine(format("Get product %s", id));
        return this.productService.getById(id);
    }

}
