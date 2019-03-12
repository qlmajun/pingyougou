package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
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

	@Override
	public boolean createBrand(TbBrand brand) {
		return brandMapper.insert(brand) > 0;
	}

	@Override
	public TbBrand queryBrandById(long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateBrand(TbBrand brand) {
		return brandMapper.updateByPrimaryKey(brand) > 0;
	}

	@Override
	public boolean deleteBrands(long[] ids) {

		for (long id : ids) {
			brandMapper.deleteByPrimaryKey(id);
		}

		return true;
	}

	@Override
	public PageResult<TbBrand> queryBrandByCondition(TbBrand brand, int pageNum, int pageSize) {

		PageHelper.startPage(pageNum, pageSize);

		TbBrandExample example = new TbBrandExample();

		Criteria criteria = example.createCriteria();

		// 品牌名称不为空，条件查询
		if (brand != null && !StringUtils.isEmpty(brand.getName())) {
			criteria.andNameLike("%" + brand.getName() + "%");
		}

		// 首字母不为空，条件查询
		if (brand != null && !StringUtils.isEmpty(brand.getFirstChar())) {
			criteria.andFirstCharEqualTo(brand.getFirstChar());
		}

		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);

		return new PageResult<TbBrand>(page.getTotal(), page.getResult());
	}

}
