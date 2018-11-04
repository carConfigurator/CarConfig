package daoImplFactory;

import config.ConfigurationLoader;
import daoImpl.LanguageDAOCA;
import daoImpl.LanguageDAOEN;
import daoImpl.LanguageDAOES;
import idao.ILanguage;

public class LanguageFactory {
	
	public static ILanguage getLanguage(ConfigurationLoader configLoad) {
		return new LanguageDAOES(configLoad);
	}

}
