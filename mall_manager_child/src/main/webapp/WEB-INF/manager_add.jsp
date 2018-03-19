<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

</head>
<body>
	添加信息<br>
	<hr>
	<form action="save_spu.do" method="post" enctype="multipart/form-data">
		<jsp:include page="spu_select.jsp"></jsp:include><br>
		商品名称:<input name="shp_mch" type="text" /><br>
		商品描述：<textarea name="shp_msh"></textarea><br>
		商品图片：<br>
		<div>
		<img onclick="file_add(0)" id="img_0" alt="" src="image/background/upload_hover.png" width="100px;">
		<input class="0" onchange="file_show(0)" id="file_0" type="file" name="files" style="display: none"/>
		</div>
		提交：
		<input type="submit" value="提交">
	</form>
	
	<script type="text/javascript">

	function file_add(i){
		$("#file_"+i+"").click();
		var j = $("div :last").attr("class");
		if(i == j){
			$("div").append(
				"<img onclick='file_add("+(i+1)+")' id='img_"+(i+1)+"' alt='' src='image/background/upload_hover.png' width='100px;'/><input class="+(i+1)+" onchange='file_show("+(i+1)+")' id='file_"+(i+1)+"' type='file' name='files' style='display: none'/>"		
			);
		}
	}
	
	function file_show(i){
		//获取名字
		var img = $("#file_"+i+"")[0].files[0];
		//获取图片的地址
		var url = window.URL.createObjectURL(img);
		//将地址存入img标签中
		$("#img_"+i+"").attr("src",url);
	}
</script>
</body>
</html>