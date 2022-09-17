package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.MenuItem;

import seguridad.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabableView;
import javax.swing.JMenuBar;

import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import logica.Facultad;
import logica.Docente;
import logica.Profesional;
import auxiliar.Fecha;
import auxiliar.ResultadoCurso;

import java.awt.Color;
import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.awt.dnd.Autoscroll;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;














import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridLayout;

import javax.swing.SwingConstants;

import java.awt.SystemColor;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.TextArea;

import javax.swing.JPopupMenu;

import java.awt.Component;

import javax.swing.SpinnerNumberModel;

import logica.CursoPosgrado;
import logica.Docente;
import logica.Estudiante;
import logica.Facultad;
import logica.Investigador;
import logica.Persona;
import logica.Profesional;

import java.awt.event.KeyEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JToolBar;
import javax.swing.JTextArea;

import java.awt.ScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;

import javax.swing.JRadioButton;

import principal.Iniciadora;
import seguridad.Papel;

import javax.swing.Box;

import java.awt.TextField;

import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractListModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.peer.SystemTrayPeer;

import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import javax.swing.JTabbedPane;

public class MenuPrincipal2 extends JFrame {

	private JPanel contentPane;
	private JTable tablePersona;
	private JPanel panelPersona;
	private JPanel panelDepartementos;
	private JMenuItem mntmDepartamentos;
	private JTable tableDepartamentos;
	private JPanel panelCursos;
	private JTable tablaMatricula3;
	private JPanel panelInicio;
	private TextArea textArea;
	private JList listaCursos;
	private JScrollPane scrollPane_3;
	private DefaultListModel modelo_lista;
	private JTextField textFieldP;
	private JButton button_3;
	private JPanel panelBotones2;
	private JTextField textFieldT;
	private JSpinner spinnerC;
	private JPanel panelMaestria;
	private JButton botonEditar;
	private JButton botonEliminar;
	private JButton btnTerminarCurso;
	private JTable tablaGrad;
	private JButton btnRegistrarCursos;
	private JButton btnDarVistoBueno;
	private JList listCursitos;
	private JButton Matricular;
	private JTable tableMatrMae;
	private JButton btnEditarPersonas;
	private JButton btnEliminarPersonas;
	private JButton btnEditarDepartamento;
	private JButton btnEliminarDepartamento;
	private JMenu mnArchivo;
	private JMenuBar menuBar;
	private JButton btnDarBaja;
	private JButton btnTerminarMaestria;
	private JMenu mnReportes;
	private JMenuItem mnPos;
	private Papel papel;
	private JTable tabledef;
	private JTabbedPane tabbedPane;


