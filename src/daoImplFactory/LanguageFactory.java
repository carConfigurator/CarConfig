package daoImplFactory;

import daoImpl.LanguageDAOCA;
import daoImpl.LanguageDAOEN;
import daoImpl.LanguageDAOES;
import idao.ILanguage;

public class LanguageFactory {
	
	public static ILanguage getLanguage(String language_default) {
		return new LanguageDAOES();
	}

}
