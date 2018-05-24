package proyecto3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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

		JTextField tContrasena = new JTextField("Introducir contrasena");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		

		panel.add(tContrasena, BorderLayout.CENTER);

		tUsuario.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if (tUsuario.getText().equals("")){
				tUsuario.setText("Introducir nick");
				}				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				tUsuario.setText("");
				
			}
		});

		tContrasena.addFocusListener(new FocusListener() {

			
			@Override
			public void focusLost(FocusEvent arg0) {

				if (tContrasena.getText().equals("")){
				tContrasena.setText("Introducir contrasena");

				}				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {

				tContrasena.setText("");

				
			}
		});
	}
	public static void main(String[] args) {
		VentanaUsuario u = new VentanaUsuario();
		u.setVisible(true);
	}
}
