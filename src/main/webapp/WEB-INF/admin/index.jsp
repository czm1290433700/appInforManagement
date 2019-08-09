<%--
  Created by IntelliJ IDEA.
  User: HU
  Date: 2019/8/8
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>Unicorn Admin</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="${ctx}/css/fullcalendar.css" />
    <link rel="stylesheet" href="${ctx}/css/unicorn.main.css" />
    <link rel="stylesheet" href="${ctx}/css/unicorn.grey.css" class="skin-color" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<style>
    td{
        　vertical-align: middle !important;
    }
</style>
<body>


<div id="header">
    <h1><a href="./dashboard.html">Unicorn Admin</a></h1>
</div>

<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav btn-group">
        <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-user"></i> <span class="text">${backendUser.username}</span></a></li>
        <li class="btn btn-inverse"><a title="" href="${ctx}/logout"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
    </ul>
</div>

<div id="sidebar">
    <a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
    <ul>

        <li class="submenu">
            <a href="${ctx}/admin/index"><i class="icon icon-th-list"></i> <span>审核管理</span> </a>
        </li>
        <li class="submenu">
            <a href="#"><i class="icon icon-file"></i> <span>轮播图管理</span> </a>
        </li>

    </ul>

</div>

<div id="style-switcher">
    <i class="icon-arrow-left icon-white"></i>
    <span>Style:</span>
    <a href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
    <a href="#blue" style="background-color: #2D2F57;"></a>
    <a href="#red" style="background-color: #673232;"></a>
</div>


<div id="content">
    <div id="breadcrumb">
        <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
        <a href="#" class="tip-bottom">审核管理</a>
        <a href="#" class="current">审核</a>
    </div>

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-title">
                        <a href="${ctx}/admin/index" class="btn btn-danger btn-mini">未审核</a> <a href="${ctx}/admin/passList" class="btn btn-success btn-mini">已审核</a>
                    </div>
                    <div class="container-fluid">
                        <table  class="table table-condensed">
                            <div class="row">
                                <!-- On rows -->
                                <tr class="active"> <td class="active">#</td><td class="active">Logo</td>  <td class="active">软件名称</td> <td class="active">大小(M)</td><td class="active">APK名</td><td class="active">三级分类</td><td class="col-sm-2 active">下载链接</td><td class="col-sm-1 active">开发者id</td><td class="col-sm-1 active">ROM</td><td class="col-sm-1 active">平台</td><td class="active">语言</td><td class="col-sm-1 active">审核结果</td><td class="active"> 操作</td></tr>
                            </div>
                            <div class="row">
                                <c:forEach items="${appInfoExampleList }" var="item" varStatus="status">
                                <tr>
                                    <td class="success">${status.index+1}</td>
                                    <td class="success"><img src="${ctx}/${item.appInfo.logoPicPath }"></td>
                                    <td class="success">${item.softwareName }</td>
                                    <td class="success">${item.softWareSize}</td>
                                    <td class="success">${item.apkName}</td>
                                    <td class="success">${item.categoryName}</td>
                                    <td class="success"><a href="${ctx}/${item.downloadLink}">下载</a></td>
                                    <td class="success">${item.devId}</td>
                                    <td class="success">${item.supportRom}</td>
                                    <td class="success">
                                        <c:if test="${item.floatFormId==9 }">
                                        手机
                                    </c:if>
                                        <c:if test="${item.floatFormId==10 }">
                                            平板
                                        </c:if>
                                        <c:if test="${item.floatFormId==14 }">
                                           通用
                                        </c:if>
                                    </td>
                                    <td class="success">${item.interfaceLanguage}</td>
                                    <td class="success">
                                            ${item.valueName}
                                    </td>
                                    <td class="success">
                                        <c:if test="${item.status==4 or item.status==6}">
                                            <a href="${ctx}/admin/checkPass/${item.id}" class="btn btn-primary btn-mini" >通过</a>
                                        </c:if>
                                        <c:if test="${item.status!=7 and item.status!=8}">
                                        &nbsp;<a href="${ctx}/admin/checkNotPass/${item.id}" class="btn btn-warning btn-mini">不通过</a></td>
                                        </c:if>
                                </tr>
                            </c:forEach>

                        </div>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="row-fluid">
            <div id="footer" class="span12">
                2019 &copy; Unicorn Admin. Brought to you by <a href="https://wrapbootstrap.com/user/diablo9983">diablo9983</a>
            </div>
        </div>
    </div>
    </div>
</div>

<script src="${ctx}/js/excanvas.min.js"></script>
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/jquery.ui.custom.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/js/jquery.flot.min.js"></script>
<script src="${ctx}/js/jquery.flot.resize.min.js"></script>
<script src="${ctx}/js/jquery.peity.min.js"></script>
<script src="${ctx}/js/fullcalendar.min.js"></script>
<script src="${ctx}/js/unicorn.js"></script>
<script src="${ctx}/js/unicorn.dashboard.js"></script>
</body>
</html>