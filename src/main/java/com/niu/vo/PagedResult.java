package com.niu.vo;

import com.niu.entity.UserInfo;

import java.util.List;

/**
 * Created by ami on 2018/11/20.
 */
public class PagedResult<T> {

    private int pageNum;
    private int pages;
    private Long totals;
    private List<T> pageList;


    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setTotals(long totals) {
        this.totals = totals;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }
}
