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
					$("#sku_class_1").append("<option value="+json.id+">"+json.flmch1+"</option>");
				});
			});
		});
		
		function sku_class2(class_1_id){
			$("#sku_class_2").empty();
			$.getJSON("js/json/class_2_"+class_1_id+".js",function(data){
				$(data).each(function(i,json){
					$("#sku_class_2").append("<option value="+json.id+">"+json.flmch2+"</option>");
				});
			});
			sku_class3(class_1_id);
		}
		
		function sku_class3(class_1_id){
			$("#sku_class_3").empty();
			$.getJSON("js/json/tm_class_1_"+class_1_id+".js",function(data){
				$(data).each(function(i,json){
					$("#sku_class_3").append("<option value="+json.id+">"+json.ppmch+"</option>");
				});
			});
		}
		
		function spu_add(pp_id){
			//alert(pp_id)
			var class_2_id = $("#sku_class_2").val();
			$.post("goto_get_spu.do",{pp_id:pp_id,class_2_id:class_2_id},function(data){
				$(data).each(function(i,json){
					$("#spu").append("<option value="+json.id+">"+json.shp_mch+"</option>");
				})
			})
		}
		
		function sku_attr_list(class_2_id){
			$.post("get_sku_attr_list.do",{class_2_id:class_2_id},function(data){
				$("#sku_attr_list").html(data);
			})
		}
</script>
<title>Insert title here</title>
</head>
<body>
	一级分类
	<select name="flbh1" id="sku_class_1" onchange="sku_class2(this.value)">
		<option>请选择</option>
	</select>
	二级分类<select name="flbh2" id="sku_class_2" onchange="sku_attr_list(this.value)"></select>
	商品名称<select name="pp_id" id="sku_class_3" onchange="spu_add(this.value)"></select>
	spu名称<select name="shp_id" id="spu"></select>
</body>
</html>