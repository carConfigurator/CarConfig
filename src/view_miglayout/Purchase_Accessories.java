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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	double Aumento, TotalPrecio;
	
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
		this.Aumento = 0;
		this.TotalPrecio = 0;
		
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
		this.lblModeloCoche.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		
		this.cbElevadurasElectricas = new JCheckBox(language.checkBoxElectricElevation());
		this.cbElevadurasElectricas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbElevadurasElectricas.setBackground(new Color(255,255,255));
		this.cbElevadurasElectricas.setFocusable(false);
		
		// Compruebo que este modelo disponga de Elevaduras Electricas
		if(!this.accessory.checkElectricElevation(this.model.getIdSelected())) {
			this.cbElevadurasElectricas.setEnabled(false);
			this.cbElevadurasElectricas.setToolTipText("Cargando Modelos disponibles...");
		}
		
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
		if(!this.accessory.checkTire(this.model.getIdSelected())) {
			this.cbLlantasAl.setEnabled(false);
		}
		
		this.cbAsientosCal = new JCheckBox(language.checkBoxHeatedSeats());
		this.cbAsientosCal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbAsientosCal.setBackground(new Color(255,255,255));
		this.cbAsientosCal.setFocusable(false);
		if(!this.accessory.checkSeating(this.model.getIdSelected())) {
			this.cbAsientosCal.setEnabled(false);
		}
		
		this.cbVelCrucero = new JCheckBox(language.checkBoxCruisingSpeed());
		this.cbVelCrucero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbVelCrucero.setBackground(new Color(255,255,255));
		this.cbVelCrucero.setFocusable(false);
		if(!this.accessory.checkSpeedCruise(this.model.getIdSelected())) {
			this.cbVelCrucero.setEnabled(false);
		}
		
		this.cbAparcamietnoAuto = new JCheckBox(language.checkBoxAutomaticParking());
		this.cbAparcamietnoAuto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbAparcamietnoAuto.setBackground(new Color(255,255,255));
		this.cbAparcamietnoAuto.setFocusable(false);
		if(!this.accessory.checkAutoParking(this.model.getIdSelected())) {
			this.cbAparcamietnoAuto.setEnabled(false);
		}
		
		this.cbConectorUSB = new JCheckBox(language.checkBoxUsbConnectors());
		this.cbConectorUSB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbConectorUSB.setBackground(new Color(255,255,255));
		this.cbConectorUSB.setFocusable(false);
		if(!this.accessory.checkUSB(this.model.getIdSelected())) {
			this.cbConectorUSB.setEnabled(false);
		}
		
		this.cbPinturaMetal = new JCheckBox(language.checkBoxMetallizedPaint());
		this.cbPinturaMetal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbPinturaMetal.setBackground(new Color(255,255,255));
		this.cbPinturaMetal.setFocusable(false);
		if(!this.accessory.checkMetallicPaint(this.model.getIdSelected())) {
			this.cbPinturaMetal.setEnabled(false);
		}
		
		JLabel lblPrecioBase = new JLabel(language.labelBasePrice());
		lblPrecioBase.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		lblPrecioBase.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		double precioBase = this.model.getPriceSelected() + this.engine.getPrice();
		JLabel lblMostrarPrecioBase = new JLabel(String.valueOf(precioBase));
		
		this.lblAumento = new JLabel(language.labelIncreasePrice());
		this.lblAumento.setFont(new Font("Tahoma", Font.BOLD, 14));
				
		JLabel lblMostrarAumento = new JLabel(String.valueOf(Aumento));
		
		this.lblTotalPrecio = new JLabel(language.labelTotalPrice());
		this.lblTotalPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.lblTotalPrecio.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		
		TotalPrecio = Double.parseDouble(lblMostrarAumento.getText()) + Double.parseDouble(lblMostrarPrecioBase.getText());
		JLabel lblMostrarTotalPrecio = new JLabel(String.valueOf(TotalPrecio));
		lblMostrarTotalPrecio.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		
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
<<<<<<< HEAD
		
		this.btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
