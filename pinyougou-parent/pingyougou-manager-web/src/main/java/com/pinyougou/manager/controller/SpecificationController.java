package com.pinyougou.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojogroup.Specification;
import com.pinyougou.sellergoods.service.SpecificationService;

/****
 * 产品规格操作Controller层
 * 
 * @author warrior
 *
 */
@Controller
@RequestMapping("specification/")
public class SpecificationController {

	@Reference
	private SpecificationService specificationService;

	/****
	 * 分页查询产品规格信息
	 * 
	 * @param pageNum  当前页
	 * @param pageSize 没有显示条数
	 * @return
	 */
	@RequestMapping(value = "collections", method = RequestMethod.GET)
	@ResponseBody
	public PageResult<TbSpecification> querySpecifications(@RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum, @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
		return specificationService.querySpecifications(pageNum, pageSize);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public Specification querySpecification(@PathVariable(value = "id") int id) {
		return specificationService.querySpecificationById(id);
	}

	/****
	 * 新增规格信息
	 * 
	 * @param specification 规格信息封装
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public Result createSpecification(@RequestBody Specification specification) {

		boolean success = specificationService.createSpecification(specification);

		if (!success) {
			return new Result(false, "新增规格信息失败");
		}

		return new Result(true, "新增规格信息成功");
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public Result updateSpecification(@RequestBody Specification specification) {

		boolean success = specificationService.updateSpecification(specification);

		if (!success) {
			return new Result(false, "修改规格信息失败");
		}

		return new Result(true, "修改规格信息成功");
	}

	/***
	 * 删除产品规格参数信息
	 * 
	 * @param ids 规格参数Id
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	@ResponseBody
	public Result deleteSpecifications(@RequestParam(value = "ids") long[] ids) {

		boolean success = specificationService.deleteSpecifications(ids);

		if (!success) {
			return new Result(false, "删除产品规格信息失败");
		}

		return new Result(true, "删除产品规格信息成功");
	}

	/****
	 * 条件查询规格参数
	 * 
	 * @param pageNum       当前页
	 * @param pageSize      每页显示条数
	 * @param specification 规格参数条件
	 * @return
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	@ResponseBody
	public PageResult<TbSpecification> querySpecificationsByCondition(@RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum, @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize, @RequestBody TbSpecification specification) {

		return specificationService.querySpecificationsByCondition(specification, pageNum, pageSize);
	}

}
