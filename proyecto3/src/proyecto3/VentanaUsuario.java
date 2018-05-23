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
		JTextField tContraseña = new JTextField("Introducir contraseña");
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		panel.add(tUsuario, BorderLayout.CENTER);
		panel.add(tContraseña, BorderLayout.CENTER);
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
		tContraseña.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if (tContraseña.getText().equals("")){
				tContraseña.setText("Introducir contraseña");
				}				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				tContraseña.setText("");
				
			}
		});
	}
	public static void main(String[] args) {
		VentanaUsuario u = new VentanaUsuario();
		u.setVisible(true);
	}
}
