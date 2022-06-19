package com.code.generate.services.impl;

import com.code.generate.beans.dto.UserInfoDTO;
import com.code.generate.beans.dto.UserInfoQueryParam;
import com.code.generate.beans.dto.UserInfoSaveParam;
import com.code.generate.beans.po.UserInfoDO;
import com.code.generate.beans.po.UserInfoQueryCondition;
import com.code.generate.dao.UserInfoDao;
import com.code.generate.services.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : 用户信息ServiceImpl
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public boolean insert(UserInfoSaveParam userInfoSaveParam) {
        if (Objects.isNull(userInfoSaveParam)) {
            return false;
        }
        UserInfoDO userInfoDO = transferDO(userInfoSaveParam);
        return userInfoDao.insert(userInfoDO) > 0;
    }

    @Override
    public boolean edit(UserInfoSaveParam userInfoSaveParam) {
        if (Objects.isNull(userInfoSaveParam) || Objects.isNull(userInfoSaveParam.getId())) {
            return false;
        }
        UserInfoDO userInfoDO = transferDO(userInfoSaveParam);
        return userInfoDao.updateByPrimaryKey(userInfoDO) > 0;
    }

    @Override
    public UserInfoDTO queryExactlyOneByCondition(UserInfoQueryParam userInfoQueryParam) {
        List<UserInfoDTO> result = queryByCondition(userInfoQueryParam);
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public List<UserInfoDTO> queryByCondition(UserInfoQueryParam userInfoQueryParam) {
        UserInfoQueryCondition userInfoQueryCondition = transferQueryCondition(userInfoQueryParam);
        List<UserInfoDO> result = userInfoDao.queryByCondition(userInfoQueryCondition);
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result.stream()
                     .map(this::transferDTO)
                     .collect(Collectors.toList());
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 转换为 DO
     */
    private UserInfoDO transferDO(UserInfoSaveParam userInfoSaveParam) {
        UserInfoDO userInfoDO = new UserInfoDO();
        BeanUtils.copyProperties(userInfoSaveParam, userInfoDO);
        return userInfoDO;
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 转换为 QueryCondition
     */
    private UserInfoQueryCondition transferQueryCondition(UserInfoQueryParam userInfoQueryParam) {
        UserInfoQueryCondition userInfoQueryCondition = new UserInfoQueryCondition();
        BeanUtils.copyProperties(userInfoQueryParam, userInfoQueryCondition);
        return userInfoQueryCondition;
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 转换为 DTO
     */
    private UserInfoDTO transferDTO(UserInfoDO userInfoDO) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        BeanUtils.copyProperties(userInfoDO, userInfoDTO);
        return userInfoDTO;
    }
}
