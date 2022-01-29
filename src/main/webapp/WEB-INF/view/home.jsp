<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Spring Security Demo</title>
</head>
<body>
    <h1>Spring Security Demo</h1>
    <security:authorize access="hasRole('ENGINEER')">
        <div><a href="${pageContext.request.contextPath}/system">View system info</a> (for engineers only)</div>
    </security:authorize>
    <security:authorize access="hasRole('MANAGER')">
        <div><a href="${pageContext.request.contextPath}/leaders">View leaders</a> (for managers only)</div>
    </security:authorize>
    <p>Welcome to the Spring Security Demo home page, <security:authentication property="principal.username" />.<br>Your role(s): <security:authentication property="principal.authorities" /></p>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <div><input type="submit" value="Logout" /></div>
    </form:form>
</body>
</html>