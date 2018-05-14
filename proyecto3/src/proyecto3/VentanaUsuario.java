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
		JTextField tContrase�a = new JTextField("Introducir contrase�a");
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		panel.add(tUsuario, BorderLayout.CENTER);
		panel.add(tContrase�a, BorderLayout.CENTER);
		tUsuario.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if (tUsuario.getText().equals("")){
				tUsuario.setText("");
				}				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				tUsuario.setText("");
				
			}
		});
	}
	public static void main(String[] args) {
		
	}
}
