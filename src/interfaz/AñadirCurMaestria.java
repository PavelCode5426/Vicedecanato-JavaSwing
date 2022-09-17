package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JList;

import logica.CursoPosgrado;
import logica.Facultad;
import logica.Maestria;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class AñadirCurMaestria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList listCursosMaestria;
	private MenuPrincipal2 menuPrincipal;
	private JButton btnAsignar;

	public AñadirCurMaestria( MenuPrincipal2 menuPrincipal) {
		this.menuPrincipal=menuPrincipal;
		setTitle("Registrar cursos de la Maestria");
		setModal(true);
		setBounds(100, 100, 270, 304);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cursos que componen la Maestr\u00EDa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 237, 206);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				
				listCursosMaestria = new JList();
				listCursosMaestria.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						validarBoton();
					}
					@Override
					public void mousePressed(MouseEvent arg0) {
						validarBoton();
					}
				});
				scrollPane.setViewportView(listCursosMaestria);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAsignar = new JButton("Asignar Cursos");
				btnAsignar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(listCursosMaestria.getSelectedIndices().length==0){
							JOptionPane.showMessageDialog(null, "No ha seleccionado ningun curso.Por favor seleccione algun curso");
						}
						else{
							asignarCursos();
							JOptionPane.showMessageDialog(null, "Los cursos han sido agregados correctamente");
							AñadirCurMaestria.this.dispose();
						}
						AñadirCurMaestria.this.menuPrincipal.validarBtnMatricular();
						
					}
				});
				btnAsignar.setActionCommand("OK");
				buttonPane.add(btnAsignar);
				getRootPane().setDefaultButton(btnAsignar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						AñadirCurMaestria.this.dispose();
						AñadirCurMaestria.this.menuPrincipal.validarBtnMatricular();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		validarBoton();
		llenarListaCursos();
	}
	
	
	
	private void llenarListaCursos(){
		DefaultListModel modelo_listaCurs= new DefaultListModel();
				
		for(int i=0;i<Facultad.getInstance().getCursos().size();i++){
			modelo_listaCurs.addElement(Facultad.getInstance().getCursos().get(i).getNombre());
		}
		listCursosMaestria.setModel(modelo_listaCurs);
	}
	public void asignarCursos(){
		DefaultListModel modeloCursitos= new DefaultListModel();
		
		Maestria unicaMaestria= new Maestria("Maestria de Informatica Aplicada", new ArrayList<String>(),new ArrayList<String>(),0,0);
		for(int i=0; i<listCursosMaestria.getSelectedValues().length;i++){
			unicaMaestria.getCursosMaestria().add(listCursosMaestria.getSelectedValues()[i].toString());
		}
		//Aqui lleno la lista del Panel de Maestria o sea lleno la lista con los cursos que tiene la maestria
		for(int j=0; j<listCursosMaestria.getSelectedValues().length; j++){
			modeloCursitos.addElement(listCursosMaestria.getSelectedValues()[j]);
		}
		menuPrincipal.devolverListaCursito().setModel(modeloCursitos);
		Facultad.getInstance().setMaestria(unicaMaestria);
	}
	private void validarBoton(){
		if(listCursosMaestria.isSelectionEmpty())
			btnAsignar.setEnabled(false);
		else
			btnAsignar.setEnabled(true);
	}
}

