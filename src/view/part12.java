package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.toedter.calendar.JDateChooser;

import config.ConfigurationLoader;
import daoImplFactory.LanguageFactory;
import net.miginfocom.swing.MigLayout;

public class part12 extends JFrame{
	
	public static void main(String[] args){
		new part12();
	}
	
//	private JFrame frame;
	private JPanel panelGBC=new JPanel(),panelBox=new JPanel();
	private List<JButton> listBotones;
	private JButton siguiente,anterior,coches;
	private JLabel l1,luser;
	private JTextArea areaInfo;
	private JTextPane area;
	private ImageIcon coche;
	private ImageIcon cocheBoton;
	private JScrollPane scroll;
	int i=0;
	
	String i1="src\\config\\car\\images\\Ateca.jpeg";
	String i2="src\\config\\car\\images\\Mii_5P.jpeg";
	String i3="src\\config\\car\\images\\Nuevo_Arona.jpeg";
	String i4="src\\config\\car\\images\\Nuevo_Ibiza.jpeg";
	List<Image> listImg;
	
	/*
	 * Añado los componentes del concesionaro del coche (parte 12)
	 */
	public part12(/*language, configLoader*/){
		//migLayout
		this.panelGBC.setLayout(new MigLayout("insets 20"));
		this.panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
		/*this.panelGBC.setBackground(new Color(255, 255, 255));
		this.panelBox.setBackground(new Color(255, 255, 255));*/
		
		this.l1=new JLabel(variables.Lenguaje.tituloTexto);
		Font font=l1.getFont();
		this.l1.setFont(new Font(font.getFontName(), font.getStyle(), 15));
		this.luser=new JLabel(variables.Lenguaje.textoUser);
		
		this.scroll = new JScrollPane(panelBox);
		this.area=new JTextPane();
		this.areaInfo=new JTextArea("Info coche");
		this.anterior=new JButton(variables.Lenguaje.bAnterior);
		this.siguiente=new JButton(variables.Lenguaje.bSiguiente);
		
//cambiarlo por las variables
		List<String> listAux=new ArrayList<>();
		listAux.add(i1);
		listAux.add(i2);
		listAux.add(i3);
		listAux.add(i4);
//		listAux.add(i4);
//		listAux.add(i4);
//		listAux.add(i4);
//		listAux.add(i4);
//		listAux.add(i4);
//		listAux.add(i4);
//		listAux.add(i4);
//		listAux.add(i4);
//		listAux.add(i4);
//		listAux.add(i4);
//		listAux.add(i4);
		
		
		//creamos una lista de los botones
		this.listBotones=new ArrayList<JButton>();
		crearBoton(listAux);//lista ruta imagen
		
		//añadimos los botones al panel
		for (JButton jButton : listBotones) {
			this.panelBox.add(jButton);
		}


		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(coche.getImage().getWidth(null)/3-10, coche.getImage().getHeight(null)*2));
		scroll.requestFocus();
		
		this.panelGBC.add(l1, "span 2");
		this.panelGBC.add(luser, "wrap, align right");
		this.panelGBC.add(scroll, "align right");
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
		setTitle("SEAT Configurador - Log In");
		setIconImage(getIconImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void crearBoton(List<String> nom) {
		for (String string : nom) {
			coches=new JButton();
			coche=new ImageIcon(string);
			cocheBoton= new ImageIcon(coche.getImage().getScaledInstance(coche.getIconWidth()/4, coche.getIconHeight()/4, Image.SCALE_DEFAULT));
			coches.setIcon(cocheBoton);//new ImageIcon(Model.getImageIcon[0]);//cargamos la imagen en el modelo
			coches.setMargin(new Insets(0, 0, 0, 0));
			listBotones.add(coches);
			
			listImg=new ArrayList<Image>();
			listImg.add(coche.getImage());
			
			listener(coche, coches);  
		}
		
		
	}
	public void listener(ImageIcon coch, JButton b) {
//		b.addFocusListener(new FocusListener() {
//			
//			@Override
//			public void focusLost(FocusEvent e) {
//			}
//			
//			@Override
//			public void focusGained(FocusEvent e) {
//				area.setContentType("text/html");
//				area.setText("<html><div style='text-align: center;'><span style='background: red'>" + "NombreCoche" + "</span></div><br></html>");
//				area.insertIcon(coch);
//				area.setEditable(false);
//			}
//		});
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				area.setContentType("text/html");
				area.setText("<html><div style='text-align: center;'><span style='background: red'>" + "NombreCoche" + "</span></div><br></html>");
				area.insertIcon(coch);
				area.setEditable(false);
			}
		});
	}

}