package com.code.generate.dataSource;

import lombok.Data;

/**
 * @author : zms
 * @create : 2022/6/12
 * @desc : 表描述
 */
@Data
public  class TableDescribe {

    /**
     * 字段名 。
     */
    private String columnName;

    /**
     * 类型 。
     */
    private String type;

    /**
     * 描述 。
     */
    private String remakes;

}
