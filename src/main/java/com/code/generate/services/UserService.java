package com.code.generate.services;

import com.code.generate.beans.dto.UserInfoDTO;
import com.code.generate.beans.dto.UserInfoQueryParam;
import com.code.generate.beans.dto.UserInfoSaveParam;

import java.util.List;

/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : ${desc} Service
 */
public interface UserService {

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 新增 ${desc}
     */
    boolean            insert(UserInfoSaveParam saveParam);

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 编辑 ${desc}
     */
    boolean            edit(UserInfoSaveParam saveParam);

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 根据条件查询具体的${desc}
     */
    UserInfoDTO        queryExactlyOneByCondition(UserInfoQueryParam queryParam);

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 条件查询${desc}列表
     */
    List<UserInfoDTO>  queryByCondition(UserInfoQueryParam queryParam);
}
