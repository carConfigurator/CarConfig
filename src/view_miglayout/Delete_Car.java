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
import idao.IModel;
import model.Client;
//import model.Model_woDAO;

public class Delete_Car{
	
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	private IModel model;
	
	private JPanel panel = new JPanel();

	public Delete_Car(ConfigurationLoader configLoad, ILanguage language, String username, Client client, IModel model) {
		this.configLoad = configLoad;
		this.language = language;
		this.username = username;
		this.client = client;
		this.model = model;
		
		//dialogo para mostrar el coche que vamos a eliminar
		int optionPane=JOptionPane.showConfirmDialog(panel, language.dataDeleteCarTitle()+"\n"
						+language.labelId()+model.getModel(model.getSelectedId()).getId()+"\n"
						+language.labelName()+model.getModel(model.getSelectedId()).getName()+"\n"
						+language.labelDescription()+model.getModel(model.getSelectedId()).getDescription()+"\n"
						+language.labelImg_Name()+model.getModel(model.getSelectedId()).getImage_name()+"\n"
						+language.labelPrice()+model.getModel(model.getSelectedId()).getPrice()+"\n"
					,language.deleteCarTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (optionPane==JOptionPane.YES_OPTION) {
			model.deleteCar(configLoad, language, username, client);
		}else {
			new Selection_Model(this.configLoad, this.language, this.username, this.client, this.model);
		}
	}
}
