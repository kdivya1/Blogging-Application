<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <title>${post.title}</title>
    <%@include file="/resources/includes/css.html" %>
</head>
<%@include file="/resources/includes/top.html"%>
<header>
</header>
<div id="page" class="col-md-12 col-xs-12">
    <div id="primary" class="col-md-offset-2 col-md-8 col-xs-12">
            <main id="main">
                <div class="row">
                <div class="col-md-10">
                    <article id="post-${post.id}">
                        <div class="inside-article">
                            <header class="entry-header">
                                <h2 class="entry-title"><a href="/post/id/${post.id}" rel="bookmark">${post.title}</a></h2>
                                <div class="panel"><b>Author: </b><a href="/post/user/${post.id_user}?page=1">${post.username}</a> </div>
                            </header>

                            <div class="entry-content" itemprop="text">
                                    ${post.content}
                            </div>

                            <footer class="entry-footer">
                            </footer>
                        </div>
                    </article>
                </div>
                
                  
                </div>
                
                <div id="add_comment col-md-8" class="panel panel-default">
                    <div class="panel-heading">Add comment</div>
                    <form:form modelAttribute="newComment">
                        <fieldset>
                            <div>
                                <label for="username">Name: </label>
                                <div class="form">
                                    <form:input path="author" type="text" id="username" />
                                </div>
                            </div>
                            <div>
                                <label for="username">Comment: </label>
                                <div class="form">
                                    <form:textarea path="content" type="text" id="content"/>
                                </div>
                            </div>
                            <div>
                                <div class="form">
                                    <input type="submit" value="Submit"/>
                                </div>
                            </div>
                        </fieldset>
                    </form:form>
                </div>
                <div id="comments" class="panel panel-default col-md-12">
                    <div class="panel-heading">Comments</div>
                    <c:forEach var="comment" items="${comments}">
                        <div class="comment col-md-8">
                            <div class="comment_header">
                                <h5><b>Author:</b> ${comment.author} <b>IP:</b> ${comment.ip} <b>Date:</b> ${comment.date}</h5>
                            </div>
                            <div class="comment_content">
                                ${comment.content}
                            </div>
                            <hr>
                        </div>
                    </c:forEach>
                </div>
            </main>
        </div>
</div>

</body>
<footer>

</footer>
</html>
