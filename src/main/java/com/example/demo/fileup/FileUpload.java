package com.example.demo.fileup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @program: springdemo
 * @ClassName FileUpload
 * @description:
 * @author: lzy
 * @create: 2021-10-05 15:37
 * @Version 1.0
 **/
@RestController
public class FileUpload {
    Logger logger = LoggerFactory.getLogger(FileUpload.class);

    @RequestMapping("/upload")
    public String single(@RequestParam("file") MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            return "null";
        }
        String name = file.getName();
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        logger.info("文件名称" + substring);
        File file1 = new File("D://" + name + substring);
        file.transferTo(file1);
        return "success";
    }

    @RequestMapping("/batch")
    public String batch(HttpServletRequest request) throws IOException {
        List<MultipartFile> multipartFiles = ((MultipartHttpServletRequest) request).getFiles("file");
        BufferedOutputStream bufferedOutputStream;
        MultipartFile multipartFile;
        for (int i = 0; i < multipartFiles.size(); i++) {
            multipartFile = multipartFiles.get(i);
            String originalFilename = multipartFile.getOriginalFilename();
            byte[] bytes = multipartFile.getBytes();
            bufferedOutputStream =
                    new BufferedOutputStream(new FileOutputStream(new File("D://demo" + originalFilename)));
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.close();
        }
        return "success";
    }

    @RequestMapping("/download")
    public String download(HttpServletRequest request, HttpServletResponse response) {

        String fileName = "test.xlsx";
        File file = new File("D:\\模型应用变量.xlsx");
        if (file.exists()) {
            ServletOutputStream outputStream = null;
            FileInputStream fileInputStream = null;
            BufferedInputStream bufferedInputStream = null;
            try {
                response.setContentType("application/force-download");
                response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
                fileInputStream = new FileInputStream(file);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                byte[] bytes = new byte[1024];
                outputStream = response.getOutputStream();
                int read;
                while (-1 != (read = bufferedInputStream.read(bytes))) {
                    outputStream.write(bytes, 0, read);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //需加判空处理
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "success";
        }
        return "success";
    }

    @GetMapping("/download/{file}")
    public ResponseEntity<byte[]> download(@PathVariable String file, HttpServletResponse response) {

        String s = "hello welcome to my word!";
        byte[] bytes = s.getBytes();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/vnd.ms-excel");
            headers.add("Connection", "close");
            headers.add("Accept-Ranges", "bytes");
            headers.add("Content-Disposition", "attachment;filename="
                    + new String(file.getBytes("gbk"), "ISO-8859-1"));
            return new ResponseEntity<byte[]>(bytes,headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}