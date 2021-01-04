package com.xzy.demo.util;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-01-04
 */
@Getter
@Setter
public class Page<T> implements Serializable {

    private static final long serialVersionUID = -6383850663790108196L;

    private int currentIndex;
    private int pageSize;
    private int totalNumber;
    private int totalPage;
    private int nextIndex;
    private int preIndex;
    private List<T> items = Collections.emptyList();

    public Page(int totalNumber, int currentIndex, int pageSize, List<T> items) {
        this.totalNumber = totalNumber;
        this.currentIndex = currentIndex;
        this.pageSize = pageSize;
        this.items = items;
    }

    public Page() {
        this.totalNumber = 0;
        this.currentIndex = 1;
        this.pageSize = 10;
    }

    public int getTotalPage() {
        int size = this.totalNumber / this.pageSize;
        if (this.totalNumber % this.pageSize != 0) {
            ++size;
        }

        this.totalPage = size;
        return this.totalPage;
    }

    public long getNextIndex() {
        if (this.currentIndex >= this.getTotalPage()) {
            this.nextIndex = this.currentIndex;
        } else {
            this.nextIndex = this.currentIndex + 1;
        }

        return this.nextIndex;
    }

    public long getPreIndex() {
        if (this.currentIndex <= 1) {
            this.preIndex = 0;
        } else {
            this.preIndex = this.currentIndex - 1;
        }

        return this.preIndex;
    }

}
