package com.lzh.springsecurity.pojo;

import lombok.Data;

import java.io.Serializable;

/*
 * @author H
 *
 * @date 2019/7/22
 *
 */
@Data
public class SysUser implements Serializable {
	private Integer id;

	private String name;

	private String password;
}
