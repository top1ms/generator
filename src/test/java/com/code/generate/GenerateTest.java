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
}
