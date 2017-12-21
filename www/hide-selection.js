module.exports = {
    disableContextMenu: function (successCallback, errorCallback) {      
        cordova.exec(successCallback, errorCallback, "HideSelection", "hideMenu", []);
    },
    enableContextMenu: function (successCallback, errorCallback) {      
        cordova.exec(successCallback, errorCallback, "HideSelection", "showMenu", []);
    }
};
