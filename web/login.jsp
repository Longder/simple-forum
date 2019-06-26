<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<html>
<head>
    <title>欢迎登录论坛系统</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/font-awesome.css" rel="stylesheet'">
    <link href="${ctx}/static/css/animate.css" rel="stylesheet">
    <link href="${ctx}/static/css/style.css" rel="stylesheet">
</head>
<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">论+</h1>
        </div>
        <h3>欢迎使用 论坛系统</h3>

        <form class="m-t" method="post" action="${ctx}/login">
            <div class="form-group">
                <input type="text" name="loginName" class="form-control" placeholder="用户名"/>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码" name="password"/>
            </div>
            <div class="form-group">
                <p class="mt-5 mb-3 text-danger">${errorMessage}</p>
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            <p class="text-muted text-center">
                <a href="register.jsp">注册一个新账号</a>
            </p>
        </form>
    </div>
</div>

<!-- 全局js -->
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
</body>
</html>
