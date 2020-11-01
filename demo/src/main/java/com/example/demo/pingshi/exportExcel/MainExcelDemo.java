package com.example.demo.pingshi.exportExcel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;

/**
 * @author zhangyu
 * @date 2019/12/4 17:03
 */
public class MainExcelDemo {

    public static void main(String[] args) {

        //web对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建表头等
        HSSFSheet sheet = wb.createSheet("test1");
        //创建行
        HSSFRow row = sheet.createRow(0);

        //创建列
        HSSFCell cell = row.createCell(0);

        HSSFCell cell2 = row.createCell(2);
        cell2.setCellValue("嗯哼");
        cell.setCellValue("我是写入的值");
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

        try {
            FileOutputStream output = new FileOutputStream("/Users/zhangyu/JAKARTA.xls");
            wb.write(output);
            output.flush();
            System.out.println("成功创建excel文件");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
