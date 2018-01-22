package com.matcha.domtest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by Student on 2018/1/22.
 */

public class parseHTML {
    public String getString()
    {
        try {
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.newDocument();

            Element html=document.createElement("html");
            Element body=document.createElement("doby");
            Element table=document.createElement("table");
            table.setAttribute("style","width:90%");
            table.setAttribute("align","center");
            Element tr=null,td=null;
            for(int i=0;i<5;i++)
            {
                tr=document.createElement("tr");
                for(int j=0;j<7;j++)
                {
                    td=document.createElement("td");
                    Text text=document.createTextNode(String.valueOf(i+j));
                    td.appendChild(text);
                    tr.appendChild(td);
                }
                table.appendChild(tr);
            }

            body.appendChild(table);
            html.appendChild(body);
            document.appendChild(html);

            DOMSource domSource=new DOMSource(document);
            StringWriter sw=new StringWriter();
            StreamResult result=new StreamResult(sw);

            TransformerFactory tf=TransformerFactory.newInstance();
            Transformer transformer=tf.newTransformer();
            transformer.transform(domSource,result);
            return sw.toString();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
