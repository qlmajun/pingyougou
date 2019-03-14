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
	
	//新增规格信息
	$scope.save=function(){
		
		// 服务返回数据
		var serviceObject;
		
		//新增
		if($scope.entity.specification.id==null){
			serviceObject = specificationService.save($scope.entity);
		}else{
			//修改
			serviceObject =specificationService.updateSpecification($scope.entity);
		}
		
		if(serviceObject.success){
			//重新加载页面
			$scope.reloadList();
		}else{
			alert(serviceObject.message);
		}
	}
	
	//根据Id查询产品规格信息
	$scope.querySpecification=function(id){
		specificationService.querySpecification(id).success(function(response){
			$scope.entity=response;
		});
	}
	
	//批量删除规格信息
	$scope.deleteSpecifications=function(){
		specificationService.deleteSpecifications($scope.selectIds).success(function(response){
			if(response.success){
				//重新加载页面
				$scope.reloadList();
				$scope.selectIds=[];
			}else{
				alert(response.message);
			}
		});
	}
	
	//新增规格选项行
	$scope.addTableRow=function(){
		if(typeof($scope.entity.specificationOptionList)=="undefined"){
			$scope.entity.specificationOptionList=[];
		}else{
			$scope.entity.specificationOptionList.push({});
		}
	}
	
	//删除规格选项行
	$scope.deleTableRow=function(index){
		$scope.entity.specificationOptionList.splice(index,1);
	}
	
});