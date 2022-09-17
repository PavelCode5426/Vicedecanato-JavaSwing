package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Ayuda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public Ayuda(MenuPrincipal2 menuPrincipal2,boolean a) {
		super(menuPrincipal2,true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/imagenes/SUSE_96px.png")));
		setTitle("Ayuda");
		setResizable(false);
		setBounds(100, 100, 452, 289);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton okButton = new JButton("Salir");
		okButton.setBackground(Color.WHITE);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		okButton.setBounds(351, 226, 85, 23);
		contentPanel.add(okButton);
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);
		
		JTextPane txtpnEsteSoftwareFue = new JTextPane();
		txtpnEsteSoftwareFue.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnEsteSoftwareFue.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnEsteSoftwareFue.setEditable(false);
		txtpnEsteSoftwareFue.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnEsteSoftwareFue.setText("Este software fue creado con el fin de facilitar el control de la informaci\u00F3n circulante en el Vicedecanato de Investigaciones y Posgrado de la Facultad de Ingieneria Informatica, dicho programa permite la inserci\u00F3n, edici\u00F3n y eliminaci\u00F3n del personal, as\u00ED como guardar permanentemente listas de los temas de investigacion pertenecientes a las lineas,ademas de registrar tambien todo lo referente a los Cursos de Posgrado que se ofertan teniendo en cuenta el orden seleccionado por el usuario, permitiendo cargar dichas listas. Todos los datos y cambios son guardados hasta el cierre del programa. Al lector, gracias por usar nuestra aplicacion.\r\n\r\n");
		txtpnEsteSoftwareFue.setBounds(10, 11, 435, 204);
		contentPanel.add(txtpnEsteSoftwareFue);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - this.getWidth()) / 2,(screenSize.height - this.getHeight())/2);

	}
}
