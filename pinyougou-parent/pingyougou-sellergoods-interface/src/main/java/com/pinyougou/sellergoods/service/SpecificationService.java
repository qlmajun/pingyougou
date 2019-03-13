package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojogroup.Specification;

/****
 * 规格参数服务接口声明
 * 
 * @author warrior
 *
 */
public interface SpecificationService {

	/****
	 * 分页查询规格参数列表
	 * 
	 * @param pageNum  当前页
	 * @param pageSize 每页显示条数
	 * @return
	 */
	PageResult<TbSpecification> querySpecifications(int pageNum, int pageSize);

	/****
	 * 根据Id获取产品规格信息
	 * 
	 * @param id 产品规格Id
	 * @return
	 */
	Specification querySpecificationById(long id);

	/****
	 * 新增产品规格
	 * 
	 * @param specification 产品规格信息
	 * @return
	 */
	boolean createSpecification(Specification specification);

	/****
	 * 修改产品规格
	 * 
	 * @param specification 产品规格信息
	 * @return
	 */
	boolean updateSpecification(Specification specification);

	/****
	 * 删除产品规格信息
	 * 
	 * @param ids 产品规格Ids
	 * @return
	 */
	boolean deleteSpecifications(long[] ids);

	/****
	 * 条件查询产品规格信息
	 * 
	 * @param specification 产品规格查询条件
	 * @param pageNum       当前页
	 * @param pageSize      每页显示条数
	 * @return
	 */
	PageResult<TbSpecification> querySpecificationsByCondition(TbSpecification specification, int pageNum, int pageSize);
}
