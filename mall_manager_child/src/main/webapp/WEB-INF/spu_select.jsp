<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
		$(function (){
			$.getJSON("js/json/class_1.js",function(data){
				$(data).each(function(i,json){
					$("#spu_class_1").append("<option value="+json.id+">"+json.flmch1+"</option>");
				});
			});
		});
		
		function spu_class2(class_1_id){
			$("#spu_class_2").empty();
			$.getJSON("js/json/class_2_"+class_1_id+".js",function(data){
				$(data).each(function(i,json){
					$("#spu_class_2").append("<option value="+json.id+">"+json.flmch2+"</option>");
				});
			});
			spu_class3(class_1_id);
		}
		
		function spu_class3(class_1_id){
			$("#spu_class_3").empty();
			$.getJSON("js/json/tm_class_1_"+class_1_id+".js",function(data){
				$(data).each(function(i,json){
					$("#spu_class_3").append("<option value="+json.id+">"+json.ppmch+"</option>");
				});
			});
		}
</script>
<title>Insert title here</title>
</head>
<body>
	一级分类
	<select name="flbh1" id="spu_class_1" onchange="spu_class2(this.value)">
		<option>请选择</option>
	</select>
	二级分类<select name="flbh2" id="spu_class_2"></select>
	商品名称<select name="pp_id" id="spu_class_3"></select>
</body>
</html>