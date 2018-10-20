package daoImpl;

import idao.ILanguage;

public class LanguageDAOES implements ILanguage{

	public String labelUsername() {
		return "Nombre de Usuario";
	}

	@Override
	public String labelPassword() {
		return "Contrase�a";
	}

	@Override
	public String btnLogin() {
		return "Iniciar Sesi�n";
	}

	@Override
	public String errorLoginUser() {
		return "El usuario introducido no es correcto o no existe.";
	}

	@Override
	public String errorLoginUserTitle() {
		return "[ERROR] - Nombre de Usuario no encontrado";
	}

	@Override
	public String errorLoginPassword() {
		return "El usuario o contrase�as no son correctos.";
	}

	@Override
	public String errorLoginPasswordTitle() {
		return "[ERROR] - Fallo de Autenticaci�n";
	}

	@Override
	public String labelClientTitle() {
		return "Datos del Cliente";
	}

	@Override
	public String labelAuthIn() {
		return "Usuario: ";
	}

	@Override
	public String labelClientName() {
		return "Nombre: *";
	}

	@Override
	public String labelClientFirstLastName() {
		return "Primer Apellido: *";
	}
	
}
