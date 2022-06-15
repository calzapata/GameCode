package interfaz;


public class DatosUsuario {
	
	public DatosUsuario(){
		
	}
	
	String usuario1 = "GAME-CODE";
	String contrasena1 = "1234";
	
	
	public int probarUsuario() {
			usuario1 = Interfaz1.inputUsuario.getText();
			contrasena1 = Interfaz1.inputPassword.getText();
			
			if(usuario1.equals("carlos") && contrasena1.equals("12345")) {
				return 1;
			}
			else {
				return 0;
			}
	}
	
}
