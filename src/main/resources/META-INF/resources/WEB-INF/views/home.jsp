<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Home</title>
</head>
<body>
<a href="<c:url value='/action1'/> ">Simple Request</a>
<hr>
First Action  : <c:out value="${firstAction}" /><br>
Second Action  : <c:out value="${secondAction}" /><br>
<hr>
Bind Action 1 : <c:out value="${firstBindAction}" /><br>
Bind Action 2 : <c:out value="${secondBindAction}" /> <br>
<hr>
[Get from method arguments]<br>
Before Bind : <c:out value="${beforeBindActionFromArgument}" /><br>
Current Bind : <c:out value="${currentBindActionFromArgument}" /> <br>
Before Action : <c:out value="${beforeActionFromArgument}" /> <br>
<hr>
Validating Request:<br>
<c:url value='/validate' var="url"/>
<form:form action="${url}" modelAttribute="demoForm" method="get">
    <form:input path="text"/><form:errors path="text"/><br>
    <form:button>Submit</form:button>
</form:form>
</body>
</html>
