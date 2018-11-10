package view_miglayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import config.ConfigurationLoader;
import daoImplFactory.LanguageFactory;
import idao.ILanguage;
import model.Client;
import model.Engine_woDAO;
import model.Model_woDAO;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Selection_Engine extends JFrame {

	private ConfigurationLoader configLoad;
	private ILanguage language;
	private String username;
	private Client client;
	private Model_woDAO model;
	private Engine_woDAO engine;
	private File temp;
	private JList list;
	
	JPanel panel;
	JLabel lblTitulo, lblUsername;
	JButton btn_Anterior, btn_Siguiente;	
	
	// Constructores de la vista:
	public Selection_Engine(ConfigurationLoader configLoad, ILanguage language, String username, Client client, Model_woDAO model, Engine_woDAO engine) {
		this.language = language;
		this.configLoad = configLoad;
		this.username = username;
		this.client = client;
		this.model = model;
		this.engine = new Engine_woDAO(this.configLoad);
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
	
	public Selection_Engine(ConfigurationLoader configLoad, ILanguage language, String username, Client client, Model_woDAO model) {
		this.language = language;
		this.configLoad = configLoad;
		this.username = username;
		this.client = client;
		this.model = model;
		this.engine = new Engine_woDAO(this.configLoad);
		
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
		this.engine.loadEngines(this.model.getIdSelected());
		// Obtengo todos los submodelos disponibles del modelo seleccionado.
		ArrayList<String> engines = this.engine.getEngines();
		// Y los printo en la vista.
		
		for (String string : engines) {
			modelo.addElement(string);
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
		
		JFrame();
	}
	
	
	protected void nextActionPerformed() {
		setVisible(false);
		
		try {
			FileWriter fw = new FileWriter(this.temp, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write("[Motor] ");
			bw.write(this.engine.getEngineSelected(this.list.getSelectedIndex() + 1));
			bw.newLine();
			bw.write("------");
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Purchase_Accessories(this.configLoad, this.language, this.username, this.client, this.model, this.engine);
	}

	/*
	 * Método para configurar la ventana actual.
	 */
	private void JFrame() {
		add(this.panel);
		setTitle(language.seleccionEngineTitle());
		setIconImage(getIconImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/*
	 * Método que obtiene la imagen para el JFrame.
	 * @return La imagen que hay en carpeta.
	 * @see java.awt.Frame#getIconImage()
	 */
	public Image getIconImage() {
		File image = new File("src/config/favicon.png");
        Image retValue = Toolkit.getDefaultToolkit().getImage(image.getAbsolutePath());
        return retValue;
    }

}
