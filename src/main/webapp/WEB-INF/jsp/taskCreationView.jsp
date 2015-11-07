<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/style.css">
    <script  src="../js/taskCreation.js" ></script>
    <script  src="../js/common.js" ></script>
</head>
<body>
<div class="row" >
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="base">
            <div>
                <span class="label label-default">Название</span>
            </div>
            <div>
                <input class="fullScreen" id="taskTitle" />
            </div>
        </div>
        <div class="base">
            <div>
                <span class="label label-default">Текст задания</span>
            </div>
            <div>
                <textarea class="fullScreen" id="taskText" ></textarea>
            </div>
            <div>
                <button type="button" id="saveTask">Сохранить задание</button>
            </div>
        </div>
    </div>
    <div class="col-md-1"></div>
</div>
</body>
</html>
