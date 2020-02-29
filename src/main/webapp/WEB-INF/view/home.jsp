<%--
  Created by IntelliJ IDEA.
  User: ShAd0w
  Date: 2/16/2020
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>Spring Security</title>
</head>
<body>

 <h2> Home Page - Yohoo</h2>
 <hr>

 Welcome!
 <hr>
    <p>
        User : <security:authentication property="principal.username"/>
    </p>
    <br>
    <p>
        Role(s) : <security:authentication property="principal.authorities"/>
    </p>
 <hr>

    <security:authorize access="hasRole('MANAGER')">

    <p>
        <a href="${pageContext.request.contextPath}/Leaders"> Leadership Meeting </a>
        (Only for Manager peeps)
    </p>

    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">

    <p>
     <a href="${pageContext.request.contextPath}/Systems"> Systems Meeting </a>
     (Only for Admin peeps)
    </p>

    </security:authorize>
 <hr>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout"/>
</form:form>

</body>
</html>
