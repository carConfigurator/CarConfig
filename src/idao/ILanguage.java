package idao;

public interface ILanguage {

	// M�todos que se usar�n para el Login.
	String loginTitle();
	String labelUsername();
	String labelPassword();
	String btnLogin();
	String errorLoginUser();
	String errorLoginUserTitle();
	String errorLoginPassword();
	String errorLoginPasswordTitle();
	
	// M�todos que se usar�n para el Data_Clients.
	String dataClientsTitle();
	String labelClientTitle();
	String labelAuthIn();
	String labelClientName();
	String labelClientFirstLastName();
	String labelClientSecondLastName();
	String labelClientAddress();
	String labelClientEmail();
	String labelClientGender();
	String radioGenderMale();
	String radioGenderFemale();
	String radioGenderUnknown();
	String labelClientBirhdate();
	String btnSave();
	String btnNext();
	String errorNullField();
	String errorNullFieldTitle();
	String errorEmail();
	String errorEmailTitle();
	String btnSaveInfo();
	
	// M�todos que se usar�n para el Seleccion_Modelo.
	String seleccionModeloTitle();
	String labelSelectTitle();
	String btnPrevious();
	//boton siguiente en Data_clients
	String menu();
	String menuItemAdd();
	String menuItemDelete();
	String menuItemModify();	

	// M�todos que se usar�n para selection_engine.
	String seleccionEngineTitle();
	String labelEngineTitle();
	
	// M�todos que se usar�n para purchase_accessories.
	String purchaseAccessoriesTitle();
	String labelAccessoriesTitle();
	String labelModelCar();
	String checkBoxElectricElevation();
	String checkBoxBrowser();
	String checkBoxTires();
	String checkBoxHeatedSeats();
	String checkBoxCruisingSpeed();
	String checkBoxAutomaticParking();
	String checkBoxUsbConnectors();
	String checkBoxMetallizedPaint();
	String labelBasePrice();
	String labelIncreasePrice();
	String labelTotalPrice();
	String btnBack();
	String btnEnd();
	
}
