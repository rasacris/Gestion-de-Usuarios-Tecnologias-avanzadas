package es.ufv.tap.gestionUsuarios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import es.ufv.tap.gestionUsuarios.bean.Profesor;


public class Dao {
	
	private String host;
	private String port;
	private String user;
	private String pwd;
	private String db;
	private String nameDB;
	
	private Connection conn;
	
	
	public Dao()
	{
		host = "localhost";
		port = "3306";
		user = "root";
		pwd = "";
		db = "tap";
		nameDB = "jdbc:mysql://";
		   

		
	}
	
	
	public void creaConexion()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(nameDB+host+":"+port+"/"+db, user, pwd);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}
	
	public Vector<Profesor> getProfesores() {
		Vector<Profesor> resultado = new Vector<Profesor>();
		String query = "SELECT * FROM profesores ";
		try
		{
			Statement stm = conn.createStatement();
			ResultSet result = stm.executeQuery(query);
			while (result.next())
			{
				String id = result.getString("id");
				String nombre = result.getString("nombre");
				String apellidos = result.getString("apellidos");
				Profesor prof = new Profesor(id, nombre, apellidos);
				resultado.add(prof);
			}
		}
		catch (SQLException e)
		{
			System.out.println("error en la consulta "+e.getMessage());
		}
		return resultado;
	}
	
	
	public void insertar(Profesor prof)
	{
		String query = "INSERT INTO profesores (nombre, apellidos) values "
				+ "('"+prof.getNombre()+"', '"+prof.getApellidos()+"')";
		try {
			Statement stm = conn.createStatement();
			stm.execute(query);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void cerrarConexion()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	public static void main(String[] args) {

		Dao dao = new Dao();
		dao.creaConexion();
		dao.insertar(new Profesor("","raul", "martin"));
		dao.cerrarConexion();
		
	}


}
