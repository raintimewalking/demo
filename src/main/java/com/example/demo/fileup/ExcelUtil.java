package com.example.demo.fileup;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;

/**
 * @program: springdemo
 * @ClassName ExcelUtil
 * @description:
 * @author: lzy
 * @create: 2021-10-05 17:20
 * @Version 1.0
 **/
public class ExcelUtil {

    /**
     * 下载文件
     *
     * @param fileName  文件名
     * @param sheetName sheet页
     * @param title     标题集合
     * @param values    单元值集合
     * @return ResponseEntity
     */
    public static ResponseEntity<byte[]> exportExcel(
            String fileName,
            String sheetName,
            String[] title,
            String[][] values) {
        try {
            // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet(sheetName);
            HSSFRow row = sheet.createRow(0);
            HSSFCellStyle style = wb.createCellStyle();
            // 创建一个居中格式
            style.setAlignment(HorizontalAlignment.CENTER);
            HSSFCell cell = null;
            //创建标题
            for (int i = 0; i < title.length; i++) {
                cell = row.createCell(i);
                cell.setCellValue(title[i]);
                cell.setCellStyle(style);
            }

            for (int i = 0; i < title.length; i++) {
                sheet.autoSizeColumn(i);
                sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 17 / 10);
            }

            // 创建内容
            for (int i = 0; i < values.length; i++) {
                row = sheet.createRow(i + 1);
                for (int j = 0; j < values[i].length; j++) {
                    //将内容按顺序赋给对应的列对象
                    if (null == values[i][j] || values[i][j].trim().length() == 0) {
                        row.createCell(j).setCellValue("");
                    } else {
                        row.createCell(j).setCellValue(values[i][j]);
                    }
                }
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            HttpHeaders headers = new HttpHeaders();
            // headers.add("Content-Type", "application/octet-stream;charset=utf-8");
            headers.add("Content-Type", "application/vnd.ms-excel");
            headers.add("Connection", "close");
            headers.add("Accept-Ranges", "bytes");
            headers.add("Content-Disposition", "attachment;filename="
                    + new String(fileName.getBytes("gbk"), "ISO-8859-1"));
            wb.write(baos);
            return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException("export excel exception");
        }
    }
}