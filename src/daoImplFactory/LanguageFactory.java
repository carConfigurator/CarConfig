package daoImplFactory;

import daoImpl.LanguageDAOCA;
import daoImpl.LanguageDAOEN;
import daoImpl.LanguageDAOES;
import idao.ILanguage;

public class LanguageFactory {
	
	public static ILanguage getLanguage(String language_default) {
		if(language_default.equals("es")) {
			return new LanguageDAOES();
		}else if(language_default.equals("en")) {
			return new LanguageDAOEN();
		}else if(language_default.equals("ca")){
			return new LanguageDAOCA();
		}else {
			System.out.println("[ERROR] - No se ha detectado el idioma.");
			return null;
		}
	}

}
