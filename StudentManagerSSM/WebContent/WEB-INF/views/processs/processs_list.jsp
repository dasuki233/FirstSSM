<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>实习过程</title>
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../easyui/css/demo.css">
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/js/validateExtends.js"></script>
	<script type="text/javascript">
	var studentList = ${studentListJson};
	$(function() {	
		var table;
		
		//datagrid初始化 
	    $('#dataList').datagrid({ 
	        title:'实习过程列表', 
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
	        nowrap:false, 
	        columns: [[  
				{field:'chk',checkbox: true,width:50},
				{field:'id',title:'ID',width:50, sortable: true},
 		        {field:'sdId',title:'姓名',width:150, sortable: true},
 		        {field:'czjl',title:'成长记录',width:150, sortable: true},
 		        //成长记录(未实习-实习中-已完成实习)
 		        //下拉框
 		        {field:'fbqk',title:'分布情况',width:150,sortable: true},
 		        {field:'bgjh',title:'变更实习计划',width:100,sortable: true},
 		        //实习计划(回校-参加工作中)
 		        //下拉框
 		        {field:'remark',title:'留言',width:1000,sortable: true},
 		        //上传留言
	 		]], 
	        toolbar: "#toolbar"
	    }); 
	    //设置分页控件 
	    var p = $('#dataList').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,//每页显示的记录条数，默认为10 
	        pageList: [10,20,30,50,100],//可以设置每页记录条数的列表 
	        beforePageText: '第',//页数文本框前显示的汉字 
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	    }); 
	    //设置工具类按钮
	    $("#add").click(function(){
	    	table = $("#addTable");
	    	$("#addDialog").dialog("open");
	    });
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
            	$.messager.confirm("消息提醒", "请确定删除？", function(r){
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
	    	height: 400,
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
										$("#add_sdId").textbox('setValue', "");
										$("#add_czjl").textbox('setValue', "");
										$("#add_fbqk").textbox('setValue', "");
										$("#add_bgjh").combobox('setValue', "");
										$("#add_remark").val( "");
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
				$("#add_sdId").textbox('setValue', "");
				$("#add_czjl").textbox('setValue', "");
				$("#add_fbqk").textbox('setValue', "");
				$("#add_bgjh").combobox('setValue', "");
				$("#add_remark").val( "");
			}
	    });
	  	
	  	//编辑年级信息
	  	$("#editDialog").dialog({
	  		title: "修改年级信息",
	    	width: 450,
	    	height: 400,
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
				$("#edit_sdId").textbox('setValue', selectRow.sdId);
				$("#edit_czjl").textbox('setValue', selectRow.czjl);
				$("#edit_fbqk").textbox('setValue', selectRow.fbqk);
				$("#edit_bgjh").combobox('setValue',selectRow.bgjh);
				$("#edit_remark").val(selectRow.remark);
			}
	    });
	   	
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
		<c:if test="${userType == 1||userType == 3}">
		<div style="float: left;"><a id="add" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a></div>
			<div style="float: left;" class="datagrid-btn-separator"></div>
		</c:if>
		<div style="float: left;"><a id="edit" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a></div>
			<div style="float: left;" class="datagrid-btn-separator"></div>
		
		<div>
			<c:if test="${userType == 1||userType == 3}">
			<a id="delete" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-some-delete',plain:true">删除</a>
			</c:if>
			学生姓名：<input id="search-sdId" class="easyui-textbox" />
			<a id="search-btn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
		</div>
	</div>
	
	<!-- 添加窗口 -->
	<div id="addDialog" style="padding: 10px;">  
   		<form id="addForm" method="post">
	    	<table id="addTable" cellpadding="8">
	    		<tr>
	    	        <td>学生姓名:</td>
	    	        <td><input id="add_sdId" style="width: 256px; height: 30px;" class="easyui-textbox" type="text" name="sdId" data-options="multiline:true, missingMessage:'请填写姓名'"  /></td>
	    	    </tr>
	    		<tr>
	    			<td>成长记录:</td>
	    			<td><input id="add_czjl" style="width: 256px; height: 50px;" class="easyui-textbox" type="text" name="czjl" data-options="multiline:true, missingMessage:'请填写成长记录'"  /></td>
	    		</tr>
	    		<tr>
	    		<tr>
	    			<td>分布情况:</td>
	    			<td><input id="add_fbqk" style="width: 256px; height: 50px;" class="easyui-textbox" type="text" name="fbqk" data-options="multiline:true, missingMessage:'请填写分布情况'"  /></td>
	    		</tr>
	    		<tr>
	    			<td>变更计划 :</td>
	    			<td>
	    				<select id="add_bgjh"  class="easyui-combobox" style="width: 256px;" name="bgjh" data-options="required:true, missingMessage:'请选择变更计划'">
	    					<option value="已就业">已就业</option>
	    					<option value="已辞职">已辞职</option>
	    					<option value="寻找工作中">未就业</option>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>留言:</td>
	    			<td><textarea id="add_remark" style="width: 256px; height: 80px;" name="remark" class="easyui-validatebox" placeholder="字数禁止超过300字" ></textarea></td>
	    		</tr>
	    	</table>
	    </form>
	</div>
	
	
	<!-- 修改窗口 -->
	<div id="editDialog" style="padding: 10px">
    	<form id="editForm" method="post">
    		<input type="hidden" name="id" id="edit-id">
	    	<table id="editTable" border=0 cellpadding="8" >
	    		<tr>
	    	        <td>学生姓名:</td>
	    	        <td><input id="edit_sdId" style="width: 256px; height: 50px;" class="easyui-textbox" type="text" name="sdId" data-options="multiline:true, missingMessage:'请填写姓名'"  /></td>
	    	    </tr>
	    		<tr>
	    			<td>成长记录:</td>
	    			<td><input id="edit_czjl" style="width: 256px; height: 50px;" class="easyui-textbox" type="text" name="czjl" data-options="multiline:true, missingMessage:'请填写成长记录'"  /></td>
	    		</tr>
	    		<tr>
	    			<td>分布情况:</td>
	    			<td><input id="edit_fbqk" style="width: 256px; height: 50px;" class="easyui-textbox" type="text" name="fbqk" data-options="multiline:true, missingMessage:'请填写分布情况'"  /></td>
	    		</tr>
	    		<tr>
	    			<td>变更计划 :</td>
	    			<td>
	    				<select id="edit_bgjh"  class="easyui-combobox" style="width: 256px;" name="bgjh" data-options="required:true, missingMessage:'请选择变更计划'">
	    					<option value="已就业">已就业</option>
	    					<option value="已辞职">已辞职</option>
	    					<option value="寻找工作中">未就业</option>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>留言:</td>
	    			<td><textarea id="edit_remark" style="width: 256px; height: 80px;" name="remark" class="easyui-validatebox" placeholder="字数禁止超过300字" ></textarea></td>
	    		</tr>
	    	</table>
	    </form>
	    <!--  <form id="photoForm" method="post" enctype="multipart/form-data" action="upload_photo" target="photo_target">
	    	<table id="addTable1" cellpadding="8">
	    		<tr >
	    			<td>上传实习内容:</td>
	    			<td>
	    				<input id="edit-upload-photo" class="easyui-filebox" name="photo" data-options="prompt:'选择照片'" style="width:200px;">
	    				<a id="upload-btn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">上传图片</a>
	    			</td>
	    		</tr>
	    	</table>
	    </form>
	    -->
	</div>
	
	
</body>
</html>