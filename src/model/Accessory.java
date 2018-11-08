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

import config.ConfigurationLoader;

public class Accessory {
	
	// Atributos de la Clase
	private ConfigurationLoader configLoad;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	private int[] id;
	private double[] price;
	private String[] name, description, image_name, models_available;//models son ints, pero para manejarlos utilizamos string
	
	public Accessory(ConfigurationLoader configLoad) {
		System.out.println("[INFO] - Cargando Accesorios...");
		this.configLoad = configLoad;
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
		this.id = loadId();
		this.price = loadPrice();
		this.name = loadName();
		this.description = loadDescription();
		this.image_name = loadImage_Name();
		this.models_available = loadModels_Available();
		System.out.println(getInformation());
	}
	
	//son ints en un array de string, al usarlos pasarlo a int
	private String[] loadModels_Available() {
		NodeList nList = document.getElementsByTagName("Accessory");
//		int[] mod_avaliable = new int[nList.getLength()];
		String[] mod_avaliable = new String[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				mod_avaliable[temp] = eElement.getElementsByTagName("models_disponibles").item(0).getTextContent();
			}
		}
		
		return mod_avaliable;
	}

	private String[] loadImage_Name() {
		NodeList nList = document.getElementsByTagName("Accessory");
		String[] image = new String[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				image[temp] = eElement.getElementsByTagName("imatge_nom").item(0).getTextContent();
			}
		}
		
		return image;
	}

	private String[] loadDescription() {
		NodeList nList = document.getElementsByTagName("Accessory");
		String[] description = new String[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				description[temp] = eElement.getElementsByTagName("descripcio").item(0).getTextContent();
			}
		}
		
		return description;
	}

	private String[] loadName() {
		NodeList nList = document.getElementsByTagName("Accessory");
		String[] name = new String[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				name[temp] = eElement.getElementsByTagName("nom").item(0).getTextContent();
			}
		}
		return name;
	}

	private double[] loadPrice() {
		NodeList nList = document.getElementsByTagName("Accessory");
		double[] price = new double[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				price[temp] = Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
			}
		}
		return price;
	}

	private int[] loadId() {
		NodeList nList = document.getElementsByTagName("Accessory");
		int[] id = new int[nList.getLength()];
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				id[temp] = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
			}
		}
		return id;
	}

	public int[] getId() {
		return id;
	}

	public double[] getPrice() {
		return price;
	}

	public String[] getName() {
		return name;
	}

	public String[] getDescription() {
		return description;
	}

	public String[] getImage_name() {
		return image_name;
	}

	public String[] getModels_available() {
		return models_available;
	}
	
	private String getInformation() {
		return "Id: "+Arrays.toString(id)+", precio: "+Arrays.toString(price)+", nomobre: "+Arrays.toString(name)+", descripcion: "+Arrays.toString(description)+", ruta imagen: "+Arrays.toString(image_name)+", modelos disponibles: "+Arrays.toString(models_available);
	}

	public boolean checkElectricElevation(int idSelected) {
		return checkAccesory(idSelected, "Elevaduras electricas");
	}
	
	public boolean checkNavegation(int idSelected) {
		return checkAccesory(idSelected, "Navegador"); 
	}
	
	public boolean checkTire(int idSelected) {
		return checkAccesory(idSelected, "Yantas de aleacion");
	}
	
	public boolean checkSeating(int idSelected) {
		return checkAccesory(idSelected, "Asientos calefactados");
	}
	
	public boolean checkSpeedCruise(int idSelected) {
		return checkAccesory(idSelected, "Velocidad de crucero");
	}
	
	public boolean checkMetallicPaint(int idSelected) {
		return checkAccesory(idSelected, "Pintura metalizada");
	}
	
	public boolean checkAutoParking(int idSelected) {
		return checkAccesory(idSelected, "Aparcamiento automatico");
	}
	
	public boolean checkUSB(int idSelected) {
		return checkAccesory(idSelected, "Conectores USB");
	}	

	private boolean checkAccesory(int idSelected, String accessory) {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			// Selecciono los elementos del nodo models_avaliable
			String available_models = eElement.getElementsByTagName("models_disponibles").item(0).getTextContent();
			String nom_accesories = eElement.getElementsByTagName("nom").item(0).getTextContent();
			
			if(nom_accesories.equals(accessory)) {
				// Hago un split para poder añadirlos a continuación en un array de int.
				String[] am = available_models.split(";");
				int[] models = new int[am.length];
				// Añado los id de los modelos disponibles en el array int.
				for (int j = 0; j < am.length; j++) {
					models[j] = Integer.parseInt(am[j]);
				}
				
				// Recorro el array en busca de la coincidencia con el id del modelo seleccionado.
				for (int j = 0; j < models.length; j++) {
					if(models[j] == idSelected) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public double getPriceElevators() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 1) {
				return Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
			}
		}
		return 0;
	}

	public double getPriceNavegador() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 2) {
				return Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
			}
		}
		return 0;
	}

	public double getPriceTires() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 3) {
				return Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
			}
		}
		return 0;
	}

	public double getPriceSeating() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 4) {
				return Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
			}
		}
		return 0;
	}
	
	public double getPriceSpeedCruise() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 5) {
				return Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
			}
		}
		return 0;
	}

	public double getPriceAutoParking() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 6) {
				return Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
			}
		}
		return 0;
	}

	public double getPriceUSB() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 7) {
				return Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
			}
		}
		return 0;
	}

	public double getPriceMetallicPaint() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 8) {
				return Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
			}
		}
		return 0;
	}

	public String getElevators() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 1) {
				int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
				String nom = eElement.getElementsByTagName("nom").item(0).getTextContent();
				String descripcio = eElement.getElementsByTagName("descripcio").item(0).getTextContent();
				double price = Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
				return id + "," + nom + "," + descripcio + "," + price;
			}
		}
		return null;
	}

	public String getNavegator() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 2) {
				int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
				String nom = eElement.getElementsByTagName("nom").item(0).getTextContent();
				String descripcio = eElement.getElementsByTagName("descripcio").item(0).getTextContent();
				double price = Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
				return id + "," + nom + "," + descripcio + "," + price;
			}
		}
		return null;
	}

	public String getTires() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 3) {
				int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
				String nom = eElement.getElementsByTagName("nom").item(0).getTextContent();
				String descripcio = eElement.getElementsByTagName("descripcio").item(0).getTextContent();
				double price = Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
				return id + "," + nom + "," + descripcio + "," + price;
			}
		}
		return null;
	}

	public String getSeating() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 4) {
				int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
				String nom = eElement.getElementsByTagName("nom").item(0).getTextContent();
				String descripcio = eElement.getElementsByTagName("descripcio").item(0).getTextContent();
				double price = Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
				return id + "," + nom + "," + descripcio + "," + price;
			}
		}
		return null;
	}

	public String getSpeedCruise() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 5) {
				int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
				String nom = eElement.getElementsByTagName("nom").item(0).getTextContent();
				String descripcio = eElement.getElementsByTagName("descripcio").item(0).getTextContent();
				double price = Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
				return id + "," + nom + "," + descripcio + "," + price;
			}
		}
		return null;
	}

	public String getAutoParking() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 6) {
				int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
				String nom = eElement.getElementsByTagName("nom").item(0).getTextContent();
				String descripcio = eElement.getElementsByTagName("descripcio").item(0).getTextContent();
				double price = Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
				return id + "," + nom + "," + descripcio + "," + price;
			}
		}
		return null;
	}

	public String getUSB() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 7) {
				int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
				String nom = eElement.getElementsByTagName("nom").item(0).getTextContent();
				String descripcio = eElement.getElementsByTagName("descripcio").item(0).getTextContent();
				double price = Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
				return id + "," + nom + "," + descripcio + "," + price;
			}
		}
		return null;
	}

	public String getMetallicPaint() {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == 8) {
				int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
				String nom = eElement.getElementsByTagName("nom").item(0).getTextContent();
				String descripcio = eElement.getElementsByTagName("descripcio").item(0).getTextContent();
				double price = Double.parseDouble(eElement.getElementsByTagName("preu").item(0).getTextContent());
				return id + "," + nom + "," + descripcio + "," + price;
			}
		}
		return null;
	}

	public ArrayList<String> getModelsAvailables(int idAccessory) {
		System.out.println("[INFO] - Seleccionando motores según el Modelo escogido");
		ArrayList<String> name_models = new ArrayList<String>();
		
		for (String string : name_models) {
			System.out.println(string);
		}
		
		NodeList nList = document.getElementsByTagName("Accessory");		
		String[] accessories = new String[nList.getLength()];
		for (int i = 0; i < accessories.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == idAccessory) {
				// Selecciono los elementos del nodo models_avaliable
				String available_models = eElement.getElementsByTagName("models_disponibles").item(0).getTextContent();
				// Hago un split para poder añadirlos a continuación en un array de int.
				String[] am = available_models.split(";");
				int[] models = new int[am.length];
				
				// Añado los id de los modelos disponibles en el array int.
				for (int j = 0; j < am.length; j++) {
					models[j] = Integer.parseInt(am[j]);
				}
				
				for (int j = 0; j < models.length; j++) {
					name_models.add(getNameModel(models[j]));
				}
			}
		}
		return name_models;
	}

	private String getNameModel(int idModel) {
		NodeList nList = document.getElementsByTagName("Model");
		String[] model = new String[nList.getLength()];
		for (int i = 0; i < model.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()) == idModel) {
				return eElement.getElementsByTagName("nom").item(0).getTextContent();
			}
		}
		return null;
	}
	
	
}
