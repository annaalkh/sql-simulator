<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Test task</h1>
<form:form modelAttribute="task" action="test-task">
    Task Name: <form:input path="name"></form:input>
    Task description: <form:input path="description"></form:input>
    Task active? <form:checkbox path="active"></form:checkbox>
    <form:button>Submit</form:button>
</form:form>

</body>
</html>