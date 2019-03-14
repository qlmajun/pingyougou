//产品规格service 层

app.service('specificationService',function($http){
	
	//分页查询规格信息
	this.findPage=function(pageNum,pageSize){
		return $http.get('../rest/specification/collections?pageNum='+pageNum+'&pageSize='+pageSize);
	}
	
	//条件查询规格信息
	this.search=function(pageNum,pageSize,entity){
		return $http.post('../rest/specification/search?pageNum='+pageNum+'&pageSize='+pageSize,entity);
	}
	
	//新增规格信息
	this.save=function(entity){
		return $http.post('../rest/specification/create',entity);
	}
	
	//根据Id查询产品规格信息
	this.querySpecification=function(id){
		return $http.get('../rest/specification/'+id);
	}
	
	//修改规格信息
	this.updateSpecification=function(entity){
		return $http.post('../rest/specification/update',entity);
	}
	
	//删除规格信息
	this.deleteSpecifications=function(ids){
		return $http.get('../rest/specification/delete?ids='+ids);
	}
	
});