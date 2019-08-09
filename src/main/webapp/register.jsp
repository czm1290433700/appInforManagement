<%--
  Created by IntelliJ IDEA.
  User: 陈祯民
  Date: 2019/8/8
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>注册页面</title>
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
    <span class="logo-head">欢迎注册</span>
</div>
<div id="loginbox" style="height:410px;">
    <form id="registerform" class="form-vertical" action="${ctx}/doRegister">
        <p>填写信息表后继续</p>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-user"></i></span><input type="text" placeholder="UserName" id="username" name="username" onblur="userNameCheck()"/>
                    <span id="username_alert"></span>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-lock"></i></span><input type="password" placeholder="Password" id="password" name ="password" onblur="CheckIntensity()"/>
                    <span id="password_alert"></span>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-lock"></i></span><input type="password" placeholder="Confirm Password" id="okpassword" name ="okpassword" onblur="okPwdCheck()"/>
                    <span id="okpassword_alert"></span>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-bell"></i></span><input type="text" placeholder="Telephone" id="telephone" name="telephone" onblur="checkPhone()"/>
                    <span id="telephone_alert"></span>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-envelope"></i></span><input type="text" placeholder="E-mail address" id="email" name="email" onblur="checkEmail()"/>
                    <span id="email_alert"></span>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-ok"></i></span><input type="text" id="code" name="code" placeholder="CheckCode" onblur="checkCode()"/>
                    <span id="code_alert"></span>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <div>
                        <IMG id="captchaImg" style="CURSOR: pointer"
                             onclick="changeCaptcha()"
                             title="看不清楚?请点击刷新验证码!" align='absmiddle' src="${ctx}/captchaServlet"
                             height="18" width="55">
                        <a href="javascript:;"
                           onClick="changeCaptcha()" style="color: #666;">看不清楚</a> <span id="code_span" style="color: red"></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <div style="width: 100%;height: 20px;">
                        <span id="all_alert"></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-actions">
            <span class="pull-left" style="margin-right: 20px;"><a href="login.jsp" class="flip-link to-login">&lt;已有账号</a></span>
            <span class="pull-right"><button id="to_register" type="button" class="btn btn-inverse">注册</button></span>
        </div>
    </form>

    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/loginCheck.js"></script>
</div>
</body>
</html>
