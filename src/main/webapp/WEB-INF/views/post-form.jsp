<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:choose>
        <c:when test="${post.id eq 0}">
            <title>Add post</title>
        </c:when>
        <c:otherwise>
            <title>Edit post ${post.title}</title>
        </c:otherwise>
    </c:choose>
    <%@include file="/resources/includes/css.html" %>
</head>
<%@include file="/resources/includes/top.html" %>
<div id="page" class="col-md-12 col-xs-12">
    <div id="primary" class="col-md-offset-2 col-md-8 col-xs-12" style="height: 650px">
        <form action="/blog_project/admin/post/addNewPost" method="post">
            <form:hidden path="post.id"/>
           <c:if test="${post.id gt 0}">
               <form:hidden path="post.date"/>
           </c:if>
            <spring:bind path="post.title">
                <div class="form-group">
                    <div class="col-md-1"><label for="title">Title: </label></div>
                    <form:input path="post.title" type="text" id="title" required="required" cssStyle="width: 90%;"/>
                </div>
            </spring:bind>
            <spring:bind path="post.content">
                <div class="form-group">
                    <div class="col-md-1"><label for="content">Content: </label></div>
                    <form:textarea path="post.content" required="required" type="text" id="content" cssStyle="width: 90%;
	                                                                                    height: 120px;
	                                                                                border: 3px solid #cccccc;
	                                                                                    padding: 5px;
	                                                                        font-family: Tahoma, sans-serif;"/>
                </div>
            </spring:bind>
            
            
            <div class="form-group col-md-12">
                <c:choose>
                    <c:when test="${post.id eq 0}">
                        <input class="btn btn-primary" type="submit" value="Add"/>
                    </c:when>
                    <c:otherwise>
                        <input class="btn btn-primary" type="submit" value="Edit"/>
                    </c:otherwise>
                </c:choose>
            </div>
            </fieldset>
        </form>
        <a href="/blog_project/admin/"><button class="btn btn-info">Go back to admin menu</button></a>
    </div>
</div>
<%@include file="/resources/includes/footer.html"%>
</body>
</html>
