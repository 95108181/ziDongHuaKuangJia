﻿
accessid = ''
accesskey = ''
host = ''
policyBase64 = ''
signature = ''
callbackbody = ''
filename = ''
key = ''
expire = 90000000
g_object_name = ''
g_object_name_type = ''
now = timestamp = Date.parse(new Date()) / 1000;
var max_num = 5;
var num = $("#imgUploadContainer img").length;

function send_request() {
    //debugger
    var xmlhttp = null;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlhttp != null) {
        serverUrl = '/common/GetOssKeys'
        xmlhttp.open("GET", serverUrl, false);
        xmlhttp.send(null);
        return xmlhttp.responseText
    }
    else {
        alert("Your browser does not support XMLHTTP.");
    }
};

function check_object_radio() {
    //debugger

    //var tt = document.getElementsByName('myradio');
    //for (var i = 0; i < tt.length ; i++) {
    //    if (tt[i].checked) {
    //        g_object_name_type = tt[i].value;
    //        break;
    //    }
    //}
    g_object_name_type = "random_name";
}

function get_signature() {
    //可以判断当前expire是否超过了当前时间,如果超过了当前时间,就重新取一下.3s 做为缓冲
    now = timestamp = Date.parse(new Date()) / 1000;
    if (expire < now + 3) {
        body = send_request()
        var obj = eval("(" + body + ")");
        host = obj['host']
        policyBase64 = obj['policy']
        accessid = obj['accessid']
        signature = obj['signature']
        expire = parseInt(obj['expire'])
        callbackbody = obj['callback']
        key = obj['dir']
        return true;
    }
    return false;
};


