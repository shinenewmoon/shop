<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<body>
	<form id="updateForm" action="update_spu_massage.do" method="post" enctype="multipart/form-data">
	    <table align="center" width="500px" border="1">
			<tr><td><input type="hidden" name="id" value="${spu.id }"/></td></tr>
			<tr><td>商品名</td><td><input type="text" name="shp_mch" value="${spu.shp_mch }"/></td></tr>
			<tr><td>商品描述</td><td><textarea name="shp_msh" style="width:300px;height:100px;">${spu.shp_msh}</textarea></td></tr>
			<tr><td>创建时间</td><td>${spu.chjshj }</td></tr>
			<tr><td>商品图片</td>
				<c:forEach items="${spu.list_image }" var="img">
					<td>
						<img onclick="file_add(0)" id="img_0" alt="" src="upload/image/${img.url }" width="100px;">
						<input class="0" onchange="file_show(0)" id="file_0" type="file" name="url" style="display: none"/>
					</td>
				</c:forEach>
			</tr>
			<tr><td>提交修改</td><td><input id="tablesub" type="submit" value="提交"></td></tr>
		</table>
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
