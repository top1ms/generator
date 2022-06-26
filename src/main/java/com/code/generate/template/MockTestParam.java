package com.code.generate.template;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author zms@didiglobal.com
 * @desc 生成 test param
 * @date 2022/6/23 
 */
public class MockTestParam implements TemplateMethodModelEx {

    @SneakyThrows
    @Override
    public Object exec(List list) throws TemplateModelException {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        SimpleScalar simpleScalar = (SimpleScalar) list.get(0);
        String clzType = TypeConvert.typeMapping.get(simpleScalar.getAsString());
        switch (clzType) {
            case "Integer":
            case "Long":
                return new Random().nextInt(10) + 1;
            case "String":
                return "test test";
        }
        return null;
    }
}
