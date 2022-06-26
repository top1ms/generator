package com.code.generate.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/** 
 * @author zms@didiglobal.com
 * @desc 分页
 * @date 2022/6/22 
 */
@Data
public class PageQueryResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 总数
     */
    private Integer           totalCount;

    /**
     * 数据集合
     */
    private List<T>           dataList;

    public static <T> PageQueryResult<T> empty() {
        PageQueryResult<T> result = new PageQueryResult<>();
        result.setTotalCount(0);
        result.setDataList(Collections.emptyList());
        return result;
    }
}