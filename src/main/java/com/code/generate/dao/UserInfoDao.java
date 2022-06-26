//package com.code.generate.dao;
//
//import com.code.generate.beans.po.UserInfoDO;
//import com.code.generate.beans.dto.UserInfoQueryParam;
//
//import java.util.List;
//
///**
// * @author : zms
// * @create : 2022/6/19
// * @desc : 用户信息 Dao
// */
//public interface UserInfoDao {
//
//
//    /**
//     * 新增 用户信息
//     * @param userInfoDO
//     * @return
//     */
//    int                 insert(UserInfoDO userInfoDO);
//
//    /**
//     * 编辑 用户信息
//     * @param userInfoDO
//     * @return
//     */
//    int                 updateByPrimaryKey(UserInfoDO userInfoDO);
//
//    /**
//     * count 用户信息
//     * @param param
//     * @return
//     */
//    int                 count(UserInfoQueryParam param);
//
//    /**
//     * 条件查询 用户信息
//     * @param param
//     * @return
//     */
//    List<UserInfoDO>     queryByParam(UserInfoQueryParam param);
//
//
//    /**
//     * 条件查询 用户信息
//     * @param param
//     * @return
//     */
//    UserInfoDO           queryExactlyOneByParam(UserInfoQueryParam param);
//
//
//
//
//}
