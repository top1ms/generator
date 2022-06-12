package com.code.generate.utils;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @author : zms
 * @create : 2022/6/12
 * @desc : 字符串转换工具类
 */
public abstract class StringFormatUtils {


    /**
     * @author : zms
     * @create : 2022/6/12
     * @desc : 驼峰转换
     */
    public static String replaceUnderLineAndUpperCase(String str){
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while(count!=0){
            int num = sb.indexOf("_",count);
            count = num + 1;
            if(num != -1){
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count , count + 1,ia + "");
            }
        }
        String result = sb.toString().replaceAll("_","");
        return StringUtils.capitalize(result);
    }

}
