<div>
    <div class="container">
        <div style="padding-bottom:50px">
            <table style="width:100%">
                <tbody>
                    <tr>					
                        <td style="width:45%;padding-left:40px;vertical-align: top">
                            <div style="padding-bottom:20px">
                                <h3>Add a Student</h3>
                            </div>
                            <form class="form-horizontal ng-valid ng-dirty" role="form" ng-submit="addStudent()">
                                <div class="form-group">
                                    <label class="col-md-5 control-label">Last Name</label>
                                    <div class="col-md-4">
                                        <input class="form-control ng-valid ng-dirty" name="lName" ng-model="lName" type="text" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-5 control-label">First Name</label>
                                    <div class="col-md-4">
                                        <input class="form-control ng-valid ng-dirty" name="fName" ng-model="fName" type="text" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-5 control-label">Date of birth</label>
                                    <div class="col-md-4">
                                        <input class="form-control ng-valid ng-dirty" name="dob" ng-model="dob" type="text" required>
                                    </div>
                                </div>
                                <div class="form-group">								
                                    <div ng-show="sho1">
                                        <input value="Submit" class="btn btn-primary" type="submit">
                                    </div>
                                    <div ng-show="sho2">
                                        <input name="sid" ng-model="sid" type="hidden">
                                        <input value="Update" class="btn btn-primary" type="button"  ng-click="updet()">
                                    </div>
                                </div>
                            </form>
                        </td>
                        <td style="vertical-align: top">
                            <table class="table">
                                <tbody><tr style="text-align: center">
                                        <th><div style="text-align: center">Last Name</div>
                                        </th>
                                        <th><div style="text-align: center">First Name</div>
                                        </th>
                                        <th><div style="text-align: center">Date of birth</div>
                                        </th>
                                        <th><div style="text-align: center">Update</div>
                                        </th>
                                        <th><div style="text-align: center">Delete</div>
                                        </th>
                                    </tr>
                                    <tr ng-repeat="x in myWelcome">
                                        <td>{{ x.FName}}</td>
                                        <td>{{ x.LName}}</td>
                                        <td>{{ x.dob}}</td>
                                        <td><input type="radio" name="del" ng-click="upd($event)" data="{{x.FName}}~{{x.LName}}~{{x.dob}}~{{x.SId}}">
                                        </td>
                                        <td><input type="radio" name="del" ng-click="del($event)" data="{{x.FName}}~{{x.LName}}~{{x.SId}}">
                                        </td>
                                    </tr>
                                </tbody></table>
                        </td>
                    </tr>
                </tbody></table>
        </div>
        <div>

        </div>
    </div>
</div>

