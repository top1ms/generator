<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${mapperName}">


     <resultMap id="BaseResultMap" type="${doPackagePath}">
      <#if tableDescribes?exists>
        <#list tableDescribes as tableDescribe>
            <#if tableDescribe.primaryKey == true>
            <id column="${tableDescribe.originColumnName}" jdbcType="${tableDescribe.type}" property="${tableDescribe.underLineColumnName}"/>
            <#else>
            <#if tableDescribe.needString == true>
            <result column="${tableDescribe.originColumnName}"   jdbcType="VARCHAR" property="${tableDescribe.underLineColumnName}"/>
            <#else>
            <result column="${tableDescribe.originColumnName}"   jdbcType="${tableDescribe.type}" property="${tableDescribe.underLineColumnName}"/>
            </#if>
            </#if>
        </#list>
      </#if>
     </resultMap>


     <sql id="Base_Column_List">
      <#if tableDescribes?exists>
          <#list tableDescribes as tableDescribe>
              ${tableDescribe.originColumnName}<#if tableDescribe_has_next>,</#if>
          </#list>
      </#if>
     </sql>


     <insert id="insert"
             parameterType="${doPackagePath}"
             useGeneratedKeys="true"
             keyProperty="id">
          INSERT INTO ${tableName}
            <trim prefix="(" suffix=")" suffixOverrides=",">
            <#if tableDescribes?exists>
              <#list tableDescribes as tableDescribe>
                <if test="${tableDescribe.underLineColumnName} != null">${tableDescribe.originColumnName}<#if tableDescribe_has_next>,</#if></if>
              </#list>
            </#if>
            </trim>
            <trim prefix="values (" suffix=")" suffixOverrides=",">
            <#if tableDescribes?exists>
              <#list tableDescribes as tableDescribe>
                <if test="${tableDescribe.underLineColumnName} != null"><#noparse>#{</#noparse>${tableDescribe.underLineColumnName}<#noparse>}</#noparse><#if tableDescribe_has_next>,</#if></if>
              </#list>
            </#if>
            </trim>
     </insert>


     <update id="updateByPrimaryKey" parameterType="${doPackagePath}">
         UPDATE ${tableName}
         <set>
             <#if tableDescribes?exists>
              <#list tableDescribes as tableDescribe>
                <if test="${tableDescribe.underLineColumnName} !=null">
                  ${tableDescribe.originColumnName} = <#noparse>#{</#noparse>${tableDescribe.underLineColumnName}<#noparse>}</#noparse><#if tableDescribe_has_next>,</#if>
                </if>
              </#list>
             </#if>
         </set>
         <#if tableDescribes?exists>
            <#list tableDescribes as tableDescribe>
              <#if tableDescribe.primaryKey == true>
         WHERE ${tableDescribe.underLineColumnName}  = <#noparse>#{</#noparse>${tableDescribe.underLineColumnName}<#noparse>}</#noparse>
              </#if>
            </#list>
         </#if>
     </update>

     <select id="queryByParam"
             parameterType="${queryParamPackagePath}"
             resultMap="BaseResultMap">
         select
         <include refid="Base_Column_List"/>
         from
         ${tableName}
         <where>
          <#if tableDescribes?exists>
           <#list tableDescribes as tableDescribe>
             <if test="${tableDescribe.underLineColumnName} !=null">
               and ${tableDescribe.originColumnName} = <#noparse>#{</#noparse>${tableDescribe.underLineColumnName}<#noparse>}</#noparse>
             </if>
           </#list>
          </#if>
         </where>
         ORDER BY gmt_modify DESC
         <if test="startRow != null and offSet != null">
         LIMIT <#noparse>#{</#noparse>startRow<#noparse>}</#noparse>,<#noparse>#{</#noparse>offSet<#noparse>}</#noparse>
         </if>
     </select>

     <select id="queryExactlyOneByParam"
                 parameterType="${queryParamPackagePath}"
                 resultMap="BaseResultMap">
         select
         <include refid="Base_Column_List"/>
         from
         ${tableName}
         <where>
          <#if tableDescribes?exists>
           <#list tableDescribes as tableDescribe>
             <if test="${tableDescribe.underLineColumnName} !=null">
               and ${tableDescribe.originColumnName} = <#noparse>#{</#noparse>${tableDescribe.underLineColumnName}<#noparse>}</#noparse>
             </if>
           </#list>
          </#if>
         </where>
         ORDER BY gmt_modify DESC
         LIMIT 1
      </select>

     <select id="count"
             parameterType="${queryParamPackagePath}"
             resultType="INTEGER">
          select
          count(*)
          from
          ${tableName}
          <where>
           <#if tableDescribes?exists>
            <#list tableDescribes as tableDescribe>
              <if test="${tableDescribe.underLineColumnName} !=null">
                and ${tableDescribe.originColumnName} = <#noparse>#{</#noparse>${tableDescribe.underLineColumnName}<#noparse>}</#noparse>
              </if>
            </#list>
           </#if>
          </where>
      </select>

</mapper>
