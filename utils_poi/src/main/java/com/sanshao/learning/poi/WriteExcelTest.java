package com.sanshao.learning.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteExcelTest {

    String PATH="";

    @Test
    public void testWrite03() throws IOException {
        //1,创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //2,创建一个工作表
        Sheet sheet = workbook.createSheet("03统计表");
        //3，创建一行（1，1）
        Row row1 = sheet.createRow(0);
        //4，创建一个单元格
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("新增观众");
        //（1，2）
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue(666);
        //第二行（2，1）
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("时间记录");
        //（2，2）
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));

        //生成一张表（IO流）03版本使用xls结尾！
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "03版本测试.xls");
        //输出
        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();

        System.out.println("03生成成功");

    }

    @Test
    public void testWrite07() throws IOException {
        //1,创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        //2,创建一个工作表
        Sheet sheet = workbook.createSheet("03统计表");
        //3，创建一行（1，1）
        Row row1 = sheet.createRow(0);
        //4，创建一个单元格
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("新增观众");
        //（1，2）
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue(666);
        //第二行（2，1）
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("时间记录");
        //（2，2）
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));

        //生成一张表（IO流）03版本使用xls结尾！
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "07版本测试.xlsx");
        //输出
        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();

        System.out.println("07生成成功");

    }

    @Test
    public void testwrite03BigData() throws IOException {
        //时间
        long begin = System.currentTimeMillis();
        //创建一个薄
        Workbook workbook = new HSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream fos = new FileOutputStream(PATH + "03版本Excel大量数据测试.xls");
        workbook.write(fos);
        fos.close();
        System.out.println("over");
        long end = System.currentTimeMillis();
        System.out.println((double) (end - begin) / 1000);
    }

    @Test
    public void testwrite07BigData() throws IOException {
        //时间
        long begin = System.currentTimeMillis();
        //创建一个薄
        Workbook workbook = new XSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        for (int rowNum = 0; rowNum < 100000; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream fos = new FileOutputStream(PATH + "07版本Excel大量数据测试.xlsx");
        workbook.write(fos);
        fos.close();
        System.out.println("over");
        long end = System.currentTimeMillis();
        System.out.println((double) (end - begin) / 1000);
    }

}
