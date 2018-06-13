package proyecto3;

import java.awt.*;
import javax.swing.*;


import java.awt.event.*;
import java.util.Arrays;
import java.util.Vector;

public class VentanaValoraciones extends JFrame{
	
	public VentanaValoraciones(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		JLabel lhotel = new JLabel("Selecciona un hotel");
		String hoteles[] = {"Hilton", "HolidayInn", "Four Seasons" };
		JComboBox<String> cbHoteles = new JComboBox<String>(hoteles);
		cbHoteles.setEditable(false);
		getContentPane().add(cbHoteles, BorderLayout.NORTH);
		
		JTextArea taOpiniones = new JTextArea(5, 5);
		JPanel pSuperior = new JPanel();
		pSuperior.setLayout(new BoxLayout(pSuperior, BoxLayout.Y_AXIS));
		JPanel pSup1 = new JPanel();
		pSup1.add(new JLabel("Seleccione un hotel"));
		pSup1.add(cbHoteles);
		pSuperior.add(pSup1);
		getContentPane().add(pSuperior, BorderLayout.NORTH);
		getContentPane().add(new JScrollPane(taOpiniones), BorderLayout.CENTER);
		
		JList<String> lOpiniones;
		String[] opis = {"Muy buena comida", "Muy atentos"};
	    Vector<String> vOpiniones = new Vector<>(Arrays.asList(opis));
		DefaultListModel<String> mOpiniones = new DefaultListModel<>();
		for (String n : opis) mOpiniones.addElement(n);
		vOpiniones = new Vector<>(Arrays.asList(new String[] {"Muy buena comida", "Muy atentos"}));
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
	}
	
	
	private void obtenerHoteles(){
		String lHoteles[];
		//lHoteles tiene que leerse desde Neo4j
	}

	
	public static void main(String[] args){
		VentanaValoraciones v = new VentanaValoraciones();
		v.setVisible(true);
	}

}
