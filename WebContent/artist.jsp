 <div class="row">
        <form class="form-inline">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon">Country Name:</div>
                    <input type="text" class="form-control" id="CountrySearch" placeholder="Country" ng-model="country">
                </div>
            </div>
            <button class="btn btn-primary" ng-click="search()">Search</button>
        </form>
    </div>
    <div class="row">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>URL</th>
                <th>thumbNail</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="artist in artistResult">
                <td>{{artist.name}}</td>
                <td>{{artist.url}}</td>
                <td><a ng-click="fetchDetails(artist.name)" ><img src={{artist.imagePath}}/></a></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <pagination
                    ng-model="currentPage"
                    total-items="artistData.length"
                    max-size="maxSize"
                    class="pagination-sm"
                    boundary-links="true">
            </pagination>
        </div>
    </div>