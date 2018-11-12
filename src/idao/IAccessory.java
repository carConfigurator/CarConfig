package idao;

import java.util.ArrayList;

import config.ConfigurationLoader;
import model.Accessory;

public interface IAccessory {
	// Atributos de la Interfaz:
	public ConfigurationLoader configLoad = ConfigurationLoader.getConfigurationLoaderInstance();
	public Accessory accesory = new Accessory();
	public ArrayList<Accessory> accesories = new ArrayList<Accessory>();
		
	// Métodos de la Interfaz:
	public void loadAccesories(int model);
	public ArrayList<Accessory> getAccesories();
	public Accessory getAccessory(int id);
	public boolean checkAccessory(int accessoryId);
	public ArrayList<String> getModelsAvailables(int id);
}
