package com.coviam.training.kafka.service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLFileHandler implements FileHandler{
    static int i =0;
    public Employee read() throws ParserConfigurationException, IOException, SAXException
    {

        Employee emp=new Employee();
        try {
            File file = new File("/Users/sangeetha/Downloads/employee.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("employee");
            Node nNode = nList.item(i);
            i++;

            if (nNode.getNodeType() == Node.ELEMENT_NODE)
            {
                //Get each employee's detail
                Element eElement = (Element) nNode;

                emp.setFirstName(eElement.getElementsByTagName("firstName")
                        .item(0).getTextContent());
                emp.setLastName(eElement.getElementsByTagName("lastName")
                        .item(0).getTextContent());
                emp.setDateOfBirth(eElement.getElementsByTagName("dateOfBirth")
                        .item(0).getTextContent());
                emp.setExperience(Double.parseDouble(eElement.getElementsByTagName("experience")
                        .item(0).getTextContent()));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("xml " + emp);
        return emp;
    }
}
