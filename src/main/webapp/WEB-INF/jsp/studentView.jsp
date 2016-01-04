<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../css/style.css" />
    <script  src="../js/student.js" ></script>
    <script  src="../js/common.js" ></script>
</head>
<body>
    <div class="row" >
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="base">
                <div>
                    <span class="label label-default">Задание</span>
                </div>
                <div>
                    <span id="taskText"></span>
                </div>
            </div>
            <div  class="base">
                <div>
                    <span class="label label-default">Введите запрос</span>
                </div>
                <div>
                    <textarea class="fullScreen" id="studentQuery"></textarea>
                </div>
                <div>
                    <button type="button" id="runButton">Выполнить</button>
                </div>
            </div>
            <div  class="base">
                <div>
                    <span class="label label-default">Результат запроса</span>
                </div>
                <div id="queryResult">
                        <table class="table">
                          <tr>
                              <td>Имя</td>
                              <td>Фамилия</td>
                          </tr>
                        </table>
                </div>
                <div>
                    <button type="button" id="checkButton">Отправить на проверку</button>
                </div>
            </div>
            <div class="base">
                <div>
                    <span class="label label-default">Правильное решение</span>
                </div>
                <div>
                    <span id="correctAnswer"></span>
                </div>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
</body>
</html>