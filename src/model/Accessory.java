package model;

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

import config.ConfigurationLoader;

public class Accessory {
	
	// Atributos de la Clase
	private ConfigurationLoader configLoad;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	private int[] id;
	private double[] price;
	private String[] name, description, image_name;
	private int[] models_available;
	
	public Accessory(ConfigurationLoader configLoad) {
		System.out.println("[INFO] - Cargando Accesorios...");
		this.configLoad = configLoad;
		this.factory = DocumentBuilderFactory.newInstance();
		try {
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
		this.models_available = loadModels_Available();
	}
	
	private int[] loadModels_Available() {
		NodeList nList = document.getElementsByTagName("Accessory");
		int[] mod_avaliable = new int[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				mod_avaliable[temp] = Integer.parseInt(eElement.getElementsByTagName("models_disponibles").item(0).getTextContent());
			}
		}
		return mod_avaliable;
	}

	private String[] loadImage_Name() {
		NodeList nList = document.getElementsByTagName("Accessory");
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
		NodeList nList = document.getElementsByTagName("Accessory");
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
		NodeList nList = document.getElementsByTagName("Accessory");
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
		NodeList nList = document.getElementsByTagName("Accessory");
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
		NodeList nList = document.getElementsByTagName("Accessory");
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

	public int[] getModels_available() {
		return models_available;
	}
}
