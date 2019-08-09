<%--
  Created by IntelliJ IDEA.
  User: 陈祯民
  Date: 2019/8/9
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>管理员登录页面</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="${ctx}/css/unicorn.login.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
</head>
<style>
    .input-prepend input[type = 'text']{height:29px;}
    .input-prepend input[type = 'password']{height:29px;}
    #logo{text-align: center;color:white;font-size:18px;}
    .input-prepend{font-size: 14px!important;}
    .input-prepend span{line-height: 30px;}
</style>
<body>
<div id="logo">
    <span class="logo-head">app信息管理系统管理员登录页面</span>
</div>
<div id="loginbox">
    <form id="loginform" class="form-vertical" action="/admin/index" />
        <p>输入账户id和密码继续</p>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-user"></i></span><input type="text" placeholder="UserCode" id="userCode" name="userCode"/>
                    <span id="userCode_alert"></span>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-lock"></i></span><input type="password" placeholder="Password" id="password" name ="password"/>
                    <span id="password_alert"></span>
                </div>
            </div>
        </div>
        <div class="form-actions">
            <span class="pull-right"><input type="submit" value="登录" id="sub" class="btn btn-inverse" onclick="return adminLoginCheck()"></span>
        </div>
    </form>

    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/loginCheck.js"></script>
    <script src="${ctx}/js/unicorn.login.js"></script>
</div>
</body>
</html>

