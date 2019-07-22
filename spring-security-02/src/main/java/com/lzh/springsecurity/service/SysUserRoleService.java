package com.lzh.springsecurity.service;

import com.lzh.springsecurity.mapper.SysUserRoleMapper;
import com.lzh.springsecurity.pojo.SysUserRole;
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
public class SysUserRoleService {
	@Autowired
	private SysUserRoleMapper userRoleMapper;

	public List<SysUserRole> listByUserId(Integer userId) {
		return userRoleMapper.listByUserId(userId);
	}
}

