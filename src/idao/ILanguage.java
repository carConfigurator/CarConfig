package src.idao;

public interface ILanguage {

	// Métodos que se usarán para el Login.
	String labelUsername();
	String labelPassword();
	String btnLogin();
	String errorLoginUser();
	String errorLoginUserTitle();
	String errorLoginPassword();
	String errorLoginPasswordTitle();
	
	// Métodos que se usarán para el Data_Clients.
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
	String labelSelectTitle();
	String btnPrevious();
	//boton siguiente en Data_clients
	String menu();
	String menuItemAdd();
	String menuItemDelete();
	String menuItemModify();
	
}
