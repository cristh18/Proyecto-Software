<%@page import="com.persistencia.AdministradorImagen"%>
<%@page import="com.logica.Imagen"%>
<%@page import="java.util.List"%>
<%@page import="com.persistencia.AdministradorCarro"%>
<%@page import="com.logica.Carro"%>
<%@page import="com.persistencia.SessionDB"%>
<%
	SessionDB.init();
	Carro carro = AdministradorCarro.getCarro(request
			.getParameter("placaCarro"));
	List<Imagen> listaImagenes = AdministradorImagen
			.getListaImagenes(carro.getCodigoCarro());
%>
<jsp:include page="encabezadoGeneral.jsp" />
<div class="scrollableContainer">
	<div class="scrollingArea">
		<table class="cruises scrollable">
			<tbody>
				<%
					if (listaImagenes.size() > 0) {
				%>
				<tr>
					<td></td>
					<td>
						<%
							for (int i = 0; i < listaImagenes.size(); i++) {
						%> <img title="Eliminar"
						src="leerImagen.jsp?idImagen=<%=listaImagenes.get(i).getIdImagen()%>"
						width="200" height="200" border="1" /> <%
 	}
 %>
					</td>
				</tr>
				<%
					}
				%>
				<tr>
					<th><div class="placa">Placa</div></th>
					<td><input type="text" readonly="readonly"
						value="<%=carro.getPlacaCarro()%>"></td>
				</tr>
				<tr>
					<th><div class="marca">Marca</div></th>
					<td><input type="text" readonly="readonly"
						value="<%=carro.getIdModeloCarro().getIdMarcaModelo()
					.getNombreMarca()%>"></td>
				</tr>
				<tr>
					<th><div class="modelo">Modelo</div></th>
					<td><input type="text" readonly="readonly"
						value="<%=carro.getIdModeloCarro().getNombreModelo()%>"></td>
				</tr>
				<tr>
					<th><div class="vidrio">Vidrio</div></th>
					<td><input type="text" readonly="readonly"
						value="<%=carro.getIdVidrioCarro().getNombreVidrio()%>"></td>
				</tr>
				<tr>
					<th><div class="combustible">Combustible</div></th>
					<td><input type="text" readonly="readonly"
						value="<%=carro.getIdCombustibleCarro().getNombreCombustible()%>"></td>
				</tr>
				<tr>
					<th><div class="direccion">Dirección</div></th>
					<td><input type="text" readonly="readonly"
						value="<%=carro.getIdDireccionCarro().getNombreDireccion()%>"></td>
				</tr>
				<tr>
					<th><div class="transmision">Transmisión</div></th>
					<td><input type="text" readonly="readonly"
						value="<%=carro.getIdTransmisionCarro().getNombreTransmision()%>"></td>
				</tr>
				<tr>
					<th><div class="cilindraje">Cilindraje</div></th>
					<td><input type="text" readonly="readonly"
						value="<%=carro.getCilindrajeCarro()%>"></td>
				</tr>

				<tr>
					<th><div class="anio">Año</div></th>
					<td><input type="text" readonly="readonly"
						value="<%=carro.getAnioCarro()%>"></td>
				</tr>
				<tr>
					<th><div class="precio">Precio</div></th>
					<td><input type="text" readonly="readonly"
						value="<%=carro.getPrecioCarro()%>"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="pieDePagina.jsp" />