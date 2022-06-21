package com.code.generate.services;

import com.alibaba.fastjson.JSONObject;
import com.code.generate.beans.dto.UserInfoDTO;
import com.code.generate.beans.dto.UserInfoQueryParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServicesTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void testQuery(){
        UserInfoQueryParam param = new UserInfoQueryParam();
        param.setId(1L);
        UserInfoDTO userInfoDTO = userInfoService.queryExactlyOneByCondition(param);
        System.out.println(userInfoDTO);

        List<UserInfoDTO> result = userInfoService.queryByCondition(param);

        System.out.println(JSONObject.toJSON(result));
    }
}
