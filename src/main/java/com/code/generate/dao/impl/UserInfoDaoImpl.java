package com.code.generate.dao.impl;


import com.code.generate.beans.po.UserInfoDO;
import com.code.generate.beans.po.UserInfoQueryCondition;
import com.code.generate.dao.UserInfoDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : DaoImpl
 */
@Service
public class UserInfoDaoImpl implements UserInfoDao {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 新增 用户信息
     *
     * @param userInfoDO
     * @return
     */
    @Override
    public int insert(UserInfoDO userInfoDO) {
        if (Objects.isNull(userInfoDO)) {
            return 0;
        }
        return sqlSessionTemplate.insert("UserInfoMapper.insert", userInfoDO);
    }

    /**
     * 编辑 人员信息
     *
     * @param userInfoDO
     * @return
     */
    @Override
    public int updateByPrimaryKey(UserInfoDO userInfoDO) {
        if (Objects.isNull(userInfoDO) || Objects.isNull(userInfoDO.getId())) {
            return 0;
        }
        return sqlSessionTemplate.update("UserInfoMapper.updateByPrimaryKey", userInfoDO);
    }

    /**
     * 条件查询 人员信息
     *
     * @param condition
     * @return
     */
    @Override
    public List<UserInfoDO> queryByCondition(UserInfoQueryCondition condition) {
        if (Objects.isNull(condition)) {
            return Collections.emptyList();
        }
        return sqlSessionTemplate.selectList("UserInfoMapperTemplate.queryByCondition", condition);
    }
}
