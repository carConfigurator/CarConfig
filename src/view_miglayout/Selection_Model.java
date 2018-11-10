package view_miglayout;

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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import config.ConfigurationLoader;
import idao.ILanguage;
import model.Accessory_woDAO;
import model.Client;
import model.Engine_woDAO;
import model.Model_woDAO;
import net.miginfocom.swing.MigLayout;

public class Selection_Model extends JFrame{	
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	private Model_woDAO model;
	private Engine_woDAO engine;
	private Accessory_woDAO accessory;
	
<<<<<<< HEAD
	// Atributos de componentes
	private JPanel panelGBC, panelBox;
	private List<JButton> listBotones;
	private JButton siguiente,anterior,btnCoches, configCoches;
	private JLabel l1,luser;
	private JTextPane areaInfo;
	private JTextPane area;
	private ImageIcon coche;
	private ImageIcon cocheBoton;
=======
	private JPanel panelMig, panelBox;
	private List<JButton> listBotones;
	private JButton btnNext,btnBack,btnCar;
	private JLabel lTitle,lUser;
	private JTextPane infoPane;
	private JTextPane carPane;
	private ImageIcon imgIconButtonCar;
	private ImageIcon imgIconPaneCar;
>>>>>>> 9049cbba322bbe1548721eb64d760cee2d5a9ac1
	private JScrollPane scroll;
	
	// Atributos del Menu
	private JMenuBar pMenu;
	private JMenu menu;
	private List<JMenuItem> lMenuItem;
	private JSeparator menuSeparator;
	
	private List<Image> listImg;
	private File temp;
	
	/*
	 * Añado los componentes del concesionaro del coche (parte 12)
	 */
	
