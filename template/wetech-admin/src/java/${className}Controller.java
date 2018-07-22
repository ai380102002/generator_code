<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
<#assign remarks = table.remarks>

package tech.wetech.admin.controller.module;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.wetech.admin.common.annotation.SystemLog;
import tech.wetech.admin.common.base.Result;
import tech.wetech.admin.controller.BaseController;
import tech.wetech.admin.model.module.${className};
import tech.wetech.admin.service.module.${className}Service;
import tk.mybatis.mapper.weekend.Weekend;

import javax.validation.Valid;

@Controller
@RequestMapping("/module/${classNameLower}")
public class ${className}Controller extends BaseController{

	@Autowired
	private ${className}Service ${classNameLower}Service;

	@GetMapping
	@RequiresPermissions("${classNameLower}:list")
	public String toPage(Model model) {
		return "module/${classNameLower}";
	}

	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("${classNameLower}:list")
	public PageResultSet<${className}> list(${className} ${classNameLower}) {
		return ${classNameLower}Service.findByPage(${classNameLower});
	}
	

	@ResponseBody
	@RequiresPermissions("${classNameLower}:view")
	@RequestMapping(value = "{id}/load", method = RequestMethod.POST)
	public Result load(@PathVariable Long id) {
		${className} ${classNameLower} = ${classNameLower}Service.findOne(id);
		return Result.Success(${classNameLower});
	}

	@ResponseBody
	@RequiresPermissions("${classNameLower}:create")
	@SystemLog("${remarks}创建")
	@PostMapping("/create")
	public Result create(@Valid ${className} ${classNameLower}) {
		${classNameLower}Service.create${className}(${classNameLower});
		return Result.Success();
	}

	@ResponseBody
	@RequiresPermissions("${classNameLower}:update")
	@SystemLog("${remarks}更新")
	@PostMapping("/update")
	public Result update(@Valid ${className} ${classNameLower}) {
		${classNameLower}Service.update${className}(${classNameLower});
		return Result.Success();
	}

	@ResponseBody
	@RequiresPermissions("${classNameLower}:delete")
	@SystemLog("${remarks}删除")
	@PostMapping("/delete")
	public Result delete(Long id) {
		${classNameLower}Service.delete${className}(id);
		return Result.Success();
	}

}
