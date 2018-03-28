<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<html>
<head>
    <title>Login</title>
    <%@include file="/resources/includes/css.html" %>
</head>
<%@include file="/resources/includes/top.html"%>
<div id="page" class="col-md-12 col-xs-12">
<div id="primary" class="container col-md-8 col-md-offset-2" style="height: 650px">
                <div class="panel-body">
                    <c:if test="${not empty error}">
                        <div>
                            <spring:message code="BadLogin"/><br />
                        </div>
                    </c:if>
                    <form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
                        <fieldset>
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input placeholder="Username" name='username' class="form-control" type="text">
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input placeholder="Password" name='password' class="form-control"  type="password" value="">
                            </div>
                            <input type="submit" class="btn btn-success" value="login">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
<%@include file="/resources/includes/footer.html"%>
</body>
</html>