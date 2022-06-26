package ${daoPackagePrefixPath};

import ${doPackagePath};
import ${queryParamPackagePath};

import java.util.List;

/**
 * @author : zms
 * @create : 2022/6/19
 * @desc : ${desc} Dao
 */
public interface ${daoName} {


    /**
     * 新增 ${desc}
     * @param ${doName?uncap_first}
     * @return
     */
    int                 insert(${doName} ${doName?uncap_first});

    /**
     * 编辑 ${desc}
     * @param ${doName?uncap_first}
     * @return
     */
    int                 updateByPrimaryKey(${doName} ${doName?uncap_first});

    /**
     * count ${desc}
     * @param param
     * @return
     */
    int                 count(${queryParamName} param);

    /**
     * 条件查询 ${desc}
     * @param param
     * @return
     */
    List<${doName}>     queryByParam(${queryParamName} param);


    /**
     * 条件查询 ${desc}
     * @param param
     * @return
     */
    ${doName}           queryExactlyOneByParam(${queryParamName} param);




}
