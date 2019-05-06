
var app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
            .when("/student", {
                templateUrl: "student.jsp",
                controller: "student"
            })
            .when("/home", {
                template: "<h1>Smart Student App</h1><p>Developed by Kayongo Ivan</p>"
            });
});

app.controller('student', function ($scope, $http) {
    $scope.sho1 = true;
    $scope.sho2 = false;
    $http.get("/webArch/resources/school")
            .then(function (response) {
                $scope.myWelcome = response.data;
            });
            
    $scope.addStudent = function () {
        var dataObj = {
            sId: null,
            lName: $scope.lName,
            fName: $scope.fName,
            dob: $scope.dob
        };
        var res = $http.post('/webArch/resources/school', dataObj);
        res.success(function (data) {
            $scope.myWelcome = data;
        });
        res.error(function (data) {
            console("failure message: " + JSON.stringify({data: data}));
        });
        // Making the fields empty
        //
        $scope.lName = '';
        $scope.fName = '';
        $scope.dob = '';
    };
    
    $scope.del = function ($event) {
        var st = $event.target.attributes.data.value.split('~');
        if (confirm("Delete " + st[0] + " " + st[1])) {
            var dataObj = {
                sId: st[2]
            };
            var res = $http.delete('/webArch/resources/school/' + st[2], dataObj);
            res.success(function (data) {
                $scope.myWelcome = data;
            });
            res.error(function (data) {
                console("failure message: " + JSON.stringify({data: data}));
            });
        }
    }
    $scope.upd = function ($event) {
        var st = $event.target.attributes.data.value.split('~');
        $scope.lName = st[0];
        $scope.fName = st[1];
        $scope.dob = st[2];
        sId:$scope.sid = st[3];
        $scope.sho1 = false;
        $scope.sho2 = true;
    }
    $scope.updet = function () {
        var dataObj = {
            sId: $scope.sid,
            lName: $scope.lName,
            fName: $scope.fName,
            dob: $scope.dob
        };
        var res = $http.put('/webArch/resources/school', dataObj);
        res.success(function (data) {
            $scope.myWelcome = data;
        });
        res.error(function (data) {
            console("failure message: " + JSON.stringify({data: data}));
        });
        // Making the fields empty
        //
        $scope.lName = '';
        $scope.fName = '';
        $scope.dob = '';
        $scope.sho1 = true;
        $scope.sho2 = false;
    };
});