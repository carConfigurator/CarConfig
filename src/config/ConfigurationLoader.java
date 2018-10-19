package config;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ConfigurationLoader {
	
	private static ConfigurationLoader configLoad;
	
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	private String language,language_default,postfix_language_file_name,version,language_files_path,car_configuration_path,car_configuration_file_name,employee_version,specifications_file_path;
	private String[] employee_list,employee_password;
	
	private ConfigurationLoader() {
		this.factory = DocumentBuilderFactory.newInstance();
		try {
			this.builder = factory.newDocumentBuilder();
			this.document = builder.parse(new File("src\\config\\cv_config.xml"));
			this.language=loadLanguage();
			this.language_default=loadLanguage_default();
			this.postfix_language_file_name=loadPostfix_language_file_name();
			this.version=loadVersion();
			this.language_files_path=loadLanguage_files_path();
			this.car_configuration_path=loadCar_configuration_path();
			this.car_configuration_file_name=loadCar_configuration_file_name();
			this.employee_list=loadEmployee_list();
			this.employee_version=loadEmployee_version();
			this.employee_password=loadEmployee_password();
			this.specifications_file_path=loadSpecifications_file_path();
		} catch (ParserConfigurationException e) {
			System.out.println("[ERROR] - No se ha podido parsear la configuración. Más información del error: " + e);
		} catch (SAXException e) {
			System.out.println("[ERROR] - No se ha podido parsear el archivo XML. Más información del error: " + e);
		} catch (IOException e) {
			System.out.println("[ERROR] - Error de E/S. Más información del error: " + e);
		}
	}
	
	public static ConfigurationLoader getConfigurationLoaderInstance() {
		if(configLoad == null) {
			System.out.println("[INFO] - Generando instancia...");
			return configLoad = new ConfigurationLoader();
		}else {
			System.out.println("[INFO] - Ya existe una instancia");
			return null;
		}
	}

	private String loadLanguage() {
		NodeList nList = document.getElementsByTagName("language");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}
	
	private String loadLanguage_default() {
		NodeList nList = document.getElementsByTagName("language_default");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}
	
	private String loadPostfix_language_file_name(){
		NodeList nList = document.getElementsByTagName("postfix_language_file_name");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}

	private String loadVersion() {
		NodeList nList = document.getElementsByTagName("version");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}
	
	private String loadLanguage_files_path() {
		NodeList nList = document.getElementsByTagName("language_files_path");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}

	private String loadCar_configuration_path() {
		NodeList nList = document.getElementsByTagName("car_configuration_path");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}
	
	private String loadCar_configuration_file_name() {
		NodeList nList = document.getElementsByTagName("car_configuration_file_name");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}
	
	private String[] loadEmployee_list() {
		NodeList nList = document.getElementsByTagName("employee_list");
		Node nNode = nList.item(0);
		return nNode.getTextContent().split(",");
	}
	
	private String loadEmployee_version() {
		NodeList nList = document.getElementsByTagName("employee_version");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}
	
	private String[] loadEmployee_password() {
		NodeList nList = document.getElementsByTagName("employee_password");
		Node nNode = nList.item(0);
		return nNode.getTextContent().split(",");
	}
	
	private String loadSpecifications_file_path() {
		NodeList nList = document.getElementsByTagName("specifications_file_path");
		Node nNode = nList.item(0);
		return nNode.getTextContent();
	}
	
	public String getLanguage() {
		return language;
	}

	public String getLanguage_default() {
		return language_default;
	}

	public String getPostfix_language_file_name() {
		return postfix_language_file_name;
	}

	public String getVersion() {
		return version;
	}

	public String getLanguage_files_path() {
		return language_files_path;
	}

	public String getCar_configuration_path() {
		return car_configuration_path;
	}

	public String getCar_configuration_file_name() {
		return car_configuration_file_name;
	}

	public String[] getEmployee_list() {
		return employee_list;
	}

	public String getEmployee_version() {
		return employee_version;
	}

	public String[] getEmployee_password() {
		return employee_password;
	}

	public String getSpecifications_file_path() {
		return specifications_file_path;
	}

	@Override
	public String toString() {
		return "ConfigurationLoader language=" + language + ", language_default=" + language_default + ", postfix_language_file_name="
				+ postfix_language_file_name + ", version=" + version + ", language_files_path=" + language_files_path
				+ ", car_configuration_path=" + car_configuration_path + ", car_configuration_file_name="
				+ car_configuration_file_name + ", employee_list=" + employee_list + ", employee_version="
				+ employee_version + ", employee_password=" + employee_password + ", specifications_file_path="
				+ specifications_file_path + "]";
	}
}
