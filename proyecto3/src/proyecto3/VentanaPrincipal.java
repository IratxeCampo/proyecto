package proyecto3;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		
		
		
		
		WindowAdapter teclado = new WindowAdapter(){
			
		};
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				
				int n = JOptionPane.showConfirmDialog(null,"�Seguro que quieres salir?", "Confirmar salida", JOptionPane.OK_CANCEL_OPTION);
				
				if (n==-1){
					JOptionPane.showMessageDialog(null, "De acuerdo\nHasta pronto"
							, "Mensaje de despedida",
							JOptionPane.INFORMATION_MESSAGE);
				}else if(n==0){
					JOptionPane.showMessageDialog(null, "De acuerdo\nHasta pronto"
							, "Mensaje de despedida",
							JOptionPane.INFORMATION_MESSAGE);

				}else{
					System.exit(n);
				}
					
					
				};
			
		});
		
		//getContentPane().add(panel, BorderLayout.CENTER);
		
		bUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login vent = new Login();
				vent.setVisible(true);
				
			}
		});
		
		bValorar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});	
		
	}
		public static void main(String[] args) {
	
			VentanaPrincipal e = new VentanaPrincipal();
			e.setVisible(true);
		}
		
}
