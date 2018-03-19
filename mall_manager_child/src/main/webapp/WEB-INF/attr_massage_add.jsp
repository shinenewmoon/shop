<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>硅谷商城</title>
</head>
<body>
 <h2>${class_2_name }添加属性</h2>
 <button id="add">添加属性</button>
 <form action="save_attr.do" method="post">
	<input  type="hidden" name="class_2_id" value="${class_2_id}"/>
	<input id="class_2_name" type="hidden" name="class_2_name" value="${class_2_name}"/>
	<table border="1">
		<tr><td>属性名：<input type="text" name="list_attr[0].shxm_mch" /></td><td></td><td id="0" onclick="add_zhi(this.id)">添加值</td></tr>
		<tr class="0"><td>属性值：<input type="text" name="list_attr[0].list_value[0].shxzh" /></td><td>单位：<input type="text" name="list_attr[0].list_value[0].shxzh_mch" /></td><td id="0_0" onclick="delete_shx(this.id)">删除</td></tr>
		<tr class="1"><td>属性值：<input type="text" name="list_attr[0].list_value[1].shxzh" /></td><td>单位：<input type="text" name="list_attr[0].list_value[1].shxzh_mch" /></td><td id="0_1" onclick="delete_shx(this.id)">删除</td></tr>
	</table>
	<br><br>
	<table border="1">
		<tr><td>属性名：<input type="text" name="list_attr[1].shxm_mch" /></td><td></td><td id="1" onclick="add_zhi(this.id)">添加值</td></tr>
		<tr class="0"><td>属性值：<input type="text" name="list_attr[1].list_value[0].shxzh" /></td><td>单位：<input type="text" name="list_attr[1].list_value[0].shxzh_mch" /></td><td id="1_0" onclick="delete_shx(this.id)">删除</td></tr>
		<tr class="1"><td>属性值：<input type="text" name="list_attr[1].list_value[1].shxzh" /></td><td>单位：<input type="text" name="list_attr[1].list_value[1].shxzh_mch" /></td><td id="1_1" onclick="delete_shx(this.id)">删除</td></tr>
	</table>
	<input type="submit" value="提交"/>
 </form>
 
 <script type="text/javascript">
	$(function(){
		
		$("#add").click(function(){
			var index = $("form > table").length;
			var context=""
			context +='<table border="1">';
			context +='<tr><td>属性名：<input type="text" name="list_attr['+index+'].shxm_mch" /></td><td></td><td id="'+index+'" onclick="add_zhi(this.id)">添加值</td></tr>';
			context +='<tr class="0"><td>属性值：<input type="text" name="list_attr['+index+'].list_value[0].shxzh" /></td><td>单位：<input type="text" name="list_attr['+index+'].list_value[0].shxzh_mch" /></td><td id="'+index+'_0" onclick="delete_shx(this.id)">删除</td></tr>';
			context +='<tr class="1"><td>属性值：<input type="text" name="list_attr['+index+'].list_value[1].shxzh" /></td><td>单位：<input type="text" name="list_attr['+index+'].list_value[1].shxzh_mch" /></td><td id="'+index+'_1" onclick="delete_shx(this.id)">删除</td></tr>';
	        context +='</table>';
			context +='<br><br>';
			//alert($("#"+index+"").attr("class"))
			$("#class_2_name").after(context);
		})
		
	})
	
	function delete_shx(id){
		if(confirm("确定要删除【"+id+"】吗？")){
			$("#"+id+"").parent("tr").remove();
			return false;
		}
	}
	
	function add_zhi(id){
		var count = $("#"+id+"").parents("table").find("tr").last().attr("class");
		//alert((id+'_'+(count*1+1*1)))
		$("#"+id+"").parents("table").find("tr").last().after("<tr class="+(count*1+1*1)+"><td>属性值：<input type='text' name='list_attr["+id+"].list_value["+(count*1+1*1)+"].shxzh' /></td><td>单位：<input type='text' name='list_attr["+id+"].list_value["+(count*1+1*1)+"].shxzh_mch' /></td><td id='"+id+"_"+(count*1+1*1)+"' onclick='delete_shx(this.id)'>删除</td></tr>");
	}
</script>
</body>
</html>