package com.code.generate.utils;

public class PageUtils {
    public static int getStartRow(int pageNum, int pageSize) {
        return pageNum > 0 ? (pageNum - 1) * pageSize : 0;
    }
}
