<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north',split:true" style="height:100px">
			<h2>商品信息</h2>
		</div>
		<div data-options="region:'west',split:true" style="width:100px">
			<a href="javascript:add_tab('信息查询','goto_list_spu.do')">spu信息的查询</a>
			<a href="javascript:add_tab('信息添加','goto_spu_add.do')">spu信息的添加</a>
		</div>
		<div data-options="region:'center'">
		</div>
	</div>
	
</body>
</html>