package com.code.generate.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.code.generate.template.MockTestParam;
import org.apache.commons.lang.StringUtils;

import com.code.generate.dataSource.TableDescribe;
import com.code.generate.dataSource.TableDescribeConstants;
import com.code.generate.template.TypeConvert;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.SneakyThrows;

/**
 * @author : zms
 * @create : 2022/6/12
 * @desc : 模版生成工具类
 */
@SuppressWarnings("DuplicatedCode")
public abstract class TemplateGenerateUtils {

    private final static Configuration configuration                    = new Configuration();

    /**
     * do 模版
     */
    private final static String        DO_TEMPLATE_NAME                 = "do.FTL";

    /**
     * dto 模版
     */
    private final static String        DTO_TEMPLATE_NAME                = "dto.FTL";

    /**
     * saveParam 模版
     */
    private final static String        SAVE_PARAM_TEMPLATE_NAME         = "saveParam.FTL";

    /**
     * queryParam 模版
     */
    private final static String        QUERY_PARAM_TEMPLATE_NAME        = "queryParam.FTL";

    /**
     * queryCondition 模版
     */
    private final static String        QUERY_CONDITION_TEMPLATE_NAME    = "queryCondition.FTL";

    /**
     * mapper 模版
     */
    private final static String        MAPPER_TEMPLATE_NAME             = "mapper.FTL";

    /**
     * dao 模版
     */
    private final static String        DAO_TEMPLATE_NAME                = "dao.FTL";

    /**
     * daoImpl 模版
     */
    private final static String        DAO_IMPL_TEMPLATE_NAME           = "daoImpl.FTL";

    /**
     * service 模版
     */
    private final static String        SERVICE_TEMPLATE_NAME            = "service.FTL";

    /**
     * serviceImpl 模版
     */
    private final static String        SERVICE_IMPL_TEMPLATE_NAME       = "serviceImpl.FTL";

    /**
     * facedManager 模版
     */
    private final static String        FACED_MANAGER_TEMPLATE_NAME      = "facedManager.FTL";

    /**
     * facedManagerImpl 模版
     */
    private final static String        FACED_MANAGER_IMPL_TEMPLATE_NAME = "facedManagerImpl.FTL";

    /**
     * facedManagerTest 模版
     */
    private final static String        FACED_MANAGER_TEST_TEMPLATE_NAME = "facedManagerTest.FTL";

    static {
        //这里比较重要，用来指定加载模板所在的路径
        configuration.setTemplateLoader(new ClassTemplateLoader(TemplateGenerateUtils.class, "/templates"));
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.toString());
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    public static Template getTemplate(String templateName) throws IOException {
        return configuration.getTemplate(templateName);
    }





