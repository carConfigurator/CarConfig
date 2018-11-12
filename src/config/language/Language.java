package config.language;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import config.ConfigurationLoader;

public class Language {
	
	private File languageFile;
	
	private FileReader fr;
	private BufferedReader br;

	private ELanguage eLan;
	private HashMap<ELanguage, String> hLanguage = new HashMap<ELanguage, String>();
	
	public Language(String pathLanguage) {
		this.languageFile = new File(pathLanguage);
		
		String line="";
		
		try {
			fr = new FileReader(this.languageFile);
			br = new BufferedReader(fr);
			
			try {
				//leemos la info y la guardamos en variables
				while((line = br.readLine()) != null) {
					for (ELanguage e : eLan.values()) {
						hLanguage.put(e, line.split("\"")[1]);
					}
				}
			}catch(IOException e) {
				System.out.println("[ERROR] - Error al leer el lenguaje");
			}
		}catch(FileNotFoundException ex) {
			System.out.println("[ERROR] - Error al buscar el fichero de lenguaje");
		}
	}
	
	public String getText(Enum enumText) {
		return hLanguage.get(enumText);
	}
}
