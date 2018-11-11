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
import idao.ILanguage;
import model.Client;
import model.Model;

public class check extends JFrame{

	File temp;
	
	public check(ConfigurationLoader configLoad, ILanguage language, String username) {
		System.out.println("HDP");
		// Comprobará siempre si el archivo existe, en caso de que exista lo eliminará para generarlo desde 0.
		this.temp = new File(configLoad.getTemporalPathFile());		
		if(this.temp.exists()) {
			System.out.println("Lo he encontrado");
			if(this.temp.length() > 0) {
				System.out.println("Tengo información muy valiosa");
				// Crear variables para este JOptionPane de Language
				System.out.println("Yo me cago en tu puta madre");
				int dialogButton = JOptionPane.showConfirmDialog(null, "¿Desea recuperar los datos temporales?", "¿Desea recuperar los datos temporales?", JOptionPane.YES_NO_CANCEL_OPTION);
				if(dialogButton == JOptionPane.YES_OPTION) {
					try {
						FileReader fr = new FileReader(this.temp);
						BufferedReader br = new BufferedReader(fr);
						String line;
						Client client;
						Model model;
						try {
							while((line = br.readLine())!=null) {
								if(line.contains("[Cliente]")) {
									String cliente = line.substring(10);
									client = new Client();
									client.setName(cliente.split(",")[0]);
									client.setFirst_last_name(cliente.split(",")[1]);
									client.setSecond_last_name(cliente.split(",")[2]);
									client.setAddress(cliente.split(",")[3]);
									client.setEmail(cliente.split(",")[4]);
									client.setGender(cliente.split(",")[5]);
									System.out.println("La fecha es nula: " + cliente.split(",")[6].equals("null"));
									if(cliente.split(",")[6].equals("null")) {
										System.out.println("Es null");
										client.setBirthdate(null);
									}else {
										client.setBirthdate(cliente.split(",")[6]);
									}
									new Data_Clients(configLoad, language, username, client, false);
									break;
								}else if(line.contains("[Model]")) {
									String modelo = line.substring(9);
									model = new Model();
									model.setId(Integer.parseInt(modelo.split(",")[0]));
								}
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}else if(dialogButton == JOptionPane.NO_OPTION){

				}else if(dialogButton == JOptionPane.CANCEL_OPTION){
					System.out.println("[INFO] - No se hará nada.");
				}
			}else {
				new Data_Clients(configLoad, language, username);
			}
			new Data_Clients(configLoad, language, username);
		}
	}
	
}
