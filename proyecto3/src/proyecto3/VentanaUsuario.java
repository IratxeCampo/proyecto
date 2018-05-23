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
				tUsuario.setText("Introducir nick");
				}				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				tUsuario.setText("");
				
			}
		});
		tContrase�a.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if (tContrase�a.getText().equals("")){
				tContrase�a.setText("Introducir contrase�a");
				}				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				tContrase�a.setText("");
				
			}
		});
	}
	public static void main(String[] args) {
		VentanaUsuario u = new VentanaUsuario();
		u.setVisible(true);
	}
}
