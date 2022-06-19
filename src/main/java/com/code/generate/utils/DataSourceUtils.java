package com.code.generate.utils;

import com.alibaba.fastjson.JSONObject;
import com.code.generate.dataSource.TableDescribe;
import com.code.generate.dataSource.TableDescribeConstants;
import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : zms
 * @create : 2022/6/12
 * @desc : 获取数据库连接
 */
public abstract class DataSourceUtils {


    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";


    private final static String URL = "jdbc:mysql://localhost:3306/warehouse";

    private final static String USER = "root";

    private final static String PASSWORD = "123456";

//    public final static Connection connection = null;


    /**
     * @author : zms
     * @create : 2022/6/12
     * @desc : 获取数据库链接
     */
    public static Connection getDataSourceConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("obtain dataSource error");
    }


    /**
     * @author : zms
     * @create : 2022/6/12
     * @desc : 获取数据库元信息
     */
    public static DatabaseMetaData getDatabaseMetaData() {
        try {
            Connection connection = getDataSourceConnection();
            return connection.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("obtain databaseMetaData error");
    }

    /**
     * @author : zms
     * @create : 2022/6/12
     * @desc : 根据 表名集合获取 resultSet 信息
     */
    public static List<ResultSet> getResultSetByTableNameList(List<String> tableNameList) {
        if (CollectionUtils.isEmpty(tableNameList)) {
            return Collections.emptyList();
        }
        return tableNameList
                    .stream()
                    .map(DataSourceUtils::getResultSetByTableName)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
    }


    /**
     * @author : zms
     * @create : 2022/6/12
     * @desc : 根据 表名 获取 resultSet
     */
    public static ResultSet getResultSetByTableName(String tableName) {
        try {
            DatabaseMetaData databaseMetaData = getDatabaseMetaData();
            return databaseMetaData.getColumns(null, "%", tableName, "%");
        } catch (SQLException e) {
            System.out.println("obtain resultSet by tableName error,reason:" + JSONObject.toJSON(e));
            e.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public static List<TableDescribe> fillTableDescribe(String tableName) {
        ResultSet resultSet = getResultSetByTableName(tableName);
        if (Objects.isNull(resultSet)) {
            return Collections.emptyList();
        }
        List<TableDescribe> tableDescribes = new ArrayList<>();
        while (resultSet.next()) {

            String originColumnName = resultSet.getString(TableDescribeConstants.COLUMN_NAME);
            String underLineColumnName = StringFormatUtils.replaceUnderLine(originColumnName);
            String type = resultSet.getString(TableDescribeConstants.TYPE);
            String remakes = resultSet.getString(TableDescribeConstants.REMARKS);

            TableDescribe tableDescribe = new TableDescribe();

            tableDescribe.setOriginColumnName(originColumnName);
            tableDescribe.setUnderLineColumnName(underLineColumnName);
            tableDescribe.setType(type);
            tableDescribe.setRemakes(remakes);
            tableDescribe.setPrimaryKey("id".equals(underLineColumnName));

            tableDescribes.add(tableDescribe);
        }
        return tableDescribes;
    }


    public static void main(String[] args) throws SQLException {
        List<TableDescribe> tableDescribes = fillTableDescribe("user_info");
        System.out.println(JSONObject.toJSON(tableDescribes));

        System.out.println(StringFormatUtils.replaceUnderLine("id"));

    }
}
