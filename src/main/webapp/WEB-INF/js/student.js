var StudentPage = function() {
    document.addEventListener("DOMContentLoaded", function(event) {
        sendGetRequest("/student/current-task", null, function(response) {
            updateCurrentTask(JSON.parse(response));
        });

        document.getElementById("runButton").onclick = function() {
            var query = document.getElementById("studentQuery").value;
            sendPostRequest("/student/run-query", query, function(response) {
                document.getElementById("queryResult").innerHTML = response;
            })
        }
    });

    function updateCurrentTask(task) {
        document.getElementById("taskText").innerHTML =  task.taskText;
        document.getElementById("studentQuery").innerHTML =  "";
    }

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

}();
