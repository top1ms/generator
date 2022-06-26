package com.code.generate.config;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;
import org.springframework.core.io.ClassPathResource;

import lombok.Data;

/**
 * @author zms@didiglobal.com
 * @desc 模版生成配置
 * @date 2022/6/22
 */
@Data
public class TemplateGenerateConfig {

    /**
     * 配置前缀
     */
    private static final String           TEMPLATE_GENERATE_CONFIG_PREFIX = "template";
    /**
     * 配置名称
     */
    private static final String           CONFIG_NAME                     = "application.yaml";

    private static TemplateGenerateConfig templateGenerateConfig;

    public static TemplateGenerateConfig getTemplateGenerateConfig() {
        return templateGenerateConfig;
    }

    private TemplateGenerateConfig() {
    }

    /**
     * jdbc 数据表名称
     */
    private String                  tableName;

    /**
     * 表信息描述
     */
    private String                  desc;

    /**
     * 模版配置 map
     */
    private Map<String, PathConfig> templateConfigMap;

    /**
     * 不用 Spring Context 了 静态使用外部配置属性绑定功能
     */
    static {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(new ClassPathResource(CONFIG_NAME));
        Properties properties = factoryBean.getObject();

        ConfigurationPropertySource propertySource = new MapConfigurationPropertySource(properties);

        Binder binder = new Binder(propertySource);

        templateGenerateConfig = binder.bind(TEMPLATE_GENERATE_CONFIG_PREFIX, TemplateGenerateConfig.class).get();
    }

}
