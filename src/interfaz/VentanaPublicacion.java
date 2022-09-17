package interfaz;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.TextEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import logica.Evento;
import logica.Libro;
import logica.Revista;

import javax.swing.SpinnerNumberModel;

import auxiliar.BasePublicaciones;

public class VentanaPublicacion extends JDialog {
	private JTextField textField_tituloLibro;
	private JTextField textField_autolibro;
	private JTextField textField_editorialibro;
	private JTextField textField_codiglibro;
	private JTextField textField_EditoriaRevista;
	private JTextField textField_tituloRevista;
	private JTextField textField_nombreevento;
	private JTextField textField_codigoevento;
	private JPanel panel;
	private JPanel panel_libro;
	private JPanel panel_revista;
	private JPanel panel_evento;
	private JSpinner spinner_EdicionLibro;
	private JSpinner spinner_cantpagrevist;
	private JSpinner spinner_aniorevista;
	private JSpinner spinner_volumenrevista;
	private JSpinner spinner_anioevento;

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
	 */
	@SuppressWarnings("deprecation")
	public VentanaPublicacion(int numero,final VentanaArticulo padre) {
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 286, 219);
		getContentPane().setLayout(new BorderLayout());
		{
			panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new CardLayout(0, 0));
			{
				panel_libro = new JPanel();
				panel.add(panel_libro, "name_114062812568231");
				panel_libro.setLayout(null);
				{
					JLabel lblTitulo = new JLabel("Titulo ");
					lblTitulo.setBounds(10, 11, 46, 14);
					panel_libro.add(lblTitulo);
				}
				{
					textField_tituloLibro = new JTextField();
					textField_tituloLibro.setBounds(66, 8, 194, 20);
					panel_libro.add(textField_tituloLibro);
					textField_tituloLibro.setColumns(10);
				}
				{
					JLabel lblAutor = new JLabel("Autor ");
					lblAutor.setBounds(10, 36, 46, 14);
					panel_libro.add(lblAutor);
				}
				{
					textField_autolibro = new JTextField();
					textField_autolibro.setBounds(66, 33, 194, 20);
					panel_libro.add(textField_autolibro);
					textField_autolibro.setColumns(10);
				}
				{
					JLabel lblEdicion = new JLabel("Edicion");
					lblEdicion.setBounds(10, 123, 46, 14);
					panel_libro.add(lblEdicion);
				}

				spinner_EdicionLibro = new JSpinner();
				spinner_EdicionLibro.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				spinner_EdicionLibro.setBounds(66, 117, 29, 20);
				panel_libro.add(spinner_EdicionLibro);

				JLabel lblEditorial = new JLabel("Editorial");
				lblEditorial.setBounds(10, 61, 46, 14);
				panel_libro.add(lblEditorial);

				textField_editorialibro = new JTextField();
				textField_editorialibro.setBounds(66, 61, 194, 20);
				panel_libro.add(textField_editorialibro);
				textField_editorialibro.setColumns(10);

				textField_codiglibro = new JTextField();
				textField_codiglibro.setColumns(10);
				textField_codiglibro.setBounds(66, 86, 194, 20);
				panel_libro.add(textField_codiglibro);

				JLabel lblCodigo = new JLabel("Codigo");
				lblCodigo.setBounds(10, 89, 46, 14);
				panel_libro.add(lblCodigo);

				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(JOptionPane.showConfirmDialog(null, "Desea Salir?")==JOptionPane.YES_OPTION)
							dispose();
					}
				});
				btnCancelar.setBounds(171, 148, 89, 23);
				panel_libro.add(btnCancelar);

				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(ACEPTARLIBRO()!=null)
						{
							BasePublicaciones.getInstance().getBaseLibro().add(ACEPTARLIBRO());
							JOptionPane.showMessageDialog(null, "Publicacion añadida exitosamente");
							padre.llenarList();
							dispose();
						}
					}
				});
				btnAceptar.setBounds(10, 148, 89, 23);
				panel_libro.add(btnAceptar);
			}
			{
				panel_revista = new JPanel();
				panel.add(panel_revista, "name_114066088949165");
				panel_revista.setLayout(null);

				textField_EditoriaRevista = new JTextField();
				textField_EditoriaRevista.setColumns(10);
				textField_EditoriaRevista.setBounds(66, 42, 194, 20);
				panel_revista.add(textField_EditoriaRevista);

				textField_tituloRevista = new JTextField();
				textField_tituloRevista.setColumns(10);
				textField_tituloRevista.setBounds(66, 11, 194, 20);
				panel_revista.add(textField_tituloRevista);

				JLabel label = new JLabel("Titulo ");
				label.setBounds(10, 14, 46, 14);
				panel_revista.add(label);

				JLabel label_1 = new JLabel("Editorial");
				label_1.setBounds(10, 42, 46, 14);
				panel_revista.add(label_1);

				JLabel lblAo = new JLabel("A\u00F1o");
				lblAo.setBounds(10, 107, 46, 14);
				panel_revista.add(lblAo);

				spinner_aniorevista = new JSpinner();
				spinner_aniorevista.setModel(new SpinnerNumberModel(2019, 1900,2019 , 1));
				spinner_aniorevista.setBounds(49, 104, 63, 20);
				panel_revista.add(spinner_aniorevista);

				spinner_volumenrevista = new JSpinner();
				spinner_volumenrevista.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				spinner_volumenrevista.setBounds(214, 107, 46, 20);
				panel_revista.add(spinner_volumenrevista);

				spinner_cantpagrevist = new JSpinner();
				spinner_cantpagrevist.setModel(new SpinnerNumberModel(30, 30, 100, 1));
				spinner_cantpagrevist.setBounds(136, 73, 46, 20);
				panel_revista.add(spinner_cantpagrevist);

				JLabel lblVolumen = new JLabel("Volumen");
				lblVolumen.setBounds(158, 110, 46, 14);
				panel_revista.add(lblVolumen);

				JLabel lblCantidadDePaginas = new JLabel("Cantidad de Paginas");
				lblCantidadDePaginas.setBounds(10, 76, 117, 14);
				panel_revista.add(lblCantidadDePaginas);

				JButton btnAceptar_1 = new JButton("Aceptar");
				btnAceptar_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(ACEPTARREVISTA()!=null)
						{
							BasePublicaciones.getInstance().getBaseRevista().add(ACEPTARREVISTA());
							JOptionPane.showMessageDialog(null, "Publicacion añadida exitosamente");
							padre.llenarList();
							dispose();
						}
					}
				});
				btnAceptar_1.setBounds(10, 146, 89, 23);
				panel_revista.add(btnAceptar_1);

				JButton btnCancelar_1 = new JButton("Cancelar");
				btnCancelar_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(JOptionPane.showConfirmDialog(null, "Desea Salir?")==JOptionPane.YES_OPTION)
							dispose();
					}
				});
				btnCancelar_1.setBounds(175, 146, 89, 23);
				panel_revista.add(btnCancelar_1);
			}
			{
				panel_evento = new JPanel();
				panel.add(panel_evento, "name_114069646145522");
				panel_evento.setLayout(null);

				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setBounds(10, 11, 61, 14);
				panel_evento.add(lblNombre);

				textField_nombreevento = new JTextField();
				textField_nombreevento.setBounds(81, 8, 179, 20);
				panel_evento.add(textField_nombreevento);
				textField_nombreevento.setColumns(10);

				JLabel lblAo_1 = new JLabel("A\u00F1o");
				lblAo_1.setBounds(10, 72, 61, 14);
				panel_evento.add(lblAo_1);

				spinner_anioevento = new JSpinner();
				spinner_anioevento.setModel(new SpinnerNumberModel(2019, 1900, 2019, 1));
				spinner_anioevento.setBounds(81, 68, 61, 20);
				panel_evento.add(spinner_anioevento);

				textField_codigoevento = new JTextField();
				textField_codigoevento.setColumns(10);
				textField_codigoevento.setBounds(81, 37, 179, 20);
				panel_evento.add(textField_codigoevento);

				JLabel lblCodigo_1 = new JLabel("Codigo");
				lblCodigo_1.setBounds(10, 40, 61, 14);
				panel_evento.add(lblCodigo_1);

				JButton button = new JButton("Aceptar");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(ACEPTAREVENTO()!=null)
						{
							BasePublicaciones.getInstance().getBaseEvento().add(ACEPTAREVENTO());
							JOptionPane.showMessageDialog(null, "Publicacion añadida exitosamente");
							padre.llenarList();
							dispose();						}
					}
				});
				button.setBounds(10, 146, 89, 23);
				panel_evento.add(button);

				JButton button_1 = new JButton("Cancelar");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(JOptionPane.showConfirmDialog(null, "Desea Salir?")==JOptionPane.YES_OPTION)
							dispose();
					}
				});
				button_1.setBounds(175, 146, 89, 23);
				panel_evento.add(button_1);
			}
		}
		showPanel(numero);
	}

	private void showPanel(int numero)
	{
		for(int x=0;x<panel.getComponentCount();x++)
		{
			panel.getComponent(x).setVisible(false);
		}

		switch (numero) {
		case 0:
			setTitle("Añadir Libro");
			panel.getComponent(numero).setVisible(true);
			break;
		case 1:
			setTitle("Añadir Revista");
			panel.getComponent(numero).setVisible(true);
			break;
		case 2:
			setTitle("Añadir Evento");
			panel.getComponent(numero).setVisible(true);
			break;
		}
	}

	/**
	 * METODOS DE LIBRO
	 */

	private Libro ACEPTARLIBRO()
	{
		Libro nuevo=null;
		try{
			if(todoOkLibro())
			{
				nuevo=new Libro(textField_tituloLibro.getText(), extraerAutores(textField_autolibro),((Integer)spinner_EdicionLibro.getValue()), textField_editorialibro.getText(), textField_codiglibro.getText());
			}
			else 
				throw new Exception("Formulario Incompleto");

		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return nuevo;
	}
	private boolean todoOkLibro()
	{
		boolean valor=true;
		for(int x=0;panel_libro.getComponentCount()>x;x++)
		{
			if(panel_libro.getComponent(x) instanceof JTextField && ((JTextField)panel_libro.getComponent(x)).getText().equals(""))
				valor=false;
		}
		
		return valor;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * METODOS DE EVENTO
	 */
	private boolean todoOkEvento()
	{
		boolean valor=true;
		for(int x=0;panel_evento.getComponentCount()>x;x++)
		{
			if(panel_evento.getComponent(x) instanceof JTextField && ((JTextField)panel_evento.getComponent(x)).getText().equals(""))
				valor=false;
		}
		return valor;
	}

	private Evento ACEPTAREVENTO()
	{
		Evento nuevo=null;
		try{
			if(todoOkEvento())
			{
				nuevo= new Evento((Integer)spinner_anioevento.getValue(), textField_codigoevento.getText(), textField_nombreevento.getText());
			}
			else 
				throw new Exception("Formulario Incompleto");

		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return nuevo;
	}





	/**
	 * METODOS DE REVISTA
	 */
	private boolean todoOkRevista()
	{
		boolean valor=true;
		for(int x=0;panel_revista.getComponentCount()>x;x++)
		{
			if(panel_revista.getComponent(x) instanceof JTextField && ((JTextField)panel_revista.getComponent(x)).getText().equals(""))
				valor=false;
		}
		return valor;
	}

	private Revista ACEPTARREVISTA()
	{
		Revista nuevo=null;
		try{
			if(todoOkRevista())
			{
				nuevo=new Revista(textField_tituloRevista.getText(),((Integer)spinner_volumenrevista.getValue()),((Integer)spinner_aniorevista.getValue()), textField_EditoriaRevista.getText(), ((Integer)spinner_cantpagrevist.getValue()));
			}
			else 
				throw new Exception("Formulario Incompleto");

		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return nuevo;
	}

	private ArrayList<String> extraerAutores(JTextField cadena){
		ArrayList<String> nuevo=new ArrayList<String>();
		String autor="";
		for(int x=0;x<cadena.getText().length();x++)
		{
			if(cadena.getText().charAt(x)!=',')
				autor+=cadena.getText().charAt(x);
			else
			{
				nuevo.add(autor);
				autor="";
			}
		}
		return nuevo;		
	}











}
