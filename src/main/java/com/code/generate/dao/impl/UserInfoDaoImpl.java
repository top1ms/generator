//package com.code.generate.dao.impl;
//
//import com.code.generate.beans.po.UserInfoQueryCondition;
//import com.code.generate.dao.UserInfoDao;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Objects;
//
//
///**
// * @author : zms
// * @create : 2022/6/19
// * @desc : DaoImpl
// */
//@Service
//public class UserInfoDaoImpl implements UserInfoDao {
//
//    @Resource
//    private SqlSessionTemplate sqlSessionTemplate;
//
//    /**
//     * 新增 人员信息
//     *
//     * @param userInfo
//     * @return
//     */
//    @Override
//    public int insert(UserInfoDO userInfo) {
//        if (Objects.isNull(userInfo)) {
//            return 0;
//        }
//        return sqlSessionTemplate.insert("UserInfoMapper.insert", userInfo);
//    }
//
//    /**
//     * 编辑 人员信息
//     *
//     * @param userInfoDO
//     * @return
//     */
//    @Override
//    public int updateByPrimaryKey(UserInfoDO userInfoDO) {
//        return 0;
//    }
//
//    /**
//     * 根据主键查询 人员信息
//     *
//     * @param id
//     * @return
//     */
//    @Override
//    public UserInfoDO queryByPrimaryKey(Long id) {
//        return null;
//    }
//
//    /**
//     * 条件查询 人员信息
//     *
//     * @param condition
//     * @return
//     */
//    @Override
//    public List<UserInfoDO> queryByCondition(UserInfoQueryCondition condition) {
//        return null;
//    }
//}
