package test.usingXml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.truetel.jcore.provider.email.EmailDBIntf;

public class DOMParser {

	DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

	// Load and parse XML file into DOM
	public Document parse(String filePath) {
		Document document = null;
		try {
			// DOM parser instance
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			// parse an XML file into a DOM tree
			document = builder.parse(new File(filePath));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Demo3");
		DOMParser parser = new DOMParser();
		parser.Demo03();

	}

	private void Demo01() {
		DOMParser parser = new DOMParser();
		Document document = parser.parse("src/books.xml");
		// get root element
		Element rootElement = document.getDocumentElement();

		// traverse child elements
		NodeList nodes = rootElement.getChildNodes();
		System.out.println("nodes.getLength: " + nodes.getLength());
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element child = (Element) node;
				// process child element

				System.out.println(child.getNodeName());
			}
		}

		NodeList nodeList = rootElement.getElementsByTagName("book");
		if (nodeList != null) {
			System.out.println("nodeList.getLength: " + nodeList.getLength());
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element element = (Element) nodeList.item(i);
				String id = element.getAttribute("id");
				String title = element.getElementsByTagName("title").item(0).getTextContent();
				String author = element.getElementsByTagName("author").item(0).getTextContent();

				System.out.println("id\t:" + id);
				System.out.println("title\t:" + title);
				System.out.println("author\t:" + author);
			}
		}
	}

	private void Demo02() {
		try {

			File fXmlFile = new File("src/books.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("book");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("id: " + eElement.getAttribute("id"));
					System.out.println("title: " + eElement.getElementsByTagName("title").item(0).getTextContent());
					System.out.println("author: " + eElement.getElementsByTagName("author").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void Demo03() {
		DOMParser parser = new DOMParser();
		Document document = parser.parse("src/8_1_1_001.rs.xml");
		// get root element
		Element rootElement = document.getDocumentElement();

		NodeList nodeList = rootElement.getElementsByTagName("Attr");
		if (nodeList != null) {
			System.out.println("nodeList.getLength: " + nodeList.getLength());
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element element = (Element) nodeList.item(i);
				String id = element.getAttribute("name");

				System.out.println("id\t:" + id);
				System.out.println("value\t:" + element.getTextContent());
				
				if(id.equals("messagecode")){
					System.out.println("get value\t:" + element.getTextContent());
				}

			}
		}
	}

}
