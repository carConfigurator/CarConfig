package model;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

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
		
//		this.transformer = null;
		accessories = new ArrayList<String>();
		headerXML();
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
	
	private void headerXML() {
		// Obtenemos la implementación del DOM
		this.implementation = builder.getDOMImplementation();
		// Creamos el documento vacío
		this.document = implementation.createDocument(null, "Presupuesto", null);
		this.document.setXmlVersion("1.0");
		
		createNodes();
	}
	
	
	private void createNodes() {
		Element raiz = document.getDocumentElement();
		
		this.element = document.createElement("employee");
		Text text = document.createTextNode(getEmployee());
//		element.appendChild(this.element);
		this.element.appendChild(text);
		raiz.appendChild(element);
		
		this.element = document.createElement("client");
		text = document.createTextNode(getClient());
//		element.appendChild(this.element);
		this.element.appendChild(text);
		raiz.appendChild(element);
		
		this.element = document.createElement("model");
		text = document.createTextNode(getModel());
//		element.appendChild(this.element);
		this.element.appendChild(text);
		raiz.appendChild(element);
		
		this.element = document.createElement("engine");
		text = document.createTextNode(getEngine());
//		element.appendChild(this.element);
		this.element.appendChild(text);
		raiz.appendChild(element);
		
		this.element = document.createElement("accesories");
		text = document.createTextNode(getClient());
//		element.appendChild(this.element);
		this.element.appendChild(text);
		raiz.appendChild(element);
		
		createXML();
	}

	private void createXML() {
		Source source = new DOMSource(document);
		Result result = new StreamResult(new File("employees\\budgets\\presupuesto.xml")); //nombre del archivo
		Transformer transformer;
		
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			try {
				transformer.transform(source, result);
			} catch (TransformerException e) {
				e.printStackTrace();
			}
		} catch (TransformerException e) {
			System.out.println("Error: " + e);
		}
	}
	
}
