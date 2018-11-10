package idao;

import java.util.ArrayList;

import config.ConfigurationLoader;
import model.Model;

public interface IModel {
	// Atributos de la Interfaz:
	public ConfigurationLoader configLoad = ConfigurationLoader.getConfigurationLoaderInstance();
	public Model model = new Model();
	public ArrayList<Model> models = new ArrayList<Model>();
	
	// Métodos de la Interfaz:
	public void loadModels();
	public ArrayList<Model> getModels();
	public Model getModel(int id);
	
}
