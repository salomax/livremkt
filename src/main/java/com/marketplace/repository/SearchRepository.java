package com.marketplace.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author salomao.marcos@gmail.com
 * @since 29/05/17
 */
public interface SearchRepository<E> {
    Page<E> search(String search, String user, Pageable pageable);
}
