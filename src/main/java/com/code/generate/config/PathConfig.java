package com.code.generate.config;

import lombok.Data;

/**
 * @author zms@didiglobal.com
 * @desc 路径相关配置
 * @date 2022/6/22
 */
@Data
public class PathConfig {

    /**
     * 包路径前缀
     */
    private String          packagePrefixPath;

    /**
     * 类名
     */
    private String          classNameSuffix;

    /**
     * 本地输出路径前缀
     */
    private String          diskPrefixPath;

    /**
     * 文件后缀
     */
    private String          fileSuffix;
}
