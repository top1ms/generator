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
    private String  columnName;

    /**
     * 驼峰转换  首位大写 。
     */
    private String  underLineAndUpperCase;

    /**
     * 驼峰转换 。
     */
    private String  underLineColumnName;

    /**
     * 原始字段名 。
     */
    private String  originColumnName;

    /**
     * 数据库主键 。
     */
    private boolean primaryKey ;

    /**
     * 类型 。
     */
    private String  type;

    /**
     * 描述 。
     */
    private String  remakes;

}
