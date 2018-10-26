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
	}

}
