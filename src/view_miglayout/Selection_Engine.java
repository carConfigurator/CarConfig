package view_miglayout;

import java.awt.Color;

import javax.swing.JPanel;

import config.ConfigurationLoader;
import daoImpl.EngineDAO_XML;
import idao.IEngine;
import idao.ILanguage;
import idao.IModel;
import model.Client;
<<<<<<< HEAD
import model.Engine;
import model.Engine_woDAO;
//import model.Model_woDAO;
import idao.IModel;
=======
import model.Model;
>>>>>>> 4e7e4cd9c5af02a6b346e6bed234749a5e0cd0d3
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;

public class Selection_Engine extends JFrame {

	private ConfigurationLoader configLoad;
	private ILanguage language;
	private String username;
	private Client client;
<<<<<<< HEAD
	private IModel model;
=======
	private Model model;
>>>>>>> 4e7e4cd9c5af02a6b346e6bed234749a5e0cd0d3
	private IEngine engine;
	private File temp;
	private JList list;
	
	private JPanel panel;
	private JLabel lblTitulo, lblUsername;
	private JButton btn_Anterior, btn_Siguiente;	
	
	// Constructores de la vista:
<<<<<<< HEAD
	public Selection_Engine(ConfigurationLoader configLoad, ILanguage language, String username, Client client, IModel model, Engine_woDAO engine) {
=======
	public Selection_Engine(ConfigurationLoader configLoad, ILanguage language, String username, Client client, Model model, IEngine engine) {
>>>>>>> 4e7e4cd9c5af02a6b346e6bed234749a5e0cd0d3
		this.language = language;
		this.configLoad = configLoad;
		this.username = username;
		this.client = client;
		this.model = model;
<<<<<<< HEAD
		this.engine = new EngineDAO_XML();
=======
		this.engine = engine;
>>>>>>> 4e7e4cd9c5af02a6b346e6bed234749a5e0cd0d3
		this.temp = new File(this.configLoad.getTemporalPathFile());
		
		FileWriter fw;
		try {
			fw = new FileWriter(this.temp);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("[Empleado] ");
			bw.write(username);
			bw.newLine();
			bw.write("------");
			bw.newLine();
			bw.write("[Cliente] ");
			bw.write(this.client.toString());
			bw.newLine();
			bw.write("------");
			bw.newLine();
			bw.write("[Modelo] ");
			bw.write(this.model.toString());
			bw.write("------");
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		onCreate();
	}
	
<<<<<<< HEAD
	public Selection_Engine(ConfigurationLoader configLoad, ILanguage language, String username, Client client, IModel model) {
=======
	public Selection_Engine(ConfigurationLoader configLoad, ILanguage language, String username, Client client, Model model) {
>>>>>>> 4e7e4cd9c5af02a6b346e6bed234749a5e0cd0d3
		this.language = language;
		this.configLoad = configLoad;
		this.username = username;
		this.client = client;
		this.model = model;
<<<<<<< HEAD
		this.engine = new EngineDAO_XML();
=======
		this.engine = new EngineDAO_XML(this.configLoad);
>>>>>>> 4e7e4cd9c5af02a6b346e6bed234749a5e0cd0d3
		
		onCreate();
	}
	
	public void onCreate() {
		
		this.temp = new File(this.configLoad.getTemporalPathFile());
		
		// Configuración del Panel
		this.panel = new JPanel();
		this.panel.setLayout(new MigLayout("insets 20"));
		this.panel.setBackground(new Color(255,255,255));
		
		// Elementos del JPanel
		this.lblTitulo = new JLabel(language.labelEngineTitle());
		this.lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		this.lblUsername = new JLabel(this.language.labelAuthIn() + this.username);
		this.lblUsername.setFont(new Font("Tahoma", 0, 11));
		 
		this.list = new JList();
		DefaultListModel modelo = new DefaultListModel(); // Sirve para introducir elementos de forma indirecta (Ej: Haciendo un bucle para añadir elementos).
		// Llamo al metodo loadEngines() y le paso el id que el usuario ha seleccionado.
<<<<<<< HEAD
		this.engine.loadEngines(1);
		ArrayList<Engine> engines = this.engine.getEngines();
=======
		this.engine.loadEngines(this.model.getId());
		// Obtengo todos los submodelos disponibles del modelo seleccionado.

//		this.getEngines.add(this.name + ", " + this.description + ", " + this.price + "€");
		
		ArrayList<String> engines = this.engine.getEngines();
		// Y los printo en la vista.
>>>>>>> 4e7e4cd9c5af02a6b346e6bed234749a5e0cd0d3
		
		for (Engine engine : engines) {
			modelo.addElement(engine.toString());
		}
		
		// PARA AÑADIR CONTENIDO A LA LISTA DEBE SER CON STRINGS.
		list.setModel(modelo);
		list.setSelectedIndex(0);
		list.setFont(new Font("Tahoma", Font.PLAIN, 12));
		list.setBackground(new Color(157, 157, 157));
		list.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
		
		this.btn_Anterior = new JButton("Anterior");
		this.btn_Anterior.setFont(new Font("Tahoma", 0, 12));
		this.btn_Anterior.setBackground(new Color(215,18,43));
		this.btn_Anterior.setForeground(new Color(255,255,255));
		this.btn_Anterior.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)));
		
		this.btn_Siguiente = new JButton("Siguiente");
		this.btn_Siguiente.setFont(new Font("Tahoma", 0, 12));
		this.btn_Siguiente.setBackground(new Color(215,18,43));
		this.btn_Siguiente.setForeground(new Color(255,255,255));
		this.btn_Siguiente.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)));
		
		
		this.btn_Anterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Selection_Model(configLoad, language, username, client, model);
			}
		});
		
		this.btn_Siguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nextActionPerformed();
			}
		});
		
		// Add Components to Panel
		this.panel.add(this.lblTitulo, "align left");
		this.panel.add(this.lblUsername, "skip, align right, wrap");
		this.panel.add(list, "wrap, span 3, growx, growy, pushx");
		this.panel.add(this.btn_Anterior, "span 2, align left");
		this.panel.add(this.btn_Siguiente, "align right");
		
		addFrame(this.configLoad, panel, language, language.seleccionEngineTitle());
	}
	
	
	protected void nextActionPerformed() {
		setVisible(false);
		
		try {
			Engine engine = this.engine.getEngine(this.list.getSelectedIndex() + 1);
			FileWriter fw = new FileWriter(this.temp, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write("[Motor] ");
			bw.write(engine.toString());
			bw.newLine();
			bw.write("------");
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Purchase_Accessories(this.configLoad, this.language, this.username, this.client, this.model, engine);
	}
}
