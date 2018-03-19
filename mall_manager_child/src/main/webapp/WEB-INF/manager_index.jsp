<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Full Layout - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css" href="js/easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyUI/themes/icon.css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript">

	$(function(){
		//js支持el表达式，但是el表达式是服务器运行，在到达jsp页面时el表达式已不再是一个变量而是一个定量
		var title = "${title}";
		var url = "${url}";
		add_tab(title,url);
	})

	function add_tab(title,url){
		
		var flag = $('#tt').tabs("exists",title);
		if(!flag){
			$('#tt').tabs('add',{    
			    title:title,    
			    href:url,    
			    closable:true,    
			    tools:[{    
			        iconCls:'icon-mini-refresh',    
			        handler:function(){
			            alert('refresh');    
			        }    
			    }]    
			}); 
		}else{
			$("#tt").tabs("select",title)
		}
		
	}
 
</script>
<title>硅谷商城</title>
</head>


<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px"><h1>管理员首页</h1></div>
	<div data-options="region:'west',split:true,title:'West'" style="width:200px;padding:10px;">
		<div class="easyui-accordion" style="width:150px;height:150px;">
		<div title="商品管理" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			<ul class="easyui-tree">
				<li>
					<span>商品发布管理</span>
					<ul>
						<li>
							<a href="javascript:add_tab('商品信息管理','goto_index.do');">商品信息管理</a><br>
						</li>
						<li>
							<a href="javascript:add_tab('商品属性管理','goto_attr_index.do');">商品属性管理</a><br>
						</li>
						<li>
							<a href="javascript:add_tab('商品库存管理','goto_sku_index.do');">商品库存管理</a><br>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		<div title="缓冲机制" data-options="iconCls:'icon-edit'" style="padding:10px;">
			<ul class="easyui-tree">
				<li>
					<a href="javascript:add_tab('redis缓存','goto_search.do');">redis缓存</a><br>
				</li>
			</ul>
		</div>
	</div>
		
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center',title:'Center'">
		<div id="tt" class="easyui-tabs" style="height: 700px;">
		
		</div>
	</div>
</body>

</html>