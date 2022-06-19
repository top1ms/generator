package com.code.generate.utils;

import com.alibaba.fastjson.JSONObject;
import com.code.generate.config.GenerateConfig;
import com.code.generate.dataSource.TableDescribe;
import com.code.generate.dataSource.TableDescribeConstants;
import com.code.generate.template.TypeConvert;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.SneakyThrows;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author : zms
 * @create : 2022/6/12
 * @desc : 模版生成工具类
 */
@SuppressWarnings("DuplicatedCode")
public abstract class TemplateGenerateUtils {

    private final static Configuration configuration = new Configuration();

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
    private final static String DAO_IMPL_OUT_PATH_PREFIX = "/Users/top1ms/IdeaProjects/generator/src/main/java/com/code/generate/dao/impl/";

    /**
     * service 输出路径前缀
     */
    private final static String SERVICE_OUT_PATH_PREFIX = "/Users/top1ms/IdeaProjects/generator/src/main/java/com/code/generate/services/";

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
     * java 类型后缀
     */
    private final static String JAVA_SUFFIX = ".java";

    /**
     * xml 路径后缀
     */
    private final static String MAPPER_XML_OUT_PATH_SUFFIX = ".xml";


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
    public static void generateFileByTemplate(String templateName, String outPath, Map<String, Object> parameters) {
        Template template = getTemplate(templateName);
        File file = createOrGetOutFile(outPath);

        FileOutputStream fos = new FileOutputStream(file);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8), 1024);
        template.process(parameters, out);
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 生成 mapper.xml
     */
    public static void generateMapperXMLByTemplate(String tableName) {

        Map<String, Object> parameters = fillParametersFromJdbcByTableName(tableName);

        String mapperXmlName = StringFormatUtils.replaceUnderLineAndUpperCase(tableName) + "MapperTemplate";
        String fileName = absolutePath(MAPPER_XML_OUT_PATH_PREFIX, mapperXmlName, MAPPER_XML_OUT_PATH_SUFFIX);

        String durationSourcePath = DO_PACKAGE_PREFIX + "." + StringFormatUtils.replaceUnderLineAndUpperCase(tableName) + "DO";

        String queryByConditionPath = DO_PACKAGE_PREFIX + "." + StringFormatUtils.replaceUnderLineAndUpperCase(tableName) + "QueryCondition";

        parameters.put("tableName", tableName);
        parameters.put("mapperXmlName", mapperXmlName);
        parameters.put("durationSourcePath", durationSourcePath);
        parameters.put("queryByConditionPath", queryByConditionPath);


        generateFileByTemplate("mapperXml.FTL", fileName, parameters);
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 生成 DAO
     */
    public static void generateDAOByTemplate(String tableName, String desc) throws Exception {

        Map<String, Object> parameters = fillParametersFromJdbcByTableName(tableName);

        GenerateConfig generateConfig = GenerateConfigUtils.generateConfig(tableName);

        fillParametersFromGenerateConfig(parameters, generateConfig);

        String fileName = absolutePath(DAO_OUT_PATH_PREFIX, generateConfig.getDaoName(), JAVA_SUFFIX);


        generateFileByTemplate("mapperDO.FTL", fileName, parameters);
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 生成 DaoImpl
     */
    public static void generateDaoImplByTemplate(String tableName, String desc) throws Exception {

        Map<String, Object> parameters = fillParametersFromJdbcByTableName(tableName);

        GenerateConfig generateConfig = GenerateConfigUtils.generateConfig(tableName);

        parameters.put("desc",desc);

        fillParametersFromGenerateConfig(parameters, generateConfig);

        String fileName = absolutePath(DAO_IMPL_OUT_PATH_PREFIX, generateConfig.getDaoImplName(), JAVA_SUFFIX);


        generateFileByTemplate("mapperDOImpl.FTL", fileName, parameters);
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 生成 Service
     */
    public static void generateServiceByTemplate(String tableName, String desc) throws Exception {

        Map<String, Object> parameters = fillParametersFromJdbcByTableName(tableName);

        GenerateConfig generateConfig = GenerateConfigUtils.generateConfig(tableName);

        parameters.put("desc",desc);

        fillParametersFromGenerateConfig(parameters, generateConfig);

        String fileName = absolutePath(SERVICE_OUT_PATH_PREFIX, generateConfig.getServiceName(), JAVA_SUFFIX);


        generateFileByTemplate("service.FTL", fileName, parameters);
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 生成 queryCondition
     */
    public static void generateQueryConditionByTemplates(String tableName, String desc) throws Exception {
        Map<String, Object> parameters = fillParametersFromJdbcByTableName(tableName);

        parameters.put("desc", desc);

        GenerateConfig generateConfig = GenerateConfigUtils.generateConfig(tableName);

        fillParametersFromGenerateConfig(parameters, generateConfig);

        String fileName = absolutePath(DO_OUT_PATH_PREFIX, generateConfig.getQueryConditionName(), JAVA_SUFFIX);


        generateFileByTemplate("queryCondition.FTL", fileName, parameters);
    }

    private static void fillParametersFromGenerateConfig(Map<String, Object> parameters, GenerateConfig config) {
        JSONObject json = (JSONObject) JSONObject.toJSON(config);
        Set<Map.Entry<String, Object>> entries = json.entrySet();
        entries.forEach(entry -> parameters.put(entry.getKey(), entry.getValue()));
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 生成  DO
     */
    public static void generateDOByTemplate(String tableName, String desc) {
        String javaName = StringFormatUtils.replaceUnderLineAndUpperCase(tableName) + "DO";

        String fileName = absolutePath(DO_OUT_PATH_PREFIX, javaName, JAVA_SUFFIX);

        Map<String, Object> parameters = buildParameters(tableName, desc, DO_PACKAGE_PREFIX, javaName);

        generateFileByTemplate("do.FTL", fileName, parameters);

    }


    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 生成 DTO
     */
    public static void generateDTOByTemplate(String tableName, String desc) {

        String javaName = StringFormatUtils.replaceUnderLineAndUpperCase(tableName) + "DTO";

        String fileName = absolutePath(DTO_OUT_PATH_PREFIX, javaName, JAVA_SUFFIX);

        Map<String, Object> parameters = buildParameters(tableName, desc, DTO_PACKAGE_PREFIX, javaName);


        generateFileByTemplate("dto.FTL", fileName, parameters);
    }


    private static Map<String, Object> buildParameters(String tableName, String desc,
                                                       String packagePrefix, String javaFileName) {
        Map<String, Object> parameters = fillParametersFromJdbcByTableName(tableName);
        parameters.put("desc", desc);
        parameters.put("packagePrefix", packagePrefix);
        parameters.put("javaFileName", javaFileName);
        parameters.put("typeConvert", new TypeConvert());
        return parameters;

    }

    private final static String ABSOLUTE_PATH_FORMAT = "%s%s%s";

    public static String absolutePath(String prefix, String fileName, String suffix) {
        return String.format(ABSOLUTE_PATH_FORMAT, prefix, fileName, suffix);
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

}
