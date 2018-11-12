package config.language;

public enum ELanguage {

	// Default Title
	titleDefault,
	
	//BOTONES
	btnLogin,
	btnSave,
	btnNext,
	btnSaveInfo,
	btnPrevious,
	btnBack,
	btnEnd,
	btnStart,
	
	// Métodos que se usarán para el Login.
	loginTitle,
	labelUsername,
	labelPassword,
	errorLoginUser,
	errorLoginUserTitle,
	errorLoginPassword,
	errorLoginPasswordTitle,

	// Métodos que se usarán para el Check.
	jopRecover,
	jopRecoverTitle,

	// Métodos que se usarán para el Data_Clients.
	dataClientsTitle,
	labelClientTitle,
	labelAuthIn,
	labelClientName,
	labelClientFirstLastName,
	labelClientSecondLastName,
	labelClientAddress,
	labelClientEmail,
	labelClientGender,
	radioGenderMale,
	radioGenderFemale,
	radioGenderUnknown,
	labelClientBirhdate,
	errorNullField,
	errorNullFieldTitle,
	errorEmail,
	errorEmailTitle,
	
	// Métodos que se usarán para el Seleccion_Modelo.
	seleccionModeloTitle,
	labelSelectTitle,
	menu,
	menuItemAdd,
	menuItemDelete,
	menuItemModify,

	// Métodos que se usarán para selection_engine.
	seleccionEngineTitle,
	labelEngineTitle,
	
	// Métodos que se usarán para purchase_accessories.
	purchaseAccessoriesTitle,
	labelModelCar,
	checkBoxElectricElevation,
	checkBoxBrowser,
	checkBoxTires,
	checkBoxHeatedSeats,
	checkBoxCruisingSpeed,
	checkBoxAutomaticParking,
	checkBoxUsbConnectors,
	checkBoxMetallizedPaint,
	labelBasePrice,
	labelIncreasePrice,
	labelTotalPrice,

	// Métodos que se usarán para add_car.
	addCarTitle,
	labelId,
	labelName,
	labelDescription,
	labelImg_Name,
	labelPrice,
	errorParseDouble,
	errorParseDoubleTitle,
	errorPriceNull,
	errorPriceNullTitle,
	errorImgName,
	errorImgNameTitle,
	errorImgNameNull,
	errorImgNameNullTitle,
	
	// Métodos que se usarán para delete_car.
	deleteCarTitle,
	dataDeleteCarTitle,

	// Métodos que se usarán para modify_car.
	modifyCarTitle,
	//los otros metodos son los mismos que los de add
	
	// Métodos que se usarán para albaran.
	deliveryNoteTitle,
	labelClient,
	labelCompany,
	//name in data_clients
	labelCompanyName,
	//first and second name in data_clients
	labelEmployee,
	//label adress in data_clients
	labelMail,
	table,
	tableOne;
}
