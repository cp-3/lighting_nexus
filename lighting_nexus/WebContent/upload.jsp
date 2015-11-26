<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
<head> 
<base href="<%=basePath%>"> 
<title>My JSP 'upload.jsp' starting page</title> 
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
<form action="/rest/light/upload-product-image" method="post" enctype="multipart/form-data"> 
请选择上传的图片或文件:<input type="file" name="fileName"/>
	<input type="hidden" id="productId" name="productId" value="1111" />
	<input type="submit" value="上传"/>
</form> 

===================================================================

<form action="/rest/light/upload-test" method="post" enctype="multipart/form-data"> 
请选择上传的图片或文件:<input type="file" name="fileName"/>
	<input type="hidden" id="userId" name="userId" value="0000" />
	<input type="hidden" id="userId1" name="userId1" value="1111" />
	<input type="hidden" id="userId2" name="userId2" value="2222" />
	<input type="hidden" id="userId3" name="userId3" value="3333" />
	<input type="hidden" id="userId4" name="userId4" value="4444" />
	<input type="submit" value="上传"/>
</form> 
</body> 
</html> 