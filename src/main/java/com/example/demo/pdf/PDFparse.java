package com.example.demo.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @program: demo
 * @ClassName PDFparse
 * @description:
 * @author: lzy
 * @create: 2021-10-07 20:48
 * @Version 1.0
 **/
@Controller
public class PDFparse {

    public static void main(String[] args) throws FileNotFoundException, DocumentException {

        Document document = new Document();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\1.pdf"));
        PdfWriter writer = PdfWriter.getInstance(document, fileOutputStream);
        document.addTitle("spring");
        writer.setPdfVersion(PdfWriter.VERSION_1_4);

        Paragraph elements = new Paragraph("===");
        document.open();
        document.add(elements);
        document.close();
    }
    @RequestMapping("/pdf")
    public ResponseEntity<byte[]> pdfDownload(HttpServletResponse response) throws IOException, DocumentException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
        document.addTitle("spring");
        writer.setPdfVersion(PdfWriter.VERSION_1_4);
        Paragraph elements = new Paragraph("===");
        document.open();
        document.add(elements);
        document.close();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode("test" + ".pdf"));
        return new ResponseEntity<>(bytes,httpHeaders, HttpStatus.OK);
    }


}