package ${daoImplPackagePrefixPath};


import ${doPackagePath};
import ${queryConditionPackagePath};
import ${daoPackagePath};
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : DaoImpl
 */
@Service
public class ${daoImplName} implements ${daoName} {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 新增 ${desc}
     *
     * @param ${doName?uncap_first}
     * @return
     */
    @Override
    public int insert(${doName} ${doName?uncap_first}) {
        if (Objects.isNull(${doName?uncap_first})) {
            return 0;
        }
        return sqlSessionTemplate.insert("${daoMapperName}.insert", ${doName?uncap_first});
    }

    /**
     * 编辑 人员信息
     *
     * @param ${doName?uncap_first}
     * @return
     */
    @Override
    public int updateByPrimaryKey(${doName} ${doName?uncap_first}) {
        if (Objects.isNull(${doName?uncap_first}) || Objects.isNull(${doName?uncap_first}.getId())){
            return 0;
        }
        return sqlSessionTemplate.update("${daoMapperName}.updateByPrimaryKey", ${doName?uncap_first});
    }

    /**
     * 条件查询 人员信息
     *
     * @param condition
     * @return
     */
    @Override
    public List<${doName}> queryByCondition(${queryConditionName} condition) {
        if (Objects.isNull(condition)) {
            return Collections.emptyList();
        }
        return sqlSessionTemplate.selectList("${daoMapperName}.queryByCondition", condition);
    }
}
