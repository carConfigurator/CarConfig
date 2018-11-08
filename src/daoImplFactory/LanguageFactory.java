package daoImplFactory;

import config.ConfigurationLoader;
import daoImpl.LanguageDAO;
import idao.ILanguage;

public class LanguageFactory {
	
	public static ILanguage getLanguage(ConfigurationLoader configLoad) {
		return new LanguageDAO(configLoad);
	}

}
