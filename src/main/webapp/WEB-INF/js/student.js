var StudentPage = function() {
    var currentTask = {};
    document.addEventListener("DOMContentLoaded", function(event) {
        refreshCurrentTask();
        setInterval(refreshCurrentTask, 5000);

        document.getElementById("runButton").onclick = function() {
            var query = document.getElementById("studentQuery").value;
            sendPostRequest("/student/run-query", query, function(response) {
                document.getElementById("queryResult").innerHTML = response;
            })
        }
    });

    function refreshCurrentTask() {
        sendGetRequest("/student/current-task", null, function(response) {
            updateCurrentTask(JSON.parse(response));
        });
    }

    function updateCurrentTask(task) {
        if (task.id != currentTask.id) {
            currentTask = task;
            document.getElementById("taskText").innerHTML =  task.description;
            document.getElementById("studentQuery").innerHTML =  "";
            document.getElementById("runButton").disabled = false;
        }
        if (task.correctAnswer) {
            document.getElementById("correctAnswer").innerHTML =  task.correctAnswer;
            document.getElementById("runButton").disabled = true;
        }
    }

}();
