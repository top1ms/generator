package ${facedManagerPackagePrefixPath};

import ${pageQueryResultPackagePrefixPath}.PageQueryResult;
import ${dtoPackagePath};
import ${saveParamPackagePath};
import ${queryConditionPackagePath};

import java.util.List;

/**
 * @author zms@didiglobal.com
 * @desc ${desc} FacedManager
 * @date 2022/6/22
 */
public interface ${facedManagerName} {

    /**
     * 根据主键查询 ${desc}
     * @param id
     * @return
     */
    ${dtoName} queryById(Long id);

    /**
     * 新增 ${desc}
     * @param param
     * @return
     */
    boolean insert(${saveParamName} param);

    /**
     * 编辑 ${desc}
     * @param param
     * @return
     */
    boolean edit(${saveParamName} param);

    /**
     * 删除 ${desc} 逻辑删除
     */
    boolean delete(Long id);

    /**
     * 分页条件查询 ${desc}
     * @param condition
     * @return
     */
    PageQueryResult<${dtoName}> pageQueryByCondition(${queryConditionName} condition);

    /**
     * 条件查询 ${desc}
     * @param condition
     * @return
     */
    List<${dtoName}> nonPageQueryByCondition(${queryConditionName} condition);

}
