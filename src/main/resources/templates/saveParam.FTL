package ${saveParamPackagePrefixPath};


import lombok.Data;
import java.util.Date;
import java.io.Serializable;

/**
 * @author : zms
 * @create : 2022/6/12
 * @desc : ${desc} SaveParam
 */
@Data
public class ${saveParamName} implements Serializable {



   <#if tableDescribes?exists>
        <#list tableDescribes as tableDescribe>
          /**
           * ${tableDescribe.remakes!}
           */
          private  ${typeConvert(tableDescribe.type)}  ${tableDescribe.underLineColumnName};
        </#list>
      </#if>


}