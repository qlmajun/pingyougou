//基本控制层

app.controller('baseController', function($scope) {

	// 重新加载数据
	$scope.reloadList = function() {
		// 切换页码
		$scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
	}

	// 分页控件配置
	$scope.paginationConf = {
		currentPage : 1,
		totalItems : 10,
		itemsPerPage : 10,
		perPageOptions : [ 10, 20, 30, 40, 50 ],
		onChange : function() {
			// 重新加载
			$scope.reloadList();
		}
	};

	// 选中的ID集合
	$scope.selectIds = [];

	// 更新复选
	$scope.updateSelection = function($event, id) {
		if ($event.target.checked) {
			// 如果是被选中,则增加到数组
			$scope.selectIds.push(id);
		} else {
			var idx = $scope.selectIds.indexOf(id);
			// 删除
			$scope.selectIds.splice(idx, 1);
		}
	}
});