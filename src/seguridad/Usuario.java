package seguridad;

public class Usuario {
	private String nombreUsuario;
	private String contrasenna;
	private Papel papel;
	
	public Usuario(String nombreUsuario, String contrasenna, Papel papel) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasenna = contrasenna;
		this.papel = papel;
	}
	

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}
	
	
	
}
