package com.qxaillm;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.StringReader;
import org.xml.sax.InputSource;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;



/**
 * Author: liYuXi
 * Date: 8/6/24
 * Time: 6:05 AM
 * Package:PACKAGE_NAME
 * Project:untitled
 * 功能：
 */


@Slf4j
@SpringBootTest
public class SpringBootTestDemo {


@Test
    public void y(){

    String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><uwword fileformat=\"1.1\" xid-max=\"916\" template=\"false\"><metadata><m key=\"dc.format\">application/x-uwword</m><m key=\"uwword.generator\">uwWord</m></metadata></uwword>";
    try {
        // 解析 XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlContent)));
        doc.getDocumentElement().normalize();

        // 提取特定节点
        NodeList metadataList = doc.getElementsByTagName("m");

        for (int i = 0; i < metadataList.getLength(); i++) {
            Node node = metadataList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Key: " + element.getAttribute("key"));
                System.out.println("Value: " + element.getTextContent());
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

}


}
