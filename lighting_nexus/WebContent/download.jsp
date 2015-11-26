<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
<head> 
<title>Lighting Nexus</title> 
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0"> 
 <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> 
<meta http-equiv="description" content="This is my page"> 
<style>
.tab{
	margin: 50px;
}
</style>	
</head> 
<body> 
<table border="1" cellpadding="1" cellspacing="0"  width="90%" class="tab">
	<tr>
		<td colspan="5" align="center"><strong>灯具信息 Lamp Infomation</strong></td>
	</tr>
	<tr>
		<td width="11%">项目名称<br/>project</td>
		<td width="10%">北京首钢西十筒仓一期</td>
		<td width="12%" rowspan="4">安装序号<br/>Type:</td>
		<td width="17%" rowspan="4">CS-02</td>
		<td width="50%" rowspan="17"><img width="100%" alt="" src="images/LN_1.jpg"></td>
	</tr>
	<tr>
		<td>业 主<br/>proprietor</td>
		<td></td>
	</tr>
	<tr>
		<td>建筑设计<br/>architectural design</td>
		<td></td>
	</tr>
	<tr>
		<td>日 期<br/>Design Date</td>
		<td>2015-04-30</td>
	</tr>
	<tr>
		<td>灯具型式<br/>Luminaires Type</td>
		<td>投光灯</td>
		<td>灯具电压</td>
		<td>◆220V ◇24V ◇12V</td>
	</tr>
	<tr>
		<td>光源型式<br/>Source Type</td>
		<td>HIT</td>
		<td>光束角度</td>
		<td>◆NSP ◇SP ◇FL ◇WFL</td>
	</tr>
	<tr>
		<td>光源色温<br/>Colour temperature</td>
		<td>4000K</td>
		<td>灯具角度</td>
		<td>◆对称 ◇非对称 ◇FL ◇可调角度</td>
	</tr>
	<tr>
		<td>光源瓦数<br/>Nominal wattage</td>
		<td>70W</td>
		<td>配光曲线</td>
		<td>◆0°~ 180° ◇90°~ 270°</td>
	</tr>
	<tr>
		<td>洞口尺寸<br/>Hole size</td>
		<td></td>
		<td>光束角度</td>
		<td>6°</td>
	</tr>
	<tr>
		<td>灯座<br/>Lamp holder</td>
		<td></td>
		<td>灯具尺寸<br/>Product dimensions</td>
		<td>L：211mm W：167mm H：316mm</td>
	</tr>
	<tr>
		<td>保护等级<br/>International Protection</td>
		<td colspan="3">IP65</td>
	</tr>
	<tr>
		<td>安装方式<br/>Mounting</td>
		<td colspan="3">表面安装</td>
	</tr>
	<tr>
		<td>生产厂家<br/>manuf.</td>
		<td colspan="3">ENDO</td>
	</tr>
	<tr>
		<td>灯具型号<br/>Model No.</td>
		<td colspan="3"></td>
	</tr>
	<tr>
		<td>灯具材质<br/>Materials and finish</td>
		<td colspan="3">铝合金</td>
	</tr>
	<tr>
		<td>安装位置<br/>Installation location</td>
		<td colspan="3">路灯</td>
	</tr>
	<tr>
		<td>备注 Remarks</td>
		<td colspan="3"></td>
	</tr>
	<tr>
		<td colspan="5" align="center"><h2><a href="<%=request.getContextPath()%>/rest/light/pdf/download" id="pluginurl"  style="color: #83AFE2;text-decoration:underline;">下载</a></h2></td>
	</tr>
</table>

</body> 
<script type="text/javascript">
 </script>
</html> 