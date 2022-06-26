package ${servicePackagePrefixPath};

import ${dtoPackagePath};
import ${queryConditionPackagePath};
import ${saveParamPackagePath};

import java.util.List;

/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : ${desc} Service
 */
public interface ${serviceName} {

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 新增 ${desc}
     */
    boolean            insert(${saveParamName} param);

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 编辑 ${desc}
     */
    boolean            edit(${saveParamName} param);

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 根据条件查询具体的${desc}
     */
    ${dtoName}         queryExactlyOneByCondition(${queryConditionName} condition);

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 条件查询${desc}列表
     */
    List<${dtoName}>   queryByCondition(${queryConditionName} condition);

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : count ${desc}
     */
    int                count(${queryConditionName} condition);
}
