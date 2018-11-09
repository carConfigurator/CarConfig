package view_miglayout;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import config.ConfigurationLoader;
import idao.ILanguage;

public class JFrame extends javax.swing.JFrame {

	/**
	 * Create the frame.
	 */
	public JFrame() {}
	public void addFrame(ConfigurationLoader configLoad, JPanel panel, String title) {
		add(panel);
		setTitle(title);
		setIconImage(getIconImage(configLoad));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
//	public JFrame(ConfigurationLoader configLoad, JPanel panel, String title) {
//		add(panel);
//		setTitle(title);
//		setIconImage(getIconImage(configLoad));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(600,600);
//		pack();
//		setLocationRelativeTo(null);
//		setVisible(true);
//	}
//	//frame para añadir un menu
//	public JFrame(ConfigurationLoader configLoad, JMenuBar pMenu, JPanel panel, String title) {
//		setJMenuBar(pMenu);
//		add(panel);
//		setTitle(title);
//		setIconImage(getIconImage(configLoad));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(600,600);
//		pack();
//		setLocationRelativeTo(null);
//		setVisible(true);
//	}
	
	public void windowsListener(ILanguage language) {
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				int dialogButton = JOptionPane.showConfirmDialog(null, language.btnSaveInfo(), language.btnSaveInfo(), JOptionPane.YES_NO_CANCEL_OPTION);
				if(dialogButton == JOptionPane.YES_OPTION) {
					System.out.println("[INFO] - Guardando los datos del cliente...");
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else if(dialogButton == JOptionPane.NO_OPTION){
					System.out.println("[INFO] - No se guardarán los cambios...");
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else if(dialogButton == JOptionPane.CANCEL_OPTION){
					System.out.println("[INFO] - No se hará nada.");
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
	}
	
	/*
	 * Método que obtiene la imagen para el JFrame.
	 * @return La imagen que hay en carpeta.
	 * @see java.awt.Frame#getIconImage()
	 */
	private Image getIconImage(ConfigurationLoader configLoader) {
		File image = new File(configLoader.getIconImage());
        Image retValue = Toolkit.getDefaultToolkit().getImage(image.getAbsolutePath());
        return retValue;
    }

}
