package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import seguridad.Credencial;

import javax.swing.ImageIcon;







import principal.Iniciadora;

import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.SwingConstants;

import java.awt.Button;
import java.beans.PropertyChangeListener;

public class Autenticar extends JDialog {
	private JLabel lblNotificacion;


	public Autenticar() {
		setResizable(false);
		setUndecorated(true);
		setModal(true);
		setAlwaysOnTop(true);
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocation(200,200);
		getContentPane().setForeground(Color.BLACK);
		setSize(new Dimension(396, 217));
		setTitle("");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Proyectos\\Java\\SuperProyecto\\src\\imagenes\\encrypted.png"));
		getContentPane().setLayout(null);
		Dimension scream_size= Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scream_size.width - getWidth()) / 2,(scream_size.height - getHeight())/2);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBorder(new LineBorder(new Color(60, 179, 113), 2));
		panel.setBounds(0, 0, 404, 217);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sistema de registro de Investigaciones y Posgrado");
		lblNewLabel.setBounds(10, 11, 384, 23);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel label = new JLabel("");
		label.setBounds(286, 51, 107, 107);
		panel.add(label);
		label.setIcon(new ImageIcon(Autenticar.class.getResource("/imagenes/SUSE_96px.png")));

		JLabel lblIntroduzcaSusCredenciales = new JLabel("Introduzca sus credenciales:");
		lblIntroduzcaSusCredenciales.setBounds(42, 45, 169, 14);
		panel.add(lblIntroduzcaSusCredenciales);
		lblIntroduzcaSusCredenciales.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(42, 70, 56, 15);
		panel.add(lblUsuario);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));

		final JTextField textFielduser = new JTextField();
		textFielduser.setBounds(122, 68, 156, 20);
		panel.add(textFielduser);
		textFielduser.setBackground(SystemColor.textHighlightText);
		textFielduser.setColumns(10);

		final JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(120, 113, 156, 20);
		panel.add(passwordField);
		passwordField.setBackground(SystemColor.textHighlightText);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(42, 115, 70, 14);
		panel.add(lblContrasea);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));

		lblNotificacion = new JLabel("Credenciales incorrectas");
		lblNotificacion.setBounds(42, 144, 183, 14);
		panel.add(lblNotificacion);
		lblNotificacion.setFont(new Font("Arial", Font.ITALIC, 12));
		lblNotificacion.setVisible(false);
		lblNotificacion.setForeground(Color.RED);

		JButton btnAutenticar = new JButton("Autenticar");
		btnAutenticar.setBounds(32, 173, 96, 23);
		panel.add(btnAutenticar);
		btnAutenticar.setMnemonic('A');
		btnAutenticar.setBackground(Color.WHITE);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(199, 173, 89, 23);
		panel.add(btnSalir);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Autenticar.this.dispose();
			}
		});
		btnAutenticar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNotificacion.setVisible(false);
				String usuario= textFielduser.getText();
				textFielduser.setText("");
				String password= new String(passwordField.getText());
				passwordField.setText("");
				if(Credencial.getInstance().checkCredencial(usuario, password)){
					Autenticar.this.dispose();
					new MenuPrincipal2(Credencial.getInstance().devolverUsuarioPapel(usuario)).setVisible(true);
					
				}
				else
					lblNotificacion.setVisible(true);
			}
		});


	}
}