    @SneakyThrows
    public static void generateFileByTemplate(String templateName, Map<String, Object> parameters) {
        Template template = getTemplate(templateName);
        String outPath = (String) parameters.get(templateName);

        File file = createOrGetOutFile(outPath);

        FileOutputStream fos = new FileOutputStream(file);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8), 1024);
        template.process(parameters, out);
    }


    /**
     * @author zms@didiglobal.com
     * @desc 生成全部模版
     * @date 2022/6/23
     */
    public static void  generateAll(String tableName,String desc){
        generateDOByTemplate(tableName,desc);
        generateDTOByTemplate(tableName,desc);
        generateQueryConditionByTemplate(tableName,desc);
        generateQueryParamByTemplate(tableName,desc);
        generateSaveParamByTemplate(tableName,desc);

        generateDaoByTemplate(tableName,desc);
        generateDaoImplByTemplate(tableName,desc);
        generateMapperByTemplate(tableName,desc);

        generateServiceByTemplate(tableName,desc);
        generateServiceImplByTemplate(tableName,desc);

        generateFacedManagerByTemplate(tableName,desc);
        generateFacedManagerImplByTemplate(tableName,desc);

        generateFacedManagerTestByTemplate(tableName,desc);

    }
    /**
     * @author zms@didiglobal.com
     * @desc 生成 DO
     * @date 2022/6/22
     */
    public static void generateDOByTemplate(String tableName, String desc) {
        Map<String, Object> parameters = TemplateGenerateUtils.generateParameters(tableName, desc);
        generateFileByTemplate(DO_TEMPLATE_NAME, parameters);
    }

    /**
     * @author zms@didiglobal.com
     * @desc 生成 DTO
     * @date 2022/6/22
     */
    public static void generateDTOByTemplate(String tableName, String desc) {
        Map<String, Object> parameters = TemplateGenerateUtils.generateParameters(tableName, desc);
        generateFileByTemplate(DTO_TEMPLATE_NAME, parameters);
    }

    /**
     * @author zms@didiglobal.com
     * @desc 生成 SaveParam
     * @date 2022/6/22
     */
    public static void generateSaveParamByTemplate(String tableName, String desc) {
        Map<String, Object> parameters = TemplateGenerateUtils.generateParameters(tableName, desc);
        generateFileByTemplate(SAVE_PARAM_TEMPLATE_NAME, parameters);
    }

    /**
     * @author zms@didiglobal.com
     * @desc 生成 QueryParam
     * @date 2022/6/22
     */
    public static void generateQueryParamByTemplate(String tableName, String desc) {
        Map<String, Object> parameters = TemplateGenerateUtils.generateParameters(tableName, desc);
        generateFileByTemplate(QUERY_PARAM_TEMPLATE_NAME, parameters);
    }

    /**
     * @author zms@didiglobal.com
     * @desc 生成 QueryCondition
     * @date 2022/6/22
     */
    public static void generateQueryConditionByTemplate(String tableName, String desc) {
        Map<String, Object> parameters = TemplateGenerateUtils.generateParameters(tableName, desc);
        generateFileByTemplate(QUERY_CONDITION_TEMPLATE_NAME, parameters);
    }

    /**
     * @author zms@didiglobal.com
     * @desc 生成 mapper
     * @date 2022/6/22
     */
    public static void generateMapperByTemplate(String tableName, String desc) {
        Map<String, Object> parameters = TemplateGenerateUtils.generateParameters(tableName, desc);
        generateFileByTemplate(MAPPER_TEMPLATE_NAME, parameters);
    }

    /**
     * @author zms@didiglobal.com
     * @desc 生成 dao
     * @date 2022/6/22
     */
    public static void generateDaoByTemplate(String tableName, String desc) {
        Map<String, Object> parameters = TemplateGenerateUtils.generateParameters(tableName, desc);
        generateFileByTemplate(DAO_TEMPLATE_NAME, parameters);
    }

    /**
     * @author zms@didiglobal.com
     * @desc 生成 daoImpl
     * @date 2022/6/22
     */
    public static void generateDaoImplByTemplate(String tableName, String desc) {
        Map<String, Object> parameters = TemplateGenerateUtils.generateParameters(tableName, desc);
        generateFileByTemplate(DAO_IMPL_TEMPLATE_NAME, parameters);
    }

    /**
     * @author zms@didiglobal.com
     * @desc 生成 service
     * @date 2022/6/22
     */
    public static void generateServiceByTemplate(String tableName, String desc) {
        Map<String, Object> parameters = TemplateGenerateUtils.generateParameters(tableName, desc);
        generateFileByTemplate(SERVICE_TEMPLATE_NAME, parameters);
    }

    /**
     * @author zms@didiglobal.com
     * @desc 生成 serviceImpl
     * @date 2022/6/22
     */
    public static void generateServiceImplByTemplate(String tableName, String desc) {
        Map<String, Object> parameters = TemplateGenerateUtils.generateParameters(tableName, desc);
        generateFileByTemplate(SERVICE_IMPL_TEMPLATE_NAME, parameters);
    }

    /**
     * @author zms@didiglobal.com
     * @desc 生成 facedManager
     * @date 2022/6/22
     */
    public static void generateFacedManagerByTemplate(String tableName, String desc) {
        Map<String, Object> parameters = TemplateGenerateUtils.generateParameters(tableName, desc);
        generateFileByTemplate(FACED_MANAGER_TEMPLATE_NAME, parameters);
    }

    /**
     * @author zms@didiglobal.com
     * @desc 生成 facedManagerImpl
     * @date 2022/6/22
     */
    public static void generateFacedManagerImplByTemplate(String tableName, String desc) {
        Map<String, Object> parameters = TemplateGenerateUtils.generateParameters(tableName, desc);
        generateFileByTemplate(FACED_MANAGER_IMPL_TEMPLATE_NAME, parameters);
    }

    /**
     * @author zms@didiglobal.com
     * @desc 生成 facedManagerTest
     * @date 2022/6/22
     */
    public static void generateFacedManagerTestByTemplate(String tableName, String desc) {
        Map<String, Object> parameters = TemplateGenerateUtils.generateParameters(tableName, desc);
        parameters.put("mockTestParam",new MockTestParam());
        generateFileByTemplate(FACED_MANAGER_TEST_TEMPLATE_NAME, parameters);
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 填充模版参数 通过表名称
     */
    private static Map<String, Object> fillParametersFromJdbcByTableName(String tableName) {
        if (StringUtils.isBlank(tableName)) {
            return Collections.emptyMap();
        }

        List<TableDescribe> tableDescribes = DataSourceUtils.fillTableDescribe(tableName);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put(TableDescribeConstants.TABLE_DESCRIBES, tableDescribes);
        parameters.put("typeConvert", new TypeConvert());
        return parameters;
    }

    @SneakyThrows
    private static File createOrGetOutFile(String outPath) {
        File file = new File(outPath);
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
            if (newFile) {
                return file;
            }
        }
        return file;
    }

    /**
     * @author zms@didiglobal.com
     * @desc 生成模版参数
     * @date 2022/6/22
     */
    public static Map<String, Object> generateParameters(String tableName, String desc) {
        // 模版配置 参数
        Map<String, Object> templateGenerateConfigParameters = GenerateConfigUtils.templateGenerateConfigMap(tableName,
            desc);
        // jdbc 参数
        Map<String, Object> jdbcParameters = fillParametersFromJdbcByTableName(tableName);
        templateGenerateConfigParameters.putAll(jdbcParameters);
        return templateGenerateConfigParameters;
    }
}
