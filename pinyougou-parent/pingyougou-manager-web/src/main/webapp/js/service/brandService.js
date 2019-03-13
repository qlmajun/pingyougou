//品牌服务层
app.service('brandService',function($http){
	
	//分页查询品牌信息
	this.findPage=function(pageNum,pageSize){
		return $http.get("../rest/brand/collections/page?pageNum="+pageNum+"&pageSize="+pageSize);
	}
	
	//新增品牌
	this.save=function(entity){
		return $http.post("../rest/brand/create",entity)
	}
	
	//修改品牌
	this.update=function(entity){
		return $http.post("../rest/brand/update",entity);
	}
	
	//根据Id获取品牌信息
	this.findOne=function(id){
		return $http.get("../rest/brand/"+id);
	}
	
	//批量删除品牌信息
	this.deleteBrands=function(ids){
		return $http.get("../rest/brand/delete?ids="+ids);
	}
	
	//条件查询品牌信息
	this.search=function(pageNum,pageSize,entity){
		return $http.post("../rest/brand/search?pageNum="+pageNum+"&pageSize="+pageSize,entity);
	}
	
});
