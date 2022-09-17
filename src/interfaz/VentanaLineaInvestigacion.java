package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logica.Articulo;
import logica.Departamento;
import logica.Docente;
import logica.Facultad;
import logica.LineaInvestigacion;
import logica.TemaInvestigacion;

import java.awt.color.CMMException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.TextEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaLineaInvestigacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable table;
	private LineaInvestigacion linea= new LineaInvestigacion(null,null);
	private Docente respLinea=null;
	private JComboBox comboBox;
	private JButton button_2;
	private JButton button_3;
	private Departamento pertenec;

	
	

	/**
	 */
	public VentanaLineaInvestigacion(final VentanaDepartament padre,Departamento pertenence) {
		setResizable(false);
		setModal(true);
		setTitle("Añadir Linea de Investigacion al Departamento "+padre.getTextField().getText());
		pertenec=pertenence;
		setBounds(100, 100, 624, 401);
		
		Dimension scream_size= Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scream_size.width - getWidth()) / 2,(scream_size.height - getHeight())/2);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel label = new JLabel("Nombre de la Linea");
		label.setBounds(10, 14, 106, 14);
		contentPanel.add(label);

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
		textField.setBounds(126, 11, 318, 20);
		contentPanel.add(textField);

		comboBox = new JComboBox();
		comboBox.setBounds(126, 42, 188, 20);
		contentPanel.add(comboBox);

		JLabel label_1 = new JLabel("Responsable");
		label_1.setBounds(10, 45, 106, 14);
		contentPanel.add(label_1);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Lista de Temas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 70, 585, 248);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				validarBotonesEditar();
			}
		});
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				validarBotonesEditar();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				validarBotonesEditar();			}
		});
		scrollPane.setViewportView(table);

		JButton button = new JButton("Registrar Linea");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				if(COMPLETO())
					if(Facultad.getInstance().containLinea(textField.getText()))
						JOptionPane.showMessageDialog(null, "La linea ya existe","Error",JOptionPane.ERROR_MESSAGE);
					else 
					{
						getResponsable();
						crearLinea();
						pertenec.getLineasInvestigacion().add(linea);
						JOptionPane.showMessageDialog(null, "Linea Añadida Correctamente");
						padre.llenarTabla();
						dispose();
						
					}
			}
		});
		button.setBounds(10, 329, 149, 23);
		contentPanel.add(button);

		JButton button_1 = new JButton("A\u00F1adir Tema");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				new VentanaTema(linea,VentanaLineaInvestigacion.this).setVisible(true);
				table.getSelectionModel().clearSelection();
				validarBotonesEditar();
			}
		});
		button_1.setBounds(272, 329, 106, 23);
		contentPanel.add(button_1);

		button_2 = new JButton("Editar Tema");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(table.getSelectedRow()!=-1)
					{
						new VentanaTema(linea, linea.getTemasInvestigacion().get(table.getSelectedRow()),VentanaLineaInvestigacion.this).setVisible(true);
					}
					else 
						throw new Exception("Porfavor Seleccione un Tema a Editar");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				table.getSelectionModel().clearSelection();
				validarBotonesEditar();
			}
		});
		button_2.setBounds(388, 329, 89, 23);
		contentPanel.add(button_2);

		button_3 = new JButton("Eliminar Tema");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(table.getSelectedRow()!=-1)
					{
						if(JOptionPane.showConfirmDialog(null, "Desea eliminar el tema seleccionado","Seleccione una opción",0)==JOptionPane.YES_OPTION){
						linea.getTemasInvestigacion().remove(table.getSelectedRow());
						actualizarTable();
						}
					}
					else
						throw new Exception("Seleccione una fila");
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				}
				table.getSelectionModel().clearSelection();
				validarBotonesEditar();
			}
		});
		button_3.setBounds(487, 329, 108, 23);
		contentPanel.add(button_3);
		llenarTableCombox();
		actualizarTable();
	}

	private void llenarTableCombox()
	{
		DefaultComboBoxModel modeloCB= new DefaultComboBoxModel();
		DefaultTableModel modeloT=new DefaultTableModel(new String[]{"Nombre del Tema","Responsable","Cantidad de Integrantes","Cantidad de Articulos"}, 0);

		for(int x=0;x<linea.getTemasInvestigacion().size();x++)
		{
			modeloT.addRow(new Object[]{linea.getTemasInvestigacion().get(x).getNombre(),linea.getTemasInvestigacion().get(x).getResponsable().getNombre(),linea.getTemasInvestigacion().get(x).getInvestigadores().size(),linea.getTemasInvestigacion().get(x).getArticulos().size()});
		}
		for(int x=0;x<Facultad.getInstance().getPersonas().size();x++)
		{
			if(Facultad.getInstance().getPersonas().get(x) instanceof Docente)
				modeloCB.addElement(Facultad.getInstance().getPersonas().get(x).getNombre());
		}
		table.setModel(modeloT);
		comboBox.setModel(modeloCB);
	}


	public void actualizarTable()
	{
		DefaultTableModel modeloT=new DefaultTableModel(new String[]{"Nombre del Tema","Responsable","Cantidad de Integrantes","Cantidad de Articulos"}, 0);
		if(linea.getTemasInvestigacion().size()==0)
		{
			button_2.setEnabled(false);
			button_3.setEnabled(false);
		}
		else
		{
			button_2.setEnabled(true);
			button_3.setEnabled(true);
		}
		for(int x=0;x<linea.getTemasInvestigacion().size();x++)
		{
			modeloT.addRow(new Object[]{linea.getTemasInvestigacion().get(x).getNombre(),linea.getTemasInvestigacion().get(x).getResponsable().getNombre(),linea.getTemasInvestigacion().get(x).getInvestigadores().size(),linea.getTemasInvestigacion().get(x).getArticulos().size()});
		}
		table.setModel(modeloT);
	}


	private boolean COMPLETO()
	{
		boolean valor=true;
		try {
			getResponsable();
			if(textField.getText().equals(""))
				throw new Exception("Linea sin nombre");
			else if(respLinea==null)
				throw new Exception("Linea sin responsable");

		} catch (Exception e) {
			valor=false;
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
		return valor;
	}

	private void getResponsable()
	{
		respLinea=(Docente)Facultad.getInstance().returnPeople(comboBox.getSelectedItem().toString());
	}

	private void crearLinea()
	{
		linea.setNombre(textField.getText());
		linea.setResponsable(respLinea);
	}





	/**
	 * SOBRECARGA DE CONSTRUCTOR
	 * @wbp.parser.constructor
	 * 
	 */

	public VentanaLineaInvestigacion(final VentanaDepartament padre,LineaInvestigacion pertenence,boolean x){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Desea salir ?")==JOptionPane.OK_OPTION)
					dispose();
			}
		});
		setResizable(false);
		setModal(true);
		setTitle("Editar Linea de Investigacion al Departamento "+padre.getTextField().getText());
		linea=pertenence;
		setBounds(100, 100, 624, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel label = new JLabel("Nombre de la Linea");
		label.setBounds(10, 14, 106, 14);
		contentPanel.add(label);

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
		textField.setBounds(126, 11, 327, 20);
		contentPanel.add(textField);

		comboBox = new JComboBox();
		comboBox.setBounds(126, 42, 188, 20);
		contentPanel.add(comboBox);

		JLabel label_1 = new JLabel("Responsable");
		label_1.setBounds(10, 45, 106, 14);
		contentPanel.add(label_1);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Lista de Temas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 70, 598, 248);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				validarBotonesEditar();
			}
		});
		panel.add(scrollPane, BorderLayout.CENTER);

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
				validarBotonesEditar();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				validarBotonesEditar();			}
		});
		scrollPane.setViewportView(table);

		JButton btnEditarLinea = new JButton("Finalizar");
		btnEditarLinea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				if(COMPLETO())
				{
					getResponsable();
					Editar();
					JOptionPane.showMessageDialog(null, "Linea Editada Correctamente");
					padre.llenarTabla();
					dispose();
				}
			}
		});
		btnEditarLinea.setBounds(10, 329, 149, 23);
		contentPanel.add(btnEditarLinea);

		JButton button_1 = new JButton("A\u00F1adir Tema");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				new VentanaTema(linea,VentanaLineaInvestigacion.this).setVisible(true);
				table.getSelectionModel().clearSelection();
				validarBotonesEditar();
			}
		});
		button_1.setBounds(287, 329, 106, 23);
		contentPanel.add(button_1);

		button_2 = new JButton("Editar Tema");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(table.getSelectedRow()!=-1)
					{
						new VentanaTema(linea, linea.getTemasInvestigacion().get(table.getSelectedRow()),VentanaLineaInvestigacion.this).setVisible(true);
					}
					else 
						throw new Exception("Por favor Seleccione un Tema a Editar");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				//table.getSelectionModel().clearSelection();
				//validarBotonesEditar();
			}
		});
		button_2.setBounds(403, 329, 89, 23);
		contentPanel.add(button_2);

		button_3 = new JButton("Eliminar Tema");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(table.getSelectedRow()!=-1)
					{
						if(JOptionPane.showConfirmDialog(null, "Desea eliminar el tema seleciionado")==JOptionPane.YES_OPTION){
						linea.getTemasInvestigacion().remove(table.getSelectedRow());
						actualizarTable();
						}
					}
					else
						throw new Exception("Seleccione una fila");
				}catch(Exception e)
				{
					JOptionPane.showInternalMessageDialog(null, e.getMessage());
				}
				table.getSelectionModel().clearSelection();
				validarBotonesEditar();
			}
		});
		button_3.setBounds(502, 329, 106, 23);
		contentPanel.add(button_3);
		llenarTableCombox();
		inicioEditar();
	}


	private void Editar()
	{
		linea.setNombre(textField.getText());
		linea.setResponsable(respLinea);
	}


	private void inicioEditar()
	{
		textField.setText(linea.getNombre());
		comboBox.setSelectedItem(linea.getResponsable().getNombre());
		actualizarTable();
		validarBotonesEditar();
	}
	/**
	 * Validaciones de los botones de la ventana Editar Linea
	 */

	private void validarBotonesEditar(){
		if(table.getSelectedRowCount()==0){
			button_2.setEnabled(false);
			button_3.setEnabled(false);
		}
		else{
			button_2.setEnabled(true);
			button_3.setEnabled(true);
		}		
	}
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
	









}
