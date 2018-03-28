<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin menu</title>
    <%@include file="/resources/includes/css.html" %>
</head>
<%@include file="/resources/includes/top.html"%>
<div id="page" class="col-md-12 col-xs-12">
<div id="primary" class="col-md-offset-2 col-md-8 col-xs-12" style="height: 650px">
    <c:if test="${duplicate == true}">
    <div class="panel panel-warning">
        <div class="panel-heading">Error!</div>
        Duplicated username!
    </div>
    </c:if>
<div class="panel panel-primary">
    <div class="panel-heading">Posts</div>
<div>
    <a href="/blog_project/admin/post/addNewPost">Add new post</a>
</div>
<div>
    <a href="/blog_project/admin/managePosts?page=1">Manage posts</a>
</div>
</div>
    
    <div class="panel panel-primary">
        <div class="panel-heading">Users</div>
<div>
    <a href="/blog_project/admin/user/addNewUser">Add new user</a>
</div>
<div>
    <a href="/blog_project/admin/manageUsers">Manage users</a>
</div>
    </div>
    <div>
        <a href=<c:url value="/j_spring_security_logout"/>> <button class="btn btn-danger">Logout</button> </a>
    </div>
</div>
</div>
<%@include file="/resources/includes/footer.html"%>
</body>
</html>
