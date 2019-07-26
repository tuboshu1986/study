package com.hb.test.student.handler.define;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 页面信息
 */
public class PageInfo<T> {
    private Integer pageNo;
    private Integer pageSize;
    private Integer totalPages;
    private Long totalRecords;
    private List<T> content;
    private Boolean hasData = true;

    public PageInfo() {
    }

    public PageInfo(Page<T> page) {
        this.hasData = page.hasContent();
        this.pageNo = page.getNumber() + 1;
        this.pageSize = page.getSize();
        this.totalPages = page.getTotalPages();
        this.totalRecords = page.getTotalElements();
        this.content =  page.getContent();
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Boolean getHasData() {
        return hasData;
    }

    public void setHasData(Boolean hasData) {
        this.hasData = hasData;
    }
}
