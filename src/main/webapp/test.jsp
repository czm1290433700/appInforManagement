<%--
  Created by IntelliJ IDEA.
  User: 陈祯民
  Date: 2019/8/8
  Time: 7:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>test</title>
    <script src="${ctx}/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            alert("dd");
            $("#add1").click(function () {
                alert("!");
                var id = $("#id").val();
                var password = $("#pwd").val();
                var value = {
                    "devPassword": password
                };
                $.ajax({
                    url: '/passwordLogin',
                    type: 'post',
                    async:false,
                    contentType:'application/json;charset=utf-8',
                    data:JSON.stringify(value),
                    success: function () {
                        alert("success");
                    },
                    error:function () {
                        alert("fail");
                    }
                })
            })
        });
        // $(function () {
        //     alert("!");
        //     $.ajax({
        //         url: '/passwordLogin',
        //         success: function () {
        //             alert("success");
        //         },
        //         error: function () {
        //             alert("success");
        //         }
        //      })
        // })
     /* document.getElementById("add").onclick=function () {
          alert("dd");

      };
*/

    </script>
</head>
<body>
    <form>
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="id" id="id"/></td>
                <td></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="devPassword" id="pwd"/></td>
                <td><span id="password_alert"></span></td>
            </tr>
            <tr>
                <td></td>
                <td><button type="button" id="add1" >ds</button></td>
                <td></td>
            </tr>
        </table>
    </form>

</body>


</html>
