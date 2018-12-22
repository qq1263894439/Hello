app.controller('brandController',function($scope,$controller,brandService){
	
	$controller('baseController',{$scope:$scope});//继承

	/**
	 * 查询所有
	 */
	$scope.findAll=function(){
		brandService.findAll().success(
				function(response){
					$scope.list=response;
				}
		);
	}
	/**
	 * 分页
	 */
	$scope.findPage= function(page,size){
		brandService.findPage(page,size).success(
					function(response){
					$scope.list=response.rows;//显示当前页数据
					$scope.paginationConf.totalItems=response.total//更新总记录数
			});
	}
	
	/**
	 * 查询实体
	 */
	$scope.findOne=function(id){
		brandService.findOne(id).success(
				function(response){
					$scope.entity=response;
				});
	}
	
	$scope.save=function(){
		var object=null;
		if($scope.entity.id != null){
			object=brandService.update($scope.entity);
		}else{
			object=brandService.add($scope.entity);
		}
		object.success(
				function(response){//如果成功
				if(response.success){
					//刷新
					$scope.reloadList();
				}else{
					alert(success,message);//提示错误信息
				}
		});
	}
	/**
	 * 删除
	 */
	$scope.dele=function(){
		//获取选中的复选框
		brandService.dele($scope.selectIds).success(
				function(response){
				if(response.success){
					//刷新
					$scope.reloadList();
				}else{
					alert(success,message);
				}
		});
	}
	/**
	 * 查询+分页
	 */
	$scope.searchEntity={};//定义搜索对象
	$scope.search= function(page,size){
		brandService.search(page,size,$scope.searchEntity).success(
				function(response){
				$scope.list=response.rows;//显示当前页数据
				$scope.paginationConf.totalItems=response.total//更新总记录数
		});
	}
	
	
	
});