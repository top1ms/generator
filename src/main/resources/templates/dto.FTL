package ${packagePrefix};


import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : zms
 * @create : 2022/6/12
 * @desc : ${desc} DTO
 */
@Data
public class ${javaFileName} implements Serializable {



    <#if tableDescribes?exists>
      <#list tableDescribes as tableDescribe>
        /**
         * ${tableDescribe.remakes!}
         */
        private  ${typeConvert(tableDescribe.type)}  ${tableDescribe.underLineColumnName};
      </#list>
    </#if>


}