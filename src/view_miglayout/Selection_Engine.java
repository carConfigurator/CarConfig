package view_miglayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import config.ConfigurationLoader;
import daoImplFactory.LanguageFactory;
import idao.ILanguage;
import model.Client;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Selection_Engine extends JFrame {

	private ConfigurationLoader configLoad;
	private ILanguage language;
	private String username;
	
	JPanel panel = new JPanel();
	JLabel lblTitulo;
	JButton btn_Anterior, btn_Siguiente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurationLoader configLoad = ConfigurationLoader.getConfigurationLoaderInstance();
					ILanguage language = LanguageFactory.getLanguage(configLoad.getLanguage_default(), configLoad);
					String username = "user1";
					Selection_Engine frame = new Selection_Engine(configLoad, language, username);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public Selection_Engine(ConfigurationLoader configLoad, ILanguage language, String username) {
		this.language = language;
		this.configLoad = configLoad;
		this.username = username;
		
		// Panel
		this.panel = new JPanel();
		this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.panel.setBackground(new Color(255,255,255));
		
		// JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 424);
		setContentPane(panel);
		setIconImage(getIconImage());
		
		// Elementos del JPanel
		this.lblTitulo = new JLabel("Seleccion de caracteristicas del modelo");
		this.lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		this.panel.setLayout(new MigLayout("", "[200px][][200px][4px][200px][50px]", "[23px][40px][31px][100px][][]"));
		this.panel.add(lblTitulo, "cell 1 0 2 1,alignx right,aligny top");
		 
		JList list = new JList();
		DefaultListModel modelo = new DefaultListModel(); // Sirve para introducir elementos de forma indirecta (Ej: Haciendo un bucle para añadir elementos).
		// Ejemplo para añadir contenido dentro del JList.
		for (int i = 1; i < 4; i++) {
			modelo.addElement("texto "+i);
		}
		// PARA AÑADIR CONTENIDO A LA LISTA DEBE SER CON STRINGS.
		list.setModel(modelo);
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list.setBackground(new Color(157, 157, 157));
		list.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.panel.add(list, "cell 0 2 6 1,growx,aligny top");
		
		this.btn_Anterior = new JButton("Anterior");
		this.btn_Anterior.setFont(new Font("Tahoma", 0, 12));
		this.btn_Anterior.setBackground(new Color(215,18,43));
		this.btn_Anterior.setForeground(new Color(255,255,255));
		this.btn_Anterior.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)));
		this.panel.add(btn_Anterior, "cell 1 5,alignx left,aligny top");
		
		this.btn_Siguiente = new JButton("Siguiente");
		this.btn_Siguiente.setFont(new Font("Tahoma", 0, 12));
		this.btn_Siguiente.setBackground(new Color(215,18,43));
		this.btn_Siguiente.setForeground(new Color(255,255,255));
		this.btn_Siguiente.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)));
		this.panel.add(btn_Siguiente, "cell 2 5,alignx right,aligny top");
		
		
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
