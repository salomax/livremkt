package com.marketplace.service;

import com.marketplace.entity.AbstractEntity;
import com.marketplace.exception.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.validation.constraints.NotNull;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
public abstract class AbstractEntityService<T extends AbstractEntity> {

    protected abstract PagingAndSortingRepository<T, Integer> getRepository();

    public T getById(@NotNull Integer id) throws EntityNotFoundException {

        T t = this.getRepository().findOne(id);

        if (t == null) {
            throw new EntityNotFoundException(id);
        }

        return t;
    }

    public Iterable<T> list() {
        return this.getRepository().findAll();
    }

    public Page<T> search(PageRequest pageRequest) {
        return this.getRepository().findAll(pageRequest);
    }

    public T save(@NotNull T t) {
        return this.getRepository().save(t);
    }

    public void delete(@NotNull Integer id) throws EntityNotFoundException {
        this.getRepository().delete(this.getById(id));
    }

}
