package view_miglayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import config.ConfigurationLoader;
import daoImplFactory.LanguageFactory;
import idao.ILanguage;
import model.Accessory;
import model.Client;
import model.Engine;
import model.Model;
import net.miginfocom.swing.MigLayout;

public class Selection_model extends JFrame{
	
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	private Model model;
	private Engine engine;
	private Accessory accessory;
	
	private JPanel panelGBC, panelBox;
	private List<JButton> listBotones;
	private JButton siguiente,anterior,btnCoches, configCoches;
	private JLabel l1,luser;
	private JTextPane areaInfo;
	private JTextPane area;
	private ImageIcon coche;
	private ImageIcon cocheBoton;
	private JScrollPane scroll;
	private int posicion=0;
	
	//menu
	private JMenuBar pMenu;
	private JMenu menu;
	private List<JMenuItem> lMenuItem;
	private JSeparator menuSeparator;
	
	String[] imatge_nom;
	String root_images;
	List<Image> listImg;
	File temp;
	
	/*
	 * Añado los componentes del concesionaro del coche (parte 12)
	 */
	public Selection_model(ConfigurationLoader configLoad, ILanguage language, String username, Client client){
		this.configLoad = configLoad;
		this.language = language;
		this.root_images = this.configLoad.getCar_image_path();
		this.client = client;
		this.username = username;
		this.model = new Model(this.configLoad);
		this.engine = new Engine(this.configLoad);
		this.accessory = new Accessory(this.configLoad);
		//migLayout
		this.panelGBC = new JPanel();
		this.panelBox = new JPanel();
		this.panelGBC.setLayout(new MigLayout("insets 20 50 50 50, fillx, filly"));
		this.panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
		this.panelGBC.setBackground(new Color(255, 255, 255));
		this.panelBox.setBackground(new Color(255, 255, 255));
		
		//Creación del Menu
		pMenu=new JMenuBar();
		pMenu.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		pMenu.setBackground(new Color(215,18,43));
		menu=new JMenu(language.menu());
		menu.setForeground(new Color(255,255,255));
		menuSeparator=new JSeparator();
		menuSeparator.setBackground(Color.RED);
		lMenuItem=new ArrayList<JMenuItem>();
		lMenuItem.add(new JMenuItem(language.menuItemAdd()));
		lMenuItem.add(new JMenuItem(language.menuItemDelete()));
		lMenuItem.add(new JMenuItem(language.menuItemModify()));
		for (JMenuItem item : lMenuItem) {
//			menu.add(menuSeparator);//Solo se pone la ultima vez que se llama
			menu.add(item);
			item.setBackground(new Color(255, 255, 255));
		}
		pMenu.add(menu);
		
		
		this.l1=new JLabel(language.labelSelectTitle());
		this.l1.setFont(new java.awt.Font("Tahoma", 0, 16));
		this.luser=new JLabel(this.language.labelAuthIn() + username);
		this.luser.setFont(new java.awt.Font("Tahoma", 0, 10));
		
		this.area=new JTextPane();
			area.setContentType("text/html");
			area.setEditable(false);
		this.areaInfo=new JTextPane();
			areaInfo.setContentType("text/html");
			areaInfo.setEditable(false);
		this.anterior=new JButton(language.btnPrevious());
		this.anterior.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.anterior.setBackground(new Color(215,18,43));
		this.anterior.setForeground(new Color(255,255,255));
		this.anterior.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)
				));
		this.siguiente=new JButton(language.btnNext());
		this.siguiente.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.siguiente.setBackground(new Color(215,18,43));
		this.siguiente.setForeground(new Color(255,255,255));
		this.siguiente.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)
				));
		
		File file = new File("src\\config\\settings.png");
		if(file.exists()) {
			System.out.println("si existe.");
		}
		
		//Se añade la ruta de la imagen en una lista
		this.imatge_nom = this.model.getImage_name();
		List<String> listImg=new ArrayList<>();
		for (int i = 0; i < imatge_nom.length; i++) {
			listImg.add(this.root_images + this.imatge_nom[i]);
		}
	
		//Creamos una lista de los botones con las rutas de las imagenes
		this.listBotones=new ArrayList<JButton>();
		crearBoton(listImg);//lista ruta imagen
		
		//Añadimos los botones al panel
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
		lMenuItem.get(0).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		lMenuItem.get(1).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		lMenuItem.get(2).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modify();
			}
		});
		
		JFrame();
	}
	
	/*
	 * Método para configurar la ventana actual.
	 */
	private void JFrame() {
		setJMenuBar(pMenu);
		add(panelGBC);
		setTitle(language.seleccionModeloTitle());
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
					if ((root_images+imatge_nom[i]).equals(coch.getDescription())) {//la descripcion es del objeto, que devuelve la ruta de la imagen
						posicion=i;
					}
				}
				File fImg = new File(coch.getDescription());
				area.setText("<html><div style='text-align: center;'><span style='color: rgb(215,18,43); font-weight:600; padding:10px; font-family: Tahoma;'>"+model.getName()[posicion]+"<br><img src =\""+fImg.toURI()+"\" /></span></div></html>");
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

	private void anteriorActionPerformed() {
		setVisible(false);
		new Data_Clients(configLoad, language, username, client);
	}
	
	private void siguienteActionPerformed() {
		this.temp = new File(this.configLoad.getTemporalPathFile());
		this.model.toModel(posicion+1);
		int id = model.getIdSelected();
		String name = model.getNameSelected();
		String description = model.getDescriptionSelected();
		double price = model.getPriceSelected();
		try {
			FileWriter fw = new FileWriter(this.temp, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write(id+", "+name+", "+description+", "+price);
			bw.newLine();
			bw.write("------");
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setVisible(false);
		new Selection_Engine(this.configLoad, this.language, this.username, this.client, this.model);
	}
	
	private void add() {
		System.out.println("add");
		new Add_Car(configLoad, language);
	}
	private void delete() {
		System.out.println("delete");
	}
	private void modify() {
		System.out.println("modify");
	}
}