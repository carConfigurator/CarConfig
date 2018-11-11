package model;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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
import view_miglayout.Selection_Model;

//public class Model_woDAO {

//	 Atributos de la Clase
	private ConfigurationLoader configLoad;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	// En estos atributos estará la información de todos los modelos disponibles.
	private int[] id;
	private double[] price;
	private String[] name, description, image_name;
	
	// En estos atributos estará la información del modelo seleccionado.
	private String nameSelected, descriptionSelected, image_nameSelected;
	private int idSelected;
	private double priceSelected;
	
	public Model_woDAO(ConfigurationLoader configLoad) {
		this.configLoad = configLoad;
		this.factory = DocumentBuilderFactory.newInstance();
		try {
			System.out.println("[INFO] - Ruta de car: " + this.configLoad.getCar_configuration_path()+this.configLoad.getCar_configuration_file_name());
			System.out.println("[INFO] - Cargando Modelos a la Vista...");
			this.builder = factory.newDocumentBuilder();
			this.document = this.builder.parse(new File(this.configLoad.getCar_configuration_path() + this.configLoad.getCar_configuration_file_name()));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.id = loadId();
		this.price = loadPrice();
		this.name = loadName();
		this.description = loadDescription();
		this.image_name = loadImage_Name();
		System.out.println(getInformation());
	}

	private String[] loadImage_Name() {
		NodeList nList = document.getElementsByTagName("Model");
		String[] image = new String[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				image[temp] = eElement.getElementsByTagName("imatge_nom").item(0).getTextContent();
			}
		}
		return image;
	}

	private String[] loadDescription() {
		NodeList nList = document.getElementsByTagName("Model");
		String[] description = new String[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				description[temp] = eElement.getElementsByTagName("descripcio").item(0).getTextContent();
			}
		}
		return description;
	}

	private String[] loadName() {
		NodeList nList = document.getElementsByTagName("Model");
		String[] name = new String[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				name[temp] = eElement.getElementsByTagName("nom").item(0).getTextContent();
			}
		}
		return name;
	}

	private double[] loadPrice() {
		NodeList nList = document.getElementsByTagName("Model");
		double[] price = new double[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				price[temp] = Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
			}
		}
		return price;
	}

	private int[] loadId() {
		NodeList nList = document.getElementsByTagName("Model");
		int[] id = new int[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				id[temp] = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
			}
		}
		return id;
	}

	public int[] getId() {
		return id;
	}

	public double[] getPrice() {
		return price;
	}

	public String[] getName() {
		return name;
	}

	public String[] getDescription() {
		return description;
	}

	public String[] getImage_name() {
		return image_name;
	}
	
	private String getInformation() {
		return "Id: "+Arrays.toString(id)+", precio: "+Arrays.toString(price)+", nomobre: "+Arrays.toString(name)+", descripcion: "+Arrays.toString(description)+", ruta imagen: "+Arrays.toString(image_name);
	}
	
	public void toModel(int id) {
		String name = null; String description = null; double price = 0;
		System.out.print("[INFO] - Buscando el Modelo... ");
		int[] allID = loadId();
		for (int i = 0; i < allID.length; i++) {
			if(allID[i] == id) {
				NodeList nList = document.getElementsByTagName("Model");
				Node nNode = nList.item(i);
				Element eElement = (Element) nNode;
				this.idSelected = id;
				this.nameSelected = eElement.getElementsByTagName("nom").item(0).getTextContent();
				this.descriptionSelected = eElement.getElementsByTagName("descripcio").item(0).getTextContent();
				this.priceSelected = Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
				this.image_nameSelected = eElement.getElementsByTagName("imatge_nom").item(0).getTextContent();
				System.out.print("ID del Modelo seleccionado encontrado!\n");
			}
		}
	}

	public String getNameSelected() {
		return nameSelected;
	}

	public String getDescriptionSelected() {
		return descriptionSelected;
	}

	public int getIdSelected() {
		return idSelected;
	}
	
	public void setIdSelected(int idSelected) {
		this.idSelected = idSelected;
	}

	public double getPriceSelected() {
		return priceSelected;
	}
	
	public String getImage_nameSelected() {
		return image_nameSelected;
	}
	
	//metodo para añadir un coche
	public void addCar(ConfigurationLoader configLoad, ILanguage language, String username, Client client, Document documentOld, JTextField tfId, JTextField tfName, JTextField tfDescription, JTextField tfImg_Name, JTextField tfPrice) {
		Document documentNew;
		
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
		
		//añadimos el nuevo coche
        Element newItemNode = documentNew.createElement("Model");
        Element idNode = documentNew.createElement("id");
        Text idValue = documentNew.createTextNode(tfId.getText());
        idNode.appendChild(idValue);
        Element nomNode = documentNew.createElement("nom");
        Text nomValue = documentNew.createTextNode(tfName.getText());
        nomNode.appendChild(nomValue);
        Element descripcioNode = documentNew.createElement("descripcio");
        Text descripcioValue = documentNew.createTextNode(tfDescription.getText());
        descripcioNode.appendChild(descripcioValue);
        Element imatge_nomNode = documentNew.createElement("imatge_nom");
        Text imatge_nomValue = documentNew.createTextNode(tfImg_Name.getText());
        imatge_nomNode.appendChild(imatge_nomValue);
        Element preuNode = documentNew.createElement("preu");
        Text preuValue = documentNew.createTextNode(tfPrice.getText());
        preuNode.appendChild(preuValue);

        newItemNode.appendChild(idNode);
        newItemNode.appendChild(nomNode);
        newItemNode.appendChild(descripcioNode);
        newItemNode.appendChild(imatge_nomNode);
        newItemNode.appendChild(preuNode);
        raiz.appendChild(newItemNode);
		
        //llamamos a añadir los motores, accessorios, y generamos el xml
		addEngines(documentNew, documentOld, raiz);
		addAccessory(documentNew, documentOld, raiz);
        generateXml(documentNew);
		
		System.out.println("[INFO] - Nuevo XML creado");
		System.out.println("[INFO] - Nuevo coche añadido");
		
		new Selection_Model(configLoad, language, username, client);
	}
	
	//metodo para eliminar un coche
	public void deleteCar(ConfigurationLoader configLoad, ILanguage language, String username, Client client, Document documentOld) {
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

        //llamamos a añadir los motores, accessorios, y generamos el xml
		addEngines(documentNew, documentOld, raiz);
		addAccessory(documentNew, documentOld, raiz);
        generateXml(documentNew);
        
		System.out.println("[INFO] - Coche eliminado");
		
		new Selection_Model(configLoad, language, username, client);
	}
	
	//metodo para modificar un coche
	public void modifyCar(ConfigurationLoader configLoad, ILanguage language, String username, Client client, Document documentOld, JTextField tfId, JTextField tfName, JTextField tfDescription, JTextField tfImg_Name, JTextField tfPrice) {
		Document documentNew;
		
		String nombre_archivo = "CarConfiguration";
		
		DOMImplementation implementation = builder.getDOMImplementation();
        documentNew = implementation.createDocument(null, nombre_archivo, null);
        documentNew.setXmlVersion("1.0");
		
      //Main Node
        Element raiz = documentNew.getDocumentElement();
        //usamos este boleano para saber que node es el que nos saltamos porque ya lo añadimos en el else
        boolean saltar = false;
        
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
			            //si el id que vamos a meter es el que queremos modificar hacemos lo siguiente: (sino se añade y ya)
			            if(!nodeKeyValue.getTextContent().equals(""+this.idSelected)) {
				            keyNode.appendChild(nodeKeyValue);
			            }else {
			            	//si es el id que queremos modificar, ponemos la info que hemos tocado
			                Element newItemNode = documentNew.createElement("Model");
			                Element idNode = documentNew.createElement("id");
			                Text idValue = documentNew.createTextNode(tfId.getText());
			                idNode.appendChild(idValue);
			                Element nomNode = documentNew.createElement("nom");
			                Text nomValue = documentNew.createTextNode(tfName.getText());
			                nomNode.appendChild(nomValue);
			                Element descripcioNode = documentNew.createElement("descripcio");
			                Text descripcioValue = documentNew.createTextNode(tfDescription.getText());
			                descripcioNode.appendChild(descripcioValue);
			                Element imatge_nomNode = documentNew.createElement("imatge_nom");
			                Text imatge_nomValue = documentNew.createTextNode(tfImg_Name.getText());
			                imatge_nomNode.appendChild(imatge_nomValue);
			                Element preuNode = documentNew.createElement("preu");
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
		addEngines(documentNew, documentOld, raiz);
		addAccessory(documentNew, documentOld, raiz);
        generateXml(documentNew);
		
		System.out.println("[INFO] - Nuevo XML creado");
		System.out.println("[INFO] - Coche modificado");
		
		new Selection_Model(configLoad, language, username, client);
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
