package interfaz;


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
import java.awt.event.ActionEvent;

public class Interfaz1 extends JFrame {

	private JPanel contentPane;
	private JButton buttonIngresar;
	public static JTextField inputUsuario;
	public static JPasswordField inputPassword;


	public Interfaz1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC-02\\Downloads\\gameCode.jpg"));
		setTitle("GAME CODE");
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
		imgWindow1.setIcon(new ImageIcon("C:\\Users\\PC-02\\Downloads\\A8.jpg"));
		
		final DatosUsuario data = new DatosUsuario();
		final Interfaz2 inter2 = new Interfaz2();
		
		buttonIngresar = new JButton("Ingresar");
		buttonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data.probarUsuario()== 1) {
					JOptionPane.showMessageDialog(null, "bienvenidos");
					inter2.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "usuario contrase;a incorrecta");
				}
				
			}
			
		});
		buttonIngresar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonIngresar.setForeground(Color.BLACK);
		buttonIngresar.setBackground(new Color(102, 153, 204));
		buttonIngresar.setAlignmentY(Component.TOP_ALIGNMENT);
		buttonIngresar.setBounds(272, 187, 113, 23);
		contentPane.add(buttonIngresar);
		
		JButton buttonNuevoUsuario = new JButton("Nuevo Usuario");
		buttonNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonNuevoUsuario.setForeground(Color.BLACK);
		buttonNuevoUsuario.setBackground(new Color(102, 153, 204));
		buttonNuevoUsuario.setBounds(256, 216, 144, 23);
		contentPane.add(buttonNuevoUsuario);
		
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNewLabel.setForeground(SystemColor.inactiveCaption);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PC-02\\Downloads\\31.png"));
		lblNewLabel.setBounds(220, 9, 199, 92);
		contentPane.add(lblNewLabel);
	}
}
