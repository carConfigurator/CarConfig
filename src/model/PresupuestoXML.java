package model;

import java.util.ArrayList;

public class PresupuestoXML {

	// Atributos de la clase
	String employee, client, model, engine;
	ArrayList<String> accessories;
	
	public PresupuestoXML() {
		super();
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public ArrayList<String> getAccessories() {
		return accessories;
	}

	public void setAccessories(ArrayList<String> accessories) {
		this.accessories = accessories;
	}
	
}
