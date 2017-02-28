


app.controller('libroController',['$scope',, function($scope){
	function mostrarTodosLibros()
	{
		$scope.libros = $resource('http://localhost:8080/libro').query(function(data){console.log(data);return data;});
	};
	
	mostrarTodosLibros();
	
	$scope.refresh = function(){
		mostrarTodosLibros();
	};
	
	$scope.create = function(){
		console.log("Invocación a Angular create");
		Libro = $resource('http://localhost:8080/create',{},{save: {method:'PUT',isArray:false}});
		console.log("Libro cargado");
		
		console.log("El libro es " +Libro);
		
		var libro = {};
		
		libro.id = $scope.libroForm.id;
		libro.titulo = $scope.libroForm.titulo;
		libro.autor = $scope.libroForm.autor;
		libro.paginas = $scope.libroForm.paginas;
		
		console.log(libro);
		
		$scope.Message = Libro.save(libro);
		
		$scope.libroForm.id = "";
		$scope.libroForm.titulo = "";
		$scope.libroForm.autor= "";
		$scope.libroForm.paginas= "";		
	};
	
	$scope.deleteRec = function(){
		Libro = $resource('http://localhost:8080/delete/:id',{},{save: {method: 'DELETE', params: {id: '@id'}}});
		
		Libro.delete({id: $scope.libroForm.id}).then(function successCallback(response){
			$scope.Message = response;
		}, function errorCallback(response){
			console.log("Cruza por error CallBack");
		});
		
		$scope.libroForm.id = "";
		$scope.libroForm.titulo = "";
		$scope.libroForm.autor= "";
		$scope.libroForm.paginas= "";		
	}
	
	$scope.update = function(){
		Libro = $resource(
    		    "http://localhost:8080/update/:id",{},{save: {method:'PUT', params: {id: '@id'}}}
    	);
		
		var libro = {};
		
		libro.id = $scope.personForm.id;
		libro.titulo = $scope.libroForm.titulo;
		libro.autor = $scope.libroForm.autor;
		libro.paginas = $scope.libroForm.paginas;
		
		console.log(libro);
		
		$scope.Message = Libro.save(libro);
		
		$scope.libroForm.id = "";
		$scope.libroForm.titulo = "";
		$scope.libroForm.autor= "";
		$scope.libroForm.paginas= "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}]);
