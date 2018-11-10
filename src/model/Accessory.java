package model;

public class Accessory {

	// Atributos de la Clase
	int id;
	String name, description, image_name;
	double price;
	String[] models_available;
	
	public Accessory() {
		super();
	}

	public Accessory(int id, String name, String description, String image_name, double price,
			String[] models_available) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image_name = image_name;
		this.price = price;
		this.models_available = models_available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

<<<<<<< HEAD
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String[] getModels_available() {
		return models_available;
=======
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
>>>>>>> 9049cbba322bbe1548721eb64d760cee2d5a9ac1
	}

	public void setModels_available(String[] models_available) {
		this.models_available = models_available;
	}
	
}
