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
	List<Imagen> listaImagenes = AdministradorImagen.getListaImagenes(carro.getCodigoCarro());
%>
<jsp:include page="encabezadoGeneral.jsp" />
<table>
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
			<td>Placa</td>
			<td><input type="text" readonly="readonly"
				value="<%=carro.getPlacaCarro()%>"></td>
		</tr>
		<tr>
			<td>Marca</td>
			<td><input type="text" readonly="readonly"
				value="<%=carro.getIdModeloCarro().getIdMarcaModelo().getNombreMarca()%>"></td>
		</tr>
		<tr>
			<td>Modelo</td>
			<td><input type="text" readonly="readonly"
				value="<%=carro.getIdModeloCarro().getNombreModelo()%>"></td>
		</tr>
		<tr>
			<td>Vidrio</td>
			<td><input type="text" readonly="readonly"
				value="<%=carro.getIdVidrioCarro().getNombreVidrio()%>"></td>
		</tr>
		<tr>
			<td>Combustible</td>
			<td><input type="text" readonly="readonly"
				value="<%=carro.getIdCombustibleCarro().getNombreCombustible()%>"></td>
		</tr>
		<tr>
			<td>Direccion</td>
			<td><input type="text" readonly="readonly"
				value="<%=carro.getIdDireccionCarro().getNombreDireccion()%>"></td>
		</tr>
		<tr>
			<td>Transmision</td>
			<td><input type="text" readonly="readonly"
				value="<%=carro.getIdTransmisionCarro().getNombreTransmision()%>"></td>
		</tr>
		<tr>
			<td>Cilindraje</td>
			<td><input type="text" readonly="readonly"
				value="<%=carro.getCilindrajeCarro()%>"></td>
		</tr>
		<tr>
			<td>Cilindraje</td>
			<td><input type="text" readonly="readonly"
				value="<%=carro.getCilindrajeCarro()%>"></td>
		</tr>
		<tr>
			<td>Anio</td>
			<td><input type="text" readonly="readonly"
				value="<%=carro.getAnioCarro()%>"></td>
		</tr>
		<tr>
			<td>Precio</td>
			<td><input type="text" readonly="readonly"
				value="<%=carro.getPrecioCarro()%>"></td>
		</tr>
	</tbody>
</table>
<jsp:include page="pieDePagina.jsp" />