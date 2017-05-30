package com.marketplace.repository;

import com.marketplace.entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
public interface SupplierRepository extends PagingAndSortingRepository<Supplier, String>, SearchRepository<Supplier> {

    @Query("select s from Supplier s join s.userPermissions u " +
            "where (s.name like %:search% or s.email like %:search%) " +
            "  and u.user = :user")
    Page<Supplier> search(@Param("search") String search, @Param("user") String user, Pageable pageable);

}
