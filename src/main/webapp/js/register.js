/**
 * Create by CZM on 2019/8/8
 */

function lookEmail(message) {
    var arr = message.split(",");
    var email = arr[0];
    var opt = email.split("@")[1];
    if("qq.com"==opt){
        location.href = "https://mail.qq.com/";
    }else if("163.com"==opt){
        location.href = "https://mail.163.com/";
    }else if("162.com"==opt){
        location.href = "https://mail.162.com/";
    }else if("sina.com"==opt){
        location.href = "http://mail.sina.com.cn/";
    }else if("sohu"==opt){
        location.href = "https://mail.sohu.com";
    }
}

function reSendEmail(message) {
    var arr = message.split(",");
    var email = arr[0];
    var code = arr[1];
    $.ajax({
        type:'post',
        url:'/sendEmail',
        data: {"email":email,"validateCode":code},
        dataType:'json',
        success:function(data){
            //alert(data["success"])
            var s = data["success"];
            if(s=="success"){
                alert("发送成功！");
            }
        }
    });
}

function reRegist() {
    location.href = "../register.jsp";
}