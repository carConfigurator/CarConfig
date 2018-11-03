package src.idao;

public interface ILanguage {

	// M�todos que se usar�n para el Login.
	String labelUsername();
	String labelPassword();
	String btnLogin();
	String errorLoginUser();
	String errorLoginUserTitle();
	String errorLoginPassword();
	String errorLoginPasswordTitle();
	
	// M�todos que se usar�n para el Data_Clients.
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
	String labelSelectTitle();
	String btnPrevious();
	//boton siguiente en Data_clients
	String menu();
	String menuItemAdd();
	String menuItemDelete();
	String menuItemModify();
	
}
