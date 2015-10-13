<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Test page MVC</h1>
<form:form modelAttribute="person" action="/test-mvc">
    Name: <form:input path="name"></form:input>
    Surname: <form:input path="surname"></form:input>
    <form:button>Submit</form:button>
</form:form>

</body>
</html>
