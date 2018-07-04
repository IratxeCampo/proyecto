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
	
	private JTextField usuario;
	private JPasswordField contrasena;
	private String[] listaUsuarios = {"Hotel", "Usuario", "Administrador"};
	
	private void posicionaLinea(Container p, String etiqueta, Component campo){
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		tempPanel.add(new JLabel(etiqueta));
		tempPanel.add(campo);
		p.add(tempPanel);
	}
	
	public Login(){
		setSize(300,250);
		setTitle("Login");
		setLocation(400, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		usuario = new JTextField("" ,19);
		contrasena = new JPasswordField("", 15);
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		JButton registro = new JButton("Registrarse");
		JComboBox<String> cbUsuarios = new JComboBox<String>(listaUsuarios);
		JPanel panelSur = new JPanel();
		JPanel panelContenido = new JPanel();		
		
		panelSur.setLayout( new GridLayout(1,2));
		panelSur.add(aceptar);
		panelSur.add(cancelar);
		
		panelContenido.add(new JLabel("Nick: "));
		panelContenido.add(usuario);
		panelContenido.add(new JLabel("Contraseña: "));
		panelContenido.add(contrasena);
		panelContenido.add(new JLabel("Tipo de usuario: "));
		panelContenido.add(cbUsuarios);
		panelContenido.add(registro);
		panelContenido.setAlignmentX(CENTER_ALIGNMENT);
		
		getContentPane().add(panelContenido, BorderLayout.CENTER);
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JTextField textUsuario =  new JTextField();
		textUsuario.setHorizontalAlignment(JTextField.CENTER);
		
		aceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				String cont = new String (contrasena.getPassword());
				String usu = usuario.getText();
				
					MongoDB mongo = new MongoDB();
					mongo.conexion();
					mongo.existeUsuario(usu, cont);					
			}
			
		});
		cancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				 
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
		
		cbUsuarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cont = new String (contrasena.getPassword());
				String usu = usuario.getText();
				
				if(comprobarContr(usu,cont) && comprobarUsu(usu, cont) && cbUsuarios.getSelectedItem().equals("Hotel")){
					VentanaHotel vh = new VentanaHotel();
					vh.setVisible(true);
				} else if (comprobarContr(usu,cont) && comprobarUsu(usu, cont) && cbUsuarios.getSelectedItem().equals("Usuario")){
					VentanaUsuario vu = new VentanaUsuario();
					vu.setVisible(true);
				} else if (comprobarContr(usu,cont) && comprobarUsu(usu, cont) && cbUsuarios.getSelectedItem().equals("Administrador"));
					VentanaAdmin va = new VentanaAdmin();
					va.setVisible(true);
			}
		});
		
	}

	
	
	public boolean comprobarContr(String usu, String contr){
		boolean isContraTrue=false;
		MongoDB base = new MongoDB();
		base.reiniciarMongo();
		base.conexion();
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("aplicacion");
		
		FindIterable<Document> iterableContra = db.getCollection("usuarios").find(
		        new Document("password", contr));
		
		
		if(iterableContra!=null){
			iterableContra.forEach(new Block<Document>(){

			@Override
			public void apply(Document doc) {
				System.out.println(doc.get("password"));
				
			}
			
		});
				JOptionPane.showMessageDialog(null, "Existe");
				isContraTrue=true;
			
		}else{
			JOptionPane.showMessageDialog(null, "No Existe");
			isContraTrue=false;
		}
		iterableContra.forEach(new Block<Document>() {
			boolean isTrue=false;
		    @Override
		    public void apply(final Document document) {
		    	if (document.get("password")==contr) {
					JOptionPane.showMessageDialog(null, "Funciona");
					isTrue=true;
					
				}else{
					JOptionPane.showMessageDialog(null, "No Funciona");
					isTrue=false;
				}
		        
		    }
		});
		
		return isContraTrue;
		
	}
	public boolean comprobarUsu(String usuario, String contr){
		boolean isUsuarioTrue=false;
		MongoDB base = new MongoDB();
		base.reiniciarMongo();
		base.conexion();
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("aplicacion");
		
		FindIterable<Document> iterableUsu = db.getCollection("usuarios").find(
		        new Document("nick", usuario));
		FindIterable<Document> iterableContr = db.getCollection("usuarios").find(
		        new Document("password", contr));
		iterableUsu.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		    	if(document.containsKey(usuario)){
		    		
		    	}else if(document.size()==0){
		    		
		    	}
		    	
		        System.out.println(document.get("password"));
		    }
		});
		iterableContr.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		    	if(document.containsKey(contr)){
		    		
		    	}
		    	
		        System.out.println(document.get("password"));
		    }
		});
		mongoClient.close();
		
		
		if(usuario.length()==3){
			if(usuario.equals(3)){
				
				return isUsuarioTrue=true;
			}
		}else{
			
			return isUsuarioTrue=false;
		}return isUsuarioTrue;
	}
	

	public static void main(String[] args) {
		Login v = new Login();
		v.setVisible(true);

	}

}
