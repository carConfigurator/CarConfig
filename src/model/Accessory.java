package model;

import java.util.Arrays;

public class Accessory {

	// Atributos de la Clase
	int id;
	String name, description, image_name;
	double price;
	String[] models_available;
	
	public Accessory() {
		super();
	}

	public Accessory(int id, String name, String description, String image_name, double price,
			String[] models_available) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return id + ", " + name + ", " + description + ", " + price;
	}
}
