package view.miglayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import config.ConfigurationLoader;
import daoImplFactory.LanguageFactory;
import idao.ILanguage;
import model.Client;
import model.Model;
import net.miginfocom.swing.MigLayout;

public class Seleccion_Modelo extends JFrame{
	
//	public static void main(String[] args) {
//		ConfigurationLoader configLoad = ConfigurationLoader.getConfigurationLoaderInstance();
//		ILanguage language = LanguageFactory.getLanguage(configLoad.getLanguage_default());
//		part12 p = new part12(configLoad, language, "alexis.mengual");
//	}
	

	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	private Model model;
	
//	private JFrame frame;
	private JPanel panelGBC=new JPanel(),panelBox=new JPanel();
	private List<JButton> listBotones;
	private JButton siguiente,anterior,btnCoches;
	private JLabel l1,luser;
	private JTextPane areaInfo;
	private JTextPane area;
	private ImageIcon coche;
	private ImageIcon cocheBoton;
	private JScrollPane scroll;
	private int posicion=0;
	
	String[] imatge_nom;
	String root = "src\\config\\car\\images\\";
	List<Image> listImg;
	
	/*
	 * Añado los componentes del concesionaro del coche (parte 12)
	 */
	public Seleccion_Modelo(ConfigurationLoader configLoad, ILanguage language, String username, Client client){
		this.configLoad = configLoad;
		this.language = language;
		this.client = client;
		this.username = username;
		this.model = new Model(this.configLoad);
		//migLayout
		this.panelGBC.setLayout(new MigLayout("insets 50, fillx, filly"));
		this.panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
		this.panelGBC.setBackground(new Color(255, 255, 255));
		this.panelBox.setBackground(new Color(255, 255, 255));
		
		this.l1=new JLabel(variables.Lenguaje.tituloTexto);
		this.l1.setFont(new java.awt.Font("Tahoma", 0, 16));
		this.luser=new JLabel(this.language.labelAuthIn() + username);
		this.luser.setFont(new java.awt.Font("Tahoma", 0, 10));
		
		this.area=new JTextPane();
			area.setContentType("text/html");
			area.setEditable(false);
		this.areaInfo=new JTextPane();
			areaInfo.setContentType("text/html");
			areaInfo.setEditable(false);
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
		
												//se añade la ruta de la imagen en una lista
		this.imatge_nom = this.model.getImage_name();
		List<String> listImg=new ArrayList<>();
		for (int i = 0; i < imatge_nom.length; i++) {
			listImg.add(this.root + this.imatge_nom[i]);
			listImg.add(this.root + this.imatge_nom[i]);
		}
	
		//creamos una lista de los botones con las rutas de las imagenes
		this.listBotones=new ArrayList<JButton>();
		crearBoton(listImg);//lista ruta imagen
		
		//añadimos los botones al panel
		for (JButton jButton : listBotones) {
			this.panelBox.add(jButton);
		}


		
		this.scroll = new JScrollPane(panelBox);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scroll.setMinimumSize(new Dimension(coche.getImage().getWidth(null)/3-10, coche.getImage().getHeight(null)*3/2));
		scroll.setPreferredSize(new Dimension(coche.getImage().getWidth(null)/3-10, coche.getImage().getHeight(null)*3/2));
		scroll.setBorder(null);
		
							//Añadimos las dimensiones aqui porque si hago como el scroll me dice que son 0,0, asi, me lo pilla bien
		area.setMinimumSize(new Dimension((scroll.getMinimumSize().width+10)*3,scroll.getMinimumSize().height*2/3));

//		listBotones.get(0).doClick();
		
		this.panelGBC.add(l1, "span 2");
		this.panelGBC.add(luser, "wrap, align right");
		this.panelGBC.add(scroll, "align right");
		this.panelGBC.add(area, "wrap, pushx, growx, pushy, growy, span 2");
		this.panelGBC.add(areaInfo, "span 2, skip, wrap, align right, pushx, growx");
		this.panelGBC.add(anterior, "skip");
		this.panelGBC.add(siguiente, "align right");
		
		
		area.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				area.setMargin(new Insets(area.getBounds().height/2-area.getBounds().y, 0, 0, 0));
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
		
		anterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				anteriorActionPerformed();
			}
		});
		
		siguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				siguienteActionPerformed();
			}
		});
		
		
		JFrame();
	}
	
	/*
	 * Método para configurar la ventana actual.
	 */
	private void JFrame() {
		add(panelGBC);
		setTitle("SEAT Configurador - Selección de modelo");
		setIconImage(getIconImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void crearBoton(List<String> nom) {
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
	private void listener(ImageIcon coch, JButton b) {
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
				b.setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(new Color(215, 18, 43)),
						BorderFactory.createEmptyBorder(1, 1, 1, 1)
						));
				for (int i = 0; i < imatge_nom.length; i++) {
					if ((root+imatge_nom[i]).equals(coch.getDescription())) {//la descripcion es del objeto, que devuelve la ruta de la imagen
						posicion=i;
					}
				}
				File fImg = new File(coch.getDescription());
				area.setText("<html><div style='text-align: center;'><span style='background: rgb(215,18,43); color: rgb(255,255,255); padding:10px; font-family: Tahoma;'>"+model.getName()[posicion]+"<br><img src =\""+fImg.toURI()+"\" /></span></div></html>");
				areaInfo.setText("<html><div style='text-align: center; font-family: Tahoma;'><span style=padding:10px;'>"+model.getDescription()[posicion]+"</span></div><br></html>");
				System.out.println("[INFO] - Cambiando modelo a: "+model.getName()[posicion]);
			}
		});
	}
	
	public Image getIconImage() {
		File image = new File("src/config/favicon.png");
        Image retValue = Toolkit.getDefaultToolkit().getImage(image.getAbsolutePath());
        return retValue;
    }

	protected void anteriorActionPerformed() {
		setVisible(false);
		new Data_Clients(configLoad, language, username, client);
	}
	
	protected void siguienteActionPerformed() {
		
	}
}