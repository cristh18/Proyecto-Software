<%@page import="com.persistencia.AdministradorImagen"%>
<%@page import="com.logica.Imagen"%>
<%@page import="com.persistencia.AdministradorCarro"%>
<%@page import="com.logica.Carro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.persistencia.AdministradorModelo"%>
<%@page import="com.logica.Modelo"%>
<%@page import="com.persistencia.AdministradorTransmision"%>
<%@page import="com.logica.Transmision"%>
<%@page import="com.logica.Direccion"%>
<%@page import="com.persistencia.AdministradorDireccion"%>
<%@page import="com.persistencia.AdministradorCombustible"%>
<%@page import="com.logica.Combustible"%>
<%@page import="com.persistencia.AdministradorVidrio"%>
<%@page import="com.logica.Vidrio"%>
<%@page import="com.logica.Color"%>
<%@page import="com.persistencia.AdministradorColor"%>
<%@page import="com.persistencia.AdministradorMarca"%>
<%@page import="com.logica.Marca"%>
<%@page import="java.util.List"%>
<%@page import="com.persistencia.SessionDB"%>
<%
	SessionDB.init();
	List<Carro> listaCarros = AdministradorCarro.getListaCarro();
	Carro carro = null;
	List<Imagen> listaImagenes = null;
	List<Marca> listaMarcas = AdministradorMarca.getListaMarcas();
	Marca marca = null;
	List<Modelo> listaModelos = null;
	Modelo modelo = null;
	if (request.getParameter("marca") != null) {
		listaModelos = AdministradorModelo.getListaModelo(Integer
				.parseInt(request.getParameter("marca")));

	}
	List<Color> listaColores = AdministradorColor.getListaColor();
	Color color = null;
	List<Vidrio> listaVidrios = AdministradorVidrio.getListaVidrios();
	Vidrio vidrio = null;
	List<Combustible> listaCombustibles = AdministradorCombustible
			.getListaCombustibles();
	Combustible combustible = null;
	List<Direccion> listaDirecciones = AdministradorDireccion
			.getListaDireccion();
	Direccion direccion = null;
	List<Transmision> listaTransmisiones = AdministradorTransmision
			.getListaTransmisiones();
	Transmision transmision = null;
%>
<jsp:include page="encabezadoGeneral.jsp" />

<nav id="navIndex">
	<ul id="navigationIndex">
		<li><a>Marca</a>
			<ul>
				<%
					for (int i = 0; i < listaMarcas.size(); i++) {
						marca = listaMarcas.get(i);
				%>
				<li><a href="index.jsp?marca=<%=marca.getIdMarca()%>"><%=marca.getNombreMarca()%></a></li>
				<%
					}
				%>
			</ul></li>
		<%
			if (listaModelos != null) {
		%>
		<li><a>Modelo</a>
			<ul>
				<%
					for (int i = 0; i < listaModelos.size(); i++) {
							modelo = listaModelos.get(i);
				%>
				<li><a href="index.jsp?modelo=<%=modelo.getIdModelo()%>"><%=modelo.getNombreModelo()%></a></li>
				<%
					}
				%>
			</ul></li>
		<%
			}
		%>
		<li><a>Color</a>
			<ul>
				<%
					for (int i = 0; i < listaColores.size(); i++) {
						color = listaColores.get(i);
				%>
				<li><a href="index.jsp?color=<%=color.getIdColor()%>"><%=color.getNombreColor()%></a></li>
				<%
					}
				%>
			</ul></li>
		<li><a>Vidrio</a>
			<ul>
				<%
					for (int i = 0; i < listaVidrios.size(); i++) {
						vidrio = listaVidrios.get(i);
				%>
				<li><a href="index.jsp?vidrio=<%=vidrio.getIdVidrio()%>"><%=vidrio.getNombreVidrio()%></a></li>
				<%
					}
				%>
			</ul></li>
		<li><a>Combustible</a>
			<ul>
				<%
					for (int i = 0; i < listaCombustibles.size(); i++) {
						combustible = listaCombustibles.get(i);
				%>
				<li><a
					href="index.jsp?combustible=<%=combustible.getIdCombustible()%>"><%=combustible.getNombreCombustible()%></a></li>
				<%
					}
				%>
			</ul></li>
		<li><a>Direccion</a>
			<ul>
				<%
					for (int i = 0; i < listaDirecciones.size(); i++) {
						direccion = listaDirecciones.get(i);
				%>
				<li><a
					href="index.jsp?direccion=<%=direccion.getIdDireccion()%>"><%=direccion.getNombreDireccion()%></a></li>
				<%
					}
				%>
			</ul></li>
		<li><a>Transmision</a>
			<ul>
				<%
					for (int i = 0; i < listaTransmisiones.size(); i++) {
						transmision = listaTransmisiones.get(i);
				%>
				<li><a
					href="index.jsp?transmision=<%=transmision.getIdTransmision()%>"><%=transmision.getNombreTransmision()%></a></li>
				<%
					}
				%>
			</ul></li>
	</ul>
