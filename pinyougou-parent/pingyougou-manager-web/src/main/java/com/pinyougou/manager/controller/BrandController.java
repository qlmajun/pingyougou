package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

/****
 * 品牌操作接口服务
 * 
 * @author warrior
 *
 */
@Controller
@RequestMapping("/brand/")
public class BrandController {

	@Reference
	private BrandService brandService;

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<TbBrand> findAll() {
		return brandService.findAll();
	}
}
