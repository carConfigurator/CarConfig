package model;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import config.ConfigurationLoader;

public class Model {

	// Atributos de la Clase
	private ConfigurationLoader configLoad;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	private int[] id;
	private double[] price;
	private String[] name, description, image_name;
	
	private String nameSelected, descriptionSelected;
	private int idSelected;
	private double priceSelected;
	
	public Model(ConfigurationLoader configLoad) {
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
//			System.out.println("[INFO] - "+nNode);
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
				this.nameSelected = eElement.getElementsByTagName("nom").item(0).getTextContent();
				this.descriptionSelected = eElement.getElementsByTagName("descripcio").item(0).getTextContent();
				this.priceSelected = Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
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
		return idSelected+1;
	}

	public double getPriceSelected() {
		return priceSelected;
	}
	
	
}
