package com.marketplace.service;

import com.marketplace.entity.AbstractEntity;
import com.marketplace.repository.ProductRepository;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
public abstract class AbstractEntityService<T extends AbstractEntity> {

     protected abstract ProductRepository getRepository();

//    public T getById(@NotNull Integer id) throws EntityNotFoundException {
//
//        T t = this.getRepository().get(id);
//
//        if (t == null) {
//            throw new EntityNotFoundException(id);
//        }
//
//        return t;
//    }

//    public Iterable<T> list() {
//        return this.getRepository().findAll();
//    }
//
//    public Page<T> search(PageRequest pageRequest) {
//        return this.getRepository().findAll(pageRequest);
//    }
//
//    public T save(@NotNull T t) {
//        return this.getRepository().save(t);
//    }
//
//    public void delete(@NotNull Integer id) throws EntityNotFoundException {
//        this.getRepository().delete(this.getById(id));
//    }

}
