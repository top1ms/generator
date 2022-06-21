package ${serviceImplPackagePrefixPath};

import ${dtoPackagePath};
import ${queryParamPackagePath};
import ${saveParamPackagePath};
import ${doPackagePath};
import ${queryConditionPackagePath};
import ${daoPackagePath};
import ${servicePackagePath};
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : ${desc}ServiceImpl
 */
@Service
public class ${serviceImplName} implements ${serviceName} {

    @Autowired
    private ${daoName} ${daoName?uncap_first};

    @Override
    public boolean insert(${saveParamName} ${saveParamName?uncap_first}) {
        if (Objects.isNull(${saveParamName?uncap_first})) {
            return false;
        }
        ${doName} ${doName?uncap_first} = transferDO(${saveParamName?uncap_first});
        return ${daoName?uncap_first}.insert(${doName?uncap_first}) > 0;
    }

    @Override
    public boolean edit(${saveParamName} ${saveParamName?uncap_first}) {
        if (Objects.isNull(${saveParamName?uncap_first}) || Objects.isNull(${saveParamName?uncap_first}.getId())) {
            return false;
        }
        ${doName} ${doName?uncap_first} = transferDO(${saveParamName?uncap_first});
        return ${daoName?uncap_first}.updateByPrimaryKey(${doName?uncap_first}) > 0;
    }

    @Override
    public ${dtoName} queryExactlyOneByCondition(${queryParamName} ${queryParamName?uncap_first}) {
        List<${dtoName}> result = queryByCondition(${queryParamName?uncap_first});
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public List<${dtoName}> queryByCondition(${queryParamName} ${queryParamName?uncap_first}) {
        ${queryConditionName} ${queryConditionName?uncap_first} = transferQueryCondition(${queryParamName?uncap_first});
        List<${doName}> result = ${daoName?uncap_first}.queryByCondition(${queryConditionName?uncap_first});
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result.stream()
                     .map(this::transferDTO)
                     .collect(Collectors.toList());
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 转换为 DO
     */
    private ${doName} transferDO(${saveParamName} ${saveParamName?uncap_first}) {
        ${doName} ${doName?uncap_first} = new ${doName}();
        BeanUtils.copyProperties(${saveParamName?uncap_first}, ${doName?uncap_first});
        return ${doName?uncap_first};
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 转换为 QueryCondition
     */
    private ${queryConditionName} transferQueryCondition(${queryParamName} ${queryParamName?uncap_first}) {
        ${queryConditionName} ${queryConditionName?uncap_first} = new ${queryConditionName}();
        BeanUtils.copyProperties(${queryParamName?uncap_first}, ${queryConditionName?uncap_first});
        return ${queryConditionName?uncap_first};
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 转换为 DTO
     */
    private ${dtoName} transferDTO(${doName} ${doName?uncap_first}) {
        ${dtoName} ${dtoName?uncap_first} = new ${dtoName}();
        BeanUtils.copyProperties(${doName?uncap_first}, ${dtoName?uncap_first});
        return ${dtoName?uncap_first};
    }
}
