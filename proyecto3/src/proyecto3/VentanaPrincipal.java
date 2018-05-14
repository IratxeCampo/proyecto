package proyecto3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
	public VentanaPrincipal() {
		setTitle( "Valortel" );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 640, 400 );
		setLocationRelativeTo( null );
		JTextArea n = new JTextArea();
		JButton bUsuario = new JButton("Introducir usuario");
		JButton bValorar = new JButton("Valoraci�n de hoteles");
		JPanel panel = new JPanel();
		getContentPane().setLayout(new GridLayout(2,1));
		getContentPane().add(bUsuario);
		getContentPane().add(bValorar);
		//getContentPane().add(panel, BorderLayout.CENTER);
		
		bUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaUsuario vent = new VentanaUsuario();
				vent.setVisible(true);
				
			}
		});
			
		
	}
		public static void main(String[] args) {
			VentanaPrincipal e = new VentanaPrincipal();
			e.setVisible(true);
		}
		
}