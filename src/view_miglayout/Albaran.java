package view_miglayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import config.ConfigurationLoader;
import idao.ILanguage;
import model.Client;

import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;

public class Albaran extends JFrame {

	// Atributos globales.
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	private File temp;
	
	// Atributos de la clase.
	private JPanel contentPane;
	private JTable table, table_1;
	private JLabel lblAlbaran, lblCliente, lblEmpresa, lblNombreempresa, lblEmpleado, lblNombreempleado,
	 lblNombre, lblPrimerApellido, lblSegundoApellido, lblDireccion, lblCorreo, lblNombrecliente, lblPriapellido, 
	 lblSegapellido, lblDireccioncliente, lblCorreocliente;
	private JScrollPane sp, sp2;

	/**
	 * Create the frame.
	 */
	public Albaran(ConfigurationLoader configLoad, ILanguage language, String username, Client client) {
		this.configLoad = configLoad;
		this.language = language;
		this.username = username;
		this.client = client;
		this.contentPane = new JPanel();
		this.contentPane.setLayout(new MigLayout("insets 30"));
		this.contentPane.setBackground(new Color(255, 255, 255));
		this.temp = new File(this.configLoad.getTemporalPathFile());
		
		JTextArea ta = new JTextArea();
		ta.setEditable(false);
		ta.setOpaque(false);
		FileReader fr;
		
		try {
			fr = new FileReader(this.temp);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			
			while((linea = br.readLine()) != null) {
				ta.setText(ta.getText() + linea + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.contentPane.add(ta, "wrap, pushx, growx, pushy, growy");
		JFrame();
	}
	
	/*
	 * Método para configurar la ventana actual.
	 */
	private void JFrame() {
		add(this.contentPane);
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
