<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>论坛 - 注册</title>
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/font-awesome.css" rel="stylesheet">
    <link href="${ctx}/static/css/animate.css" rel="stylesheet">
    <link href="${ctx}/static/css/style.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="middle-box text-center loginscreen   animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">论+</h1>
        </div>
        <h3>欢迎注册论坛系统</h3>
        <p>创建一个新账户</p>
        <form class="m-t" id="register-form" method="post" action="${ctx}/register">
            <div class="form-group">
                <input name="name" type="text" class="form-control" placeholder="请输入姓名"/>
            </div>
            <div class="form-group">
                <input name="loginName" type="text" class="form-control" placeholder="请输入登录名"/>
            </div>
            <div class="form-group">
                <input name="password" type="password" class="form-control" placeholder="请输入密码">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="请再次输入密码">
            </div>

            <button type="submit" class="btn btn-primary block full-width m-b">注 册</button>
            <p class="text-muted text-center">
                <small>已经有账户了？</small>
                <a href="${ctx}/">点此登录</a>
            </p>
        </form>
    </div>
</div>

<!-- 全局js -->
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>

<!--Validate-->
<script src="${ctx}/static/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx}/static/js/plugins/validate/messages_zh.min.js"></script>
<script>

    $(function () {
        //注册表单验证
        $("#register-form").validate({
            rules:{
                name:"required",
                loginName:"required",
                password:"required"
            },messages:{
                name:"请输入姓名",
                loginName:"请输入登录名",
                password:"请输入密码"
            }
        });

    });
</script>
</body>
</html>
