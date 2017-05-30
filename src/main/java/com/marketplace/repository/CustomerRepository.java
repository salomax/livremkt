package com.marketplace.repository;

import com.marketplace.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String>, SearchRepository<Customer> {

    @Query("select c from Customer c join c.userPermissions u " +
            "where (c.name like %:search% or c.email like %:search%) " +
            "  and u.user = :user")
    Page<Customer> search(@Param("search") String search, @Param("user") String user, Pageable pageable);

}
