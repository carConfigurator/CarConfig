package view_miglayout;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import model.Accessory;
import model.Client;
import model.Engine;
import model.Model;
import net.miginfocom.swing.MigLayout;
import sun.awt.AWTAccessor.SystemColorAccessor;

public class Add_Car extends JFrame{

	private ILanguage language;
	private ConfigurationLoader configLoad;
	
	private JPanel panelMig;
	
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document documentOld;
	private Document documentNew;
	
	public Add_Car(ConfigurationLoader configLoad, ILanguage language){
		this.configLoad = configLoad;
		this.language = language;
		
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

		this.panelMig = new JPanel();
		this.panelMig.setLayout(new MigLayout("insets 20 50 50 50, fillx, filly"));
		this.panelMig.setBackground(new Color(255, 255, 255));

		

        String nombre_archivo = "car_config-prova";
        
        System.out.println("-------------");

        NodeList nListModel = documentOld.getElementsByTagName("Model");
		for (int i = 0; i < nListModel.getLength(); i++) {
			Node nNode = nListModel.item(i);
			System.out.println("------NEW MODEL");
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				for (int y = 0; y < eElement.getElementsByTagName("*").getLength(); y++) {
					Node nElements = eElement.getElementsByTagName("*").item(y);
					System.out.println("KEY: "+nElements.getNodeName());
					if (nElements.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement2 = (Element) nElements;
						System.out.println("VALUE: "+eElement2.getTextContent());
					}
		    	}
			}
    	}
		
		NodeList nListEngine = documentOld.getElementsByTagName("Engine");
		for (int i = 0; i < nListEngine.getLength(); i++) {
			Node nNode = nListEngine.item(i);
			System.out.println("-------NEW ENGINE");
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				for (int y = 0; y < eElement.getElementsByTagName("*").getLength(); y++) {
					Node nElements = eElement.getElementsByTagName("*").item(y);
					System.out.println("KEY: "+nElements.getNodeName());
					if (nElements.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement2 = (Element) nElements;
						System.out.println("VALUE: "+eElement2.getTextContent());
					}
		    	}
			}
    	}
		
		NodeList nList = documentOld.getElementsByTagName("Accessory");
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			System.out.println("--------NEW ACCESSORY");
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				for (int y = 0; y < eElement.getElementsByTagName("*").getLength(); y++) {
					Node nElements = eElement.getElementsByTagName("*").item(y);
					System.out.println("KEY: "+nElements.getNodeName());
					if (nElements.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement2 = (Element) nElements;
						System.out.println("VALUE: "+eElement2.getTextContent());
					}
		    	}
			}
    	}
		
		
		ArrayList key = new ArrayList();
        ArrayList value = new ArrayList();
        key.add("opcion1");
        value.add("22");
        key.add("opcion2");
        value.add("22");
        key.add("opcion3");
        value.add("22");
        key.add("opcion4");
        value.add("25");
		
//        DOMImplementation implementation = builder.getDOMImplementation();
//        Document document = implementation.createDocument(null, nombre_archivo, null);
//        document.setXmlVersion("1.0");

        
    	System.out.println("Root element :" + documentOld.getDocumentElement().getNodeName());
    	NodeList nodeList = documentOld.getDocumentElement().getChildNodes();
    	for (int i = 0; i < nodeList.getLength(); i++) {
    		Element eElement = (Element) nodeList;
    		System.out.println(eElement.getNodeName());
    		System.out.println(eElement.getElementsByTagName(eElement.getNodeName()).item(0).getTextContent());
    		System.out.println(eElement.getNodeValue());
    	}
        //Main Node
        Element raiz = documentOld.getDocumentElement();
        //Por cada key creamos un item que contendrá la key y el value
//        NodeList nodeList = documentOld.getDocumentElement().getChildNodes();
        System.out.println("docElement "+documentOld.getDocumentElement());
        System.out.println("docChildNodes "+documentOld.getDocumentElement().getChildNodes());
        System.out.println("docChildNodes2 "+documentOld.getDocumentElement());
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode2 = nodeList.item(i);
        	
    		if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
    			Element eElement = (Element) nNode2;
//    			""+eElement.getElementsByTagName("title").item(0).getTextContent();

                //Item Node
//                Element itemNode = document.createElement(eElement.getTagName()); 
                System.out.println("TAG: "+eElement.getTagName());
                
                //Key Node
//                Element keyNode = document.createElement(eElement.getNodeName()); 
//                Text nodeKeyValue = document.createTextNode(eElement.getNodeValue());
//                keyNode.appendChild(nodeKeyValue);
                
                System.out.println("NodeName: "+eElement.getNodeName());
                
                System.out.println("NodeValue: "+eElement.getNodeValue());
                
    		}
        	
        	
        	
        	
            //Item Node
//            Element itemNode = document.createElement("ITEM"); 
//            //Key Node
//            Element keyNode = document.createElement("KEY"); 
//            Text nodeKeyValue = document.createTextNode(""+key.get(i));
//            keyNode.appendChild(nodeKeyValue);      
//            //Value Node
//            Element valueNode = document.createElement("VALUE"); 
//            Text nodeValueValue = document.createTextNode(""+value.get(i));                
//            valueNode.appendChild(nodeValueValue);
//            //append keyNode and valueNode to itemNode
//            itemNode.appendChild(keyNode);
//            itemNode.appendChild(valueNode);
//            //append itemNode to raiz
//            raiz.appendChild(itemNode); //pegamos el elemento a la raiz "Documento"
        }                
        //Generate XML
//        Source source = new DOMSource(document);
        //Indicamos donde lo queremos almacenar
        Result result = new StreamResult(new File("src\\config\\car"+nombre_archivo+".xml")); //nombre del archivo
        Transformer transformer;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
//	        try {
//				transformer.transform(source, result);
//			} catch (TransformerException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		NodeList nodes = documentOld.getElementsByTagName("CarConfiguration");
//		
//		Element eModel = document.getDocumentElement();
//		Node node = document.createElement("newnode");

//		eModel.appendChild(node); 
//		Element eModel = document.createElement("Model");
//		eModel.setAttribute("id", "123");
//		eModel.setAttribute("nom", "123");
//		eModel.setAttribute("descripcio", "123");
//		eModel.setAttribute("imatge_nom", "123");
//		eModel.setAttribute("preu", "123");
//		System.out.println(nodes.item(0).toString());
//		nodes.item(0).getParentNode().insertBefore(eModel, nodes.item(0));
		
		JFrame();
	}
	
	//se quita
	public String loginTitle() {
		NodeList nList = documentOld.getElementsByTagName("Login");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("title").item(0).getTextContent();
		}
		return null;
	}
	
	
	
	private void JFrame() {
		add(panelMig);
		setTitle("Añadir Un Coche");
		setIconImage(getIconImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/*
	 * Método que obtiene la imagen para el JFrame.
	 * @return La imagen que hay en carpeta.
	 * @see java.awt.Frame#getIconImage()
	 */
	public Image getIconImage() {
		File image = new File("src/config/favicon.png");
        Image retValue = Toolkit.getDefaultToolkit().getImage(image.getAbsolutePath());
        return retValue;
    }
}
