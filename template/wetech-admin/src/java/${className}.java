<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package tech.wetech.admin.model.module;

import tech.wetech.admin.model.BaseEntity;
import javax.validation.constraints.*;

/**
 * ${table.remarks}
 * @version 1.0
 * @author
 */
public class ${className} extends BaseEntity {

<#list table.columns as column>
/**
 * ${column.columnAlias}
 */
<@generateBycondition column.columnNameLower>
<#if column.isNulllable=='false' && column.simpleJavaType == 'String'>
@NotEmpty(message = "${column.columnAlias}不能为空")
</#if>
<#if column.isNulllable=='false' && column.simpleJavaType != 'String'>
@NotNull(message = "${column.columnAlias}不能为空")
</#if>
</@generateBycondition>
<#if column.columnNameLower !='id'>
private ${column.simpleJavaType} ${column.columnNameLower};
</#if>
</#list>



<#list table.columns as column>
<#if column.columnNameLower !='id'>
public void set${column.columnName}(${column.simpleJavaType} value) {
	this.${column.columnNameLower} = value;
}

public ${column.simpleJavaType} get${column.columnName}() {
	return this.${column.columnNameLower};
}
</#if>
</#list>
}
