/**
  * Create by CZM on 2019/8/7
 **/

//校验id
function loginCheck(){
    var flag;
    var id = $("#id").val();
    var password = $("#password").val();
    if(id == ''){
        $("#id_alert").text("请输入账户id").css("color", "red");
        flag = false;
    }else if(!(/^[0-9]{4}$/.test(id))){
        $("#id_alert").text("请输入合法账户id").css("color", "red");
        flag = false;
    }else{
        $("#id_alert").text("");
    }
    if(password == ''){
        $("#password_alert").text("请输入密码").css("color","red");
        flag = false;
    }else{
        $("#password_alert").text("");
    }
    if(id != '' && password != ''){
        var value = {
            "id": id,
            "password": password
        };
        $.ajax({
            url: '/passwordLogin',
            type: 'post',
            async:false,
            data: value,
            success: function (data) {
                if(data =="success"){
                    flag = true;
                }else{
                    $("#password_alert").text("密码错误！").css("color","red");
                    flag = false;
                }
            }
        });
    }
    return flag;
}

//验证邮箱地址(登录)
function emailCheck(){
    var flag;
    var email = $("#email").val();
    if(email == ''){
        $("#email_alert").text("请输入邮箱").css("color", "red");
        flag = false;
    }else{
        $("#email_alert").text("");
    }
    if(!(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$/.test(email))){
        $("#email_alert").text("请输入正确邮箱").css("color", "red");
        flag = false;
    }else{
        $("#email_alert").text("");
    }
    //测试邮箱无误，将会发送邮件
    if(email != '' && /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$/.test(email)){
        var value = {
            "email": email
        };
        $.ajax({
            url: '/checkEmail',
            type: 'post',
            data: value,
            success: function (data) {
                if(data =="fail"){
                    flag = true;
                }else{
                    $("#email_alert").text("邮箱未被注册！").css("color","red");
                    flag = false;
                }
            }
        });
    }
    return flag;
}

//校验手机号(登录)
var flag2 = true;
function phoneCheck(){
    var phone = $("#telephone").val();
    phone = phone.replace(/^\s+|\s+$/g,"");
    if(!(/^1[3456789]\d{9}$/.test(phone))){
        $("#telephone_alert").text("手机号码非法！").css("color","red");
        flag2 = false;
    }else{
        $.ajax({
            type:'post',
            url:'/checkPhone',
            data: {"telephone":phone},
            success:function(data){
                if(data == "success"){
                    //未注册
                    $("#telephone_alert").text("该手机号还未注册！").css("color","red");
                    flag2 =  false;
                }else{
                    //注册
                    $("#telephone_alert").text("");
                    flag2 =  true;
                }
            }
        });
    }
    return flag2;
}

//校验用户名
function userNameCheck() {
    var username = $("#username").val();
    if(username == ''){
        $("#username_alert").text("用户名不能为空").css("color","red");
        return false;
    }
    return true;
}

//校验密码强弱
function CheckIntensity() {
    var flag = false;
    var pwd = $("#password").val();
    //去两边空格
    if(pwd!=null) {
        pwd = pwd.replace(/^\s+|\s+$/g, "");
    }
    var len = 0;
    if(pwd != "" && pwd!=null){
        len = pwd.length;
    }
    if( len < 6){
        $("#password_alert").text("密码长度少于6位！").css("color","red");
    }else {
        if(/^[0-9]*$/.test(pwd) || /^[A-Za-z]+$/.test(pwd)){
            $("#password_alert").text("密码强度弱！").css("color","green");
        }else if(/^[A-Za-z0-9]+$ /.test(pwd) || pwd.length <= 10){
            $("#password_alert").text("密码强度中！").css("color","green");
        }else{
            $("#password_alert").text("密码强度强！").css("color","green");
        }
        flag = true;
    }
    return flag;
}

//验证前后输入密码是否一致
function okPwdCheck(){
    var pwd = $("#password").val();
    var okpwd = $("#okpassword").val();
    if(pwd == '' || okpwd == ''){
        $("#okpassword_alert").text("密码不能为空").css("color","red");
        return false;
    }else{
        if(okpwd != pwd) {
            $("#okpassword_alert").text("前后密码不一致").css("color", "red");
            return false;
        }else{
            return true;
        }
    }
}

