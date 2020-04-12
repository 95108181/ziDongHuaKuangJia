<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="res/css/base.css"/>
  <link rel="stylesheet" type="text/css" href="res/css/style.css"/>
  <link rel="shortcut icon" href="res/images/favicon.ico"/>
  <link rel="stylesheet" href="res/login/bgstretcher.css">
  <script type="text/javascript" src="res/js/jquery-1.7.2.min.js"></script>
  <script type="text/javascript" src="res/login/bgstretcher.js"></script>
  <script type="text/javascript" src="Scripts/layer/layer.js"></script>
  <title>登录</title>
</head>
<style>
  /*登录页样式*/
  .Login_back {
    background: url("res/images/back.png") no-repeat center top;
    height: 100%;
  }

  .login {
    padding: 20px;
    background-color: rgba(255, 255, 255, 0.75);
    box-shadow: 0 1em 2em -1em rgba(0, 0, 0, 0.5);
  }
</style>
<body class="Login_back">
<div class="slideshow">
  <div class="w12">
    <div class="login">
      <div class="logo">
        <svg width="268" height="91">
          <image xlink:href="res/images/logo_login.svg"
                 src="svg.png" width="268" height="91"/>
        </svg>
      </div>
      <div class="title">
        <span>用户登录</span><i>LOGIN</i>
      </div>
      <div class="form">
        <form action="">
          <ul>
            <li>
              <b>手机号:</b>
              <p><input type="text" id="phoneNumber"/></p>
            </li>
            <li>
              <b>密码:</b>
              <p><input type="text" id="password"/></p>
            </li>
            <li>
              <b>邮箱号:</b>
              <p><input type="text" id="mailbox"/></p>
            </li>
            <li>
              <b>验证码:</b>
              <p><input class="m" type="text" id="valiCode"/></p>
              <div class="yzm">
                <span class="a1 " onclick="getCode()">获取验证码</span>
                <span class="a2 none">60S后重新获取</span>
              </div>
            </li>
          </ul>
          <!--当上面严重错误的时候分别不同提示：手机号码错误、验证码错误、使用码错误-->
          <div class="tip none">手机号错误</div>
          <a id="login" onclick="login()" style="cursor: pointer">登录</a>
        </form>
      </div>
    </div>
  </div>
</div>
<script>
  $(document).ready(function () {
    var imgs = [];
    imgs.push('http://qdsytest.oss-cn-hangzhou.aliyuncs.com/article/201807031111473736495.jpg');
    imgs.push('http://qdsytest.oss-cn-hangzhou.aliyuncs.com/article/201807041743003348303.jpg');
    $('body').bgStretcher({
      images: imgs,
      imageWidth: 1024,
      imageHeight: 768,
      nextSlideDelay: 6000
    });
  });

  //验证码倒计时
  var Time_, LocalTime = 60;

  function STime() {
    Time_ = setInterval(function () {
      LocalTime--;
      $(".a2").text(LocalTime + "S后重新获取");
      if (LocalTime == 1) {
        clearInterval(Time_);
        LocalTime = 60;
        $(".a1").show();
        $(".a2").hide();
        $(".a2").text("60S后重新获取");
      }
    }, 1000);
  }
  // $(function () {
  //   $(".a1,.a3").click(function () {
  //     $(this).hide();
  //     $(".a2").show();
  //     STime();
  //   });
  // })

  //获取验证码
  function getCode() {
    var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
    var phoneNumber = $("#phoneNumber").val();
    var mailbox = $("#mailbox").val();
    if (!(mailbox && reg.test(mailbox))) {
      layer.msg("请输入正确的邮箱格式");
      return false;
      }
    if (!(phoneNumber && /^1[0-9]{10}$/.test(phoneNumber))) {
      layer.msg("请输入正确的手机号");
      return false;
    }
      $(".a1").hide();
      $(this).hide();
      $(".a2").show();
      STime();
      $.ajax({
        url: "/comment/sendCode", type: "post", data: {phone: phoneNumber, mailbox: mailbox},
        success: function (data) {
          if (data.succeed) {
            layer.msg("发送成功！")
          } else {
            layer.msg(data.errorMessage)
          }
        }
      })
  }

  //登录
  function login() {
    var phoneNumber = $("#phoneNumber").val();
    var password = $("#password").val();
    var mailbox = $("#mailbox").val();
    var valiCode = $("#valiCode").val();
    if (!(phoneNumber && /^1[0-9]{10}$/.test(phoneNumber))) {
      layer.msg("请输入正确的电话号码");
      return false;
    }else {
      $.ajax({
        url: "/user/login",
        type: "post",
        data: {phoneNumber: phoneNumber, password: password, mailbox: mailbox, valiCode: valiCode},
        success: function (data) {
          console.log(data);
          if (data.succeed) {
            window.location.href = "/user/home";
          } else {
            layer.msg(data.errorMessage)
          }
        }
      })
    }
  }


</script>
</body>
</html>
