<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>论坛主页</title>
    <link href="${ctx}/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx}/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${ctx}/static/css/animate.css" rel="stylesheet">
    <link href="${ctx}/static/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <h3>论坛首页</h3>
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>帖子列表</h5>
                </div>
                <div class="ibox-content">
                    <p>
                        <a class="btn btn-outline btn-default" href="${ctx}/posts">全部板块</a>
                        <a class="btn btn-outline btn-primary" href="${ctx}/posts?category=网络技术">网络技术</a>
                        <a class="btn btn-outline btn-success" href="${ctx}/posts?category=移动开发">移动开发</a>
                        <a class="btn btn-outline btn-info" href="${ctx}/posts?category=web开发">web开发</a>
                        <a class="btn btn-outline btn-warning" href="${ctx}/posts?category=数据库">数据库</a>
                        <a class="btn btn-outline btn-danger" href="${ctx}/posts?category=操作系统">操作系统</a>
                    </p>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>所属板块</th>
                            <th>标题</th>
                            <th>发帖时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="posts" varStatus="status">
                            <tr>
                                <td>${status.index+1}</td>
                                <td>${posts.category}</td>
                                <td>${posts.title}</td>
                                <td>${posts.postTime}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <nav aria-label="Page navigation">

                        <ul class="pagination">
                            <c:forEach begin="1" end="${total}" var="p">
                                <li><a href="${ctx}/posts?category=${category}&page=${p}">${p}</a></li>
                            </c:forEach>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="${ctx}/static/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx}/static/js/bootstrap.min.js?v=3.3.6"></script>
</body>
</html>
