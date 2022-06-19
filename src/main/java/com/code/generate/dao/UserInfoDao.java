package com.code.generate.dao;

import com.code.generate.beans.po.UserInfoDO;
import com.code.generate.beans.po.UserInfoQueryCondition;

import java.util.List;

/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : UserInfoDao
 */
public interface UserInfoDao {


    /**
     * 新增
     * @param userInfoDO
     * @return
     */
    int                 insert(UserInfoDO userInfoDO);

    /**
     * 更新
     * @param userInfoDO
     * @return
     */
    int                 updateByPrimaryKey(UserInfoDO userInfoDO);


    /**
     * 条件查询
     * @param userInfoQueryCondition
     * @return
     */
    List<UserInfoDO>    queryByCondition(UserInfoQueryCondition userInfoQueryCondition);


}
