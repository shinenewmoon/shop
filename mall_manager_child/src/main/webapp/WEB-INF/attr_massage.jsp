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

</script>
<title>硅谷商城</title>
</head>
<body>
	<h3>属性列表</h3>
	<c:if test="${not empty list_attr }">
		<table>
			<tr>
			   <th>属性名称</th>
			   <th>属性值</th>
			</tr>
			<c:forEach items="${list_attr }" var="attr">
		    <tr>
				<td>${attr.shxm_mch }:</td>
				<c:forEach items="${attr.list_value }" var="val">
					<td>${val.shxzh }${val.shxzh_mch }</td>
				</c:forEach>
			</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>