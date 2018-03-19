<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north',split:true" style="height:100px">
			<h2>商品属性信息</h2>
			<jsp:include page="attr_select.jsp"></jsp:include>
		</div>
		<div data-options="region:'west',split:true" style="width:100px">
				<a href="javascript:attr_massage_add();">添加属性</a>
		</div>
		<div data-options="region:'center'">
			<table id="dg"></table>  
			<div id="attr_massage_show"></div>
		</div>
	</div>
	
	<script type="text/javascript">


	function attr_massage_add(){
		/* var class_2_id = $("#attr_class_2").val();
		var class_2_name = $("#attr_class_2 option:selected").text(); */
		var class_2_id = $("#attr_class_2").combo("getValue");
		var class_2_name = $("#attr_class_2").combo("getText");
		//alert(class_2_id + class_2_name)
		/* location = 
			"attr_massage_add.do?class_2_id=" + class_2_id + "&class_2_name=" + class_2_name; */
		add_tab('添加属性',"attr_massage_add.do?class_2_id=" + class_2_id + "&class_2_name=" + class_2_name)
	}
	

</script>
	
</body>
</html>