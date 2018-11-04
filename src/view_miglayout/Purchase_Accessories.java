package src.view_miglayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import src.config.ConfigurationLoader;
import src.daoImplFactory.LanguageFactory;
import src.idao.ILanguage;
import src.model.Client;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class Purchase_Accessories extends JFrame {

	// Atributos de la Clase:
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private JLabel username;
	
	JPanel contentPane;
	JLabel lblTitulo, lblModeloCoche, lblPrecioBasee, lblAumento, lblTotalPrecio;
	JTextField tfAumento, tfTotalPrecio, tfPrecioBase;
	JCheckBox cbElevadurasElectricas, cbNavegador, cbLlantasAl, cbAsientosCal, cbVelCrucero, cbAparcamietnoAuto, cbConectorUSB, cbPinturaMetal;
	JButton btnAtras, btnFinalizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurationLoader configLoad = ConfigurationLoader.getConfigurationLoaderInstance();
					ILanguage language = LanguageFactory.getLanguage(configLoad);
					String username = "user1";
					Purchase_Accessories frame = new Purchase_Accessories(configLoad, language, username);
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
	public Purchase_Accessories(ConfigurationLoader configLoad, ILanguage language, String username) {
		this.language = language;
		this.configLoad = configLoad;
		this.username = new JLabel(username);
		this.username.setFont(new Font("Tahoma", 0, 11));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 537);
		contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setBackground(new Color(255,255,255));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("insets 35"));
		
		this.lblTitulo = new JLabel("Compra de Accesorios");
		this.lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		this.lblModeloCoche = new JLabel("Caracteristicas seleccionadas anteriormente.");
		this.lblModeloCoche.setFont(new Font("Tahoma", 2, 12));
		
		this.cbElevadurasElectricas = new JCheckBox("Elevaduras electricas");
		this.cbElevadurasElectricas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbElevadurasElectricas.setBackground(new Color(255,255,255));
		this.cbElevadurasElectricas.setFocusable(false);
		
		this.cbNavegador = new JCheckBox("Navegador");
		this.cbNavegador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbNavegador.setBackground(new Color(255,255,255));
		this.cbNavegador.setFocusable(false);
		
		this.cbLlantasAl = new JCheckBox("Llantas de aleacion");
		this.cbLlantasAl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbLlantasAl.setBackground(new Color(255,255,255));
		this.cbLlantasAl.setFocusable(false);
		
		this.cbAsientosCal = new JCheckBox("Asientos calefactados");
		this.cbAsientosCal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbAsientosCal.setBackground(new Color(255,255,255));
		this.cbAsientosCal.setFocusable(false);
		
		this.cbVelCrucero = new JCheckBox("Velocidad de crucero");
		this.cbVelCrucero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbVelCrucero.setBackground(new Color(255,255,255));
		this.cbVelCrucero.setFocusable(false);
		
		this.cbAparcamietnoAuto = new JCheckBox("Aparcamiento automatico");
		this.cbAparcamietnoAuto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbAparcamietnoAuto.setBackground(new Color(255,255,255));
		this.cbAparcamietnoAuto.setFocusable(false);
		
		this.cbConectorUSB = new JCheckBox("Conectores USB");
		this.cbConectorUSB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbConectorUSB.setBackground(new Color(255,255,255));
		this.cbConectorUSB.setFocusable(false);
		
		this.cbPinturaMetal = new JCheckBox("Pintura metalizada");
		this.cbPinturaMetal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cbPinturaMetal.setBackground(new Color(255,255,255));
		this.cbPinturaMetal.setFocusable(false);
		
		this.lblPrecioBasee = new JLabel("Precio Base:");
		this.lblPrecioBasee.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		this.tfPrecioBase = new JTextField();
		this.tfPrecioBase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.tfPrecioBase.setText("0");
		this.tfPrecioBase.setOpaque(false);
		this.tfPrecioBase.setEditable(false);
		
		this.lblAumento = new JLabel("Accesorios:");
		this.lblAumento.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		this.tfAumento = new JTextField();
		this.tfAumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.tfAumento.setText("0");
		this.tfAumento.setOpaque(false);
		this.tfAumento.setEditable(false);
		
		this.lblTotalPrecio = new JLabel("Total precio:");
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
		
		this.btnAtras = new JButton("Atrás");
		this.btnAtras.setBackground(new Color(215,18,43));
		this.btnAtras.setForeground(new Color(255,255,255));
		this.btnAtras.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)));
		
		this.btnFinalizar = new JButton("Finalizar Compra");
		this.btnFinalizar.setBackground(new Color(215,18,43));
		this.btnFinalizar.setForeground(new Color(255,255,255));
		this.btnFinalizar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)));
		
		this.contentPane.add(lblTitulo);
		this.contentPane.add(this.username, "wrap, align right");
		this.contentPane.add(lblModeloCoche, "wrap, align right");
		this.contentPane.add(cbElevadurasElectricas);
		this.contentPane.add(cbNavegador, "align left, wrap");
		this.contentPane.add(cbLlantasAl);
		this.contentPane.add(cbAsientosCal, "align left, wrap");
		this.contentPane.add(cbVelCrucero);
		this.contentPane.add(cbAparcamietnoAuto, "align left, wrap");
		this.contentPane.add(cbConectorUSB);
		this.contentPane.add(cbPinturaMetal, "align left, wrap");
		this.contentPane.add(lblPrecioBasee);
		this.contentPane.add(tfPrecioBase, "align left, wrap, pushx, growx");
		this.contentPane.add(lblAumento);
		this.contentPane.add(tfAumento, "align left, wrap, pushx, growx");
		this.contentPane.add(lblTotalPrecio);
		this.contentPane.add(tfTotalPrecio, "align left, wrap, pushx, growx");
		this.contentPane.add(btnAtras);
		this.contentPane.add(btnFinalizar, "align right, wrap");
		
	}

}
