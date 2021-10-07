package com.example.demo.xmlparse;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

/**
 * @program: demo
 * @ClassName XmlParseTest
 * @description:
 * @author: lzy
 * @create: 2021-10-07 09:32
 * @Version 1.0
 **/
public class XmlParseTest {
    public static void main(String[] args) {
        File file = new File("D:\\test3.xml");
        XmlParseTest xmlParseTest = new XmlParseTest();
        xmlParseTest.createXml(file);
    }

    public void modify(File file) {
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(file);
            List list = document.selectNodes("/books/book/@show");
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Attribute next = (Attribute) iterator.next();
                if ("yes".equals(next.getValue())) {
                    next.setValue("no");
                }
            }
            XMLWriter xmlWriter = new XMLWriter(new FileWriter(file));
            xmlWriter.write(document);
            xmlWriter.close();
            System.out.println("========");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createXml(File file) {

        try {
            Document document = DocumentHelper.createDocument();
            Element books = document.addElement("books");
            books.addComment("this is comment");
            Element book = books.addElement("book");
            book.addAttribute("show", "yes");
            Element title = book.addElement("title");
            title.addText("hello");
            Element book2 = books.addElement("book");
            book2.addAttribute("show", "yes");
            Element title2 = book2.addElement("title");
            title2.addText("hi");

            XMLWriter xmlWriter = new XMLWriter(new FileWriter(file));
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xmlparse() {
        try {
            File file = new File("D:\\test1.xml");
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(file);

            Element rootElement = document.getRootElement();
            Iterator iterator;
            for (iterator = rootElement.elementIterator(); iterator.hasNext(); ) {
                Element next = (Element) iterator.next();
                String name = next.elementText("name");
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}