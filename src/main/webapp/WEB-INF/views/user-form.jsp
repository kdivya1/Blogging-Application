
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <%@include file="/resources/includes/css.html" %>
</head>
<%@include file="/resources/includes/top.html"%>
<div id="page" class="col-md-12 col-xs-12">
<div id="primary" class="col-md-offset-2 col-md-8 col-xs-12" style="height: 650px">
<form:form modelAttribute="user">
    <form:hidden path="id"/>
    <fieldset>
        <div>
            <label for="username">Username: </label>
            <div class="form">
                <form:input path="username" type="text" id="username" required="required"/>
            </div>
        </div>
        <div>
            <label for="password">password: </label>
            <div class="form">
                <form:password path="password" id="password" required="required"/>
            </div>
        </div>
        <div>
            <c:choose>
                <c:when test="${user.id eq 0}">
                    <input type="submit" value="Add"/>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Edit"/>
                </c:otherwise>
            </c:choose>
        </div>
    </fieldset>
</form:form>
    <a href="/blog_project/admin/"><button class="btn btn-info">Go back to admin menu</button></a>
</div>
</div>
<%@include file="/resources/includes/footer.html"%>
</body>
</html>
