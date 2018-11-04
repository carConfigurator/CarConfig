package idao;

public interface ILanguage {

	// Métodos que se usarán para el Login.
	String loginTitle();
	String labelUsername();
	String labelPassword();
	String btnLogin();
	String errorLoginUser();
	String errorLoginUserTitle();
	String errorLoginPassword();
	String errorLoginPasswordTitle();
	
	// Métodos que se usarán para el Data_Clients.
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
	
	// Métodos que se usarán para el Seleccion_Modelo.
	String seleccionModeloTitle();
	String labelSelectTitle();
	String btnPrevious();
	//boton siguiente en Data_clients
	String menu();
	String menuItemAdd();
	String menuItemDelete();
	String menuItemModify();	

	// Métodos que se usarán para selection_engine.
	String seleccionEngineTitle();
	String labelEngineTitle();
	
	// Métodos que se usarán para purchase_accessories.
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
