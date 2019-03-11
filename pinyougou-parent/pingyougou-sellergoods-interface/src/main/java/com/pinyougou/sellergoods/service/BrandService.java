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

}
