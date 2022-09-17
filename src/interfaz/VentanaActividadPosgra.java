package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.Departamento;
import logica.Docente;
import logica.Facultad;
import logica.Persona;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class VentanaActividadPosgra extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String nombreDep;
	private JTable tablaAct;
	private JButton okButton;
	private JComboBox comboBoxActiv;
	private JLabel lblNombreTabla;
	
	public VentanaActividadPosgra(String nombreDep) {
		setResizable(false);
		this.nombreDep=nombreDep;
		setTitle("Actividad de Posgrado del Departamento "+nombreDep);
		setBounds(100, 100, 567, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 100, 531, 247);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tablaAct = new JTable();
		scrollPane.setViewportView(tablaAct);
		
		JLabel lblAcividadDePosgrado = new JLabel("Acividad de Posgrado:");
		lblAcividadDePosgrado.setBounds(10, 21, 119, 14);
		contentPanel.add(lblAcividadDePosgrado);
		
		comboBoxActiv = new JComboBox();
		comboBoxActiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxActiv.getSelectedIndex()==1){
					llenarTablaMae(Facultad.getInstance().devolverDep(VentanaActividadPosgra.this.nombreDep));
					lblNombreTabla.setText("Maestría Informática Aplicada");
				}
				else
					if(comboBoxActiv.getSelectedIndex()==0){
						llenarTabla(Facultad.getInstance().devolverDep(VentanaActividadPosgra.this.nombreDep));
						lblNombreTabla.setText("Cursos de Posgrado");
					}
			}
		});
		comboBoxActiv.setModel(new DefaultComboBoxModel(new String[] {"Cursos de Posgrado", "Maestria Informatica aplicada"}));
		comboBoxActiv.setBounds(118, 18, 144, 20);
		contentPanel.add(comboBoxActiv);
		
		lblNombreTabla = new JLabel("Cursos de Posgrado");
		lblNombreTabla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreTabla.setBounds(155, 63, 318, 29);
		contentPanel.add(lblNombreTabla);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						VentanaActividadPosgra.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap(494, Short.MAX_VALUE)
						.addComponent(okButton)
						.addContainerGap())
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(okButton))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
		llenarTabla(Facultad.getInstance().devolverDep(nombreDep));
	}
	private void llenarTabla(Departamento dep){
		DefaultTableModel modelo=new DefaultTableModel(new String[]{"Docentes","Sexo","Creditos/Obt","Corsos/Imparte","Cursos/Ter"},0);
		
		for(int i=0; i<dep.devolvetInvest().size(); i++){
			modelo.addRow(new Object[]{dep.devolvetInvest().get(i).getNombre(),dep.devolvetInvest().get(i).getSexo(),((Docente)dep.devolvetInvest().get(i)).cantidadCred(),Facultad.getInstance().cantCursosDa(dep.devolvetInvest().get(i).getNombre()),((Docente)dep.devolvetInvest().get(i)).getResultadoCursos().size()});
		}		
		tablaAct.setModel(modelo);
		
	}
	private void llenarTablaMae(Departamento dep){
		DefaultTableModel modeloTabla= new DefaultTableModel(new Object[]{"Docentes","Categoria/C","Sexo","Matriculado","Cursos/Mae/Term","Defendiendo","Graduado"},0);
		
		for(int i=0; i<dep.devolvetInvest().size(); i++){
			modeloTabla.addRow(new Object[]{dep.devolvetInvest().get(i).getNombre(), ((Docente)dep.devolvetInvest().get(i)).getCategoriaC(),dep.devolvetInvest().get(i).getSexo(), ((Docente)dep.devolvetInvest().get(i)).estaMatriculado(), Facultad.getInstance().getMaestria().cantidadCursos(dep.devolvetInvest().get(i)) , ((Docente)dep.devolvetInvest().get(i)).estaDefendiendo(), ((Docente)dep.devolvetInvest().get(i)).estaGraduado()});
		}
		tablaAct.setModel(modeloTabla);
	}
}
