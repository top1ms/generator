package com.code.generate.utils;

import com.code.generate.dataSource.TableDescribe;
import com.code.generate.dataSource.TableDescribeConstants;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : zms
 * @create : 2022/6/12
 * @desc : 模版生成工具类
 */
public abstract class TemplateGenerateUtils {

    private final static Configuration configuration = new Configuration();

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
    private static void generateFileByTemplate(String templateName, File file, Map<String, Object> parameters) {
        Template template = getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8), 1024);
        template.process(parameters, out);
    }

    public static void main(String[] args) throws IOException {
        List<TableDescribe> tableDescribes = DataSourceUtils.fillTableDescribe("user_info");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(TableDescribeConstants.TABLE_DESCRIBES, tableDescribes);
        parameters.put("packagePrefix", "com.code.generate.beans");
        parameters.put("desc", "用户信息表 DTO");
        parameters.put("tableName", "UserInfo");
        File file = new File("/Users/top1ms/generator/UserInfoDTO.java");
        if (!file.exists()) {
            file.createNewFile();
        }

        generateFileByTemplate("dto.FTL", file, parameters);


    }
}
