package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import config.ConfigurationLoader;

public class Engine {

	// Atributos de la clase
	private int id, idEngineSelect;
	private double price;
	private String name, description, image_name;
	private String models_available;
	private ConfigurationLoader configLoad;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	private ArrayList<String> getEngines;
	
	public Engine(ConfigurationLoader configLoad) {
		System.out.println("[INFO] - Cargando Motores...");
		this.configLoad = configLoad;
		this.getEngines = new ArrayList<String>();
		this.factory = DocumentBuilderFactory.newInstance();
		try {
			this.builder = factory.newDocumentBuilder();
			this.document = this.builder.parse(new File(this.configLoad.getCar_configuration_path() + this.configLoad.getCar_configuration_file_name()));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadEngines(int idModel) {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Engine");
		String[] engines = new String[nList.getLength()];
		for (int i = 0; i < engines.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			// Selecciono los elementos del nodo models_avaliable
			String available_models = eElement.getElementsByTagName("models_avaliable").item(0).getTextContent();
			// Hago un split para poder añadirlos a continuación en un array de int.
			String[] am = available_models.split(";");
			int[] models = new int[am.length];
			// Añado los id de los modelos disponibles en el array int.
			for (int j = 0; j < am.length; j++) {
				models[j] = Integer.parseInt(am[j]);
			}
			
			// Recorro el array en busca de la coincidencia con el id del modelo seleccionado.
			for (int j = 0; j < models.length; j++) {
				if(models[j] == idModel) {
					this.id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
					this.name = eElement.getElementsByTagName("nom").item(0).getTextContent();
					this.description = eElement.getElementsByTagName("description").item(0).getTextContent();
					this.image_name = eElement.getElementsByTagName("image_name").item(0).getTextContent();
					this.price = Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent());
					// Finalmente añado la información en un ArrayList<String> para cuando el programa necesite printar en la vista las varias opciones.
					this.getEngines.add(this.name + ", " + this.description + ", " + this.price + "€");
				}
			}	
		}
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

	public String getModels_available() {
		return models_available;
	}

	public ArrayList<String> getEngines(){
		return this.getEngines;
	}
	
	public int getIdSelected() {
		return this.idEngineSelect;
	}
	
	public String getEngineSelected(int idEngine) {
		this.idEngineSelect = idEngine;
		NodeList nList = document.getElementsByTagName("Engine");
		String[] engines = new String[nList.getLength()];
		for (int i = 0; i < engines.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(idEngine == Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent())) {
				int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
				String nom = eElement.getElementsByTagName("nom").item(0).getTextContent();
				String descripcion = eElement.getElementsByTagName("description").item(0).getTextContent();
				double price = Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent());
				return id + ", " + nom + ", " + descripcion + ", " + price;
			}
		}
		return null;
	}
}