	public  MenuPrincipal2(Papel papel) {
		this.papel=papel;
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal2.class.getResource("/imagenes/SUSE_96px.png")));
		setTitle("Registro General");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(728, 469));

		Dimension scream_size= Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scream_size.width - getWidth()) / 2,(scream_size.height - getHeight())/2);

		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		mnArchivo.setIcon(new ImageIcon(MenuPrincipal2.class.getResource("/imagenes/icons8_Binder_16.png")));
		menuBar.add(mnArchivo);

		JMenuItem mntmRegistrarPersonas = new JMenuItem("Registro de Personas");
		mntmRegistrarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showPanel(1);
			}
		});
		mntmRegistrarPersonas.setIcon(new ImageIcon(MenuPrincipal2.class.getResource("/imagenes/icons8_Add_User_Group_Woman_Man_16.png")));
		mnArchivo.add(mntmRegistrarPersonas);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(MenuPrincipal2.class.getResource("/imagenes/exit.png")));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(EXIT_ON_CLOSE);
			}
		});

		mntmDepartamentos = new JMenuItem("Departamentos");
		mntmDepartamentos.setIcon(new ImageIcon(MenuPrincipal2.class.getResource("/imagenes/icons8_Department_16.png")));
		mntmDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showPanel(2);
			}
		});
		mnArchivo.add(mntmDepartamentos);

		JMenuItem mntmCursosDePosgrado = new JMenuItem("Cursos de Posgrado");
		mntmCursosDePosgrado.setIcon(new ImageIcon(MenuPrincipal2.class.getResource("/imagenes/icons8_Book_16.png")));
		mntmCursosDePosgrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Facultad.getInstance().getPersonas().size()==0)
					JOptionPane.showMessageDialog(null, "No se ha registrado ninguna persona en la Facultad.Por\nfavor registre personal primero", "Error", JOptionPane.ERROR_MESSAGE);
				else{
					showPanel(3);
					llenarListaCursos();
					vaciarPantalla();
				}
			}
		});
		mnArchivo.add(mntmCursosDePosgrado);

		JMenuItem mntmMaestrias = new JMenuItem("Maestr\u00EDa Inform\u00E1tica Aplicada");
		mntmMaestrias.setIcon(new ImageIcon(MenuPrincipal2.class.getResource("/imagenes/icons8_Graduation_Cap_16.png")));
		mntmMaestrias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Facultad.getInstance().getPersonas().size()==0)
					JOptionPane.showMessageDialog(null, "No se ha registrado ninguna persona en la Facultad.Por\nfavor registre personal primero", "Error", JOptionPane.ERROR_MESSAGE);
				else 
					if(Facultad.getInstance().getCursos().size()==0)
						JOptionPane.showMessageDialog(null, "No hay Cursos de Posgrado registrdos ", "Error", JOptionPane.ERROR_MESSAGE);
					else
						showPanel(4);
			}
		});
		mnArchivo.add(mntmMaestrias);
		mnArchivo.add(mntmSalir);

		mnReportes = new JMenu("Reportes");
		mnReportes.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				cambiarMenu0();
				cambiarMenu2();

			}
		});
		mnReportes.setMnemonic('R');
		mnReportes.setIcon(new ImageIcon(MenuPrincipal2.class.getResource("/imagenes/icons8_Presentation_16.png")));
		menuBar.add(mnReportes);

		JMenuItem Dep = new JMenuItem("Actividad investigativa por departamento ");

		mnReportes.add(Dep);

		JMenuItem Act = new JMenuItem("Actividad investigativa de todos los departamentos");
		Act.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Facultad.getInstance().getDepartamentos().size()!=0)
					new VentanaReportes(MenuPrincipal2.this,1).setVisible(true);
				else
					JOptionPane.showMessageDialog(null, "No hay departamentos");
			}
		});
		mnReportes.add(Act);

		mnPos = new JMenuItem("Actividad de posgrado por departamento");
		mnPos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Facultad.getInstance().getCursos().size()==0)
					JOptionPane.showMessageDialog(null, "No hay cursos de posgrado registrados.Registre al\n menos un curso");
			}
		});
		mnReportes.add(mnPos);

		JMenu mnReportesGrficos = new JMenu("Reportes gr\u00E1ficos");
		mnReportes.add(mnReportesGrficos);

		JMenuItem mntmArtculosPorDepartamento = new JMenuItem("Art\u00EDculos por departamento");
		mntmArtculosPorDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Facultad.getInstance().MaxArticulos()!=0){
					VentanaReportes vent= new VentanaReportes(MenuPrincipal2.this, 2);
					vent.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "No hay artículos en los departamentos","Error" ,JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnReportesGrficos.add(mntmArtculosPorDepartamento);

		JMenuItem mntmLneasDeInvestigacin = new JMenuItem("L\u00EDneas de Investigaci\u00F3n por departamento");
		mntmLneasDeInvestigacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaReportes vent= new VentanaReportes(MenuPrincipal2.this, 3);
				vent.setVisible(true);
			}
		});
		mnReportesGrficos.add(mntmLneasDeInvestigacin);

		JMenuItem mntmPorcientoDeGraduados = new JMenuItem("% graduados de los matriculados en Maestr\u00EDa");
		mntmPorcientoDeGraduados.setIcon(null);
		mntmPorcientoDeGraduados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Facultad.getInstance().getMaestria().getCantidadMatriculados()!= 0)
					new ReporteVisualGrafico().setVisible(true);
				else
					JOptionPane.showMessageDialog(null, "No hay matriculados en la Maestría", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		mnReportesGrficos.add(mntmPorcientoDeGraduados);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('Y');
		mnAyuda.setIcon(new ImageIcon(MenuPrincipal2.class.getResource("/imagenes/icons8_Help_16.png")));

		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaCreditos(MenuPrincipal2.this,true).setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Contenido de ayuda");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Ayuda(MenuPrincipal2.this, true).setVisible(true);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MenuPrincipal2.class.getResource("/imagenes/icons8_Help_16.png")));
		mnAyuda.add(mntmNewMenuItem_1);
		mntmAcercaDe.setIcon(new ImageIcon(MenuPrincipal2.class.getResource("/imagenes/icons8_E-Learning_16.png")));
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);


		contentPane.setBorder(new LineBorder(Color.DARK_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		panelPersona = new JPanel();
		panelPersona.setBackground(SystemColor.menu);
		contentPane.add(panelPersona, "name_261885932949800");
		panelPersona.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 27, 700, 357);
		panelPersona.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				validarBotonesPersona();
			}
		});
		panel.add(scrollPane, BorderLayout.CENTER);

		tablePersona = new JTable(){
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		tablePersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				validarBotonesPersona();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				validarBotonesPersona();
			}
		});
		scrollPane.setViewportView(tablePersona);

		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(0, 384, 720, 33);
		panelPersona.add(panelBotones);

		JButton btnAadir = new JButton("A\u00F1adir Integrante");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaPersona(MenuPrincipal2.this).setVisible(true);
			}
		});

		btnEditarPersonas = new JButton("Editar Integrante");
		btnEditarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tablePersona.getSelectedRow()==-1)
					JOptionPane.showMessageDialog(null, "Seleccione una fila");
				else{
					new VentanaPersona(MenuPrincipal2.this, Facultad.getInstance().getPersonas().get(tablePersona.getSelectedRow())).setVisible(true);
					tablePersona.getSelectionModel().clearSelection();
					validarBotonesPersona();
				}
			}
		});

		btnEliminarPersonas = new JButton("Eliminar Integrante");
		btnEliminarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tablePersona.getSelectedRow()==-1)
					JOptionPane.showMessageDialog(null,"Seleccione una fila","Error", JOptionPane.ERROR_MESSAGE);
				else{

					eliminarPersona();
					tablePersona.getSelectionModel().clearSelection();
					validarBotonesPersona();
				}
			}
		});
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelBotones.add(btnAadir);
		panelBotones.add(btnEditarPersonas);
		panelBotones.add(btnEliminarPersonas);

		JPanel panel_13 = new JPanel();
		panel_13.setBounds(0, 0, 720, 27);
		panelPersona.add(panel_13);

		JLabel lblListaDePersonas = new JLabel("Lista de Personas de la Facultad");
		lblListaDePersonas.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_13.add(lblListaDePersonas);

		panelDepartementos = new JPanel();
		contentPane.add(panelDepartementos, "name_261886012960400");
		panelDepartementos.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panelDepartementos.add(panel_1, BorderLayout.CENTER);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 0, 700, 357);
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				validarBotonesDepartamento();
			}
		});
		panel_1.setLayout(null);
		panel_1.add(scrollPane_1);

		tableDepartamentos = new JTable(){
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		tableDepartamentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				validarBotonesDepartamento();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				validarBotonesDepartamento();
			}
		});
		scrollPane_1.setViewportView(tableDepartamentos);

		JPanel panel_Botones = new JPanel();
		panelDepartementos.add(panel_Botones, BorderLayout.SOUTH);

		JButton btnAadirDepartamento = new JButton("A\u00F1adir Departamento");
		btnAadirDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaDepartament(MenuPrincipal2.this).setVisible(true);
				tableDepartamentos.getSelectionModel().clearSelection();
				validarBotonesDepartamento();
			}
		});
		panel_Botones.add(btnAadirDepartamento);

		btnEditarDepartamento = new JButton("Editar Departamento");
		btnEditarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableDepartamentos.getSelectedRow()==-1)
					JOptionPane.showMessageDialog(null, "Seleccione una fila");
				else{
					new VentanaDepartament(Facultad.getInstance().getDepartamentos().get(tableDepartamentos.getSelectedRow()), MenuPrincipal2.this).setVisible(true);
					tableDepartamentos.getSelectionModel().clearSelection();
					validarBotonesDepartamento();
				}
			}
		});
		panel_Botones.add(btnEditarDepartamento);

		btnEliminarDepartamento = new JButton("Eliminar Departamento");
		btnEliminarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableDepartamentos.getSelectedRow()==-1)
					JOptionPane.showMessageDialog(null, "Seleccione una fila","Mensaje", 0);
				else 
				{
					if(JOptionPane.showConfirmDialog(null, "Desea eliminar el departamento seleccionado","Seleccione una opción",0)==JOptionPane.YES_OPTION){					
						Facultad.getInstance().getDepartamentos().remove(tableDepartamentos.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Departamento eliminado correctamente");
						llenarTablaDespartanto();
						tableDepartamentos.getSelectionModel().clearSelection();
						validarBotonesDepartamento();
					}
				}
			}
		});
		panel_Botones.add(btnEliminarDepartamento);

		JPanel panel_6 = new JPanel();
		panelDepartementos.add(panel_6, BorderLayout.NORTH);

		JLabel lblListaDeDepartamento = new JLabel("Lista de Departamentos de la Facultad");
		lblListaDeDepartamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(lblListaDeDepartamento);

		panelCursos = new JPanel();
		contentPane.add(panelCursos, "name_261886058880800");
		panelCursos.setLayout(new BorderLayout(95, 3));

		panelBotones2 = new JPanel();
		panelCursos.add(panelBotones2, BorderLayout.SOUTH);

		button_3 = new JButton("A\u00F1adir");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Facultad.getInstance().check(1)){
					new VentanaAñadirCurso(MenuPrincipal2.this).setVisible(true);
				}

			}
		});
		panelBotones2.add(button_3);

		botonEditar = new JButton("Editar");
		botonEditar.setEnabled(false);
		botonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!listaCursos.isSelectionEmpty()){
					new VentanaAñadirCurso(MenuPrincipal2.this,Facultad.getInstance().buscarCurso(listaCursos.getSelectedValue().toString()), listaCursos.getSelectedIndex()).setVisible(true);

				}
				else{
					JOptionPane.showMessageDialog(null,"No ha seleccionado un curso.Intente de nuevo");
				}
				tablaMatricula3.clearSelection();
				validarBotonesInfCurso();

			}
		});
		panelBotones2.add(botonEditar);

		botonEliminar = new JButton("Eliminar");
		botonEliminar.setEnabled(false);
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!listaCursos.isSelectionEmpty()){
					if(JOptionPane.showConfirmDialog(null, "Está seguro de eliminar los cursos seleccionados", "Seleccione una opción", 0)==JOptionPane.OK_OPTION){
						eliminarCurso(listaCursos.getSelectedIndex());
						JOptionPane.showMessageDialog(null,"Se ha eliminado el curso satisfactoriamente");
						llenarListaCursos();
						vaciarPantalla();
						listaCursos.setSelectedIndex(listaCursos.getModel().getSize()-1);
						if(listaCursos.getModel().getSize()==0){
							JOptionPane.showMessageDialog(null, "No quedan cursos me temo que debe salir");
							showPanel(0);
						}

					}

				}
				else
					JOptionPane.showMessageDialog(null, "No ha seleccionado un curso.Intente de nuevo");
				validarBotonesInfCurso();
			}
		});
		panelBotones2.add(botonEliminar);


		JPanel panelCentral = new JPanel();
		panelCursos.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cursos de Posgrado", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 0, 113, 336);
		panelCentral.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				validarBotonesInfCurso();
			}
		});
		panel_2.add(scrollPane_2, BorderLayout.CENTER);

		listaCursos = new JList();
		listaCursos.setBackground(SystemColor.inactiveCaptionBorder);
		listaCursos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				validarBotonesInfCurso();
			}
		});
		listaCursos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(listaCursos.getModel().getSize()>0){
					botonEditar.setEnabled(true);
					botonEliminar.setEnabled(true);
					if(listaCursos.isFocusOwner()){
						llenarDatos(listaCursos.getSelectedValue().toString());
						llenarTabla(listaCursos.getSelectedValue().toString());
					}
					else
						if(!listaCursos.isSelectionEmpty()){
							llenarDatos(listaCursos.getSelectedValue().toString());
							llenarTabla(listaCursos.getSelectedValue().toString());
						}
				}
			}
		}
				);





		listaCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane_2.setViewportView(listaCursos);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "General", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_3.setBounds(125, 0, 591, 336);
		panelCentral.add(panel_3);
		panel_3.setLayout(null);

		JLabel label_1 = new JLabel("Tema:");
		label_1.setBounds(10, 26, 46, 20);
		panel_3.add(label_1);

		JLabel label_2 = new JLabel("Profesor:");
		label_2.setBounds(10, 57, 57, 14);
		panel_3.add(label_2);

		JLabel lblCrditos = new JLabel("Cr\u00E9ditos:");
		lblCrditos.setBounds(10, 85, 57, 14);
		panel_3.add(lblCrditos);

		JPanel panel_4 = new JPanel();

		panel_4.setBounds(256, 11, 325, 314);
		panel_4.setBorder(new TitledBorder(null, "Matr\u00EDcula", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		scrollPane_3 = new JScrollPane();
		scrollPane_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				validarBotonesCurso();
			}
		});
		panel_4.add(scrollPane_3);

		tablaMatricula3 = new JTable(){
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
		};


		tablaMatricula3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				validarBotonesCurso();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				validarBotonesCurso();
			}
		});

		tablaMatricula3.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		scrollPane_3.setViewportView(tablaMatricula3);

		btnTerminarCurso = new JButton("Terminar Curso");
		btnTerminarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!listaCursos.isSelectionEmpty() && tablaMatricula3.getSelectedRow()!=-1){
					if(JOptionPane.showConfirmDialog(null, "Esta seguro que los seleccionados terminaron el curso "+listaCursos.getSelectedValue().toString(),"Seleccione una opción",0)==JOptionPane.YES_OPTION){
						terminarCurso(tablaMatricula3.getSelectedRows(),buscarXindex(listaCursos.getSelectedIndex()));
						JOptionPane.showMessageDialog(null, "Los seleccionados han terminado el curso satisfactoriamente");
						llenarTabla(listaCursos.getSelectedValue().toString());
						tablaMatricula3.getSelectionModel().clearSelection();
						validarBotonesCurso();

					}
				}
				else
					JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila de la tabla.Por favor\n intente de nuevo");
			}


		});
		btnTerminarCurso.setEnabled(false);
		panel_4.add(btnTerminarCurso, BorderLayout.SOUTH);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 110, 242, 215);
		panel_5.setBorder(new TitledBorder(null, "Objetivos", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_3.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		textArea = new TextArea();
		textArea.setEditable(false);
		panel_5.add(textArea, BorderLayout.CENTER);

		textFieldP = new JTextField();
		textFieldP.setEditable(false);
		textFieldP.setBounds(61, 54, 185, 20);
		panel_3.add(textFieldP);
		textFieldP.setColumns(10);

		spinnerC = new JSpinner();
		spinnerC.setEnabled(false);
		spinnerC.setBounds(61, 82, 57, 20);
		panel_3.add(spinnerC);

		textFieldT = new JTextField();
		textFieldT.setBounds(61, 26, 185, 20);
		panel_3.add(textFieldT);
		textFieldT.setEditable(false);
		textFieldT.setColumns(10);

		panelInicio = new JPanel();
		contentPane.add(panelInicio, "name_261892613499000");
		panelInicio.setLayout(new BorderLayout(0, 0));

		JPanel panel_16 = new JPanel();
		panelInicio.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(null);

		Fecha fchjun = new Fecha();
		fchjun.setForeground(new Color(255, 204, 153));
		fchjun.setFont(new Font("Arial Black", Font.BOLD, 14));
		fchjun.setBounds(595, 11, 115, 21);
		panel_16.add(fchjun);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 720, 417);
		label.setIcon(new ImageIcon(MenuPrincipal2.class.getResource("/imagenes/64791512_543305246203245_276157469025402861_n.png")));
		panel_16.add(label);

		modelo_lista=new DefaultListModel();
		listaCursos.setModel(modelo_lista);

		JPanel panel_14 = new JPanel();
		panelCursos.add(panel_14, BorderLayout.NORTH);

		JLabel lblCursosDePosgrado = new JLabel("Cursos de Posgrado de la Facultad");
		lblCursosDePosgrado.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_14.add(lblCursosDePosgrado);

		panelMaestria = new JPanel();
		contentPane.add(panelMaestria, "name_111586971488600");
		panelMaestria.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(null);
		panel_8.setBounds(0, 11, 712, 395);
		panelMaestria.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblPlanDeEstudio = new JLabel("Plan de Estudio de la Maestr\u00EDa \"Inform\u00E1tica Aplicada\"");
		lblPlanDeEstudio.setBounds(181, 0, 383, 19);
		panel_8.add(lblPlanDeEstudio);
		lblPlanDeEstudio.setFont(new Font("Tahoma", Font.BOLD, 14));

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 23, 167, 309);
		panel_8.add(panel_7);
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Asignaturas Definidas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_7.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_4 = new JScrollPane();
		panel_7.add(scrollPane_4);

		listCursitos = new JList();
		listCursitos.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listCursitos.setEnabled(false);
		listCursitos.setBackground(SystemColor.menu);
		listCursitos.setForeground(Color.BLACK);
		scrollPane_4.setViewportView(listCursitos); 

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Matr\u00EDcula", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_9.setBounds(181, 23, 521, 173);
		panel_8.add(panel_9);
		panel_9.setLayout(null);
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(6, 143, 509, 23);
		panel_9.add(panel_10);
		panel_10.setLayout(null);

		btnDarVistoBueno = new JButton("Dar visto bueno");
		btnDarVistoBueno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableMatrMae.getSelectedRow()!=-1){
					if(JOptionPane.showConfirmDialog(null, "Está seguro que desea darle el visto bueno \na los seleccionados","Seleccione una opción",0) ==JOptionPane.YES_OPTION)
						if(!verificarMatriculados()){
							darVistoBueno(tableMatrMae);
							actualizarTablaDefender();
							actualizarTablaMatricula();
						}
				}
				else
					JOptionPane.showMessageDialog(null, "Seleccione una fila");
				validarBotonesMaestriaMat();
				tabledef.clearSelection();
				tablaGrad.clearSelection();
				actualizarTerminar();
			}
		});
		btnDarVistoBueno.setBounds(393, 0, 116, 23);
		btnDarVistoBueno.setEnabled(false);
		panel_10.add(btnDarVistoBueno);

		Matricular = new JButton("Matricular");
		Matricular.setBounds(0, 0, 95, 23);
		panel_10.add(Matricular);
		Matricular.setToolTipText("Aquí podrá gestionar la matrícula ");
		Matricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listCursitos.getModel().getSize()>0)
					new MatricularMaestria(MenuPrincipal2.this).setVisible(true);
				else
					JOptionPane.showMessageDialog(null, "No ha añadido ningún curso al Plan de Estudios \nde la Maestría");
				validarBotonesMaestriaMat();
				tabledef.clearSelection();
				actualizarTerminar();
			}
		});

		btnDarBaja = new JButton("Dar baja");
		btnDarBaja.setEnabled(false);
		btnDarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableMatrMae.getSelectedRow()!=-1){
					int valor=JOptionPane.showConfirmDialog(null, "Esta seguro que desea darle baja de la maestria");
					if(valor==JOptionPane.OK_OPTION)
						darBaja();
				}
				else
					JOptionPane.showMessageDialog(null, "Seleccione una fila");
				tableMatrMae.getSelectionModel().clearSelection();
				validarBotonesMaestriaMat();
				tabledef.clearSelection();
				actualizarTerminar();
			}
		});

		btnDarBaja.setBounds(111, 0, 89, 23);
		panel_10.add(btnDarBaja);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				validarBotonesMaestriaMat();
			}
		});
		scrollPane_7.setBounds(6, 20, 509, 123);
		panel_9.add(scrollPane_7);

		tableMatrMae = new JTable(){
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		tableMatrMae.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				validarBotonesMaestriaMat();
				tablaGrad.getSelectionModel().clearSelection();
			}
		});
		tableMatrMae.setBorder(null);
		tableMatrMae.setBackground(SystemColor.menu);
		scrollPane_7.setViewportView(tableMatrMae);

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "Defensa y final de curso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_11.setBounds(181, 196, 521, 188);
		panel_8.add(panel_11);
		panel_11.setLayout(null);

		JPanel panel_12 = new JPanel();
		panel_12.setBounds(10, 21, 501, 156);
		panel_11.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));

		JPanel panel_15 = new JPanel();
		panel_12.add(panel_15, BorderLayout.SOUTH);
		panel_15.setLayout(new GridLayout(0, 5, 0, 0));

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_15.add(horizontalStrut_1);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_15.add(horizontalStrut_2);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_15.add(horizontalStrut_3);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_15.add(horizontalStrut);

		btnTerminarMaestria = new JButton("Terminar");
		btnTerminarMaestria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tabledef.getSelectedRow()!=-1){
					if(JOptionPane.showConfirmDialog(null, "Esta seguro que desea graduar a los seleccionados","Seleccione una opción",0)== JOptionPane.YES_OPTION)
					{
						graduar();
						actualizarTablaDefender();
						actualizarGraduados();
					}

				}
				else
					JOptionPane.showMessageDialog(null, "Seleccione una fila");
				tableMatrMae.getSelectionModel().clearSelection();
				actualizarTerminar();
			}
		});
		panel_15.add(btnTerminarMaestria);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabledef.clearSelection();
				tablaGrad.clearSelection();
				actualizarTerminar();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				tabledef.clearSelection();
				tablaGrad.clearSelection();
				actualizarTerminar();
			}
		});
		panel_12.add(tabbedPane, BorderLayout.CENTER);

		JScrollPane scrollPane_5 = new JScrollPane();
		tabbedPane.addTab("Defendiendo", null, scrollPane_5, null);

		tabledef = new JTable() {
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}
		};
		tabledef.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			actualizarTerminar();
			}
		});
		scrollPane_5.setViewportView(tabledef);

		JScrollPane scrollPane_6 = new JScrollPane();
		tabbedPane.addTab("Graduados", null, scrollPane_6, null);
		tablaGrad = new JTable(){
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
			@Override
			public boolean isCellSelected(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		scrollPane_6.setViewportView(tablaGrad);

		btnRegistrarCursos = new JButton("Registrar Cursos");
		btnRegistrarCursos.setBounds(20, 343, 139, 23);
		panel_8.add(btnRegistrarCursos);
		btnRegistrarCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AñadirCurMaestria(MenuPrincipal2.this).setVisible(true);

			}
		});
		tablaGrad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tableMatrMae.getSelectionModel().clearSelection();
				validarBotonesMaestriaMat();
			}
		});


		showPanel(0);
		bloqAdmin();

	}


	//Arreglar aqui
	protected boolean verificarMatriculados() {
		boolean ok=true;
		try{
			for(int i=0; i<tableMatrMae.getSelectedRows().length; i++){
				if((Integer)tableMatrMae.getModel().getValueAt(tableMatrMae.getSelectedRows()[i], 3) != Facultad.getInstance().getMaestria().getCursosMaestria().size()){
					throw new Exception("Los seleccionados tienen que vencer todas las asignaturas del plan de estudio");
				}
			}
			ok=false;

		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return ok;
	}

	public void showPanel(int valor){
		for(int i=0; i<contentPane.getComponentCount();i++){
			contentPane.getComponent(i).setVisible(false);
		}
		validarBotonesDepartamento();
		actualizarTable_Bottones();
		validarBotonesMaestriaMat();
		llenarTablaDespartanto();
		validarBotonesMaestriaMat();
		actualizarTablaMatricula(); 
		actualizarTablaDefender();
		actualizarGraduados();
		validarBotonesMaestriaMat();
		validarBtnMatricular();
		switch (valor) {
		case 0:
			//Panel Inicio
			panelInicio.setVisible(true);
			validarBotonesDepartamento();
			break;
		case  1:
			//Panel Persona
			panelPersona.setVisible(true);
			DefaultTableModel modelo_tablaP= new DefaultTableModel(new String[]{"Nombre","Sexo","Edad","Tipo","Resultado de investigación"},0);
			tablePersona.setModel(modelo_tablaP);
			actualizarTable_Bottones();
			validarBotonesMaestriaMat();

			break;
		case  2:
			//Panel Departamentos
			panelDepartementos.setVisible(true);
			llenarTablaDespartanto();
			validarBotonesMaestriaMat();
			break;
		case 3:
			//Panel de los Cursos de Posgrado
			panelCursos.setVisible(true);
			validarBotonesMaestriaMat();
			DefaultTableModel modeloTablaMatricula= new DefaultTableModel(new String[]{"Nombre","Edad","Sexo"},0);
			tablaMatricula3.setModel(modeloTablaMatricula);
			if(validarCursos()==true){
				if(JOptionPane.showConfirmDialog(null, "No se ha registrado ningún curso.Desea\nregistrar alguno","Seleccione una opción",0)== JOptionPane.YES_OPTION){
					new VentanaAñadirCurso(MenuPrincipal2.this).setVisible(true);}
				else {
					showPanel(0);
				}

			}
			break;
		case 4:
			//Panel de la Maestria
			panelMaestria.setVisible(true);
			actualizarTablaMatricula(); 
			actualizarTablaDefender();
			actualizarGraduados();
			validarBotonesMaestriaMat();
			break;

		}
	}
	public void actualizarTablaMatricula(){

		DefaultTableModel modelo= new DefaultTableModel(new String []{"Nombre","Edad","Sexo","Asig/Vencidas"},0);

		for(int i =0; i<Facultad.getInstance().getPersonas().size();i++){
			if(Facultad.getInstance().getPersonas().get(i) instanceof Docente){
				if(((Docente)Facultad.getInstance().getPersonas().get(i)).getMatricula()!=null)
					if(((Docente)Facultad.getInstance().getPersonas().get(i)).getCategoriaC().equals("Ninguna"))
						if(!((Docente)Facultad.getInstance().getPersonas().get(i)).getMatricula().isGraduadoMaestria())
							if(!((Docente)Facultad.getInstance().getPersonas().get(i)).getMatricula().isVistoBueno())
								modelo.addRow(new Object[]{Facultad.getInstance().getPersonas().get(i).getNombre(),Facultad.getInstance().getPersonas().get(i).getEdad(),Facultad.getInstance().getPersonas().get(i).getSexo(),Facultad.getInstance().getMaestria().cantidadCursos(Facultad.getInstance().getPersonas().get(i))});
			}
			else{
				if(Facultad.getInstance().getPersonas().get(i) instanceof Profesional)
					if(((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula()!=null)
						if(!((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula().isGraduadoMaestria())
							if(!((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula().isVistoBueno())
								modelo.addRow(new Object[]{Facultad.getInstance().getPersonas().get(i).getNombre(),Facultad.getInstance().getPersonas().get(i).getEdad(),Facultad.getInstance().getPersonas().get(i).getSexo(),Facultad.getInstance().getMaestria().cantidadCursos(Facultad.getInstance().getPersonas().get(i))});
			}
		}
		tableMatrMae.setModel(modelo);

	}





	private boolean validarCursos(){
		boolean verificacion=false;
		if(Facultad.getInstance().getCursos().size()==0){
			verificacion=true;
		}
		return verificacion;
	}

	public void llenarListaCursos(){
		if(listaCursos.getModel().getSize() > 0){
			modelo_lista.removeAllElements();
			for(int i=0;i<Facultad.getInstance().getCursos().size();i++)
				modelo_lista.addElement(Facultad.getInstance().getCursos().get(i).getNombre());

		}
		else{
			for(int i=0;i<Facultad.getInstance().getCursos().size();i++)
				modelo_lista.addElement(Facultad.getInstance().getCursos().get(i).getNombre());
		}
	}

	//LLenar todos los campos de informacion
	private void llenarDatos(String nombreCurso){
		CursoPosgrado curso=Facultad.getInstance().buscarCurso(nombreCurso);
		textFieldT.setText(curso.getTema());
		textFieldP.setText(curso.getProfesor().getNombre());
		spinnerC.setValue(curso.getCreditos());
		textArea.setText(curso.getObjetivos());
	}
	private void llenarTabla(String nombreCurso){
		DefaultTableModel modeloTablaMatrix= new DefaultTableModel(new String[]{"Nombre","Edad","Centro"},0);
		CursoPosgrado curso=Facultad.getInstance().buscarCurso(nombreCurso);

		for(int i=0; i<curso.getPersonasCurso().size();i++){
			modeloTablaMatrix.addRow(new Object[]{curso.getPersonasCurso().get(i).getNombre(),curso.getPersonasCurso().get(i).getEdad(),devolverCentro(curso.getPersonasCurso().get(i))});
		}
		tablaMatricula3.setModel(modeloTablaMatrix);

	}
	//Este metodo devuelve un String que seria el centro de trabajo o el nombre de la facultad dependiendo de la persona(Se llama 4 lineas arriba)
	private String devolverCentro(Persona e){
		String centroTrabajo="";
		if(e instanceof Docente){
			centroTrabajo=((Docente) e).getFacultad();
		}
		else if(e instanceof Profesional){
			centroTrabajo=((Profesional) e).getCentroTrabajo();
		}
		return centroTrabajo;
	}


	//Buscar el indice en el Array de Cursos y devolver este dado un curso
	public int indexCurso(CursoPosgrado curso){
		int index=0;
		for(int i=0; i<Facultad.getInstance().getCursos().size();i++){
			if(Facultad.getInstance().getCursos().get(i).getNombre().equals(curso.getNombre()))
				index=i;
		}
		return index;
	}



	private void eliminarCurso(int index){
		Facultad.getInstance().getCursos().remove(index);

	}
	public JList devolverListaCurso(){
		return listaCursos;
	}

	public JList devolverListaCursito(){
		return listCursitos;
	}

	//Dadas las filas de la tabla de la matricula y el curso de posgrado seleccionado en la lista 
	private void terminarCurso(int[] index,CursoPosgrado cursitoSeleccionado){
		ResultadoCurso resultado= new ResultadoCurso(cursitoSeleccionado.getNombre(),cursitoSeleccionado.getCreditos());

		for(int i=0;i<index.length; i++){
			if(cursitoSeleccionado.getPersonasCurso().get(index[i]) instanceof Docente){
				((Docente)cursitoSeleccionado.getPersonasCurso().get(index[i])).getResultadoCursos().add(resultado);
			}
			else{
				((Profesional)cursitoSeleccionado.getPersonasCurso().get(index[i])).getResultadoCursos().add(resultado);
			}
			cursitoSeleccionado.getPersonasCurso().set(index[i], null);
		}
		for(int x=0;x<index.length;x++){
			boolean encontrado=true;
			for(int j=0;j<cursitoSeleccionado.getPersonasCurso().size() && encontrado;j++){
				if(cursitoSeleccionado.getPersonasCurso().get(j)==null){
					encontrado=false;
					cursitoSeleccionado.getPersonasCurso().remove(j);
				}
			}
		}
	}

	private CursoPosgrado buscarXindex(int index){
		return Facultad.getInstance().getCursos().get(index);
	}

	public boolean estaMatriculado(String nombrePersona,CursoPosgrado cursito){
		boolean estaMatric=false;
		for(int i=0;i<cursito.getPersonasCurso().size() && !estaMatric ;i++){
			if(cursito.getPersonasCurso().get(i).getNombre().equals(nombrePersona))
				estaMatric=true;
		}
		return estaMatric;
	}


	public void actualizarTable_Bottones()
	{
		validarBotonesPersona();
		DefaultTableModel modelo=new DefaultTableModel(new String []{"Nombre","Sexo","Edad","Tipo","Facultad","Resultado"},0){
			@Override public Class getColumnClass(int columnIndex) {
				Class[] types = new Class [] {  
						java.lang.String.class,
						java.lang.String.class,
						java.lang.String.class,
						java.lang.String.class,
						java.lang.String.class,
						java.lang.String.class,
						ImageIcon.class,
				};
				return types[columnIndex];
			}
		};
		for(int x=0;x<Facultad.getInstance().getPersonas().size();x++)
		{
			if(Facultad.getInstance().getPersonas().get(x) instanceof Docente)
				modelo.addRow(new Object[]{Facultad.getInstance().getPersonas().get(x).getNombre(),Facultad.getInstance().getPersonas().get(x).getSexo(),Facultad.getInstance().getPersonas().get(x).getEdad(),"Docente",((Docente)Facultad.getInstance().getPersonas().get(x)).getFacultad(),((Investigador)Facultad.getInstance().getPersonas().get(x)).getCantTotalArt(),new ImageIcon(getClass().getClassLoader().getResource("imagenes/gohome.png"))});
			else if(Facultad.getInstance().getPersonas().get(x) instanceof Estudiante)
				modelo.addRow(new Object[]{Facultad.getInstance().getPersonas().get(x).getNombre(),Facultad.getInstance().getPersonas().get(x).getSexo(),Facultad.getInstance().getPersonas().get(x).getEdad(),"Estudiante","Informatica",((Investigador)Facultad.getInstance().getPersonas().get(x)).getCantTotalArt()});
			else
				modelo.addRow(new Object[]{Facultad.getInstance().getPersonas().get(x).getNombre(),Facultad.getInstance().getPersonas().get(x).getSexo(),Facultad.getInstance().getPersonas().get(x).getEdad(),"Profesional","No tiene","No investiga"});
		}
		tablePersona.setModel(modelo);
	}


	private void eliminarPersona(){
		try{
			if(tablePersona.getSelectedRowCount()<0)
				throw new Exception("Seleccione una fila de la tabla");
			else
				if(Facultad.getInstance().removerPerson(Facultad.getInstance().getPersonas().get(tablePersona.getSelectedRow()))){
					JOptionPane.showMessageDialog(null, "Persona eliminada correctamente");
					actualizarTable_Bottones();
				}

		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public JButton devolverBoton(){
		return btnRegistrarCursos;
	}
	public JButton devolverVistobueno(){
		return btnDarVistoBueno;
	}





	public void llenarTablaDespartanto()
	{
		DefaultTableModel modelo= new DefaultTableModel(new String[]{"Departamento","Jefe del Departamento","Cantidad Líneas","Cantidad Investigadores"},0);
		for(int x=0;x< Facultad.getInstance().getDepartamentos().size();x++){
			int personas=0;
			for(int y=0;y<Facultad.getInstance().getDepartamentos().get(x).getLineasInvestigacion().size();y++)
				for(int z=0;z<Facultad.getInstance().getDepartamentos().get(x).getLineasInvestigacion().get(y).getTemasInvestigacion().size();z++)
					personas+=Facultad.getInstance().getDepartamentos().get(x).getLineasInvestigacion().get(y).getTemasInvestigacion().get(z).getInvestigadores().size();
			modelo.addRow(new Object[]{Facultad.getInstance().getDepartamentos().get(x).getNombre(),Facultad.getInstance().getDepartamentos().get(x).getResponsable().getNombre(),Facultad.getInstance().getDepartamentos().get(x).getLineasInvestigacion().size(),personas});
		}
		tableDepartamentos.setModel(modelo);
	}
	public JTable devolverTabla_Maestri(){
		return tableMatrMae;
	}


	private void  actualizarTablaDefender(){
		DefaultTableModel modelo=new DefaultTableModel(new Object[]{"Nombre","Edad","Sexo","Tipo"},0);

		for(int i=0;i<Facultad.getInstance().getPersonas().size();i++){
			if(Facultad.getInstance().getPersonas().get(i) instanceof Docente){
				if(((Docente)Facultad.getInstance().getPersonas().get(i)).getMatricula()!=null)
					if(((Docente)Facultad.getInstance().getPersonas().get(i)).getMatricula().getNombreCursosMaestria().size()>0)
						if(((Docente)Facultad.getInstance().getPersonas().get(i)).getMatricula().isVistoBueno())
							if(!((Docente)Facultad.getInstance().getPersonas().get(i)).getMatricula().isGraduadoMaestria())
								modelo.addRow(new Object[]{((Docente)Facultad.getInstance().getPersonas().get(i)).getNombre(),((Docente) Facultad.getInstance().getPersonas().get(i)).getEdad(),((Docente) Facultad.getInstance().getPersonas().get(i)).getSexo(),((Docente)Facultad.getInstance().getPersonas().get(i)).getClass().getSimpleName()});
			}
			else
				if(Facultad.getInstance().getPersonas().get(i) instanceof Profesional)
					if(((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula()!=null)
						if(((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula().getNombreCursosMaestria().size()>0)
							if(((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula().isVistoBueno())
								if(!((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula().isGraduadoMaestria() && ((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula().getNombreCursosMaestria().size()>0)
									modelo.addRow(new Object[]{((Profesional)Facultad.getInstance().getPersonas().get(i)).getNombre(),((Profesional) Facultad.getInstance().getPersonas().get(i)).getEdad(),((Profesional) Facultad.getInstance().getPersonas().get(i)).getSexo(),((Profesional)Facultad.getInstance().getPersonas().get(i)).getClass().getSimpleName()});

		}

		tabledef.setModel(modelo);
		btnTerminarMaestria.setEnabled(true);
	}


	/*private void defenderMaestria(Persona persona){
		if(persona instanceof Docente){
			((Docente)persona).getMatricula().setVistoBueno(true);
		}else
			if(persona instanceof Profesional){
				((Profesional)persona).getMatricula().setVistoBueno(true);
			}
	}*/

	public void bloqAdmin()
	{
		if(papel.equals(Papel.Cliente))
			menuBar.remove(mnArchivo);

	}
	////////////////////////////
	//Funciones que he agregado al programa
	private void vaciarPantalla(){
		textFieldT.setText("");
		textFieldP.setText("");
		spinnerC.setValue(0);
		textArea.setText("");
		DefaultTableModel modeloVacio= new DefaultTableModel();
		tablaMatricula3.setModel(modeloVacio);
		if(listaCursos.getModel().getSize()>0)
			listaCursos.setSelectedIndex(0);
	}

	private void actualizarGraduados(){
		DefaultTableModel modeloG= new DefaultTableModel(new String[]{"Nombre","Edad","Sexo","Tipo"},0);

		for(int i=0;i<Facultad.getInstance().getPersonas().size();i++){
			if(Facultad.getInstance().getPersonas().get(i) instanceof Docente){
				if(((Docente)Facultad.getInstance().getPersonas().get(i)).getMatricula()!=null)
					if(((Docente)Facultad.getInstance().getPersonas().get(i)).getMatricula().getNombreCursosMaestria().size()>0)
						if(((Docente)Facultad.getInstance().getPersonas().get(i)).getMatricula().isVistoBueno())
							if(((Docente)Facultad.getInstance().getPersonas().get(i)).getMatricula().isGraduadoMaestria())
								modeloG.addRow(new Object[]{((Docente)Facultad.getInstance().getPersonas().get(i)).getNombre(),((Docente) Facultad.getInstance().getPersonas().get(i)).getEdad(),((Docente) Facultad.getInstance().getPersonas().get(i)).getSexo(),((Docente)Facultad.getInstance().getPersonas().get(i)).getClass().getSimpleName()});
			}
			else
				if(Facultad.getInstance().getPersonas().get(i) instanceof Profesional)
					if(((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula()!=null)
						if(((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula().getNombreCursosMaestria().size()>0)
							if(((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula().isVistoBueno())
								if(((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula().isGraduadoMaestria() && ((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula().getNombreCursosMaestria().size()>0)
									modeloG.addRow(new Object[]{((Profesional)Facultad.getInstance().getPersonas().get(i)).getNombre(),((Profesional) Facultad.getInstance().getPersonas().get(i)).getEdad(),((Profesional) Facultad.getInstance().getPersonas().get(i)).getSexo(),((Profesional)Facultad.getInstance().getPersonas().get(i)).getClass().getSimpleName()});

		}

		tablaGrad.setModel(modeloG);
		btnTerminarMaestria.setEnabled(false);
	}
	//Esto me devulve los nombres de las personas seleccionadas por fila con lo que se los paso a otra funcion que lo que hace es buscarlos y actualizarles su atributo Matricula
	//poniendole el visto bueno en true
	private void darVistoBueno(JTable tabla){
		for(int i=0; i<tabla.getModel().getRowCount();i++){
			if(tabla.isRowSelected(i))
				if(Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))instanceof Docente)
					((Docente)Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))).getMatricula().setVistoBueno(true);
				else 
					if(Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))instanceof Profesional)
						((Profesional)Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))).getMatricula().setVistoBueno(true);

		}
		DefaultTableModel modelito_defensa=new DefaultTableModel(new String[]{"Nombre","Edad","Sexo","Tipo"},0);

		for(int i=0; i<tabla.getModel().getRowCount();i++){
			if(tabla.isRowSelected(i)){
				if(Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))instanceof Docente)
					modelito_defensa.addRow(new Object[]{((Docente)Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))).getNombre(),((Docente)Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))).getEdad(),((Docente)Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))).getSexo(),((Docente)Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))).getClass().getSimpleName()});
			}
			else
				if(Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))instanceof Profesional){
					modelito_defensa.addRow(new Object[]{((Profesional)Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))).getNombre(),((Profesional)Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))).getEdad(),((Profesional)Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))).getSexo(),((Profesional)Facultad.getInstance().buscarPersona((String)tabla.getModel().getValueAt(i, 0))).getClass().getSimpleName()});
				}
		}
		tabledef.setModel(modelito_defensa);


	}

	private void darBaja(){
		for(int i=0; i<tableMatrMae.getModel().getRowCount();i++){
			if(tableMatrMae.isRowSelected(i))
				if(Facultad.getInstance().buscarPersona((String)tableMatrMae.getModel().getValueAt(i, 0))instanceof Docente)
					((Docente)Facultad.getInstance().buscarPersona((String)tableMatrMae.getModel().getValueAt(i, 0))).setMatricula(null);
				else 
					if(Facultad.getInstance().buscarPersona((String)tableMatrMae.getModel().getValueAt(i, 0))instanceof Profesional)
						((Profesional)Facultad.getInstance().buscarPersona((String)tableMatrMae.getModel().getValueAt(i, 0))).setMatricula(null);;

		}

		actualizarTablaMatricula();

	}
	private void graduar(){
		for(int i=0; i<tabledef.getModel().getRowCount();i++){
			if(tabledef.isRowSelected(i))
				if(Facultad.getInstance().buscarPersona((String)tabledef.getModel().getValueAt(i, 0))instanceof Docente){
					((Docente)Facultad.getInstance().buscarPersona((String)tabledef.getModel().getValueAt(i, 0))).getMatricula().setGraduadoMaestria(true);
					((Docente)Facultad.getInstance().buscarPersona((String)tabledef.getModel().getValueAt(i, 0))).setCategoriaC("Máster");
					Facultad.getInstance().getMaestria().aumentarCantGrad();
				}
				else 
					if(Facultad.getInstance().buscarPersona((String)tabledef.getModel().getValueAt(i, 0))instanceof Profesional){
						((Profesional)Facultad.getInstance().buscarPersona((String)tabledef.getModel().getValueAt(i, 0))).getMatricula().setGraduadoMaestria(true);
						Facultad.getInstance().getMaestria().aumentarCantGrad();}
		}
		actualizarTablaDefender();


	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	/**
	 * VALIDACIONES DE BOTONES
	 */

	private void validarBotonesPersona()
	{
		if(tablePersona.getSelectedRowCount()==0||Facultad.getInstance().getPersonas().size()==0)
		{
			btnEditarPersonas.setEnabled(false);
			btnEliminarPersonas.setEnabled(false);
		}
		else 
		{
			btnEditarPersonas.setEnabled(true);
			btnEliminarPersonas.setEnabled(true);
		}
	}

	private void validarBotonesDepartamento()
	{
		if(tableDepartamentos.getSelectedRowCount()==0||Facultad.getInstance().getDepartamentos().size()==0)
		{
			btnEditarDepartamento.setEnabled(false);
			btnEliminarDepartamento.setEnabled(false);
		}
		else 
		{
			btnEditarDepartamento.setEnabled(true);
			btnEliminarDepartamento.setEnabled(true);
		}
	}

	private void validarBotonesCurso()
	{
		if(tablaMatricula3.getSelectedRowCount()==0)
		{
			btnTerminarCurso.setEnabled(false);
		}
		else
			btnTerminarCurso.setEnabled(true);
	}

	private void validarBotonesInfCurso()
	{
		if(listaCursos.getSelectedIndices().length==0|| listaCursos.getModel().getSize()==0)
		{
			botonEditar.setEnabled(false);
			botonEliminar.setEnabled(false);
		}
		else
		{
			botonEditar.setEnabled(true);
			botonEliminar.setEnabled(true);
		}
	}

	private void validarBotonesMaestriaMat()
	{
		if(tableMatrMae.getSelectedRowCount()==0)
		{
			btnDarVistoBueno.setEnabled(false);
			btnDarBaja.setEnabled(false);
		}
		else
		{
			btnDarVistoBueno.setEnabled(true);
			btnDarBaja.setEnabled(true);	
		}
	}


	private void cambiarMenu2(){
		if(Facultad.getInstance().getDepartamentos().size()>0 && Facultad.getInstance().getCursos().size()>0){
			mnReportes.remove(2);
			JMenu menuActivPos=new JMenu("Actividad de Posgrado por Departamento");

			for(int i=0; i<Facultad.getInstance().getDepartamentos().size(); i++){
				final JMenuItem nuevo=new JMenuItem(Facultad.getInstance().getDepartamentos().get(i).getNombre());
				nuevo.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						new VentanaActividadPosgra(nuevo.getText()).setVisible(true);						
					}
				});
				menuActivPos.add(nuevo);

			}
			mnReportes.add(menuActivPos, 2);
		}
		else {
			mnReportes.remove(2);
			JMenuItem menuInser= new JMenuItem("Actividad de Posgrado");
			menuInser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(Facultad.getInstance().getCursos().size()==0)
						JOptionPane.showMessageDialog(null, "No hay cursos de posgrado registrados.Registre al\n menos un curso");
					else
						if(Facultad.getInstance().getDepartamentos().size()==0)
							JOptionPane.showMessageDialog(null, "No hay departamentos registrados.Registre al\n menos un curso");
				}
			});
			mnReportes.add(menuInser, 2);
		}
	}
	private void cambiarMenu0()
	{
		/**
		 * codigo :)
		 */
		JMenu mnHolisss= new JMenu("Actividad Investigativa Por Departamento");

		JMenuItem mnHoli= new JMenuItem("Actividad Investigativa Por Departamento");
		mnHoli.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "No hay departamentos");				
			}
		});
		if(Facultad.getInstance().getDepartamentos().size()>0)
		{
			for(int y=0;Facultad.getInstance().getDepartamentos().size()>y;y++)
			{
				final JMenuItem men= new JMenuItem(Facultad.getInstance().getDepartamentos().get(y).getNombre());
				men.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						VentanaReportes ven=new VentanaReportes(MenuPrincipal2.this, 0);
						ven.llenarTablas(Facultad.getInstance().returnDepart(men.getLabel()));
						ven.setVisible(true);
					}
				});
				mnHolisss.add(men);
			}
			mnReportes.remove(0);
			mnReportes.add(mnHolisss,0);
		}
		else{
			mnReportes.remove(0);
			mnReportes.add(mnHoli, 0);
		}
	}
	public void actualizarTerminar(){
		if(tabledef.getSelectedRowCount()!=0)
			btnTerminarMaestria.setEnabled(true);
		else
			btnTerminarMaestria.setEnabled(false);
	}
	public void validarBtnMatricular(){
		if(Facultad.getInstance().getMaestria().getCursosMaestria().size()==0)
			Matricular.setEnabled(false);
		else
			Matricular.setEnabled(true);
	}
}

