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
	
	// M�todos que se usar�n para el Login.
	loginTitle,
	labelUsername,
	labelPassword,
	errorLoginUser,
	errorLoginUserTitle,
	errorLoginPassword,
	errorLoginPasswordTitle,

	// M�todos que se usar�n para el Check.
	jopRecover,
	jopRecoverTitle,

	// M�todos que se usar�n para el Data_Clients.
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
	
	// M�todos que se usar�n para el Seleccion_Modelo.
	seleccionModeloTitle,
	labelSelectTitle,
	menu,
	menuItemAdd,
	menuItemDelete,
	menuItemModify,

	// M�todos que se usar�n para selection_engine.
	seleccionEngineTitle,
	labelEngineTitle,
	
	// M�todos que se usar�n para purchase_accessories.
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

	// M�todos que se usar�n para add_car.
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
	
	// M�todos que se usar�n para delete_car.
	deleteCarTitle,
	dataDeleteCarTitle,

	// M�todos que se usar�n para modify_car.
	modifyCarTitle,
	//los otros metodos son los mismos que los de add
	
	// M�todos que se usar�n para albaran.
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
