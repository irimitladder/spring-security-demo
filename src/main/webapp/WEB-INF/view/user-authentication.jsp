<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Spring Security Demo &mdash; User Authentication</title>
</head>
<body>
    <h1>User Authentication</h1>
    <form:form action="${pageContext.request.contextPath}/processUserAuthentication" method="POST">
        <c:if test="${param.error != null}">
            <div>Invalid name or password! Please, try again.</div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div>You have been logged out.</div>
        </c:if>
        <div><label for="name">Your name:</label><input type="text" id="name" name="username" /></div>
        <div><label for="password">Your password:</label><input type="password" id="password" name="password" /></div>
        <div><input type="submit" value="Login" /></div>
    </form:form>
</body>
</html>