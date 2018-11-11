package model;

import java.util.Arrays;

public class Engine {

	// Atributos de la Clase
	private int id;
	private String name, descritpion, image_name;
	private double price;
	private String[] models_available;
	
	public Engine() {
		super();
	}
	
	public Engine(int id, String name, String descritpion, String image_name, double price, String[] models_available) {
		super();
		this.id = id;
		this.name = name;
		this.descritpion = descritpion;
		this.image_name = image_name;
		this.price = price;
		this.models_available = models_available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String[] getModels_available() {
		return models_available;
	}

	public void setModels_available(String[] models_available) {
		this.models_available = models_available;
	}

	@Override
	public String toString() {
		return name + ", " + descritpion + ", " + price + "€";
	}
}