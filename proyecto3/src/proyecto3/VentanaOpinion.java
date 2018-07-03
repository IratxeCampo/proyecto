package proyecto3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaOpinion extends JFrame {
	public JTextField tHotel;
	public JSlider js;
	public JTextField tTitulo;
	public JTextArea tOpinion;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaOpinion(String usu) {
		setTitle("¡Danos la opinión de tu experiencia!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(990, 400);
		setLocationRelativeTo(null);
		
		Font fuente = new Font("Apple Chancery", Font.PLAIN, 20);
		JLabel lUsuario = new JLabel(usu);
		lUsuario.setFont(fuente);
		JLabel lTexto = new JLabel("Usuario: ");
		lTexto.setFont(fuente);

		JButton bVolver = new JButton("Volver al menú");
		JButton bGuardar = new JButton("Guardar");
		
		js = new JSlider(0,5,0);
		js.setMajorTickSpacing(1);
		js.setMinimum(0);
		js.setMaximum(5);
		js.setPaintLabels(true);
	
		tHotel = new JTextField(12);
		tHotel.setAlignmentX(CENTER_ALIGNMENT);
		tTitulo = new JTextField(12);
		tOpinion = new JTextArea(80,40);
		tOpinion.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		js.setToolTipText("Insertar nota entre 0 y 5 de acuerdo a la satisfacción con los servicios recibidos");
	
		JPanel pCentral = new JPanel();
		JPanel pSuperior = new JPanel();
		JPanel pInferior = new JPanel();
		JPanel panelIzq = new JPanel();
		JPanel panelDrch = new JPanel();
		
		
		pCentral.add(panelIzq);
		pCentral.add(panelDrch);
		
		getContentPane().add(pCentral, BorderLayout.CENTER);
		getContentPane().add(panelIzq, BorderLayout.WEST);
		getContentPane().add(panelDrch, BorderLayout.EAST);
		getContentPane().add(pSuperior, BorderLayout.NORTH);
		getContentPane().add(pInferior, BorderLayout.SOUTH);
	
		
		pSuperior.setBorder(BorderFactory.createLineBorder(Color.black));
		pSuperior.add(lTexto);
		pSuperior.add(lUsuario);
		
		
		panelIzq.add(new JLabel(" Introducir nombre del hotel: "));
		panelIzq.add(tHotel);
		panelIzq.add(new JLabel(" Introducir título del comentario: "));
		panelIzq.add(tTitulo);
		panelIzq.add(new JLabel(" Introducir nota global de satisfacción: "));
		panelIzq.add(js);

		panelDrch.add(new JLabel(" Introducir opinión sobre el hotel: "));
		panelDrch.add(tOpinion);
	
		panelIzq.setLayout(new GridLayout(3,2));
		panelDrch.setLayout(new GridLayout(3, 3));
		
		pInferior.setLayout(new GridLayout(1, 2));
		pInferior.add(bGuardar);
		pInferior.add(bVolver);
		
		js.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				
			}
		});
		
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
				if(compruebaVacio(tHotel.getText(), tTitulo.getText(), tOpinion.getText())){
					MongoDB mongo = new MongoDB();
					mongo.insertOpinion(usu, tHotel.getText(), tTitulo.getText(), tOpinion.getText());
					
				}else{
					JOptionPane.showMessageDialog(null, "Comprueba que todos los campos estén completos");
				}
			}
		});
		
	}
	public boolean compruebaVacio(String nomHotel, String titulo, String opinion){
		boolean isCompleto = false;
		if(nomHotel.length()!=0){
			if(titulo.length()!=0){
				if(opinion.length()!=0){
					isCompleto=true;
				}
			}
		}else{
			isCompleto=false;
		}
		return isCompleto;
	}
	public String recuperarPuntos(int puntos, String nomHotel) {
		puntos = js.getValue();
		nomHotel = tHotel.getText();
		return puntos+", "+nomHotel;
	}	
	
	private void textCodKeyTyped(KeyEvent key) {
		char c = key.getKeyChar();
		if(c<'0' || c>'5') key.consume();
	}
		
	public static void main(String[] args) {
		VentanaOpinion v = new VentanaOpinion("Jon");
		v.setVisible(true);
	}
}
