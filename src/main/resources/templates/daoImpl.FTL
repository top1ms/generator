package ${daoImplPackagePrefixPath};


import ${doPackagePath};
import ${queryParamPackagePath};
import ${daoPackagePath};
import ${pageUtilsPackagePrefixPath}.PageUtil;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : ${desc} DaoImpl
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
        return sqlSessionTemplate.insert("${mapperName}.insert", ${doName?uncap_first});
    }

    /**
     * 编辑 ${desc}
     *
     * @param ${doName?uncap_first}
     * @return
     */
    @Override
    public int updateByPrimaryKey(${doName} ${doName?uncap_first}) {
        if (Objects.isNull(${doName?uncap_first}) || Objects.isNull(${doName?uncap_first}.getId())){
            return 0;
        }
        return sqlSessionTemplate.update("${mapperName}.updateByPrimaryKey", ${doName?uncap_first});
    }


    /**
     * count ${desc}
     *
     * @param param
     * @return
     */
    @Override
    public int count(${queryParamName} param) {
        if (Objects.isNull(param)){
            return 0;
        }
        return sqlSessionTemplate.selectOne("${mapperName}.count",param);
    }

    /**
     * 条件查询 ${desc}
     *
     * @param param
     * @return
     */
    @Override
    public List<${doName}> queryByParam(${queryParamName} param) {
        if (Objects.isNull(param)) {
            return Collections.emptyList();
        }
        if (Objects.nonNull(param.getPageNo()) && Objects.nonNull(param.getPageSize())) {
            param.setOffSet(param.getPageSize());
            param.setStartRow(PageUtil.getStartRow(param.getPageNo(), param.getPageSize()));
        }
        return sqlSessionTemplate.selectList("${mapperName}.queryByParam", param);
    }


    /**
     * 条件查询 ${desc}
     *
     * @param param
     * @return
     */
    @Override
    public ${doName} queryExactlyOneByParam(${queryParamName} param) {
        if (Objects.isNull(param)) {
            return null;
        }
        return sqlSessionTemplate.selectOne("${mapperName}.queryExactlyOneByParam", param);
    }
}
