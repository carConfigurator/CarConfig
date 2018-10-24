package model;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import config.ConfigurationLoader;

public class Engine {

	// Atributos de la clase
	private int[] id;
	private double[] price;
	private String[] name, description, image_name;
	private int[] models_available;
	private ConfigurationLoader configLoad;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	public Engine(ConfigurationLoader configLoad) {
		System.out.println("[INFO] - Cargando Motores...");
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

	public int[] getId() {
		return null;
	}

	public double[] getPrice() {
		return null;
	}

	public String[] getName() {
		return null;
	}

	public String[] getDescription() {
		return null;
	}

	public String[] getImage_name() {
		return null;
	}

	public int[] getModels_available() {
		return models_available;
	}	
}
