package idao;

import java.util.ArrayList;

import config.ConfigurationLoader;
import model.Engine;

public interface IEngine {
	// Atributos de la Interfaz:
	public ConfigurationLoader configLoad = ConfigurationLoader.getConfigurationLoaderInstance();
	public Engine engine = new Engine();
	public ArrayList<Engine> engines = new ArrayList<Engine>();
	
	// Métodos de la Interfaz:
	public void loadEngines(int id);
	public ArrayList<Engine> getEngines();
	public Engine getEngine(int id);
	
}
