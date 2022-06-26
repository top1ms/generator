package ${queryParamPackagePrefixPath};


import lombok.Data;
import java.util.Date;
import ${basePageQueryPackagePrefixPath}.BasePageQuery;

/**
 * @author : zms
 * @create : 2022/6/12
 * @desc : ${desc} QueryParam
 */
@Data
public class ${queryParamName} extends BasePageQuery {



   <#if tableDescribes?exists>
        <#list tableDescribes as tableDescribe>
          /**
           * ${tableDescribe.remakes!}
           */
          private  ${typeConvert(tableDescribe.type)}  ${tableDescribe.underLineColumnName};
        </#list>
      </#if>


}