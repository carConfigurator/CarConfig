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

import config.ConfigurationLoader;
import idao.IModel;
import model.Model;

public class ModelDAO_XML implements IModel{
	
	// Atributos de la Implementación:
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	public ModelDAO_XML() {
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
		
		loadModels();
	}

	@Override
	public Model getModel(int id) {
		return models.get(id);
	}

	@Override
	public ArrayList<Model> getModels() {
		return models;
	}

	@Override
	public void loadModels() {
		NodeList nList = document.getElementsByTagName("Model");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
				String name = eElement.getElementsByTagName("name").item(0).getTextContent();
				String description = eElement.getElementsByTagName("description").item(0).getTextContent();
				String image_name = eElement.getElementsByTagName("image_name").item(0).getTextContent();
				double price = Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent());
				models.add(new Model(id, name, description, image_name, price));
			}
		}
	}
}