	public Selection_Model(ConfigurationLoader configLoad, ILanguage language, String username, Client client, Model_woDAO model) {
		this.configLoad = configLoad;
		this.language = language;
		this.client = client;
		this.username = username;
		this.model = model;
		this.engine = new Engine_woDAO(this.configLoad);
		this.accessory = new Accessory_woDAO(this.configLoad);
		this.temp = new File(this.configLoad.getTemporalPathFile());
		
		FileWriter fw;
		try {
			fw = new FileWriter(this.temp);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Datos Temporales");
			bw.newLine();
			bw.write("[Empleado] ");
			bw.write(username);
			bw.newLine();
			bw.write("------");
			bw.newLine();
			bw.write("[Cliente] ");
			bw.write(this.client.toString());
			bw.newLine();
			bw.write("------");
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		onCreate();
		listBotones.get(this.model.getIdSelected()-1).requestFocus();
	}
	
	public Selection_Model(ConfigurationLoader configLoad, ILanguage language, String username, Client client){
		this.configLoad = configLoad;
		this.language = language;
		this.client = client;
		this.username = username;
<<<<<<< HEAD
		this.model = new Model_woDAO(this.configLoad);
		this.engine = new Engine_woDAO(this.configLoad);
		this.accessory = new Accessory_woDAO(this.configLoad);
=======
		this.model = new Model(this.configLoad);
		this.engine = new Engine(this.configLoad);
		this.accessory = new Accessory(this.configLoad);
		this.temp = new File(this.configLoad.getTemporalPathFile());
>>>>>>> 9049cbba322bbe1548721eb64d760cee2d5a9ac1
		
		onCreate();
	}
	
	public void onCreate() {
<<<<<<< HEAD
		//MiGLayout
		this.panelGBC = new JPanel();
=======
		//migLayout
		this.panelMig = new JPanel();
>>>>>>> 9049cbba322bbe1548721eb64d760cee2d5a9ac1
		this.panelBox = new JPanel();
		this.panelMig.setLayout(new MigLayout("insets 20 50 50 50, fillx, filly"));
		this.panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
		this.panelMig.setBackground(new Color(255, 255, 255));
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
			menu.add(item);
			item.setBackground(new Color(255, 255, 255));
		}
		pMenu.add(menu);
		
		//iniciamos los componentes
		this.lTitle=new JLabel(language.labelSelectTitle());
		this.lTitle.setFont(new java.awt.Font("Tahoma", 0, 16));
		this.lUser=new JLabel(this.language.labelAuthIn() + username);
		this.lUser.setFont(new java.awt.Font("Tahoma", 0, 10));
		
<<<<<<< HEAD
		this.l1=new JLabel(language.labelSelectTitle());
		this.l1.setFont(new java.awt.Font("Tahoma", 0, 16));
		this.luser=new JLabel(this.language.labelAuthIn() + username);
		this.luser.setFont(new java.awt.Font("Tahoma", 0, 10));
		
		this.area = new JTextPane();
		this.area.setContentType("text/html");
		this.area.setEditable(false);
			
		this.areaInfo=new JTextPane();
		this.areaInfo.setContentType("text/html");
		this.areaInfo.setEditable(false);
		
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
=======
		this.carPane=new JTextPane();
			carPane.setContentType("text/html");
			carPane.setEditable(false);
		this.infoPane=new JTextPane();
			infoPane.setContentType("text/html");
			infoPane.setEditable(false);
		this.btnBack=new JButton(language.btnPrevious());
		this.btnBack.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.btnBack.setBackground(new Color(215,18,43));
		this.btnBack.setForeground(new Color(255,255,255));
		this.btnBack.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)
				));
		this.btnNext=new JButton(language.btnNext());
		this.btnNext.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.btnNext.setBackground(new Color(215,18,43));
		this.btnNext.setForeground(new Color(255,255,255));
		this.btnNext.setBorder(BorderFactory.createCompoundBorder(
>>>>>>> 9049cbba322bbe1548721eb64d760cee2d5a9ac1
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)
				));
		
		
		
		
		//HASTA AQUI TDODO BIEN
		
		this.listBotones=new ArrayList<JButton>();//esta lista la usamos en createButton, vamos añadiendo los coches a esta lista
		createButton();
		
		//Añadimos los botones al panel
		for (JButton jButton : listBotones) {
			this.panelBox.add(jButton);
		}
		
		this.scroll = new JScrollPane(panelBox);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scroll.setMinimumSize(new Dimension(imgIconButtonCar.getImage().getWidth(null)/3-10, imgIconButtonCar.getImage().getHeight(null)*3/2));
		scroll.setPreferredSize(new Dimension(imgIconButtonCar.getImage().getWidth(null)/3-10, imgIconButtonCar.getImage().getHeight(null)*3/2));
		scroll.setBorder(null);
		
		//Añadimos las dimensiones aqui porque si hago como el scroll me dice que son 0,0, asi, me lo pilla bien
		carPane.setMinimumSize(new Dimension((scroll.getMinimumSize().width+10)*3,scroll.getMinimumSize().height*2/3));
		
		this.panelMig.add(lTitle, "span 2");
		this.panelMig.add(lUser, "wrap, align right");
		this.panelMig.add(scroll, "align right");
		this.panelMig.add(carPane, "wrap, pushx, growx, pushy, growy, span 2");
		this.panelMig.add(infoPane, "span 2, skip, wrap, align right, pushx, growx");
		this.panelMig.add(btnBack, "skip");
		this.panelMig.add(btnNext, "align right");
		
