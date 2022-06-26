package ${facedManagerTestPackagePrefixPath};


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import ${pageQueryResultPackagePrefixPath}.PageQueryResult;
import ${dtoPackagePath};
import ${saveParamPackagePath};
import ${queryConditionPackagePath};


/**
 * @author zms@didiglobal.com
 * @desc ${desc} 单元测试
 * @date 2022/6/23
 */
@SpringBootTest
class ${facedManagerTestName} {


    @Autowired
    private ${facedManagerName} ${facedManagerName?uncap_first};


    /**
     * 走一遍
     */
    @Test
    void test(){
       System.out.println("***新增测试开始**");
       insert();
       System.out.println("***新增测试结束**");

       System.out.println("***编辑测试开始**");
       edit();
       System.out.println("***编辑测试开始**");

       System.out.println("***分页查询开始**");
       pageQueryByCondition();
       System.out.println("***分页查询结束**");


       System.out.println("***查询列表开始**");
       nonPageQueryByCondition();
       System.out.println("***查询列表结束**");

       System.out.println("***查询开始**");
       queryById();
       System.out.println("***查询结束**");

       System.out.println("***删除开始**");
       deleteById();
       System.out.println("***删除结束**");
    }

     /**
       * ${desc} 主键查询 test
       */
    @Test
    void queryById() {
        ${dtoName} ${dtoName?uncap_first} = ${facedManagerName?uncap_first}.queryById(1L);
        System.out.println(${dtoName?uncap_first});
    }

    /**
      * ${desc} 新增 test
      */
    @Test
    void insert() {
        ${saveParamName} param = new ${saveParamName}();
        <#if tableDescribes?exists>
        <#list tableDescribes as tableDescribe>
        <#if tableDescribe.needString == true && tableDescribe.primaryKey == false >
        param.set${tableDescribe.underLineColumnName?cap_first}(<#noparse>"</#noparse>${mockTestParam(tableDescribe.type)}<#noparse>"</#noparse>);
        </#if>
        <#if tableDescribe.needInteger == true && tableDescribe.primaryKey = false >
        param.set${tableDescribe.underLineColumnName?cap_first}(${mockTestParam(tableDescribe.type)});
        </#if>
        <#if tableDescribe.needLong == true && tableDescribe.primaryKey == false >
        param.set${tableDescribe.underLineColumnName?cap_first}(${mockTestParam(tableDescribe.type)}L);
        </#if>
        <#if tableDescribe.needDate == true && tableDescribe.primaryKey == false >
        param.set${tableDescribe.underLineColumnName?cap_first}(new Date());
        </#if>
        </#list>
        </#if>
        ${facedManagerName?uncap_first}.insert(param);
    }

    /**
      * ${desc} 编辑 test
      */
    @Test
    void edit() {
        ${saveParamName} param = new ${saveParamName}();
        <#if tableDescribes?exists>
        <#list tableDescribes as tableDescribe>
        <#if tableDescribe.needString == true >
        param.set${tableDescribe.underLineColumnName?cap_first}(<#noparse>"</#noparse>${mockTestParam(tableDescribe.type)}<#noparse>"</#noparse>);
        </#if>
        <#if tableDescribe.needInteger == true >
        param.set${tableDescribe.underLineColumnName?cap_first}(8);
        </#if>
        <#if tableDescribe.needLong == true >
        param.set${tableDescribe.underLineColumnName?cap_first}(12L);
        </#if>
        <#if tableDescribe.needDate == true >
        param.set${tableDescribe.underLineColumnName?cap_first}(new Date());
        </#if>
        </#list>
        </#if>

        ${facedManagerName?uncap_first}.edit(param);
    }

   /**
     * ${desc} 条件查询 分页  test
     */
    @Test
    void pageQueryByCondition() {
        ${queryConditionName} condition = new ${queryConditionName}();
        condition.setPageNo(1);
        condition.setPageSize(1);
        PageQueryResult<${dtoName}> pageQueryResult = ${facedManagerName?uncap_first}.pageQueryByCondition(condition);
        System.out.println(JSONObject.toJSONString(pageQueryResult));
    }

    /**
     * ${desc} 条件查询 test
     */
    @Test
    void nonPageQueryByCondition() {
        ${queryConditionName} condition = new ${queryConditionName}();
        List<${dtoName}> result = ${facedManagerName?uncap_first}.nonPageQueryByCondition(condition);
        System.out.println(JSONObject.toJSONString(result));
    }

    /**
     * ${desc} 删除 test
     */
    @Test
    void deleteById() {
        boolean result = ${facedManagerName?uncap_first}.delete(1L);
        System.out.println(result);
    }



}