=======
>>>>>>> 4f426254565acff75b2aec88f39a862847e692f5
		this.btnFinalizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Albaran(configLoad, language, username, client);
<<<<<<< HEAD
			}
		});
		
		cbElevadurasElectricas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				double priceElevators = accessory.getPriceElevators();
				if(cbElevadurasElectricas.isSelected()) {
					System.out.println("[INFO] - Elevaduras Seleccionado");
					Aumento = Aumento + priceElevators;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio + priceElevators;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}else{
					Aumento = Aumento - priceElevators;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio - priceElevators;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}
			}
		});
		
		cbNavegador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double pricesNavegador = accessory.getPriceNavegador();
				if(cbNavegador.isSelected()) {
					System.out.println("[INFO] - Navegador Seleccionado");
					Aumento = Aumento + pricesNavegador;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio + pricesNavegador;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}else{
					Aumento = Aumento - pricesNavegador;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio - pricesNavegador;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}
			}
		});
		
		cbLlantasAl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double pricesTires = accessory.getPriceTires();
				if(cbLlantasAl.isSelected()) {
					System.out.println("[INFO] - Navegador Seleccionado");
					Aumento = Aumento + pricesTires;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio + pricesTires;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}else{
					Aumento = Aumento - pricesTires;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio - pricesTires;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}
			}
		});
		
		cbAsientosCal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double priceSeating = accessory.getPriceSeating();
				if(cbAsientosCal.isSelected()) {
					System.out.println("[INFO] - Navegador Seleccionado");
					Aumento = Aumento + priceSeating;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio + priceSeating;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}else{
					Aumento = Aumento - priceSeating;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio - priceSeating;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}
			}
		});
		
		cbVelCrucero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double priceSpeedCruise = accessory.getPriceSpeedCruise();
				if(cbVelCrucero.isSelected()) {
					System.out.println("[INFO] - Navegador Seleccionado");
					Aumento = Aumento + priceSpeedCruise;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio + priceSpeedCruise;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}else{
					Aumento = Aumento - priceSpeedCruise;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio - priceSpeedCruise;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}
			}
		});
		
		cbAparcamietnoAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double priceAutoParking = accessory.getPriceAutoParking();
				if(cbAparcamietnoAuto.isSelected()) {
					System.out.println("[INFO] - Navegador Seleccionado");
					Aumento = Aumento + priceAutoParking;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio + priceAutoParking;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}else{
					Aumento = Aumento - priceAutoParking;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio - priceAutoParking;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}
			}
		});
		
		cbConectorUSB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double priceUSB = accessory.getPriceUSB();
				if(cbConectorUSB.isSelected()) {
					System.out.println("[INFO] - Navegador Seleccionado");
					Aumento = Aumento + priceUSB;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio + priceUSB;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}else{
					Aumento = Aumento - priceUSB;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio - priceUSB;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}
			}
		});
		
		cbPinturaMetal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double metallicPaint = accessory.getPriceMetallicPaint();
				if(cbPinturaMetal.isSelected()) {
					System.out.println("[INFO] - Navegador Seleccionado");
					Aumento = Aumento + metallicPaint;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio + metallicPaint;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}else{
					Aumento = Aumento - metallicPaint;
					lblMostrarAumento.setText(String.valueOf(Aumento));
					TotalPrecio = TotalPrecio - metallicPaint;
					lblMostrarTotalPrecio.setText(String.valueOf(TotalPrecio));
				}
			}
		});
		
		// Add components to JPanel
=======
				
			}
		});
>>>>>>> 4f426254565acff75b2aec88f39a862847e692f5
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
		this.panel.add(lblPrecioBase);
		this.panel.add(lblMostrarPrecioBase, "align left, wrap, pushx, growx");
		this.panel.add(lblAumento);
		this.panel.add(lblMostrarAumento, "align left, wrap, pushx, growx");
		this.panel.add(lblTotalPrecio);
		this.panel.add(lblMostrarTotalPrecio, "align left, wrap, pushx, growx");
		this.panel.add(this.btnAtras, "align left");
		this.panel.add(btnFinalizar, "align right");
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
