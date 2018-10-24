package model;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

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
		this.id = loadId();
		this.price = loadPrice();
		this.name = loadName();
		this.description = loadDescription();
		this.image_name = loadImage_Name();
		this.models_available = loadModels_Available();
	}
	
	private int[] loadModels_Available() {
		return null;
	}

	private String[] loadImage_Name() {
		return null;
	}

	private String[] loadDescription() {
		return null;
	}

	private String[] loadName() {
		return null;
	}

	private double[] loadPrice() {
		return null;
	}

	private int[] loadId() {
		return null;
	}

}
