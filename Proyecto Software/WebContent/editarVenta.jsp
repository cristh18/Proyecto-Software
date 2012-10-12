<%@page import="com.persistencia.AdministradorVenta"%>
<%@page import="com.logica.Venta"%>
<%@page import="com.persistencia.AdministradorPersona"%>
<%@page import="com.logica.Persona"%>
<%@page import="com.persistencia.AdministradorCarro"%>
<%@page import="com.logica.Carro"%>
<%@page import="java.util.List"%>
<%@page import="com.persistencia.SessionDB"%>
<%
	Object nombrePersona = session.getAttribute("nombrePersona");
	if (nombrePersona == null) {
		response.sendRedirect("index.jsp");
	}
	SessionDB.init();
	Venta venta = null;
	boolean ventaNueva = true;
	if (request.getParameter("idVenta") != null) {
		ventaNueva = false;
		venta = AdministradorVenta.getVenta(Integer.parseInt(request
		.getParameter("idVenta").toString()));
	} else {
		venta = new Venta();
	}
	List<Carro> listaCarros = AdministradorCarro.getListaCarro();
	Carro carro = null;
	List<Persona> listaCompradores = AdministradorPersona
	.getListaPersonas();
	Persona persona = null;
	int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
	.toString());
	if (tipoMenu == 1) {
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<section id="editarVenta">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="editarVenta">
		<%
			}
		%>
		<img alt="venta" src="imagenes/venta.jpg" id="imagenVenta">
		<%
			if (listaCarros.size() == 0 && ventaNueva) {
		%>
		<h2>No hay carros disponibles para ser vendidos.</h2>
		<%
			} else {
		%>
		<div id="contact-form" class="clearfix">
			<ul id="errors" class="">
				<li id="info">There were some problems with your form
					submission:</li>
			</ul>
			<p id="success">Thanks for your message! We will get back to you
				ASAP!</p>
			<form method="post" action="guardarVenta.jsp">
				<script type="text/javascript">
					var peticion = false;
					var testPasado = false;
					try {
						peticion = new XMLHttpRequest();
					} catch (trymicrosoft) {
						try {
							peticion = new ActiveXObject("Msxml2.XMLHTTP");
						} catch (othermicrosoft) {
							try {
								peticion = new ActiveXObject(
										"Microsoft.XMLHTTP");
							} catch (failed) {
								peticion = false;
							}
						}
					}

					if (!peticion)
						alert("ERROR AL INICIALIZAR!");
					function cargarPersona(url, comboAnterior, element_id) {
						var element = document.getElementById(element_id);
						var valordepende = document
								.getElementById(comboAnterior);
						var x = valordepende.value;
						var fragment_url = url + '?cedulaPersona=' + x;
						peticion.open("GET", fragment_url);
						peticion.onreadystatechange = function() {
							if (peticion.readyState == 4) {
								element.innerHTML = peticion.responseText;
							}
						}
						peticion.send(null);
					}

					function cargarCarro(url, comboAnterior, element_id) {
						var element = document.getElementById(element_id);
						var valordepende = document
								.getElementById(comboAnterior);
						var x = valordepende.value;
						var fragment_url = url + '?placaCarro=' + x;
						peticion.open("GET", fragment_url);
						peticion.onreadystatechange = function() {
							if (peticion.readyState == 4) {
								element.innerHTML = peticion.responseText;
							}
						}
						peticion.send(null);
					}
				</script>

				<%
							if (listaCarros.size() > 0) {
						%>
				<label for="placaCarro">Placa carro: <span class="required">*</span></label>
				<select name="placaCarro" id="placaCarro"
					onchange="javascript:cargarCarro('informacionCarro.jsp', 'placaCarro', 'informacionCarro')">
					<option></option>
					<%
										if (!ventaNueva) {
									%>
					<option value="<%=venta.getIdCarroVenta().getPlacaCarro()%>"
						selected="selected"><%=venta.getIdCarroVenta().getPlacaCarro()%></option>
					<%
										}
												for (int i = 0; i < listaCarros.size(); i++) {
													carro = listaCarros.get(i);
									%>
					<option value="<%=carro.getPlacaCarro()%>"><%=carro.getPlacaCarro()%></option>
					<%
										}
									%>
				</select> <label for="informacionCarro">Información carro: <span
					class="required">*</span></label>
				<p id="informacionCarro"><jsp:include
						page="informacionCarro.jsp"></jsp:include>
				<p>
					<%
							}
						%>

					<label for="cedulaComprador">Cédula comprador: <span
						class="required">*</span></label> <select name="cedulaComprador"
						id="cedulaComprador"
						onchange="javascript:cargarPersona('informacionPersona.jsp', 'cedulaComprador', 'informacionPersona')">
						<option></option>
						<%
										for (int i = 0; i < listaCompradores.size(); i++) {
												persona = listaCompradores.get(i);
												if (venta.getIdClienteVenta().getCedulaPersona()
														.equals(persona.getCedulaPersona())) {
									%>
						<option value="<%=persona.getCedulaPersona()%>"
							selected="selected">
							<%=persona.getCedulaPersona()%></option>
						<%
										} else {
									%>
						<option value="<%=persona.getCedulaPersona()%>"><%=persona.getCedulaPersona()%></option>
						<%
										}
											}
									%>
					</select> <label for="nombreComprador">Nombre comprador: <span
						class="required">*</span></label>
				<p id="informacionPersona"><jsp:include
						page="informacionPersona.jsp"></jsp:include></p>

				<a href="agregarComprador.jsp">Agregar Comprador</a> <label
					for="fechaVenta">Fecha venta<span class="required">*</span></label>
				<input type="date" name="fechaVenta" required="required"
					value="<%=venta.getFechaVenta()%>">
				<%
					}
				%>
				<%
					if (ventaNueva) {
				%>
				<input type="submit" name="guardar" value="Crear">
				<input type="hidden" name="accion" value="guardar"><input
					type="hidden" name="cedulaVendedor"
					value=<%=session.getAttribute("cedulaPersona").toString()%>>
				<%
					} else {
						if (listaCarros.size() == 0) {
				%>
				<input type="submit" name="guardar" value="Guardar"> <input
					type="hidden" name="accion" value="editarSin"> <input
					type="hidden" name="idVenta" value=<%=venta.getIdVenta()%>>
				<%
					} else {
				%>
				<input type="submit" name="guardar" value="Guardar"> <input
					type="hidden" name="accion" value="editar"> <input
					type="hidden" name="idVenta" value=<%=venta.getIdVenta()%>>
				<%
					}
						if (tipoMenu == 1) {
				%>
				<button
					onclick="window.location.href='eliminarVenta.jsp?idVenta=<%=venta.getIdVenta()%>'"
					type="button">Eliminar</button>

				<%
					}
				%>
				<button onclick="window.location.href='reporteVenta.jsp?idVenta=<%=venta.getIdVenta()%>'"
	type="button">Generar reporte</button>
				<button onclick="window.location.href='venta.jsp'">Atras</button>
				<%
					}
				%>

			</form>
		</div>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />