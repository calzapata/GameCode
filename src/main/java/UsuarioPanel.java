


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.awt.event.ActionEvent;
@SuppressWarnings("serial")
public class UsuarioPanel extends JFrame {

	private JPanel contentPane;
	private JButton buttonIngresar;
	public static JTextField inputUsuario;
	public static JPasswordField inputPassword;


	public UsuarioPanel() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Objects.requireNonNull(this.getClass().getResource("images/icono.png"))));
		setTitle("GAME CODE");
		setLocationRelativeTo(null);
		setForeground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 206, 261);
		contentPane.add(panel);
		panel.setLayout(null);
	
		JLabel imgWindow1 = new JLabel("");
		imgWindow1.setHorizontalAlignment(SwingConstants.CENTER);
		imgWindow1.setBounds(0, 0, 206, 261);
		panel.add(imgWindow1);
		imgWindow1.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images/icono.png"))));
		
		final UsuarioDatos data = new UsuarioDatos();
		final Game inter2 = new Game();
		buttonIngresar = new JButton("Ingresar");
		buttonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inter2.setVisible(false);	
				if(data.probarUsuario()== 1) {
					JOptionPane.showMessageDialog(null, "Bienvenidos a"+"\n"+" GAME-CODE");
					inter2.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuario Contrase;a Incorrecta");	
				}
				
			}
			
		});
		buttonIngresar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonIngresar.setForeground(Color.BLACK);
		buttonIngresar.setBackground(new Color(102, 153, 204));
		buttonIngresar.setAlignmentY(Component.TOP_ALIGNMENT);
		buttonIngresar.setBounds(272, 187, 113, 23);
		contentPane.add(buttonIngresar);
		
		JLabel txtUsuario = new JLabel("usuario");
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setBounds(305, 97, 46, 14);
		contentPane.add(txtUsuario);
		
		JLabel txtContrasena = new JLabel("contrasena");
		txtContrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasena.setBounds(284, 141, 89, 14);
		contentPane.add(txtContrasena);
		
		inputUsuario = new JTextField();
		inputUsuario.setForeground(Color.BLACK);
		inputUsuario.setBounds(272, 114, 113, 20);
		contentPane.add(inputUsuario);
		inputUsuario.setColumns(10);
		
		inputPassword = new JPasswordField();
		inputPassword.setBounds(272, 156, 113, 20);
		contentPane.add(inputPassword);
		
		
	}
}
