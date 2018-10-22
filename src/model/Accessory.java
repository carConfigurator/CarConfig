package model;

public class Accessory {
	
	// Atributos de la Clase:
	private int id;
	private double price;
	private String name, description, image_name;
	private int[] models_available;
	
	public Accessory() {
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
