
<%@page import="com.persistencia.AdministradorImagen"%>
<%@page import="com.logica.Imagen"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.persistencia.SessionDB"%>
<%@page import="com.logica.Persona"%>
<%@page import="com.logica.Modelo"%>
<%@page import="com.persistencia.AdministradorModelo"%>
<%@page import="com.persistencia.AdministradorMarca"%>
<%@page import="com.logica.Marca"%>
<%@page import="com.logica.Carro"%>
<%@page import="java.util.List"%>
<%@page import="com.persistencia.AdministradorCarro"%>
<%
Object nombrePersona = session.getAttribute("nombrePersona");
if (nombrePersona == null) {
	response.sendRedirect("index.jsp");
}
SessionDB.init();
List<Carro> listaCarros = null;
List<Imagen> listaImagenes = null;
int estadoFinal = 0;
if (request.getParameter("estado") != null) {
	int estado = Integer.parseInt(request.getParameter("estado"));
	if (estado == 1) {
		listaCarros = AdministradorCarro.getListaCarroVendidos();
		estadoFinal = 1;
	} else {
		listaCarros = AdministradorCarro.getListaCarrosTodos();
		estadoFinal = 3;
	}
} else {
	listaCarros = AdministradorCarro.getListaCarro();
	estadoFinal = 2;
}
Carro carro = null;
int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
		.toString());
if (tipoMenu == 1) {
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<section id="automovil">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="automovil">
		<%
			}
		%>
		<h1>Información automoviles.</h1>
		<%
			if (listaCarros.size() == 0) {
		%>
		<h2>Ningun carro encontrado.</h2>
		<%
			} else {
				if (request.getParameter("aviso") != null) {
					int numeroMensaje = Integer.parseInt(request
							.getParameter("aviso"));
					if (numeroMensaje == 1) {
		%>
		<h2>Automovil almacenado correctamente.</h2>
		<%
			} else if (numeroMensaje == 2) {
		%>
		<h2>Automovil eliminado correctamente.</h2>
		<%
			} else if (numeroMensaje == 3) {
		%>
		<h2>Automovil editado correctamente.</h2>
		<%
			}
				}
		%>
		<section id="tablasInformacion">
			<table>
				<thead>
					<tr>
						<th>Placa</th>
						<th>Marca</th>
						<th>Modelo</th>
						<th>Año</th>
						<th>Precio</th>
						<th>Propietario</th>
						<th>Fecha ingreso</th>
						<%
							if (request.getParameter("estado") != null) {
						%>
						<th>Fecha venta</th>
						<%
							}
						%>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < listaCarros.size(); i++) {
								carro = listaCarros.get(i);
								listaImagenes = AdministradorImagen.getListaImagenes(carro
										.getCodigoCarro());
					%>
					<tr>
						<td><%=carro.getPlacaCarro()%></td>
						<td><%=carro.getIdModeloCarro().getIdMarcaModelo()
							.getNombreMarca()%></td>
						<td><%=carro.getIdModeloCarro().getNombreModelo()%></td>
						<td><%=carro.getAnioCarro()%></td>
						<td><%=carro.getPrecioCarro()%></td>
						<td><%=carro.getIdPropietarioPersona()
							.getNombrePersona()
							+ " "
							+ carro.getIdPropietarioPersona()
									.getApellidoPersona()%></td>
						<%
				DateFormat fecha = DateFormat
								.getDateInstance(DateFormat.MEDIUM);
			%>
			<td><%=fecha.format(carro.getFechaIngresoCarro())%></td>
			<%
				if (carro.getEstadoCarro() == 1) {
			%>
			<td></td>
			<td><a
				href="editarAutomovil.jsp?placaCarro=<%=carro.getPlacaCarro()%>">Editar</a>
				<a
				href="eliminarCarro.jsp?placaCarro=<%=carro.getPlacaCarro()%>
					&tipoPersona"
				onclick="return confirm('Está seguro que desea eliminar el carro con placa: <%=carro.getPlacaCarro()%>')">Eliminar</a>
			</td>
			<%
				}
						if (carro.getFechaVentaCarro() != null) {
			%>
			<td><%=fecha.format(carro.getFechaVentaCarro())%></td>
			<%
				}
						if (carro.getEstadoCarro() == 2) {
			%>
			<td><a href="reporteCarro.jsp?placaCarro=<%=carro.getCodigoCarro()%>">Imprimir</a>
			</td>
			<%
				}
						if (listaImagenes.size() > 0) {
			%>
						<td><img
							src="leerImagen.jsp?idImagen=<%=listaImagenes.get(0).getIdImagen()%>"
							width="100" height="100" border="1" /></td>
						<%
							}
						%>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</section>
		<%
			}
		%>
		<input onclick="window.location.href='editarAutomovil.jsp'"
			type="button" value="Agregar automovil">
	<input
	onclick="window.location.href='reporteCarros.jsp?estado=<%=estadoFinal%>'"
	type="button" value="Generar reporte">
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />