package model;

public class Model {

	// Attributos de la Clase:
	String name, description, image_name;
	int id;
	double price;
	
	public Model() {
		super();
	}


	public Model(int id, String name, String description, String image_name, double price) {
		super();
		this.name = name;
		this.description = description;
		this.image_name = image_name;
		this.id = id;
		this.price = price;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + description + ", " + image_name + ", " + id + ", " + price;
	}
}
