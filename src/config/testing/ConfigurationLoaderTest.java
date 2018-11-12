package config.testing;

import java.util.Arrays;

import config.ConfigurationLoader;

public class ConfigurationLoaderTest {

	public static void main(String[] args) {
		// Pruebo de instanciar dos veces el Singleton, debe de indicar en la segunda instancia que ya existe una instancia, valga la rebundancia.
		ConfigurationLoader configLoad = ConfigurationLoader.getConfigurationLoaderInstance();
		ConfigurationLoader configLoad2 = ConfigurationLoader.getConfigurationLoaderInstance();
		// El método toString() solo se pondrá para prueba, en cuando el primer Sprint se demuestre que funciona, este será eliminado.
		System.out.println(configLoad.toString());
		
		
		System.out.println("");
		System.out.println("Ruta config coche: "+configLoad.getCar_configuration_path());
		System.out.println("Nombre fichero coche: "+configLoad.getCar_configuration_file_name());
		System.out.println("Lista empleados: "+Arrays.toString(configLoad.getEmployee_list()));
		System.out.println("Contraseña empleado: "+Arrays.toString(configLoad.getEmployee_password()));
		System.out.println("Ruta archivo especificaciones: "+configLoad.getSpecifications_file_path());
		System.out.println("");
		System.out.println("Version: "+configLoad.getVersion());
		System.out.println("Version de empleado: "+configLoad.getDiscount());
	}
}
