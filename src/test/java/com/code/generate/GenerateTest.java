package com.code.generate;

import com.code.generate.utils.TemplateGenerateUtils;
import org.junit.jupiter.api.Test;


public class GenerateTest {


    @Test
    public void testGenerateMapperXML(){
        TemplateGenerateUtils.generateDaoByTemplate("user_info","用户信息");
    }
}
