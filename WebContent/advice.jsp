<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1, minimum-scale=1,user-scalable=0">
<title>微信学习</title>
<link rel="stylesheet" href="weui-1.1.0/css/weui.css">
<link rel="stylesheet" href="weui-1.1.0/css/jquery-weui.css">
<link rel="stylesheet" href="weui-1.1.0/css/demos.css">
<script src="weui-1.1.0/js/jquery-2.1.4.js"></script>
</head>
<body ontouchstart>
	<header class="demos-header">
      	<header class='demos-header'>
      		<h1 class="demos-title">投诉建议</h1>
     	</header>
    </header>
	<form class="weui-cells weui-cells_form" id="adviceForm" name="adviceForm" method="post" action="/voastudy/AdviceServlet?method=add">
	  <input id="userId" name="userId" class="weui-uploader__input" type="hidden" value="${user.userId}">
	  <input id="userName" name="userName" class="weui-uploader__input" type="hidden" value="${user.userName}">
	  <div class="weui-cell">
	    <div class="weui-cell__bd">
	      <div class="weui-uploader">
	        <div class="weui-uploader__hd">
	          <p class="weui-uploader__title">图片上传</p>
	          <div class="weui-uploader__info">0/4</div>
	        </div>
	        <div class="weui-uploader__bd">
	          <ul class="weui-uploader__files" id="uploaderFiles">
	            
	          </ul>
	          <div class="weui-uploader__input-box">
	            <input id="uploaderInput" class="weui-uploader__input" type="file" accept="image/*" multiple="">
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	  <div class="weui-cells__title">请在这里写下您的宝贵建议</div>
	  <div class="weui-cells weui-cells_form">
		  <div class="weui-cell">
		    <div class="weui-cell__bd">
		      <textarea class="weui-textarea" placeholder="请输入文本" rows="3" name="adviceContent"></textarea>
		      <div class="weui-textarea-counter"><span>0</span>/100</div>
		    </div>
		  </div>
	  </div>
	  <div class="weui-btn-area">
            <a href="javascript:;" class="weui-btn weui-btn_primary" id="submitButton">提交</a>
        </div>
	</form>
	
	
</body>
<script type="text/javascript">
    $(function(){
    	$('#submitButton').click(function(){
    		$('#adviceForm').submit();
    	});
        var tmpl = '<li class="weui-uploader__file" style="background-image:url(#url#)"></li>',
            $gallery = $("#gallery"), $galleryImg = $("#galleryImg"),
            $uploaderInput = $("#uploaderInput"),
            $uploaderFiles = $("#uploaderFiles");

        $uploaderInput.on("change", function(e){
            var src, url = window.URL || window.webkitURL || window.mozURL, files = e.target.files;
            for (var i = 0, len = files.length; i < len; ++i) {
                var file = files[i];

                if (url) {
                    src = url.createObjectURL(file);
                } else {
                    src = e.target.result;
                }
                $uploaderFiles.append($(tmpl.replace('#url#', src)));
                $uploaderFiles.append($(tmpl.replace('#i#', i)));
            }
        });
        $uploaderFiles.on("click", "li", function(){
            $galleryImg.attr("style", this.getAttribute("style"));
            $gallery.fadeIn(100);
        });
        $gallery.on("click", function(){
            $gallery.fadeOut(100);
        });
    });
</script>
</html>