package daoImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	
	private File languageFile;
	
	private FileReader fr;
	private BufferedReader br;
	
	private String titleDefault,btnLogin,btnSave,btnNext,btnSaveInfo,btnPrevious,btnBack,btnEnd,btnStart,titleLogin,labelUsername,labelPassword,errorLoginUser,errorLoginUserTitle,
		errorLoginPassword,errorLoginPasswordTitle,titleClients,labelClientTitle,labelUser,labelClientName,labelClientFirstLastname,labelClientSecondLastname,labelClientAddress,
		labelClientEmail,labelClientGender,rbMale,rbFemale,rbUnknown,labelClientBirthdate,errorNullField,errorNullFieldTitle,errorEmail,errorEmailTitle,titleModel,labelSelectTitle,
		menu,menuItemAdd,menuItemDelete,menuItemModify,titleEngine,labelTitle,titleAccessories,labelModelCar,checkBoxElectricElevation,checkBoxBrowser,checkBoxTires,checkBoxHeatedSeats,
		checkBoxCruisingSpeed,checkBoxAutomaticParking,checkBoxUsbConnectors,checkBoxMetallizedPaint,labelBasePrice,labelIncreasePrice,labelTotalPrice,titleAddCar,labelId,labelName,
		labelDescription,labelImgName,labelPrice,errorParseDouble,errorParseDoubleTitle,errorPriceNull,errorPriceNullTitle,errorImgName,errorImgNameTitle,errorImgNameNull,
		errorImgNameNullTitle,titleDeleteCar,labelDataTitle,titleModifyCar,titleDeliveryNote,labelClient,labelCompany,labelCompanyName,lableEmployee,labelMail,table,tableOne;
	
	private String[] languageText;
	
	public LanguageDAO(ConfigurationLoader configLoad) {
		this.languageFile = new File(configLoad.getLanguage_files_path()+configLoad.getLanguage_default()+configLoad.getPostfix_language_file_name());
		
		String line="";
		int contador = 0;
		try {
			fr = new FileReader(this.languageFile);
			br = new BufferedReader(fr);
			
			try {
				//miramos cuantas linias hay en el archivo
				while (!(line=""+br.readLine()).equals("null")) {
					contador++;
				}
				fr.close();
				br.close();
				fr = new FileReader(this.languageFile);
				br = new BufferedReader(fr);
				languageText=new String[contador];
				contador=0;
				//leemos la info y la guardamos en variables
				while((line = br.readLine()) != null) {
					languageText[contador]=line.split("\"")[1];
					contador++;
				}
				
				titleDefault=languageText[0];
				btnLogin=languageText[1];
				btnSave=languageText[2];
				btnNext=languageText[3];
				btnSaveInfo=languageText[4];
				btnPrevious=languageText[5];
				btnBack=languageText[6];
				btnEnd=languageText[7];
				btnStart=languageText[8];
				titleLogin=languageText[9];
				labelUsername=languageText[10];
				labelPassword=languageText[11];
				errorLoginUser=languageText[12];
				errorLoginUserTitle=languageText[13];
				errorLoginPassword=languageText[14];
				errorLoginPasswordTitle=languageText[15];
				titleClients=languageText[16];
				labelClientTitle=languageText[17];
				labelUsername=languageText[18];
				labelClientName=languageText[19];
				labelClientFirstLastname=languageText[20];
				labelClientSecondLastname=languageText[21];
				labelClientAddress=languageText[22];
				labelClientEmail=languageText[23];
				labelClientGender=languageText[24];
				rbMale=languageText[25];
				rbFemale=languageText[26];
				rbUnknown=languageText[27];
				labelClientBirthdate=languageText[28];
				errorNullField=languageText[29];
				errorNullFieldTitle=languageText[30];
				errorEmail=languageText[31];
				errorEmailTitle=languageText[32];
				titleModel=languageText[33];
				labelSelectTitle=languageText[34];
				menu=languageText[35];
				menuItemAdd=languageText[36];
				menuItemDelete=languageText[37];
				menuItemModify=languageText[38];
				titleEngine=languageText[39];
				labelTitle=languageText[40];
				titleAccessories=languageText[41];
				labelModelCar=languageText[42];
				checkBoxElectricElevation=languageText[43];
				checkBoxBrowser=languageText[44];
				checkBoxTires=languageText[45];
				checkBoxHeatedSeats=languageText[46];
				checkBoxCruisingSpeed=languageText[47];
				checkBoxAutomaticParking=languageText[48];
				checkBoxUsbConnectors=languageText[49];
				checkBoxMetallizedPaint=languageText[50];
				labelBasePrice=languageText[51];
				labelIncreasePrice=languageText[52];
				labelTotalPrice=languageText[53];
				titleAddCar=languageText[54];
				labelId=languageText[55];
				labelName=languageText[56];
				labelDescription=languageText[57];
				labelImgName=languageText[58];
				labelPrice=languageText[59];
				errorParseDouble=languageText[60];
				errorParseDoubleTitle=languageText[61];
				errorPriceNull=languageText[62];
				errorPriceNullTitle=languageText[63];
				errorImgName=languageText[64];
				errorImgNameTitle=languageText[65];
				errorImgNameNull=languageText[66];
				errorImgNameNullTitle=languageText[67];
				titleDeleteCar=languageText[68];
				labelDataTitle=languageText[69];
				titleModifyCar=languageText[70];
				titleDeliveryNote=languageText[71];
				labelDataTitle=languageText[72];
				labelCompany=languageText[73];
				labelCompanyName=languageText[74];
				lableEmployee=languageText[75];
				labelMail=languageText[76];
				table=languageText[77];
				tableOne=languageText[78];
			}catch(IOException e) {
				System.out.println("[ERROR] - Error al leer el lenguaje");
			}
		}catch(FileNotFoundException ex) {
			System.out.println("[ERROR] - Error al buscar el fichero de lenguaje");
		}
	}
	
	//  ------------------------------Default title-------------------------------------
	@Override
	public String titleDefault() {
		return titleDefault;
	}
	
	//	------------------------------Botones----------------------------------

	@Override
	public String btnLogin() {
		return btnLogin;
	}
	
	@Override
	public String btnSave() {
		return btnSave;
	}

	@Override
	public String btnNext() {
		return btnNext;
	}

	@Override
	public String btnSaveInfo() {
		return btnSaveInfo;
	}
	
	@Override
	public String btnPrevious() {
		return btnPrevious;
	}

	@Override
	public String btnBack() {
		return btnBack;
	}

	@Override
	public String btnEnd() {
		return btnEnd;
	}

	@Override
	public String btnStart() {
		return btnStart;
	}

	//		-------------------Métodos que se usarán para el Login.-------------------

	@Override
	public String loginTitle() {
		return titleLogin;
	}
	
	@Override
	public String labelUsername() {
		return labelUsername;
	}
	
	@Override
	public String labelPassword() {
		return labelPassword;
	}

	@Override
	public String errorLoginUser() {
		return errorLoginUser;
	}

	@Override
	public String errorLoginUserTitle() {
		return errorLoginUserTitle;
	}
	
	@Override
	public String errorLoginPassword() {
		return errorLoginPassword;
	}

	@Override
	public String errorLoginPasswordTitle() {
		return errorLoginPasswordTitle;
	}
	
	//		-------------------Métodos que se usarán para el Data_Clients.-------------------

	@Override
	public String dataClientsTitle() {
		return titleClients;
	}
	
	@Override
	public String labelClientTitle() {
		return labelClientTitle;
	}

	@Override
	public String labelAuthIn() {
		return labelUser;
	}

	@Override
	public String labelClientName() {
		return labelClientName;
	}

	@Override
	public String labelClientFirstLastName() {
		return labelClientFirstLastname;
	}

	@Override
	public String labelClientSecondLastName() {
		return labelClientSecondLastname;
	}
	
	@Override
	public String labelClientAddress() {
		return labelClientAddress;
	}

	@Override
	public String labelClientEmail() {
		return labelClientEmail;
	}

	@Override
	public String labelClientGender() {
		return labelClientGender;
	}

	@Override
	public String radioGenderMale() {
		return rbMale;
	}

	@Override
	public String radioGenderFemale() {
		return rbFemale;
	}

	@Override
	public String radioGenderUnknown() {
		return rbUnknown;
	}

	@Override
	public String labelClientBirhdate() {
		return labelClientBirthdate;
	}

	@Override
	public String errorNullField() {
		return errorNullField;
	}

	@Override
	public String errorNullFieldTitle() {
		return errorNullFieldTitle;
	}

	@Override
	public String errorEmail() {
		return errorEmail;
	}

	@Override
	public String errorEmailTitle() {
		return errorEmailTitle;
	}
	
	//		-------------------Métodos que se usarán para el Selection_model.-------------------
	
	@Override
	public String seleccionModeloTitle() {
		return titleModel;
	}
	
	@Override
	public String labelSelectTitle() {
		return labelSelectTitle;
	}

	@Override
	public String menu() {
		return menu;
	}

	@Override
	public String menuItemAdd() {
		return menuItemAdd;
	}

	@Override
	public String menuItemDelete() {
		return menuItemDelete;
	}

	@Override
	public String menuItemModify() {
		return menuItemModify;
	}
	
	//		-------------------Métodos que se usarán para Selection_Engine.-------------------
	
	@Override
	public String seleccionEngineTitle() {
		return titleEngine;
	}

	@Override
	public String labelEngineTitle() {
		return labelTitle;
	}
	
	//		-------------------Métodos que se usarán para PurchaseAccessories.-------------------

	@Override
	public String purchaseAccessoriesTitle() {
		return titleAccessories;
	}

	@Override
	public String labelModelCar() {
		return labelModelCar;
	}

	@Override
	public String checkBoxElectricElevation() {
		return checkBoxElectricElevation;
	}
	
	@Override
	public String checkBoxBrowser() {
		return checkBoxBrowser;
	}

	@Override
	public String checkBoxTires() {
		return checkBoxTires;
	}

	@Override
	public String checkBoxHeatedSeats() {
		return checkBoxHeatedSeats;
	}

	@Override
	public String checkBoxCruisingSpeed() {
		return checkBoxCruisingSpeed;
	}

	@Override
	public String checkBoxAutomaticParking() {
		return checkBoxAutomaticParking;
	}

	@Override
	public String checkBoxUsbConnectors() {
		return checkBoxUsbConnectors;
	}

	@Override
	public String checkBoxMetallizedPaint() {
		return checkBoxMetallizedPaint;
	}

	@Override
	public String labelBasePrice() {
		return labelBasePrice;
	}

	@Override
	public String labelIncreasePrice() {
		return labelIncreasePrice;
	}

	@Override
	public String labelTotalPrice() {
		return labelTotalPrice;
	}
	
	//		-------------------Métodos que se usarán para Add_Car.-------------------

	@Override
	public String addCarTitle() {
		return titleAddCar;
	}
	
	@Override
	public String labelId() {
		return labelId;
	}

	@Override
	public String labelName() {
		return labelName;
	}

	@Override
	public String labelDescription() {
		return labelDescription;
	}

	@Override
	public String labelImg_Name() {
		return labelImgName;
	}

	@Override
	public String labelPrice() {
		return labelPrice;
	}
	
	@Override
	public String errorParseDouble() {
		return errorParseDouble;
	}

	@Override
	public String errorParseDoubleTitle() {
		return errorParseDoubleTitle;
	}

	@Override
	public String errorPriceNull() {
		return errorPriceNull;
	}

	@Override
	public String errorPriceNullTitle() {
		return errorPriceNullTitle;
	}

	@Override
	public String errorImgName() {
		return errorImgName;
	}

	@Override
	public String errorImgNameTitle() {
		return errorImgNameTitle;
	}

	@Override
	public String errorImgNameNull() {
		return errorImgNameNull;
	}

	@Override
	public String errorImgNameNullTitle() {
		return errorImgNameNullTitle;
	}
	
	//		-------------------Métodos que se usarán para Delete_Car.-------------------

	@Override
	public String deleteCarTitle() {
		return titleDeleteCar;
	}

	@Override
	public String dataDeleteCarTitle() {
		return labelDataTitle;
	}
	
	//		-------------------Métodos que se usarán para Modify_Car.-------------------

	@Override
	public String modifyCarTitle() {
		return titleModifyCar;
	}
	
	//		-------------------Métodos que se usarán para Albaran.-------------------

	@Override
	public String deliveryNoteTitle() {
		return titleDeliveryNote;
	}

	@Override
	public String labelClient() {
		return labelClient;
	}

	@Override
	public String labelCompany() {
		return labelCompany;
	}

	@Override
	public String labelCompanyName() {
		return labelCompanyName;
	}
	
	@Override
	public String labelEmployee() {
		return lableEmployee;
	}

	@Override
	public String labelMail() {
		return labelMail;
	}

	@Override
	public String table() {
		return table;
	}

	@Override
	public String tableOne() {
		return tableOne;
	}
}
