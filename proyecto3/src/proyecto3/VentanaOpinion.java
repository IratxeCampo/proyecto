package proyecto3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class VentanaOpinion extends JFrame {

	public VentanaOpinion(String usu) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 400);
		setLocationRelativeTo(null);
		
		Font fuente = new Font("Apple Chancery", Font.PLAIN, 20);
		Font fuente2 = new Font("Apple Chancery", Font.PLAIN, 9);
		JLabel lUsuario = new JLabel(usu);
		lUsuario.setFont(fuente);
		JLabel lTexto = new JLabel("Usuario: ");
		lTexto.setFont(fuente);
		JLabel lHotel = new JLabel("*Nombre del hotel");
		lHotel.setFont(fuente2);
		JLabel lTitulo = new JLabel("*Título");
		lTitulo.setFont(fuente2);
		JLabel lOpinion = new JLabel("*Opinión");
		lOpinion.setFont(fuente2);
		JLabel lNota = new JLabel("*Nota");
		lNota.setFont(fuente2);
		
		JButton bVolver = new JButton("Volver al menú");
		JButton bGuardar = new JButton("Guardar");
		
		JTextField tHotel = new JTextField("1");
		JTextField tTitulo = new JTextField("2");
		JTextArea tOpinion = new JTextArea("3");
		JTextField tNota = new JTextField("4");
		
		JProgressBar jp = new JProgressBar();
		jp.setMaximum(5);
		jp.setMinimum(0);
		
		JPanel pCentral = new JPanel();
		JPanel pSuperior = new JPanel();
		JPanel pInferior = new JPanel();
		
		getContentPane().add(pSuperior, BorderLayout.NORTH);
		getContentPane().add(pCentral, BorderLayout.CENTER);
		getContentPane().add(pInferior, BorderLayout.SOUTH);
		
		pSuperior.setBorder(BorderFactory.createLineBorder(Color.black));
		pSuperior.add(lTexto);
		pSuperior.add(lUsuario);
		
		pCentral.setLayout(new GridLayout(8,1));
		pCentral.add(tHotel);
		pCentral.add(lHotel);
		pCentral.add(tTitulo);
		pCentral.add(lTitulo);
		pCentral.add(tOpinion);
		pCentral.add(lOpinion);
		pCentral.add(tNota);
		pCentral.add(lNota);
		
		pInferior.setLayout(new GridLayout(1, 2));
		pInferior.add(bGuardar);
		pInferior.add(bVolver);
		
		
		bVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal v = new VentanaPrincipal();
				v.setVisible(true);
				dispose();	
			}
		});
		
		bGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
	}
public static void main(String[] args) {
	VentanaOpinion v = new VentanaOpinion("Jon");
	v.setVisible(true);
}
}
