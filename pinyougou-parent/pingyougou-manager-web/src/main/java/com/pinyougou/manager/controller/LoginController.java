package com.pinyougou.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/***
 * 用户登入
 * 
 * @author warrior
 *
 */
@RestController
@RequestMapping("/login/")
public class LoginController {

	@RequestMapping(value = "name", method = RequestMethod.GET)
	public Map<String, String> loginByName() {

		String name = SecurityContextHolder.getContext().getAuthentication().getName();

		Map<String, String> map = new HashMap<String, String>();

		map.put("loginName", name);

		return map;
	}
}
