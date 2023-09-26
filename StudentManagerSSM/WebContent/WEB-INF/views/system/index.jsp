<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>学生实习管理网站 管理员后台</title>
    <link rel="shortcut icon" href="favicon.ico"/>
	<link rel="bookmark" href="favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="../easyui/css/default.css" />
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" />
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='../easyui/js/outlook2.js'> </script>
    <script type="text/javascript">
    var _menus = {"menus":[
		<c:if test="${userType == 1}">
		{"menuid":"1","icon":"","menuname":"用户（管理员）管理",
			"menus":[
					{"menuid":"11","menuname":"用户列表","icon":"icon-user-teacher","url":"../user/list"}
				]
		},
		</c:if>
		<c:if test="${userType == 1||userType == 3}">
		{"menuid":"0","icon":"","menuname":"教师管理",
			"menus":[
					{"menuid":"11","menuname":"教师列表","icon":"icon-user-teacher","url":"../teacher/list"}
				]
		},
		</c:if>
		{"menuid":"8","icon":"","menuname":"学生管理",
			"menus":[
					{"menuid":"81","menuname":"学生管理","icon":"icon-user_add","url":"../student/list"},
				]
		},
		{"menuid":"2","icon":"","menuname":"通知公告",
			"menus":[
					{"menuid":"81","menuname":"顶岗实习通知","icon":"icon-user_add","url":"../inform/list"},
				]
		},
		{"menuid":"3","icon":"","menuname":"实习单位信息",
			"menus":[
					{"menuid":"31","menuname":"实习单位信息","icon":"icon-world","url":"../units/list"},
				]
		},
		{"menuid":"4","icon":"","menuname":"顶岗实习申请",
			"menus":[
					{"menuid":"41","menuname":"自主实习","icon":"icon-world","url":"../independent/list"},
					{"menuid":"42","menuname":"志愿申请","icon":"icon-world","url":"../volunteer/list"},
				]
		},
		{"menuid":"5","icon":"","menuname":"实习过程",
			"menus":[
					{"menuid":"51","menuname":"实习过程","icon":"icon-house","url":"../processs/list"},
					{"menuid":"51","menuname":"变更实习安排申请报告","icon":"icon-house","url":"../baogao/list"},
				]
		},
		{"menuid":"6","icon":"","menuname":"评价管理",
			"menus":[
					{"menuid":"61","menuname":"评价","icon":"icon-user-student","url":"../pjgl/list"},
				]
		},
		{"menuid":"7","icon":"","menuname":"统计与分析",
			"menus":[
					{"menuid":"71","menuname":"统计与分析","icon":"icon-chart_bar","url":"../statistics/list"},
					//statistics
				]
		},
		
]};


    </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
	<noscript>
		<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
		    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background:  #7f99be;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head"><span style="color:red; font-weight:bold;">${user.username}&nbsp;</span>您好&nbsp;&nbsp;&nbsp;<a href="login_out" id="loginOut">安全退出</a></span>
        <span style="padding-left:10px; font-size: 16px; ">学生实习管理网站</span>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">Copyright &copy;2020 zjj All rights reserved </div>
    </div>
    <div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
	<div id="nav" class="easyui-accordion" fit="true" border="false">
		<!--  导航内容 -->
	</div>
	
    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<jsp:include page="welcome.jsp" />
		</div>
    </div>
	
</body>
</html>