package com.code.generate.beans;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author zms@didiglobal.com
 * @desc 分页查询基类
 * @date 2021/11/18
 */
public class BasePageQuery implements Serializable {

    public final static Integer DEFAULT_PAGE_NO   = 1;

    public final static Integer DEFAULT_PAGE_SIZE = 20;
    /**
     * 页号 。
     */
    private Integer             pageNo;

    /**
     * 页码 。
     */
    private Integer             pageSize;

    /**
     * 起始行数 。
     */
    private Integer             startRow;

    /**
     * 偏移量 。
     */
    private Integer             offSet;

    /**
     * 分页 size 最大 200 。
     */
    public final static int     MAX_PAGE_SIZE     = 200;

    public void setPageSize(Integer pageSize) {
        if (Objects.nonNull(pageSize) && pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setOffSet(Integer offSet) {
        this.offSet = offSet;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getOffSet() {
        return offSet;
    }

    public Integer getStartRow() {
        return startRow;
    }
}
