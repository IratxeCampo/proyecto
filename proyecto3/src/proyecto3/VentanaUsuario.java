package proyecto3;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaUsuario extends JFrame {
	public VentanaUsuario() {
		setTitle( "Valortel" );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 640, 400 );
		setLocationRelativeTo( null );
		JTextField tUsuario = new JTextField("Introducir nick");
		JTextField tContraseña = new JTextField("Introducir contraseña");
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		panel.add(tUsuario, BorderLayout.CENTER);
		panel.add(tContraseña, BorderLayout.CENTER);
		
	}
	public static void main(String[] args) {
		
	}
}
