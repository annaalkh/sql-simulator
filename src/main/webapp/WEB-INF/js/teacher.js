var TeacherPage = function() {
    document.addEventListener("DOMContentLoaded", function(event) {

        document.getElementById("publishTask").onclick = function() {
            var taskText = document.getElementById("taskText").value;
            sendPostRequest("/teacher/publish-task", taskText, function(response) { })
        }

        document.getElementById("completeTask").onclick = function() {
            var correctAnswer = document.getElementById("correctAnswer").value;
            sendPostRequest("/teacher/complete-task", correctAnswer, function(response) {
                document.getElementById("taskText").innerHTML =  ""
            })
        }

    });

}();
