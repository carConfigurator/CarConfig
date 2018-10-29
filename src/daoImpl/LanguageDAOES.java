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

	@Override
	public String labelClientSecondLastName() {
		return "Segundo Apellido: *";
	}

	@Override
	public String labelClientAddress() {
		return "Direcci�n: *";
	}

	@Override
	public String labelClientEmail() {
		return "Correo Electr�nico: *";
	}

	@Override
	public String labelClientGender() {
		return "G�nero: ";
	}

	@Override
	public String radioGenderMale() {
		return "Hombre";
	}

	@Override
	public String radioGenderFemale() {
		return "Mujer";
	}

	@Override
	public String radioGenderUnknown() {
		return "Desconocido";
	}

	@Override
	public String labelClientBirhdate() {
		return "Fecha nacimiento: ";
	}

	@Override
	public String btnSave() {
		return "Guardar";
	}

	@Override
	public String btnNext() {
		return "Siguiente";
	}

	@Override
	public String errorNullField() {
		return "Faltan campos por rellenar. Rellene todos los campos obligatorios.";
	}

	@Override
	public String errorNullFieldTitle() {
		return "Informacion Incompleta";
	}

	@Override
	public String errorEmail() {
		return "El correo no es valido.";
	}

	@Override
	public String errorEmailTitle() {
		return "Error de correo";
	}

	@Override
	public String btnSaveInfo() {
		return "�Desea Guardar los Cambios?";
	}
	
}
