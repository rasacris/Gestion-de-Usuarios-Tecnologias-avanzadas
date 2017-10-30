<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="es.ufv.tap.gestionUsuarios.logica.Logica" %>
<%@ page import="es.ufv.tap.gestionUsuarios.bean.Profesor" %>
<%@ page import="java.util.Vector" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String nombre = request.getParameter("nombre");
String apellidos = request.getParameter("apellidos");


Logica logica = new Logica();
logica.insertar(nombre, apellidos);

Vector<Profesor> res = logica.getProfesores();
for (int i = 0; i < res.size(); i++)
{

%>
<%=res.elementAt(i).getNombre()%> <%=res.elementAt(i).getApellidos()%><br/>
<%

}
%>  

<h1>Un saludo</h1>
<p><%= nombre%> <%=apellidos %>


</body>
</html>