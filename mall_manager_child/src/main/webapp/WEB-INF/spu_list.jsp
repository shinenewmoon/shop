<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
	<table align="center" width="500px" border="1">
		<c:forEach items="${list_spu}" var="spu">
			<tr>
			<td><img src="upload/image/${spu.shp_tp }" width="50px"></td>
			<td>${spu.shp_mch }</td><td>${spu.shp_msh }</td>
			<td><a href="javascript:add_tab('更新','update_spu.do?id='+${spu.id }+'')">更新</a></td>
			<td><a href="javascript:delete_spu('${spu.id }','${spu.shp_mch }');">删除</a></td></tr>
		</c:forEach>
	</table>
	
	<script type="text/javascript">
		function delete_spu(id,name){
			if(confirm("确定要删除"+name+"吗？")){
				$.get("goto_spu_delete.do",{id:id},function(data){
					if(data == "success"){
						location = "goto_list_spu.do";
					}
				})
			}
		}
		
	</script>
</body>
</html>