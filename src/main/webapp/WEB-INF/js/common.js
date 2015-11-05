function sendGetRequest(url, data, successCallback) {
    sendRequest("GET", url, data, successCallback);
}

function sendPostRequest(url, data, successCallback) {
    sendRequest("POST", url, data, successCallback);
}

function sendRequest(method, url, data, successCallback) {
    var anHttpRequest = new XMLHttpRequest();
    anHttpRequest.onreadystatechange = function() {
        if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
            successCallback(anHttpRequest.responseText);
    }

    anHttpRequest.open(method, url, true );
    anHttpRequest.send(data);
}