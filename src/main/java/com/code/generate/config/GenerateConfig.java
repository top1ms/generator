package com.code.generate.config;

import lombok.Data;

/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : 自动生成配置类
 */
@Data
public class GenerateConfig {

    /**
     * 表名称 user_info
     */
    private String      tableName;

    /**
     * 表名称驼峰 userInfo
     */
    private String      tableUnderLineName;

    /**
     * 表名称驼峰 首字母大写 UserInfo
     */
    private String      tableUnderLineNameUpperCase;

    /**
     * DO 类名称 UserInfoDo
     */
    private String      doName;

    /**
     * DO 类输出路径
     */
    private String      doOutputPath;

    /**
     * DO 类包路径前缀
     */
    private String      doPackagePrefixPath;

    /**
     * DO 类包路径
     */
    private String      doPackagePath;

    /**
     * DTO 类名称 UserInfoDTO
     */
    private String      dtoName;

    /**
     * DTO 类输出路径
     */
    private String      dtoOutputPath;

    /**
     * DTO 类包路径前缀
     */
    private String      dtoPackagePrefixPath;

    /**
     * DTO 类包路径
     */
    private String      dtoPackagePath;

    /**
     * 新增编辑 Param 名称 UserInfoSaveParam
     */
    private String      saveParamName;
    private String      saveParamOutputPath;
    private String      saveParamPackagePrefixPath;
    private String      saveParamPackagePath;

    /**
     * 查询 Param 类名称 UserInfoQueryParam
     */
    private String      queryParamName;
    private String      queryParamOutputPath;
    private String      queryParamPackagePrefixPath;
    private String      queryParamPackagePath;

    /**
     * 查询 Condition 类名称 UserInfoQueryCondition
     */
    private String      queryConditionName;
    private String      queryConditionOutputPath;
    private String      queryConditionPackagePrefixPath;
    private String      queryConditionPackagePath;

    /**
     * DAO 类名称 UserInfoDao
     */
    private String      daoName;
    private String      daoOutputPath;
    private String      daoPackagePrefixPath;
    private String      daoPackagePath;
    

    /**
     * DAO Impl 类名称 UserInfoDaoImpl
     */
    private String      daoImplName;
    private String      daoImplOutputPath;
    private String      daoImplPackagePrefixPath;
    private String      daoImplPackagePath;

    /**
     * service 类名称  UserInfoService
     */
    private String      serviceName;
    private String      serviceOutputPath;
    private String      servicePackagePrefixPath;
    private String      servicePackagePath;

    /**
     * serviceImpl 类名称 UserInfoServiceImpl
     */
    private String      serviceImplName;
    private String      serviceImplOutputPath;
    private String      serviceImplPackagePrefixPath;
    private String      serviceImplPackagePath;

    /**
     * mapper
     */
    private String      daoMapperName;

}
