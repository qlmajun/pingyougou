package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

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
	
}
