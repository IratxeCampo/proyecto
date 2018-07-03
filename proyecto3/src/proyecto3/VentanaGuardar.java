package proyecto3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaGuardar extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	public VentanaGuardar(){
		setTitle( "Valortel" );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 240, 200 );
		setLocation(1000,200);
		JButton bGuardarBD = new JButton("Guardar datos");
		JButton bReset = new JButton("Reiniciar datos");
		bReset.setToolTipText("Se reiniciará la base de datos de usuarios para volver a tener los datos por defecto");
		getContentPane().setLayout(new GridLayout(2, 1));
		getContentPane().add(bGuardarBD);
		getContentPane().add(bReset);
		
		bGuardarBD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MongoDB mongo = new MongoDB();
				mongo.recogerInfo();
			}
		});
		
		bReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MongoDB mongo = new MongoDB();
				mongo.reiniciarMongo();
				mongo.conexion();		
			}
		});
	}
	
	
	
	
	public static void main(String[] args) {
		VentanaGuardar V = new VentanaGuardar();
		V.setVisible(true);
	}
}
