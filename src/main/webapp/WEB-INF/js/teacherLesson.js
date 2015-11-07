var TeacherPage = function() {
    var selectedTaskId = "";
    var taskIsSelected = false;

    document.addEventListener("DOMContentLoaded", function(event) {

        document.getElementById("publishTask").onclick = function() {
            //var taskText = document.getElementById("taskText").value;
            sendPostRequest("/teacher/publish-task", selectedTaskId, function(response) { })
        }

        document.getElementById("completeTask").onclick = function() {
            var correctAnswer = document.getElementById("correctAnswer").value;
            sendPostRequest("/teacher/complete-task", correctAnswer, function(response) {
                document.getElementById("taskText").innerHTML =  ""
            })
        }

        initTasksList();
    });

    function initTasksList() {
        var taskSelect = document.getElementById("taskSelect");

        sendGetRequest("/teacher/get-tasks-for-lesson", null, function(response) {
            console.log("tasks loaded")
            fillTasksList(JSON.parse(response));
        })

        taskSelect.onchange = function() {
            console.log("task selected");
            if (this.options[this.selectedIndex].value) {
                var selectedTask = this.options[this.selectedIndex];
                var selectedTaskText = selectedTask.dataset.taskText;
                document.getElementById("taskText").innerHTML = selectedTaskText;
                selectedTaskId = selectedTask.value;
                taskIsSelected = true;
            } else {
                selectedTaskId = "";
                taskIsSelected = false;
                document.getElementById("taskText").innerHTML = "";
            }
        }

        function fillTasksList(tasks) {
            addEmptyTask();
            for (var taskIndex in tasks) {
                var task = tasks[taskIndex];
                var option = document.createElement("option");
                option.value = task.id;
                option.text = task.name;
                option.dataset.taskText = task.description;
                taskSelect.add(option);
            }

            function addEmptyTask() {
                var option = document.createElement("option");
                taskSelect.add(option);
            }
        }
    }

}();
