package es.ufv.tap.gestionUsuarios.logica;

import java.util.Vector;

import es.ufv.tap.gestionUsuarios.bean.Profesor;
import es.ufv.tap.gestionUsuarios.dao.Dao;

public class Logica {

	
	public void insertar(String nombre, String apellidos)
	{
		Profesor prof = new Profesor("", nombre, apellidos);
		Dao dao = new Dao();
		dao.creaConexion();
		dao.insertar(prof);
		dao.cerrarConexion();
	}
	
	public Vector<Profesor> getProfesores()
	{
		Dao dao = new Dao();
		dao.creaConexion();
		Vector<Profesor> res = dao.getProfesores();
		dao.cerrarConexion();
		return res;
	}
}
