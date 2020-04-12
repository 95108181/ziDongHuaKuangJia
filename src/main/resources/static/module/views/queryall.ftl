<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
    <title></title>
    <link rel="stylesheet" type="text/css" href="/assets/queryall/zepto.mtimer.css">
    <script type="text/javascript" src="/assets/queryall/zepto.js"></script>
    <script type="text/javascript" src="/assets/queryall/zepto.mtimer.js"></script>
</head>

<script>
function windowHeight() {
	var de = document.documentElement;
	return self.innerHeight||(de && de.clientHeight)||document.body.clientHeight;
}
window.onload=window.onresize=function(){
	var wh=windowHeight();
	document.getElementById("xt-left").style.height = document.getElementById("xt-right").style.height = (wh-document.getElementById("xt-top").offsetHeight)+"px";
}
</script>

<body>
<div class="xt-center">
<div id="xt-right">
    <div class="xt-input">
        <span>选择时间定时运行</span>
        <input type="text" id="picktime" value="03-27 15:00" class="int-text" readonly>
        <input type="button" value="确 定" class="green-int" />
<#--        <span>来源</span>-->
<#--        <input type="text" class="int-text" />-->
        <a id="testfunction" onclick="testfunction()" class="yellow-int">点击立即运行</a>
    </div>
    <div class="xt-table">
        <table cellpadding="0" cellspacing="0" border="0" bgcolor="#dcdcdc" width="100%">
            <tr>
            <th>编号</th>
            <th>用例总数</th>
            <th>用例通过</th>
            <th>用例跳过</th>
            <th>用例失败</th>
            <th>开始时间</th>
            <th>运行时间</th>
            <th>用例名称</th>
            <th>创建时间</th>
            <th>状态</th>
            </tr>
            <#list goodsList as goods>
            <tr>
                <td>${goods.id}</td>
                <td>${goods.testAll}</td>
                <td>${goods.testPass}</td>
                <td>${goods.testSkip}</td>
                <td>${goods.testsFail}</td>
                <td>${goods.runningTime}</td>
                <td>${goods.startTime}</td>
                <td>${goods.caseName}</td>
                <td>2020-3-31</td>
                <td><a href="/testData/details/${goods.id}" class="yellow-xt">详情</a><a href="#" class="blue-xt">删除</a></td>
            </tr>
            </#list>


        </table>
    </div>
<#--    <div class="xt-fenye">-->
<#--        <div class="xt-fenye-left">当前第 1 / 270 页,每页10条，共 2696条记录</div>-->
<#--        <div class="xt-fenye-right">-->
<#--            <a href="#">首页</a>-->
<#--            <a href="#">上一步</a>-->
<#--            <a href="#">下一步</a>-->
<#--            <a href="#">尾页</a>-->
<#--            <input type="text" name="text" />-->
<#--            <a href="#" class="xt-link">跳转</a>-->
<#--        </div>-->
<#--    </div>-->
</div>
</div>

</body>

<script>
    $(function(){
        $('#picktime').mtimer();
    });

    //运行用例
    function testfunction() {
        alert("点击成功，运行中请稍后;");
            $.ajax({
                url: "/testData/function",
                type: "post",
                data: {},
                success: function (data) {
                    console.log(data);
                    if (data.succeed) {
                        alert("运行成功");
                    } else {
                        alert("系统繁忙，请稍后再试");
                    }
                }
            })

    }
</script>
</html>