package view_miglayout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Selection_Engine extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selection_Engine frame = new Selection_Engine();
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
	public Selection_Engine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSeleccionDeCaracteristicas = new JLabel("Seleccion de caracteristicas del modelo");
		lblSeleccionDeCaracteristicas.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.setLayout(new MigLayout("", "[200px][][200px][4px][200px][50px]", "[23px][40px][31px][100px][][]"));
		contentPane.add(lblSeleccionDeCaracteristicas, "cell 1 0,alignx right,aligny top");
		
		JList list = new JList();
		DefaultListModel modelo = new DefaultListModel(); // Sirve para introducir elementos de forma indirecta (Ej: Haciendo un bucle para añadir elementos).
		// Ejemplo para añadir contenido dentro del JList.
		for (int i = 1; i < 4; i++) {
			modelo.addElement("texto "+i);
		}
		// PARA AÑADIR CONTENIDO A LA LISTA DEBE SER CON STRINGS.
		list.setModel(modelo);
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(list, "cell 0 2 6 1,growx,aligny top");
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnAnterior, "cell 1 5,alignx left,aligny top");
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnSiguiente, "cell 2 5 3 1,alignx left,aligny top");
	}

}
