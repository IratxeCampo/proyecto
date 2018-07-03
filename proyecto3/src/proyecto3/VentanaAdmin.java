package proyecto3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.sun.javafx.runtime.async.AsyncOperationListener;

public class VentanaAdmin extends JFrame{

	private static final long serialVersionUID = -4259920324098726336L;

	public VentanaAdmin() {
		setTitle("Ventana del administrador");
		setSize(900, 700);
		setLocation(500, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panelCentral = new JPanel();
		
		ArrayList<String> lista = new ArrayList<>();
		JList<String> lHoteles = new JList<>(VentanaValoraciones.obtenerHoteles(lista));
		
		
	//	ArrayList<String> arrayO = new ArrayList<>();
		ArrayList<String> opis = new ArrayList<>(obtenerOpiniones(lista));
		JList lOpiniones = new JList(opis.toArray());
		
	//	ArrayList<String> usus = new ArrayList<>();
		ArrayList<String> lUsuarios = new ArrayList<>(obtenerUsuarios(lista));
		JList list = new JList(lUsuarios.toArray());
		
		JScrollPane spHoteles = new JScrollPane(lHoteles);
		spHoteles.setPreferredSize(new Dimension(300, 100));
		JScrollPane spOpiniones = new JScrollPane(lOpiniones);
		spOpiniones.setPreferredSize(new Dimension(300, 100));
		JScrollPane spUsuarios = new JScrollPane(list);
		spUsuarios.setPreferredSize(new Dimension(300, 100));
		
		panelCentral.add(spHoteles);
		panelCentral.add(spOpiniones);
		panelCentral.add(spUsuarios);
		
		panelCentral.setLayout(new GridLayout(1, 3));
		
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		
	}
	
	public ArrayList<String> obtenerUsuarios(ArrayList<String> lista){
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("aplicacion");
		
		FindIterable<Document> iterable = db.getCollection("usuarios").find();
		
		iterable.forEach(new Block<Document>() {
			@Override
			public void apply(final Document document){
				lista.add(document.get("nick").toString());
			}
		});
		mongoClient.close();
		return lista;
	}
	
	public ArrayList<String> obtenerOpiniones(ArrayList<String> lista){
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("aplicacion");
		
		FindIterable<Document> iterable = db.getCollection("usuarios").find();
		
		iterable.forEach(new Block<Document>() {
			@Override
			public void apply(final Document document){
				lista.add(document.get("opinion").toString());
			}
		});
		mongoClient.close();
		return lista;
	}
	
	public static void main(String[] args){
		VentanaAdmin va = new VentanaAdmin();
		va.setVisible(true);
	}

}