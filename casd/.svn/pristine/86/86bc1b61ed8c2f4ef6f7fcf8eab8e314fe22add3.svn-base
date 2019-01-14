package com.casd.controller.web.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 导入表格数据辅助类
 * @author Administrator
 *
 */
public class ImportExcel {
	// 创建工作簿
	private HSSFWorkbook workBook = new HSSFWorkbook();
	// 文件保存路径
	private String url;
	// 文件名称
	private String fileName;
	// 单元格复制样式（字符串格式）
	private int cellType = HSSFCell.CELL_TYPE_STRING;
	private HSSFCellStyle headerStyle = this.getHeaderStyle();

	// 创建sheet页
	HSSFSheet sheet;
	// 标题行样式
	private HSSFCellStyle titleStyle = this.getTitleStyle();

	public HSSFCellStyle getTitleStyle() {
		HSSFCellStyle style = workBook.createCellStyle();
		HSSFFont font = workBook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 12);// 设置字体大小
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上线居中
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setWrapText(true);
		style.setFont(font);
		return style;
	}

	public HSSFCellStyle getHeaderStyle() {

		HSSFCellStyle style = workBook.createCellStyle();
		HSSFFont font = workBook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗體
		font.setFontHeight((short) (9 * 20));
		font.setFontHeightInPoints((short) 22);

		font.setFontName("宋体");// 字體樣式

		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上线居中
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setWrapText(true);
		style.setFont(font);

		return style;
	}

	private List<Column> columns;

	/**
	 * 创建sheet页
	 * 
	 * @param sheetName
	 *            sheet页名称
	 */
	public void createSheet(String sheetName) {

		this.sheet = workBook.createSheet(sheetName);

	}

	 public static void main(String[] args) throws IOException {
		 Date date_root = new Date(2010, 1, 1);
		 long id = System.currentTimeMillis();
		 String temp = "" + id;
			if (8 < temp.length())
				temp = temp.substring(temp.length() - 8, temp.length());
	 
	 }

	/**
	 * 插入标题方法
	 * 
	 * @param title
	 *            标题名称
	 * @param rowNum
	 *            插入多少行
	 * @param colspan
	 *            跨多少列
	 */
	public void insertTitle(String title, int rowNum, int colspan) {
		if (null == sheet) {

			sheet = workBook.createSheet();
		}
		sheet.shiftRows(rowNum, sheet.getLastRowNum(), 1, true, false);
		sheet.addMergedRegion(new CellRangeAddress(rowNum, 0, rowNum, colspan));
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCell cell = row.createCell(rowNum, 0);
		cell.setCellStyle(titleStyle);
		HSSFRichTextString text = new HSSFRichTextString(title);
		cell.setCellValue(text);
	}

	/**
	 * 添加数据
	 * 
	 * @param data
	 */
	public void addData(List<Map<String, Object>> data) {
		if (columns == null) {

		}
		if (null == sheet) {

			sheet = workBook.createSheet();
		}
		int column_index = 0;
		int rowNo = sheet.getLastRowNum();
		HSSFRow rows = sheet.createRow(rowNo);
		for (Column column : columns) {

			HSSFCell cell = rows.createCell(column_index++);
			cell.setCellType(column.getCellType());
			cell.setCellStyle(titleStyle);
			HSSFRichTextString text = new HSSFRichTextString(column.getHeader());
			cell.setCellValue(text);

		}

		for (Map<String, Object> row : data) {
			int index = 0;
			int rowindex = sheet.getLastRowNum();
			HSSFRow datarow = sheet.createRow(rowindex + 1);

			for (Column column : columns) {
				Object v = null;
				if (column.hanlder != null)
					v = column.hanlder.hanlder(row, column.getField());
				else
					v = row.get(column.getField());

				HSSFCell datacelll = datarow.createCell(index++);
				datacelll.setCellType(column.getCellType());
				HSSFRichTextString text = new HSSFRichTextString(v.toString());
				datacelll.setCellValue(text);
			}
		}
	}

	/**
	 * 添加普通字符串列数据
	 * 
	 * @param headerMap
	 *            表头
	 * @throws IOException
	 */
	public void addColumn(String headStr, String field, int width) {

		if (columns == null) {
			columns = new ArrayList<Column>();
		}
		Column column = new Column();
		column.setHeader(headStr);
		column.setField(field);
		column.setWidth(width);
		columns.add(column);
	}

	/**
	 * 添加布尔类型数据
	 * 
	 * @param colmun
	 * @param filed
	 * @param map
	 */
	public void setBolleanValue(String headStr, String field, int width,
			IRowBindHanlder hanlder) {
		if (columns == null) {
			columns = new ArrayList<Column>();
		}
		Column column = new Column();
		column.setHeader(headStr);
		column.setField(field);
		column.setWidth(width);
		column.setCellType(HSSFCell.CELL_TYPE_STRING);
		column.setHanlder(hanlder);
		columns.add(column);

	}

	/**
	 * double类型数据插入
	 * 
	 * @param headStr
	 * @param field
	 * @param width
	 */
	public void setDoubleVlue(String headStr, String field, int width) {

		if (columns == null) {
			columns = new ArrayList<Column>();
		}
		Column column = new Column();
		column.setHeader(headStr);
		column.setField(field);
		column.setWidth(width);
		column.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		columns.add(column);
	}

	/**
	 * 插入整形数据；
	 * 
	 * @param headStr
	 * @param field
	 * @param width
	 * @param hanlder
	 */
	public void setIntegert(String headStr, String field, int width) {
		if (columns == null) {
			columns = new ArrayList<Column>();
		}
		Column column = new Column();
		column.setHeader(headStr);
		column.setField(field);
		column.setWidth(width);
		column.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		columns.add(column);
	}

	/**
	 * 插入键值对形式的数据
	 * 
	 * @param headStr
	 *            表头
	 * @param field
	 *            表头的字符串
	 * @param width
	 *            宽度
	 * @param hanlder
	 *            需要自己去实现该类的方法
	 */
	public void addMapValue(String headStr, String field, int width,
			IRowBindHanlder hanlder) {

		if (columns == null) {
			columns = new ArrayList<Column>();
		}
		Column column = new Column();
		column.setHeader(headStr);
		column.setField(field);
		column.setWidth(width);
		column.setCellType(HSSFCell.CELL_TYPE_STRING);
		column.setHanlder(hanlder);
		columns.add(column);

	}

	public void out() throws IOException {

		FileOutputStream out = new FileOutputStream(
				"C:\\Users\\poi_comment.xls");
		workBook.write(out);
		out.close();
	}

	class Column {
		public String getHeader() {
			return header;
		}

		public void setHeader(String header) {
			this.header = header;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public IRowBindHanlder getHanlder() {
			return hanlder;
		}

		public void setHanlder(IRowBindHanlder hanlder) {
			this.hanlder = hanlder;
		}

		private int cellType;

		public int getCellType() {
			return cellType;
		}

		public void setCellType(int cellType) {
			this.cellType = cellType;
		}

		private String header;
		private String field;
		private int width;
		private IRowBindHanlder hanlder;
	}

	public List<StringBuffer> readXls(String url) throws IOException {
		InputStream is = new FileInputStream(url);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		List<StringBuffer> list = new ArrayList<StringBuffer>();
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			

			// 循环行Row
			StringBuffer sb = null;
			for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}

				// 循环列Cell
				sb = new StringBuffer();
				for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
					HSSFCell hssfCell = hssfRow.getCell(cellNum);
					if (hssfCell == null) {
						sb.append(" #");
					}else{
						sb.append(getValue1(hssfCell).trim()+"#");
					}
					
				}
				list.add(sb);
			}
		}
		return list;
	}

	@SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}
	
	private String getValue1(HSSFCell hssfCell) {
		DecimalFormat df = new DecimalFormat("0.00");  
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			if(hssfCell.getNumericCellValue()<1){
				df = new DecimalFormat("0.00"); 
			}
			return String.valueOf(df.format(hssfCell.getNumericCellValue()));
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}
	
	/**
     * 读取Office 2007 excel
     * */
    public List<List<Object>> read2007Excel(File file)
            throws IOException {
        List<List<Object>> list = new ArrayList<List<Object>>();
        // 构造 XSSFWorkbook 对象，strPath 传入文件路径
        XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
        // 读取第一章表格内容
        XSSFSheet sheet = xwb.getSheetAt(0);
        Object value = null;
        XSSFRow row = null;
        XSSFCell cell = null;
        int counter = 0;
        for (int i = sheet.getFirstRowNum(); counter < sheet
                .getPhysicalNumberOfRows(); i++) {
            row = sheet.getRow(i);
            if (row == null) {
                continue;
            } else {
                counter++;
            }
            List<Object> linked = new LinkedList<Object>();
            if(row.getLastCellNum()==-1) continue;
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (cell == null) {
                    continue;
                }
                DecimalFormat df = new DecimalFormat("0.00");// 格式化 number String
                                                            // 字符
                SimpleDateFormat sdf = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
                DecimalFormat nf = new DecimalFormat("0.000");// 格式化数字
                switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_NUMERIC:
                    if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                        value = df.format(cell.getNumericCellValue());
                    } else if ("General".equals(cell.getCellStyle()
                            .getDataFormatString())) {
                        value = nf.format(cell.getNumericCellValue());
                    } else {
                        value = sdf.format(HSSFDateUtil.getJavaDate(cell
                                .getNumericCellValue()));
                    }
                    break;
                case XSSFCell.CELL_TYPE_BOOLEAN:
                    value = cell.getBooleanCellValue();
                    break;
                case XSSFCell.CELL_TYPE_BLANK:
                    value = "";
                    break;
                default:
                    value = cell.toString();
                }
                linked.add(value);
            }
            list.add(linked);
        }
        return list;
    }

}
