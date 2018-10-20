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

}
