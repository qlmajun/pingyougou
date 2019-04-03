//登入服务层
app.service('loginService', function($http) {
	
	//读取登入人名称
	this.loginName=function(){
		return $http.get('../rest/login/name');
	}
});