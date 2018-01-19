package net.technearts.javapom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class AbstractPom {
    public void main() {
        Class<? extends AbstractPom> klazz = this.getClass();
        GAV gav = klazz.getAnnotationsByType(GAV.class)[0];
        System.out.println(gav.value());
        Name name = klazz.getAnnotationsByType(Name.class)[0];
        System.out.println(name.value());

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("project");
            Attr xmlns = doc.createAttribute("xmlns");
            xmlns.setValue("http://maven.apache.org/POM/4.0.0");
            rootElement.setAttributeNode(xmlns);
            Attr xmlns_xsi = doc.createAttribute("xmlns:xsi");
            xmlns_xsi.setValue("http://www.w3.org/2001/XMLSchema-instance");
            rootElement.setAttributeNode(xmlns_xsi);
            Attr xsi_schemaLocation = doc.createAttribute("xsi:schemaLocation");
            xsi_schemaLocation.setValue("http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd");
            rootElement.setAttributeNode(xsi_schemaLocation);
            doc.appendChild(rootElement);

            // staff elements
            Element staff = doc.createElement("modelVersion");
            staff.appendChild(doc.createTextNode("4.0.0"));
            rootElement.appendChild(staff);

            // shorten way
            // staff.setAttribute("id", "1");

            // firstname elements
            Element firstname = doc.createElement("name");
            firstname.appendChild(doc.createTextNode(name.value()));
            rootElement.appendChild(firstname);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("D:\\pom.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

          } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
          } catch (TransformerException tfe) {
            tfe.printStackTrace();
          }
    }
    

}
