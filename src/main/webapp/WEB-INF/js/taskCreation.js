var TeacherPage = function() {
    document.addEventListener("DOMContentLoaded", function(event) {

        document.getElementById("saveTask").onclick = function() {
            var taskTitle = document.getElementById("taskTitle").value;
            var taskText = document.getElementById("taskText").value;
            var data = {
                name: taskTitle,
                taskText: taskText
            };
            sendPostRequest("/task-management/save-task", data, function(response) {
                document.getElementById("taskTitle").value =  "";
                document.getElementById("taskText").value =  "";
            })
        }

    });

}();
