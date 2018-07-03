package proyecto3;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;
import javax.imageio.ImageIO;

public class VentanaInicial extends JPanel{

	private static final long serialVersionUID = 1700212922307207712L;
	private static BufferedImage imagenOriginal;
	private static Graphics2D graphics;

	public VentanaInicial(String nombreImagenFondo) {
		URL imgURL = getClass().getResource(nombreImagenFondo);
		try{
			imagenOriginal = ImageIO.read(imgURL);
		} catch (IOException e){
		}
		
	}
		
	
	public static void main(String[] args){
		JFrame vi = new JFrame();
		vi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		vi.setSize(600, 350);
		vi.setTitle("Bienvenido a Varhotel!!");
		vi.setLocation(200, 150);
		
		Font fuente = new Font("Bradley Hand", Font.BOLD, 18);
		JLabel lUsuario = new JLabel("  Elige el tipo de usuario:");
		lUsuario.setFont(fuente);
		String[] listaUsuarios = {"Administrador", "Hotel", "Usuario"};
		JComboBox<String> cbUsuarios = new JComboBox<>(listaUsuarios);
		
		vi.getContentPane().add(lUsuario, BorderLayout.NORTH);
		vi.getContentPane().add(cbUsuarios, BorderLayout.SOUTH);
		
		String[] listaFotos = {"Accra", "Buccaneer", "EastWind", "Luanda", "Oasis", "Sakkara", "SeaGull", "Sunshine", "Tranquility", "TranquilityBay"};
		
		(new Thread(){
			
			@Override
			public void run(){
				
				
				for(String s : listaFotos){
					JPanel panel = new VentanaInicial("Fotos/" + s + ".jpg"){
						
						private static final long serialVersionUID = 8368646524789567905L;
						{
						setLayout(new BorderLayout());
							}
						@Override
						protected void paintComponent(Graphics g){
							super.paintComponent(g);
							Graphics2D g2 = (Graphics2D) g;
							g2.drawImage(imagenOriginal, 0, 0, 600, 350, null);
						}
					};
					
					System.out.println("1");
				
					vi.getContentPane().add(panel, "Center");
					try { Thread.sleep(3000); } catch (InterruptedException e) {}
					panel.setVisible(false);
					panel.repaint();
					System.out.println("3");
					cbUsuarios.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if (cbUsuarios.getSelectedItem().equals("Administrador")){
								VentanaAdmin va = new VentanaAdmin();
								va.setVisible(true);
							} else if (cbUsuarios.getSelectedItem().equals("Hotel")){
								VentanaHotel vh = new VentanaHotel();
								vh.setVisible(true);
							} else if (cbUsuarios.getSelectedItem().equals("Usuario")){
								VentanaPrincipal vp = new VentanaPrincipal();
								vp.setVisible(true);
							}
							
						}
					});
				}
				
			}
		}).start();
		
		vi.setVisible(true);
		
		
	}
	
	public Graphics2D getGraphics(){
		return graphics;
	}

}