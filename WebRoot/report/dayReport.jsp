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
	
</script>
	</head>
	<body>
		<jsp:include page="../top.jsp"></jsp:include>
		<div class="mainTitle">
			日结账报表
		</div>
		<div style="width: 90%; margin: 0 auto;">
			<s:form action="dayReport" namespace="/report">
				<s:textfield name="date" label="日期" cssClass="easyui-datebox"
					data-options="formatter:myformatter,parser:myparser">
					<s:param name="value">
						<s:date name="date" format="yyyy-MM-dd" />
					</s:param>
				</s:textfield>
				<s:submit value="查询"/>
			</s:form>
			<table class="detail_table">
				<tr>
					<td>日期</td>
					<td>餐台号</td>
					<td>价格</td>
				</tr>
				<s:iterator value="orderList" var="o">
					<tr>
						<td><s:date name="#o.date" format="yyyy-MM-dd"/></td>
						<td><s:property value="#o.desk.name"/></td>
						<td><s:property value="#o.price"/></td>
					</tr>
				</s:iterator>
				<tr>
					<td></td><td></td><td>总价：<s:property value="totalPrice"/></td>
				</tr>
			</table>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
