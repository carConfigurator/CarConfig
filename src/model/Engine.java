package model;

public class Engine {

	// Atributos de la clase
	private int id;
	private double price;
	private String name, description, image_name;
	private int[] models_available;
	
	public Engine() {
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

	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getImage_name() {
		return image_name;
	}

	public int[] getModels_available() {
		return models_available;
	}	
}
