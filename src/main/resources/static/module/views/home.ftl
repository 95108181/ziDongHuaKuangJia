<!DOCTYPE html>
<html>
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport"
        content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <!-- Fonts-->
  <link rel="stylesheet" type="text/css" href="../assets/fonts/fontawesome/font-awesome.min.css">
  <!-- Vendors-->
  <link rel="stylesheet" type="text/css" href="../assets/vendors/bootstrap/grid.css">
  <link rel="stylesheet" type="text/css"
        href="../assets/vendors/magnific-popup/magnific-popup.min.css">
  <link rel="stylesheet" type="text/css" href="../assets/vendors/swiper/swiper.css">
  <link rel="stylesheet" type="text/css" href="../assets/vendors/wow/animate.css">
  <!-- App & fonts-->
  <link rel="stylesheet" type="text/css"
        href="https://fonts.googleapis.com/css?family=Josefin+Sans:400,700|Montserrat:400,700">
  <link rel="stylesheet" type="text/css" id="app-stylesheet" href="../assets/css/main.css">
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <![endif]-->

</head>

<body>
<div class="page-wrap" id="root">

  <!-- header -->
  <header class="header header--fixed">
    <div class="container">
      <div class="header__inner">
        <div class="header__logo"><a>springboot</a></div>
        <div class="header__menu">
        </div>
      </div>
    </div>
  </header><!-- End / header -->

  <!-- Content-->
  <div class="awe-content">

    <!-- hero -->
    <section class="hero awe-text-center" id="id-1">
      <div class="awe-overlay"></div>
      <div class="hero__wrapper">
        <div class="container">
          <div class="row">
            <div
                class="col-md-12 col-lg-8 col-xs-offset-0 col-sm-offset-0 col-md-offset-0 col-lg-offset-2 ">
              <h1 class="hero__title">springboot测试系统，为软件保驾护航!
              </h1>
              <p class="hero__text">Bosch Technology <a href="#">Test </a> System,<a href="#">
                escort </a>the software! </p>
              <a class="a-btn btn-first" onclick="api()" href="#">Api</a>
              <#--<a class="a-btn btn-first" onclick="apiExcl()" href="#">Api</a>-->
              <a class="a-btn btn-first" onclick="Appium()" href="#">Appium</a>
              <a class="a-btn btn-first" onclick="selenium()" href="#">selenium</a>
            </div>
          </div>
        </div>
      </div>

      <!-- smoky -->
      <div class="smoky" id="smoky-bg">
        <canvas>Your browser does not support HTML5 canvas.</canvas>
      </div><!-- End / smoky -->

    </section><!-- End / hero -->
  </div>
  <!-- End / Content-->

  <!-- footer -->
  <div class="footer">
    <div id="back-to-top"><i class="fa fa-angle-up"></i></div>
    <div class="container">
      <div class="footer__wrapper">
        <div class="footer__social">


        </div>
        <p class="footer__copy">2018 &copy; Copyright <a href="#">Awe7</a>.- More Templates
          <a>springboot2.0</a> - Collect from <a>springboot2.0</a></p>
      </div>
    </div>
  </div><!-- End / footer -->

</div>
<!-- Vendors-->
<script type="text/javascript" src="../assets/vendors/_jquery/jquery.min.js"></script>
<script type="text/javascript" src="../assets/vendors/imagesloaded/imagesloaded.pkgd.js"></script>
<script type="text/javascript" src="../assets/vendors/isotope-layout/isotope.pkgd.js"></script>
<script type="text/javascript" src="../assets/vendors/jquery-one-page/jquery.nav.min.js"></script>
<script type="text/javascript" src="../assets/vendors/jquery.easing/jquery.easing.min.js"></script>
<script type="text/javascript"
        src="../assets/vendors/jquery.matchHeight/jquery.matchHeight.min.js"></script>
<script type="text/javascript"
        src="../assets/vendors/magnific-popup/jquery.magnific-popup.min.js"></script>
<script type="text/javascript" src="../assets/vendors/masonry-layout/masonry.pkgd.js"></script>
<script type="text/javascript" src="../assets/vendors/swiper/swiper.jquery.js"></script>
<script type="text/javascript" src="../assets/vendors/menu/menu.js"></script>
<script type="text/javascript"
        src="../assets/vendors/jquery.countTo/jquery.countTo.min.js"></script>
<script type="text/javascript"
        src="../assets/vendors/jquery.waypoints/jquery.waypoints.min.js"></script>
<script type="text/javascript" src="../assets/vendors/tabs/awe-tabs.js"></script>
<script type="text/javascript" src="../assets/vendors/wow/wow.js"></script>
<script type="text/javascript" src="../assets/vendors/jquery.appear/jquery.appear.js"></script>
<script type="text/javascript" src="../assets/vendors/waterpipe/waterpipe.js"></script>
<!-- App-->
<script type="text/javascript" src="../assets/js/main.js"></script>
<script>
  //开始
  function api() {
    window.location.href = "/api/singleInterface";
  }
  function apiExcl() {
    window.location.href = "/api/apiExcl";
  }
  function Appium() {
    window.location.href = "/Appium/huLiAppShiZhong";
  }
  function selenium() {
    window.location.href = "/selenium/huLiSelenium";
  }
</script>
</body>
</html>