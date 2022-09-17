package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JList;

import logica.Docente;
import logica.Facultad;
import logica.Maestria;
import logica.Persona;
import logica.Profesional;

import javax.swing.ListSelectionModel;

import auxiliar.Matricula;
import auxiliar.ResultadoCurso;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MatricularMaestria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList listPersonal;
	private JList listMatricula;
	private DefaultListModel modeloPersonal;
	private DefaultListModel modeloMatricula;
	private JPanel panelMatri;
	private MenuPrincipal2 menuPrincipal;
	private JButton button;
	private JButton button_1;
	private JButton btnVerificar;

	public MatricularMaestria(final MenuPrincipal2 menuPrincipal) {
		this.menuPrincipal=menuPrincipal;
		modeloPersonal=new DefaultListModel();
		modeloMatricula=new DefaultListModel();		
		setModal(true);
		setTitle("Matricular en Maestr\u00EDa");
		setBounds(100, 100, 434, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Seleccione la matricula", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 398, 218);
		contentPanel.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 21, 144, 185);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		listPersonal = new JList();
		listPersonal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listMatricula.clearSelection();
				validarRevisar();
				validarBotonesMaest();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				validarRevisar();
				listMatricula.clearSelection();
				validarBotonesMaest();
			}
		});
		listPersonal.setToolTipText("Lista del personal que pudiera matricular en la Maestria Informatica Aplicada");
		scrollPane.setViewportView(listPersonal);

		button = new JButton(">>>");
		button.setToolTipText("Agregar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listPersonal.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "No ha seleccionado algo por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					matricular();
				}
				validarBotonesMaest();
				validarRevisar();
			}
		});
		button.setBounds(164, 79, 69, 23);
		panel.add(button);

		button_1 = new JButton("<<<");
		button_1.setToolTipText("Quitar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listMatricula.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "No ha seleccionado algo por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					desmatricular();
				}
				validarBotonesMaest();
				validarRevisar();
			}
		});
		button_1.setBounds(164, 133, 69, 23);
		panel.add(button_1);

		panelMatri = new JPanel();
		panelMatri.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Matr\u00EDcula", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelMatri.setBounds(243, 21, 144, 185);
		panel.add(panelMatri);
		panelMatri.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panelMatri.add(scrollPane_1, BorderLayout.CENTER);

		listMatricula = new JList();
		listMatricula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				validarRevisar();
				listPersonal.clearSelection();
				validarBotonesMaest();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				validarRevisar();
				listPersonal.clearSelection();
				validarBotonesMaest();
			}
		});
		listMatricula.setToolTipText("Seleccione una persona y verifique si hay espacio en los cursos");
		listMatricula.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(listMatricula);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnVerificar = new JButton("Verificar Espacio");
				btnVerificar.setToolTipText("Verifique si hay espacio en los cursos para poder matricular");
				btnVerificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(listMatricula.getModel().getSize()==0){
							JOptionPane.showMessageDialog(null, "La lista de los matriculados esta vacia.Compruebe\nsu seleccion");
						}
						else
							if(listMatricula.getSelectedValues().length==0){
								JOptionPane.showMessageDialog(null, "No ha seleccionado nada en la lista \n de los matriculados");
							}

							else
								if(asignarPersona(Facultad.getInstance().buscarPersona(listMatricula.getSelectedValue().toString())).size()>0){
									JOptionPane.showMessageDialog(null, "No hay espacio en los cursos");
									panelMatri.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Matriculados", TitledBorder.LEFT, TitledBorder.TOP, null, Color.RED));
								}
								else{
									panelMatri.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Matriculados", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
									otorgarMatricula(Facultad.getInstance().buscarPersona(listMatricula.getSelectedValue().toString()));
									JOptionPane.showMessageDialog(null, "Se ha matriculado correctamente");
									menuPrincipal.actualizarTablaMatricula();
									modeloMatricula.removeElementAt(listMatricula.getSelectedIndex());
									listMatricula.setSelectedIndex(listMatricula.getModel().getSize()-1);
									menuPrincipal.devolverBoton().setEnabled(false);
								}
					}


				});
				btnVerificar.setActionCommand("OK");
				buttonPane.add(btnVerificar);
				getRootPane().setDefaultButton(btnVerificar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setToolTipText("Cancelar la matr\u00EDcula");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(JOptionPane.showConfirmDialog(null, "Desea salir","Seleccione una opción", 0) == JOptionPane.OK_OPTION)
							MatricularMaestria.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		validarRevisar();
		llenarPersonal();
		validarBotonesMaest();
	}


	private void llenarPersonal(){
		for(int i=0; i<Facultad.getInstance().getPersonas().size();i++){
			if(Facultad.getInstance().getPersonas().get(i) instanceof Docente){
				if(((Docente)Facultad.getInstance().getPersonas().get(i)).getMatricula()==null)
					if(((Docente)Facultad.getInstance().getPersonas().get(i)).getCategoriaC().equals("Ninguna"))
						modeloPersonal.addElement(Facultad.getInstance().getPersonas().get(i).getNombre());
			}
			else{
				if(Facultad.getInstance().getPersonas().get(i) instanceof Profesional){
					if(((Profesional)Facultad.getInstance().getPersonas().get(i)).getMatricula()==null)
						modeloPersonal.addElement(Facultad.getInstance().getPersonas().get(i).getNombre());
				}
			}

		}
		listPersonal.setModel(modeloPersonal);
		listMatricula.setModel(modeloMatricula);
	}

	private void matricular(){
		Object[] selecc=listPersonal.getSelectedValues();
		for(int i=0;i<selecc.length;i++)
		{
			modeloMatricula.addElement(selecc[i]);
			modeloPersonal.removeElement(selecc[i]);
		}
	}
	private void desmatricular(){
		Object[] selecc=listMatricula.getSelectedValues();
		for(int i=0;i<selecc.length;i++)
		{
			modeloPersonal.addElement(selecc[i]);
			modeloMatricula.removeElement(selecc[i]);
		}

	}

	private void otorgarMatricula(Persona persona){
		Matricula matriculaNueva=new Matricula(new ArrayList<String>(), false, false);

		for(int i=0; i<Facultad.getInstance().getMaestria().getCursosMaestria().size();i++){
			matriculaNueva.getNombreCursosMaestria().add(Facultad.getInstance().getMaestria().getCursosMaestria().get(i));
		}


		if(persona instanceof Docente){
			((Docente) persona).setMatricula(matriculaNueva);
		}
		else
			if(persona instanceof Profesional){
				((Profesional)persona).setMatricula(matriculaNueva);
			}
		Facultad.getInstance().getMaestria().aumentarCantMatri();
	}


	/////////////////////Este metodo no deberia ir aqui
	public ArrayList<String> asignarPersona(Persona persona){
		ArrayList<String> lista=new ArrayList<String>();

		for(int i=0; i<Facultad.getInstance().getMaestria().getCursosMaestria().size(); i++){
			if(persona instanceof Docente){
				if(!((Docente)persona).estaEnResultado(Facultad.getInstance().getMaestria().getCursosMaestria().get(i)))//si no lo ha pasado
					if(!Facultad.getInstance().buscarCurso(Facultad.getInstance().getMaestria().getCursosMaestria().get(i)).personaEnCurso(persona.getNombre()))//si no esta matriculada  en el curso Aqui hacer lo mismo que en el anterior
						if(!Facultad.getInstance().buscarCurso(Facultad.getInstance().getMaestria().getCursosMaestria().get(i)).verificarEspacio()){//si hay espacio para matricularlo
							Facultad.getInstance().buscarCurso(Facultad.getInstance().getMaestria().getCursosMaestria().get(i)).addPersonasCurso(persona);
						}
						else{
							lista.add(Facultad.getInstance().getMaestria().getCursosMaestria().get(i));
						}
			}
			else{
				if(persona instanceof Profesional)
					if(!((Profesional)persona).estaEnResultado(Facultad.getInstance().getMaestria().getCursosMaestria().get(i)))//si no lo ha pasado
						if(!Facultad.getInstance().buscarCurso(Facultad.getInstance().getMaestria().getCursosMaestria().get(i)).personaEnCurso(persona.getNombre()))//si no esta matriculada  en el curso Aqui hacer lo mismo que en el anterior
							if(!Facultad.getInstance().buscarCurso(Facultad.getInstance().getMaestria().getCursosMaestria().get(i)).verificarEspacio())//si hay espacio para matricularlo
								Facultad.getInstance().buscarCurso(Facultad.getInstance().getMaestria().getCursosMaestria().get(i)).addPersonasCurso(persona);
							else{
								lista.add(Facultad.getInstance().getMaestria().getCursosMaestria().get(i));
							}
			}
		}

		return lista;
	}
	private void validarBotonesMaest(){
		if(listPersonal.getSelectedValues().length==0)
			button.setEnabled(false);
		else
			button.setEnabled(true);
		if(listMatricula.getSelectedValues().length==0)
			button_1.setEnabled(false);
		else
			button_1.setEnabled(true);
	}
	private void validarRevisar(){
		if(listMatricula.isSelectionEmpty())
			btnVerificar.setEnabled(false);
		else
			btnVerificar.setEnabled(true);
	}


}



