<%--
  Created by IntelliJ IDEA.
  User: ShAd0w
  Date: 2/16/2020
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login Form</title>
</head>
<body>

    <h3> Custom Login Page </h3>

    <form:form action="${pageContext.request.contextPath}/authenticateUser"
    method="post">

        <c:if test="${param.error != null}">
            <i>Sorry ! Bad Credentials </i>
        </c:if>


        <p>
            User name: <input type="text" name="username">
        </p>

        <p>
            Password: <input type="password" name="password">
        </p>

        <input type="submit" value="Login"/>

    </form:form>

</body>
</html>
