package excel;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by wangb on 2020/4/2.
 */
public class test {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\wangb\\Desktop\\综合查询系统\\新建表\\新建表2.xlsx";
        //得到Excel工作簿对象
        XSSFWorkbook xs = new XSSFWorkbook(new FileInputStream(path));
//        xs.createSheet("sheet3");
        creatContent(xs);
        linkToContent(xs);
        FileOutputStream fileOut = new FileOutputStream(path);
        xs.write(fileOut);
    }

    /**
     * 给xlsx文件添加链接到各个sheet的目录
     * @param xs
     */
    public static void creatContent(XSSFWorkbook xs) {
        CreationHelper createHelper = xs.getCreationHelper();
        // 获得sheet总数，循环获得sheet名
        int num = xs.getNumberOfSheets();
        // 获取sheet数后新增目录sheet，则用i循环时不含此sheet
        Sheet newSheet = xs.createSheet("context");
        String[] str = new String[num];
        for (int i = 0; i < num; i++) {
            str[i] = xs.getSheetName(i);
            System.out.println(str[i]);
            Cell cell = newSheet.createRow(i).createCell(0);
            Hyperlink hyperlink = createHelper.createHyperlink(HyperlinkType.DOCUMENT);
            hyperlink.setAddress("#'" + str[i] + "'!A1");
            cell.setHyperlink(hyperlink);
            cell.setCellValue(str[i]);
        }

    }
    /**
     * 给xlsx文件添加链接到各个sheet的目录
     * @param xs
     */
    public static void linkToContent(XSSFWorkbook xs) {
        CreationHelper createHelper = xs.getCreationHelper();
        Iterator<Sheet> iterator = xs.iterator();
        Iterator<Sheet> sheetIterator = xs.sheetIterator();
        Sheet sheet = null;
        while (iterator.hasNext()) {
            Hyperlink hyperlink = createHelper.createHyperlink(HyperlinkType.DOCUMENT);
            hyperlink.setAddress("#'context'!A1");
            sheet = iterator.next();
            if (!"context".equals(sheet.getSheetName())) {
                Row row = null;
                if (sheet.getRow(0) != null) {
                    row = sheet.getRow(0);
                } else {
                    row = sheet.createRow(0);
                }
                Cell cell = null;
                if (row.getCell(0) != null) {
                    cell = row.getCell(0);
                } else {
                    cell = row.createCell(0);
                }
                cell.setHyperlink(hyperlink);
            }
        }

    }
    public void temp(XSSFWorkbook xs) {
        CreationHelper createHelper = xs.getCreationHelper();
//        XSSFHyperlink  hyperlink = (XSSFHyperlink) createHelper.createHyperlink(HyperlinkType.DOCUMENT);
        Hyperlink hyperlink = createHelper.createHyperlink(HyperlinkType.DOCUMENT);

        // "#"表示本文档    "明细页面"表示sheet页名称  "A10"表示第几列第几行
        hyperlink.setAddress("#sheet3!A1");
        Sheet sheet = xs.getSheetAt(0);
        Row row = sheet.createRow(1);
//        Cell cell = xs.getSheetAt(0).getRow(0).getCell((short)0);
        Cell cell = row.createCell((short) 0);
        cell.setHyperlink(hyperlink);
        // 点击进行跳转
        cell.setCellValue("this is test");

    }
}
