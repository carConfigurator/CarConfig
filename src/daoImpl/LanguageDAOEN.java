package daoImpl;

import idao.ILanguage;

public class LanguageDAOEN implements ILanguage{

	@Override
	public String labelUsername() {
		return "Username";
	}

	@Override
	public String labelPassword() {
		return "Password";
	}
	
	@Override
	public String btnLogin() {
		return "Log In";
	}

	@Override
	public String errorLoginUser() {
		return "Username introduce has not identified";
	}

	@Override
	public String errorLoginUserTitle() {
		return "[ERROR] - Username non-existent";
	}

	@Override
	public String errorLoginPassword() {
		return "Username or password introduce has not correct";
	}

	@Override
	public String errorLoginPasswordTitle() {
		return "[ERROR] - Failed Login";
	}

}
