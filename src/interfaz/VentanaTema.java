package interfaz;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultEditorKit.CutAction;
import javax.swing.JScrollPane;
import javax.swing.JList;

import java.awt.GridLayout;

import logica.Articulo;
import logica.Docente;
import logica.Facultad;
import logica.Investigador;
import logica.LineaInvestigacion;
import logica.TemaInvestigacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractListModel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaTema extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private LineaInvestigacion lin;
	private JComboBox comboBox;
	private JList listPersonal;
	private JList listInvestigadores;
	///////////////////////////////////////////////////////////////////////
	private DefaultComboBoxModel modeloCombox= new DefaultComboBoxModel(); ///////
	private DefaultListModel modeloLista= new DefaultListModel();  /////////////
	private DefaultListModel modeloLista2=new DefaultListModel();  ////////////
	private DefaultListModel modeloLista3=new DefaultListModel(); ////////////
	/////////////////////////////////////////////////////////////////////
	private ArrayList<Articulo> articulos=new ArrayList<Articulo>();
	private ArrayList<Investigador> investigadores=new ArrayList<Investigador>();
	private Docente responsable=null;
	private TemaInvestigacion editable;
	private JButton buttEditar;
	private JButton buttEliminar;
	private JList listaArticulos;
	private JButton buttoMatricular;
	private JButton buttonDesmatr;
	private JButton buttMat;
	private JButton buttDes;
	

	
	/**
	 * Create the dialog.
	 */
	public VentanaTema(LineaInvestigacion pertenece,final VentanaLineaInvestigacion padre) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Desea salir ?")==JOptionPane.OK_OPTION)
					dispose();
			}
		});
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		lin=pertenece;
		setTitle("A\u00F1adir Tema de Investigacion a la Linea"+padre.getTextField().getText());
		setBounds(100, 100, 401, 396);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("Nombre del Tema ");
			label.setBounds(10, 15, 94, 14);
			contentPanel.add(label);
		}
		{
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
			textField.setBounds(114, 11, 263, 20);
			contentPanel.add(textField);
		}
		{
			comboBox = new JComboBox();
			comboBox.setBounds(112, 36, 184, 20);
			contentPanel.add(comboBox);
		}
		{
			JLabel label = new JLabel("Responsable");
			label.setBounds(10, 39, 86, 14);
			contentPanel.add(label);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(null, "Registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 69, 367, 244);
			contentPanel.add(panel);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 22, 143, 211);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						listPersonal = new JList();
						listPersonal.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								if(listInvestigadores.getSelectedValues().length>0)
									listInvestigadores.getSelectionModel().clearSelection();
								validarBotones();

							}
							@Override
							public void mousePressed(MouseEvent arg0) {
								if(listInvestigadores.getSelectedValues().length>0)
									listInvestigadores.getSelectionModel().clearSelection();
								validarBotones();							}
						});
						scrollPane.setViewportView(listPersonal);
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Investigadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(225, 24, 134, 209);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						listInvestigadores = new JList();
						listInvestigadores.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								if(listPersonal.getSelectedValues().length>0)
									listPersonal.getSelectionModel().clearSelection();
								validarBotones();

							}
							@Override
							public void mousePressed(MouseEvent arg0) {
								if(listPersonal.getSelectedValues().length>0)
									listPersonal.getSelectionModel().clearSelection();
								validarBotones();							}
						});
						scrollPane.setViewportView(listInvestigadores);
					}
				}
			}
			{
				buttoMatricular = new JButton(">>");
				buttoMatricular.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addIntegrante();
						validarBotones();
					}
				});
				buttoMatricular.setBounds(163, 92, 52, 23);
				panel.add(buttoMatricular);
			}
			{
				buttonDesmatr = new JButton("<<");
				buttonDesmatr.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						removeIntegrante();
						validarBotones();
					}
				});
				buttonDesmatr.setBounds(163, 141, 55, 23);
				panel.add(buttonDesmatr);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setMnemonic('o');
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0){
						if(COMPLETO())
							if(Facultad.getInstance().containTema(textField.getText()))
								JOptionPane.showMessageDialog(null, "El tema ya existe");
							else if(Añadir()){
								JOptionPane.showMessageDialog(null, "Tema creado correctamente");
								padre.actualizarTable();
								dispose();
							}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(JOptionPane.showConfirmDialog(null, "Desea salir ?")==JOptionPane.OK_OPTION)
							dispose();
					}
				});
				cancelButton.setMnemonic('c');
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		llenarComboxLista();
		validarBotones();
	}

	/**
	 * METODOS DE A;ADIR 
	 */

	private boolean COMPLETO()
	{
		boolean valor=true;
		try{
			getResponsable();
			if(textField.getText().equals(""))
				throw new Exception("Tema sin nombre");
			else if(responsable==null)
				throw new Exception("Tema sin responsable");
			getInvestigadores();
		}catch (Exception e){
			valor=false;
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return valor;
	}
	private void llenarComboxLista()
	{
		for(int x=0;x<Facultad.getInstance().getPersonas().size();x++)
		{
			if(Facultad.getInstance().getPersonas().get(x) instanceof Docente)
				modeloCombox.addElement(Facultad.getInstance().getPersonas().get(x).getNombre());
			if(Facultad.getInstance().getPersonas().get(x) instanceof Investigador)
				modeloLista.addElement(Facultad.getInstance().getPersonas().get(x).getNombre());
		}

		comboBox.setModel(modeloCombox);
		listPersonal.setModel(modeloLista);
		listInvestigadores.setModel(modeloLista2);

	}

	private void addIntegrante()
	{
		Object [] seleccion=listPersonal.getSelectedValues();
		for(int x=0;x<seleccion.length;x++)
		{
			modeloLista2.addElement(seleccion[x]);
			modeloLista.removeElement(seleccion[x]);
		}
	}

	private void removeIntegrante()
	{
		Object [] seleccion=listInvestigadores.getSelectedValues();
		for(int x=0;x<seleccion.length;x++)
		{
			modeloLista.addElement(seleccion[x]);
			modeloLista2.removeElement(seleccion[x]);
		}
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}

	public void actualizarListas()
	{
		modeloLista3.clear();
		for(int x=0;x<articulos.size();x++)
		{
			modeloLista3.addElement(articulos.get(x).getTitulo());
		}
	}

	private boolean Añadir()
	{
		boolean valor=false;
		if(lin.getTemasInvestigacion().add(new TemaInvestigacion(textField.getText(),investigadores, articulos,responsable)))
			valor=true;
		return valor;
	}

	private void getResponsable()
	{
		int x=0;
		boolean encontrado=false;
		while(x<Facultad.getInstance().getPersonas().size() && !encontrado)
		{
			if(comboBox.getSelectedItem().equals(Facultad.getInstance().getPersonas().get(x).getNombre()))
			{
				encontrado=true;
				responsable=(Docente)Facultad.getInstance().getPersonas().get(x);
			}
			x++;
		}
	}

	private void getInvestigadores()
	{
		investigadores=new ArrayList<Investigador>();
		for(int x=0;x<Facultad.getInstance().getPersonas().size();x++)
			if(modeloLista2.contains(Facultad.getInstance().getPersonas().get(x).getNombre()))
				investigadores.add((Investigador)Facultad.getInstance().getPersonas().get(x));
	}

	/**
	 * CONSTRUCTOR DE EDITAR 
	 * @wbp.parser.constructor
	 */
	public VentanaTema(LineaInvestigacion pertenece,TemaInvestigacion editar,final VentanaLineaInvestigacion padre) {
		setResizable(false);
		editable=editar;
		setTitle("Editar Tema de Investigacion de "+padre.getTextField().getText());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		lin=pertenece;
		setBounds(100, 100, 625, 396);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("Nombre del Tema ");
			label.setBounds(10, 15, 94, 14);
			contentPanel.add(label);
		}
		{
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
			textField.setBounds(114, 11, 481, 20);
			contentPanel.add(textField);
		}
		{
			comboBox = new JComboBox();
			comboBox.setBounds(112, 36, 184, 20);
			contentPanel.add(comboBox);
		}
		{
			JLabel label = new JLabel("Responsable");
			label.setBounds(10, 39, 86, 14);
			contentPanel.add(label);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(null, "Registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 69, 367, 244);
			contentPanel.add(panel);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 22, 143, 211);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						listPersonal = new JList();
						listPersonal.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								listInvestigadores.clearSelection();listaArticulos.clearSelection();
								validarBotonesEditar();
							}
							@Override
							public void mousePressed(MouseEvent arg0) {
								listInvestigadores.clearSelection();listaArticulos.clearSelection();
								validarBotonesEditar();							}
						});
						scrollPane.setViewportView(listPersonal);
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Investigadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(225, 24, 134, 209);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						listInvestigadores = new JList();
						listInvestigadores.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								listPersonal.clearSelection();listaArticulos.clearSelection();
								validarBotonesEditar();
							}
							@Override
							public void mousePressed(MouseEvent arg0) {
								listPersonal.clearSelection();listaArticulos.clearSelection();
								validarBotonesEditar();							}
						});
						scrollPane.setViewportView(listInvestigadores);
					}
				}
			}
			{
				buttMat = new JButton(">>");
				buttMat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addIntegrante();
						validarBotonesEditar();
					}
				});
				buttMat.setBounds(163, 92, 52, 23);
				panel.add(buttMat);
			}
			{
				buttDes = new JButton("<<");
				buttDes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						removeIntegrante();
						validarBotonesEditar();
					}
				});
				buttDes.setBounds(163, 141, 55, 23);
				panel.add(buttDes);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Lista de Articulos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(387, 69, 215, 244);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseExited(MouseEvent arg0) {
					}
				});
				panel.add(scrollPane, BorderLayout.CENTER);

				listaArticulos = new JList();
				listaArticulos.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						listPersonal.clearSelection();
						listInvestigadores.clearSelection();
						validarBotonesEditar();
					}
					@Override
					public void mousePressed(MouseEvent arg0) {
						listPersonal.clearSelection();
						listInvestigadores.clearSelection();
						validarBotonesEditar();					}
				});
				scrollPane.setViewportView(listaArticulos);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.SOUTH);
				panel_1.setLayout(new GridLayout(1, 3, 0, 0));
				{
					JButton button = new JButton("A\u00F1adir");
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							new VentanaArticulo(VentanaTema.this).setVisible(true);
						}
					});
					panel_1.add(button);
				}
				{
					buttEditar = new JButton("Editar");
					buttEditar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if(!listaArticulos.isSelectionEmpty())
								new VentanaArticulo(VentanaTema.this,articulos.get(listaArticulos.getSelectedIndex())).setVisible(true);
						listaArticulos.clearSelection();
							validarBotonesEditar();
						}
					});
					panel_1.add(buttEditar);
				}
				{
					buttEliminar = new JButton("Eliminar");
					buttEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								if(!listaArticulos.isSelectionEmpty())
								{
									articulos.remove((articulos.get(listaArticulos.getSelectedIndex())));
									actualizarListas();
								}
								else
									throw new Exception("Seleccione un Articulo");

							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, e.getMessage());
							}
							listaArticulos.clearSelection();
							validarBotonesEditar();

						}
					});
					panel_1.add(buttEliminar);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Editar");
				okButton.setMnemonic('e');
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(COMPLETO()){
							Editar();
							JOptionPane.showMessageDialog(null, "Tema creado correctamente");
							padre.actualizarTable();
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(JOptionPane.showConfirmDialog(null, "Desea salir ?")==JOptionPane.OK_OPTION)
							dispose();
					}
				});
				cancelButton.setMnemonic('c');
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		PrepararEdicion();
		validarBotonesEditar();
	}

	private void PrepararEdicion()
	{
		articulos=editable.getArticulos();
		investigadores=editable.getInvestigadores();
		responsable=editable.getResponsable();
		textField.setText(editable.getNombre());
		llenarComboxLista();
		comboBox.setSelectedItem(editable.getResponsable().getNombre());
		llenarlistaEditar();
	}


	public void setInvestigadores(ArrayList<Investigador> investigadores) {
		this.investigadores = investigadores;
	}
	ArrayList<Investigador> getInvestigadores1(){
		return investigadores;
	}

	private void llenarlistaEditar()
	{
		modeloLista.clear();
		modeloLista2.clear();
		modeloLista3.clear();
		for(int x=0;x<Facultad.getInstance().getPersonas().size();x++)
		{
			if(investigadores.contains(Facultad.getInstance().getPersonas().get(x)))
				modeloLista2.addElement(Facultad.getInstance().getPersonas().get(x).getNombre());
			else if(Facultad.getInstance().getPersonas().get(x) instanceof Investigador)
				modeloLista.addElement(Facultad.getInstance().getPersonas().get(x).getNombre());
		}
		for(int x=0;x<articulos.size();x++)
			modeloLista3.addElement(articulos.get(x).getTitulo());
		listaArticulos.setModel(modeloLista3);
		listPersonal.setModel(modeloLista);
		listInvestigadores.setModel(modeloLista2);

	}

	private void Editar()
	{
		editable.setNombre(textField.getText());
		editable.setInvestigadores(investigadores);
		editable.setResponsable(responsable);
		editable.setArticulos(articulos);
	}

	public DefaultListModel getModeloLista2() {
		return modeloLista2;
	}

	public void setModeloLista2(DefaultListModel modeloLista2) {
		this.modeloLista2 = modeloLista2;
	}


	public TemaInvestigacion getEditable() {
		return editable;
	}

	public void setEditable(TemaInvestigacion editable) {
		this.editable = editable;
	}
	///////////
	//Validacion de botones Añadir Tema

	private void validarBotones(){
		if(listPersonal.getSelectedValues().length==0){
			buttoMatricular.setEnabled(false);
		}
		else{
			buttoMatricular.setEnabled(true);
		}
		if(listInvestigadores.getSelectedValues().length==0){
			buttonDesmatr.setEnabled(false);
		}
		else{
			buttonDesmatr.setEnabled(true);
		}
	}

	private void validarBotonesEditar(){
		if(listaArticulos.getSelectedValues().length==0){
			buttEditar.setEnabled(false);
			buttEliminar.setEnabled(false);
		}
		else{
			buttEditar.setEnabled(true);
			buttEliminar.setEnabled(true);
		}
		if(listPersonal.getSelectedValues().length==0){
			buttMat.setEnabled(false);
		}
		else{
			buttMat.setEnabled(true);
		}
		if(listInvestigadores.getSelectedValues().length==0){
			buttDes.setEnabled(false);
		}
		else{
			buttDes.setEnabled(true);
		}

	}
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}








}
