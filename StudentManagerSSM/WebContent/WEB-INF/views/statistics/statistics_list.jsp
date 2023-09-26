<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>统计与分析</title>
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../easyui/css/demo.css">
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/js/validateExtends.js"></script>
	<script type="text/javascript">
	var independentList = ${independentListJson};
	$(function() {	
		var table;
		//datagrid初始化 
	    $('#dataList').datagrid({ 
	        title:'统计与分析', 
	        iconCls:'icon-more',//图标 
	        border: true, 
	        collapsible:false,//是否可折叠的 
	        fit: true,//自动大小 
	        method: "post",
	        url:"get_list?t="+new Date().getTime(),
	        idField:'id', 
	        singleSelect:false,//是否单选 
	        pagination:true,//分页控件 
	        rownumbers:true,//行号 
	        sortName:'id',
	        sortOrder:'DESC', 
	        remoteSort: false,
	        columns: [[  
	        	//{field:'chk',checkbox: true,width:50},
 		        {field:'id',title:'ID',width:50, sortable: true,hidden:true},
 		        {field:'sdId',title:'姓名',width:100,sortable: true},
 		        {field:'site',title:'工作地域',width:150,sortable: true},
 		        {field:'score',title:'实习成绩',width:80,sortable: true},
 		        //和评价系统用同一个实习成绩
 		        {field:'duikou',title:'专业是否对口',width:100,sortable: true},
 		        //这里用单选框
 		        {field:'remark',title:'申请类型',width:100,sortable: true},
	 		]], 
	        toolbar: "#toolbar"
	    }); 
		
	    
	    //设置工具类按钮
	    $("#add").click(function(){
	    	table = $("#addTable");
	    	$("#addDialog").dialog("open");
	    });
	    //设置分页控件 
	    var p = $('#dataList').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,//每页显示的记录条数，默认为10 
	        pageList: [10,20,30,50,100],//可以设置每页记录条数的列表 
	        beforePageText: '第',//页数文本框前显示的汉字 
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录 ',
	    }); 
	    
	    
	    //设置工具类按钮
	    $("#add").click(function(){
	    	table = $("#addTable");
	    	$("#addDialog").dialog("open");
	    });
	    /*
	    //修改
	    $("#edit").click(function(){
	    	table = $("#editTable");
	    	var selectRows = $("#dataList").datagrid("getSelections");
        	if(selectRows.length != 1){
            	$.messager.alert("消息提醒", "请选择一条数据进行操作!", "warning");
            } else{
		    	$("#editDialog").dialog("open");
            }
	    });
	    //删除
	    $("#delete").click(function(){
	    	var selectRows = $("#dataList").datagrid("getSelections");
        	var selectLength = selectRows.length;
        	if(selectLength == 0){
            	$.messager.alert("消息提醒", "请选择数据进行删除!", "warning");
            } else{
            	var ids = [];
            	$(selectRows).each(function(i, row){
            		ids[i] = row.id;
            	});
            	$.messager.confirm("消息提醒", "如果年级下存在班级信息则无法删除，须先删除年级下属的班级信息？", function(r){
            		if(r){
            			$.ajax({
							type: "post",
							url: "delete",
							data: {ids: ids},
							dataType:'json',
							success: function(data){
								if(data.type == "success"){
									$.messager.alert("消息提醒","删除成功!","info");
									//刷新表格
									$("#dataList").datagrid("reload");
									$("#dataList").datagrid("uncheckAll");
								} else{
									$.messager.alert("消息提醒",data.msg,"warning");
									return;
								}
							}
						});
            		}
            	});
            }
	    });
	    
	    
	  	//设置添加窗口
	    $("#addDialog").dialog({
	    	title: "添加年级",
	    	width: 450,
	    	height: 350,
	    	iconCls: "icon-add",
	    	modal: true,
	    	collapsible: false,
	    	minimizable: false,
	    	maximizable: false,
	    	draggable: true,
	    	closed: true,
	    	buttons: [
	    		{
					text:'添加',
					plain: true,
					iconCls:'icon-user_add',
					handler:function(){
						var validate = $("#addForm").form("validate");
						if(!validate){
							$.messager.alert("消息提醒","请检查你输入的数据!","warning");
							return;
						} else{
							var data = $("#addForm").serialize();
							$.ajax({
								type: "post",
								url: "add",
								data: data,
								dataType:'json',
								success: function(data){
									if(data.type == "success"){
										$.messager.alert("消息提醒","添加成功!","info");
										//关闭窗口
										$("#addDialog").dialog("close");
										//清空原表格数据
										$("#add_name").textbox('setValue', "");
										$("#add_remark").textbox('setValue', "");
										//重新刷新页面数据
							  			$('#dataList').datagrid("reload");
										
									} else{
										$.messager.alert("消息提醒",data.msg,"warning");
										return;
									}
								}
							});
						}
					}
				},
			],
			onClose: function(){
				$("#add_name").textbox('setValue', "");
				$("#add_remark").textbox('setValue', "");
			}
	    });
	  	
	  	//编辑年级信息
	  	$("#editDialog").dialog({
	  		title: "修改年级信息",
	    	width: 450,
	    	height: 350,
	    	iconCls: "icon-edit",
	    	modal: true,
	    	collapsible: false,
	    	minimizable: false,
	    	maximizable: false,
	    	draggable: true,
	    	closed: true,
	    	buttons: [
	    		{
					text:'提交',
					plain: true,
					iconCls:'icon-edit',
					handler:function(){
						var validate = $("#editForm").form("validate");
						if(!validate){
							$.messager.alert("消息提醒","请检查你输入的数据!","warning");
							return;
						} else{
							
							var data = $("#editForm").serialize();
							
							$.ajax({
								type: "post",
								url: "edit",
								data: data,
								dataType:'json',
								success: function(data){
									if(data.type == "success"){
										$.messager.alert("消息提醒","修改成功!","info");
										//关闭窗口
										$("#editDialog").dialog("close");
										
										//重新刷新页面数据
							  			$('#dataList').datagrid("reload");
							  			$('#dataList').datagrid("uncheckAll");
										
									} else{
										$.messager.alert("消息提醒",data.msg,"warning");
										return;
									}
								}
							});
						}
					}
				},
			],
			onBeforeOpen: function(){
				var selectRow = $("#dataList").datagrid("getSelected");
				//设置值
				$("#edit-id").val(selectRow.id);
				$("#edit_arrange").textbox('setValue', selectRow.arrange);
				$("#edit_testt").textbox('setValue', selectRow.testt);
				$("#edit_training").textbox('setValue', selectRow.training);
				$("#edit_sqsj").textbox('setValue', selectRow.sqsj);
			}
	    });
	   	*/
	  	//搜索按钮
	  	$("#search-btn").click(function(){
	  		$('#dataList').datagrid('reload',{
	  			sdId:$("#search-sdId").textbox('getValue')
	  		});
	  	});
	});
	</script>
