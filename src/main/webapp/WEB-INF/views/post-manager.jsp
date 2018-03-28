<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post manager</title>
    <%@include file="/resources/includes/css.html" %>
</head>
<%@include file="/resources/includes/top.html"%>
<div id="page" class="col-md-12 col-xs-12">
<div id="primary" class="col-md-offset-2 col-md-8 col-xs-12" style="height: 650px">
    <div class="container">
    <table class="table">
        <thead>
        <tr>
        <th>Post title</th>
        <th>Edit</th>
        <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="post" items="${posts}">
            <c:url var="editPost" value="/admin/post/editPost">
                <c:param name="postId" value="${post.id}"/>
            </c:url>
            <c:url var="deletePost" value="/admin/post/deletePost">
                <c:param name="postId" value="${post.id}"/>
            </c:url>
            <tr>
                <td>${post.title}</td>
                <td><a href="${editPost}">Edit</a></td>
                <td><a href="${deletePost}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        <div>
            <a href="/blog_project/admin/post/deleteAllPosts"><button class="btn btn-warning">Delete all posts</button></a>
        </div>
    <div id="pages">
        <h2>Pages:</h2>
                <c:forEach var="page" items="${listOfPages}">
                    <c:if test="${(page+1)==currentPage}">
                        <button class="btn btn-primary disabled">${page+1}</button>
                    </c:if>
                    <c:if test="${(page+1)!=currentPage}">
                        <a href="/blog_project/admin/managePosts?page=${page+1}"> <button class="btn btn-primary">${page+1}</button> </a>
                    </c:if>
                </c:forEach>
    </div>
</div>
    <div class="col-md-12">
    <a href="/blog_project/admin/"><button class="btn btn-info">Go back to admin menu</button></a>
    </div>
</div>
</div>
<%@include file="/resources/includes/footer.html"%>
</body>
</html>
