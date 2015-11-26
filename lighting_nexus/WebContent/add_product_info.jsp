<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
<head> 
<title>新增产品信息</title> 
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0"> 
 <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> 
<meta http-equiv="description" content="This is my page"> 
<!-- 
<link rel="stylesheet" type="text/css" href="styles.css"> 
--> 
</head> 
<body> 
<form action="/rest/light/add-product-info" method="post" enctype="multipart/form-data"> 
	产品名称：<input type="text" id="productName" name="productName" value=""/><br/><br/>
	型&nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text" id="modelType"   name="modelType"   value=""/><br/><br/>
	安装类型：<select name="installType">
				<option value="0">其他</option>
				<option value="1">轨道</option>
				<option value="2">埋入式</option>
				<option value="3">明装</option>
				<option value="4">吊装</option>
				<option value="5">明装壁灯</option>
				<option value="6">埋入式壁灯</option>
				<option value="7">地埋</option>
		   </select><br/><br/>
	安装类型：<select name="functionType">
				<option value="0">其他</option>
				<option value="1">圆形光斑</option>
				<option value="2">圆形光斑可调角度</option>
				<option value="3">椭圆光斑</option>
				<option value="4">洗墙灯</option>
				<option value="5">投影灯</option>
				<option value="6">掠射光</option>
				<option value="7">上出光</option>
				<option value="8">下出光</option>
				<option value="9">上下出光</option>
				<option value="10">侧出光</option>
			</select><br/><br/>
	光&nbsp;&nbsp;&nbsp;&nbsp;强：<input type="text" id="lightStrength"   name="lightStrength"   value=""/><br/><br/>
	光源类型：<select name="lightSouType">
				<option value="0">其他</option>
				<option value="1">LED</option>
				<option value="2">卤素灯</option>
				<option value="3">金卤灯</option>
				<option value="4">紧凑型荧光灯</option>
				<option value="5">直管荧光灯</option>
			</select><br/><br/>
	外观图片：<input type="file" id="appearanceImgFile" name="appearanceImgFile" value=""/><br/><br/>
	尺寸图片：<input type="file" id="sizeImgFile" name="sizeImgFile" value=""/><br/><br/>
	配光图片：<input type="file" id="gradingImgFile" name="gradingImgFile" value=""/><br/><br/>
	备用图片：<input type="file" id="backupImgFile" name="backupImgFile" value=""/><br/><br/>
	功&nbsp;&nbsp;&nbsp;&nbsp;率：<input type="text" id="power" name="power" value="" /><br/><br/>
	显  色  性：<input type="text" id="showColAttr" name="showColAttr" value="" /><br/><br/>
	色&nbsp;&nbsp;&nbsp;&nbsp;温：<input type="text" id="colorTemp" name="colorTemp" value="" /><br/><br/>
	项目&nbsp;&nbsp;ID：<input type="text" id="projectId" name="projectId" value="" /><br/><br/>
	项目名称：<input type="text" id="projectName" name="projectName" value="" /><br/><br/>
	品牌&nbsp;&nbsp;ID：<input type="text" id="brandId" name="brandId" value="" /><br/><br/>
	品牌名称：<input type="text" id="brandName" name="brandName" value="" /><br/><br/>
	地&nbsp;&nbsp;&nbsp;&nbsp;址：<input type="text" id="address" name="address" value="" /><br/><br/>
	参 考 价：<input type="text" id="refPrice" name="refPrice" value="" /><br/><br/>
	货&nbsp;&nbsp;&nbsp;&nbsp;期：<input type="text" id="deliveryTime" name="deliveryTime" value="" /><br/><br/>
	保 修 期：<input type="text" id="warrPeriod" name="warrPeriod" value="" /><br/><br/>
	均 匀 度：<input type="text" id="uniformity" name="uniformity" value="" /><br/><br/>
	截 光 角：<input type="text" id="cutoffAngle" name="cutoffAngle" value="" /><br/><br/>
	备&nbsp;&nbsp;&nbsp;&nbsp;注：<input type="text" id="remark" name="remark" value="" /><br/><br/>
	<input type="hidden" id="size" name="size" value="" />
	<input type="submit" value="添加"/>
</form> 
</body> 
<script type="text/javascript">
</script>

</html> 