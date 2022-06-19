package com.code.generate.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.code.generate.config.GenerateConfig;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : 路径相关工具类
 */
public abstract class GenerateConfigUtils {

    /**
     * mapper.xml 输出路径前缀
     */
    private final static String MAPPER_XML_OUT_PATH_PREFIX = "/Users/top1ms/IdeaProjects/generator/src/main/resources/mapper/";

    /**
     * dto 输出路径前缀
     */
    private final static String DTO_OUT_PATH_PREFIX = "/Users/top1ms/IdeaProjects/generator/src/main/java/com/code/generate/beans/dto/";

    /**
     * po 输出路径前缀
     */
    private final static String DO_OUT_PATH_PREFIX = "/Users/top1ms/IdeaProjects/generator/src/main/java/com/code/generate/beans/po/";

    /**
     * dao 输出路径前缀
     */
    private final static String DAO_OUT_PATH_PREFIX = "/Users/top1ms/IdeaProjects/generator/src/main/java/com/code/generate/dao/";


    /**
     * daoImpl 输出路径前缀
     */
    private final static String DAO_IMPL_OUT_PATH_PREFIX = "/Users/top1ms/IdeaProjects/generator/src/main/java/com/code/generate/dao/impl";

    /**
     * dto 包路径前缀
     */
    private final static String DTO_PACKAGE_PREFIX = "com.code.generate.beans.dto";

    /**
     * po 包路径前缀
     */
    private final static String DO_PACKAGE_PREFIX = "com.code.generate.beans.po";

    /**
     * dao 包路径前缀
     */
    private final static String DAO_PACKAGE_PREFIX = "com.code.generate.dao";

    /**
     * daoImpl 包路径前缀
     */
    private final static String DAO_IMPL_PACKAGE_PREFIX = "com.code.generate.dao.impl";


    /**
     * service 包路径前缀
     */
    private final static String SERVICE_PACKAGE_PREFIX = "com.code.generate.services";

    /**
     * serviceImpl 包路径前缀
     */
    private final static String SERVICE_IMPL_PACKAGE_PREFIX = "com.code.generate.services.impl";

    /**
     * java 类型后缀
     */
    private final static String JAVA_SUFFIX = ".java";

    /**
     * xml 路径后缀
     */
    private final static String MAPPER_XML_OUT_PATH_SUFFIX = ".xml";

    private final static String ABSOLUTE_PATH_FORMAT = "%s%s%s";

    private final static String ABSOLUTES_PATH_FORMAT = "%s.%s";

    public static String format(String prefix, String fileName, String suffix) {
        return String.format(ABSOLUTE_PATH_FORMAT, prefix, fileName, suffix);
    }

    public static String format(String prefix, String fileName) {
        return String.format(ABSOLUTES_PATH_FORMAT, prefix, fileName);
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 自动生成配置填充
     */
    public static GenerateConfig generateConfig(String tableName) throws Exception {
        if (StringUtils.isBlank(tableName)) {
            throw new Exception("tableName error");
        }
        String tableUnderLineName = StringFormatUtils.replaceUnderLine(tableName);
        String tableUnderLinNameUpperCase = StringFormatUtils.upperCaseByFirst(tableUnderLineName);

        GenerateConfig config = new GenerateConfig();
        config.setTableName(tableName);
        config.setTableUnderLineName(tableUnderLineName);
        config.setTableUnderLineNameUpperCase(StringFormatUtils.upperCaseByFirst(tableUnderLineName));

        config.setDoPackagePrefixPath(DO_PACKAGE_PREFIX);
        config.setDtoPackagePrefixPath(DTO_PACKAGE_PREFIX);
        config.setSaveParamPackagePrefixPath(DTO_PACKAGE_PREFIX);
        config.setQueryParamPackagePrefixPath(DTO_PACKAGE_PREFIX);
        config.setQueryConditionPackagePrefixPath(DO_PACKAGE_PREFIX);

        config.setDaoPackagePrefixPath(DAO_PACKAGE_PREFIX);
        config.setDaoImplPackagePrefixPath(DAO_IMPL_PACKAGE_PREFIX);

        config.setServicePackagePrefixPath(SERVICE_PACKAGE_PREFIX);
        config.setServiceImplPackagePrefixPath(SERVICE_IMPL_PACKAGE_PREFIX);

        config.setDoName(tableUnderLinNameUpperCase + "DO");
        config.setDtoName(tableUnderLinNameUpperCase + "DTO");
        config.setSaveParamName(tableUnderLinNameUpperCase + "SaveParam");
        config.setQueryParamName(tableUnderLinNameUpperCase + "QueryParam");
        config.setQueryConditionName(tableUnderLinNameUpperCase + "QueryCondition");

        config.setDaoName(tableUnderLinNameUpperCase + "Dao");
        config.setDaoImplName(tableUnderLinNameUpperCase + "DaoImpl");

        config.setServiceName(tableUnderLinNameUpperCase + "Service");

        config.setServiceImplName(tableUnderLinNameUpperCase + "ServiceImpl");


        config.setDoPackagePath(format(DO_PACKAGE_PREFIX, tableUnderLinNameUpperCase) + "DO");
        config.setDtoPackagePath(format(DTO_PACKAGE_PREFIX, tableUnderLinNameUpperCase) + "DTO");
        config.setSaveParamPackagePath(format(DTO_PACKAGE_PREFIX, tableUnderLinNameUpperCase) + "SaveParam");
        config.setQueryParamPackagePath(format(DTO_PACKAGE_PREFIX, tableUnderLinNameUpperCase) + "QueryParam");
        config.setQueryConditionPackagePath(format(DO_PACKAGE_PREFIX, tableUnderLinNameUpperCase) + "QueryCondition");


        config.setDaoPackagePath(format(DAO_PACKAGE_PREFIX, tableUnderLinNameUpperCase) + "Dao");
        config.setDaoImplPackagePath(format(DAO_IMPL_PACKAGE_PREFIX, tableUnderLinNameUpperCase) + "DaoImpl");

        config.setServicePackagePath(format(SERVICE_PACKAGE_PREFIX, tableUnderLinNameUpperCase) + "Service");
        config.setServiceImplPackagePath(format(SERVICE_IMPL_PACKAGE_PREFIX, tableUnderLinNameUpperCase) + "ServiceImpl");


        config.setDaoMapperName(tableUnderLinNameUpperCase + "Mapper");
        return config;
    }


    public static void main(String[] args) throws Exception {
        GenerateConfig config = generateConfig("user_info");
        JSONObject json = (JSONObject) JSONObject.toJSON(config);
        Set<Map.Entry<String, Object>> entries = json.entrySet();
        Map<String, Object> map = new HashMap<>();
        entries.forEach(entry -> map.put(entry.getKey(), entry.getValue()));
        System.out.println(map);


    }
}
