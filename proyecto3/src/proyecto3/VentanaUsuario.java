package proyecto3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaUsuario extends JFrame {

	private static final long serialVersionUID = 8296910194879088164L;

	public VentanaUsuario() {
		
		setTitle( "Valortel" );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 330, 300 );
		setLocationRelativeTo( null );
		
		JTextField tUsuario = new JTextField(12);
		JPasswordField tContrasena = new JPasswordField(12);
		JPasswordField trContrasena = new JPasswordField(12);
		JTextField tEmail = new JTextField(12);
		JTextField tEdad = new JTextField();
		
		Font fuente = new Font("Apple Chancery", Font.PLAIN, 9);
		JLabel lUsuario = new JLabel("*Introducir nick");
		lUsuario.setFont(fuente);
		JLabel lContrasena = new JLabel("*Introducir contrasenya");
		lContrasena.setFont(fuente);
		JLabel lrContrasena = new JLabel("*Repetir contrasenya");
		lrContrasena.setFont(fuente);
		JLabel lEmail = new JLabel("*Introducir email");
		lEmail.setFont(fuente);
		JLabel lEdad = new JLabel("*Introducir edad");
		lEdad.setFont(fuente);
		
		JButton bGuardar = new JButton("Guardar");
		JButton bCancelar = new JButton("Cancelar");
		
		JPanel panelPrincipal = new JPanel();
		JPanel panelIzq = new JPanel();
		JPanel panelDrch = new JPanel();
		JPanel panel2 = new JPanel();
		
		panelPrincipal.add(panelIzq);
		panelPrincipal.add(panelDrch);
		
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		getContentPane().add(panelIzq, BorderLayout.WEST);
		getContentPane().add(panelDrch, BorderLayout.EAST);
		getContentPane().add(panel2, BorderLayout.SOUTH);
		
		panelIzq.add(new JLabel(" Nick: "));
		panelIzq.add(new JLabel(" Contrasenya: "));
		panelIzq.add(new JLabel(" Repetir contrasenya: "));
		panelIzq.add(new JLabel(" Email: "));
		panelIzq.add(new JLabel(" Edad: "));
		
		panelDrch.add(tUsuario);
		panelDrch.add(lUsuario);
		panelDrch.add(tContrasena);
		panelDrch.add(lContrasena);
		panelDrch.add(trContrasena);
		panelDrch.add(lrContrasena);
		panelDrch.add(tEmail);
		panelDrch.add(lEmail);
		panelDrch.add(tEdad);
		panelDrch.add(lEdad);
		
		panelIzq.setLayout(new GridLayout(5,1));
		panelDrch.setLayout(new GridLayout(10, 1));
		panel2.setLayout(new GridLayout(1,2));
		panel2.add(bGuardar);
		panel2.add(bCancelar);

		
		bGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nick = tUsuario.getText();
				String contrasenya = tContrasena.getPassword().toString();
				String trContrasenya = trContrasena.getPassword().toString();
				String edad = tEdad.getText();
				String email = tEmail.getText();
				System.out.println(nick + " " + contrasenya + " " + trContrasenya + " " + edad + " " + email);
				
				if(tContrasena.getPassword() != trContrasena.getPassword()){
					JOptionPane.showMessageDialog(null, "Las contraseynas no coinciden");
					tContrasena.setText("");
					trContrasena.setText("");
					System.out.println(tContrasena.getPassword().toString() + " " + trContrasena.getPassword().toString());
				}else {
					MongoDB mongo = new MongoDB();
					mongo.insertUser(nick, contrasenya, email, edad);
				}
				
				if(!email.contains("@")){
					JOptionPane.showMessageDialog(null, "Email no valido");
					tEmail.setText("");
				}
				
			}
		});
		
		bCancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
			
		});
	}
	
	
	public static void main(String[] args) {
		VentanaUsuario u = new VentanaUsuario();
		u.setVisible(true);
	}	
}
