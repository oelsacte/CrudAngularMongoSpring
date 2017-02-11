var app = angular.module('estanteApp',['ngResource']);

app.controller('libroController',['$scope','$resource', function($scope,$resource){
	function mostrarTodosLibros()
	{
		$scope.libros = $resource('http://localhost:8080/libro').query(function(data){return data;});
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
		
		//libro.id = $scope.personForm.id;
		libro.titulo = $scope.libroForm.titulo;
		libro.autor = $scope.libroForm.autor;
		libro.paginas = $scope.libroForm.paginas;
		
		console.log(libro);
		
		$scope.Message = Libro.save(libro);
		
		//$scope.personForm.id = "";
		$scope.libroForm.titulo = "";
		$scope.libroForm.autor= "";
		$scope.libroForm.paginas= "";		
	};
}]);