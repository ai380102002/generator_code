<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
<#assign remarks = table.remarks>

package tech.wetech.admin.mapper.module;

import tech.wetech.admin.common.utils.MyMapper;
import tech.wetech.admin.model.module.${className};

public interface ${className}Mapper extends MyMapper<${className}> {

}