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
import model.Accessory;
import model.Client;
import model.Engine;
import model.Model;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

public class Purchase_Accessories extends JFrame {

	// Atributos de la Clase:
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private Model model;
	private Engine engine;
	private Accessory accessory;
	private JLabel username;
	
	JPanel panel;
	JLabel lblTitulo, lblModeloCoche, lblPrecioBasee, lblAumento, lblTotalPrecio;
	JTextField tfAumento, tfTotalPrecio, tfPrecioBase;
	JCheckBox cbElevadurasElectricas, cbNavegador, cbLlantasAl, cbAsientosCal, cbVelCrucero, cbAparcamietnoAuto, cbConectorUSB, cbPinturaMetal;
	JButton btnAtras, btnFinalizar;
	
	/**
	 * Create the frame.
	 */
	public Purchase_Accessories(ConfigurationLoader configLoad, ILanguage language, String username, Client client, Model model, Engine engine) {
		this.language = language;
		this.configLoad = configLoad;
		this.client = client;
		this.model = model;
		this.engine = engine;
		this.accessory = new Accessory(this.configLoad);
		
		this.username = new JLabel(this.language.labelAuthIn() + username);
		this.username.setFont(new Font("Tahoma", 0, 11));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 537);
		this.panel = new JPanel();
		this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.panel.setBackground(new Color(255,255,255));
		this.panel.setLayout(new MigLayout("insets 35"));
		
		this.lblTitulo = new JLabel(language.purchaseAccessoriesTitle());
		this.lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblModeloCoche = new JLabel(language.labelModelCar());
		this.lblModeloCoche.setFont(new Font("Tahoma", 2, 12));
		
		this.cbElevadurasElectricas = new JCheckBox(language.checkBoxElectricElevation());
		this.cbElevadurasElectricas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbElevadurasElectricas.setBackground(new Color(255,255,255));
		this.cbElevadurasElectricas.setFocusable(false);
		// Compruebo que este modelo disponga de Elevaduras Electricas
		if(!this.accessory.checkElectricElevation(this.model.getIdSelected())) {
			this.cbElevadurasElectricas.setEnabled(false);
		}
		this.cbElevadurasElectricas.setToolTipText("Cargando Modelos disponibles...");
		
		this.cbNavegador = new JCheckBox(language.checkBoxBrowser());
		this.cbNavegador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbNavegador.setBackground(new Color(255,255,255));
		this.cbNavegador.setFocusable(false);
		// Compruebo que este modelo disponga de Navegador
		if(!this.accessory.checkNavegation(this.model.getIdSelected())) {
			this.cbNavegador.setEnabled(false);
		}
		
		this.cbLlantasAl = new JCheckBox(language.checkBoxTires());
		this.cbLlantasAl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbLlantasAl.setBackground(new Color(255,255,255));
		this.cbLlantasAl.setFocusable(false);
		
		this.cbAsientosCal = new JCheckBox(language.checkBoxHeatedSeats());
		this.cbAsientosCal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbAsientosCal.setBackground(new Color(255,255,255));
		this.cbAsientosCal.setFocusable(false);
		
		this.cbVelCrucero = new JCheckBox(language.checkBoxCruisingSpeed());
		this.cbVelCrucero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbVelCrucero.setBackground(new Color(255,255,255));
		this.cbVelCrucero.setFocusable(false);
		
		this.cbAparcamietnoAuto = new JCheckBox(language.checkBoxAutomaticParking());
		this.cbAparcamietnoAuto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbAparcamietnoAuto.setBackground(new Color(255,255,255));
		this.cbAparcamietnoAuto.setFocusable(false);
		
		this.cbConectorUSB = new JCheckBox(language.checkBoxUsbConnectors());
		this.cbConectorUSB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbConectorUSB.setBackground(new Color(255,255,255));
		this.cbConectorUSB.setFocusable(false);
		
		this.cbPinturaMetal = new JCheckBox(language.checkBoxMetallizedPaint());
		this.cbPinturaMetal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbPinturaMetal.setBackground(new Color(255,255,255));
		this.cbPinturaMetal.setFocusable(false);
		
		this.lblPrecioBasee = new JLabel(language.labelBasePrice());
		this.lblPrecioBasee.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		this.tfPrecioBase = new JTextField();
		this.tfPrecioBase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.tfPrecioBase.setText("0");
		this.tfPrecioBase.setOpaque(false);
		this.tfPrecioBase.setEditable(false);
		
		this.lblAumento = new JLabel(language.labelIncreasePrice());
		this.lblAumento.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		this.tfAumento = new JTextField();
		this.tfAumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.tfAumento.setText("0");
		this.tfAumento.setOpaque(false);
		this.tfAumento.setEditable(false);
		
		this.lblTotalPrecio = new JLabel(language.labelTotalPrice());
		this.lblTotalPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		// Esta parte del codigo sirve para sumar los dos campos de precios y mostrar el total.
		// Solo se puede mostrar en forma de String por lo que se deben pasar los valores de formato.
		String pb = tfPrecioBase.getText();
		int numero1 = Integer.parseInt(pb);
		String ap = tfAumento.getText();
		int numero2 = Integer.parseInt(ap);
		int resultado = numero1 + numero2;
		String resultSt = Integer.toString(resultado);
		
		this.tfTotalPrecio = new JTextField();
		this.tfTotalPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.tfTotalPrecio.setText(resultSt); // Resultado do los dos campos.
		this.tfTotalPrecio.setOpaque(false);
		this.tfTotalPrecio.setEditable(false);
		
		this.btnAtras = new JButton(language.btnBack());
		this.btnAtras.setBackground(new Color(215,18,43));
		this.btnAtras.setForeground(new Color(255,255,255));
		this.btnAtras.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)));
		
		this.btnFinalizar = new JButton(language.btnEnd());
		this.btnFinalizar.setBackground(new Color(215,18,43));
		this.btnFinalizar.setForeground(new Color(255,255,255));
		this.btnFinalizar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)));
		
		this.panel.add(lblTitulo);
		this.panel.add(this.username, "wrap, align right");
		this.panel.add(lblModeloCoche, "wrap, align right");
		this.panel.add(cbElevadurasElectricas);
		this.panel.add(cbNavegador, "align left, wrap");
		this.panel.add(cbLlantasAl);
		this.panel.add(cbAsientosCal, "align left, wrap");
		this.panel.add(cbVelCrucero);
		this.panel.add(cbAparcamietnoAuto, "align left, wrap");
		this.panel.add(cbConectorUSB);
		this.panel.add(cbPinturaMetal, "align left, wrap");
		this.panel.add(lblPrecioBasee);
		this.panel.add(tfPrecioBase, "align left, wrap, pushx, growx");
		this.panel.add(lblAumento);
		this.panel.add(tfAumento, "align left, wrap, pushx, growx");
		this.panel.add(lblTotalPrecio);
		this.panel.add(tfTotalPrecio, "align left, wrap, pushx, growx");
		this.panel.add(btnAtras);
		this.panel.add(btnFinalizar, "align right, wrap");
		
		JFrame();
		
	}
	
	/*
	 * Método para configurar la ventana actual.
	 */
	private void JFrame() {
		add(panel);
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
