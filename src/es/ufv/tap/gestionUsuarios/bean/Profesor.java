package es.ufv.tap.gestionUsuarios.bean;

public class Profesor {

	private String id;
	private String nombre;
	private String apellidos;
	
	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(String id, String nombre, String apellidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public boolean equals(Profesor prof)
	{
		return apellidos.equals(prof.apellidos);
	}
	
	
}
