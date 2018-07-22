<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#include "/macro.include"/>
package tech.wetech.admin.service.module;

import tech.wetech.admin.model.module.${className};
import tk.mybatis.mapper.weekend.Weekend;
import tech.wetech.admin.common.base.PageResultSet;

import java.util.List;

/**
 * ${table.remarks}Service
 * @version 1.0
 * @author
 */
public interface ${className}Service {

    int create${className}(${className} ${classNameLower});

    int update${className}(${className} ${classNameLower});

    void delete${className}(Long ${classNameLower}Id);

    ${className} findOne(Long ${classNameLower}Id);

    List<${className}> find(Weekend weekend);

    List<${className}> findAll();

    PageResultSet<${className}> findByPage(${className} ${classNameLower});
}
