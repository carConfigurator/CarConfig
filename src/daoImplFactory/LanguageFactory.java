package daoImplFactory;

import java.io.File;
import config.ConfigurationLoader;

public class LanguageFactory {
	
	public static /*File*/ String getLanguage(ConfigurationLoader configLoad) {
		String idioma = configLoad.getLanguage(); // Recoger la clave del archivo XML.
		String[] idiomas = idioma.split(",") ; // Crear un array de Strings para añadir la clave del XML.
		String path = configLoad.getLanguage_files_path(); // Recoger la ruta donde estan los archivos. 
		String lengDef = configLoad.getLanguage_default(); // Recoger el idioma predeterminado.
		String postfix = configLoad.getPostfix_language_file_name(); // Recoger parte del nombre de los archivos (_cv.lenguage).
		
		// Recorrer el array donde estan los idiomas por posiciones, se añaden a una variable junto a la otra parte del nombre del archivo y se añaden a otro array.
		for (int i = 0; i < idiomas.length; i++) {
			String lenguage = idiomas[i];
			String conjunto = lenguage+postfix;
			String[] conjuntos = new String[3];
			conjuntos[i] = conjunto;
			
			// Instanciar un archivo para saber si existe o no con la ruta y el nombre de los archivos.
			File archivo = new File(path+conjunto);
			if(archivo.exists()) {
				for (int j = 0; j < conjuntos.length; j++) {
					return path+conjunto;
				}
			}else {
				System.out.println("[ERROR] - El archivo " + conjuntos[i] + " no existe.");
			}
		}
		return path+lengDef+postfix;
	}

}
