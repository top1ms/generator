package com.code.generate;

import com.code.generate.utils.TemplateGenerateUtils;
import org.junit.jupiter.api.Test;


public class GenerateTest {


    @Test
    public void testGenerateMapperXML(){
        TemplateGenerateUtils.generateMapperXMLByTemplate("user_info");
    }

    @Test
    public void testGenerateDTO(){
        TemplateGenerateUtils.generateDTOByTemplate("user_info","用户信息");
    }

    @Test
    public void testGenerateDO(){
        TemplateGenerateUtils.generateDOByTemplate("user_info","用户信息");
    }

    @Test
    public void testGenerateDao() throws Exception {
        TemplateGenerateUtils.generateDAOByTemplate("user_info","用户信息");
    }

    @Test
    public void testGenerateDaoImpl() throws Exception {
        TemplateGenerateUtils.generateDaoImplByTemplate("user_info","用户信息");
    }

    @Test
    public void testGenerateService() throws Exception {
        TemplateGenerateUtils.generateServiceByTemplate("user_info","用户信息");
    }

    @Test
    public void testGenerateServiceImpl() throws Exception {
        TemplateGenerateUtils.generateServiceImplByTemplate("user_info","用户信息");
    }
    @Test
    public void testGenerateQueryCondition() throws Exception {
        TemplateGenerateUtils.generateQueryConditionByTemplates("user_info","用户信息");
    }
}
