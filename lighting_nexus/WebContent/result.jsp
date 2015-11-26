<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ include file="/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
<head> 
<title>结果页面</title> 
<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0"> 
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> 
<meta http-equiv="description" content="This is my page"> 
<!-- 
<link rel="stylesheet" type="text/css" href="styles.css"> 
--> 
</head> 
<body> 
	 <c:if test="${retCode =='000'}">
	 	<h2>添加成功！</h2>
	 </c:if>
	 <c:if test="${retCode =='001'}">
	 	<h2>添加失败！</h2>
	 </c:if>
	 <a href="http://121.40.167.45/add_product_info.jsp">返  回</a>
</body> 
</html> 