angular.module('mrlapp.service.pythongui', [])
.controller('PythonGuiCtrl', ['$log', '$scope', 'mrl', function($log, $scope, mrl) {
    console.log('PythonGuiCtrl');
    
    // get fresh copy
    // basic data set
    var name = $scope.service.name;
    $scope.service = mrl.getService($scope.service.name);
    $scope.name = name;

    // the awesome ace editor 1
    var editor = null ;
    
    //you can access two objects
    //$scope.panel & $scope.service
    //$scope.panel contains some framwork functions related to your service panel
    //-> you can call functions on it, but NEVER write in it
    //$scope.service is your service-object, it is the representation of the service running in mrl
    
    //you HAVE TO define this method &
    //it is the ONLY exception of writing into .gui
    //-> you will receive all messages routed to your service here
    $scope.panel.onMsg = function(msg) {
        switch (msg.method) {
        case 'onPulse':
            $scope.pulseData = msg.data[0];
            $scope.$apply();
            break;
        case 'onClockStarted':
            $scope.label = "Stop";
            $scope.$apply();
            break;
        case 'onClockStopped':
            $scope.label = "Start";
            $scope.$apply();
            break;
        default:
            console.log("ERROR - unhandled method " + msg.method);
            break;
        }
    }
    ;
    
    $scope.aceLoaded = function(e) {
        $log.info("ace loaded");
        // Options
        editor = e;
        //editor.setReadOnly(true);
    }
    ;
    
    $scope.aceChanged = function(e) {
        $log.info("ace changed");
        //
    }
    ;
    
    $scope.execute = function() {
        $log.info("execute");
        mrl.sendTo(name, "exec", editor.getValue());
    }
    ;
    
    //you can subscribe to methods
    mrl.subscribe(name, 'pulse');
    mrl.subscribe(name, 'clockStarted');
    mrl.subscribe(name, 'clockStopped');
    
    //after you're done with setting up your service-panel, call this method
    $scope.panel.initDone();
}
]);