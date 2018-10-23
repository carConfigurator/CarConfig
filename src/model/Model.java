package model;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import config.ConfigurationLoader;

public class Model {

	// Atributos de la Clase
	private ConfigurationLoader configLoad;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	private int id;
	private double price;
	private String name, description, image_name;
	
	public Model(ConfigurationLoader configLoad) {
		this.configLoad = configLoad;
		this.factory = DocumentBuilderFactory.newInstance();
		try {
			System.out.println("[INFO] - Ruta de car: " + configLoad.getCar_configuration_path()+this.configLoad.getCar_configuration_file_name());
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
	}

	private String loadImage_Name() {
		return null;
	}

	private String loadDescription() {
		return null;
	}

	private String loadName() {
		return null;
	}

	private double loadPrice() {
		return 0;
	}

	private int loadId() {
		return 0;
	}
	
	
}
