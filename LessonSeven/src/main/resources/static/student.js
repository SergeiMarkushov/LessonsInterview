
angular.module('app', []).controller('studentController', function ($scope, $http) {
    const contextPath = 'http://localhost:8282/api/v1';

    $scope.loadStudents = function () {
        $http.get(contextPath + '/students')
            .then(function (response) {
                console.log(response.data);
                $scope.StudentsList = response.data;
            });
    };

    $scope.deleteStudent = function (studentId) {
        $http.delete(contextPath + '/students/' + studentId)
            .then(function (response) {
                $scope.loadStudents();
            });
    }

    $scope.updateStudent = function () {
        $http.post(contextPath + '/students', $scope.newStudent)
            .then(function (response) {
                $scope.loadStudents();
            });
    };
    $scope.infoStudent = function (studentId) {
        $http.get(contextPath + '/students/' + studentId)
            .then(function (response) {
                alert(response.data.name + " " + response.data.age)
            });
    }


    $scope.loadStudents();

});