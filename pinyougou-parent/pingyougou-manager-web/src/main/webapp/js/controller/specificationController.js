//产品规格层

app.controller("specificationController",function($scope,$controller,specificationService){
	
	// 继承
	$controller('baseController', {
		$scope : $scope
	});
	
	//分页查询规格信息
	$scope.findPage=function(pageNum,pageSize){
		specificationService.findPage(pageNum,pageSize).success(function(response){
			$scope.list = response.rows;
			// 更新总记录数
			$scope.paginationConf.totalItems = response.total;
		});
	}
	
	// 定义搜索对象
	$scope.searchEntity = {};
	
	$scope.search=function(pageNum,pageSize){
		specificationService.search(pageNum,pageSize,$scope.searchEntity).success(function(response){
			$scope.list = response.rows;
			// 更新总记录数
			$scope.paginationConf.totalItems = response.total;
		});
	}
	
});