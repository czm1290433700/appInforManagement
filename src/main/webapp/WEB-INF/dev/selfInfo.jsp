<%--
  Created by IntelliJ IDEA.
  User: HU
  Date: 2019/8/8
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Unicorn Admin</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/fullcalendar.css" />
    <link rel="stylesheet" href="css/unicorn.main.css" />
    <link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <c:set var="ctx" value="${pageContext.request.contextPath }"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>


<div id="header">
    <h1><a href="./dashboard.html">Unicorn Admin</a></h1>
</div>

<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav btn-group">
        <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-user"></i> <span class="text">${devUser.devName}</span></a></li>
        <li class="btn btn-inverse"><a title="" href="${ctx}/logout"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
    </ul>
</div>

<div id="sidebar">
    <a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
    <ul>

        <li class="submenu">
            <a href="#"><i class="icon icon-th-list"></i> <span>App账号管理</span> </a>
            <ul>
                <li><a href="${ctx}/selfInfo/query">个人信息</a></li>
            </ul>
        </li>
        <li class="submenu">
            <a href="#"><i class="icon icon-file"></i> <span>App应用管理</span> </a>
            <ul>
                <li><a href="${ctx}/appList">App维护</a></li>
            </ul>
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
        <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
        <a href="#" class="tip-bottom">App账户管理</a>
        <a href="#" class="current">个人中心</a>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-title">
								<span class="icon">
									<i class="icon-align-justify"></i>
								</span>
                        <h5>固定信息 </h5>
                    </div>
                    <form id="devUserInfoForm" class="form-horizontal" method="post" action="${ctx}/editDevInfoSubmit">
                        <div>
                            <table class="table table-bordered">
                                <input type="hidden" name="id" value=" ${devUser.id}">
                                <input type="hidden" name="devCode" value=" ${devUser.devCode}">
                                <input type="hidden" name="creationDate" value=" ${devUser.creationDate}">
                                <tbody>
                                <tr>
                                    <td>
                                        账号
                                    </td>
                                    <td>
                                        注册时间
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        ${devUser.devCode}
                                    </td>
                                    <td>
                                        ${devUser.creationDate}
                                    </td>

                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="widget-box collapsible">
                            <div class="widget-title">
                                <a href="#collapseOne" data-toggle="collapse">
                                    <span class="icon"><i class="icon-arrow-right"></i></span>
                                    <h5>可修改部分</h5>
                                </a>
                            </div>
                            <div class="collapse in" id="collapseOne">
                                <div class="widget-content">

                                    <div class="form-group form-group-sm">
                                        <div class="row">
                                            <label class="col-sm-2 control-label" for="nc">昵称</label>
                                            <div class="col-sm-7">
                                                <input name="devName"  id="devName" value="${devUser.devName}" class="form-control" type="text" id="nc" >
                                            </div>
                                            <div class="col-sm-3">
                                                <span style="color: red;" id="ncSpan"></span>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <label class="col-sm-2 control-label" for="mm">密码</label>
                                            <div class="col-sm-7">
                                                <input id="password" name="devPassword" value="${devUser.devPassword}" class="form-control" type="text" id="mm" >
                                            </div>
                                            <div class="col-sm-3">
                                                <span style="color: red;" id="mmSpan"></span>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <label class="col-sm-2 control-label" for="yx">邮箱</label>
                                            <div class="col-sm-7">
                                                <input id="email" name="devEmail" value="${devUser.devEmail}" class="form-control" type="text" id="yx">
                                            </div>
                                            <div class="col-sm-3">
                                                <span style="color: red;" id="yxSpan"></span>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <label class="col-sm-2 control-label" for="sj">手机</label>
                                            <div class="col-sm-7">
                                                <input name="phone" id="phone" value="${devUser.phone}" class="form-control" type="text" id="sj">
                                            </div>
                                            <div class="col-sm-3">
                                                <span style="color: red;" id="sjSpan"></span>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <label class="col-sm-2 control-label" for="qm">个性签名</label>
                                            <div class="col-sm-7">
                                                <input name="devInfo" value="${devUser.devInfo}"class="form-control" type="text" id="qm" >
                                            </div>
                                            <div class="col-sm-3">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button type="button" class="btn btn-primary" id="saveModifyDevUserInfo">保存修改</button>
                        <c:if test="${editUserInfoErrors!=null }">
                            <c:forEach items="${editUserInfoErrors }" var="error">
                                <span style="color: red;">${error.defaultMessage }</span> &nbsp;&nbsp;&nbsp;
                            </c:forEach>

                        </c:if>
                        <c:if test="${editUserInfoSuccess!=null }">
                            <span style="color: blue;">${editUserInfoSuccess }</span> &nbsp;&nbsp;&nbsp;
                        </c:if>
                    </form>
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

<script src="js/excanvas.min.js"></script>
<script src="js/jquery.min.js"></script>
<script>

    $(function() {
        $("#saveModifyDevUserInfo").click(function () {
            var devName = document.getElementById('devName').value;
            if(devName==null || devName.length<2||devName.length>10){
                $("#ncSpan").text("昵称在2-10个字符之间");
                return false;
            }else{
                $("#ncSpan").text("");
            }
            var password = document.getElementById('password').value;
            if(password==null || password.length<2||password.length>10){
                $("#mmSpan").text("密码在2-10个字符之间");
                return false;
            }else{
                $("#mmSpan").text("");
            }
            var email = document.getElementById('email').value;
            if(!(/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(email))){
                $("#yxSpan").text("邮箱格式有误");
                return false;
            }else{
                $("#yxSpan").text("");
            }
            var phone = document.getElementById('phone').value;
            if(!(/^1(3|4|5|7|8)\d{9}$/.test(phone))){
                $("#sjSpan").text("手机格式有误");
                return false;
            }else{
                $("#sjSpan").text("");
            }
            $("#devUserInfoForm").submit();
        });
    });

</script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.flot.min.js"></script>
<script src="js/jquery.flot.resize.min.js"></script>
<script src="js/jquery.peity.min.js"></script>
<script src="js/fullcalendar.min.js"></script>
<script src="js/unicorn.js"></script>
<script src="js/unicorn.dashboard.js"></script>
</body>
</html>