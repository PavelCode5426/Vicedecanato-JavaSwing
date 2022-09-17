package auxiliar;

import java.text.DateFormat;
import java.util.Date;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Fecha extends JLabel {
	
	public Fecha() {
		Date fechaSys = new Date();
		DateFormat formatoFecha= DateFormat.getDateInstance();
		String fecha = formatoFecha.format(fechaSys);
		this.setText(fecha);
	}
}
