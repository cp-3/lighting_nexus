package com.lighting.front.util;

import java.io.FileOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @生产PDF文件2
 * @author Bill
 * @createtime : 2015年5月12日
 */
public class PdfTest_New2 {
	protected static Log logger = LogFactory.getLog(PdfTest_New2.class);
	// 表头
//	public static final String[] tableHeader = { "项目名称\nProject Name", "天洋广场", "项目编号\nProject No.", "", "区域\nArea", "建筑外立面", "日期\nDate", "2012/12/22" };
	// 数据表字段数
	private static final int TABLE_1_colNumber = 7;
	// 表格的设置
	private static final float spacing = 0.5f;
	// 表格的设置
	private static final float padding = 5;
	
	public static void buildPdf() {
		// 创建文Pdf文挡50, 50, 50,50左右上下距离
		Document document = new Document(PageSize.A3);
		try {
			// 使用PDFWriter进行写文件操作
			PdfWriter.getInstance(document, new FileOutputStream("E:\\LN_1.pdf"));
			document.open();
			// 中文字体
			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font fontChinese8 = new Font(bfChinese, 8, Font.BOLD);
			Font fontChinese16 = new Font(bfChinese, 16, Font.BOLD);
			/**一，创建第一文本行*/
			/**二，创建第一张表*/
			// 创建有colNumber(8)列的表格
			PdfPTable datatable1 = new PdfPTable(TABLE_1_colNumber);
			// 定义表格的宽度
			int[] cellsWidth = { 8, 9, 8, 15, 1, 40, 1};
			datatable1.setWidths(cellsWidth);
			// 表格的宽度百分比
			datatable1.setWidthPercentage(100);
			datatable1.getDefaultCell().setPadding(padding);
			datatable1.getDefaultCell().setBorderWidth(spacing);
			// 设置表格的底色
			datatable1.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
			datatable1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
			// 添加子元素
			datatable1.addCell(new Paragraph("项目名称\nproject", fontChinese8));
			datatable1.addCell(new Paragraph("北京首钢西十筒仓一期", fontChinese8));
			PdfPCell table1_cell1_3 = new PdfPCell(new Paragraph("安装序号  Type:", fontChinese8));
			table1_cell1_3.setPadding(2*padding);
			table1_cell1_3.setBorderWidth(spacing);
			table1_cell1_3.setRowspan(4);
			table1_cell1_3.setVerticalAlignment(Element.ALIGN_BOTTOM);
			datatable1.addCell(table1_cell1_3);
			PdfPCell table1_cell1_4 = new PdfPCell(new Paragraph("CS-02", fontChinese16));
			table1_cell1_4.setPadding(2*padding);
			table1_cell1_4.setBorderWidth(spacing);
			table1_cell1_4.setRowspan(4);
			table1_cell1_4.setVerticalAlignment(Element.ALIGN_BOTTOM);
			datatable1.addCell(table1_cell1_4);
			PdfPCell table1_cell1_5 = new PdfPCell(new Paragraph("", fontChinese8));
			table1_cell1_5.setRowspan(17);
			datatable1.addCell(table1_cell1_5);
			Image jpeg1 = Image.getInstance("E:\\test\\LN_1.jpg");jpeg1.scalePercent(35);jpeg1.setAlignment(Image.LEFT);
			PdfPCell table1_image_cell = new PdfPCell(jpeg1);
			table1_image_cell.setRowspan(17);
			datatable1.addCell(table1_image_cell);
			PdfPCell table1_cell1_7 = new PdfPCell(new Paragraph("", fontChinese8));
			table1_cell1_7.setRowspan(17);
			datatable1.addCell(table1_cell1_7);
			
			datatable1.addCell(new Paragraph("业    主\nproprietor", fontChinese8));
			datatable1.addCell(new Paragraph("", fontChinese8));
			datatable1.addCell(new Paragraph("建筑设计\narchitectural design", fontChinese8));
			datatable1.addCell(new Paragraph("", fontChinese8));
			datatable1.addCell(new Paragraph("日    期\nDesign Date", fontChinese8));
			datatable1.addCell(new Paragraph("2015-04-30", fontChinese8));
			
			datatable1.addCell(new Paragraph("灯具型式\nLuminaires Type", fontChinese8));
			datatable1.addCell(new Paragraph("投光灯", fontChinese8));
			datatable1.addCell(new Paragraph("灯具电压", fontChinese8));
			datatable1.addCell(new Paragraph("◆220V  ◇24V  ◇12V", fontChinese8));
			
			datatable1.addCell(new Paragraph("光源型式\nSource Type", fontChinese8));
			datatable1.addCell(new Paragraph("HIT", fontChinese8));
			datatable1.addCell(new Paragraph("光束角度", fontChinese8));
			datatable1.addCell(new Paragraph("◆NSP  ◇SP  ◇FL  ◇WFL", fontChinese8));
			
			datatable1.addCell(new Paragraph("光源色温\nColour temperature", fontChinese8));
			datatable1.addCell(new Paragraph("4000K", fontChinese8));
			datatable1.addCell(new Paragraph("灯具角度", fontChinese8));
			datatable1.addCell(new Paragraph("◆对称  ◇非对称  ◇FL  ◇可调角度", fontChinese8));
		
			datatable1.addCell(new Paragraph("光源瓦数\nNominal wattage", fontChinese8));
			datatable1.addCell(new Paragraph("70W", fontChinese8));
			datatable1.addCell(new Paragraph("配光曲线", fontChinese8));
			datatable1.addCell(new Paragraph("◆0°~    180°  ◇90°~    270°", fontChinese8));
			
			datatable1.addCell(new Paragraph("洞口尺寸\nHole size", fontChinese8));
			datatable1.addCell(new Paragraph(" ", fontChinese8));
			datatable1.addCell(new Paragraph("光束角度", fontChinese8));
			datatable1.addCell(new Paragraph("6°", fontChinese8));
			
			datatable1.addCell(new Paragraph("灯座\nLamp holder", fontChinese8));
			datatable1.addCell(new Paragraph(" ", fontChinese8));
			datatable1.addCell(new Paragraph("灯具尺寸\nProduct dimensions", fontChinese8));
			datatable1.addCell(new Paragraph("L：211mm W：167mm H：316mm", fontChinese8));
			
			datatable1.addCell(new Paragraph("保护等级\nInternational Protection", fontChinese8));
			PdfPCell table1_cell11_2 = new PdfPCell(new Paragraph("IP65", fontChinese8));
			table1_cell11_2.setColspan(3);
			datatable1.addCell(table1_cell11_2);
			
			datatable1.addCell(new Paragraph("安装方式\nMounting", fontChinese8));
			PdfPCell table1_cell12_2 = new PdfPCell(new Paragraph("表面安装", fontChinese8));
			table1_cell12_2.setColspan(3);
			datatable1.addCell(table1_cell12_2);
			
			datatable1.addCell(new Paragraph("生产厂家\nmanuf.", fontChinese8));
			PdfPCell table1_cell13_2 = new PdfPCell(new Paragraph("ENDO", fontChinese8));
			table1_cell13_2.setColspan(3);
			datatable1.addCell(table1_cell13_2);
			
			datatable1.addCell(new Paragraph("灯具型号\nModel No.", fontChinese8));
			PdfPCell table1_cell14_2 = new PdfPCell(new Paragraph("", fontChinese8));
			table1_cell14_2.setColspan(3);
			datatable1.addCell(table1_cell14_2);
			
			datatable1.addCell(new Paragraph("灯具材质\nMaterials and finish", fontChinese8));
			PdfPCell table1_cell15_2 = new PdfPCell(new Paragraph("铝合金", fontChinese8));
			table1_cell15_2.setColspan(3);
			datatable1.addCell(table1_cell15_2);
			
			datatable1.addCell(new Paragraph("安装位置\nInstallation location", fontChinese8));
			PdfPCell table1_cell16_2 = new PdfPCell(new Paragraph("路灯", fontChinese8));
			table1_cell16_2.setColspan(3);
			datatable1.addCell(table1_cell16_2);
			
			datatable1.addCell(new Paragraph("备注 Remarks", fontChinese8));
			PdfPCell table1_cell17_2 = new PdfPCell(new Paragraph("", fontChinese8));
			table1_cell17_2.setColspan(3);
			datatable1.addCell(table1_cell17_2);
			
			document.add(datatable1);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		buildPdf();
	}
}
