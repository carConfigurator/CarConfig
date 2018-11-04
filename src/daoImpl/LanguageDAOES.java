package daoImpl;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import config.ConfigurationLoader;
import idao.ILanguage;

public class LanguageDAOES implements ILanguage{

	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	public LanguageDAOES(ConfigurationLoader configLoad) {
		this.factory = DocumentBuilderFactory.newInstance();
		try {
			this.builder = factory.newDocumentBuilder();
			this.document = builder.parse(new File(configLoad.getLanguage_files_path()+configLoad.getLanguage_default()+configLoad.getPostfix_language_file_name()));
		} catch (ParserConfigurationException e) {
			System.out.println("[ERROR] - No se ha podido parsear la configuración. Más información del error: " + e);
		} catch (SAXException e) {
			System.out.println("[ERROR] - No se ha podido parsear el archivo XML. Más información del error: " + e);
		} catch (IOException e) {
			System.out.println("[ERROR] - Error de E/S. Más información del error: " + e);
		}
	}
	
	@Override
	public String loginTitle() {
		NodeList nList = document.getElementsByTagName("Login");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("title").item(0).getTextContent();
		}
		return null;
	}
	
	@Override
	public String labelUsername() {
		NodeList nList = document.getElementsByTagName("Login");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_username").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelPassword() {
		NodeList nList = document.getElementsByTagName("Login");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_password").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String btnLogin() {
		NodeList nList = document.getElementsByTagName("Login");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("btn_login").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorLoginUser() {
		NodeList nList = document.getElementsByTagName("Login");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_login_user").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorLoginUserTitle() {
		NodeList nList = document.getElementsByTagName("Login");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_login_user_title").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorLoginPassword() {
		NodeList nList = document.getElementsByTagName("Login");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_login_password").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorLoginPasswordTitle() {
		NodeList nList = document.getElementsByTagName("Login");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_login_password_title").item(0).getTextContent();
		}
		return null;
	}
	
	//		-------------------Métodos que se usarán para el Data_Clients.-------------------

	@Override
	public String dataClientsTitle() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("title").item(0).getTextContent();
		}
		return null;
	}
	
	@Override
	public String labelClientTitle() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_client_title").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelAuthIn() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_username").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelClientName() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_client_name").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelClientFirstLastName() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_client_first_lastname").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelClientSecondLastName() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_client_second_lastname").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelClientAddress() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_client_address").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelClientEmail() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_client_email").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelClientGender() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_client_gender").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String radioGenderMale() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("rb_male").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String radioGenderFemale() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("rb_female").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String radioGenderUnknown() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("rb_unknown").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelClientBirhdate() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_client_birthdate").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String btnSave() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("btn_save").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String btnNext() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("btn_next").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorNullField() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_null_field").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorNullFieldTitle() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_null_field_title").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorEmail() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_email").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorEmailTitle() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_email_title").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String btnSaveInfo() {
		NodeList nList = document.getElementsByTagName("Data_clients");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("btn_save_info").item(0).getTextContent();
		}
		return null;
	}
	
	//		-------------------Métodos que se usarán para el Selection_model.-------------------
	
	@Override
	public String seleccionModeloTitle() {
		NodeList nList = document.getElementsByTagName("Selection_model");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("title").item(0).getTextContent();
		}
		return null;
	}
	
	@Override
	public String labelSelectTitle() {
		NodeList nList = document.getElementsByTagName("Selection_model");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_select_title").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String btnPrevious() {
		NodeList nList = document.getElementsByTagName("Selection_model");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("btn_previous").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String menu() {
		NodeList nList = document.getElementsByTagName("Selection_model");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("menu").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String menuItemAdd() {
		NodeList nList = document.getElementsByTagName("Selection_model");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("menu_item_add").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String menuItemDelete() {
		NodeList nList = document.getElementsByTagName("Selection_model");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("menu_item_delete").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String menuItemModify() {
		NodeList nList = document.getElementsByTagName("Selection_model");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("menu_item_modify").item(0).getTextContent();
		}
		return null;
	}
	
	//		-------------------Métodos que se usarán para Selection_Engine.-------------------
	
	@Override
	public String seleccionEngineTitle() {
		NodeList nList = document.getElementsByTagName("Selection_engine");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("title").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelEngineTitle() {
		NodeList nList = document.getElementsByTagName("Selection_engine");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_title").item(0).getTextContent();
		}
		return null;
	}
	
	//		-------------------Métodos que se usarán para Purchase_accessories.-------------------

	@Override
	public String labelAccessoriesTitle() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_title").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelModelCar() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_model_car").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String checkBoxElectricElevation() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("checkBox_electric_elevation").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String checkBoxBrowser() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("checkBox_browser").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String checkBoxTires() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("checkBox_tires").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String checkBoxHeatedSeats() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("checkBox_heated_seats").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String checkBoxCruisingSpeed() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("checkBox_cruising_speed").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String checkBoxAutomaticParking() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("checkBox_automatic_parking").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String checkBoxUsbConnectors() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("checkBox_usb_connectors").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String checkBoxMetallizedPaint() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("checkBox_metallized_paint").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelBasePrice() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_base_price").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelIncreasePrice() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_increase_price").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelTotalPrice() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_total_price").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String btnBack() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("btn_back").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String btnEnd() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("btn_end").item(0).getTextContent();
		}
		return null;
	}
}
