package view_miglayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import config.ConfigurationLoader;
import idao.ILanguage;
import idao.IModel;
import model.Client;

public class Delete_Car{
	
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	private IModel model;
	
	private JPanel panel = new JPanel();

	public Delete_Car(ConfigurationLoader configLoad, ILanguage language, String username, Client client, IModel model, int idSelected) {
		this.configLoad = configLoad;
		this.language = language;
		this.username = username;
		this.client = client;
		this.model = model;
		
		//dialogo para mostrar el coche que vamos a eliminar
		int optionPane=JOptionPane.showConfirmDialog(panel, language.dataDeleteCarTitle()+"\n"
						+language.labelId()+model.getModel(idSelected).getId()+"\n"
						+language.labelName()+model.getModel(idSelected).getName()+"\n"
						+language.labelDescription()+model.getModel(idSelected).getDescription()+"\n"
						+language.labelImg_Name()+model.getModel(idSelected).getImage_name()+"\n"
						+language.labelPrice()+model.getModel(idSelected).getPrice()+"\n"
					,language.deleteCarTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (optionPane==JOptionPane.YES_OPTION) {
			model.deleteCar(idSelected);
		}
		new Selection_Model(this.configLoad, this.language, this.username, this.client);
	}
}
