package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

/*****
 * 品牌操作服务接口实现
 * 
 * @author warrior
 *
 */
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;

	@Override
	public List<TbBrand> findAll() {
		return brandMapper.selectByExample(null);
	}

	@Override
	public PageResult<TbBrand> findPage(int pageNum, int pageSize) {

		PageHelper.startPage(pageNum, pageSize);

		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);

		return new PageResult<TbBrand>(page.getTotal(), page.getResult());
	}

}
