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
	
});