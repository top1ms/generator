package com.code.generate.utils;

import java.util.HashMap;
import java.util.Map;

import com.code.generate.config.PathConfig;
import com.code.generate.config.TemplateGenerateConfig;

/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : 配置参数生成 工具类
 */
public abstract class GenerateConfigUtils {

    /**
     * tableName map key
     */
    private final static String TABLE_NAME_KEY      = "tableName";

    /**
     * desc map key
     */
    private final static String DESC_KEY            = "desc";

    /**
     * 名称后缀
     */
    private final static String NAME_SUFFIX         = "name";

    /**
     * 包路径前缀
     */
    private final static String PACKAGE_PREFIX_PATH = "packagePrefixPath";

    /**
     * 包路径
     */
    private final static String PACKAGE_PATH        = "packagePath";

    /**
     * 点
     */
    private final static String DOT                 = ".";

    /**
     * 模版后缀
     */
    private final static String FTL_SUFFIX          = ".FTL";

    /**
     * @param tableName jdbc表名
     * @param desc      描述
     * @author zms@didiglobal.com
     * @desc 模版配置文件 生成模版参数
     * @date 2022/6/22
     */
    public static Map<String, Object> templateGenerateConfigMap(String tableName, String desc) {
        TemplateGenerateConfig templateGenerateConfig = TemplateGenerateConfig.getTemplateGenerateConfig();
        // 驼峰 userInfo
        String tableUnderLineName = StringFormatUtils.replaceUnderLine(tableName);
        // 首字母大写驼峰 UserInfo
        String tableUnderLinNameUpperCase = StringFormatUtils.upperCaseByFirst(tableUnderLineName);

        // file类型与路径映射 map
        Map<String, PathConfig> templatePathConfigMap = templateGenerateConfig.getTemplateConfigMap();

        Map<String, Object> templateGenerateConfigMap = new HashMap<>();

        templateGenerateConfigMap.put(TABLE_NAME_KEY, tableName);
        templateGenerateConfigMap.put(DESC_KEY, desc);

        templatePathConfigMap.forEach((key, pathConfig) -> {
            // 文件后缀
            String fileSuffix = pathConfig.getFileSuffix();

            String nameKey = key + StringFormatUtils.upperCaseByFirst(NAME_SUFFIX);
            String nameValue = tableUnderLinNameUpperCase + pathConfig.getClassNameSuffix();

            String packagePrefixPathKey = key + StringFormatUtils.upperCaseByFirst(PACKAGE_PREFIX_PATH);
            String packagePrefixPathValue = pathConfig.getPackagePrefixPath();

            String packagePathKey = key + StringFormatUtils.upperCaseByFirst(PACKAGE_PATH);
            String packagePathValue = pathConfig.getPackagePrefixPath() + DOT + nameValue;

            String outputPathKey = key + FTL_SUFFIX;
            String outputPathValue = pathConfig.getDiskPrefixPath() + nameValue + fileSuffix;

            templateGenerateConfigMap.put(nameKey, nameValue);
            templateGenerateConfigMap.put(packagePrefixPathKey, packagePrefixPathValue);
            templateGenerateConfigMap.put(packagePathKey, packagePathValue);
            templateGenerateConfigMap.put(outputPathKey, outputPathValue);

        });

        return templateGenerateConfigMap;
    }

}
