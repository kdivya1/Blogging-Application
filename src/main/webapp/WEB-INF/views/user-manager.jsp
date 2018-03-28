<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories manager</title>
    <%@include file="/resources/includes/css.html" %>
</head>
<%@include file="/resources/includes/top.html"%>
<div id="page" class="col-md-12 col-xs-12">
<div id="primary" class="col-md-offset-2 col-md-8 col-xs-12" style="height: 650px">
    <table class="table">
        <tr>
            <th>Username</th>
            <th>Change password</th>
            <th>Delete</th>
            <th>Warning</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <c:url var="editUser" value="/admin/user/editUser">
                <c:param name="userId" value="${user.id}"/>
            </c:url>
            <c:url var="deleteUser" value="/admin/user/deleteUser">
                <c:param name="userId" value="${user.id}"/>
            </c:url>
            <tr>
                <td>${user.username}</td>
                <c:choose>
                    <c:when test="${user.username == username}">
                        <td><a href="${editUser}">Edit</a></td>
                    </c:when>
                    <c:otherwise>
                        <td>You can't other users password</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${user.username == 'admin'}">
                        <td>Can't delete admin</td>
                        <td>Can't delete</td>
                    </c:when>
                    <c:when test="${user.username == currentUser}">
                        <td>You can't delete yourself</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="${deleteUser}">Delete</a></td>
                        <td>It will delete post written by this user!</td>
                    </c:otherwise>
                </c:choose>

            </tr>
        </c:forEach>
    </table>
    <a href="/blog_project/admin/"><button class="btn btn-info">Go back to admin menu</button></a>
</div>
</div>
<%@include file="/resources/includes/footer.html"%>
</body>
</html>