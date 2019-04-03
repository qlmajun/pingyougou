package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

/****
 * 品牌操作接口服务
 * 
 * @author warrior
 *
 */
@RestController
@RequestMapping("/brand/")
public class BrandController {

	@Reference
	private BrandService brandService;

	/***
	 * 查询所有的品牌列表信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "collections", method = RequestMethod.GET)
	public List<TbBrand> findAll() {
		return brandService.findAll();
	}

	/****
	 * 分页查询品牌列表信息
	 * 
	 * @param pageNum  当前页
	 * @param pageSize 每页显示大小
	 * @return
	 */
	@RequestMapping(value = "collections/page", method = RequestMethod.GET)
	public PageResult<TbBrand> findPage(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		return brandService.findPage(pageNum, pageSize);
	}

	/****
	 * 新增品牌
	 * 
	 * @param brand 品牌封装数据
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public Result createBrand(@RequestBody TbBrand brand) {

		boolean success = brandService.createBrand(brand);

		if (!success) {
			return new Result(false, "新增品牌失败");
		}

		return new Result(true, "新增品牌成功");
	}

	/****
	 * 根据品牌Id查询品牌信息
	 * 
	 * @param id 品牌Id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public TbBrand queryBrand(@PathVariable(value = "id") long id) {
		TbBrand brand = brandService.queryBrandById(id);
		return brand;
	}

	/****
	 * 修改品牌信息
	 * 
	 * @param brand 品牌信息
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result updateBrand(@RequestBody TbBrand brand) {

		boolean success = brandService.updateBrand(brand);

		if (!success) {
			return new Result(false, "修改失败");
		}

		return new Result(true, "修改成功");
	}

	/***
	 * 批量删除品牌信息
	 * 
	 * @param ids 品牌Id列表
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public Result deleteBrands(@RequestParam(value = "ids") long[] ids) {

		boolean success = brandService.deleteBrands(ids);

		if (!success) {
			return new Result(false, "删除失败");
		}

		return new Result(true, "删除成功");
	}

	/****
	 * 条件查询品牌列表信息
	 * 
	 * @param brand    查询品牌条件
	 * @param pageNum  当前页
	 * @param pageSize 每页显示条数
	 * @return
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public PageResult<TbBrand> queryBrandByCondition(@RequestBody TbBrand brand, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

		return brandService.queryBrandByCondition(brand, pageNum, pageSize);
	}

}
