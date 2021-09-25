package com.example.demo.excel.bean;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExcelData {
    @ExcelProperty(value = "id",index = 0)
    private String id;
    @ExcelProperty(value = "name",index = 1)
    private String name;

    @ExcelProperty(value = "age",index = 2)
    private String age;
    @ExcelIgnore
    private String eamail;
}
