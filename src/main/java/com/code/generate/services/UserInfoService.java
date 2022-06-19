package com.code.generate.services;

import com.code.generate.beans.dto.UserInfoDTO;
import com.code.generate.beans.dto.UserInfoQueryParam;
import com.code.generate.beans.dto.UserInfoSaveParam;

import java.util.List;

/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : 用户信息 Service
 */
public interface UserInfoService {

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 新增 用户信息
     */
    boolean             insert(UserInfoSaveParam userInfoSaveParam);

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 编辑 用户信息
     */
    boolean             edit(UserInfoSaveParam userInfoSaveParam);

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 根据条件查询具体的用户信息
     */
    UserInfoDTO         queryExactlyOneByCondition(UserInfoQueryParam userInfoQueryParam);

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 条件查询用户信息列表
     */
    List<UserInfoDTO>   queryByCondition(UserInfoQueryParam userInfoQueryParam);
}
