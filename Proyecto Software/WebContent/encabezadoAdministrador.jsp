<%@page import="com.persistencia.SessionDB"%>
<%@page import="com.persistencia.AdministradorPersona"%>
<%@page import="com.logica.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/estilo.css" type="text/css"
	media="screen">
<style type="text/css"></style>
</head>
<body>
	<header>
		<img id="imgHeader" alt="header" src="imagenes/header.jpg">
	</header>

	<nav id="navAdmin">
		<ul id="navigationAdmin">
			<li><a>Agregar</a>
				<ul>
					<li><a href="editarPersona.jsp?tipoPersona=1">Administrador</a></li>
					<li><a href="editarPersona.jsp?tipoPersona=2">Vendedor</a></li>
					<li><a href="agregarCliente.jsp">Cliente</a></li>
					<li><a href="editarAutomovil.jsp">Automovil</a></li>
					<li><a href="editarVenta.jsp">Venta</a></li>
				</ul></li>
			<li><a>Consultas</a>
				<ul>
					<li><a href="persona.jsp?tipoPersona=1">Administradores</a></li>
					<li><a href="persona.jsp?tipoPersona=2">Vendedores</a></li>
					<li><a href="persona.jsp?tipoPersona=3">Clientes</a></li>
					<li><a>Automoviles</a>
						<ul>
							<li><a href="automovil.jsp">Para la venta</a></li>
							<li><a href="automovil.jsp?estado=1">Vendidos</a></li>
							<li><a href="automovil.jsp?estado=2">Todos</a></li>
						</ul></li>
					<li><a>Ventas</a>
						<ul>
							<li><a href="filtroFechas.jsp">Filtrar por fechas</a></li>
							<li><a href="filtroVendedor.jsp">Filtrar por vendedor</a></li>
							<li><a href="venta.jsp">Todas</a></li>
						</ul></li>
				</ul></li>
			<li><a href="empresa.jsp">Empresa</a></li>
			<li><a href="empresa.jsp">Ayuda</a></li>
		</ul>
	</nav>

	<nav id="navLogin">
		<ul id="navigationLogin">
			<%
				SessionDB.init();
				String cedulaPersona = session.getAttribute("cedulaPersona")
						.toString();
				Persona persona = AdministradorPersona.getPersona(cedulaPersona);
			%>
			<li><a><%=persona.getNombrePersona()%></a>
				<ul>
					<li><a href="informacionPerfil.jsp">Informacion</a></li>
					<li><a href="cambioContrasenia.jsp">Cambio contrasenia</a></li>
					<li><a href="cierreSesion.jsp">Salir</a></li>
				</ul></li>
		</ul>
	</nav>