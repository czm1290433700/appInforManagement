<%--
  Created by IntelliJ IDEA.
  User: 陈祯民
  Date: 2019/8/7
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>登录页面</title>
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
</style>
<body>
    <div id="logo">
        <span class="logo-head">app信息管理系统登录页面</span>
    </div>
    <div id="loginbox">
        <form id="loginform" class="form-vertical" action="index.html" />
        <p>输入用户名和密码继续</p>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-user"></i></span><input type="text" placeholder="Username" />
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-lock"></i></span><input type="password" placeholder="Password" />
                </div>
            </div>
        </div>
        <div class="form-actions">
            <span class="pull-left" style="margin-right: 15px;"><a href="#" class="flip-link to-phone">&lt; 手机验证登录</a></span>
            <span class="pull-left"><a href="#" class="flip-link to-recover">忘记密码?</a></span>
            <span class="pull-right"><input type="submit" class="btn btn-inverse" value="登录" /></span>
        </div>
        </form>
        <form id="phoneform" class="form-vertical" action="index.html" />
        <p>输入手机号和收到的验证码继续</p>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-bell"></i></span><input type="text" placeholder="Telephone" />
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-ok"></i></span><input type="password" placeholder="CheckCode" style="width: 105px;margin-right:15px;"/><button class="btn" id="go" style="font-size: 12px;">获取验证码</button>
                </div>
            </div>
        </div>
        <div class="form-actions">
            <span class="pull-left" style="margin-right: 15px;"><a href="#" class="flip-link to-login">&lt; 账号密码登录</a></span>
            <span class="pull-left"><a href="#" class="flip-link to-recover">忘记密码?</a></span>
            <span class="pull-right"><input type="submit" class="btn btn-inverse" value="登录" /></span>
        </div>
        </form>
        <form id="recoverform" action="#" class="form-vertical" />
        <p>在下面输入您预存的邮箱地址，我们将会发邮箱给您告诉您怎么找回密码</p>
            <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-envelope"></i></span><input type="text" placeholder="E-mail address" />
                </div>
            </div>
        </div>
        <div class="form-actions">
            <span class="pull-left" style="margin-right: 20px;"><a href="#" class="flip-link to-login">&lt;账号密码登录</a></span>
            <span class="pull-left"><a href="#" class="flip-link to-phone">手机验证登录&gt;</a></span>
            <span class="pull-right"><input type="submit" class="btn btn-inverse" value="找回密码" /></span>
        </div>
        </form>

        <script src="${ctx}/js/jquery.min.js"></script>
        <script src="${ctx}/js/unicorn.login.js"></script>
    </div>
</body>
</html>
