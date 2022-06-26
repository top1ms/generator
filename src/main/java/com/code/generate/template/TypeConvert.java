package com.code.generate.template;

import java.util.*;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

/**
 * @author : zms
 * @create : 2022/6/18
 * @desc : 类型转换函数
 */
public class TypeConvert implements TemplateMethodModelEx {

    public final static Map<String, String> typeMapping = new HashMap<>();

    public final static Set<String>         integerSet  = new HashSet<>();

    public final static Set<String>         longSet     = new HashSet<>();

    public final static Set<String>         strSet      = new HashSet<>();

    public final static Set<String>         dateSet     = new HashSet<>();

    private final static String             DEFAULT     = "String";

    static {
        typeMapping.put("VARCHAR", "String");
        typeMapping.put("TEXT", "String");
        typeMapping.put("JSON", "String");

        typeMapping.put("TIMESTAMP", "Date");

        typeMapping.put("TINYINT", "Integer");
        typeMapping.put("INTEGER", "Integer");
        typeMapping.put("INT", "Integer");

        typeMapping.put("BIGINT", "Long");
        typeMapping.put("BIGINT UNSIGNED", "Long");

        strSet.add("VARCHAR");
        strSet.add("TEXT");
        strSet.add("JSON");

        dateSet.add("TIMESTAMP");

        integerSet.add("TINYINT");
        integerSet.add("INT");
        integerSet.add("INTEGER");

        longSet.add("BIGINT");
        longSet.add("BIGINT UNSIGNED");




    }

    /**
     * @author : zms
     * @create : 2022/6/18
     * @desc : 根据 jdbcType 获取 javaType
     */
    private String getJavaTypeByJdbcType(String jdbcType) {
        if (StringUtils.isBlank(jdbcType)) {
            return DEFAULT;
        }
        String upperJdbcType = jdbcType.trim().toUpperCase();
        String result = typeMapping.get(upperJdbcType);
        if (StringUtils.isBlank(result)) {
            return DEFAULT;
        }
        return result;
    }

    @Override
    public String exec(List list) throws TemplateModelException {
        if (CollectionUtils.isEmpty(list)) {
            return DEFAULT;
        }
        SimpleScalar simpleScalar = (SimpleScalar) list.get(0);
        return getJavaTypeByJdbcType(simpleScalar.getAsString());
    }
}
