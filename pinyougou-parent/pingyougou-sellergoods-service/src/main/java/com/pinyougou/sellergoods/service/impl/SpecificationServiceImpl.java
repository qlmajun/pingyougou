package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationExample;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import com.pinyougou.pojo.TbSpecificationOptionExample.Criteria;
import com.pinyougou.pojogroup.Specification;
import com.pinyougou.sellergoods.service.SpecificationService;

/****
 * 规格参数服务接口实现
 * 
 * @author warrior
 *
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private TbSpecificationMapper specificationMapper;

	@Autowired
	private TbSpecificationOptionMapper specificationOptionMapper;

	@Override
	public PageResult<TbSpecification> querySpecifications(int pageNum, int pageSize) {

		PageHelper.startPage(pageNum, pageSize);

		Page<TbSpecification> page = (Page<TbSpecification>) specificationMapper.selectByExample(null);

		return new PageResult<TbSpecification>(page.getTotal(), page.getResult());
	}

	@Override
	public Specification querySpecificationById(long id) {

		TbSpecification specification = specificationMapper.selectByPrimaryKey(id);

		// 获取规格选项
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(specification.getId());
		List<TbSpecificationOption> specificationOptions = specificationOptionMapper.selectByExample(example);

		return new Specification(specification, specificationOptions);
	}

	@Override
	public boolean createSpecification(Specification specification) {

		// 获取规格实体对象
		TbSpecification tbSpecification = specification.getSpecification();

		// 新增到数据
		specificationMapper.insert(tbSpecification);

		// 获取规格选项
		List<TbSpecificationOption> specificationOptions = specification.getSpecificationOptionList();

		for (TbSpecificationOption specificationOption : specificationOptions) {
			specificationOption.setSpecId(tbSpecification.getId());
			specificationOptionMapper.insert(specificationOption);
		}

		return true;
	}

	@Override
	public boolean updateSpecification(Specification specification) {

		// 获取规格实体对象
		TbSpecification tbSpecification = specification.getSpecification();

		// 修改规格信息到数据库
		specificationMapper.updateByPrimaryKey(tbSpecification);

		// 删除原来规格信息对应的规格选项
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(tbSpecification.getId());
		specificationOptionMapper.deleteByExample(example);

		// 获取新的规格选项信息
		List<TbSpecificationOption> specificationOptions = specification.getSpecificationOptionList();
		for (TbSpecificationOption specificationOption : specificationOptions) {
			specificationOption.setSpecId(tbSpecification.getId());
			specificationOptionMapper.insert(specificationOption);
		}

		return true;
	}

	@Override
	public boolean deleteSpecifications(long[] ids) {

		for (long id : ids) {
			specificationMapper.deleteByPrimaryKey(id);

			// 删除规格选项数据
			TbSpecificationOptionExample example = new TbSpecificationOptionExample();
			Criteria criteria = example.createCriteria();
			criteria.andSpecIdEqualTo(id);
			specificationOptionMapper.deleteByExample(example);
		}

		return true;
	}

	@Override
	public PageResult<TbSpecification> querySpecificationsByCondition(TbSpecification specification, int pageNum, int pageSize) {

		PageHelper.startPage(pageNum, pageSize);

		TbSpecificationExample example = new TbSpecificationExample();

		com.pinyougou.pojo.TbSpecificationExample.Criteria criteria = example.createCriteria();

		// 规格名称条件过滤
		if (specification != null && !StringUtils.isEmpty(specification.getSpecName())) {
			criteria.andSpecNameLike("%" + specification.getSpecName() + "%");
		}

		Page<TbSpecification> page = (Page<TbSpecification>) specificationMapper.selectByExample(example);

		return new PageResult<TbSpecification>(page.getTotal(), page.getResult());
	}

}
