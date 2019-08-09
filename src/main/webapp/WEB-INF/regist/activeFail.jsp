<%--
  Created by IntelliJ IDEA.
  User: 陈祯民
  Date: 2019/8/8
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>激活失败</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="${ctx}/css/unicorn.login.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
</head>
<style>
    #logo{text-align: center;color:white;font-size:18px;}
    .infor{width:350px;height:120px;line-height: 140px;font-weight: bold;font-size: 20px;margin:0px auto;color:red;}
</style>
<body>
<div id="logo">
    <span class="logo-head">激活信息页面</span>
</div>
<div id="loginbox">
    <div class="infor">抱歉,激活失败</div>
    <div class="form-actions">
        <span class="pull-right"><a href="${ctx}/register.jsp"><button type="button" class="btn btn-danger">重新注册</button></a></span>
    </div>
    <script src="${ctx}/js/jquery.min.js"></script>
</div>
</body>
</html>
