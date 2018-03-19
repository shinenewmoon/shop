<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
		$(function (){
			/* $.getJSON("js/json/class_1.js",function(data){
				$(data).each(function(i,json){
					$("#attr_class_1").append("<option value="+json.id+">"+json.flmch1+"</option>");
				});
			}); */
			$('#attr_class_1').combobox({    
			    url:'js/json/class_1.js',
			    width:100,
			    valueField:'id',    
			    textField:'flmch1',
			    onSelect:function attr_class2(){
			    	var class_1_id = $(this).combo("getValue");
			    	$('#attr_class_2').combobox({
					    url:'js/json/class_2_'+class_1_id+'.js',
					    width:100,
					    valueField:'id',    
					    textField:'flmch2',
					    onSelect:function(){
					    	var class_2_id = $(this).combo("getValue");
					    	attr_ajax(class_2_id);
					    }
			    	})
			    }
			});  

		});
		
		function attr_class2(class_1_id){
			$("#attr_class_2").empty();
			$.getJSON("js/json/class_2_"+class_1_id+".js",function(data){
				$(data).each(function(i,json){
					$("#attr_class_2").append("<option value="+json.id+">"+json.flmch2+"</option>");
				});
			});
		}
		
		function attr_ajax(class_2_id){
			/* $.post("attr_massage.do",{class_2_id:class_2_id},function(data){
				$("#attr_massage_show").html(data);
			}) */
			
			$('#attr_massage_show').datagrid({    
			    url:'attr_massage_json.do',
			    queryParams:{
			    	class_2_id:class_2_id
			    },
			    columns:[[    
			        {field:'id',title:'属性编号',width:100},    
			        {field:'shxm_mch',title:'属性名',width:100},    
			        {field:'list_value',title:'属性值',width:200,formatter: function(value,row,index){
						var str = "";
						$(value).each(function(i,json){
							str = str + "" + json.shxzh + json.shxzh_mch + " ";
						})
						return str;
			        	}
			        },
			        {field:'chjshj',title:'创建时间',width:200,formatter: function(value,row,index){
			        	var str = "";
			        	var dateObject = new Date(value);
			        	str = str + "" + dateObject.toLocaleString();
			        	return str;
			        }}
			    ]]    
			});
		}
		
</script>
<title>Insert title here</title>
</head>
<body>
	一级分类
	<select class="easyui-combobox" name="flbh1" id="attr_class_1" onchange="attr_class2(this.value)">
		<option>请选择</option>
	</select>
	二级分类<select class="easyui-combobox" name="flbh2" id="attr_class_2" onchange="attr_ajax(this.value)">
		<option>请选择</option>
	</select>
</body>
</html>