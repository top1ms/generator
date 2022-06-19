package com.code.generate.template;

import com.alibaba.fastjson.JSONObject;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import javax.xml.transform.sax.TemplatesHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : zms
 * @create : 2022/6/18
 * @desc : 类型转换函数
 */
public class TypeConvert implements TemplateMethodModelEx {

    private final static Map<String, String> typeMapping = new HashMap<>();

    private final static String DEFAULT = "String";

    static {
        typeMapping.put("VARCHAR", "String");
        typeMapping.put("TEXT", "String");
        typeMapping.put("JSON", "String");

        typeMapping.put("TIMESTAMP", "Date");


        typeMapping.put("TINYINT", "Integer");
        typeMapping.put("INTEGER", "Integer");
        typeMapping.put("BIGINT", "Long");

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
