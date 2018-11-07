package model;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PresupuestoXML {

	// Atributos de la clase
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	private DOMImplementation implementation;
	private Document document;
	private Element element;
	private Source source;
	private Result result;
	private Transformer transformer;
	
	String employee, client, model, engine;
	ArrayList<String> accessories;
	
	public PresupuestoXML() {
		this.factory = DocumentBuilderFactory.newInstance();	
		try {
			this.builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		this.implementation = builder.getDOMImplementation();
		
		this.transformer = null;
		accessories = new ArrayList<String>();
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

	public void setAccessories(String line) {
		accessories.add(line);
	}

	@Override
	public String toString() {
		return "PresupuestoXML [employee=" + employee + ", client=" + client + ", model=" + model + ", engine=" + engine
				+ ", accessories=" + accessories + "]";
	}
	
	
	
}
