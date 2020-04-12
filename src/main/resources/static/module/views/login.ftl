<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="/assets/login/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="/assets/login/assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Login Page - Now UI Kit by Creative Tim</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <link rel="stylesheet" href="/assets/login/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/login/assets/css/now-ui-kit.css?v=1.1.0">
    <link rel="stylesheet" href="/assets/login/assets/css/demo.css">
    <link rel="canonical" href="" />
    <meta name="keywords" content="">
    <meta name="description" content="">
</head>

<body class="login-page sidebar-collapse">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent " color-on-scroll="400">
        <div class="container">
            <div class="dropdown button-dropdown">
                <a href="#pablo" class="dropdown-toggle" id="navbarDropdown" data-toggle="dropdown">
                    <span class="button-bar"></span>
                    <span class="button-bar"></span>
                    <span class="button-bar"></span>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-header">Dropdown header</a>
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Separated link</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">One more separated link</a>
                </div>
            </div>
            <div class="navbar-translate">
                <a class="navbar-brand" href="#" rel="tooltip" data-placement="bottom">
                    ClipClaps
                </a>
                <button class="navbar-toggler navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar bar1"></span>
                    <span class="navbar-toggler-bar bar2"></span>
                    <span class="navbar-toggler-bar bar3"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse justify-content-end" data-nav-image="/assets/login/assets/img/blurred-image-1.jpg">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Test platform</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#/issues">Where dreams begin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" rel="tooltip" title="Follow us on Twitter" data-placement="bottom" href="#CreativeTim" target="_blank">
                            <i class="fa fa-twitter"></i>
                            <p class="d-lg-none d-xl-none">Twitter</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" rel="tooltip" title="Like us on Facebook" data-placement="bottom" href="#CreativeTim" target="_blank">
                            <i class="fa fa-facebook-square"></i>
                            <p class="d-lg-none d-xl-none">Facebook</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" rel="tooltip" title="Follow us on Instagram" data-placement="bottom" href="#" target="_blank">
                            <i class="fa fa-instagram"></i>
                            <p class="d-lg-none d-xl-none">Instagram</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- End Navbar -->
    <div class="page-header" filter-color="orange">
        <div class="page-header-image" style="background-image:url(/assets/login/assets/img/login.jpg)"></div>
        <div class="container">
            <div class="col-md-4 content-center">
                <div class="card card-login card-plain">
                    <form class="form" method="" action="">
                        <div class="header header-primary text-center">
                            <div class="logo-container">
                                <img src="/assets/login/assets/img/now-logo.png" alt="">
                            </div>
                        </div>
                        <div class="content">
                            <div class="input-group form-group-no-border input-lg">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons users_circle-08"></i>
                                </span>
                                <input type="text" id="userName" placeholder="First Name..." class="form-control" />
                            </div>
                            <div class="input-group form-group-no-border input-lg">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons text_caps-small"></i>
                                </span>
                                <input type="text" id="password" placeholder="Password..." class="form-control" />
                            </div>
                        </div>
                        <div class="footer text-center">
                            <a id="login" onclick="login()" class="btn btn-primary btn-round btn-lg btn-block">Get Started</a>
                        </div>
                        <div class="pull-left">
                            <h6>
                                <a href="#pablo" class="link">Create Account</a>
                            </h6>
                        </div>
                        <div class="pull-right">
                            <h6>
                                <a href="#pablo" class="link">Need Help?</a>
                            </h6>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

<script src="/assets/login/assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="/assets/login/assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="/assets/login/assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<script src="/assets/login/assets/js/plugins/bootstrap-switch.js"></script>
<script src="/assets/login/assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
<script src="/assets/login/assets/js/plugins/bootstrap-datepicker.js" type="text/javascript"></script>
<script src="/assets/login/assets/js/plugins/jquery.sharrre.js" type="text/javascript"></script>
<script src="/assets/login/assets/js/now-ui-kit.js?v=1.1.0" type="text/javascript"></script>

<script type="text/javascript">
    //登录
    function login() {
        var userName = $("#userName").val();
        var password = $("#password").val();
        if (userName == null || userName == "" || password == null  || password == "") {
            alert("请输入正确的账号和密码");
            return false;
        }else {
            $.ajax({
                url: "/user/login",
                type: "post",
                data: {userName: userName, password: password},
                success: function (data) {
                    console.log(data);
                    if (data.succeed) {
                        window.location.href = "/testData/queryall";
                    } else {
                        alert(data.errorMessage);
                    }
                }
            })
        }
    }
</script>


</html>