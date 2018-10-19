package config.testing;

import config.ConfigurationLoader;

public class ConfigurationLoaderTest {

	public static void main(String[] args) {
		// Pruebo de instanciar dos veces el Singleton, debe de indicar en la segunda instancia que ya existe una instancia, valga la rebundancia.
		ConfigurationLoader configLoad = ConfigurationLoader.getConfigurationLoaderInstance();
		ConfigurationLoader configLoad2 = ConfigurationLoader.getConfigurationLoaderInstance();
		// El m�todo toString() solo se pondr� para prueba, en cuando el primer Sprint se demuestre que funciona, este ser� eliminado.
		System.out.println(configLoad.toString());
		
		System.out.println(configLoad.getEmployee_list());
	}
	
}
