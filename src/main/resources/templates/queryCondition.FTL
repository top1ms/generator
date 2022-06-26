package ${queryConditionPackagePrefixPath};


import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import ${basePageQueryPackagePrefixPath}.BasePageQuery;

/**
 * @author : zms
 * @create : 2022/6/12
 * @desc : ${desc}
 */
@Data
public class ${queryConditionName} extends BasePageQuery implements Serializable {



    <#if tableDescribes?exists>
      <#list tableDescribes as tableDescribe>
        /**
         * ${tableDescribe.remakes!}
         */
        private  ${typeConvert(tableDescribe.type)}  ${tableDescribe.underLineColumnName};
      </#list>
    </#if>


}