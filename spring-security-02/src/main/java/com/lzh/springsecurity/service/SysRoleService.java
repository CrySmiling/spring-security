package com.lzh.springsecurity.service;

import com.lzh.springsecurity.mapper.SysRoleMapper;
import com.lzh.springsecurity.pojo.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author H
 *
 * @date 2019/7/22
 *
 */
@Service
public class SysRoleService {
	@Autowired
	private SysRoleMapper roleMapper;

	public SysRole selectById(Integer id){
		return roleMapper.selectById(id);
	}
}

