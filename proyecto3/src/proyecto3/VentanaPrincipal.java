package proyecto3;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
	public VentanaPrincipal() {
		setTitle( "Valortel" );
		setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
		setSize( 640, 400 );
		setLocationRelativeTo( null );
		JTextArea n = new JTextArea();
		JButton bUsuario = new JButton("Introducir usuario");
		JButton bValorar = new JButton("Valoración de hoteles");
		JPanel panel = new JPanel();
		getContentPane().setLayout(new GridLayout(2,1));
		getContentPane().add(bUsuario);
		getContentPane().add(bValorar);
		
		
		WindowAdapter teclado = new WindowAdapter(){
			
		};
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				
				final ImageIcon icon = new ImageIcon(getClass().getResource("adios.gif"));

				int n = JOptionPane.showConfirmDialog(null,"Seguro que quieres salir?", "Confirmar salida", JOptionPane.OK_CANCEL_OPTION);	
				
				if (n==-1){

					JOptionPane.showMessageDialog(null, "De acuerdo\nHasta pronto"
							, "Mensaje de despedida",
							JOptionPane.QUESTION_MESSAGE, icon);
					System.exit(n);
					//dispose();
				}else if(n==0){
			
					JOptionPane.showMessageDialog(null, "De acuerdo\nHasta pronto"
							, "Mensaje de despedida",
							JOptionPane.INFORMATION_MESSAGE, icon);
					System.exit(n);
				}else{
					
				}
				
			};
		});
	
		
		//getContentPane().add(panel, BorderLayout.CENTER);
		
		bUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login vent = new Login();
				vent.setVisible(true);
				dispose();
			}
		});
		
		bValorar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaValoraciones vv = new VentanaValoraciones();
				vv.setVisible(true);
				
				
			}
		});	
		
	}
		public static void main(String[] args) {
	
			VentanaPrincipal e = new VentanaPrincipal();
			e.setVisible(true);
		}
		
}
