package com.marketplace.service;

import com.marketplace.entity.AbstractUserEntity;
import com.marketplace.exception.EntityNotFoundException;
import com.marketplace.repository.DefaultPage;
import com.marketplace.repository.SearchPageRequest;
import com.marketplace.repository.SearchRepository;
import com.marketplace.repository.UserEntityRepository;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;

import static com.marketplace.utils.SecurityUtils.getGooglePrincipal;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
public abstract class AbstractUserEntityService<E extends AbstractUserEntity, R extends CrudRepository<E, String>> {

     protected abstract R getRepository();

     public E getById(@NotNull String id) throws EntityNotFoundException {
          E e = this.getRepository().findOne(id);
          if (e == null) {
               throw new EntityNotFoundException(id);
          }
          return e;
     }

     public DefaultPage<E> list(String search, SearchPageRequest pageRequest) {
          String userId = getGooglePrincipal().getEmail();
          if (this.getRepository() instanceof SearchRepository) {
               return new DefaultPage(((SearchRepository) this.getRepository())
                       .search(search, userId, pageRequest));
          }
          throw new UnsupportedOperationException();
     }

     public E save(E e) throws EntityNotFoundException {
          if (e.getId() != null) {
               // check if exists or is a fake id
               this.getById(e.getId());
          }
          return this.getRepository().save(e);
     }

     public void delete(E e) throws EntityNotFoundException {
          if (e.getId() != null) {
               // check if exists or is a fake id
               this.getById(e.getId());
          }
          this.getRepository().delete(e);
     }

}
