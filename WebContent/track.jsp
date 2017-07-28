
<div class="container" onload="myFunction()">
    
    <div class="row">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>URL</th>
                <th>PlaCount</th>
                <th>Listeners</th>
                <th>Streamable</th>
                <th>Image</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="track in trackResult">
                <td>{{track.name}}</td>
                <td>{{track.url}}</td>
                <td>{{track.playcount}}</td>
                <td>{{track.listeners}}</td>
                <td>{{track.streamable}}</td>
                <td><a><img src={{track.imagePath}}/></a></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
