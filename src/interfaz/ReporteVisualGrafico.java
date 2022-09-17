package interfaz;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hamcrest.Factory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.graphics2d.svg.ImageElement;

import com.orsoncharts.data.Dataset3DChangeListener;
import com.orsoncharts.data.PieDataset3D;
import com.orsoncharts.plot.PiePlot3D;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.Raster;
import java.util.EventListener;
import java.util.List;

import logica.Facultad;


public class ReporteVisualGrafico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panelFiguras;

	
	public ReporteVisualGrafico() {
		setResizable(false);
		setTitle("Porciento hist\u00F3rico de graduados de Maestria con relaci\u00F3n a los matriculados");
		setModal(true);
		setBounds(100, 100, 489, 378);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panelFiguras = new JPanel();

			contentPanel.add(panelFiguras, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ReporteVisualGrafico.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			hacerPastel();

		}
	}
	private void hacerPastel(){
		DefaultPieDataset datos=new DefaultPieDataset();
		
		datos.setValue("Graduados", Facultad.getInstance().getMaestria().getCantidadGraduados());
		datos.setValue("Matriculados", Facultad.getInstance().getMaestria().getCantidadMatriculados());
		
		JFreeChart graf= ChartFactory.createPieChart3D("Porciento de graduados de Maestría\n del total de matriculados", datos);
		panelFiguras.setLayout(new GridLayout(0, 1, 0, 0));
		ChartPanel panel= new ChartPanel(graf);
		panel.setForeground(Color.WHITE);
		graf.setBackgroundPaint(getForeground().white);		
		panel.setBackground(Color.WHITE);
		panelFiguras.add(panel);
	}
}
