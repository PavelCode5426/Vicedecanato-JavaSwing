package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;



public class VentanaCreditos extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	public VentanaCreditos(MenuPrincipal2 pantalla,boolean a) {
		super(pantalla,a);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaCreditos.class.getResource("/imagenes/SUSE_96px.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Acerca del Proyecto");
		setBounds(100, 100, 392, 272);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Aceptar");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			okButton.setBackground(Color.WHITE);
			okButton.setBounds(286, 209, 90, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblNewLabel = new JLabel("\"CUJAE\"");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(263, 155, 66, 14);
		contentPanel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(null);
		panel_1.setBounds(20, 125, 130, 104);
		contentPanel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{140, 0};
		gbl_panel_1.rowHeights = new int[]{102, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(VentanaCreditos.class.getResource("/imagenes/FormatFactoryImagen2.png")));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.fill = GridBagConstraints.VERTICAL;
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panel_1.add(label_1, gbc_label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(null);
		panel.setBounds(294, 0, 130, 128);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaCreditos.class.getResource("/imagenes/FormatFactoryImagen1.png")));
		panel.add(label, BorderLayout.CENTER);
		
		JTextPane txtpnSoftwareDesarrolladoPor = new JTextPane();
		txtpnSoftwareDesarrolladoPor.setEditable(false);
		txtpnSoftwareDesarrolladoPor.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtpnSoftwareDesarrolladoPor.setText("Software desarrollado por:\r\n\tSaydel D\u00EDaz Toris\r\n                  Pavel P\u00E9rez Gonz\u00E1lez\r\n\r\n        Facultad de Ingenier\u00EDa Inform\u00E1tica\r\n\r\nUniversidad Tecnol\u00F3gica de La Habana \r\n\t\t\t\t\t                                            \r\n\t");
		txtpnSoftwareDesarrolladoPor.setBounds(10, 11, 414, 117);
		contentPanel.add(txtpnSoftwareDesarrolladoPor);
		
		JLabel lbljosAntonioEcheverra = new JLabel("\"Jos\u00E9 Antonio Echeverr\u00EDa\"");
		lbljosAntonioEcheverra.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbljosAntonioEcheverra.setBounds(171, 125, 171, 23);
		contentPanel.add(lbljosAntonioEcheverra);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - this.getWidth()) / 2,(screenSize.height - this.getHeight())/2);
	}
}
