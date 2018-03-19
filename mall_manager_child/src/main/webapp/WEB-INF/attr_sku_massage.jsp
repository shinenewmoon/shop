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
<script type="text/javascript">
 	function check_selected(id,checked){
 		if(checked){
 			$("#attr_sku" + id).show();
 		}else{
 			$("#attr_sku" + id).hide();
 			$(".attr_sku_" + id).removeAttr('checked');
 		}
 	}
</script>
<title>硅谷商城</title>
</head>
<body>
	<c:if test="${not empty attr_sku_list }">
		<h3>属性列表</h3>
		<hr>
		<table>
			<tr>
				<td>商品名称:</td>
				<td><input type="text" name="sku_mch"/></td>
			</tr>
		  	<tr>
		  		<td>商品价格:</td>
		  		<td><input type="text" name="jg"/></td>
		  	</tr>
		  	<tr>
				<td>商品发送地址:</td>
				<td><input type="text" name="kcdz"/></td>
		  	</tr>
		</table>
		<hr>
		<c:forEach items="${attr_sku_list }" var="attr" varStatus="status">
			<input name="list_sku[${status.index }].shxm_id" value="${attr.id }" type="checkbox" onclick="check_selected(this.value,checked)">${attr.shxm_mch }:
		</c:forEach>
		<br>
		<c:forEach items="${attr_sku_list }" var="attr" varStatus="status">
	    <div id="attr_sku${attr.id }" style="display: none">
			<c:forEach items="${attr.list_value }" var="val">
			   <input name="list_sku[${status.index }].shxzh_id" class="attr_sku_${attr.id }" type="radio" value="${val.id }">${val.shxzh }${val.shxzh_mch }
			</c:forEach>
			<br>
		</div>
		</c:forEach>
		<input type="submit" value="提交"/>
	</c:if>
	<c:if test="${empty attr_sku_list }">
		<h2><a href="attr_massage_add.jsp">没有属性信息，请添加</a></h2>
	</c:if>
</body>
</html>