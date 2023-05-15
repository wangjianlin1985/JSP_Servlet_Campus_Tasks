// 
// 
// 

package pers.hdh.beans;

import java.util.List;

public class PageBean<E>
{
    private List<E> list;
    private Integer currPage;
    private Integer pageSize;
    private Integer totalCount;
    private Integer totalPage;
    
    public List<E> getList() {
        return this.list;
    }
    
    public void setList(final List<E> list) {
        this.list = list;
    }
    
    public Integer getCurrPage() {
        return this.currPage;
    }
    
    public void setCurrPage(final Integer currPage) {
        this.currPage = currPage;
    }
    
    public Integer getPageSize() {
        return this.pageSize;
    }
    
    public void setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
    }
    
    public Integer getTotalCount() {
        return this.totalCount;
    }
    
    public void setTotalCount(final Integer totalCount) {
        this.totalCount = totalCount;
    }
    
    public Integer getTotalPage() {
        return (int)Math.ceil(this.totalCount * 1.0 / this.pageSize);
    }
    
    public PageBean() {
    }
    
    public PageBean(final List<E> list, final Integer currPage, final Integer pageSize, final Integer totalCount) {
        this.list = list;
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }
}
