package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import prueba.DepartamentoTestCase;
import logica.CursoPosgrado;
import logica.Departamento;
import logica.Docente;
import logica.Estudiante;
import logica.Facultad;
import logica.Investigador;
import logica.LineaInvestigacion;
import logica.Persona;
import logica.Profesional;
import logica.TemaInvestigacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.GridLayout;

import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;

import javax.swing.BoxLayout;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.category.DefaultCategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetGroup;

public class VentanaReportes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table_activadad_invest;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField textField;
	private JPanel panel_graficoDep;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaReportes dialog = new VentanaReportes(null,0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaReportes(MenuPrincipal2 m,int numero) {
		setTitle("");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReportes.class.getResource("/imagenes/icons8_Increase_16.png")));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 567, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		{
			JPanel panel_activadaInvest = new JPanel();
			contentPanel.add(panel_activadaInvest, "name_155219792315341");
			panel_activadaInvest.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel = new JPanel();
				panel_activadaInvest.add(panel, BorderLayout.NORTH);
				panel.setLayout(new GridLayout(0, 2, 0, 0));
				{
					JLabel lblResponsable = new JLabel("Responsable");
					panel.add(lblResponsable);
				}
				{
					textField = new JTextField();
					textField.setEditable(false);
					textField.setEnabled(false);
					panel.add(textField);
					textField.setColumns(10);
				}
			}
			{
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				panel_activadaInvest.add(tabbedPane, BorderLayout.CENTER);
				{
					JPanel panel = new JPanel();
					tabbedPane.addTab("Lineas de Investigacion", null, panel, null);
					panel.setLayout(new GridLayout(0, 1, 0, 0));
					{
						JScrollPane scrollPane = new JScrollPane();
						panel.add(scrollPane);
						{
							table_3 = new JTable();
							scrollPane.setViewportView(table_3);
						}
					}
				}
				{
					JPanel panel = new JPanel();
					tabbedPane.addTab("Temas de Investigacion", null, panel, null);
					panel.setLayout(new GridLayout(1, 0, 0, 0));
					{
						JScrollPane scrollPane = new JScrollPane();
						panel.add(scrollPane);
						{
							table_2 = new JTable();
							scrollPane.setViewportView(table_2);
						}
					}
				}
				{
					JPanel panel = new JPanel();
					tabbedPane.addTab("Integrantes", null, panel, null);
					panel.setLayout(new GridLayout(1, 0, 0, 0));
					{
						JScrollPane scrollPane = new JScrollPane();
						panel.add(scrollPane);
						{
							table_1 = new JTable();
							scrollPane.setViewportView(table_1);
						}
					}
				}
				{
					JPanel panel = new JPanel();
					tabbedPane.addTab("Articulos", null, panel, null);
					panel.setLayout(new GridLayout(0, 1, 0, 0));
					{
						JScrollPane scrollPane = new JScrollPane();
						panel.add(scrollPane);
						{
							table = new JTable();
							scrollPane.setViewportView(table);
						}
					}
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, "name_109942802782319");
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table_activadad_invest = new JTable();
					scrollPane.setViewportView(table_activadad_invest);
				}
			}
		}
		{
			panel_graficoDep = new JPanel();
			contentPanel.add(panel_graficoDep, "name_292061595788848");
			panel_graficoDep.setLayout(new GridLayout(1, 0, 0, 0));
		}
		showPanel(numero);
	}

	/**
	 * METODOS DEPARTAMENTO
	 */
	


	public  void showPanel(int numero)
	{
		for(int x=0;x<contentPanel.getComponentCount();x++)
			contentPanel.getComponent(x).setVisible(false);
		switch (numero) {
		case 0:
			setTitle("Actividad Investigativa por Departamento");
			contentPanel.getComponent(numero).setVisible(true);
			break;
		case 1:
			setTitle("Actividad Investigativa de los Investigadores");
			contentPanel.getComponent(numero).setVisible(true);
			llenarTablaXarticulo();
		case 2:
			setTitle("Cantidad de Articulos Por Departamento");
			contentPanel.getComponent(numero).setVisible(true);
			Graficar(0);
			break;
		case 3:
			setTitle("Cantidad de Lineas Por Departamento");
			contentPanel.getComponent(2).setVisible(true);
			Graficar(1);
			break;
		}
	}

	void llenarTablas(Departamento obj)
	{
		DefaultTableModel modelo1=new DefaultTableModel(new String[]{"Nombre de la Linea de Investigacion","Responsable"},0);
		DefaultTableModel modelo2=new DefaultTableModel(new String[]{"Nombre del Tema de Investigacion","Responsable","Linea de Investigacion"},0);
		DefaultTableModel modelo3=new DefaultTableModel(new String[]{"Nombre y Apellido","Tema de Investigacion","Tipo de Investigador"},0);
		DefaultTableModel modelo4=new DefaultTableModel(new Object[]{"Nombre del Articulo"}, 0);
		textField.setText(obj.getResponsable().getNombre());

		for(int x=0;x<obj.getLineasInvestigacion().size();x++)
		{
			modelo1.addRow(new Object[]{obj.getLineasInvestigacion().get(x).getNombre(),obj.getLineasInvestigacion().get(x).getResponsable().getNombre()});
			for(int y=0;y<obj.getLineasInvestigacion().get(x).getTemasInvestigacion().size();y++)
			{
				modelo2.addRow(new Object[]{obj.getLineasInvestigacion().get(x).getTemasInvestigacion().get(y).getNombre(),obj.getLineasInvestigacion().get(x).getTemasInvestigacion().get(y).getResponsable().getNombre(),obj.getLineasInvestigacion().get(x).getNombre()});
				for(int z=0;z<obj.getLineasInvestigacion().get(x).getTemasInvestigacion().get(y).getInvestigadores().size();z++)
				{
					if(obj.getLineasInvestigacion().get(x).getTemasInvestigacion().get(y).getInvestigadores().get(z) instanceof Estudiante)
						modelo3.addRow(new Object[]{obj.getLineasInvestigacion().get(x).getTemasInvestigacion().get(y).getInvestigadores().get(z).getNombre(),obj.getLineasInvestigacion().get(x).getTemasInvestigacion().get(y).getNombre(),"Estudiante"});
					else
						modelo3.addRow(new Object[]{obj.getLineasInvestigacion().get(x).getTemasInvestigacion().get(y).getInvestigadores().get(z).getNombre(),obj.getLineasInvestigacion().get(x).getTemasInvestigacion().get(y).getNombre(),"Docente"});
				}
				for(int z=0;z<obj.getLineasInvestigacion().get(x).getTemasInvestigacion().get(y).getArticulos().size();z++)
					modelo4.addRow(new Object[]{obj.getLineasInvestigacion().get(x).getTemasInvestigacion().get(y).getArticulos().get(z).getTitulo()});
			}
		}
		table_3.setModel(modelo1);
		table_2.setModel(modelo2);
		table_1.setModel(modelo3);
		table.setModel(modelo4);
	}



	private void llenarTablaXarticulo()
	{
		ArrayList<Investigador> x= new ArrayList<Investigador>();
		DefaultTableModel model=new DefaultTableModel(new String[]{"Nombre del Investigador","Resultado Investigativo"},0);
		for(int r=0;r<Facultad.getInstance().getPersonas().size();r++)
		{
			if(Facultad.getInstance().getPersonas().get(r) instanceof Investigador)
			{
				x.add((Investigador)Facultad.getInstance().getPersonas().get(r));
			}
		}
		while(x.size()!=0)
		{
			Investigador r=x.get(0);
			for(int y=0;y<x.size()-1;y++)
			{
				if(r.getCantTotalArt()<=x.get(y+1).getCantTotalArt())
					r=x.get(y+1);
			}
			model.addRow(new Object[]{r.getNombre(),r.getCantTotalArt()});
			x.remove(r);
		}
		table_activadad_invest.setModel(model);
	}

	private void Graficar(int x)
	{
		switch (x) {
		case 0:
			GraficarArticulos();
			break;
		case 1:
			GraficarLineas();
			break;
		case 2:

			break;
		default:
			break;
		}
	}

	private void GraficarArticulos()
	{
		DefaultCategoryDataset datos= new DefaultCategoryDataset();
		for(int x=0;x<Facultad.getInstance().getDepartamentos().size();x++){
			
			datos.setValue(Facultad.getInstance().getDepartamentos().get(x).TotalArticulos(),Facultad.getInstance().getDepartamentos().get(x).getNombre() , "");
		}
					JFreeChart grafica= ChartFactory.createBarChart3D("Cantidad de Articulos por Departamento", "Departamentos","Cantidad de Articulos", datos);
		ChartPanel panel= new ChartPanel(grafica);
		panel_graficoDep.add(panel);
	}

	private void GraficarLineas()
	{
		DefaultCategoryDataset datos= new DefaultCategoryDataset();
		for(int x=0;x<Facultad.getInstance().getDepartamentos().size();x++)
			datos.setValue(Facultad.getInstance().getDepartamentos().get(x).getLineasInvestigacion().size(),Facultad.getInstance().getDepartamentos().get(x).getNombre(),"" );
		JFreeChart grafChart= ChartFactory.createBarChart3D("Cantidad de Lineas de Investigacion Por Departamento", "Departamentos", "Cantidad de Lineas", datos);
		ChartPanel panel= new ChartPanel(grafChart);
		panel_graficoDep.add(panel);

	}









}
