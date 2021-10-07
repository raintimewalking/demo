package com.example.demo.excelparseanddown;

import com.sun.deploy.net.HttpResponse;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @program: demo
 * @ClassName ExcelParse
 * @description:
 * @author: lzy
 * @create: 2021-10-07 17:17
 * @Version 1.0
 **/
@Controller
public class ExcelParse {
    public static void main(String[] args) {
        String addr = "D:\\test.xlsx";
        File file = new File(addr);
//        excelParse(file);
    }


    public  void excelParse(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
            XSSFName name = sheets.getName("1");
            List<XSSFName> allNames = sheets.getAllNames();
            XSSFSheet sheetAt = sheets.getSheetAt(0);
            int activeSheetIndex = sheets.getActiveSheetIndex();
            XSSFRow row = sheetAt.getRow(0);
            XSSFCell cell = row.getCell(0);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/excel")
    public void download(HttpServletResponse response) throws IOException {

        XSSFWorkbook sheets = new XSSFWorkbook();
        XSSFSheet test1 = sheets.createSheet("test1");
        XSSFRow row = test1.createRow(0);
        String[] title = { "监控点编号", "监控点名称", "检测日期时间", "检测类型", "故障类型", "故障描述", "检测码流类型", "视频质量级别",
                "检测录像保存位置", "检测录像保存天数","录像丢失时段描述", "报警处理结果", "报警处理描述" };
        for (int i = 0; i < title.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
//        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=" + new String("hello".getBytes(),"iso-8859-1") + ".xls");
        response.setContentType("application/x-download");
        ServletOutputStream outputStream = response.getOutputStream();
        sheets.write(outputStream);
    }
}