package view_miglayout;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import config.ConfigurationLoader;
import idao.ILanguage;
import model.Client;
import model.Model_woDAO;

public class Delete_Car{
	
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	private Model_woDAO model;
	
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document documentOld;
	
	private JPanel panel = new JPanel();

	public Delete_Car(ConfigurationLoader configLoad, ILanguage language, String username, Client client, Model_woDAO model) {
		this.configLoad = configLoad;
		this.language = language;
		this.username = username;
		this.client = client;
		this.model = model;
		
		this.factory = DocumentBuilderFactory.newInstance();
		try {
			this.builder = factory.newDocumentBuilder();
			this.documentOld = builder.parse(new File(configLoad.getCar_configuration_path()+configLoad.getCar_configuration_file_name()));
		} catch (ParserConfigurationException e) {
			System.out.println("[ERROR] - No se ha podido parsear la configuración. Más información del error: " + e);
		} catch (SAXException e) {
			System.out.println("[ERROR] - No se ha podido parsear el archivo XML. Más información del error: " + e);
		} catch (IOException e) {
			System.out.println("[ERROR] - Error de E/S. Más información del error: " + e);
		}
		
		//string en que le guardamos la info del modelo
		String[] info=new String[5];
		
		//buscamos el modelo que queremos
		NodeList nList = documentOld.getElementsByTagName("Model");
		String[] models = new String[nList.getLength()];
		for (int i = 0; i < models.length; i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			//cuando lo encontremos cogemos la info de ese modelo y lo guardamos al array
			if (eElement.getElementsByTagName("id").item(0).getTextContent().equals(""+this.model.getIdSelected())) {
				for (int j = 0; j < 5; j++) {
					String allInfo = eElement.getElementsByTagName("*").item(j).getTextContent();
					info[j]=allInfo;
				}
			}
		}
		
		//dialogo para mostrar el coche que vamos a eliminar
		int optionPane=JOptionPane.showConfirmDialog(panel, language.dataDeleteCarTitle()+"\n"
						+language.labelId()+info[0]+"\n"
						+language.labelName()+info[1]+"\n"
						+language.labelDescription()+info[2]+"\n"
						+language.labelImg_Name()+info[3]+"\n"
						+language.labelPrice()+info[4]+"\n"
					,language.deleteCarTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (optionPane==JOptionPane.YES_OPTION) {
			model.deleteCar(configLoad, language, username, client, documentOld);
		}else {
			new Selection_Model(this.configLoad, this.language, this.username, this.client, this.model);
		}
	}
}
