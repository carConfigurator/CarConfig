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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class PresupuestoXML {

	// Atributos de la clase
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	private DOMImplementation implementation;
	private Document document;
	private Element element;
	private Node node;
	
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
//		headerXML();
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
	
	public void headerXML() {
		// Obtenemos la implementación del DOM
		this.implementation = builder.getDOMImplementation();
		// Creamos el documento vacío
		this.document = implementation.createDocument(null, "Presupuesto", null);
		this.document.setXmlVersion("1.0");
		
		createNodes();
	}
	
	
	private void createNodes() {
		Element raiz = document.getDocumentElement();
		
		//cogemos el nombre de empleado
			this.element = document.createElement("Employee");
			
				this.node = document.createElement("Employee_Name");
					Text text = document.createTextNode(getEmployee().split(" ")[1]);//esto separa por el espacio el [Employee] con "nombre_empleado.apellidos" y devuelve el nombre completo
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
		raiz.appendChild(element);//añadimos el element en la raiz
		
		//cogemos la informacion del cliente (la separamos por , por lo tanto lo recogemos por posicion)
			this.element = document.createElement("Client");
			
				this.node = document.createElement("Client_Name");
					text = document.createTextNode(getClient().split(",")[0]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Surname");
					text = document.createTextNode(getClient().split(",")[1]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Second_Surname");
					text = document.createTextNode(getClient().split(",")[2]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Address");
					text = document.createTextNode(getClient().split(",")[3]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Email"); 
					text = document.createTextNode(getClient().split(",")[4]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Gender"); 
					text = document.createTextNode(getClient().split(",")[5]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Birthdate"); 
					text = document.createTextNode(getClient().split(",")[6]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
		raiz.appendChild(element);//añadimos el element en la raiz

		//cogemos la informacion del modelo (la separamos por , por lo tanto lo recogemos por posicion)
			this.element = document.createElement("Model");
			
				this.node = document.createElement("Model_Id");
					text = document.createTextNode(getModel().split(",")[0]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Model_Name");
					text = document.createTextNode(getModel().split(",")[1]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Model_Description");
					text = document.createTextNode(getModel().split(",")[2]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Image_Name");
					text = document.createTextNode(getModel().split(",")[3]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Price");
					text = document.createTextNode(getModel().split(",")[4]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
		raiz.appendChild(element);//añadimos el element en la raiz

		//cogemos la informacion de los motores (la separamos por , por lo tanto lo recogemos por posicion)
		this.element = document.createElement("Engine");
		
				this.node = document.createElement("Engine_Id");
					text = document.createTextNode(getEngine().split(",")[0]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Engine_Name");
					text = document.createTextNode(getEngine().split(",")[1]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Engine_Description");
					text = document.createTextNode(getEngine().split(",")[2]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Image_Name");
					text = document.createTextNode(getEngine().split(",")[3]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Price");
					text = document.createTextNode(getEngine().split(",")[4]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("Models_Avaliable");
					text = document.createTextNode(getEngine().split(",")[5]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
		raiz.appendChild(element);//añadimos el element en la raiz

		//por cada linea de accessiorios (por cada accessorio) cogemos la informacion separada por ","
		for (String accessory : getAccessories()) {
				this.element = document.createElement("Accesories");
				
					this.node = document.createElement("Accesory_Id");
						text = document.createTextNode(accessory.split(",")[0]);
					this.node.appendChild(text);//añadimos el texto al node
				this.element.appendChild(this.node);//añadimos el node al element
					this.node = document.createElement("Accesory_Name");
						text = document.createTextNode(accessory.split(",")[1]);
					this.node.appendChild(text);//añadimos el texto al node
				this.element.appendChild(this.node);//añadimos el node al element
					this.node = document.createElement("Accesory_Description");
						text = document.createTextNode(accessory.split(",")[2]);
					this.node.appendChild(text);//añadimos el texto al node
				this.element.appendChild(this.node);//añadimos el node al element
					this.node = document.createElement("Image_Name");
						text = document.createTextNode(accessory.split(",")[3]);
					this.node.appendChild(text);//añadimos el texto al node
				this.element.appendChild(this.node);//añadimos el node al element
					this.node = document.createElement("Price");
						text = document.createTextNode(accessory.split(",")[4]);
					this.node.appendChild(text);//añadimos el texto al node
				this.element.appendChild(this.node);//añadimos el node al element
					this.node = document.createElement("Models_Avaliable");
						text = document.createTextNode(accessory.split(",")[5]);
					this.node.appendChild(text);//añadimos el texto al node
				this.element.appendChild(this.node);//añadimos el node al element
			raiz.appendChild(element);//añadimos el element en la raiz
		}
		
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
