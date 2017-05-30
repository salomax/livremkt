package com.marketplace.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @author salomao.marcos@gmail.com
 * @since 27/05/17
 */
public class SearchPageRequest extends PageRequest {

    public final static String DEFAULT_LIMIT = "10";

    private SearchPageRequest(Builder builder) {
        super(builder.offset/builder.limit, builder.limit, builder.buildSort());
    }

    public static final class Builder {

        private int offset;
        private int limit;
        private String sort;
        private String order;

        public Builder offset(int offset) {
            this.offset = offset;
            return this;
        }

        public Builder limit(int limit) {
            this.limit = limit;
            return this;
        }

        public Builder sort(String sort) {
            this.sort = sort;
            return this;
        }

        public Builder order(String order) {
            this.order = order;
            return this;
        }

        public Sort buildSort() {
            if (this.sort != null) {
                return new Sort(Sort.Direction.valueOf(order.toUpperCase()), sort);
            }
            return null;
        }

        public SearchPageRequest build() {
            return new SearchPageRequest(this);
        }

    }

}
