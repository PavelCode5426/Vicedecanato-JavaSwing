package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import logica.Departamento;
import logica.Docente;
import logica.Facultad;
import logica.LineaInvestigacion;

import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class VentanaDepartament extends JDialog {
	private JTextField textField;
	private JTable table;
	private Departamento depar=new Departamento(null, null, new ArrayList<LineaInvestigacion>());
	private JComboBox comboBox;
	private JButton button_3;
	private JButton button_4;
	private JButton btnEditarLnea;
	private JButton btnEliminarLnea;
	
	/**
	 */
	public VentanaDepartament(final MenuPrincipal2 padre){
		setTitle("A\u00F1adir Departamento");
		setSize(new Dimension(450, 300));
		
		Dimension scream_size= Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scream_size.width - getWidth()) / 2,(scream_size.height - getHeight())/2);
		
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(panel, BorderLayout.CENTER);

			JLabel label = new JLabel("Nombre del Departamento:");
			label.setBounds(10, 14, 138, 14);
			panel.add(label);

			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char chapter= e.getKeyChar();
					if(!((chapter<'0')||(chapter>'9'))&& (chapter!='\b'))
						e.consume();
				}
			});
			textField.setColumns(10);
			textField.setBounds(158, 11, 266, 20);
			panel.add(textField);

			JLabel label_1 = new JLabel("Jefe del Departamento:");
			label_1.setBounds(10, 41, 124, 14);
			panel.add(label_1);

			comboBox = new JComboBox();
			comboBox.setBounds(158, 42, 266, 20);
			panel.add(comboBox);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Lista de Lineas de Investigacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 66, 414, 161);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent arg0) {
					validacionDepartAñadir();
				}
			});
			panel_1.add(scrollPane);

			table = new JTable(){
				@Override
				public boolean isCellEditable(int arg0, int arg1) {
					// TODO Auto-generated method stub
					return false;
				}
			};
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					validacionDepartAñadir();
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					validacionDepartAñadir();
				}
			});
			scrollPane.setViewportView(table);

			JPanel panel_2 = new JPanel();
			panel_1.add(panel_2, BorderLayout.NORTH);

			JButton button_2 = new JButton("A\u00F1adir Linea");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new VentanaLineaInvestigacion(VentanaDepartament.this,depar).setVisible(true);
					table.getSelectionModel().clearSelection();
					validacionDepartAñadir();
				}
			});
			panel_2.add(button_2);

			button_3 = new JButton("Editar Linea");
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						if(table.getSelectedRow()!=-1)
						{
							new VentanaLineaInvestigacion(VentanaDepartament.this,depar.getLineasInvestigacion().get(table.getSelectedRow()),true).setVisible(true);
						}
						else
							throw new Exception("Seleccione una fila");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}	
					table.getSelectionModel().clearSelection();
					validacionDepartAñadir();
				}
			});
			panel_2.add(button_3);

			button_4 = new JButton("Eliminar Linea");
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						if(table.getSelectedRow()!=-1)
						{
							depar.getLineasInvestigacion().remove(table.getSelectedRow());
							llenarTabla();
						}
						else
							throw new Exception("Seleccione una fila");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					table.getSelectionModel().clearSelection();
					validacionDepartAñadir();
				}
			});
			panel_2.add(button_4);
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.SOUTH);
			panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton btnRegistrarDepartamento = new JButton("Registrar Departamento");
				btnRegistrarDepartamento.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(COMPLETO())
							if(Facultad.getInstance().containDepartamento(textField.getText()))
								JOptionPane.showMessageDialog(null, "El departamento ya existe","Error", JOptionPane.ERROR_MESSAGE);
							else
							{
								crearDepartamento();
								Facultad.getInstance().getDepartamentos().add(depar);
								JOptionPane.showMessageDialog(null, "Departamento Añadido Correctamente");
								Facultad.getInstance().actualizarResultadoInvestigacion();
								padre.llenarTablaDespartanto();
								dispose();
							}


					}
				});
				btnRegistrarDepartamento.setActionCommand("OK");
				panel.add(btnRegistrarDepartamento);
			}
			{
				JButton button = new JButton("Cancel");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(JOptionPane.showConfirmDialog(null, "Desea salir ?","Seleccione una opción",0)==JOptionPane.OK_OPTION)
							dispose();
					}
				});
				button.setActionCommand("Cancel");
				panel.add(button);
			}
		}
		llenar_combox();
		validacionDepartAñadir();
		llenarTabla();
	
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	private void llenar_combox()
	{
		DefaultComboBoxModel modelo=new DefaultComboBoxModel();
		for(int x=0;x<Facultad.getInstance().getPersonas().size();x++)
		{
			if(Facultad.getInstance().getPersonas().get(x) instanceof Docente)
				modelo.addElement(Facultad.getInstance().getPersonas().get(x).getNombre());
		}
		comboBox.setModel(modelo);
	}

	public void llenarTabla()
	{
		DefaultTableModel modelo=new DefaultTableModel(new String[]{"Nombre","Cantidad de Temas"}, 0);
		for(int x=0;x<depar.getLineasInvestigacion().size();x++)
		{
			modelo.addRow(new Object[]{depar.getLineasInvestigacion().get(x).getNombre(),depar.getLineasInvestigacion().get(x).getTemasInvestigacion().size()});
		}
		table.setModel(modelo);
		botones();
	}
	private void botones()
	{
		if(depar.getLineasInvestigacion().size()==0)
		{
			try {
				button_3.setEnabled(false);		
				button_4.setEnabled(false);	
			} catch (NullPointerException e) {
				btnEditarLnea.setEnabled(false);
				btnEliminarLnea.setEnabled(false);
			}
			try{
				btnEditarLnea.setEnabled(false);
				btnEliminarLnea.setEnabled(false);
			}
			catch(NullPointerException e){
				button_3.setEnabled(false);
				button_4.setEnabled(false);
			}

		}
		else
		{
			try {
				button_3.setEnabled(true);		
				button_4.setEnabled(true);	
			} catch (NullPointerException e) {
				btnEditarLnea.setEnabled(true);
				btnEliminarLnea.setEnabled(true);
			}
			try{
				btnEditarLnea.setEnabled(true);
				btnEliminarLnea.setEnabled(true);
			}
			catch(NullPointerException e){
				button_3.setEnabled(true);
				button_4.setEnabled(true);
			}
		}
	}

	private void crearDepartamento()
	{
		depar.setNombre(textField.getText());
		depar.setResponsable((Docente)Facultad.getInstance().returnPeople(comboBox.getSelectedItem().toString()));
	}

	private boolean COMPLETO()
	{
		boolean valor=true;
		try {
			if(textField.getText().equals(""))
				throw new Exception("Departamento sin nombre");
			else if(comboBox.getSelectedItem()==null)
				throw new Exception("Departamento sin responsable");

		} catch (Exception e) {
			valor=false;
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);

		}
		return valor;
	}


	/**
	 * SOBRECARGA DE CONSTRUCTOR
	 * @wbp.parser.constructor
	 */

	public VentanaDepartament(final Departamento editable,final MenuPrincipal2 padre){
		depar=new Departamento(editable);
		setTitle("Editar Departamento");
		setSize(new Dimension(450, 300));
		
		Dimension scream_size= Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scream_size.width - getWidth()) / 2,(scream_size.height - getHeight())/2);
		
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(panel, BorderLayout.CENTER);

			JLabel label = new JLabel("Nombre del Departamento:");
			label.setBounds(10, 14, 138, 14);
			panel.add(label);

			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char chapter= e.getKeyChar();
					if(!((chapter<'0')||(chapter>'9'))&& (chapter!='\b'))
						e.consume();
				}
			});
			textField.setColumns(10);
			textField.setBounds(158, 11, 266, 20);
			panel.add(textField);

			JLabel label_1 = new JLabel("Jefe del Departamento:");
			label_1.setBounds(10, 41, 124, 14);
			panel.add(label_1);

			comboBox = new JComboBox();
			comboBox.setBounds(158, 42, 266, 20);
			panel.add(comboBox);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "L\u00EDneas de Investigaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 66, 414, 161);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent arg0) {
					validacionDepartEditar();
				}
			});
			
			panel_1.add(scrollPane);

			table = new JTable(){
				@Override
				public boolean isCellEditable(int arg0, int arg1) {
					// TODO Auto-generated method stub
					return false;
				}
			};
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					validacionDepartEditar();
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					validacionDepartEditar();
				}
			});
			scrollPane.setViewportView(table);

			JPanel panel_2 = new JPanel();
			panel_1.add(panel_2, BorderLayout.NORTH);

			JButton btnAadirLnea = new JButton("A\u00F1adir L\u00EDnea");
			btnAadirLnea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new VentanaLineaInvestigacion(VentanaDepartament.this,depar).setVisible(true);
					table.getSelectionModel().clearSelection();
					validacionDepartEditar();
				}
			});
			panel_2.add(btnAadirLnea);

			btnEditarLnea = new JButton("Editar L\u00EDnea");
			btnEditarLnea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						if(table.getSelectedRow()!=-1)
						{
							new VentanaLineaInvestigacion(VentanaDepartament.this,depar.getLineasInvestigacion().get(table.getSelectedRow()),true).setVisible(true);
						}
						else
							throw new Exception("Seleccione una fila");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					table.getSelectionModel().clearSelection();
					validacionDepartEditar();
				}
			});
			panel_2.add(btnEditarLnea);

			btnEliminarLnea = new JButton("Eliminar L\u00EDnea");
			btnEliminarLnea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						if(table.getSelectedRow()!=-1)
						{
							depar.getLineasInvestigacion().remove(table.getSelectedRow());
							llenarTabla();
						}
						else
							throw new Exception("Seleccione una fila");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					table.getSelectionModel().clearSelection();
					validacionDepartEditar();
				}
			});
			panel_2.add(btnEliminarLnea);
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.SOUTH);
			panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton btnRegistrarDepartamento = new JButton("Guardar Departamento");
				btnRegistrarDepartamento.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(COMPLETO())
						{
							crearDepartamento();
							Facultad.getInstance().getDepartamentos().set(Facultad.getInstance().getDepartamentos().indexOf(editable),depar);
							JOptionPane.showMessageDialog(null, "Departamento editado correctamente");
							Facultad.getInstance().actualizarResultadoInvestigacion();
							padre.llenarTablaDespartanto();
							dispose();
						}


					}
				});
				btnRegistrarDepartamento.setActionCommand("OK");
				panel.add(btnRegistrarDepartamento);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(JOptionPane.showConfirmDialog(null, "Desea salir","Seleccione una opción",0)==JOptionPane.OK_OPTION)
							VentanaDepartament.this.dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				panel.add(btnCancelar);
			}
		}
		llenar_combox();
		inicializarEditar();
		llenarTabla();
		validacionDepartEditar();
	}


	private void inicializarEditar()
	{
		textField.setText(depar.getNombre());
		comboBox.setSelectedItem(depar.getResponsable().getNombre());
	}
/*
 * Validaciones de la ventana
 * 
 */
	private void validacionDepartAñadir(){
		if(table.getSelectedRowCount()==0)
		{
			button_3.setEnabled(false);
			button_4.setEnabled(false);
			
		}
		else{
			button_3.setEnabled(true);
			button_4.setEnabled(true);
		}
	}
	
	private void validacionDepartEditar(){
		if(table.getSelectedRowCount()==0)
		{
			btnEditarLnea.setEnabled(false);
			btnEliminarLnea.setEnabled(false);
			
		}
		else{
			btnEditarLnea.setEnabled(true);
			btnEliminarLnea.setEnabled(true);
		}
	}
	






}
