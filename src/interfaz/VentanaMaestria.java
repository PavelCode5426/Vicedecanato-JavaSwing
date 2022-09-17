package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;

public class VentanaMaestria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaMaestria dialog = new VentanaMaestria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaMaestria() {
		setTitle("A;adir maestria");
		setBounds(100, 100, 452, 337);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel_6 = new JPanel();
		getContentPane().add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new CardLayout(0, 0));
		panel_6.add(contentPanel, "name_124606997591891");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 58, 14);
		contentPanel.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(78, 8, 349, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 36, 416, 216);
		contentPanel.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cursos de Postgrado", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 22, 139, 149);
		panel.add(panel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(268, 22, 139, 149);
		panel.add(panel_5);
		
		JButton button = new JButton(">>>");
		button.setBounds(169, 59, 89, 23);
		panel.add(button);
		
		JButton button_3 = new JButton("<<<");
		button_3.setBounds(169, 106, 89, 23);
		panel.add(button_3);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Personas", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 25, 139, 146);
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(262, 25, 139, 146);
		panel_2.add(panel_4);
		
		JButton button_1 = new JButton(">>>");
		button_1.setBounds(159, 47, 89, 23);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("<<<");
		button_2.setBounds(159, 105, 89, 23);
		panel_2.add(button_2);
		
		JButton button_5 = new JButton("Cancelar");
		button_5.setBounds(337, 264, 89, 23);
		contentPanel.add(button_5);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(238, 264, 89, 23);
		contentPanel.add(btnAceptar);
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, "name_124625534797540");
		panel_7.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 11, 416, 242);
		panel_7.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "Matriculados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBounds(10, 11, 140, 220);
		panel_8.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_9.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(null, "Graduados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.setBounds(259, 11, 147, 220);
		panel_8.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_10.add(scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JButton btnNewButton = new JButton(">>>");
		btnNewButton.setBounds(160, 53, 89, 23);
		panel_8.add(btnNewButton);
		
		JButton button_4 = new JButton("<<<");
		button_4.setBounds(160, 129, 89, 23);
		panel_8.add(button_4);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(337, 264, 89, 23);
		panel_7.add(btnCancelar);
		
		JButton btnGraduar = new JButton("Graduar");
		btnGraduar.setBounds(238, 264, 89, 23);
		panel_7.add(btnGraduar);
	}
}
