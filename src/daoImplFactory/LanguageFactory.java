package src.daoImplFactory;

import src.config.ConfigurationLoader;
import src.daoImpl.LanguageDAOCA;
import src.daoImpl.LanguageDAOEN;
import src.daoImpl.LanguageDAOES;
import src.idao.ILanguage;

public class LanguageFactory {
	
	public static ILanguage getLanguage(ConfigurationLoader configLoad) {
		return new LanguageDAOES(configLoad);
	}

}
