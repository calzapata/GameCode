


public class UsuarioDatos {
	
	public UsuarioDatos(){
		
	}
	
	String usuario1 = "";
	String contrasena1 = "";
	
	
	@SuppressWarnings("deprecation")
	public int probarUsuario() {
			usuario1 = UsuarioPanel.inputUsuario.getText();
			contrasena1 = UsuarioPanel.inputPassword.getText();
			
			if(usuario1.equals("a") && contrasena1.equals("1")) {
				return 1;
			}
			else {
				return 0;   
			}
	}
	
}
