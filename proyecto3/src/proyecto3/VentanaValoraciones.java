package proyecto3;

import java.awt.*;
import javax.swing.*;


import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class VentanaValoraciones extends JFrame{
	
	public VentanaValoraciones(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000, 800);
		setLocationRelativeTo(null);
		
		JLabel lHoteles = new JLabel("  Selecciona un hotel: ");
		ArrayList<String> arHotel = new ArrayList<String>();
		String[] listaHotel = obtenerHoteles(arHotel);
		JComboBox<String> cbHoteles = new JComboBox<String>(listaHotel);
		
		JLabel lPaises = new JLabel("  Busqueda por paises: ");
		ArrayList<String> arPais = new ArrayList<String>();
		String[] listaPais = obtenerPaises(arPais);
		JComboBox<String> cbPaises = new JComboBox<String>(listaPais);
		
		JLabel lCiudades = new JLabel("  Busqueda por ciudades: ");
		ArrayList<String> arCiudad = new ArrayList<String>();
		String[] listaCiudad = obtenerCiudades(arCiudad);
		JComboBox<String> cbCiudades = new JComboBox<>(listaCiudad);
		
		JTextArea taOpiniones = new JTextArea(70, 80);
		JSlider slider = new JSlider(0,100,0);
		slider.setMajorTickSpacing(50);
		slider.setFont(new Font("serif", Font.ITALIC, 12));
		slider.setPaintLabels(true);
		
		JPanel pCentral = new JPanel();
		JPanel pSuperior = new JPanel();
		pSuperior.setLayout(new GridLayout(3, 2));
		pSuperior.add(lPaises);
		pSuperior.add(cbPaises);
		pSuperior.add(lCiudades);
		pSuperior.add(cbCiudades);
		pSuperior.add(lHoteles);
		pSuperior.add(cbHoteles);
		pCentral.add(slider, BorderLayout.WEST);
		pCentral.add(new JScrollPane(taOpiniones), BorderLayout.EAST);
		getContentPane().add(pSuperior, BorderLayout.NORTH);
		getContentPane().add(pCentral, BorderLayout.CENTER);
		
		JList<String> lOpiniones;
		String[] opis = {"Muy buena comida", "Muy atentos"};
	    Vector<String> vOpiniones = new Vector<>(Arrays.asList(opis));
		DefaultListModel<String> mOpiniones = new DefaultListModel<>();
		for (String n : opis) mOpiniones.addElement(n);
		vOpiniones.add("Muy buena comida");
		lOpiniones = new JList<String>(mOpiniones);
		
//		DefaultComboBoxModel<String> datos = new DefaultComboBoxModel<>(hoteles);
//		cHoteles.setModel(datos);
//		datos.addElement("Plaza");
		
		cbHoteles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				taOpiniones.setText("Valoraciones: ");
				if(cbHoteles.getSelectedItem().equals("Hilton")){
					taOpiniones.append("\n" + mOpiniones.getElementAt(0));
				} else if(cbHoteles.getSelectedItem().equals("HolidayInn")) {
					taOpiniones.append("\n" + mOpiniones.getElementAt(1));
				}
					
			}
		});
		cbCiudades.addActionListener(new ActionListener() {
			//JComboBox<String> datosHoteles = new JComboBox<String>();
			//ArrayList<String> c = 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		cbPaises.addActionListener(new ActionListener() {
			
			ArrayList<String> c = new ArrayList<String>();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pSuperior.getComponent(3).setVisible(false);
			//	cbCiudades = new JComboBox<>(Ciudad(cbPaises.getSelectedItem().toString(), c));
			//	pSuperior.add(cbCiudades, 3).setVisible(true);
				String[] listaCiudad2 = Ciudad(c, cbPaises.getSelectedItem().toString());
				JComboBox<String> cbCiudades2 = new JComboBox<>(listaCiudad2);
				pSuperior.add(cbCiudades2).setVisible(true);;
				
			}
		});
	}
	
	
	public String[] obtenerHoteles(ArrayList<String> h){
		Neo4j("Hoteles", h, "");
		return h.toString().split(",");
	}
	
	public String[] obtenerPaises(ArrayList<String> p){
		Neo4j("Paises", p, "");
		return p.toString().split(",");
	}

	public String[] obtenerCiudades(ArrayList<String> c){
		Neo4j("Ciudades", c, "");
		return c.toString().split(",");
	}
	
	public String[] Ciudad(ArrayList<String> ciudades, String c){
		Neo4j("Ciudades", ciudades, c);
		return ciudades.toString().split(",");
		/*
		try {
			Class.forName("org.neo4j.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:neo4j:http://localhost:7474", "neo4j", "1234");
			
			Statement stmt = con.createStatement();
			ResultSet rs = null;
			
			rs = stmt.executeQuery("MATCH (c:Ciudad)-[:UBICADA]->(p:Pais) WHERE p.name=\""+dato+ "\"RETURN c");
			
			
			while(rs.next()){
				ciudades.add(rs.getString("c").substring(9, rs.getString("c").length()-2));
				return ciudades.toString().split(",");
			}
		
			System.out.println(ciudades.add(rs.getString("c").substring(9, rs.getString("c").length()-2)));
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;*/
	}

	public void Neo4j(String dato, ArrayList<String> hoteles, String s){
		
		try{
			
			Class.forName("org.neo4j.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:neo4j:http://localhost:7474", "neo4j", "1234");
			
			Statement stmt = con.createStatement();
			ResultSet rs = null;
			
			if (dato=="Hoteles"){
				rs = stmt.executeQuery("MATCH (n:Hotel) RETURN n");
				
				while(rs.next()){
					hoteles.add(rs.getString("n").substring(9, rs.getString("n").length()-2));
				}
				
			} else if (dato=="Paises" ){
				rs = stmt.executeQuery("MATCH (n:Pais) return n");
				
				while(rs.next()){
					hoteles.add(rs.getString("n").substring(9, rs.getString("n").length()-2));
				}
				
			} else if (dato=="Ciudades" && s.equals("")){
				rs = stmt.executeQuery("MATCH (n:Ciudad) return n");
				
				while(rs.next()){
					hoteles.add(rs.getString("n").substring(9, rs.getString("n").length()-2));
				}
			} else if (dato=="Ciudades" && s.length()>0){
				rs = stmt.executeQuery("MATCH (c:Ciudad)-[:UBICADA]->(p:Pais) WHERE p.name=\""+s+ "\"RETURN c");
				
				while(rs.next()){
					hoteles.add(rs.getString("n").substring(9, rs.getString("n").length()-2));
				}
				
			} else if (dato=="Capital"){
				rs = stmt.executeQuery("MATCH p=()-[r:CAPITAL]->() RETURN p");
			} else if (dato=="Reservas"){
				rs = stmt.executeQuery("MATCH (n:Persona)-[:RESERVA]->(h:Hotel) return n,h");
			} else if (dato=="PaisYCiudad"){
				rs = stmt.executeQuery("MATCH (c:Ciudad)-[:UBICADA]->(p:Pais) WHERE p.name=[1] RETURN c");
			}
			
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	
	public static void main(String[] args){
		VentanaValoraciones v = new VentanaValoraciones();
		v.setVisible(true);
	}

}
