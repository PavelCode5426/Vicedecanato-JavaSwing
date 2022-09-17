package interfaz;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Event;
import java.awt.FlowLayout;

import javax.swing.DefaultButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.CardLayout;

import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import auxiliar.BasePublicaciones;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.ResourceBundle.Control;

import logica.Articulo;
import logica.Evento;
import logica.Facultad;
import logica.Investigador;
import logica.Libro;
import logica.LineaInvestigacion;
import logica.Publicacion;
import logica.Revista;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Choice;
import java.awt.CheckboxGroup;
import java.awt.List;

import javax.swing.UIManager;

import java.awt.Color;

public class VentanaArticulo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JComboBox comboBox;
	private JList list;
	private VentanaTema padre;
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	private Articulo editar;
	private List list_1;
	private List list_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {



		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public VentanaArticulo( VentanaTema padre) {
		list_2=null;
		setTitle("Añadir Articulo a "+padre.getTextField().getText());
		this.padre=padre;
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 352, 290);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombreDeArticulo = new JLabel("Nombre de Articulo");
			lblNombreDeArticulo.setBounds(10, 11, 108, 14);
			contentPanel.add(lblNombreDeArticulo);
		}
		{
			textField = new JTextField();
			textField.setBounds(128, 8, 208, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblPublicacion = new JLabel("Publicacion");
			lblPublicacion.setBounds(10, 39, 84, 14);
			contentPanel.add(lblPublicacion);
		}
		{
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					llenarList();
				}
			});
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Libro", "Revista", "Evento"}));
			comboBox.setBounds(128, 36, 73, 20);
			contentPanel.add(comboBox);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Seleccione la Publicacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 67, 159, 157);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					list = new JList();
					scrollPane.setViewportView(list);
				}
			}
		}
		{
			JButton btnAadirPublicacion = new JButton("A\u00F1adir Publicacion");
			btnAadirPublicacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(comboBox.getSelectedItem().equals("Libro"))
						new VentanaPublicacion(0,VentanaArticulo.this).setVisible(true);
					else if(comboBox.getSelectedItem().equals("Revista"))
						new VentanaPublicacion(1,VentanaArticulo.this).setVisible(true);
					else
						new VentanaPublicacion(2,VentanaArticulo.this).setVisible(true);
				}
			});
			btnAadirPublicacion.setBounds(211, 36, 125, 23);
			contentPanel.add(btnAadirPublicacion);
		}

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Seleccione los Autores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(179, 67, 157, 157);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		list_1 = new List();
		list_1.setMultipleSelections(true);
		scrollPane.setViewportView(list_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(ACEPTAR()!=null){
							JOptionPane.showMessageDialog(null, "Articulo añadido exitosamente");
							VentanaArticulo.this.padre.getArticulos().add(ACEPTAR());
							dispose();
							VentanaArticulo.this.padre.actualizarListas();
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
						if(JOptionPane.showConfirmDialog(null, "Desea Salir?")==JOptionPane.OK_OPTION)
							dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);

			}
		}
		llenarList();
		llenarAutores(1);
	}


	public  void llenarList()
	{
		DefaultListModel modelo=new DefaultListModel();
		if(comboBox.getSelectedItem().equals("Revista"))
			for(int x=0;x<BasePublicaciones.getInstance().getBaseRevista().size();x++)
			{
				modelo.addElement(BasePublicaciones.getInstance().getBaseRevista().get(x).getNombre());
			}
		else if(comboBox.getSelectedItem().equals("Evento"))
			for(int x=0;x<BasePublicaciones.getInstance().getBaseEvento().size();x++)
			{
				modelo.addElement(BasePublicaciones.getInstance().getBaseEvento().get(x).getNombre());
			}
		else 
			for(int x=0;x<BasePublicaciones.getInstance().getBaseLibro().size();x++)
			{
				modelo.addElement(BasePublicaciones.getInstance().getBaseLibro().get(x).getTitulo());
			}
		list.setModel(modelo);
	}


	private Articulo ACEPTAR(){
		Articulo nuevo=null;
		try{
			if(todoOK())
			{
				nuevo=new Articulo(textField.getText(), publicSelected(),getautores(1));
			}
			else
			{
				throw new Exception("Formulario Incompleto");
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());	
		}
		return nuevo;
	}

	private boolean todoOK(){
		boolean valor=true;
		if(textField.getText().equals(""))
			valor=false;
		if(list.isSelectionEmpty())
			valor=false;
		if(list_1!=null && list_1.getSelectedItems().length==0)
			valor=false;
		else if(list_2!=null && list_2.getSelectedItems().length==0)
			valor=false;
		return valor;
	}

	private Publicacion publicSelected(){
		Publicacion nuevo=null;
		if(comboBox.getSelectedItem().equals("Libro"))
			for(int x=0;x<BasePublicaciones.getInstance().getBaseLibro().size();x++)
			{
				if(BasePublicaciones.getInstance().getBaseLibro().get(x).getTitulo().equals(list.getSelectedValue()))
					nuevo=BasePublicaciones.getInstance().getBaseLibro().get(x);
			}
		else if(comboBox.getSelectedItem().equals("Evento"))
			for(int x=0;x<BasePublicaciones.getInstance().getBaseEvento().size();x++)
			{
				if(BasePublicaciones.getInstance().getBaseEvento().get(x).getNombre().equals(list.getSelectedValue()))
					nuevo=BasePublicaciones.getInstance().getBaseEvento().get(x);
			}

		else
			for(int x=0;x<BasePublicaciones.getInstance().getBaseRevista().size();x++)
			{
				if(BasePublicaciones.getInstance().getBaseRevista().get(x).getNombre().equals(list.getSelectedValue()))
					nuevo=BasePublicaciones.getInstance().getBaseRevista().get(x);
			}
		return nuevo;
	}

	/**
	 * SOBRECARGA DE CONTRUCTOR
	 * 
	 */

	public VentanaArticulo(final VentanaTema padre,Articulo editar) {
		list_1=null;
		setTitle("Editar Articulo de "+padre.getTextField().getText());
		this.editar=editar;
		this.padre=padre;
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 352, 295);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombreDeArticulo = new JLabel("Nombre de Articulo");
			lblNombreDeArticulo.setBounds(10, 11, 108, 14);
			contentPanel.add(lblNombreDeArticulo);
		}
		{
			textField = new JTextField();
			textField.setBounds(128, 8, 208, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblPublicacion = new JLabel("Publicacion");
			lblPublicacion.setBounds(10, 39, 84, 14);
			contentPanel.add(lblPublicacion);
		}
		{
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					llenarList();
				}
			});
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Libro", "Revista", "Evento"}));
			comboBox.setBounds(128, 36, 73, 20);
			contentPanel.add(comboBox);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Seleccione la Publicacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 64, 159, 160);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					list = new JList();
					scrollPane.setViewportView(list);
				}
			}
		}
		{
			JButton btnAadirPublicacion = new JButton("A\u00F1adir Publicacion");
			btnAadirPublicacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(comboBox.getSelectedItem().equals("Libro"))
						new VentanaPublicacion(0,VentanaArticulo.this).setVisible(true);
					else if(comboBox.getSelectedItem().equals("Revista"))
						new VentanaPublicacion(1,VentanaArticulo.this).setVisible(true);
					else
						new VentanaPublicacion(2,VentanaArticulo.this).setVisible(true);
				}
			});
			btnAadirPublicacion.setBounds(211, 36, 125, 23);
			contentPanel.add(btnAadirPublicacion);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione los Autores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(175, 64, 161, 160);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					list_2 = new List();
					list_2.setMultipleSelections(true);
					scrollPane.setViewportView(list_2);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Editar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(EDITAR()!=null){
							VentanaArticulo.this.padre.getArticulos().remove(VentanaArticulo.this.editar);
							VentanaArticulo.this.padre.getArticulos().add(EDITAR());
							
							JOptionPane.showMessageDialog(null, "Articulo editado exitosamente");
							dispose();
							VentanaArticulo.this.padre.actualizarListas();
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
						if(JOptionPane.showConfirmDialog(null, "Desea Salir?")==JOptionPane.OK_OPTION)
							dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		inicioEditar();
		llenarList();
		llenarAutores(0);
	}

	private void inicioEditar(){
		textField.setText(editar.getTitulo());
	}

	private Articulo EDITAR()
	{
		Articulo nuevo=null;
		try{
			if(todoOK())
			{
				nuevo= new Articulo(textField.getText(), publicSelected(),getautores(0));
			}
			else 
				throw new Exception("Formulario Incompleto");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return nuevo;
	}

	private void llenarAutores(int numero)
	{

		switch (numero) {
		case 0:
			for(int x=0;x<padre.getInvestigadores1().size();x++)
				list_2.add(padre.getInvestigadores1().get(x).getNombre());

			break;
		default:
			for(int x=0;x<padre.getInvestigadores1().size();x++)
				list_1.add(padre.getInvestigadores1().get(x).getNombre());
			break;
		}
	}



	//editar este para corregir eso de los autores
	private ArrayList<Investigador> getautores(int e){
		ArrayList<Investigador> aut=null;

		switch (e) {
		case 0:
			for(int p=0;p<list_2.getItemCount();p++)
				aut=Facultad.getInstance().returInvestig(list_2.getSelectedItems());
			break;
		default:

			for(int p=0;p<list_1.getItemCount();p++)
				aut=Facultad.getInstance().returInvestig(list_1.getSelectedItems());
			break;
		}

		return aut;
	}




}








