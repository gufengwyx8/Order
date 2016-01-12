<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=basePath%>" />

		<title>Index</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css"
			href="plugin/easyui/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="plugin/easyui/themes/icon.css" />
		<script type="text/javascript" src="plugin/easyui/jquery.min.js"></script>
		<script type="text/javascript"
			src="plugin/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/datagrid.js"></script>
		<script type="text/javascript">
			function getData(){
				var rows=[
					<s:iterator value="foodList" var="c">
					{
						"food.id":"<s:property value='#c.id' escape='false'/>",
						"food.name":"<s:property value='#c.name' escape='false'/>",
						"food.op":"<a href='order/addFood?food.id=<s:property value='#c.id'/>&category.id=<s:property value='category.id'/>'>点菜</a>",
						"food.price":"<s:property value='#c.price' escape='false'/>",
					},
					</s:iterator>
				];
				return rows;
			}
			$(function(){
				initDataGrid($("#dg"),$("#dlg"),$("#fm"),getData());
			});
			function saveSuccess(e){
				if(e=="error"){
					$.messager.alert('提示','菜品信息重复');
				}else if(e=="success"){
					$.messager.alert('提示','保存成功');
					location.href=location.href;
				}
			}
		</script>
	</head>
	<body>
		<jsp:include page="../top.jsp"></jsp:include>
		<div class="mainTitle">
			菜品信息列表
		</div>
		<div style="width:90%;margin:0 auto;">
			餐桌：<s:property value="#session.desk.name"/><br/>
			已选菜品 :<br/><s:iterator value="car" var="f">
				<s:property value="#f.name"/>&nbsp;&nbsp;&nbsp;<s:property value="#f.price"/>元  &nbsp;&nbsp;&nbsp;&nbsp;<a href='order/removeFood?food.id=<s:property value='#f.id'/>&category.id=<s:property value='category.id'/>'>取消</a><br/>
			</s:iterator>
			总价：<s:property value="totalPrice"/>
		</div>
		<div style="width:90%;margin:0 auto;">
			<a href="order/listCategory">返回菜品分类</a>
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="food.name" width="50">菜品名称</th>
						<th field="food.price" width="50">菜品价格</th>
						<th field="food.op" width="50">操作</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
			<s:if test="loginUser.type.toString()=='ADMIN'">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建菜品信息</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改菜品信息</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('order/destoryFood','food.id')">删除菜品信息</a>
			</s:if>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">菜品信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="food.id" />
					<div class="fitem">
						<label>菜品名称:</label>
						<input name="food.name" class="easyui-validatebox" required="true">
					</div>
					<div class="fitem">
						<label>菜品价格:</label>
						<input name="food.price" class="easyui-validatebox" required="true">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('order/saveFood?food.category.id=<s:property value='category.id'/>',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
			<div>
				<a href="order/addOrder" class="easyui-linkbutton">结账</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
