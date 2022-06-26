package ${facedManagerImplPackagePrefixPath};

import ${pageQueryResultPackagePrefixPath}.PageQueryResult;
import ${dtoPackagePath};
import ${saveParamPackagePath};
import ${queryConditionPackagePath};
import ${facedManagerPackagePath};
import ${servicePackagePath};
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author zms@didiglobal.com
 * @desc ${desc} FaceManagerImpl
 * @date 2022/6/23
 */
@Service("${facedManagerName?uncap_first}")
public class ${facedManagerImplName} implements ${facedManagerName} {

    @Autowired
    private ${serviceName} ${serviceName?uncap_first};

    @Override
    public ${dtoName} queryById(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        ${queryConditionName} condition = new ${queryConditionName}();
        condition.setId(id);
        return ${serviceName?uncap_first}.queryExactlyOneByCondition(condition);
    }

    @Override
    public boolean insert(${saveParamName} param) {
        if (Objects.isNull(param)) {
            return false;
        }
        /** 业务逻辑代码 **/
        return ${serviceName?uncap_first}.insert(param);
    }

    @Override
    public boolean edit(${saveParamName} param) {
        if (Objects.isNull(param) || Objects.isNull(param.getId())) {
            return false;
        }
        /** 业务逻辑代码 **/
        return ${serviceName?uncap_first}.edit(param);
    }

     @Override
    public boolean delete(Long id) {
        if (Objects.isNull(id)) {
            return false;
        }
        ${saveParamName} param = new ${saveParamName}();
        param.setId(id);
        param.setHasDeleted(1);
        return ${serviceName?uncap_first}.edit(param);
    }

    @Override
    public PageQueryResult<${dtoName}> pageQueryByCondition(${queryConditionName} condition) {
        if (Objects.isNull(condition)) {
            return PageQueryResult.empty();
        }
        PageQueryResult<${dtoName}> pageQueryResult = new PageQueryResult<>();
        List<${dtoName}> result = ${serviceName?uncap_first}.queryByCondition(condition);
        if (CollectionUtils.isEmpty(result)) {
            return PageQueryResult.empty();
        }
        int count = ${serviceName?uncap_first}.count(condition);
        pageQueryResult.setDataList(result);
        pageQueryResult.setTotalCount(count);
        return pageQueryResult;
    }

    @Override
    public List<${dtoName}> nonPageQueryByCondition(${queryConditionName} condition) {
        if (Objects.isNull(condition)) {
            return Collections.emptyList();
        }
        condition.setPageNo(null);
        condition.setPageSize(null);
        return ${serviceName?uncap_first}.queryByCondition(condition);
    }
}
