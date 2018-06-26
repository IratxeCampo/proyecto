package proyecto3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaUsuario extends JFrame {
	public VentanaUsuario() {
		setTitle( "Valortel" );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 380, 180 );
		setLocationRelativeTo( null );
		JTextField tUsuario = new JTextField("Introducir nick");
		JTextField tContrasena = new JTextField("Introducir contrasenya");
		JTextField trContrasena = new JTextField("Repetir contrasenya");
		JTextField tEmail = new JTextField("Introducir email");
		JTextField tEdad = new JTextField("Introducir edad");
		JButton bGuardar = new JButton("Guardar");
		bGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nick = tUsuario.getText();
				String contrasenya = tContrasena.getText();
				String edad = tEdad.getText();
				String email = tEmail.getText();
				MongoDB mongo = new MongoDB();
				mongo.insertUser(nick, contrasenya, email, edad);
				
				
			}
		});
		JButton bCancelar = new JButton("Cancelar");
		JPanel panel2 = new JPanel();
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(panel2, BorderLayout.SOUTH);
		panel.add(new JLabel("Nick: "));
		panel.add(tUsuario, BorderLayout.CENTER);
		panel.add(new JLabel("Contrasenya: "));
		panel.add(tContrasena, BorderLayout.CENTER);
		panel.add(new JLabel("Repetir contrasenya: "));
		panel.add(trContrasena, BorderLayout.CENTER);
		panel.add(new JLabel("Email: "));
		panel.add(tEmail, BorderLayout.SOUTH);
		panel.add(new JLabel("Edad: "));
		panel.add(tEdad, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(5,2));
		panel2.setLayout(new GridLayout(1,2));
		panel2.add(bGuardar);
		panel2.add(bCancelar);

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
				tContrasena.setText("Introducir contrasenya");

				}				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {

				tContrasena.setText("");

				
			}
		});
		trContrasena.addFocusListener(new FocusListener() {

			
			@Override
			public void focusLost(FocusEvent arg0) {

				if (trContrasena.getText().equals("")){
				trContrasena.setText("Repetir contrasenya");

				}				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {

				trContrasena.setText("");

				
			}
		});
		
		tEmail.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if (tEmail.getText().equals("")){
				tEmail.setText("Introducir email");
				}				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				tEmail.setText("");
				
			}
		});
		tEdad.addFocusListener(new FocusListener() {
	
			@Override
			public void focusLost(FocusEvent arg0) {
				if (tEdad.getText().equals("")){
				tEdad.setText("Introducir edad");
				}				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				tEdad.setText("");
				
			}
		});
		bCancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
			
		});
	}
public static void main(String[] args) {
	VentanaUsuario u = new VentanaUsuario();
	u.setVisible(true);
}	
}
