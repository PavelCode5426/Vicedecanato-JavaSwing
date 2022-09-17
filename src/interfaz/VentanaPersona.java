package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

import org.omg.CORBA.OMGVMCID;

import logica.Facultad;
import auxiliar.ResultadoCurso;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import logica.Docente;
import logica.Estudiante;
import logica.Persona;
import logica.Profesional;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaPersona extends JDialog {

	private JPanel contentPane;
	private Persona editar;
	private JTextField textField_carnet;
	private JTextField textField_nombre;
	private JTextField textField_trabajo;
	private JPanel panel_3;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JPanel panel_2;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JTextField textField_profeProfes;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblCentroDeTrabajo_1;
	private JLabel lblProfesion_2;

	
	/**
	 * @wbp.parser.constructor
	 */
	public VentanaPersona(final MenuPrincipal2 padre) {
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPersona.class.getResource("/imagenes/icons8_Add_User_Group_Woman_Man_16.png")));
		setTitle("A\u00F1adir Nuevo Integrante");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 395);
		
		Dimension scream_size= Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scream_size.width - getWidth()) / 2,(scream_size.height - getHeight())/2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setMnemonic('a');
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ACEPTAR()!=null)
					if(Facultad.getInstance().addPersonas(ACEPTAR())){
						JOptionPane.showMessageDialog(null,"Persona añadida correctamente");
						padre.actualizarTable_Bottones();	//actualizar tabla x parametros
						inicio();
					}

			}
		});
		btnAceptar.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setMnemonic('c');
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Desea Salir","Mensaje", 0)==JOptionPane.YES_OPTION)
					dispose();
			}
		});
		btnCancelar.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(btnCancelar);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 11, 378, 162);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("Nombre");
		label.setBounds(10, 24, 64, 14);
		panel_2.add(label);

		JLabel label_2 = new JLabel("Carnet");
		label_2.setBounds(10, 52, 64, 14);
		panel_2.add(label_2);

		JLabel lblTipoDePersona = new JLabel("Tipo de Persona");
		lblTipoDePersona.setBounds(10, 77, 109, 14);
		panel_2.add(lblTipoDePersona);

		JLabel label_4 = new JLabel("Sexo");
		label_4.setBounds(10, 102, 46, 14);
		panel_2.add(label_4);

		JLabel label_5 = new JLabel("Edad");
		label_5.setBounds(10, 127, 46, 14);
		panel_2.add(label_5);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(17, 17, 100, 1));
		spinner.setBounds(66, 124, 53, 20);
		panel_2.add(spinner);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		comboBox.setBounds(66, 99, 127, 20);
		panel_2.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionTipoInvestigador();
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Docente", "Estudiante", "Profesional"}));
		comboBox_1.setBounds(129, 74, 109, 20);
		panel_2.add(comboBox_1);

		textField_carnet = new JTextField();
		textField_carnet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chapter= e.getKeyChar();
				if(((chapter<'0')||(chapter>'9'))&& (chapter!='\b')||textField_carnet.getText().length()>=11){
					e.consume();
				}
			}
		});
		textField_carnet.setColumns(10);
		textField_carnet.setBounds(96, 49, 272, 20);
		panel_2.add(textField_carnet);


		textField_nombre = new JTextField();
		textField_nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chapter= e.getKeyChar();
				if(!((chapter<'0')||(chapter>'9'))&& (chapter!='\b'))
					e.consume();
			}
		});
		textField_nombre.setColumns(10);
		textField_nombre.setBounds(96, 21, 272, 20);
		panel_2.add(textField_nombre);

		panel_3 = new JPanel();
		panel_3.setBounds(10, 184, 378, 127);
		panel_1.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));

		JPanel panel_Profesional = new JPanel();
		panel_Profesional.setBorder(new TitledBorder(null, "Datos del Profesional", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_Profesional, "name_101544408398622");
		panel_Profesional.setLayout(null);

		JLabel lblCentroDeTrabajo = new JLabel("Centro de Trabajo");
		lblCentroDeTrabajo.setBounds(10, 21, 100, 14);
		panel_Profesional.add(lblCentroDeTrabajo);

		textField_trabajo = new JTextField();
		textField_trabajo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chapter= e.getKeyChar();
				if(!(((chapter<'0')||(chapter>'9'))&& (chapter!='\b')))
					e.consume();
			}
		});
		textField_trabajo.setBounds(120, 18, 248, 20);
		panel_Profesional.add(textField_trabajo);
		textField_trabajo.setColumns(10);

		JLabel lblProfesion = new JLabel("Profesion");
		lblProfesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfesion.setBounds(10, 46, 100, 14);
		panel_Profesional.add(lblProfesion);

		textField_profeProfes = new JTextField();
		textField_profeProfes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chapter= e.getKeyChar();
				if(!(((chapter<'0')||(chapter>'9'))&& (chapter!='\b')))
					e.consume();
			}
		});
		textField_profeProfes.setBounds(120, 43, 248, 20);
		panel_Profesional.add(textField_profeProfes);
		textField_profeProfes.setColumns(10);

		JPanel panel_Docente = new JPanel();
		panel_Docente.setBorder(new TitledBorder(null, "Datos del Docente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_Docente, "name_101524105161985");
		panel_Docente.setLayout(null);

		JLabel lblCategoriaDocente = new JLabel("Categoria Docente");
		lblCategoriaDocente.setBounds(10, 22, 99, 14);
		panel_Docente.add(lblCategoriaDocente);

		JLabel lblCategoriaCientifica = new JLabel("Categoria Cientifica");
		lblCategoriaCientifica.setBounds(10, 47, 99, 14);
		panel_Docente.add(lblCategoriaCientifica);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Ninguna", "M\u00E1ster", "Doctor"}));
		comboBox_2.setBounds(119, 44, 249, 20);
		panel_Docente.add(comboBox_2);

		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Instructor", "Asistente", "Profesor Auxiliar", "Profesor Titular"}));
		comboBox_3.setBounds(119, 19, 249, 20);
		panel_Docente.add(comboBox_3);

		JLabel lblProfesion_1 = new JLabel("Profesion");
		lblProfesion_1.setBounds(10, 72, 55, 14);
		panel_Docente.add(lblProfesion_1);

		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chapter= e.getKeyChar();
				if(!((chapter<'0')||(chapter>'9'))&& (chapter!='\b'))
					e.consume();
			}
		});
		textField_1.setBounds(119, 69, 249, 20);
		panel_Docente.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblFacultad = new JLabel("Facultad");
		lblFacultad.setBounds(10, 97, 46, 14);
		panel_Docente.add(lblFacultad);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chapter= e.getKeyChar();
				if(!((chapter<'0')||(chapter>'9'))&& (chapter!='\b'))
					e.consume();
			}
		});
		textField_2.setBounds(119, 94, 249, 20);
		panel_Docente.add(textField_2);
		textField_2.setColumns(10);

		JPanel panel_Estudiante = new JPanel();
		panel_Estudiante.setBorder(new TitledBorder(null, "Datos de Estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_Estudiante, "name_101490741961597");
		panel_Estudiante.setLayout(null);

		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setBounds(10, 21, 46, 14);
		panel_Estudiante.add(lblAo);

		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner_1.setBounds(66, 18, 29, 20);
		panel_Estudiante.add(spinner_1);
		inicio();
		seleccionTipoInvestigador();
	}

	/**
	 */
	public VentanaPersona(final MenuPrincipal2 padre,Persona editarble) {
		editar=editarble;
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPersona.class.getResource("/imagenes/icons8_Add_User_Group_Woman_Man_16.png")));
		setTitle("Editar Nuevo Integrante");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 394);
		
		Dimension scream_size= Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scream_size.width - getWidth()) / 2,(scream_size.height - getHeight())/2);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JButton btnAceptar = new JButton("Editar");
		btnAceptar.setMnemonic('a');
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(EDITAR()!=null){
					JOptionPane.showMessageDialog(null,"Persona editada correctamente");
					dispose();
					padre.actualizarTable_Bottones();
				}

			}

		});
		btnAceptar.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setMnemonic('c');
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Desea salir", "Seleccione una opcion",0)==JOptionPane.YES_OPTION)
					dispose();
			}
		});
		btnCancelar.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(btnCancelar);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 11, 378, 157);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("Nombre");
		label.setBounds(10, 24, 64, 14);
		panel_2.add(label);

		JLabel label_2 = new JLabel("Carnet");
		label_2.setBounds(10, 52, 64, 14);
		panel_2.add(label_2);

		JLabel lblTipoDePersona = new JLabel("Tipo de Persona");
		lblTipoDePersona.setBounds(10, 77, 109, 14);
		panel_2.add(lblTipoDePersona);

		JLabel label_4 = new JLabel("Sexo");
		label_4.setBounds(10, 102, 46, 14);
		panel_2.add(label_4);

		JLabel label_5 = new JLabel("Edad");
		label_5.setBounds(10, 127, 46, 14);
		panel_2.add(label_5);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(17, 17, 100, 1));
		spinner.setBounds(66, 124, 53, 20);
		panel_2.add(spinner);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		comboBox.setBounds(66, 99, 127, 20);
		panel_2.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionTipoInvestigador();
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Docente", "Estudiante", "Profesional"}));
		comboBox_1.setBounds(129, 74, 109, 20);
		panel_2.add(comboBox_1);

		textField_carnet = new JTextField();
		textField_carnet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chapter= e.getKeyChar();
				if(((chapter<'0')||(chapter>'9'))&& (chapter!='\b')||textField_carnet.getText().length()>=11)
					e.consume();
			}
		});
		textField_carnet.setColumns(10);
		textField_carnet.setBounds(96, 49, 272, 20);
		panel_2.add(textField_carnet);

		textField_nombre = new JTextField();
		textField_nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chapter= e.getKeyChar();
				if(!((chapter<'0')||(chapter>'9'))&& (chapter!='\b'))
					e.consume();
			}
		});
		textField_nombre.setColumns(10);
		textField_nombre.setBounds(96, 21, 272, 20);
		panel_2.add(textField_nombre);

		panel_3 = new JPanel();
		panel_3.setBounds(10, 179, 378, 127);
		panel_1.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));

		JPanel panel_Profesional = new JPanel();
		panel_Profesional.setBorder(new TitledBorder(null, "Datos del Profesional", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_Profesional, "name_101544408398622");
		panel_Profesional.setLayout(null);

		lblCentroDeTrabajo_1 = new JLabel("Centro de Trabajo");
		lblCentroDeTrabajo_1.setBounds(10, 21, 100, 14);
		panel_Profesional.add(lblCentroDeTrabajo_1);

		textField_trabajo = new JTextField();
		textField_trabajo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chapter= e.getKeyChar();
				if(!((chapter<'0')||(chapter>'9'))&& (chapter!='\b'))
					e.consume();
			}
		});
		textField_trabajo.setBounds(120, 18, 248, 20);
		panel_Profesional.add(textField_trabajo);
		textField_trabajo.setColumns(10);

		lblProfesion_2 = new JLabel("Profesion");
		lblProfesion_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfesion_2.setBounds(10, 46, 100, 14);
		panel_Profesional.add(lblProfesion_2);

		textField_profeProfes = new JTextField();
		textField_profeProfes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chapter= e.getKeyChar();
				if(!((chapter<'0')||(chapter>'9'))&& (chapter!='\b'))
					e.consume();
			}
		});
		textField_profeProfes.setBounds(120, 43, 248, 20);
		panel_Profesional.add(textField_profeProfes);
		textField_profeProfes.setColumns(10);

		JPanel panel_Docente = new JPanel();
		panel_Docente.setBorder(new TitledBorder(null, "Datos del Docente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_Docente, "name_101524105161985");
		panel_Docente.setLayout(null);

		JLabel lblCategoriaDocente = new JLabel("Categoria Docente");
		lblCategoriaDocente.setBounds(10, 22, 99, 14);
		panel_Docente.add(lblCategoriaDocente);

		JLabel lblCategoriaCientifica = new JLabel("Categoria Cientifica");
		lblCategoriaCientifica.setBounds(10, 47, 99, 14);
		panel_Docente.add(lblCategoriaCientifica);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Ninguna", "M\u00E1ster", "Doctor"}));
		comboBox_2.setBounds(119, 44, 249, 20);
		panel_Docente.add(comboBox_2);

		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Instructor", "Asistente", "Profesor Auxiliar", "Profesor Titular"}));
		comboBox_3.setBounds(119, 19, 249, 20);
		panel_Docente.add(comboBox_3);

		JLabel lblProfesion_1 = new JLabel("Profesion");
		lblProfesion_1.setBounds(10, 72, 55, 14);
		panel_Docente.add(lblProfesion_1);

		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chapter= e.getKeyChar();
				if(!((chapter<'0')||(chapter>'9'))&& (chapter!='\b'))
					e.consume();
			}
		});
		textField_1.setBounds(119, 69, 249, 20);
		panel_Docente.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblFacultad = new JLabel("Facultad");
		lblFacultad.setBounds(10, 97, 46, 14);
		panel_Docente.add(lblFacultad);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char chapter= e.getKeyChar();
				if(!((chapter<'0')||(chapter>'9'))&& (chapter!='\b'))
					e.consume();
			}
		});
		textField_2.setBounds(119, 94, 249, 20);
		panel_Docente.add(textField_2);
		textField_2.setColumns(10);

		JPanel panel_Estudiante = new JPanel();
		panel_Estudiante.setBorder(new TitledBorder(null, "Datos de Estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_Estudiante, "name_101490741961597");
		panel_Estudiante.setLayout(null);

		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setBounds(10, 21, 46, 14);
		panel_Estudiante.add(lblAo);

		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner_1.setBounds(66, 18, 29, 20);
		panel_Estudiante.add(spinner_1);
		inicio_edicion();
	}

	/**
	 * METODOS Y COSITAS PARA QUE EL PROGRAMA FUNCIONES CORRECTAMENTE
	 */

	private void inicio(){
		textField_carnet.setText("");
		textField_nombre.setText("");
		textField_trabajo.setText("");
		comboBox.setSelectedItem("");
		comboBox_1.setSelectedItem("");
		comboBox_2.setSelectedItem("");
		comboBox_3.setSelectedItem("");
		textField_profeProfes.setText("");
		textField_1.setText("");
		textField_2.setText("");
		spinner.setValue(17);
		spinner_1.setValue(1);
	}

	private void seleccionTipoInvestigador(){
		for(int x=0;x<panel_3.getComponentCount();x++)
			panel_3.getComponent(x).setVisible(false);
		if(comboBox_1.getSelectedItem().equals("Estudiante"))
			panel_3.getComponent(2).setVisible(true);
		else if(comboBox_1.getSelectedItem().equals("Docente"))
			panel_3.getComponent(1).setVisible(true);
		else if(comboBox_1.getSelectedItem().equals("Profesional"))
			panel_3.getComponent(0).setVisible(true);
	}

	private boolean todoOK(){
		boolean estado=true;
		for(int x=0;x<panel_2.getComponentCount();x++)
		{
			if(panel_2.getComponent(x) instanceof JTextField && ((JTextField)panel_2.getComponent(x)).getText().equals("")){
				estado=false;
			}

		}
		if(comboBox_1.getSelectedItem().equals("Docente"))
		{
			if(textField_1.getText().equals(""))
				estado =false;
			else if( textField_2.getText().equals(""))
				estado=false;
		}
		else if(comboBox_1.getSelectedItem().equals("Profesional"))
		{
			if(textField_profeProfes.getText().equals(""))
				estado=false;
			else if(textField_trabajo.getText().equals(""))
				estado=false;
		}
		return estado;
	}

	private Persona ACEPTAR(){
		Persona nuevo=null;
		try{
			if(todoOK()){
				if(!Facultad.getInstance().containPersona(textField_carnet.getText()))
				{
					if(comboBox_1.getSelectedItem().equals("Estudiante"))
						nuevo=new Estudiante(textField_carnet.getText(),textField_nombre.getText(), comboBox.getSelectedItem().toString(), false,(Integer)spinner.getValue(),0,(Integer)spinner_1.getValue());				
					else if(comboBox_1.getSelectedItem().equals("Profesional"))
						nuevo=new Profesional(textField_carnet.getText(),textField_nombre.getText(), comboBox.getSelectedItem().toString(), true,(Integer)spinner.getValue(),textField_trabajo.getText(),textField_profeProfes.getText(),new ArrayList<ResultadoCurso>(),null);
					else
						nuevo=new Docente(textField_carnet.getText(), textField_nombre.getText(), comboBox.getSelectedItem().toString(), true, (Integer)spinner.getValue(), 0, new ArrayList<ResultadoCurso>(),new ArrayList<String>(),comboBox_3.getSelectedItem().toString(), comboBox_2.getSelectedItem().toString(),textField_2.getText(), null,textField_1.getText());
				}
				else
					JOptionPane.showMessageDialog(null, "La persona ya existe", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else 
				throw new Exception("Formulario Incompleto");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}

		return nuevo;
	}


	private Persona EDITAR(){
		Persona nuevo=null;
		try{
			if(todoOK()){
				if(comboBox_1.getSelectedItem().equals("Estudiante")){
					nuevo=new Estudiante(textField_carnet.getText(),textField_nombre.getText(), comboBox.getSelectedItem().toString(), false,(Integer)spinner.getValue(),0,(Integer)spinner_1.getValue());
				}
				else if(comboBox_1.getSelectedItem().equals("Profesional")){
					nuevo=new Profesional(textField_carnet.getText(),textField_nombre.getText(), comboBox.getSelectedItem().toString(), true,(Integer)spinner.getValue(),textField_trabajo.getText(),textField_profeProfes.getText(),new ArrayList<ResultadoCurso>(),null);
				}
				else{
					nuevo=new Docente(textField_carnet.getText(), textField_nombre.getText(), comboBox.getSelectedItem().toString(), true, (Integer)spinner.getValue(), 0, new ArrayList<ResultadoCurso>(),new ArrayList<String>(),comboBox_3.getSelectedItem().toString(), comboBox_2.getSelectedItem().toString(),textField_2.getText(), null,textField_1.getText());
				}
				Facultad.getInstance().getPersonas().get(Facultad.getInstance().getPersonas().indexOf(editar)).Copy(nuevo, Facultad.getInstance().getPersonas().indexOf(editar));
			}
			else 
				throw new Exception("Formulario Incompleto");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}

		return nuevo;
	}

	private void inicio_edicion(){
		textField_nombre.setText(editar.getNombre());
		textField_carnet.setText(editar.getId());
		comboBox.setSelectedItem(editar.getSexo());
		spinner.setValue(editar.getEdad());
		if(editar instanceof Docente)
		{
			comboBox_1.setSelectedItem("Docente");
			comboBox_2.setSelectedItem(((Docente)editar).getCategoriaC());
			comboBox_3.setSelectedItem(((Docente)editar).getCategoriaD());
			textField_1.setText(((Docente)editar).getProfesion());
			textField_2.setText(((Docente)editar).getFacultad());
		}
		else if (editar instanceof Estudiante)
		{
			comboBox_1.setSelectedItem("Estudiante");
			spinner_1.setValue(((Estudiante)editar).getAño());
		}
		else
		{
			comboBox_1.setSelectedItem("Profesional");
			textField_trabajo.setText(((Profesional)editar).getCentroTrabajo());
			textField_profeProfes.setText(((Profesional)editar).getProfesion());
		}
	}
}
