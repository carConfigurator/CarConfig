package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class part12 {
	
	public static void main(String[] args) {
		new part12();
	}
	
	private JFrame frame;
	private JPanel panelGBC,panelBox;
	private List<JButton> listBotones;
	private JButton b1,b2,b3,b4,b5,b6,b7,siguiente,anterior;
	private JLabel l1,l2;
	private JTextArea area, areaInfo;
	
	public part12() {
		setComp();
	}
	
	/*
	 * Añado los componentes del concesionaro del coche (parte 12)
	 */
	private void setComp() {
		frame=new JFrame(variables.Lenguaje.tituloConcesionario);
		panelGBC= new JPanel();
		panelBox=new JPanel();
		panelGBC.setLayout(new GridBagLayout());
		panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
		panelGBC.setBackground(new Color(255,255,255));
		panelBox.setBackground(new Color(255,255,255));
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
		
		b1=new JButton();
		b1.setIcon(getIconImage());//new ImageIcon(ConfigurationLoader.getImageIcon[0]);//cargamos la imagen en el singelton
		b1.setBackground(new Color(255,255,255));
		b1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		panelBox.add(b1);

		b2=new JButton();
		b2.setIcon(new ImageIcon("src/config/car/images/Mii_5P.jpeg"));//new ImageIcon(ConfigurationLoader.getImageIcon[0]);//cargamos la imagen en el singelton
		b2.setBackground(new Color(255,255,255));
		b2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		panelBox.add(b2);
		
		b3=new JButton("Coche3");
		panelBox.add(b3);
		
		b4=new JButton("Coche4");
		panelBox.add(b4);

		b5=new JButton("Coche5");
		panelBox.add(b5);
		
		b6=new JButton("Coche6");
		panelBox.add(b6);
		
		b7=new JButton("Coche7");
		panelBox.add(b7);
		
	//quitamos los insets y posicion
		constraints.insets=new Insets(0,0,0,0);//top, left, bottom, right
		constraints.gridheight=1;
		
		area=new JTextArea("<nombre> y sus cosas");
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
		areaInfo=new JTextArea();
		constraints.gridx=2;
		constraints.gridy=5;
		constraints.gridheight=2;
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
		frame.pack();
		frame.setVisible(true);
		
	}

	private Icon getIconImage() {
        Icon icon = new ImageIcon("src/config/car/images/Ateca.jpeg");
        return icon;
	}

}
