package proyecto3;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaHotel extends JFrame{

	private static final long serialVersionUID = -603863875546164973L;
	

	public VentanaHotel() {
		
		setSize(1000, 700);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Tu ventana de opiniones");
		
		ArrayList<String> hoteles = new ArrayList<>();
		String[] lista;
		
		JLabel lOpiniones = new JLabel();
		
		lista = VentanaValoraciones.obtenerHoteles(hoteles);
		
		for(String s : lista){
			lOpiniones.setText(s);
			getContentPane().add(lOpiniones, BorderLayout.CENTER);
			System.out.println(s);
		}
		
	}
	
	public void visuOpiniones(){
		JPanel panel = new JPanel();
	
	}
	
	public static void main(String[] args){
		VentanaHotel vh = new VentanaHotel();
		vh.setVisible(true);
	}

}