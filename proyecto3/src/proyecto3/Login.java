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
		panelContenido.add(new JLabel("Contraseña: "));
		panelContenido.add(contraseña);
		panelContenido.add(registro);
		panelContenido.setAlignmentX(CENTER_ALIGNMENT);
		
		
		JTextField textUsuario =  new JTextField();
		textUsuario.setHorizontalAlignment(JTextField.CENTER);
		
		aceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//comprobarUsu(usuario.getText())&&
				String cont = new String (contraseña.getPassword());
				String usu = usuario.getText();
				
				
					MongoDB mongo = new MongoDB();
					mongo.conexion();
					mongo.existeUsuario(usu, cont);	
					
				
//					textUsuario.setText("");
//					contraseña.setText("");
				
				
//				
//				mongo.existeUsuario(usu);
//				mongo.recuperarContraseña(usu, cont);
//				System.out.println(cont);
				
//				if(true){
//					System.out.println("Datos correctos"); 
//				} else {
//					JLabel mensaje = new JLabel("¡Contraseña o usuario incorrecta!");
//					panelContenido.add(mensaje);
//				}
				
				
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
	
//	public boolean comprobarContr(String usu, String contr){
//		boolean isContraTrue=false;
//		MongoDB base = new MongoDB();
//		base.reiniciarMongo();
//		base.conexion();
//		MongoClient mongoClient = new MongoClient();
//		MongoDatabase db = mongoClient.getDatabase("aplicacion");
//		
//		FindIterable<Document> iterableContra = db.getCollection("usuarios").find(
//		        new Document("password", contr));
//		
//		
//		if(iterableContra!=null){
//			iterableContra.forEach(new Block<Document>(){
//
//			@Override
//			public void apply(Document doc) {
//				System.out.println(doc.get("password"));
//				
//			}
//			
//		});
//				JOptionPane.showMessageDialog(null, "Existe");
//				isContraTrue=true;
//			
//		}else{
//			JOptionPane.showMessageDialog(null, "No Existe");
//			isContraTrue=false;
//		}
//		iterableContra.forEach(new Block<Document>() {
//			boolean isTrue=false;
//		    @Override
//		    public void apply(final Document document) {
//		    	if (document.get("password")==contr) {
//					JOptionPane.showMessageDialog(null, "Funciona");
//					isTrue=true;
//					
//				}else{
//					JOptionPane.showMessageDialog(null, "No Funciona");
//					isTrue=false;
//				}
//		        
//		    }
//		});
//		
//		return isContraTrue;
//		
//	}
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
	
	
	public void cargaUsuario(){
		
	}

	public static void main(String[] args) {
		Login v = new Login();
		v.setVisible(true);

	}

}