<<<<<<< HEAD
		area.addComponentListener(new ComponentListener() {
=======
		
		carPane.addComponentListener(new ComponentListener() {
>>>>>>> 9049cbba322bbe1548721eb64d760cee2d5a9ac1
			
			@Override
			public void componentShown(ComponentEvent e) {
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				carPane.setMargin(new Insets(carPane.getBounds().height/2-carPane.getBounds().y, 0, 0, 0));
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				anteriorActionPerformed();
			}
		});
		
<<<<<<< HEAD
		siguiente.addActionListener(new ActionListener() {
=======
		btnNext.addActionListener(new ActionListener() {
			
>>>>>>> 9049cbba322bbe1548721eb64d760cee2d5a9ac1
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

		addMenuBar(pMenu);
		addFrame(configLoad, panelMig, language, language.titleDefault());
	}
	
	private void createButton() {
		listImg=new ArrayList<Image>();
		
		for (int i = 0; i < this.model.getId().length; i++) {
			btnCar=new JButton();
			btnCar.setBackground(new Color(255,255,255));
			btnCar.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(new Color(255, 255, 255)),
					BorderFactory.createEmptyBorder(1, 1, 1, 1)
					));
<<<<<<< HEAD
			coche = new ImageIcon(sNomImg.split(";")[0]);//en la posicion 0 tenemos el nombre de la imagen
			cocheBoton = new ImageIcon(coche.getImage().getScaledInstance(coche.getIconWidth()/4, coche.getIconHeight()/4, Image.SCALE_DEFAULT));
			btnCoches.setIcon(cocheBoton);
			btnCoches.setMargin(new Insets(0, 0, 0, 0));
			listBotones.add(btnCoches);
			
			listener(coche, btnCoches, Integer.parseInt(sNomImg.split(";")[1]));  //en la posicion 1 tenemos el id del coche
=======
			imgIconButtonCar=new ImageIcon(this.configLoad.getCar_image_path()+this.model.getImage_name()[i]);//cogemos la ruta de la imagen
			imgIconPaneCar= new ImageIcon(imgIconButtonCar.getImage().getScaledInstance(imgIconButtonCar.getIconWidth()/4, imgIconButtonCar.getIconHeight()/4, Image.SCALE_DEFAULT));//hacemos la imagen pequeña
			btnCar.setIcon(imgIconPaneCar);//añadimos la imagen del coche al boton
			btnCar.setMargin(new Insets(0, 0, 0, 0));
			btnCar.setFocusPainted(false);//hacemos que no se marque al pulsar (no nos hace falta porque ya tenemos bordes)
			listBotones.add(btnCar);
			
			listImg.add(imgIconButtonCar.getImage());//añadimos la imagen a una lista
			
			listener(imgIconButtonCar, btnCar, this.model.getId()[i]);  //en la posicion 1 tenemos el id del coche
>>>>>>> 9049cbba322bbe1548721eb64d760cee2d5a9ac1
		}
	}
	
	private void listener(ImageIcon imgIconCar, JButton bCar, int idCar) {
		bCar.addFocusListener(new FocusListener() {//por cada boton de los coches, añadimos su listener
			
			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (model.getIdSelected()>0) {//Si pulsamos cualquier otra cosa se nos desselecciona el coche, asi lo mantenemos seleccioando hasta que cambiemos de coche
					listBotones.get(model.getIdSelected()-1).setBackground(new Color(255,255,255));
					listBotones.get(model.getIdSelected()-1).setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(new Color(255, 255, 255)),
						BorderFactory.createEmptyBorder(1, 1, 1, 1)
						));
				}
				
				bCar.setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(new Color(215, 18, 43)),
						BorderFactory.createEmptyBorder(1, 1, 1, 1)
						));
				
				File fImg = new File(imgIconCar.getDescription());
				carPane.setText("<html><div style='text-align: center;'><span style='color: rgb(215,18,43); font-weight:600; padding:10px; font-family: Tahoma;'>"+model.getName()[idCar-1]+"<br><img src =\""+fImg.toURI()+"\" /></span></div></html>");
				infoPane.setText("<html><div style='text-align: center; font-family: Tahoma;'><span style=padding:10px;'>"+model.getDescription()[idCar-1]+"</span></div><br></html>");
				System.out.println("[INFO] - Cambiando modelo a: "+model.getName()[idCar-1]);

				model.toModel(idCar);//le decimos que modelo tenemos seleccionado
			}
		});
	}

	private void anteriorActionPerformed() {
		setVisible(false);
		new Data_Clients(configLoad, language, username, client);
	}
	
	private void siguienteActionPerformed() {
		this.temp = new File(this.configLoad.getTemporalPathFile());
		int id = model.getIdSelected();
		String name = model.getNameSelected();
		String description = model.getDescriptionSelected();
		double price = model.getPriceSelected();
		
		try {
			FileWriter fw = new FileWriter(this.temp, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write("[Modelo] ");
			bw.write(id+","+name+","+description+","+price);
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
		System.out.println("[INFO] - Añadiendo un coche...");
		new Add_Car(configLoad, language, username, client, model);
		setVisible(false);
	}
	
	private void delete() {
		setVisible(false);
		System.out.println("[INFO] - Eliminando un coche...");
		new Delete_Car(configLoad, language, username, client, model);
	}
	
	private void modify() {
		System.out.println("[INFO] - Modificando un coche...");
		new Modify_Car(configLoad, language, username, client, model);
		setVisible(false);
	}
}