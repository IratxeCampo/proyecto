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


public class Login extends JFrame {
	
	private JTextField usuario;
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
		
//		panelContenido.setLayout();
//		posicionaLinea(panelContenido, "Nick: ", usuario);
//		posicionaLinea(panelContenido, "Password: ", contrase�a );
		
		panelContenido.add(new JLabel("Nick: "));
		panelContenido.add(usuario);
		panelContenido.add(new JLabel("Contrase�a: "));
		panelContenido.add(contraseña);
		panelContenido.add(registro);
		panelContenido.setAlignmentX(CENTER_ALIGNMENT);
		
		
		JTextField textUsuario =  new JTextField();
		textUsuario.setHorizontalAlignment(JTextField.CENTER);
		
		aceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(comprobarUsuario(usuario.getText(), contraseña.getPassword().toString())){
					System.out.println("contraseña correcta"); 
				} else {
					JLabel mensaje = new JLabel("Contraseña o usuario incorrecta!");
					panelContenido.add(mensaje);
				}
				
				
			}
			
		});
		cancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				
				
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
	
	
	public boolean comprobarUsuario(String usu, String con){
		if(usu.equals());
	}
	public void cargaUsuario(){
		
	}

	public static void main(String[] args) {
		Login v = new Login();
		v.setVisible(true);

	}

}
