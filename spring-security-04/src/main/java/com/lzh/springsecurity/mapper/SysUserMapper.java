package com.lzh.springsecurity.mapper;

import com.lzh.springsecurity.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/*
 * @author H
 *
 * @date 2019/7/22
 *
 */
@Mapper
public interface SysUserMapper {
	@Select("SELECT * FROM sys_user WHERE id = #{id}")
	SysUser selectById(Integer id);

	@Select("SELECT * FROM sys_user WHERE name = #{name}")
	SysUser selectByName(String name);
}

