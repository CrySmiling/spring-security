package com.lzh.springsecurity.mapper;

import com.lzh.springsecurity.pojo.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
 * @author H
 *
 * @date 2019/7/22
 *
 */
@Mapper
public interface SysUserRoleMapper {
	@Select("SELECT * FROM sys_user_role WHERE user_id = #{userId}")
	List<SysUserRole> listByUserId(Integer userId);
}

