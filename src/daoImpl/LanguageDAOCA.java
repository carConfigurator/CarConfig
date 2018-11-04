package daoImpl;

import idao.ILanguage;

public class LanguageDAOCA implements ILanguage{

	@Override
	public String labelUsername() {
		return "Nom d'Usuari";
	}

	@Override
	public String labelPassword() {
		return "Contrasenya";
	}

	@Override
	public String btnLogin() {
		return "Iniciar Sessió";
	}

	@Override
	public String errorLoginUser() {
		return "El Nom d'Usuari no existeix o no es correcte.";
	}

	@Override
	public String errorLoginUserTitle() {
		return "[ERROR] - Nom d'Usuari inexistent";
	}

	@Override
	public String errorLoginPassword() {
		return "El Nom d'Usuario o Contrasenya son incorrectes.";
	}

	@Override
	public String errorLoginPasswordTitle() {
		return "[ERROR] - Fallada d'Autenticació";
	}

	@Override
	public String labelClientTitle() {
		return "Dades del Client";
	}

	@Override
	public String labelAuthIn() {
		return "Usuari: ";
	}

	@Override
	public String labelClientName() {
		return "Nom: *";
	}

	@Override
	public String labelClientFirstLastName() {
		return "Primer Cognom: *";
	}

	@Override
	public String labelClientSecondLastName() {
		return "Segon Cognom: *";
	}

	@Override
	public String labelClientAddress() {
		return "Adreça: *";
	}

	@Override
	public String labelClientEmail() {
		return "Adrecça Electronica: *";
	}

	@Override
	public String labelClientGender() {
		return "Genere: ";
	}

	@Override
	public String radioGenderMale() {
		return "Home";
	}

	@Override
	public String radioGenderFemale() {
		return "Dona";
	}

	@Override
	public String radioGenderUnknown() {
		return "Desconegut";
	}

	@Override
	public String labelClientBirhdate() {
		return "Data Naixement: ";
	}

	@Override
	public String btnSave() {
		return "Guardar";
	}

	@Override
	public String btnNext() {
		return "Següent";
	}

	@Override
	public String errorNullField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String errorNullFieldTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String errorEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String errorEmailTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String btnSaveInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String labelSelectTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String btnPrevious() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String menu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String menuItemAdd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String menuItemDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String menuItemModify() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loginTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dataClientsTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String seleccionModeloTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String seleccionEngineTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String labelEngineTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String labelAccessoriesTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String labelModelCar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkBoxElectricElevation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkBoxBrowser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkBoxTires() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkBoxHeatedSeats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkBoxCruisingSpeed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkBoxAutomaticParking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkBoxUsbConnectors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkBoxMetallizedPaint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String labelBasePrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String labelIncreasePrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String labelTotalPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String btnBack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String btnEnd() {
		// TODO Auto-generated method stub
		return null;
	}

}
