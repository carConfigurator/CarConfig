package config.testing;

import config.ConfigurationLoader;
import model.Accessory;
import model.Engine;
import model.Model;

public class ConfigurationCarTEST {

	public static void main(String[] args) {
		ConfigurationLoader configLoad = ConfigurationLoader.getConfigurationLoaderInstance();
		Engine engine = new Engine(configLoad);
		Model model = new Model(configLoad);
		Accessory accessory = new Accessory(configLoad);
		
		// Falta a�adir al constructor de cada Clase la llamada a un m�todo, que haga lo mismo que el toString(), para printar toda la informaci�n de estos.
	}

}