</head>
<body>
	<!-- 数据列表 -->
	<table id="dataList" cellspacing="0" cellpadding="0"> 
	    
	</table> 
	<!-- 工具栏 -->
	<div id="toolbar">
	<!-- 
		<c:if test="${userType == 1}">
		<div style="float: left;"><a id="add" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a></div>
			<div style="float: left;" class="datagrid-btn-separator"></div>
		<div style="float: left;"><a id="edit" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a></div>
			<div style="float: left;" class="datagrid-btn-separator"></div>
		</c:if>
		<div>
			<c:if test="${userType == 1}">
			<a id="delete" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-some-delete',plain:true">删除</a>
			</c:if>
			
		</div>
		-->
		学生姓名：<input id="search-sdId" class="easyui-textbox" />
			<a id="search-btn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
			
	</div>
	
	<!-- 添加窗口 -->
	<!-- <div id="addDialog" style="padding: 10px;">  
   		<form id="addForm" method="post">
	    	<table id="addTable" cellpadding="8">
	    		<tr >
	    			<td>实习时间安排:</td>
	    			<td>
	    				<input id="add_arrange"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="arrange" data-options="required:true, missingMessage:'请填写实习时间安排'"  />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>岗前测试时间:</td>
	    			<td><input id="add_testt" style="width: 256px; height: 180px;" class="easyui-textbox" type="text" name="testt" data-options="multiline:true, missingMessage:'请填写岗前测试时间'"  /></td>
	    		</tr>
	    		<tr>
	    			<td>培训时间安排:</td>
	    			<td><input id="add_training" style="width: 256px; height: 180px;" class="easyui-textbox" type="text" name="training" data-options="multiline:true, missingMessage:'请填写培训时间安排'"  /></td>
	    		</tr>
	    		<tr>
	    			<td>申请岗位(单位) :</td>
	    			<td><input id="add_sqsj" style="width: 256px; height: 180px;" class="easyui-textbox" type="text" name="sqsj" data-options="multiline:true, missingMessage:'请填写申请岗位(单位)'"  /></td>
	    		</tr>
	    	</table>
	    </form>
	</div>
	 -->
	
	<!-- 修改窗口 -->
	<!--
	<div id="editDialog" style="padding: 10px">
    	<form id="editForm" method="post">
    		<input type="hidden" name="id" id="edit-id">
	    	<table id="editTable" border=0 cellpadding="8" >
	    		<tr >
	    			<td>实习时间安排:</td>
	    			<td>
	    				<input id="add_arrange"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="arrange" data-options="required:true, missingMessage:'请填写实习时间安排'"  />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>岗前测试时间:</td>
	    			<td><input id="add_testt" style="width: 256px; height: 180px;" class="easyui-textbox" type="text" name="testt" data-options="multiline:true, missingMessage:'请填写岗前测试时间'"  /></td>
	    		</tr>
	    		<tr>
	    			<td>培训时间安排:</td>
	    			<td><input id="add_training" style="width: 256px; height: 180px;" class="easyui-textbox" type="text" name="training" data-options="multiline:true, missingMessage:'请填写培训时间安排'"  /></td>
	    		</tr>
	    		<tr>
	    			<td>申请岗位(单位) :</td>
	    			<td><input id="add_sqsj" style="width: 256px; height: 180px;" class="easyui-textbox" type="text" name="sqsj" data-options="multiline:true, missingMessage:'请填写申请岗位(单位)'"  /></td>
	    		</tr>
	    	</table>
	    </form>
	</div>
	 -->
	
</body>
</html>