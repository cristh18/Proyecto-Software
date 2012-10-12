<%@page import="com.logica.TipoCarro"%>
<%@page import="com.persistencia.AdministradorPersona"%>
<%@page import="com.logica.Persona"%>
<%@page import="java.util.List"%>
<%@page import="com.persistencia.SessionDB"%>
<%
	Object nombrePersona = session.getAttribute("nombrePersona");
	if (nombrePersona == null) {
		response.sendRedirect("index.jsp");
	}
	int tipoPersona = 0;
	String leyendaPersona = "";
	List<Persona> listaPersonas = null;
	if (request.getParameter("tipoPersona") != null) {
		tipoPersona = Integer.parseInt(request
				.getParameter("tipoPersona"));
		SessionDB.init();
		listaPersonas = AdministradorPersona
				.getListaPersonasTodas(tipoPersona);
	}
	if (tipoPersona == 1) {
		leyendaPersona = "Administrador";
	} else if (tipoPersona == 2) {
		leyendaPersona = "Vendedor";
	} else if (tipoPersona == 3) {
		leyendaPersona = "Cliente";
	}
	int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
			.toString());
	String cedulaPersona = session.getAttribute("cedulaPersona")
			.toString();
	if (tipoMenu == 1) {
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<section id="persona">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="persona">
		<%
			}
			if (tipoPersona == 1) {
		%>
		<h1>Informacion Administradores</h1>
		<%
			} else if (tipoPersona == 2) {
		%>
		<h1>Informacion Vendedores</h1>
		<%
			} else if (tipoPersona == 3) {
		%>
		<h1>Informacion Clientes</h1>
		<%
			}
			if (listaPersonas.size() == 0) {
		%>
		<h1><%="Ningun " + leyendaPersona + " encontrado"%></h1>
		<%
			} else {
				if (request.getParameter("aviso") != null) {
					int numeroMensaje = Integer.parseInt(request
							.getParameter("aviso"));
					if (numeroMensaje == 1) {
		%>
		<h2><%=leyendaPersona + " almacenado correctamente."%></h2>
		<%
			} else if (numeroMensaje == 2) {
		%>
		<h2><%=leyendaPersona + " eliminado correctamente."%></h2>
		<%
			} else if (numeroMensaje == 3) {
		%>
		<h2><%=leyendaPersona + " editado correctamente."%></h2>
		<%
			}
				}
		%>
		<section id="tablasInformacion">
			<table>
				<thead>
					<tr>
						<%
							if (tipoPersona == 3) {
						%>
						<th>Nombre/Razon Social</th>
						<th>Apellido</th>
						<th>Cedula/ NIT</th>
						<%
							} else {
						%>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Cedula</th>
						<th>Salario</th>
						<th>Fecha ingreso</th>
						<th>Fecha Salida</th>
						<%
							}
						%>
						<th>Estado</th>
						<th>Teléfono</th>
						<th>Dirección</th>
						<th>Correo</th>
						<th></th>
					</tr>
				</thead>
				<tbody style="overflow: auto; height: 100px; width: 320px;">
					<%
						for (int i = 0; i < listaPersonas.size(); i++) {
								Persona persona = listaPersonas.get(i);
					%>
					<tr class='even'>
						<td><%=persona.getNombrePersona()%></td>
						<td><%=persona.getApellidoPersona()%></td>
						<td><%=persona.getCedulaPersona()%></td>
						<%
							if (tipoPersona != 3) {
						%>
						<td><%=persona.getSalarioPersona()%></td>
						<td><%=persona.getFechaIngresoPersona()%></td>
						<%
							if (persona.getEstadoPersona() == 2) {
						%>
						<td><%=persona.getFechaCancelacionPersona()%></td>
						<%
							} else {
						%>
						<td></td>
						<%
							}
									}
									if (persona.getEstadoPersona() == 1) {
						%>
						<td>Activada</td>
						<%
							} else {
						%>
						<td>Desactivada</td>
						<%
							}
						%>
						<td><%=persona.getTelefonoPersona()%></td>
						<td><%=persona.getDireccionPersona()%></td>
						<td><%=persona.getCorreoPersona()%></td>
						<td>
							<%
								if (tipoPersona == 3) {
							%> <a
							href="agregarCliente.jsp?cedulaPersona=<%=persona.getCedulaPersona()%>">Editar</a>
							<%
								} else {
							%> <a
							href="editarPersona.jsp?cedulaPersona=<%=persona.getCedulaPersona()%>
					&tipoPersona=<%=tipoPersona%>">Editar</a>
							<%
								}
										if (!cedulaPersona.equals(persona.getCedulaPersona())
												&& persona.getEstadoPersona() == 1) {
							%> <a
							href="eliminarPersona.jsp?cedulaPersona=<%=persona.getCedulaPersona()%>
					&tipoPersona=<%=tipoPersona%>"
							onclick="return confirm('Está seguro que desea eliminar a: <%=persona.getNombrePersona() + " "
								+ persona.getApellidoPersona()%>')">Eliminar</a>
							<%
								}
							%>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</section>

		<%
			}
			if (tipoPersona == 3) {
		%>
		<input onclick="window.location.href='agregarCliente.jsp'"
			type="button" value="<%="Agregar " + leyendaPersona%>">
		<%
			} else {
		%>
		<input
			onclick="window.location.href='editarPersona.jsp?tipoPersona=<%=tipoPersona%>'"
			type="button" value="<%="Agregar " + leyendaPersona%>">
		<%
			}
		%>
		<input
			onclick="window.location.href='reportePersonas.jsp?tipoPersona=<%=tipoPersona%>'"
			type="button" value="Generar reporte">
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />