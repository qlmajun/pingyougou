package com.pinyougou.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 用户登入
 * 
 * @author warrior
 *
 */
@Controller
@RequestMapping("/login/")
public class LoginController {

	@RequestMapping(value = "name", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> loginByName() {

		String name = SecurityContextHolder.getContext().getAuthentication().getName();

		Map<String, String> map = new HashMap<String, String>();

		map.put("loginName", name);

		return map;
	}
}
