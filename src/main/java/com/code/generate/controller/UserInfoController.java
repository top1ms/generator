//package com.code.generate.controller;
//
//import com.code.generate.beans.po.UserInfoDO;
//import com.code.generate.dao.UserInfoDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("user")
//public class UserInfoController {
//
//
//    @Autowired
//    private UserInfoDao userInfoDao;
//
//
//    @RequestMapping("insert")
//    public String insert(){
//        UserInfoDO userInfo = new UserInfoDO();
//        userInfo.setUserId(1L);
//        userInfo.setName("zms");
//        userInfo.setStatus(1);
//        userInfoDao.insert(userInfo);
//        return "success";
//    }
//}
