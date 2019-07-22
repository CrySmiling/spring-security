package com.lzh.springsecurity.service;

import com.lzh.springsecurity.mapper.SysPermissionMapper;
import com.lzh.springsecurity.pojo.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @author H
 *
 * @date 2019/7/22
 *
 */
@Service
public class SysPermissionService {
	@Autowired
	private SysPermissionMapper permissionMapper;

	/**
	 * 获取指定角色所有权限
	 */
	public List<SysPermission> listByRoleId(Integer roleId) {
		return permissionMapper.listByRoleId(roleId);
	}
}