package proyecto3;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;


import javax.swing.*;

import org.bson.Document;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;


public class Login extends JFrame {
	
	public JTextField usuario;
	private JPasswordField contraseña;
	private JList listaUsuarios;
	
	private void posicionaLinea(Container p, String etiqueta, Component campo){
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		tempPanel.add(new JLabel(etiqueta));
		tempPanel.add(campo);
		p.add(tempPanel);
	}
	
	public Login(){
		setSize(300,160);
		setTitle("Login");
		setLocation(400, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		usuario = new JTextField("" ,19);
		
		contraseña = new JPasswordField("", 15);
		listaUsuarios = new JList<>();
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		JButton registro = new JButton("Registrarse");
		JPanel panelSur = new JPanel();
		JPanel panelContenido = new JPanel();		
		getContentPane().add(panelContenido, BorderLayout.CENTER);
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout( new GridLayout(1,2));
		panelSur.add(aceptar);
		panelSur.add(cancelar);
		
		panelContenido.add(new JLabel("Nick: "));
		panelContenido.add(usuario);
		panelContenido.add(new JLabel("Contraseña: "));
		panelContenido.add(contraseña);
		panelContenido.add(registro);
		panelContenido.setAlignmentX(CENTER_ALIGNMENT);
		
		
		JTextField textUsuario =  new JTextField();
		textUsuario.setHorizontalAlignment(JTextField.CENTER);
		
		aceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				String cont = new String (contraseña.getPassword());
				String usu = usuario.getText();
				
				
				MongoDB mongo = new MongoDB();
				mongo.existeUsuario(usu, cont);					
			}
			
		});
		cancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal v = new VentanaPrincipal();
				v.setVisible(true);
				dispose();
				
				
				
			}
			
		});
		registro.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaUsuario usu = new VentanaUsuario();
				usu.setVisible(true);
				
			}
			
		});
		
	}
	public String getUsuario(){
		String tUsuario = usuario.getText();
		return tUsuario;
	}
	

	public static void main(String[] args) {
		Login v = new Login();
		v.setVisible(true);

	}

}
