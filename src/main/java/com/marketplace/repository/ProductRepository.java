package com.marketplace.repository;

import com.marketplace.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, String>, SearchRepository<Product> {

    @Query("select p from Product p join p.userPermissions u " +
            "where (p.code like %:search% or p.name like %:search%) " +
            "  and u.user = :user")
    Page<Product> search(@Param("search") String search, @Param("user") String user, Pageable pageable);

}
