package com.code.generate.beans.dto;


import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : zms
 * @create : 2022/6/12
 * @desc : 用户信息 DTO
 */
@Data
public class UserInfoDTO implements Serializable {



        /**
         * 主键 id 。
         */
        private  Long  id;
        /**
         * 用户 id 。
         */
        private  Long  userId;
        /**
         * 用户名称 。
         */
        private  String  name;
        /**
         * 状态 。

         */
        private  Integer  status;
        /**
         * 创建时间 。
         */
        private  Date  gmtCreate;
        /**
         * 修改时间 。
         */
        private  Date  gmtModify;


}