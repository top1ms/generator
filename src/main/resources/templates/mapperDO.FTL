package ${daoPackagePrefixPath};

import ${doPackagePath};
import ${queryConditionPackagePath};

import java.util.List;

/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : ${daoName}
 */
public interface ${daoName} {


    /**
     * 新增
     * @param ${doName?uncap_first}
     * @return
     */
    int                 insert(${doName} ${doName?uncap_first});

    /**
     * 更新
     * @param ${doName?uncap_first}
     * @return
     */
    int                 updateByPrimaryKey(${doName} ${doName?uncap_first});


    /**
     * 条件查询
     * @param ${queryConditionName?uncap_first}
     * @return
     */
    List<${doName}>    queryByCondition(${queryConditionName} ${queryConditionName?uncap_first});


}
