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
    public static String replaceUnderLine(String str){
        StringBuilder sb = new StringBuilder();
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
        return sb.toString().replaceAll("_","");
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 首位字母大写
     */
    public static String upperCaseByFirst(String str) {
        if (org.apache.commons.lang.StringUtils.isBlank(str)) {
            return str;
        }
        return StringUtils.capitalize(str);
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 转换驼峰 + 首字母大写
     */
    public static String replaceUnderLineAndUpperCase(String str) {
        return upperCaseByFirst(replaceUnderLine(str));
    }

    public static void main(String[] args) {
        System.out.println(upperCaseByFirst("name"));
    }

}
