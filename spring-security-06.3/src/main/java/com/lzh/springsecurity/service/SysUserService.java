package com.lzh.springsecurity.service;

import com.lzh.springsecurity.mapper.SysUserMapper;
import com.lzh.springsecurity.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author H
 *
 * @date 2019/7/22
 *
 */
@Service
public class SysUserService {
	@Autowired
	private SysUserMapper userMapper;

	public SysUser selectById(Integer id) {
		return userMapper.selectById(id);
	}

	public SysUser selectByName(String name) {
		return userMapper.selectByName(name);
	}
}

