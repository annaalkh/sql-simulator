<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/style.css">
    <script  src="../js/teacherLesson.js" ></script>
    <script  src="../js/common.js" ></script>
</head>
<body>
<div class="row" >
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="base">
            <div>
                <span class="label label-default">Выберите задание</span>
            </div>
            <div>
                <select class="fullScreen" id="taskSelect" ></select>
            </div>
        </div>
        <div class="base">
            <div>
                <span class="label label-default">Текст задания</span>
            </div>
            <div>
                <textarea class="fullScreen" id="taskText" disabled></textarea>
            </div>
            <div>
                <button type="button" id="publishTask">Опубликовать задание</button>
            </div>
        </div>
        <div class="base">
            <div>
                <span class="label label-default">Результаты студентов</span>
            </div>
            <div>
                <table class="table">
                    <tr>
                        <td>Студент</td>
                        <td>Запрос</td>
                        <td>Результат</td>
                    </tr>
                    <tr>
                        <td>aivenov</td>
                        <td>Select * from students</td>
                        <td>num1</td>
                    </tr>
                </table>
            </div>
            <div class="base">
                <div>
                    <span class="label label-default">Правильный ответ</span>
                </div>
                <div>
                    <textarea class="fullScreen" id="correctAnswer"></textarea>
                </div>
            </div>
            <div>
                <button type="button" id="completeTask">Завершить задание</button>
            </div>
        </div>
    </div>
    <div class="col-md-1"></div>
</div>
</body>
</html>
