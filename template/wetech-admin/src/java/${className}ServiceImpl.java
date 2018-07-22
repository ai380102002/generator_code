<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package tech.wetech.admin.service.module.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.wetech.admin.common.base.PageResultSet;
import com.github.pagehelper.PageHelper;
import tech.wetech.admin.mapper.module.${className}Mapper;
import tech.wetech.admin.model.module.${className};
import tech.wetech.admin.service.module.${className}Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;
import java.util.List;

@Service
public class ${className}ServiceImpl implements ${className}Service {

    @Autowired
    private ${className}Mapper ${classNameLower}Mapper;

    @Override
    public int create${className}(${className} ${classNameLower}) {
        return ${classNameLower}Mapper.insert(${classNameLower});
    }

    @Override
    public int update${className}(${className} ${classNameLower}) {
        return ${classNameLower}Mapper.updateByPrimaryKey(${classNameLower});
    }

    @Override
    public void delete${className}(Long ${classNameLower}Id) {
        ${classNameLower}Mapper.deleteByPrimaryKey(${classNameLower}Id);
    }

    @Override
    public ${className} findOne(Long ${classNameLower}Id) {
        return ${classNameLower}Mapper.selectByPrimaryKey(${classNameLower}Id);
    }

    @Override
    public List<${className}> findAll() {
        return ${classNameLower}Mapper.selectAll();
    }

    @Override
    public List<${className}> find(Weekend weekend) {
        return ${classNameLower}Mapper.selectByExample(weekend);
    }


    @Override
    public PageResultSet<${className}> findByPage(${className} ${classNameLower}){
        PageHelper.offsetPage(${classNameLower}.getOffset(), ${classNameLower}.getLimit());
        if(!StringUtils.isEmpty(${classNameLower}.getOrderBy())){
            PageHelper.orderBy(${classNameLower}.getOrderBy());
        }
        Weekend<${className}> weekend = Weekend.of(${className}.class);
        //WeekendCriteria<${className},Object> criteria = weekend.weekendCriteria();
        //if(!StringUtils.isEmpty(${classNameLower}.getSearch())){
        //    criteria.andLike(${className}::get${className},"%"+${classNameLower}.getSearch()+"%")
        //    .orLike(${className}::getDescription,"%"+${classNameLower}.getSearch()+"%");
        //}
        PageResultSet<${className}> resultSet = new PageResultSet<>();
        List<${className}> list = ${classNameLower}Mapper.selectByExample(${classNameLower});
        long count = ${classNameLower}Mapper.selectCountByExample(weekend);
        resultSet.setRows(list);
        resultSet.setTotal(count);
        return resultSet;
    }
}