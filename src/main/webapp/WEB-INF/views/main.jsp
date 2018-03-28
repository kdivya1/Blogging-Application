<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <title>Blog main page</title>
    <meta name="description" content="Blog written in Java language with Spring framework"/>
    <%@include file="/resources/includes/css.html" %>
</head>
<%@include file="/resources/includes/top.html"%>
<div id="page" class="col-md-12 col-xs-12">
    <div id="primary" class="col-md-offset-2 col-md-8 col-xs-12">
        <div class="container-fluid">
            <div class="row">
                <div id="posts">
                    <c:if test="${empty posts}">
                        <div>
                            There are no posts
                        </div>
                    </c:if>
                    <hr>
                    <c:forEach var="post" items="${posts}">
                        <div id="post-${post.id}" class="post col-md-12">
                            <hr>
                            <header class="entry-header">
                                <h2 class="entry-title">
                                    <a href="/blog_project/post/id/${post.id}" rel="bookmark">${post.title}</a>
                                </h2>
                                
                                
                              
                            </header>
                            <div class="entry-content">
                                    ${post.content} <a href="/blog_project/post/id/${post.id}" rel="bookmark">Read more</a>
                                    <%--End of post content--%>
                            </div>
                            <div class="entry-footer">
                                <h5>Written by <b><a href="/blog_project/post/user/${post.id_user}?page=1">${post.username}</a></b>
                                    <b>date: </b> ${post.date}</h5>
                                    <%--End of post footer--%>
                            </div>
                        </div>
                         
                        
                        <hr/>
                        <%--End of posts--%>
                    </c:forEach>
                </div>
                <c:if test="${listOfPages.size() > 1}">
                    <div id="pages" class="col-md-10 col-xs-8">
                        <h3>Pages: </h3>
                       
                                    <c:forEach var="page" items="${listOfPages}">
                                    <c:if test="${(page+1)==currentPage}">
                                        <button class="btn btn-primary disabled btn-lg">${page+1}</button>
                                    </c:if>
                                    <c:if test="${(page+1)!=currentPage}">
                                        <a href="/blog_project/blog?page=${page+1}"> <button class="btn btn-primary btn-lg active">${page+1}</button></a>
                                    </c:if>
                                </c:forEach>
                           
                        
                            <%--End of pages--%>
                    </div>
                </c:if>
            </div>
        </div>

    </div>

    <%--End of main page--%>
</div>
</body>

</html>