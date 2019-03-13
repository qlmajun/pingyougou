//品牌控制层
app.controller('brandController', function($scope, $controller, brandService) {

	// 继承
	$controller('baseController', {
		$scope : $scope
	});

	// 分页查询品牌信息
	$scope.findPage = function(pageNum, pageSize) {
		brandService.findPage(pageNum, pageSize).success(function(response) {
			$scope.list = response.rows;
			// 更新总记录数
			$scope.paginationConf.totalItems = response.total;
		});
	}

	// 新增品牌
	$scope.save = function() {

		// 服务返回数据
		var serviceObject;

		// 修改数据
		if ($scope.entity.id != null) {
			serviceObject = brandService.update($scope.entity);
		} else {
			serviceObject = brandService.save($scope.entity);
		}

		if (serviceObject.success) {
			// 重新加载列表
			$scope.reloadList();
		} else {
			alert(response.message);
		}
	}

	// 根据Id获取品牌信息
	$scope.findOne = function(id) {
		brandService.findOne(id).success(function(response) {
			$scope.entity = response;
		});
	}

	// 批量删除品牌信息
	$scope.deleteBrands = function(ids) {
		brandService.deleteBrands(ids).success(function(response) {
			if (response.success) {
				// 重新加载列表
				$scope.reloadList();
				$scope.selectIds = [];
			} else {
				alert(response.message);
			}
		});
	}

	// 定义搜索对象
	$scope.searchEntity = {};

	// 条件查询品牌信息
	$scope.search = function(pageNum, pageSize) {
		brandService.search(pageNum, pageSize, $scope.searchEntity).success(
				function(response) {
					$scope.list = response.rows;
					// 更新总记录数
					$scope.paginationConf.totalItems = response.total;
				});
	}
});