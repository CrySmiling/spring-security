package com.lzh.springsecurity.mapper;

import com.lzh.springsecurity.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/*
 * @author H
 *
 * @date 2019/7/22
 *
 */
@Mapper
public interface SysRoleMapper {
	@Select("SELECT * FROM sys_role WHERE id = #{id}")
	SysRole selectById(Integer id);
}
