package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.entity.PageResult;

/****
 * 品牌操作服务接口声明
 * 
 * @author warrior
 *
 */
public interface BrandService {

	/****
	 * 获取所有品牌列表
	 * 
	 * @return
	 */
	List<TbBrand> findAll();

	/****
	 * 分页获取品牌列表
	 * 
	 * @param pageNum  开始页
	 * @param pageSize 每页显示条数
	 * @return
	 */
	PageResult<TbBrand> findPage(int pageNum, int pageSize);

	/***
	 * 新增品牌
	 * 
	 * @param brand 品牌数据
	 * @return success:true,fail:false
	 */
	boolean createBrand(TbBrand brand);

	/****
	 * 根据Id获取品牌信息
	 * 
	 * @param id
	 * @return
	 */
	TbBrand queryBrandById(long id);

	/****
	 * 修改品牌信息
	 * 
	 * @param brand 品牌数据
	 * @return
	 */
	boolean updateBrand(TbBrand brand);

	/****
	 * 批量删除品牌信息
	 * 
	 * @param ids 品牌Id列表
	 * @return
	 */
	boolean deleteBrands(long[] ids);

	/****
	 * 条件查询品牌信息
	 * 
	 * @param brand    查询品牌信息条件
	 * @param pageNum  当前页
	 * @param pageSize 每页显示条数
	 * @return
	 */
	PageResult<TbBrand> queryBrandByCondition(TbBrand brand, int pageNum, int pageSize);

}
