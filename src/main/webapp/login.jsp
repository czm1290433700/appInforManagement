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
    <title>开发人员登录页面</title>
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
        <span class="logo-head">app信息管理系统开发人员登录页面</span>
    </div>
    <div id="loginbox">
        <form id="loginform" class="form-vertical" action="index.html" />
            <p>输入账户id和密码继续</p>
            <div class="control-group">
                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-user"></i></span><input type="text" placeholder="Id" id="id" name="id"/>
                        <span id="id_alert"></span>
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
                <span class="pull-left" style="margin-right: 15px;"><a href="#" class="flip-link to-phone">&lt; 手机验证登录</a></span>
                <span class="pull-left"><a href="#" class="flip-link to-recover">忘记密码?</a></span>
                <span class="pull-right"><input type="submit" value="登录" id="sub" class="btn btn-inverse" onclick="return loginCheck()"></span>
            </div>
        </form>
        <form id="phoneform" class="form-vertical" action="index.html" />
            <p>输入手机号和收到的验证码继续</p>
            <div class="control-group">
                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-bell"></i></span><input type="text" placeholder="Telephone" id="telephone" name="telephone"/>
                        <span id="telephone_alert"></span>
                    </div>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-ok"></i></span><input type="text" id="verifyCode" name="telephoneCode" placeholder="CheckCode" style="width: 105px;margin-right:15px;"/><button type="button" class="btn" id="go" style="font-size: 12px;">获取验证码</button>
                        <span id="checkCode_alert"></span>
                    </div>
                </div>
            </div>
            <div class="form-actions">
                <span class="pull-left" style="margin-right: 15px;"><a href="#" class="flip-link to-login">&lt; 账号密码登录</a></span>
                <span class="pull-left"><a href="#" class="flip-link to-recover">忘记密码?</a></span>
                <span class="pull-right"><button id="phone_btn" type="button" class="btn btn-inverse">登录</button></span>
            </div>
        </form>
        <form id="recoverform" action="#" class="form-vertical" />
            <p>在下面输入您的邮箱，我们将会发邮箱到您的预存邮箱帮助您找回密码</p>
                <div class="control-group">
                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><i class="icon-envelope"></i></span><input type="text" placeholder="E-mail address" id="email" name="devEmail"/>
                        <span id="email_alert"></span>
                    </div>
                </div>
            </div>
            <div class="form-actions">
                <span class="pull-left" style="margin-right: 20px;"><a href="#" class="flip-link to-login">&lt;账号密码登录</a></span>
                <span class="pull-left"><a href="#" class="flip-link to-phone">手机验证登录&gt;</a></span>
                <span class="pull-right"><button type="button" class="btn btn-inverse" onclick="return emailCheck()">找回密码</button></span>
            </div>
        </form>

        <script src="${ctx}/js/jquery.min.js"></script>
        <script src="${ctx}/js/loginCheck.js"></script>
        <script src="${ctx}/js/unicorn.login.js"></script>
    </div>
</body>
</html>
