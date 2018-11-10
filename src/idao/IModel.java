package idao;

import java.util.ArrayList;

import javax.swing.JTextField;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import config.ConfigurationLoader;
import model.Client;
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

	public void addCar(JTextField tfId, JTextField tfName, JTextField tfDescription, JTextField tfImg_Name, JTextField tfPrice);
	public void deleteCar(int idSelected);
	public void modifyCar(JTextField tfId, JTextField tfName, JTextField tfDescription, JTextField tfImg_Name, JTextField tfPrice, int idSelected);
}
