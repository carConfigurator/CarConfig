package daoImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;
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
import idao.IModel;
import model.Client;
import model.Model;
import view_miglayout.Selection_Model;

public class ModelDAO_XML implements IModel{
	
	// Atributos de la Implementación:
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	public ModelDAO_XML() {
		this.factory = DocumentBuilderFactory.newInstance();
		try {
			this.builder = factory.newDocumentBuilder();
			try {
				this.document = builder.parse(new File(configLoad.getCar_configuration_path() + configLoad.getCar_configuration_file_name()));
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		loadModels();
	}

	@Override
	public Model getModel(int id) {
		return models.get(id-1);
	}

	@Override
	public ArrayList<Model> getModels() {
		return models;
	}

	@Override
	public void loadModels() {
		models.clear();
		NodeList nList = document.getElementsByTagName("Model");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
				String name = eElement.getElementsByTagName("name").item(0).getTextContent();
				String description = eElement.getElementsByTagName("description").item(0).getTextContent();
				String image_name = eElement.getElementsByTagName("image_name").item(0).getTextContent();
				double price = Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent());
				models.add(new Model(id, name, description, image_name, price));
			}
		}
	}
	
	@Override
	public void addCar(JTextField tfId, JTextField tfName, JTextField tfDescription, JTextField tfImg_Name, JTextField tfPrice) {
		Document documentNew;
		
		String nombre_archivo = "CarConfiguration";
		
		DOMImplementation implementation = builder.getDOMImplementation();
        documentNew = implementation.createDocument(null, nombre_archivo, null);
        documentNew.setXmlVersion("1.0");
		
      //Main Node
        Element raiz = documentNew.getDocumentElement();

        NodeList nListModel = document.getElementsByTagName("Model");
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
		
		//añadimos el nuevo coche
        Element newItemNode = documentNew.createElement("Model");
        Element idNode = documentNew.createElement("id");
        Text idValue = documentNew.createTextNode(tfId.getText());
        idNode.appendChild(idValue);
        Element nomNode = documentNew.createElement("name");
        Text nomValue = documentNew.createTextNode(tfName.getText());
        nomNode.appendChild(nomValue);
        Element descripcioNode = documentNew.createElement("description");
        Text descripcioValue = documentNew.createTextNode(tfDescription.getText());
        descripcioNode.appendChild(descripcioValue);
        Element imatge_nomNode = documentNew.createElement("image_name");
        Text imatge_nomValue = documentNew.createTextNode(tfImg_Name.getText());
        imatge_nomNode.appendChild(imatge_nomValue);
        Element preuNode = documentNew.createElement("price");
        Text preuValue = documentNew.createTextNode(tfPrice.getText());
        preuNode.appendChild(preuValue);

        newItemNode.appendChild(idNode);
        newItemNode.appendChild(nomNode);
        newItemNode.appendChild(descripcioNode);
        newItemNode.appendChild(imatge_nomNode);
        newItemNode.appendChild(preuNode);
        raiz.appendChild(newItemNode);
		
        //llamamos a añadir los motores, accessorios, y generamos el xml
		addEngines(documentNew, document, raiz);
		addAccessory(documentNew, document, raiz);
        generateXml(documentNew);
		
		System.out.println("[INFO] - Nuevo XML creado");
		System.out.println("[INFO] - Nuevo coche añadido");
	}
	
	@Override
	//metodo para eliminar un coche
	public void deleteCar(int idSelected) {
		Document documentNew;
		
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
        NodeList nListModel = document.getElementsByTagName("Model");
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
			            if(!nodeKeyValue.getTextContent().equals(""+getModel(idSelected).getId())) {
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

        //llamamos a añadir los motores, accessorios, y generamos el xml
		addEngines(documentNew, document, raiz);
		addAccessory(documentNew, document, raiz);
        generateXml(documentNew);
        
		System.out.println("[INFO] - Coche eliminado");
	}
	
	@Override
	//metodo para modificar un coche
	public void modifyCar(JTextField tfId, JTextField tfName, JTextField tfDescription, JTextField tfImg_Name, JTextField tfPrice, int idSelected) {
		Document documentNew;
		
		String nombre_archivo = "CarConfiguration";
		
		DOMImplementation implementation = builder.getDOMImplementation();
        documentNew = implementation.createDocument(null, nombre_archivo, null);
        documentNew.setXmlVersion("1.0");
		
      //Main Node
        Element raiz = documentNew.getDocumentElement();
        //usamos este boleano para saber que node es el que nos saltamos porque ya lo añadimos en el else
        boolean saltar = false;
        
        NodeList nListModel = document.getElementsByTagName("Model");
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
			            //si el id que vamos a meter es el que queremos modificar hacemos lo siguiente: (sino se añade y ya)
			            if(!nodeKeyValue.getTextContent().equals(""+getModel(idSelected).getId())) {
				            keyNode.appendChild(nodeKeyValue);
			            }else {
			            	//si es el id que queremos modificar, ponemos la info que hemos tocado
			                Element newItemNode = documentNew.createElement("Model");
			                Element idNode = documentNew.createElement("id");
			                Text idValue = documentNew.createTextNode(tfId.getText());
			                idNode.appendChild(idValue);
			                Element nomNode = documentNew.createElement("name");
			                Text nomValue = documentNew.createTextNode(tfName.getText());
			                nomNode.appendChild(nomValue);
			                Element descripcioNode = documentNew.createElement("description");
			                Text descripcioValue = documentNew.createTextNode(tfDescription.getText());
			                descripcioNode.appendChild(descripcioValue);
			                Element imatge_nomNode = documentNew.createElement("image_name");
			                Text imatge_nomValue = documentNew.createTextNode(tfImg_Name.getText());
			                imatge_nomNode.appendChild(imatge_nomValue);
			                Element preuNode = documentNew.createElement("price");
			                Text preuValue = documentNew.createTextNode(tfPrice.getText());
			                preuNode.appendChild(preuValue);

			                newItemNode.appendChild(idNode);
			                newItemNode.appendChild(nomNode);
			                newItemNode.appendChild(descripcioNode);
			                newItemNode.appendChild(imatge_nomNode);
			                newItemNode.appendChild(preuNode);
			                raiz.appendChild(newItemNode);
			                
			                //hacemos que nos salte lo que queda de node
			            	y=elementKey.getElementsByTagName("*").getLength();
			            	saltar=true;
			            }
			            keyNode.appendChild(nodeKeyValue);
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

        //llamamos a añadir los motores, accessorios, y generamos el xml
		addEngines(documentNew, document, raiz);
		addAccessory(documentNew, document, raiz);
        generateXml(documentNew);
		
		System.out.println("[INFO] - Nuevo XML creado");
		System.out.println("[INFO] - Coche modificado");
	}
	
	//añadimos los motores al documento
	private void addEngines(Document documentNew, Document documentOld, Element raiz) {
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
	}

	
	//añadimos los accessorios al documento
	private void addAccessory(Document documentNew, Document documentOld, Element raiz) {
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
	}

	//generamos el documento xml
	private void generateXml(Document documentNew) {
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
