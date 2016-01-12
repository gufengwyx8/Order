<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="container">
	<div class="header">
		<div class="title">
			<div>
				酒店餐饮管理系统
			</div>
		</div>
		<ul>
			<s:if test="loginUser!=null">
				<li>
					欢迎,
					<s:property value="loginUser.typeName"/><s:property value="loginUser.name" />
				</li>
				<li>
					<a href="#" onclick="$('#pwd-dlg').dialog('open').dialog('setTitle','修改密码');$('#pwd-fm').form('clear');return false;">修改密码</a>
				</li>
				<li>
					<a href="logout">登出</a>
				</li>
			</s:if>
			<s:else>
				<li>
					<a href="reg">注册</a>
				</li>
				<li>
					<a href="login">登录</a>
				</li>
			</s:else>
		</ul>
	</div>
	<div class="navList">
		<ul>
			<li>
				<a href="index">首页</a>
			</li>
			<li>
				<a href="order/index">点菜</a>
			</li>
			<s:if test="loginUser.type.toString()=='ADMIN'">
				<li>
					<a href="report/dayReport">日结账报表</a>
				</li>
				<li>
					<a href="report/monthReport">月结账报表</a>
				</li>
			</s:if>
		</ul>
		<div id="pwd-dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#pwd-dlg-buttons">
			<div class="ftitle">修改密码</div>
			<form id="pwd-fm" method="post" novalidate>
				<div class="fitem">
					<label>旧密码:</label>
					<input type="password" name="oldPassword">
				</div>
				<div class="fitem">
					<label>新密码:</label>
					<input type="password" name="newPassword1" >
				</div>
				<div class="fitem">
					<label>确认密码:</label>
					<input type="password" name="newPassword2">
				</div>
			</form>
		</div>
		<div id="pwd-dlg-buttons">
			<script type="text/javascript">
				function changePassword(){
					$.post("password",$("#pwd-fm").serialize(),function(result){
						if(result=='old error'){
							$.messager.alert("提示","原始密码不正确");
						}else if(result=='new error'){
							$.messager.alert("提示","新密码不一致");
						}else{
							$.messager.alert("提示","修改成功");
							$('#pwd-dlg').dialog('close');
						}
					},'text');
				}
			</script>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="changePassword();">修改</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#pwd-dlg').dialog('close')">取消</a>
		</div>
	</div>
	<div class="main">
		<div class="mainBody">