package interfaz;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.TextArea;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.UIManager;

import java.awt.Color;
import java.util.ArrayList;
import java.util.ResourceBundle.Control;

import logica.CursoPosgrado;
import logica.Docente;
import logica.Estudiante;
import logica.Facultad;
import logica.Persona;
import logica.Profesional;

import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;

import javax.swing.AbstractListModel;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.DebugGraphics;

import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;

public class VentanaAñadirCurso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField Nombre;
	private JTextField Tema;
	private JComboBox comboProfesor;
	private JSpinner spinnerCreditos;
	private TextArea Areatext;
	private JList listaMatricula;
	private JButton btnDesma;
	private JButton btnMatri;
	private JPanel buttonPane;
	private JButton cancelButton;
	private DefaultListModel modelo_matricula;
	private DefaultListModel modelo_personas;
	private JPanel panelTextArea;
	private JButton btnRegistrar;
	private JLabel labelNombre;
	private JLabel labelTema;
	private JLabel labelProfesor;
	private JPanel panelMatriculados;
	private JList listaPersonal;
	private JSpinner spinnerCantMax;
	private JLabel lblCantidadMax;
	private MenuPrincipal2 menuEditar;
	private MenuPrincipal2 menuNormal;
	private JPanel panel_2;
	private JPanel panel_4;
	private int indiceee;
	private JScrollPane scrollPane_1;







	/**
	 * @wbp.parser.constructor
	 */
	public VentanaAñadirCurso( final MenuPrincipal2 menuNormal) {
		this.menuNormal= menuNormal;
		modelo_matricula= new DefaultListModel();
		modelo_personas= new DefaultListModel();
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("A\u00F1adir Curso de Posgrado");
		setBounds(100, 100, 700, 382);
		
		Dimension scream_size= Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(((scream_size.width - getWidth()) / 2)+60,((scream_size.height - getHeight())/2) +60);

		
		getContentPane().setLayout(new BorderLayout());

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione la Matr\u00EDcula", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(256, 14, 446, 295);
		contentPanel.add(panel);

		btnMatri = new JButton(">>>");
		btnMatri.setBounds(184, 139, 84, 23);
		btnMatri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listaPersonal.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "No ha seleccionado algo por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					matricular();
				}
				listaMatricula.clearSelection();
				validarBotonesAñadir();
			}
		});
		panel.setLayout(null);
		btnMatri.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnMatri);

		btnDesma = new JButton("<<<");
		btnDesma.setBounds(184, 193, 84, 23);
		btnDesma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listaMatricula.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "No ha seleccionado algo por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					desmatricular();
				}
				listaMatricula.clearSelection();
				validarBotonesAñadir();
			}
		});
		btnDesma.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnDesma);

		panelMatriculados = new JPanel();
		panelMatriculados.setBounds(268, 28, 168, 256);
		panelMatriculados.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Matriculados", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		panel.add(panelMatriculados);
		panelMatriculados.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();

		panelMatriculados.add(scrollPane, BorderLayout.CENTER);

		listaMatricula = new JList();
		listaMatricula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listaPersonal.clearSelection();
				validarBotonesAñadir();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				listaPersonal.clearSelection();
				validarBotonesAñadir();			}
		});

		listaMatricula.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(!listaMatricula.isSelectionEmpty())
					btnDesma.setEnabled(true);
				else
					btnDesma.setEnabled(false);

			}
		});


		DefaultListModel modelo_Matriculados= new DefaultListModel();
		listaMatricula.setModel(modelo_Matriculados);

		listaMatricula.setBackground(UIManager.getColor("menu"));
		scrollPane.setViewportView(listaMatricula);

		panel_2 = new JPanel();
		panelMatriculados.add(panel_2, BorderLayout.NORTH);

		lblCantidadMax = new JLabel("Cantidad max:");

		spinnerCantMax = new JSpinner();
		spinnerCantMax.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(lblCantidadMax, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(spinnerCantMax, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
				);
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidadMax, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerCantMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panel_2.setLayout(gl_panel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 28, 168, 256);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Personal", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		scrollPane_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				listaPersonal.setSelectedIndex(-1);
			}
		});
		panel_1.add(scrollPane_1, BorderLayout.CENTER);

		listaPersonal = new JList();
		listaPersonal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listaMatricula.clearSelection();
				validarBotonesAñadir();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				listaMatricula.clearSelection();
				validarBotonesAñadir();			}
		});
		listaPersonal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!btnMatri.isFocusable())
					listaPersonal.getSelectionModel().clearSelection();
			}
		});
		listaPersonal.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(!listaPersonal.isSelectionEmpty())
					btnMatri.setEnabled(true);
				else
					btnMatri.setEnabled(false);
			}
		});

		scrollPane_1.setViewportView(listaPersonal);


		listaPersonal.setBackground(SystemColor.menu);

		panelTextArea = new JPanel();
		panelTextArea.setBorder(new TitledBorder(null, "Objetivos", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelTextArea.setBounds(10, 133, 236, 176);
		contentPanel.add(panelTextArea);
		panelTextArea.setLayout(new BorderLayout(0, 0));

		Areatext = new TextArea();
		Areatext.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(Areatext.getText().equals("Escriba aqui los objetivos del curso")){
					Areatext.setText("");
				}

			}
		});
		Areatext.setText("Escriba aqui los objetivos del curso");
		panelTextArea.add(Areatext, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 248, 122);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);

		labelTema = new JLabel("Tema:");
		labelTema.setBounds(0, 39, 46, 20);
		panel_3.add(labelTema);

		labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(0, 14, 57, 14);
		panel_3.add(labelNombre);
		labelNombre.setForeground(Color.BLACK);

		Nombre = new JTextField();
		Nombre.setBounds(54, 11, 182, 20);
		panel_3.add(Nombre);
		Nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(!(caracter<'0' || caracter>'9')&& caracter!='\b')
					e.consume();
			}
		});
		Nombre.setColumns(10);

		Tema = new JTextField();
		Tema.setBounds(54, 39, 182, 20);
		panel_3.add(Tema);
		Tema.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(!(caracter<'0' || caracter>'9')&& caracter!='\b')
					e.consume();
			}
		});
		Tema.setColumns(10);

		labelProfesor = new JLabel("Profesor:");
		labelProfesor.setBounds(0, 70, 57, 14);
		panel_3.add(labelProfesor);

		comboProfesor = new JComboBox();
		comboProfesor.setMaximumRowCount(3);
		comboProfesor.setBounds(54, 67, 182, 20);
		panel_3.add(comboProfesor);

		spinnerCreditos = new JSpinner();
		spinnerCreditos.setBounds(54, 98, 52, 20);
		panel_3.add(spinnerCreditos);
		spinnerCreditos.setToolTipText("");
		spinnerCreditos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter= e.getKeyChar();
				if(((caracter<'0')||(caracter>'9'))&&(caracter !='\b')){
					e.consume();
				}    
			}
		});
		spinnerCreditos.setModel(new SpinnerNumberModel(1, 1, 30, 1));

		JLabel label_3 = new JLabel("Créditos:");
		label_3.setBounds(0, 101, 57, 14);
		panel_3.add(label_3);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(JOptionPane.showConfirmDialog(null, "Desea salir","Seleccione una opción", 0)==JOptionPane.YES_OPTION){
							if(Facultad.getInstance().getCursos().size()>0){
								menuNormal.llenarListaCursos();
								menuNormal.devolverListaCurso().setSelectedIndex(menuNormal.devolverListaCurso().getModel().getSize()-1);
								VentanaAñadirCurso.this.dispose();

							}

							else{
								VentanaAñadirCurso.this.dispose();
								menuNormal.showPanel(0);
							}
						}
					}
				});

				btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(Facultad.getInstance().check(1))
							if(!validarDatos()){
								if(Facultad.getInstance().addCurso(devolver())){
									JOptionPane.showMessageDialog(null, "Se ha añadido satisfactoriamente un curso");
									vaciarInterfaz();
									menuNormal.llenarListaCursos();
									menuNormal.devolverListaCurso().setSelectedIndex(menuNormal.devolverListaCurso().getModel().getSize()-1);

								}
							}
					}
				});
				buttonPane.add(btnRegistrar);
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
		llenarCombobox();
		llenarPersonal();
		validarBotonesAñadir();
	}
	//Constructor para la Ventana Editar






	/**
	 */
	public VentanaAñadirCurso( final MenuPrincipal2 menuEditar, final CursoPosgrado cursito,  final int index) {
		this.menuEditar=menuEditar;
		this.indiceee=index;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAñadirCurso.class.getResource("/imagenes/SUSE_96px.png")));
		modelo_matricula= new DefaultListModel();
		modelo_personas= new DefaultListModel();
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Editar Curso de Posgrado");
		setBounds(100, 100, 718, 382);
		
		Dimension scream_size= Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(((scream_size.width - getWidth()) / 2)+60,((scream_size.height - getHeight())/2) +60);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		labelNombre = new JLabel("Nombre:");
		labelNombre.setForeground(Color.BLACK);
		labelNombre.setBounds(10, 14, 57, 14);
		contentPanel.add(labelNombre);

		Nombre = new JTextField();
		Nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(!(caracter<'0' || caracter>'9')&& caracter!='\b')
					e.consume();
			}
		});
		Nombre.setColumns(10);
		Nombre.setBounds(64, 11, 182, 20);
		contentPanel.add(Nombre);

		labelTema = new JLabel("Tema:");
		labelTema.setBounds(10, 39, 46, 20);
		contentPanel.add(labelTema);

		Tema = new JTextField();
		Tema.setColumns(10);
		Tema.setBounds(64, 39, 182, 20);
		contentPanel.add(Tema);

		labelProfesor = new JLabel("Profesor:");
		labelProfesor.setBounds(10, 70, 57, 14);
		contentPanel.add(labelProfesor);

		JLabel label_3 = new JLabel("Creditos:");
		label_3.setBounds(10, 101, 57, 14);
		contentPanel.add(label_3);

		comboProfesor = new JComboBox();
		comboProfesor.setMaximumRowCount(3);
		comboProfesor.setBounds(64, 67, 182, 20);
		contentPanel.add(comboProfesor);

		spinnerCreditos = new JSpinner();
		spinnerCreditos.setToolTipText("");
		spinnerCreditos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter= e.getKeyChar();
				if(((caracter<'0')||(caracter>'9'))&&(caracter !='\b')){
					e.consume();
				}    
			}
		});
		spinnerCreditos.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinnerCreditos.setBounds(64, 98, 52, 20);
		contentPanel.add(spinnerCreditos);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Matr\u00EDcula", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(256, 14, 446, 295);
		contentPanel.add(panel);

		btnMatri = new JButton(">>>");
		btnMatri.setBounds(184, 139, 84, 23);
		btnMatri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listaPersonal.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "No ha seleccionado algo por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					matricular();
				}
				listaPersonal.clearSelection();
				validarBotonesAñadir();
			}
		});
		panel.setLayout(null);
		btnMatri.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnMatri);

		btnDesma = new JButton("<<<");
		btnDesma.setBounds(184, 193, 84, 23);
		btnDesma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listaMatricula.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "No ha seleccionado algo por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					desmatricular();
				}
				listaMatricula.clearSelection();
				validarBotonesAñadir();
			}
		});
		btnDesma.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnDesma);

		panelMatriculados = new JPanel();
		panelMatriculados.setBounds(268, 28, 168, 256);
		panelMatriculados.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Matriculados", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		panel.add(panelMatriculados);
		panelMatriculados.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelMatriculados.add(scrollPane, BorderLayout.CENTER);

		listaMatricula = new JList();
		listaMatricula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listaPersonal.clearSelection();
				validarBotonesAñadir();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				listaPersonal.clearSelection();
				validarBotonesAñadir();			}
		});

		DefaultListModel modelo_Matriculados= new DefaultListModel();
		listaMatricula.setModel(modelo_Matriculados);

		listaMatricula.setBackground(UIManager.getColor("menu"));
		scrollPane.setViewportView(listaMatricula);

		panel_4 = new JPanel();
		panelMatriculados.add(panel_4, BorderLayout.NORTH);

		lblCantidadMax = new JLabel("Cantidad max:");

		spinnerCantMax = new JSpinner();
		spinnerCantMax.setModel(new SpinnerNumberModel(0,0, null, new Integer(1)));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
				gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblCantidadMax, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(spinnerCantMax, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		gl_panel_4.setVerticalGroup(
				gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCantidadMax, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(spinnerCantMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
				);
		panel_4.setLayout(gl_panel_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 28, 168, 256);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Personal", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		listaPersonal = new JList();
		listaPersonal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listaMatricula.clearSelection();
				validarBotonesAñadir();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				listaMatricula.clearSelection();
				validarBotonesAñadir();			}
		});
		listaPersonal.setBackground(SystemColor.menu);
		panel_1.add(listaPersonal, BorderLayout.CENTER);

		panelTextArea = new JPanel();
		panelTextArea.setBorder(new TitledBorder(null, "Objetivos", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelTextArea.setBounds(10, 126, 236, 183);
		contentPanel.add(panelTextArea);
		panelTextArea.setLayout(new BorderLayout(0, 0));

		Areatext = new TextArea();

		panelTextArea.add(Areatext, BorderLayout.CENTER);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(JOptionPane.showConfirmDialog(null, "Desea salir", "Seleccione una opción",0)==JOptionPane.YES_OPTION){
							if(Facultad.getInstance().getCursos().size()== 0){
								menuEditar.showPanel(0);
								VentanaAñadirCurso.this.dispose();

							}
							else
								VentanaAñadirCurso.this.dispose();
						}
					}
				});


				btnRegistrar = new JButton("Editar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(!validarDatosEditar())
							//aqui pregunto si cambio el profesor que imparte el curso.si no es igual al que ya staba o sea lo cambio debo borrarle el daCurso
							//al que lo tenia y ponerselo al nuevo docente
							if(comboProfesor.getSelectedItem().toString().equals(cursito.getProfesor().getNombre())){
								cursito.getProfesor().removeEnCurso(cursito.getNombre());
								((Docente)Facultad.getInstance().buscarProfesor(comboProfesor.getSelectedItem().toString())).actualizarEnCurso(Nombre.getText());
								cursito.vaciarMatricula();
								crearCursoEditado(cursito);	
								Facultad.getInstance().insertarCurso(crearCursoEditado(cursito), index);
								JOptionPane.showMessageDialog(null, "Se ha editado satisfactoriamente el curso");
								//menuEditar.insertarCurso(devolver(), menuEditar.indexCurso(cursito));
								menuEditar.llenarListaCursos();
								menuEditar.devolverListaCurso().setSelectedIndex(index);
								VentanaAñadirCurso.this.dispose();

							}
							else{
								cursito.vaciarMatricula();
								crearCursoEditado(cursito);	
								Facultad.getInstance().insertarCurso(crearCursoEditado(cursito), index);
								JOptionPane.showMessageDialog(null, "Se ha editado satisfactoriamente el curso");
								//menuEditar.insertarCurso(devolver(), menuEditar.indexCurso(cursito));
								menuEditar.llenarListaCursos();
								menuEditar.devolverListaCurso().setSelectedIndex(index);
								VentanaAñadirCurso.this.dispose();

							}
					}
				}
						);


				buttonPane.add(btnRegistrar);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		llenarListas(cursito);
		llenarListaProfesores(cursito);
		llenarCampos(cursito);
		validarBotonesAñadir();

	}


	private void llenarListas(CursoPosgrado cursito) {
		//LLenar el modelo de las personas quitando a las que estan ya matriculadas

		for(int i=0; i<Facultad.getInstance().getPersonas().size(); i++)
		{
			if(Facultad.getInstance().getPersonas().get(i) instanceof Docente){
				if(((Docente)Facultad.getInstance().getPersonas().get(i)).getCategoriaC().equals("Ninguna"))
					if(!menuEditar.estaMatriculado(Facultad.getInstance().getPersonas().get(i).getNombre(), cursito))
						if(!((Docente)Facultad.getInstance().getPersonas().get(i)).estaEnResultado(cursito.getNombre()))
							modelo_personas.addElement(Facultad.getInstance().getPersonas().get(i).getNombre());
			}
			else{
				if(Facultad.getInstance().getPersonas().get(i) instanceof Profesional)
					if(!menuEditar.estaMatriculado(Facultad.getInstance().getPersonas().get(i).getNombre(), cursito))
						if(!((Profesional)Facultad.getInstance().getPersonas().get(i)).estaEnResultado(cursito.getNombre()))
							modelo_personas.addElement(Facultad.getInstance().getPersonas().get(i).getNombre());


			}
		}


		//Añadir
		for(int i=0; i<cursito.getPersonasCurso().size(); i++){
			modelo_matricula.addElement(cursito.getPersonasCurso().get(i).getNombre());
		}

		listaPersonal.setModel(modelo_personas);
		listaMatricula.setModel(modelo_matricula);

	}


	//Editar
	private void llenarListaProfesores(CursoPosgrado cursito) {
		DefaultComboBoxModel modelo_combo= new DefaultComboBoxModel();

		for(int i=0;i<Facultad.getInstance().getPersonas().size();i++){
			if(Facultad.getInstance().getPersonas().get(i)instanceof Docente && ((Docente)Facultad.getInstance().getPersonas().get(i)).getFacultad().equals("Informatica") && !((Docente)Facultad.getInstance().getPersonas().get(i)).getCategoriaC().equals("Ninguna"))
				modelo_combo.addElement(Facultad.getInstance().getPersonas().get(i).getNombre());
		}
		comboProfesor.setModel(modelo_combo);
		comboProfesor.setSelectedItem(cursito.getProfesor().getNombre());
	}


	//Este metodo actualiza la informacion del curso a editar
	private void llenarCampos(CursoPosgrado e) {
		Nombre.setText(e.getNombre());
		Tema.setText(e.getTema());
		Areatext.setText(e.getObjetivos());
		spinnerCantMax.setValue((Integer)e.getCapacidadMax());
		spinnerCreditos.setValue((Integer)e.getCreditos());

	}

	//Añadir
	private void llenarCombobox(){
		DefaultComboBoxModel modelo_combo= new DefaultComboBoxModel();
		modelo_combo.addElement(" Seleccione un profesor ");

		for(int i=0;i<Facultad.getInstance().getPersonas().size();i++){
			if(Facultad.getInstance().getPersonas().get(i)instanceof Docente && ((Docente)Facultad.getInstance().getPersonas().get(i)).getFacultad().equals("Informatica") && !((Docente)Facultad.getInstance().getPersonas().get(i)).getCategoriaC().equals("Ninguna"))
				modelo_combo.addElement(Facultad.getInstance().getPersonas().get(i).getNombre());
		}
		comboProfesor.setModel(modelo_combo);

	}
	//Añadir
	private void llenarPersonal(){
		for(int i=0;i<Facultad.getInstance().getPersonas().size();i++)
		{
			if(Facultad.getInstance().getPersonas().get(i) instanceof Docente){
				if(((Docente)Facultad.getInstance().getPersonas().get(i)).getCategoriaC().equals("Ninguna"))
					modelo_personas.addElement(Facultad.getInstance().getPersonas().get(i).getNombre());

			}
			else{
				if(Facultad.getInstance().getPersonas().get(i) instanceof Profesional){
					modelo_personas.addElement(Facultad.getInstance().getPersonas().get(i).getNombre());
				}
			}
		}

		listaPersonal.setModel(modelo_personas);
		listaMatricula.setModel(modelo_matricula);
	}


	private void matricular(){
		Object[] selecc=listaPersonal.getSelectedValues();
		for(int i=0;i<selecc.length;i++)
		{
			modelo_matricula.addElement(selecc[i]);
			modelo_personas.removeElement(selecc[i]);
		}
	}
	private void desmatricular(){
		Object[] selecc=listaMatricula.getSelectedValues();
		for(int i=0;i<selecc.length;i++)
		{
			modelo_personas.addElement(selecc[i]);
			modelo_matricula.removeElement(selecc[i]);
		}

	}
	private boolean validarDatos(){
		boolean validacion=true;

		try{
			if(Facultad.getInstance().comprobarNombre(Nombre.getText()))
				JOptionPane.showMessageDialog(null, "Ya existe un curso con ese mismo nombre", "Error", JOptionPane.ERROR_MESSAGE);
			else
				if(Nombre.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Se le olvidó registrar el nombre del curso", "Error", JOptionPane.ERROR_MESSAGE);
				else
					if(Facultad.getInstance().comprobarTema(Tema.getText()))
						JOptionPane.showMessageDialog(null, "Ya existe un curso con ese mismo tema", "Error", JOptionPane.ERROR_MESSAGE);
					else
						if(comboProfesor.getSelectedIndex()==0)
							JOptionPane.showMessageDialog(null, "No ha registrado el profesor del curso", "Error", JOptionPane.ERROR_MESSAGE);
						else
							if(Tema.getText().equals(""))
								JOptionPane.showMessageDialog(null, "Se le olvidó registrar el tema del curso", "Error", JOptionPane.ERROR_MESSAGE);
							else
								if(Areatext.getText().equals("Escriba aquí los objetivos del curso") || Areatext.getText().equals(""))
									JOptionPane.showMessageDialog(null,"Se le olvidó registrar los objetivos del curso", "Error", JOptionPane.ERROR_MESSAGE);
								else
									if(listaMatricula.getModel().getSize() > (Integer)spinnerCantMax.getValue())
										JOptionPane.showMessageDialog(null, "La matrícula excede la cantidad máxima registrada", "Error", JOptionPane.ERROR_MESSAGE);
									else
										validacion=false;

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}

		return validacion;
	}

	private CursoPosgrado devolver(){

		return new CursoPosgrado(Nombre.getText(),Tema.getText(), Areatext.getText(),(Docente)Facultad.getInstance().buscarProfesor(comboProfesor.getSelectedItem().toString()),((Integer)spinnerCreditos.getValue()),Facultad.getInstance().returnPeoples(arreglo(listaMatricula)), ((Integer)spinnerCantMax.getValue()));
	}

	private String[] arreglo(JList listaMatriculados){
		String[]arreglo= new String[listaMatriculados.getModel().getSize()];
		for(int i=0; i<listaMatriculados.getModel().getSize();i++){
			arreglo[i]=(String) listaMatriculados.getModel().getElementAt(i);
		}
		return arreglo;

	}
	//Añadir
	private void vaciarInterfaz(){
		Nombre.setText("");
		Tema.setText("");
		spinnerCreditos.setValue(1);
		Areatext.setText("Escriba aqui los objetivos del curso");
		comboProfesor.setSelectedIndex(0);
		modelo_matricula.removeAllElements();
		spinnerCantMax.setValue(0);
		modelo_personas.removeAllElements();
		llenarPersonal();
	}

	public void actuEditarProfe(Docente docente){


	}
	////////////////////Metodo Editar de la Ventana de Editar
	private boolean validarDatosEditar(){
		boolean validacion=true;

		try{
			if(Facultad.getInstance().comprobarNombreEditar(Nombre.getText(), indiceee))
				JOptionPane.showMessageDialog(null, "Ya existe un curso con ese mismo nombre", "Error", JOptionPane.ERROR_MESSAGE);
			else
				if(Nombre.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Se le olvido registrar el nombre del curso", "Error", JOptionPane.ERROR_MESSAGE);
				else
					if(Facultad.getInstance().comprobarTemaEditar(Tema.getText(), indiceee))
						JOptionPane.showMessageDialog(null, "Ya existe un curso con ese mismo tema", "Error", JOptionPane.ERROR_MESSAGE);
					else
						if(Tema.getText().equals(""))
							JOptionPane.showMessageDialog(null,"Se le olvido registrar el tema del curso", "Error", JOptionPane.ERROR_MESSAGE);
						else
							if( Areatext.getText().equals(""))
								JOptionPane.showMessageDialog(null,"Se le olvido registrar los objetivos del curso", "Error",JOptionPane.ERROR_MESSAGE);
							else
								if(listaMatricula.getModel().getSize() > (Integer)spinnerCantMax.getValue())
									JOptionPane.showMessageDialog(null,"La matricula excede la cantidad maxima registrada", "Error", JOptionPane.ERROR_MESSAGE);
								else
									validacion=false;

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
		}

		return validacion;
	}
	private CursoPosgrado crearCursoEditado(CursoPosgrado cursito){
		cursito.setNombre(Nombre.getText());
		cursito.setTema(Tema.getText());
		cursito.setProfesor((Docente)Facultad.getInstance().buscarProfesor(comboProfesor.getSelectedItem().toString()));
		cursito.setCreditos((Integer)spinnerCreditos.getValue());
		cursito.setCapacidadMax((Integer)spinnerCantMax.getValue());
		cursito.setPersonasCurso(Facultad.getInstance().returnPeoples(this.arreglo(listaMatricula)));

		return cursito;
	}

	private void validarBotonesAñadir(){
		if(listaPersonal.getSelectedValues().length==0)
			btnMatri.setEnabled(false);
		else
			btnMatri.setEnabled(true);

		if(listaMatricula.getSelectedValues().length==0)
			btnDesma.setEnabled(false);
		else
			btnDesma.setEnabled(true);
	}



}
