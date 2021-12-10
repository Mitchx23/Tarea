package bean;

public class Usuario {

	private String usuario;
	private String clave;
	private String nombre;
	private String apellidos;
	private String email;
	private String telefono;

	public Usuario(String usuario, String clave, String nombre, String apellidos, String email, String telefono) {

		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
	}

	public Usuario() {

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefono() {
	    return telefono;	
	}
	
	public void setTelefono (String telefono) {
		this.telefono = telefono;
	}
	

}