//随机字符串
function random_string(len) {
    //debugger
    len = len || 32;
    var chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';
    var maxPos = chars.length;
    var pwd = '';
    for (i = 0; i < len; i++) {
        pwd += chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return pwd;
}

//返回一个字符串
function get_suffix(filename) {
    //debugger
    pos = filename.lastIndexOf('.')
    suffix = ''
    if (pos != -1) {
        suffix = filename.substring(pos)
    }
    return suffix;
}

function calculate_object_name(filename) {
    //debugger
    if (g_object_name_type == 'local_name') {
        g_object_name += "${filename}"
    }
    else if (g_object_name_type == 'random_name') {
        suffix = get_suffix(filename)
        g_object_name = key + random_string(10) + suffix
    }
    return ''
}

function get_uploaded_object_name(filename) {
    //debugger
    if (g_object_name_type == 'local_name') {
        tmp_name = g_object_name
        tmp_name = tmp_name.replace("${filename}", filename);
        return tmp_name
    }
    else if (g_object_name_type == 'random_name') {
        return g_object_name
    }
}

function set_upload_param(up, filename, ret) {
    //debugger
    if (ret == false) {
        ret = get_signature()
    }
    g_object_name = key;
    if (filename != '') {
        suffix = get_suffix(filename)
        calculate_object_name(filename)
    }
    new_multipart_params = {
        'key': g_object_name,
        'policy': policyBase64,
        'OSSAccessKeyId': accessid,
        'success_action_status': '200', //让服务端返回200,不然，默认会返回204
        'callback': callbackbody,
        'signature': signature,
    };

    up.setOption({
        'url': host,
        'multipart_params': new_multipart_params
    });

    up.start();
}

var uploader = new plupload.Uploader({
    runtimes: 'html5,flash,silverlight,html4',
    browse_button: 'selectfiles',
    //multi_selection: false,
    container: document.getElementById('imgUploadContainer'),
    flash_swf_url: '/Scripts/plugin/plupload-2.1.2/js/Moxie.swf',
    silverlight_xap_url: '/Scripts/plugin/plupload-2.1.2/js/Moxie.xap',
    url: 'http://oss.aliyuncs.com',

    filters: {
        mime_types: [ //只允许上传图片和zip,rar文件
        { title: "Image files", extensions: "jpg,gif,png,bmp,jpeg" },
        //{ title: "Zip files", extensions: "zip,rar" }
        ],
        max_file_size: '10mb', //最大只能上传10mb的文件
        prevent_duplicates: true //不允许选取重复文件
    },

    //当初始化plupload完成后触发
    init: {
        //当init事件发生后触发

        PostInit: function () {
            //debugger
            //document.getElementById('ossfile').innerHTML = '';
            document.getElementById('postfiles').onclick = function () {
                set_upload_param(uploader, '', false);
                return false;
            };
        },
        //FilesAdded: function (up, files) {
        //    plupload.each(files, function (file) {
        //        document.getElementById('ossfile').innerHTML += '<div id="' + file.id + '">' + file.name + ' (' + plupload.formatSize(file.size) + ')<b></b>'
        //		+ '<div class="progress"><div class="progress-bar" style="width: 0%"></div></div>'
        //		+ '</div>';
        //    });
        //},
        //上传文件之前触发
        BeforeUpload: function (up, file) {
            //debugger

            check_object_radio();
            set_upload_param(up, file.name, true);
        },

        //UploadProgress: function (up, file) {
        //    var d = document.getElementById(file.id);
        //    d.getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
        //    var prog = d.getElementsByTagName('div')[0];
        //    var progBar = prog.getElementsByTagName('div')[0]
        //    progBar.style.width = 2 * file.percent + 'px';
        //    progBar.setAttribute('aria-valuenow', file.percent);
        //},
        //上传成功之后触发
        FileUploaded: function (up, file, info) {
            num++
            if (info.status == 200) {
                //document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = 'upload to oss success, object name:' + get_uploaded_object_name(file.name);
                var imgPath = host + "/" + get_uploaded_object_name(file.name);

                var imgContainer = document.getElementById('imgUploadContainer');
                var sp = document.createElement("span");
                
                sp.setAttribute("style", "background-image:url('" + staticFileServer + "/Content/Admin/Home/image/close.png');width:25px;height:25px;display:none;position:absolute;right:0px;top:0px;");
                var imgA = document.createElement("a");
                imgA.appendChild(sp);
                imgA.setAttribute("style", "position:relative;display:inline-block;width: 140px;height: 95px;")
                imgA.setAttribute("data-lightbox", "example-set");
                imgA.setAttribute("href", imgPath);
                var imgImg = document.createElement("img");
                imgImg.setAttribute("style", "width: 140px; height:95px;margin-bottom:10px;display:none");
                imgImg.setAttribute("src", imgPath);
                imgA.appendChild(imgImg);
                imgContainer.appendChild(imgA);
                $(imgA).insertBefore($("#sortNumberBr"));
                $(imgImg).show();
                imgA.onmouseover = function () {
                    sp.style.display = 'inline-block';
                }
                imgA.onmouseout = function () {
                    sp.style.display = 'none';
                }
                sp.onclick = function (e) {
                    //阻止默认行为
                    e.preventDefault();
                    imgContainer.removeChild(imgA);
                    num--;
                    $("#selectfiles").css("display", "inline-block");
                    $("#postfiles").css("display", "inline-block");
                    return;
                }
                if (num > max_num) {
                    $("#selectfiles").css("display", "none");
                    $("#postfiles").css("display", "none");
                }


                //style="width: 140px; height:95px;margin-bottom:10px;display:none"
                //data-lightbox="example-set"
                //imgContainer.appendChild(imgItem);
                //var frameDiv = document.createElement("div");//创建一个标签
                //$($("#imgUploadContainer a")[i].children).attr("src", imgPath).show();
                //$($("#imgUploadContainer a")[i]).attr("href", imgPath);

                //style="width: 140px; height:95px;margin-bottom:10px;display:none"
                //data-lightbox="example-set"
                //imgContainer.appendChild(imgItem);
                //var frameDiv = document.createElement("div");//创建一个标签
                //$($("#imgUploadContainer a")[i].children).attr("src", imgPath).show();
                //$($("#imgUploadContainer a")[i]).attr("href", imgPath);
            }
            //else {
            //    document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = info.response;
            //}
        },

        //Error: function (up, err) {
        //    if (err.code == -600) {
        //        document.getElementById('console').appendChild(document.createTextNode("\n选择的文件太大了,可以根据应用情况，在upload.js 设置一下上传的最大大小"));
        //    }
        //    else if (err.code == -601) {
        //        document.getElementById('console').appendChild(document.createTextNode("\n选择的文件后缀不对,可以根据应用情况，在upload.js进行设置可允许的上传文件类型"));
        //    }
        //    else if (err.code == -602) {
        //        document.getElementById('console').appendChild(document.createTextNode("\n这个文件已经上传过一遍了"));
        //    }
        //    else {
        //        document.getElementById('console').appendChild(document.createTextNode("\nError xml:" + err.response));
        //    }
        //}
    }
});
//初始化实例
uploader.init();
//删除选中图片

$(".lookimg_delBtn").click(function () {
    ////debugger
    $(".imgfile[num=" + $(this).parent().attr("num") + "]").remove();//移除图片file
    $(this).parent().remove();//移除图片显示
});

//删除按钮移入移出效果


$(".lookimg").mouseover(function () {
    //debugger
    if ($(this).attr("ISUP") != "1")
        $(this).children(".lookimg_delBtn").eq(0).css("display", "block");;
});




$(".lookimg").mouseout(function () {
    //debugger
    $(this).children(".lookimg_delBtn").eq(0).css("display", "none");;
});



$("#imgUploadContainer a").mouseover(function () {
    $(this).find('span').css('display','inline-block');
}) 
    

$("#imgUploadContainer a").mouseout(function () {
    $(this).find('span').css('display', 'none');
})
$("#imgUploadContainer span").click(function (e) {
    //阻止默认行为
    e.preventDefault();
    $(this).parent().remove();
    num--;
    $("#selectfiles").css("display", "inline-block");
    $("#postfiles").css("display", "inline-block");
    return;
})