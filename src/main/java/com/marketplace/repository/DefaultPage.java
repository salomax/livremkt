package com.marketplace.repository;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author salomao.marcos@gmail.com
 * @since 27/05/17
 */
public class DefaultPage<T> {

    private long total;
    private List<T> rows;

    public DefaultPage(Page page) {
        this.total = page.getTotalElements();
        this.rows = page.getContent();
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}
