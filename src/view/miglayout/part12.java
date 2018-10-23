package view.miglayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import config.ConfigurationLoader;
import daoImplFactory.LanguageFactory;
import idao.ILanguage;
import model.Model;
import net.miginfocom.swing.MigLayout;

public class part12 extends JFrame{
	
	public static void main(String[] args) {
		ConfigurationLoader configLoad = ConfigurationLoader.getConfigurationLoaderInstance();
		ILanguage language = LanguageFactory.getLanguage(configLoad.getLanguage_default());
		part12 p = new part12(configLoad, language, "alexis.mengual");
	}
	
	private ConfigurationLoader configLoad;
	private ILanguage language;
	private Model model;
	
//	private JFrame frame;
	private JPanel panelGBC=new JPanel(),panelBox=new JPanel();
	private List<JButton> listBotones;
	private JButton siguiente,anterior,btnCoches;
	private JLabel l1,luser;
	private JTextArea areaInfo;
	private JTextPane area;
	private ImageIcon coche;
	private ImageIcon cocheBoton;
	private JScrollPane scroll;
	int i=0;
	
	String[] imatge_nom;
	String root = "src\\config\\car\\images\\";
	String i1="src\\config\\car\\images\\Ateca.jpeg";
	String i2="src\\config\\car\\images\\Mii_5P.jpeg";
	String i3="src\\config\\car\\images\\Nuevo_Arona.jpeg";
	String i4="src\\config\\car\\images\\Nuevo_Ibiza.jpeg";
	List<Image> listImg;
	
	/*
	 * Añado los componentes del concesionaro del coche (parte 12)
	 */
	public part12(ConfigurationLoader configLoad, ILanguage language, String username){
		this.configLoad = configLoad;
		this.language = language;
		this.model = new Model(this.configLoad);
		//migLayout
		this.panelGBC.setLayout(new MigLayout("insets 50, fillx, filly"));
		this.panelGBC.setBackground(new Color(255, 255, 255));
		this.panelBox.setBackground(new Color(255, 255, 255));
		
		this.l1=new JLabel(variables.Lenguaje.tituloTexto);
		this.l1.setFont(new java.awt.Font("Tahoma", 0, 16));
		this.luser=new JLabel(variables.Lenguaje.textoUser);
		
		this.area=new JTextPane();
			area.setContentType("text/html");
			area.setEditable(false);
		this.areaInfo=new JTextArea("Info coche");
		this.anterior=new JButton(variables.Lenguaje.bAnterior);
		this.anterior.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.anterior.setBackground(new Color(215,18,43));
		this.anterior.setForeground(new Color(255,255,255));
		this.anterior.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)
				));
		this.siguiente=new JButton(variables.Lenguaje.bSiguiente);
		this.siguiente.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.siguiente.setBackground(new Color(215,18,43));
		this.siguiente.setForeground(new Color(255,255,255));
		this.siguiente.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)
				));
		
		//cambiarlo por las variables
		this.imatge_nom = this.model.getImage_name();
		List<String> listAux=new ArrayList<>();
		for (int i = 0; i < imatge_nom.length; i++) {
			listAux.add(this.root + this.imatge_nom[i]);
		}
		
		Box box = Box.createVerticalBox();
	
		//creamos una lista de los botones
		this.listBotones=new ArrayList<JButton>();
		crearBoton(listAux);//lista ruta imagen
		
		//añadimos los botones al panel
		for (JButton jButton : listBotones) {
//			this.panelBox.add(jButton);
			box.add(jButton);
		}
		
		
		panelBox.add(box);

		JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);
		panelBox.add(scrollBar, BorderLayout.EAST);
//		panelBox.add(scrollBar);
		
//		this.scroll = new JScrollPane(lista);
//		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//      scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//		scroll.setPreferredSize(new Dimension(coche.getImage().getWidth(null)/3-10, coche.getImage().getHeight(null)*2));
//		scroll.requestFocus();
		
		this.panelGBC.add(l1, "span 2");
		this.panelGBC.add(luser, "wrap, align right");
		this.panelGBC.add(panelBox, "align right");//scroll
		this.panelGBC.add(area, "wrap, pushx, growx, pushy, growy, span 2");
		this.panelGBC.add(areaInfo, "span 2, skip, wrap, align right, pushx, growx");
		this.panelGBC.add(anterior, "skip");
		this.panelGBC.add(siguiente, "align right");
		
		JFrame();
		listBotones.get(0).doClick();
	}
	
	/*
	 * Método para configurar la ventana actual.
	 */
	public void JFrame() {
		add(panelGBC);
		setTitle("SEAT Configurador");
		setIconImage(getIconImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void crearBoton(List<String> nom) {
		for (String string : nom) {
			btnCoches=new JButton();
			btnCoches.setBackground(new Color(255,255,255));
			btnCoches.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(new Color(255, 255, 255)),
					BorderFactory.createEmptyBorder(1, 1, 1, 1)
					));
			coche=new ImageIcon(string);
			cocheBoton= new ImageIcon(coche.getImage().getScaledInstance(coche.getIconWidth()/4, coche.getIconHeight()/4, Image.SCALE_DEFAULT));
			btnCoches.setIcon(cocheBoton);
			btnCoches.setMargin(new Insets(0, 0, 0, 0));
			listBotones.add(btnCoches);
			
			listImg=new ArrayList<Image>();
			listImg.add(coche.getImage());
			
			listener(coche, btnCoches);  
		}
		
		
	}
	public void listener(ImageIcon coch, JButton b) {
		b.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				b.setBackground(new Color(255,255,255));
				b.setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(new Color(255, 255, 255)),
						BorderFactory.createEmptyBorder(1, 1, 1, 1)
						));
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println(b.getIcon().toString());
				b.setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(new Color(215, 18, 43)),
						BorderFactory.createEmptyBorder(1, 1, 1, 1)
						));
				area.setContentType("text/html");
				area.setText("<html><div style='text-align: center;'><span style='background: red; padding:10px;'>Nombre del Coche</span></div><br></html>");
				area.insertIcon(coch);
				area.setEditable(false);
			}
		});
//		b.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				area.setText("<html><div style='text-align: center;'><span style='background: red'>" + "NombreCoche" + "</span></div><br></html>");
//				area.insertIcon(coch);
//			}
//		});
	}

}