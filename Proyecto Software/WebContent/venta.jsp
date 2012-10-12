<%@page import="java.text.DateFormat"%>
<%@page import="com.persistencia.AdministradorVenta"%>
<%@page import="com.logica.Venta"%>
<%@page import="java.util.List"%>
<%@page import="com.persistencia.SessionDB"%>
<%
	Object nombrePersona = session.getAttribute("nombrePersona");
	if (nombrePersona == null) {
		response.sendRedirect("index.jsp");
	}
	SessionDB.init();
	List<Venta> listaVentas = null;
	int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
			.toString());
	String parametro = "";
	if (tipoMenu == 1) {
		if (request.getParameter("fechaInicial") != null
				&& request.getParameter("fechaFinal") != null) {
			listaVentas = AdministradorVenta.getListaVentasFechas(
					request.getParameter("fechaInicial"),
					request.getParameter("fechaFinal"));
			parametro = "?fechaInicial="
					+ request.getParameter("fechaInicial")
					+ "&fechaFinal="
					+ request.getParameter("fechaFinal");
		} else if (request.getParameter("cedulaVendedor") != null) {
			listaVentas = AdministradorVenta
					.getListaVentasVendedor(request
							.getParameter("cedulaVendedor"));
			parametro = "?cedulaVendedor="
					+ request.getParameter("cedulaVendedor");
		} else {

			listaVentas = AdministradorVenta.getListaVentas();
		}
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<section id="venta">
	<%
		} else if (tipoMenu == 2) {
			listaVentas = AdministradorVenta.getListaVentasVendedor(session
					.getAttribute("cedulaPersona").toString());
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="venta">
		<%
			}
		%>
		<h1>Informacion Ventas</h1>
		<%
			if (listaVentas.size() == 0) {
		%>
		<h2>Ninguna venta encontrada.</h2>
		<%
			} else {
				if (request.getParameter("aviso") != null) {
					int numeroMensaje = Integer.parseInt(request
							.getParameter("aviso"));
					if (numeroMensaje == 1) {
		%>
		<h2>Venta almacenada correctamente.</h2>
		<%
			} else if (numeroMensaje == 2) {
		%>
		<h2>Venta editada correctamente.</h2>
		<%
			}
				}
		%>
		<section id="tablasInformacion">
			<table>
				<thead>
					<tr>
						<th>Codigo venta</th>
						<th>Placa carro</th>
						<th>Marca carro</th>
						<th>Modelo carro</th>
						<th>Precio carro</th>
						<th>Nombre vendedor</th>
						<th>Nombre comprador</th>
						<th>Nombre propietario</th>
						<th>Fecha venta</th>
						<th>Opción editar</th>
						<th>Opción eliminar</th>
					</tr>
				</thead>
				<tbody class="scrollContent">
					<%
						for (int i = 0; i < listaVentas.size(); i++) {
								Venta venta = listaVentas.get(i);
					%>
					<tr>
						<td><%=venta.getIdVenta()%></td>
						<td><%=venta.getIdCarroVenta().getPlacaCarro()%></td>
						<td><%=venta.getIdCarroVenta().getIdModeloCarro()
							.getIdMarcaModelo().getNombreMarca()%></td>
						<td><%=venta.getIdCarroVenta().getIdModeloCarro()
							.getNombreModelo()%></td>
						<td><%=venta.getIdCarroVenta().getPrecioCarro()%></td>
						<td><%=venta.getIdVendedorVenta().getNombrePersona()
							+ " "
							+ venta.getIdVendedorVenta().getApellidoPersona()%></td>
						<td><%=venta.getIdClienteVenta().getNombrePersona()
							+ " "
							+ venta.getIdClienteVenta().getApellidoPersona()%></td>
						<td><%=venta.getIdCarroVenta().getIdPropietarioPersona()
							.getNombrePersona()
							+ " "
							+ venta.getIdCarroVenta().getIdPropietarioPersona()
									.getApellidoPersona()%></td>
						<%
							DateFormat fechaVenta = DateFormat
											.getDateInstance(DateFormat.MEDIUM);
						%>
						<td><%=fechaVenta.format(venta.getFechaVenta())%></td>
						<td><a href="editarVenta.jsp?idVenta=<%=venta.getIdVenta()%>">Editar</a>
						<td><a
							href="reporteVenta.jsp?idVenta=<%=venta.getIdVenta()%>">Imprimir</a>
							<%
								if (tipoMenu == 1) {
							%>
						<td><a
							href="eliminarVenta.jsp?idVenta=<%=venta.getIdVenta()%>"
							onclick="return confirm('Está seguro que desea eliminar la venta con codigo: <%=venta.getIdVenta()%>')">Eliminar</a>
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
		<input
			onclick="window.location.href='reporteVentas.jsp<%=parametro%>'"
			type="button" value="Generar
	reporte"> <input
			onclick="window.location.href='editarVenta.jsp'" type="button"
			value="Generar reporte">
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />