<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"  %>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function b(){
		
		//序列化，将序列化数据转换成字符串
		//异步的提交一定是用ajax中的三个提交的方式，submit是同步提交的方法
		$.get("login.do",$("#form_id").serialize(),function(data){
			alert(data);
		})

	}
</script>
<title>硅谷商城</title>
</head>
<body>
	<form id="form_id">
		用户名:<input type="text" name="yh_mch"/>
		密码:<input type="text" name="yh_mm"/>
		<input type="button" value="登录" onclick="b()"/>
	</form>
</body>
</html>