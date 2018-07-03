package proyecto3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import proyecto3.MongoDB;

public class VentanaHotel extends JFrame{

	private static final long serialVersionUID = -603863875546164973L;
	

	public VentanaHotel() {
		
		setSize(600, 250);
		setLocation(300, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Tu ventana de opiniones");
		
		JLabel lNombre = new JLabel("  Introduce el nombre del hotel: ");
		ArrayList<String> arHoteles = new ArrayList<String>();
		String[] listaHoteles = VentanaValoraciones.obtenerHoteles(arHoteles);
		JComboBox<String> cbHoteles = new JComboBox<String>(listaHoteles);
		
		JPanel panelArriba = new JPanel();
		
		panelArriba.setLayout(new GridLayout(1, 2));
		
		panelArriba.add(lNombre);
		panelArriba.add(cbHoteles);
		
		getContentPane().add(panelArriba, BorderLayout.NORTH);
		
		cbHoteles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbHoteles.getSelectedItem().toString().equals("[Skyna Luanda")){
					Font fuente = new Font("Bradley Hand", Font.BOLD, 13);
					Font fuente2 = new Font("Cambria", Font.BOLD, 16);
					JLabel lUsu = new JLabel(" Usuario:  Garazi");
					lUsu.setFont(fuente2);
					JLabel lTit = new JLabel("  Opinion: " );
					lTit.setFont(fuente2);
					JLabel lOpinion = new JLabel("    Agradable estancia en un hotel bien ubicado y confortable.");
					lOpinion.setFont(fuente);
					JLabel lResponder = new JLabel("  Responder:");
					JTextArea taRespuesta = new JTextArea(2, 10);
					JPanel pOpiniones = new JPanel();
					pOpiniones.add(lUsu);
					pOpiniones.add(lTit);
					pOpiniones.add(lOpinion);
					pOpiniones.add(lResponder);
					pOpiniones.add(taRespuesta);
					pOpiniones.setLayout(new GridLayout(5, 1));
					getContentPane().add(pOpiniones, BorderLayout.CENTER);
				}
				
			}
		});
		
		
	}
	
	public void visuOpiniones(){
		JPanel panel = new JPanel();
	
	}
	
	public static void main(String[] args){
		VentanaHotel vh = new VentanaHotel();
		vh.setVisible(true);
	}

}