package es.ufv.tap.gestionUsuarios.action;

import com.opensymphony.xwork2.ActionSupport;

import es.ufv.tap.gestionUsuarios.logica.Logica;

public class CargarAction extends ActionSupport{

	
	private String apellidos;
	private String nombre;

	public String execute() throws Exception {
		System.out.println("hola");
		Logica logica = new Logica();
		logica.insertar(nombre, apellidos);
		
		return "success";
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void validate()
	{
		if (nombre.length()==0)
		{
	        addFieldError( "nombre", "Debes escribir un nombre." );
		}
		if (apellidos.length()==0)
		{
	        addFieldError( "apellidos", "Debes escribir apellidos." );
		}
	}
}
