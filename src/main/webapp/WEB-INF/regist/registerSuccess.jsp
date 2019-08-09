<%--
  Created by IntelliJ IDEA.
  User: 陈祯民
  Date: 2019/8/8
  Time: 18:09
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
    #logo{text-align: center;color:white;font-size:18px;}
</style>
<body>
<div id="logo">
    <span class="logo-head">注册成功页面</span>
</div>
<div id="loginbox" style="height:240px;">
    <p>恭喜注册成功!</p><br>
    <span style="font-size: 15px;font-weight: bold;padding: 20px;">激活邮件已经发送到您的注册邮箱${message.split(",")[0]},点击邮件里的链接即可激活账号。</span><br><br>
    <button style="font-size:12px;" class="btn btn-primary" type="button" onclick="lookEmail('${message}');">立即查看邮件</button>
    <div class="form-actions">
        还没收到邮件？您可以选择
        <span class="pull-right"><a id="btn" onclick="reRegist();">重新注册</a></span>
        <span class="pull-right" style="padding-right: 15px;"><a id="reBtn" onclick="reSendEmail('${message}')">重新发送邮件</a></span>
    </div>
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/register.js"></script>
</div>
</body>
</html>
