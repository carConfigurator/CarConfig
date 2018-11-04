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

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import config.ConfigurationLoader;

public class Engine {

	// Atributos de la clase
	private int[] id;
	private double[] price;
	private String[] name, description, image_name;
	private String[] models_available;
	private ConfigurationLoader configLoad;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	public Engine(ConfigurationLoader configLoad) {
		System.out.println("[INFO] - Cargando Motores...");
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
		System.out.println(getInformation());
	}

	private String[] loadModels_Available() {
		NodeList nList = document.getElementsByTagName("Engine");
//		int[] mod_avaliable = new int[nList.getLength()];
		String[] mod_avaliable = new String[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				mod_avaliable[temp] = eElement.getElementsByTagName("models_avaliable").item(0).getTextContent();
			}
		}
//		for (int i = 0; i < modelosString.length; i++) {
//			mod_avaliable[i]=Integer.parseInt(modelosString[i]);
//		}
		return mod_avaliable;
	}

	private String[] loadImage_Name() {
		NodeList nList = document.getElementsByTagName("Engine");
		String[] image = new String[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				image[temp] = eElement.getElementsByTagName("image_name").item(0).getTextContent();
			}
		}
		return image;
	}

	private String[] loadDescription() {
		NodeList nList = document.getElementsByTagName("Engine");
		String[] description = new String[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				description[temp] = eElement.getElementsByTagName("description").item(0).getTextContent();
			}
		}
		return description;
	}

	private String[] loadName() {
		NodeList nList = document.getElementsByTagName("Engine");
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
		NodeList nList = document.getElementsByTagName("Engine");
		double[] price = new double[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				price[temp] = Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent());
			}
		}
		return price;
	}

	private int[] loadId() {
		NodeList nList = document.getElementsByTagName("Engine");
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

	public String[] getModels_available() {
		return models_available;
	}	
	
	private String getInformation() {
		return "Id: "+Arrays.toString(id)+", precio: "+Arrays.toString(price)+", nomobre: "+Arrays.toString(name)+", descripcion: "+Arrays.toString(description)+", ruta imagen: "+Arrays.toString(image_name)+", modelos disponibles: "+Arrays.toString(models_available);
	}
}
