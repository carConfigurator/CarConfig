package view_miglayout;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import config.ConfigurationLoader;
import idao.ILanguage;
import model.Client;
import model.Model;

public class Delete_Car {
	
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	private int idSelected;
	
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document documentOld;
	private Document documentNew;

	public Delete_Car(ConfigurationLoader configLoad, ILanguage language, String username, Client client, Model model, int idSelected) {
		this.configLoad = configLoad;
		this.language = language;
		this.username = username;
		this.client = client;
		this.idSelected = idSelected;	
		
		this.factory = DocumentBuilderFactory.newInstance();
		try {
			this.builder = factory.newDocumentBuilder();
			this.documentOld = builder.parse(new File(configLoad.getCar_configuration_path()+configLoad.getCar_configuration_file_name()));
		} catch (ParserConfigurationException e) {
			System.out.println("[ERROR] - No se ha podido parsear la configuración. Más información del error: " + e);
		} catch (SAXException e) {
			System.out.println("[ERROR] - No se ha podido parsear el archivo XML. Más información del error: " + e);
		} catch (IOException e) {
			System.out.println("[ERROR] - Error de E/S. Más información del error: " + e);
		}
		
		NodeList nListModel = documentOld.getElementsByTagName("Model");
		for (int i = 0; i < nListModel.getLength(); i++) {
			Node nNode = nListModel.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elementKey = (Element) nNode;
				for (int y = 0; y < elementKey.getElementsByTagName("id").getLength(); y++) {
					Node nElementsKey = elementKey.getElementsByTagName("id").item(y);
					if (nElementsKey.getNodeType() == Node.ELEMENT_NODE) {
						Element elementValue = (Element) nElementsKey;
						if (elementValue.getTextContent().equals(idSelected)) {
							System.out.println("SI");
//							JOptionPane.showConfirmDialog(parentComponent, message)
						}
					}
		    	}
			}
    	}
		
		generateXML();
	}
	
	private void generateXML() {
		String nombre_archivo = "CarConfiguration";
		
		DOMImplementation implementation = builder.getDOMImplementation();
        documentNew = implementation.createDocument(null, nombre_archivo, null);
        documentNew.setXmlVersion("1.0");
		
      //Main Node
        Element raiz = documentNew.getDocumentElement();

        NodeList nListModel = documentOld.getElementsByTagName("Model");
		for (int i = 0; i < nListModel.getLength(); i++) {
			Node nNode = nListModel.item(i);
            Element itemNode = documentNew.createElement("Model"); 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elementKey = (Element) nNode;
				for (int y = 0; y < elementKey.getElementsByTagName("*").getLength(); y++) {
					Node nElementsKey = elementKey.getElementsByTagName("*").item(y);
		            Element keyNode = documentNew.createElement(nElementsKey.getNodeName()); 
					if (nElementsKey.getNodeType() == Node.ELEMENT_NODE) {
						Element elementValue = (Element) nElementsKey;
			            Text nodeKeyValue = documentNew.createTextNode(elementValue.getTextContent());
			            keyNode.appendChild(nodeKeyValue);
					}
		            itemNode.appendChild(keyNode);
		    	}
	            raiz.appendChild(itemNode);
			}
    	}
		
		NodeList nListEngine = documentOld.getElementsByTagName("Engine");
		for (int i = 0; i < nListEngine.getLength(); i++) {
			Node nNode = nListEngine.item(i);
            Element itemNode = documentNew.createElement("Engine"); 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elementEngine = (Element) nNode;
				for (int y = 0; y < elementEngine.getElementsByTagName("*").getLength(); y++) {
					Node nElementsKey = elementEngine.getElementsByTagName("*").item(y);
		            Element keyNode = documentNew.createElement(nElementsKey.getNodeName()); 
					if (nElementsKey.getNodeType() == Node.ELEMENT_NODE) {
						Element elementValue = (Element) nElementsKey;
			            Text nodeKeyValue = documentNew.createTextNode(elementValue.getTextContent());
			            keyNode.appendChild(nodeKeyValue);
					}
		            itemNode.appendChild(keyNode);
		    	}
	            raiz.appendChild(itemNode);
			}
    	}
		
		NodeList nList = documentOld.getElementsByTagName("Accessory");
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
            Element itemNode = documentNew.createElement("Accessory");
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				for (int y = 0; y < eElement.getElementsByTagName("*").getLength(); y++) {
					Node nElementsKey = eElement.getElementsByTagName("*").item(y);
		            Element keyNode = documentNew.createElement(nElementsKey.getNodeName()); 
					if (nElementsKey.getNodeType() == Node.ELEMENT_NODE) {
						Element elementValue = (Element) nElementsKey;
			            Text nodeKeyValue = documentNew.createTextNode(elementValue.getTextContent());
			            keyNode.appendChild(nodeKeyValue);
					}
		            itemNode.appendChild(keyNode);
		    	}
	            raiz.appendChild(itemNode);
			}
    	}
		
        //Generate XML
        Source source = new DOMSource(documentNew);
        //Indicamos donde lo queremos almacenar
        Result result = new StreamResult(new File("src\\config\\car\\car_config.xml")); //nombre del archivo
        Transformer transformer;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
	        try {
				transformer.transform(source, result);
			} catch (TransformerException e) {
				e.printStackTrace();
			}
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
	}

}
