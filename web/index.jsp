<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Simple Web Project</title>

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.message" var="message"/>
    <fmt:message bundle="${loc}" key="local.locbutton.name.ru"
                 var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.locbutton.name.en"
                 var="en_button"/>
    <fmt:message bundle="${loc}" key="local.label.login" var="login_label"/>
    <fmt:message bundle="${loc}" key="local.label.password" var="password_label"/>
    <fmt:message bundle="${loc}" key="local.locbutton.login" var="b_login"/>

</head>
<body>

<form action="Controller" method="post" style="float: right">
<input type="hidden" name="command" value="login"/>

<c:out value="${login_label}"/>: <br/>
<input type="text" name="login" value=""/> <br/>

<c:out value="${password_label}"/>: <br/>
<input type="password" name="password" value=""/><br/>

<input type="submit" value="${b_login}"/>
</form>

<form action="Controller" method="post" style="float: left">
    <input type="hidden" name="command" value="change-local"/>
    <input type="hidden" name="local" value="ru"/>
    <input type="submit" value="${ru_button}"/><br/>
</form>

<form action="Controller" method="post">
    <input type="hidden" name="command" value="change-local"/>
    <input type="hidden" name="local" value="en"/>
    <input type="submit" value="${en_button}"/><br/>
</form>
</body>
</html>