package proyecto3;

import java.awt.*;
import javax.swing.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class VentanaValoraciones extends JFrame{
	
	private static final long serialVersionUID = 7294056902574858093L;


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
		JLabel lSlider = new JLabel("Valoración general: ");
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
		pCentral.add(lSlider);
		pCentral.add(slider, BorderLayout.WEST);
		pCentral.add(new JScrollPane(taOpiniones), BorderLayout.EAST);
		getContentPane().add(pSuperior, BorderLayout.NORTH);
		getContentPane().add(pCentral, BorderLayout.CENTER);
		
		
//		DefaultComboBoxModel<String> datos = new DefaultComboBoxModel<>(hoteles);
//		cHoteles.setModel(datos);
//		datos.addElement("Plaza");
		
		cbHoteles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				taOpiniones.setText("Valoraciones: ");
				
				if(cbHoteles.getSelectedItem().equals("[Skyna Luanda")){
					taOpiniones.append("\n\nEneko: ");
					taOpiniones.append("\nEs un sitio muy agradable y muy relajante el personal es muy "
									+ "atento y servicial,nosotros somos repetidores van ya 5 estancias es genial.");
					taOpiniones.append("\n\nAnder: ");
					taOpiniones.append("\nMaravilloso, sublime, espectacular.");
					slider.setValue(85);
					
				} else if(cbHoteles.getSelectedItem().equals(" Accra")) {
					taOpiniones.append("\n\nMikel: ");
					taOpiniones.append("\nUn hotel de lujo en el centro de Accra que, además de la comodidad y limpieza de las habitaciones y la calidad del descanso, cuenta con un buen buffet que mezcla platos europeos con sabores locales; la repostería es muy destacable. "
							+ "\nComo curiosidad,el hotel muestra en sus pasillos y paredes esculturas y pinturas de autores locales muy sobresalientes.");
					slider.setValue(89);
				} else if(cbHoteles.getSelectedItem().equals(" Reefs")){
					taOpiniones.append("\n\nMikel: ");
					taOpiniones.append("\nLa estancia fue correcta. \nQuizas esperaba algo mas por los comentarios"
							+ " que encontre antes de reservarlo pero lo que indicaba lo ofrecia, no mas ni menos.");
					slider.setValue(86);
				} else if(cbHoteles.getSelectedItem().equals(" Sakkara Inn")){
					taOpiniones.append("\n\nJon");
					taOpiniones.append("\nEs un hotel normal y a precio razonable, mi pareja y yo solo lo "
									+ "utilizábamos para ir a dormir ya que no buscábamos otra funcionalidad. \nLo "
									+ "que deberían hacer es cambiar las almohadas y poner unas más duras, por lo"
									+ " demás es estupendo.");
					slider.setValue(77);
				} else if(cbHoteles.getSelectedItem().equals(" Sea Gull Hurghada")){
					taOpiniones.append("\n\nMaialen");
					taOpiniones.append("\nEs un hotel excelentemente situado, con una recepción "
								+ "muy agradable y un bar muy luminoso donde se pueden tomar buenos"
								+ " cocktails. \nLas habitaciones son un tanto antiguas y no se corresponden a la"
								+ " imagen de la entrada.");
					slider.setValue(91);
				} else if(cbHoteles.getSelectedItem().equals(" Grand Oasis")){
					taOpiniones.append("\n\nMaddi");
					taOpiniones.append("\nBuena atención , buen servicio, habitación "
							+ "confortable y con todo lo necesario para que la estancia sea lo más "
							+ "agradable posible.");
					slider.setValue(81);
				} else if(cbHoteles.getSelectedItem().equals(" Tranquility Bay")){
					taOpiniones.append("\n\nAsier");
					taOpiniones.append("\nLa atención del personal del hotel excelente y la habitación"
							+ " limpia y correcta. \nBuena insonorizacion de la habitación que garantiza buen "
							+ "descanso. Lo unico malo es que el hotel no dispone de parking propio");
					slider.setValue(79);
				} else if(cbHoteles.getSelectedItem().equals(" Sunshine Suites")){
					taOpiniones.append("\n\nMaite");
					taOpiniones.append("\nPara ser un hotel con buena ubicación y lindo la atención deja mucho que "
							+ "desear poco o nada de servicio poco personal a pesar de estar pronto al carnaval..."
							+ " esperaba mucho más. \nUn desayuno con pocas cosas pocas frutas tres y nada de buenas "
							+ "sólo jugo de naranja esperaba probar mucho mas de las frutas de aca . "
							+ "\nSólo un tipo de pan de molde en fin nada acordé al precio pagado");
					slider.setValue(68);
				} else if(cbHoteles.getSelectedItem().equals(" East Winds Inn")){
					taOpiniones.append("\n\nAitor");
					taOpiniones.append("\nLas comodidades e instalaciones son poco acogedoraspara un hotel de lujo,"
							+ " especialmente la habitación poco acogedora el conjunto muy impersonal demasiados"
							+ " espacios vacíos clima un poco frío en la habitación");
					slider.setValue(73);
				} else if(cbHoteles.getSelectedItem().equals(" The Buccaneer")){
					taOpiniones.append("\n\nAne");
					taOpiniones.append("\nEl hotel muy bonito pero incómodo, la "
							+ "habitación es hermosa pero la cama doble es pequeña y el baño regular.");
					slider.setValue(79);
				} else if(cbHoteles.getSelectedItem().equals(" Posada Viena")){
					taOpiniones.append("\n\nAmaia");
					taOpiniones.append("\nEl hotel en si esta bastante bien, pero esta mal explotado... "
							+ "la comida para la categoria que es , y la variedad deja mucho que desear");
					slider.setValue(76);
				} else if(cbHoteles.getSelectedItem().equals(" Crowne Plaza")){
					taOpiniones.append("\n\nUnai");
					taOpiniones.append("\nGrandes instalaciones, pero lo mejor fue el trato que recibimos de "
							+ "todo el personal, un 10, en recepción una esmerada atención, y el personal del "
							+ "comedor y limpieza siempre con una sonrisa en la cara. \nCelebraba mi cumpleaños y"
							+ " recibí un buen detalle en la habitación");
					slider.setValue(95);
				} else if(cbHoteles.getSelectedItem().equals(" Robin´s Nest")){
					taOpiniones.append("\n\nGarazi");
					taOpiniones.append("\nAgradable estancia en un hotel bien ubicado y confortable.");
					slider.setValue(82);
				} else if(cbHoteles.getSelectedItem().equals(" Edgewater")){
					taOpiniones.append("\n\nAna");
					taOpiniones.append("\nTodo fabuloso. La única pega es que la piscina "
							+ "infantil está muy fria y a consecuencia estaba totalmente vacía.");
					slider.setValue(86);
				} else if(cbHoteles.getSelectedItem().equals(" Deerwood Inn")){
					taOpiniones.append("\n\nAinhoa");
					taOpiniones.append("\nConfortable hotel con todos los servicios. Buenas y modernas "
							+ "instalaciones. \nExquisita atención y trato personal. Restaurante buffet con "
							+ "calida. Situado en una zona centrica de la isla., muy turística.");
					slider.setValue(89);
				} else if(cbHoteles.getSelectedItem().equals(" French Market Inn")){
					taOpiniones.append("\n\nAnder");
					taOpiniones.append("\nMi estancia en el hotel es positiva, muy céntrico, el personal del h"
							+ "otel muy agradable y muy predispuesto a ayudar. 100% recomendable.");
					slider.setValue(96);
				}
					
			}
		});
		cbCiudades.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbCiudades.getSelectedItem().equals(" [Luanda")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Skyna Luanda", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Giza")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Sakkara Inn", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Hurghada")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Sea Gull Hurghada", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Sharm El Sheikh")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Grand Oasis", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Bolans")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Tranquility Bay", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Rockley")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Accra", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Safehaven")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Sunshine Suites", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Gros Islet")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" East Winds Inn", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Christiansted")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" The Buccaneer", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Mexico City")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Posada Viena", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Pembroke")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Robin´s Nest", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Southhampton")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Reefs", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Whitehorse")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Edgewater", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Madison")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Deerwood Inn", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Chicago")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Red Roof Inn", 0);
				} else if (cbCiudades.getSelectedItem().equals(" New Orleans")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" French Market Inn", 0);
				} else if (cbCiudades.getSelectedItem().equals(" West Monroe")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Best Western Inn", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Chengdu")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Crowne Plaza", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Abu Dhabi")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Jumeirah at Etihad Towers Residence", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Dubai")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Jumeirah Zabeel Saray", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Londonderry")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Victoria Gate", 0);
				}  else if (cbCiudades.getSelectedItem().equals(" London")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Boston Court", 0);
					cbHoteles.insertItemAt(" Batty Langley´s", 1);
				} else if (cbCiudades.getSelectedItem().equals(" Alsager")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Mere Cottage", 0);
				} else if (cbCiudades.getSelectedItem().equals(" Hounslow")){
					cbHoteles.removeAllItems();
					cbHoteles.insertItemAt(" Renaissance London Heathrow", 0);
				} 
				
			}
		});
		
		
		cbPaises.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbPaises.getSelectedItem().equals("[Angola")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Luanda", 0);
				} else if(cbPaises.getSelectedItem().equals(" Egypt")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Sharm El Sheikh", 0);
					cbCiudades.insertItemAt(" Hurghada", 1);
					cbCiudades.insertItemAt(" Giza", 2);
				} else if(cbPaises.getSelectedItem().equals(" Antigua and Barbuda")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Bolans", 0);
				} else if(cbPaises.getSelectedItem().equals(" Barbados")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Rockley", 0);
				} else if(cbPaises.getSelectedItem().equals(" Cayman Islands")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Safehaven", 0);
				} else if(cbPaises.getSelectedItem().equals(" Saint Lucia")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Gros Islet", 0);
				} else if(cbPaises.getSelectedItem().equals(" U.S. Virgin Islands")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Christiansted", 0);
				} else if(cbPaises.getSelectedItem().equals(" Mexico")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Mexico City", 0);
				} else if(cbPaises.getSelectedItem().equals(" Bermuda")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Southhampton", 0);
					cbCiudades.insertItemAt(" Pembroke", 1);
				} else if(cbPaises.getSelectedItem().equals(" Canada")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Whitehorse", 0);
				} else if(cbPaises.getSelectedItem().equals(" United Sates")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" West Monroe", 0);
					cbCiudades.insertItemAt(" New Orleans", 1);
					cbCiudades.insertItemAt(" Chicago", 2);
					cbCiudades.insertItemAt(" Madison", 3);
				} else if(cbPaises.getSelectedItem().equals(" China")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Chengdu", 0);
				} else if(cbPaises.getSelectedItem().equals(" United Arab Emirates")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Abu Dhabi", 0);
					cbCiudades.insertItemAt(" Dubai", 1);
				} else if(cbPaises.getSelectedItem().equals(" United Kingdom")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Malvern", 0);
					cbCiudades.insertItemAt(" Alsager", 1);
					cbCiudades.insertItemAt(" Hounslow", 2);
					cbCiudades.insertItemAt(" Londonderry", 3);
					cbCiudades.insertItemAt(" London", 4);
				} else if(cbPaises.getSelectedItem().equals(" Ireland")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Castlebar", 0);
				} else if(cbPaises.getSelectedItem().equals(" Italy")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Tramin an der WeinstraBe", 0);
					cbCiudades.insertItemAt(" Paganico", 1);
				} else if(cbPaises.getSelectedItem().equals(" Portugal")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Angra do Heroismo", 0);
					cbCiudades.insertItemAt(" Funchal", 1);
					cbCiudades.insertItemAt(" Povoa de Varzim", 2);
					cbCiudades.insertItemAt(" Porto", 3);
					cbCiudades.insertItemAt(" Albufeira", 4);
					cbCiudades.insertItemAt(" Vidago", 5);
					cbCiudades.insertItemAt(" Cascais", 6);
					cbCiudades.insertItemAt(" Oliveira de Azemeis", 7);
					cbCiudades.insertItemAt(" Lisboa", 8);
					cbCiudades.insertItemAt(" Fatima", 9);
				} else if(cbPaises.getSelectedItem().equals(" Austria")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Kals", 0);
					cbCiudades.insertItemAt(" Markt Allhau", 1);
					cbCiudades.insertItemAt(" Saalbach-Hinterglemm", 2);
					cbCiudades.insertItemAt(" Zell", 3);
				} else if(cbPaises.getSelectedItem().equals(" Switzerland")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Stein", 0);
					cbCiudades.insertItemAt(" Twann", 1);
					cbCiudades.insertItemAt(" Verbier", 2);
				} else if(cbPaises.getSelectedItem().equals(" Germany")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Werne", 0);
					cbCiudades.insertItemAt(" Bad Wörishofen", 1);
					cbCiudades.insertItemAt(" Hannover", 2);
					cbCiudades.insertItemAt(" Hamm", 3);
					cbCiudades.insertItemAt(" Colbitz", 4);
				} else if(cbPaises.getSelectedItem().equals(" France")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Paris", 0);
				} else if(cbPaises.getSelectedItem().equals(" Fiji")){
					cbCiudades.removeAllItems();
					cbCiudades.insertItemAt(" Mana Island", 0);
				}
			}
		});
	}
	
	
	public static String[] obtenerHoteles(ArrayList<String> h){
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

	public static void Neo4j(String dato, ArrayList<String> hoteles, String s){
		
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