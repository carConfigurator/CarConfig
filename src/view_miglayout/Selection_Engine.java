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
	
	JPanel panel;
	JLabel lblTitulo;
	JButton btn_Anterior, btn_Siguiente;	
	
	/**
	 * Create the frame.
	 */
	public Selection_Engine(ConfigurationLoader configLoad, ILanguage language, String username) {
		this.language = language;
		this.configLoad = configLoad;
		this.username = username;
		
		// Panel
		this.panel = new JPanel();
		this.panel.setLayout(new MigLayout("insets 20"));
		this.panel.setBackground(new Color(255,255,255));
		
		// Elementos del JPanel
		this.lblTitulo = new JLabel(language.labelEngineTitle());
		this.lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		 
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
		
		// Add Components to Panel
		this.panel.add(this.lblTitulo, "wrap, align right");
		this.panel.add(list, "wrap, span 3, growx, growy, pushx");
		this.panel.add(this.btn_Anterior, "span 2, align left");
		this.panel.add(this.btn_Siguiente, "align right");
		
		JFrame();
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