//校验手机号(注册)
function checkPhone() {
    var flag2 = true;
    var phone = $("#telephone").val();
    phone = phone.replace(/^\s+|\s+$/g,"");
    if(!(/^1[3456789]\d{9}$/.test(phone))){
        $("#telephone_alert").text("手机号码非法！").css("color","red");
        flag2 = false;
    }else{
        $.ajax({
            type:'post',
            url:'/checkPhone',
            data: {"telephone":phone},
            success:function(data){
                if(data == "success"){
                    //未注册
                    $("#telephone_alert").text("√").css("color","green");
                    flag2 =  true;
                }else{
                    //注册
                    $("#telephone_alert").text("该手机号已被注册！").css("color","red");
                    flag2 =  false;
                }
            }
        });
    }
    return flag2;
}

var flag_e = false;
//校验邮箱(注册)
function checkEmail(){
    var email = $("#email").val();
    if(email == ''){
        $("#email_alert").text("请输入邮箱").css("color", "red");
        flag_e = false;
    }else{
        $("#email_alert").text("");
    }
    if(!(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$/.test(email))){
        $("#email_alert").text("请输入正确邮箱").css("color", "red");
        flag_e = false;
    }else{
        $("#email_alert").text("");
    }
    //测试邮箱无误，将会发送邮件
    if(email != '' && /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$/.test(email)){
        var value = {
            "email": email
        };
        $.ajax({
            url: '/checkEmail',
            type: 'post',
            data: value,
            success: function (data) {
                if(data =="fail"){
                    $("#email_alert").text("该邮箱已被注册").css("color","red");
                    flag_e = false;
                }else{
                    $("#email_alert").text("√").css("color","green");
                    flag_e = true;
                }
            }
        });
    }
    return flag_e;
}

//获取验证码按钮事件
function countDown(s){
    if(s <= 0){
        $("#go").text("重新获取");
        $("#go").removeAttr("disabled");
        return;
    }
    /* $("#go").val(s + "秒后重新获取");*/
    $("#go").text(s + "秒后重新获取");
    setTimeout("countDown("+(s-1)+")",1000);
}

var p_flag = false;
//手机验证码检查
function checkPhoneCode(){
    var reg = /^\d{6}\b/;
    var code = $("#verifyCode").val();
    if(reg.test(code)){
        $("#checkCode_alert").text("");
        p_flag =  true;
    }else {
        $("#checkCode_alert").text("输入正确验证码").css("color","red");
        p_flag =  false;
    }
    return p_flag;
}

//更换验证码
function changeCaptcha() {
    $("#captchaImg").attr('src', '/captchaServlet?t=' + (new Date().getTime()));
}

var flag_c = false;
//验证码校验
function checkCode() {
    var code = $("#code").val();
    code = code.replace(/^\s+|\s+$/g,"");
    if(code == ""){
        $("#code_alert").text("请输入验证码！").css("color","red");
        flag_c = false;
    }else{
        $.ajax({
            type: 'post',
            url: '/checkCode',
            data: {"code": code},
            success: function (data) {
                if (data == "success") {
                    $("#code_alert").text("√").css("color","green");
                    flag_c = true;
                }else {
                    $("#code_alert").text("验证码错误！").css("color","red");
                    flag_c = false;
                }
            }
        });

    }
    return flag_c;
}

//获取手机验证码
$(function () {
    $("#go").click(function () {
        if(phoneCheck()){
            //  发送短信给用户手机..
            //  发送一个HTTP请求，通知服务器 发送短信给目标用户
            var telephone =$("#telephone").val();// 用户输入的手机号
            // 用户输入手机号校验通过
            $("#go").attr("disabled", "disabled");
            countDown(60);
            $.ajax({
                method: 'POST',
                url: '/sendSms',// 发送验证码给ActiveQM, 同时保存验证码到redis数据库
                data : {
                    telephone : telephone
                },
                success:function(data) {
                    var tt = data["msg"];
                    if(tt){
                        alert("发送短信成功!");
                    }else{
                        alert("发送短信出错，请联系管理员");
                    }
                }
            });
        }else{
            $("#telephone_alert").text("手机号尚未注册!").css("color", "red");
        }
    })

    //登录
    $("#phone_btn").click(function () {
        if(phoneCheck()&& checkPhoneCode()){
            // 校验用户名和密码
            $("#telephone_alert").text("").css("color","red");
            $("#phoneform").submit();
        }else {
            alert("请输入手机号和6位验证码!");
        }
    });

    //提交注册信息
    $("#to_register").click (function(){
        if(userNameCheck() && CheckIntensity() && okPwdCheck() && checkPhone() && flag_e && flag_c){
            $("#registerform").submit();
        }else {
            alert(a);
            alert(b);
            alert(c);
            alert(d);
            alert(e);
            alert(f);
            $("#all_alert").text("请将信息填写完整！").css("color","red");
        }

    });

});

