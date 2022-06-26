package ${doPackagePrefixPath};


import lombok.Data;
import java.util.Date;

/**
 * @author : zms
 * @create : 2022/6/12
 * @desc : ${desc} DO
 */
@Data
public class ${doName} {



    <#if tableDescribes?exists>
      <#list tableDescribes as tableDescribe>
        /**
         * ${tableDescribe.remakes!}
         */
        private  ${typeConvert(tableDescribe.type)}  ${tableDescribe.underLineColumnName};
      </#list>
    </#if>


}