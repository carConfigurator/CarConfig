package config.testing;

import config.ConfigurationLoader;

public class ConfigurationLoaderTest {

	public static void main(String[] args) {
		// Pruebo de instanciar dos veces el Singleton, debe de indicar en la segunda instancia que ya existe una instancia, valga la rebundancia.
		ConfigurationLoader configLoad = ConfigurationLoader.getConfigurationLoaderInstance();
		ConfigurationLoader configLoad2 = ConfigurationLoader.getConfigurationLoaderInstance();
	}
	
}
