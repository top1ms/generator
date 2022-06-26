package ${serviceImplPackagePrefixPath};

import ${dtoPackagePath};
import ${queryConditionPackagePath};
import ${saveParamPackagePath};
import ${doPackagePath};
import ${queryParamPackagePath};
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
    public boolean insert(${saveParamName} param) {
        if (Objects.isNull(param)) {
            return false;
        }
        ${doName} ${doName?uncap_first} = transferDO(param);
        return ${daoName?uncap_first}.insert(${doName?uncap_first}) > 0;
    }

    @Override
    public boolean edit(${saveParamName} param) {
        if (Objects.isNull(param) || Objects.isNull(param.getId())) {
            return false;
        }
        ${doName} ${doName?uncap_first} = transferDO(param);
        return ${daoName?uncap_first}.updateByPrimaryKey(${doName?uncap_first}) > 0;
    }

    @Override
    public ${dtoName} queryExactlyOneByCondition(${queryConditionName} condition) {
        if(Objects.isNull(condition)){
            return null;
        }
        ${queryParamName} param = transferQueryParam(condition);
        ${doName} ${doName?uncap_first} = ${daoName?uncap_first}.queryExactlyOneByParam(param);
        if(Objects.isNull(${doName?uncap_first})){
            return null;
        }
        return transferDTO(${doName?uncap_first});
    }

    @Override
    public List<${dtoName}> queryByCondition(${queryConditionName} condition) {
        ${queryParamName} param = transferQueryParam(condition);
        List<${doName}> result = ${daoName?uncap_first}.queryByParam(param);
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result.stream()
                     .map(this::transferDTO)
                     .collect(Collectors.toList());
    }

    @Override
    public int count(${queryConditionName} condition) {
        ${queryParamName} param = transferQueryParam(condition);
        return ${daoName?uncap_first}.count(param);
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 转换为 DO
     */
    private ${doName} transferDO(${saveParamName} param) {
        ${doName} ${doName?uncap_first} = new ${doName}();
        BeanUtils.copyProperties(param, ${doName?uncap_first});
        return ${doName?uncap_first};
    }

    /**
     * @author : zms
     * @create : 2022/6/19
     * @desc : 转换为 QueryParam
     */
    private ${queryParamName} transferQueryParam(${queryConditionName} condition) {
        ${queryParamName} param = new ${queryParamName}();
        BeanUtils.copyProperties(condition, param);
        return param;
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