</nav>
<section id="anuncio">
	<%
		if (request.getParameter("marca") != null) {
			listaCarros = AdministradorCarro.getListaCarroParametro(1,
					Integer.parseInt(request.getParameter("marca")));
	%>
	<a href="<%=request.getRequestURI()%>"> marca x</a>
	<%
		}
		if (request.getParameter("modelo") != null) {
			listaCarros = AdministradorCarro.getListaCarroParametro(2,
					Integer.parseInt(request.getParameter("modelo")));
	%>
	<a href="<%=request.getRequestURI()%>"> modelo x</a>
	<%
		}
		if (request.getParameter("color") != null) {
			listaCarros = AdministradorCarro.getListaCarroParametro(3,
					Integer.parseInt(request.getParameter("color")));
	%>
	<a href="<%=request.getRequestURI()%>"> color x</a>
	<%
		}
		if (request.getParameter("vidrio") != null) {
			listaCarros = AdministradorCarro.getListaCarroParametro(4,
					Integer.parseInt(request.getParameter("vidrio")));
	%>
	<a href="<%=request.getRequestURI()%>"> vidrio x</a>
	<%
		}
		if (request.getParameter("combustible") != null) {
			listaCarros = AdministradorCarro.getListaCarroParametro(5,
					Integer.parseInt(request.getParameter("combustible")));
	%>
	<a href="<%=request.getRequestURI()%>"> combustible x </a>
	<%
		}
		if (request.getParameter("direccion") != null) {
			listaCarros = AdministradorCarro.getListaCarroParametro(6,
					Integer.parseInt(request.getParameter("direccion")));
	%>
	<a href="<%=request.getRequestURI()%>"> direccion x</a>
	<%
		}
		if (request.getParameter("transmision") != null) {
			listaCarros = AdministradorCarro.getListaCarroParametro(7,
					Integer.parseInt(request.getParameter("transmision")));
	%>
	<a href="<%=request.getRequestURI()%>"> transmision x </a>
	<%
		}
		if (request.getParameter("ultimos") != null) {
			listaCarros = AdministradorCarro.getListaCarroUltimos();
	%>
	<a href="<%=request.getRequestURI()%>"> ultimos x</a>
	<%
		}
		if (listaCarros.size() == 0) {
	%>
	<h1>Lo sentimos ningun carro encontrado .</h1>
	<%
		} else {
	%>
	<section id="tablasInformacion">
		<table>
			<tbody>
				<%
					for (int i = 0; i < listaCarros.size(); i++) {
							carro = listaCarros.get(i);
							listaImagenes = AdministradorImagen.getListaImagenes(carro
									.getCodigoCarro());
							if (i == 0 || i % 4 == 0) {
				%>
				<tr onscroll="true">
					<%
						}
					%>
					<td>
						<%
							if (listaImagenes.size() > 0) {
						%> <a
						href="consultarCarro.jsp?placaCarro=<%=carro.getPlacaCarro()%> ">
							<img title="Consultar"
							src="leerImagen.jsp?idImagen=<%=listaImagenes.get(0).getIdImagen()%>"
							width="200" height="200" border="1" />
					</a> <%
 	} else {
 %> <img src="noExiste.jpg" width="200" height="200" border="1"> <%
 	}
 %> <br> <a
						href="consultarCarro.jsp?placaCarro=<%=carro.getPlacaCarro()%> ">Precio:
							<%=carro.getPrecioCarro()%></a> <br> <a
						href="consultarCarro.jsp?placaCarro=<%=carro.getPlacaCarro()%> ">Anio:
							<%=carro.getAnioCarro()%></a>
					</td>
					<%
						}
					%>
				</tr>
			</tbody>
		</table>
	</section>
	<%
		}
	%>

</section>
<jsp:include page="pieDePagina.jsp" />