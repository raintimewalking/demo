package com.example.demo.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.example.demo.excel.bean.ExcelData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/excel")
@Controller
public class EaysExcelDownloadController {

    @RequestMapping("/write")
    public void excelDownload(HttpServletResponse response) throws IOException {
        System.out.println("==========");
        ExcelData excelData = new ExcelData();
        ExcelData excelData1 = new ExcelData();
        List<ExcelData> resultList = new ArrayList<>();
        excelData.setId("1");
        excelData.setName("one");
        excelData.setAge("10");
        excelData.setEamail("123@test.com");
        excelData1.setId("2");
        excelData1.setName("two");
        excelData1.setAge("12");
        excelData1.setEamail("www@test.com");

        resultList.add(excelData);
        resultList.add(excelData1);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        String fileName = "testexcel";
        response.setHeader("Content-disposition","attachment;filename=" + fileName + ".xlsx");
//        EasyExcel.write(fileName,ExcelData.class)
//                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
//                .sheet()
//                .doWrite(resultList);
        EasyExcel.write(response.getOutputStream(),ExcelData.class)
                .sheet()
                .doWrite(resultList);
    }
}
