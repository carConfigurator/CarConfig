package view_miglayout;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import model.Client;
import model.Model;

public class Delete_Car extends JFrame{
	
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	private int idSelected;
	
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document documentOld;
	private Document documentNew;
	
	private JPanel panel = new JPanel();

	public Delete_Car(ConfigurationLoader configLoad, ILanguage language, String username, Client client, int idSelected) {
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
		
		//string en que le guardamos la info del modelo
		String[] info=new String[5];
		
		//buscamos el modelo que queremos
		NodeList nList = documentOld.getElementsByTagName("Model");
		String[] models = new String[nList.getLength()];
		for (int i = 0; i < models.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			//cuando lo encontremos cogemos la info de ese modelo y lo guardamos al array
			if (eElement.getElementsByTagName("id").item(0).getTextContent().equals(""+this.idSelected)) {
				for (int j = 0; j < 5; j++) {
					String allInfo = eElement.getElementsByTagName("*").item(j).getTextContent();
					info[j]=allInfo;
				}
			}
		}
		
		//dialogo para mostrar el coche que vamos a eliminar
		int optionPane=JOptionPane.showConfirmDialog(panel, language.dataDeleteCarTitle()+"\n"
						+language.labelId()+info[0]+"\n"
						+language.labelName()+info[1]+"\n"
						+language.labelDescription()+info[2]+"\n"
						+language.labelImg_Name()+info[3]+"\n"
						+language.labelPrice()+info[4]+"\n"
					,language.deleteCarTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (optionPane==JOptionPane.YES_OPTION) {
			generateXML();
		}else {
			new Selection_model(this.configLoad, this.language, this.username, this.client);
		}
		
		JFrame();
	}
	
	private void JFrame() {
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(false);
	}
	
	private void generateXML() {
		String nombre_archivo = "CarConfiguration";
		
		DOMImplementation implementation = builder.getDOMImplementation();
        documentNew = implementation.createDocument(null, nombre_archivo, null);
        documentNew.setXmlVersion("1.0");
		
      //Main Node
        Element raiz = documentNew.getDocumentElement();

        //creamos un boolean para ver si nos saltamos un modelo (para saltar el modelo eliminado)
        boolean saltar=false;
        //boolean para saber en que punto hemos eliminado el coche
        boolean eliminat=false;
        NodeList nListModel = documentOld.getElementsByTagName("Model");
		for (int i = 0; i < nListModel.getLength(); i++) {
			Node nNode = nListModel.item(i); 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elementKey = (Element) nNode;
				Element itemNode = documentNew.createElement("Model");
				for (int y = 0; y < elementKey.getElementsByTagName("*").getLength(); y++) {
					Node nElementsKey = elementKey.getElementsByTagName("*").item(y);
		            Element keyNode = documentNew.createElement(nElementsKey.getNodeName()); 
					if (nElementsKey.getNodeType() == Node.ELEMENT_NODE) {
						Element elementValue = (Element) nElementsKey;
			            Text nodeKeyValue = documentNew.createTextNode(elementValue.getTextContent());
			            //primero comprobamos si lo tenemos que eliminar
			            if(!nodeKeyValue.getTextContent().equals(""+this.idSelected)) {
				            keyNode.appendChild(nodeKeyValue);
				            //y si no es el seleccionado y ya hay uno eliminado, baja el id de los demas en 1 
				            if (keyNode.getNodeName().equals("id") && eliminat) {
				            	nodeKeyValue.setTextContent(""+i);
				            }
			            }else {
			            	y=elementKey.getElementsByTagName("*").getLength();
			            	saltar=true;
			            	eliminat=true;
			            }
					}
					if(!saltar) {
			            itemNode.appendChild(keyNode);
		            }
		    	}
				if(!saltar) {
		            raiz.appendChild(itemNode);
	            }else {
	            	saltar=false;
	            }
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
		
		new Selection_model(this.configLoad, this.language, this.username, this.client);
	}

}
