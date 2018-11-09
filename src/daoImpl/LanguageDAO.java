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

public class LanguageDAO implements ILanguage{

	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	public LanguageDAO(ConfigurationLoader configLoad) {
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
	
	//  ------------------------------Default title-------------------------------------
	@Override
	public String titleDefault() {
		NodeList nList = document.getElementsByTagName("title_default");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}
	
	//	------------------------------Botones----------------------------------

	@Override
	public String btnLogin() {
		NodeList nList = document.getElementsByTagName("btn_login");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}
	
	@Override
	public String btnSave() {
		NodeList nList = document.getElementsByTagName("btn_save");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}

	@Override
	public String btnNext() {
		NodeList nList = document.getElementsByTagName("btn_next");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}

	@Override
	public String btnSaveInfo() {
		NodeList nList = document.getElementsByTagName("btn_save_info");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}
	
	@Override
	public String btnPrevious() {
		NodeList nList = document.getElementsByTagName("btn_previous");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}

	@Override
	public String btnBack() {
		NodeList nList = document.getElementsByTagName("btn_back");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}

	@Override
	public String btnEnd() {
		NodeList nList = document.getElementsByTagName("btn_end");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}

	@Override
	public String btnStart() {
		NodeList nList = document.getElementsByTagName("btn_start");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}

	//		-------------------Métodos que se usarán para el Login.-------------------

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
	public String purchaseAccessoriesTitle() {
		NodeList nList = document.getElementsByTagName("Purchase_accessories");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("title").item(0).getTextContent();
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
	
	//		-------------------Métodos que se usarán para Add_Car.-------------------

	@Override
	public String addCarTitle() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("title").item(0).getTextContent();
		}
		return null;
	}
	
	@Override
	public String labelId() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_id").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelName() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_name").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelDescription() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_description").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelImg_Name() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_img_name").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelPrice() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_price").item(0).getTextContent();
		}
		return null;
	}
	
	@Override
	public String errorParseDouble() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_parse_double").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorParseDoubleTitle() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_parse_double_title").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorPriceNull() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_price_null").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorPriceNullTitle() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_price_null_title").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorImgName() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_img_name").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorImgNameTitle() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_img_name_title").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorImgNameNull() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_img_name_null").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String errorImgNameNullTitle() {
		NodeList nList = document.getElementsByTagName("Add_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("error_img_name_null_title").item(0).getTextContent();
		}
		return null;
	}
	
	//		-------------------Métodos que se usarán para Delete_Car.-------------------

	@Override
	public String deleteCarTitle() {
		NodeList nList = document.getElementsByTagName("Delete_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("title").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String dataDeleteCarTitle() {
		NodeList nList = document.getElementsByTagName("Delete_Car");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_data_title").item(0).getTextContent();
		}
		return null;
	}

	//		-------------------Métodos que se usarán para Delete_Car.-------------------

	@Override
	public String labelDeliveryNote() {
		NodeList nList = document.getElementsByTagName("Delivery_Note");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_data_title").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelClient() {
		NodeList nList = document.getElementsByTagName("Delivery_Note");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_data_title").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelCompany() {
		NodeList nList = document.getElementsByTagName("Delivery_Note");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_company").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelCompanyName() {
		NodeList nList = document.getElementsByTagName("Delivery_Note");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_company_name").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelEmployee() {
		NodeList nList = document.getElementsByTagName("Delivery_Note");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("lable_employee").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String labelMail() {
		NodeList nList = document.getElementsByTagName("Delivery_Note");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("label_mail").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String table() {
		NodeList nList = document.getElementsByTagName("Delivery_Note");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("table").item(0).getTextContent();
		}
		return null;
	}

	@Override
	public String tableOne() {
		NodeList nList = document.getElementsByTagName("Delivery_Note");
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return ""+eElement.getElementsByTagName("tableOne").item(0).getTextContent();
		}
		return null;
	}

	
}
