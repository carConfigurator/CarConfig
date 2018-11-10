package daoImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import idao.IAccessory;
import model.Accessory;
import model.Engine;

public class AccessoryDAO_XML implements IAccessory{

	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	
	
	public AccessoryDAO_XML() {
		this.factory = DocumentBuilderFactory.newInstance();
		try {
			this.builder = factory.newDocumentBuilder();
			try {
				this.document = builder.parse(new File(configLoad.getCar_configuration_path() + configLoad.getCar_configuration_file_name()));
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	
		loadAccesories();
	}

	@Override
	public void loadAccesories() {
		NodeList nList = document.getElementsByTagName("Accesory");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
				String name = eElement.getElementsByTagName("name").item(0).getTextContent();
				String description = eElement.getElementsByTagName("description").item(0).getTextContent();
				String image_name = eElement.getElementsByTagName("image_name").item(0).getTextContent();
				double price = Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent());
				String[] models_availables = eElement.getElementsByTagName("models_available").item(0).getTextContent().split(";");
				accesories.add(new Accessory(id, name, description, image_name, price, models_availables));
			}
		}
	}

	@Override
	public ArrayList<Accessory> getAccesories() {
		return accesories;
	}

	@Override
	public Accessory getAccessory(int id) {
		return accesories.get(id);
	}

}
