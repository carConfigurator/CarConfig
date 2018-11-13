package model;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
	Double price;
	int discount;
	ArrayList<String> accessories;
	
	public PresupuestoXML() {
		this.factory = DocumentBuilderFactory.newInstance();	
		try {
			this.builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		this.implementation = builder.getDOMImplementation();
	
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
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public int getDiscount() {
		return discount;
	}
	
	public void setDiscount(int discount) {
		this.discount = discount;
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
			
				this.node = document.createElement("name");
					Text text = document.createTextNode(getEmployee().split(" ")[1]);//esto separa por el espacio el [Employee] con "nombre_empleado.apellidos" y devuelve el nombre completo
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
		raiz.appendChild(element);//añadimos el element en la raiz
		
		//cogemos la informacion del cliente (la separamos por , por lo tanto lo recogemos por posicion)
			this.element = document.createElement("Client");
			
				this.node = document.createElement("name");
					text = document.createTextNode(getClient().split(",")[0]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("first_lastname");
					text = document.createTextNode(getClient().split(",")[1]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("second_lastname");
					text = document.createTextNode(getClient().split(",")[2]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("address");
					text = document.createTextNode(getClient().split(",")[3]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("email"); 
					text = document.createTextNode(getClient().split(",")[4]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("gender"); 
					text = document.createTextNode(getClient().split(",")[5]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("birthdate"); 
					text = document.createTextNode(getClient().split(",")[6]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
		raiz.appendChild(element);//añadimos el element en la raiz

		//cogemos la informacion del modelo (la separamos por , por lo tanto lo recogemos por posicion)
			this.element = document.createElement("Model");
			
				this.node = document.createElement("id");
					text = document.createTextNode(getModel().split(",")[0]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("name");
					text = document.createTextNode(getModel().split(",")[1]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("description");
					text = document.createTextNode(getModel().split(",")[2]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("price");
					text = document.createTextNode(getModel().split(",")[3]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
		raiz.appendChild(element);//añadimos el element en la raiz

		//cogemos la informacion de los motores (la separamos por , por lo tanto lo recogemos por posicion)
		this.element = document.createElement("Engine");
		//no le pasamos el id, por lo tanto peta
				this.node = document.createElement("id");
					text = document.createTextNode(getEngine().split(",")[0]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("name");
					text = document.createTextNode(getEngine().split(",")[1]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("description");
					text = document.createTextNode(getEngine().split(",")[2]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
				this.node = document.createElement("price");
					text = document.createTextNode(getEngine().split(",")[3]);
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
		raiz.appendChild(element);//añadimos el element en la raiz

		//por cada linea de accessiorios (por cada accessorio) cogemos la informacion separada por ","

			this.element = document.createElement("Accesories");
			Element eAccesory = null;
			for (String accessory : getAccessories()) {
				eAccesory = document.createElement("Accesory");
					this.node = document.createElement("id");
						text = document.createTextNode(accessory.split(",")[0]);
					this.node.appendChild(text);//añadimos el texto al node
				eAccesory.appendChild(this.node);//añadimos el node al element
					this.node = document.createElement("name");
						text = document.createTextNode(accessory.split(",")[1]);
					this.node.appendChild(text);//añadimos el texto al node
				eAccesory.appendChild(this.node);//añadimos el node al element
					this.node = document.createElement("description");
						text = document.createTextNode(accessory.split(",")[2]);
					this.node.appendChild(text);//añadimos el texto al node
				eAccesory.appendChild(this.node);//añadimos el node al element
					this.node = document.createElement("price");
						text = document.createTextNode(accessory.split(",")[3]);
					this.node.appendChild(text);//añadimos el texto al node
				eAccesory.appendChild(this.node);//añadimos el node al element
				this.element.appendChild(eAccesory);//añadimos el element al elementraiz
			}
		raiz.appendChild(this.element);//añadimos el element en la raiz
		
		//cogemos el precio final
			this.element = document.createElement("FinalPrice");
			
				this.node = document.createElement("price");
					text = document.createTextNode(""+getPrice());//esto separa por el espacio el [Employee] con "nombre_empleado.apellidos" y devuelve el nombre completo
				this.node.appendChild(text);//añadimos el texto al node
			this.element.appendChild(this.node);//añadimos el node al element
		raiz.appendChild(element);//añadimos el element en la raiz
		
		
		createXML();
	}

	private void createXML() {
		Source source = new DOMSource(document);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		Result result = new StreamResult(new File("employees"+File.separator+"budgets"+File.separator+"presupuesto_"+timeStamp+".xml")); //nombre del archivo
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
