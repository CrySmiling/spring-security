package com.lzh.springsecurity.mapper;

import com.lzh.springsecurity.pojo.SysPermission;
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
public interface SysPermissionMapper {
	@Select("SELECT * FROM sys_permission WHERE role_id=#{roleId}")
	List<SysPermission> listByRoleId(Integer roleId);
}