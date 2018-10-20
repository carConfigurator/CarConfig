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
		return "Iniciar Sessi�";
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
		return "[ERROR] - Fallada d'Autenticaci�";
	}

}
