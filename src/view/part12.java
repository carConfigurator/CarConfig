package view;

import java.awt.Color;
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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.toedter.calendar.JDateChooser;

import config.ConfigurationLoader;
import model.Model;
import net.miginfocom.swing.MigLayout;

public class part12 {
	
	private ConfigurationLoader configLoad;
	
	public static void main(String[] args) {
		new part12();
	}
	
	private JFrame frame;
	private JPanel panelGBC,panelBox;
	private List<JButton> listBotones;
	private JButton siguiente,anterior,coches;
	private JLabel l1,l2;
	private JTextArea areaInfo;
	private JTextPane area;
	private ImageIcon coche;
	private ImageIcon cocheBoton;
	
	String i1="src\\config\\car\\images\\Ateca.jpeg";
	String i2="src\\config\\car\\images\\Mii_5P.jpeg";
	String i3="src\\config\\car\\images\\Nuevo_Arona.jpeg";
	String i4="src\\config\\car\\images\\Nuevo_Ibiza.jpeg";
	List<Image> aux;
	
	/*
	 * Añado los componentes del concesionaro del coche (parte 12)
	 */
	public part12() {
		this.configLoad = configLoad.getConfigurationLoaderInstance();
		Model model = new Model(configLoad);
		frame=new JFrame(variables.Lenguaje.tituloConcesionario);
		panelGBC= new JPanel();
		panelBox=new JPanel();
		panelGBC.setLayout(new GridBagLayout());
		panelGBC.setBackground(new Color(255, 255, 255));
		panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
		panelBox.setBackground(new Color(255, 255, 255));
		GridBagConstraints constraints= new GridBagConstraints();
		frame.add(panelGBC);
		
	//Linea 0	
		l1=new JLabel(variables.Lenguaje.tituloTexto);
		Font font=l1.getFont();
		l1.setFont(new Font(font.getFontName(), font.getStyle(), 15));
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=2;
		constraints.insets=new Insets(10,0,10,0);//top, left, bottom, right
		constraints.fill=GridBagConstraints.EAST;
		panelGBC.add(l1, constraints);
		
		//Volvemos a dejar que sea todo en su posicion
		constraints.gridwidth=1;
		constraints.insets=new Insets(0,0,0,0);
		
		l2=new JLabel(variables.Lenguaje.textoUser);
		constraints.gridx=2;
		constraints.gridy=0;
		//fill east
		panelGBC.add(l2, constraints);
	
	//Linea 1
		//BOTONES EN BOX
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridheight=8;
		constraints.insets=new Insets(0,0,0,30);//top, left, bottom, right
		panelGBC.add(panelBox, constraints);
		
		//quitamos los insets
		constraints.insets=new Insets(0,0,0,0);//top, left, bottom, right
		
		//cambiarlo por las variables
		List<String> listAux=new ArrayList<>();
		listAux.add(i1);
		listAux.add(i2);
		listAux.add(i3);
		listAux.add(i4);
		
		//creamos una lista de los botones
		listBotones=new ArrayList<JButton>();
		crearBoton(listAux);
		
		//añadimos los botones al panel
		for (JButton jButton : listBotones) {
			panelBox.add(jButton);
		}

	//quitamos la posicion
		constraints.gridheight=1;
		
		area=new JTextPane();
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.gridwidth=2;
		constraints.gridheight=4;
		constraints.fill=GridBagConstraints.BOTH;
		panelGBC.add(area, constraints);
		
		//Volvemos a dejar que sea todo en su posicion
		constraints.gridwidth=1;
		constraints.gridheight=1;

	//linia 5
		areaInfo=new JTextArea("Info coche");
		constraints.gridx=2;
		constraints.gridy=5;
		constraints.gridheight=2;
		constraints.insets=new Insets(5, 0, 0, 0);
		panelGBC.add(areaInfo, constraints);
		
		//Volvemos a dejar que sea todo en su posicion
		constraints.gridheight=1;
		constraints.fill=GridBagConstraints.NONE;
		
	//linia 7
		//Insets para los botones
		constraints.insets=new Insets(20, 0, 0, 0);//top, left, bottom, right
		
		anterior=new JButton(variables.Lenguaje.bAnterior);
		constraints.gridx=1;
		constraints.gridy=7;
		constraints.fill=GridBagConstraints.NORTHWEST;
		panelGBC.add(anterior, constraints);
		
		siguiente=new JButton(variables.Lenguaje.bSiguiente);
		constraints.gridx=2;
		constraints.gridy=7;
		constraints.fill=GridBagConstraints.NORTHEAST;
		panelGBC.add(siguiente, constraints);
		
		//Quitar insets y fill
		constraints.insets=new Insets(0, 0, 0, 0);
		constraints.fill=GridBagConstraints.NONE;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public void crearBoton(List<String> nom) {
		for (String string : nom) {
			coches=new JButton();
			coche=new ImageIcon(string);
			cocheBoton= new ImageIcon(coche.getImage().getScaledInstance(coche.getIconWidth()/4, coche.getIconHeight()/4, Image.SCALE_DEFAULT));
			coches.setIcon(cocheBoton);//new ImageIcon(Model.getImageIcon[0]);//cargamos la imagen en el modelo
			coches.setMargin(new Insets(0, 0, 0, 0));
			listBotones.add(coches);
			
			aux=new ArrayList<Image>();
			aux.add(coche.getImage());
			
			listener(coche, coches);  
		}
	}
	public void listener(ImageIcon coch, JButton b) {
		b.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				area.setContentType("text/html");
				area.setText("<html><div style='text-align: center;'><span style='background: red'>" + "NombreCoche" + "</span></div><br></html>");
				area.insertIcon(coch);
				area.setEditable(false);
				frame.pack();
			}
		});
	}

}