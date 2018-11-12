package view_miglayout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import config.ConfigurationLoader;
import daoImpl.EngineDAO_XML;
import daoImpl.ModelDAO_XML;
import idao.IEngine;
import config.language.ELanguage;
import config.language.Language;
import idao.IModel;
import model.Client;
import model.Engine;
import model.Model;

public class check extends JFrame{

	File temp;
	
	public check(ConfigurationLoader configLoad, Language language, String username) {
		System.out.println("HDP");
		// Comprobará siempre si el archivo existe, en caso de que exista lo eliminará para generarlo desde 0.
		this.temp = new File(configLoad.getTemporalPathFile());		
		if(this.temp.exists()) {
			if(this.temp.length() > 0) {
				// Crear variables para este JOptionPane de Language
				int dialogButton = JOptionPane.showConfirmDialog(null, "¿Desea recuperar los datos temporales?", "¿Desea recuperar los datos temporales?", JOptionPane.YES_NO_OPTION);
				if(dialogButton == JOptionPane.YES_OPTION) {
					Client client = new Client();
					Model model = new Model();
					Engine engine = new Engine();
					try {
						FileReader fr = new FileReader(this.temp);
						BufferedReader br = new BufferedReader(fr);
						String line;
						try {
							while((line = br.readLine())!=null) {
								// Si en el archivo .txt 
								if(line.contains("[Cliente]")) {
									String cliente = line.substring(10);
									client.setName(cliente.split(",")[0]);
									client.setFirst_last_name(cliente.split(",")[1]);
									client.setSecond_last_name(cliente.split(",")[2]);
									client.setAddress(cliente.split(",")[3]);
									client.setEmail(cliente.split(",")[4]);
									client.setGender(cliente.split(",")[5]);
									if(cliente.split(",")[6].equals("null")) {
										client.setBirthdate(null);
									}else {
										client.setBirthdate(cliente.split(",")[6]);
									}
								}
								
								if(line.contains("[Modelo]")) {
									String modelo = line.substring(9);
									IModel imodel = new ModelDAO_XML();
									model = imodel.getModel(Integer.parseInt(modelo.split(",")[0]));
								}
								
								if(line.contains("[Motor]")) {
									IEngine iengine = new EngineDAO_XML();
									if(model.getId() != 0) {
										iengine.loadEngines(model.getId());
										engine = iengine.getEngine(Integer.parseInt(line.substring(8).split(",")[0]));
									}
								}
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					if(client.getName() != null) {
						if(model.getId() != 0) {
							if(engine.getId() != 0) {
								new Selection_Engine(configLoad, language, username, client, model, engine);
							}else {
								new Selection_Model(configLoad, language, username, client, model);
							}
						}else {
							new Data_Clients(configLoad, language, username, client, false);
						}
					}else {
						new Data_Clients(configLoad, language, username);
					}
					
				}else if(dialogButton == JOptionPane.NO_OPTION){
					new Data_Clients(configLoad, language, username, new Client(), true);
				}
			}else {
				new Data_Clients(configLoad, language, username);
			}
		}
	}
	
}
