package seguridad;

import java.util.ArrayList;

public class Credencial {
	private ArrayList<Usuario> usuarios;
	private static Credencial objetoCredencial;


	public static Credencial getInstance(){
		if(objetoCredencial==null)
			objetoCredencial= new Credencial(new ArrayList<Usuario>());
		return objetoCredencial;
	}



	public Credencial(ArrayList<Usuario> usuarios) {
		super();
		this.usuarios = usuarios;
		this.usuarios.add(new Usuario("Saydel", "1234", Papel.Administrador));
		this.usuarios.add(new Usuario("Pavel", "991221", Papel.Administrador));
		this.usuarios.add(new Usuario("cliente", "cliente", Papel.Cliente));
	}
	
	

	

	public boolean checkCredencial(String user,String pass){
		boolean check=false;

		for(int i=0;i<usuarios.size() && !check;i++){
			if(usuarios.get(i).getNombreUsuario().equals(user)){
				if(usuarios.get(i).getContrasenna().equals(pass))
					check=true;
			}

		}

		return check;
	}

	public Papel devolverUsuarioPapel(String nombreUsuario){
		Papel pape=null;
		boolean encontrado=false;
		for(int i=0; i<usuarios.size() && !encontrado; i++){
			if(usuarios.get(i).getNombreUsuario().equals(nombreUsuario)){
				encontrado=true;
				pape=usuarios.get(i).getPapel();
			}

		}
		return pape;

	}




}
