<%@page import="com.persistencia.AdministradorImagen"%>
<%@page import="com.logica.Imagen"%>
<%@page import="com.persistencia.AdministradorPersona"%>
<%@page import="com.logica.Persona"%>
<%@page import="com.persistencia.AdministradorTipoCarro"%>
<%@page import="com.logica.TipoCarro"%>
<%@page import="com.persistencia.AdministradorTransmision"%>
<%@page import="com.logica.Transmision"%>
<%@page import="com.persistencia.AdministradorDireccion"%>
<%@page import="com.logica.Direccion"%>
<%@page import="com.persistencia.AdministradorCombustible"%>
<%@page import="com.logica.Combustible"%>
<%@page import="com.persistencia.AdministradorVidrio"%>
<%@page import="com.logica.Vidrio"%>
<%@page import="com.persistencia.AdministradorColor"%>
<%@page import="com.logica.Color"%>
<%@page import="com.logica.Modelo"%>
<%@page import="com.persistencia.AdministradorModelo"%>
<%@page import="com.persistencia.SessionDB"%>
<%@page import="com.logica.Marca"%>
<%@page import="com.persistencia.AdministradorMarca"%>
<%@page import="java.util.List"%>
<%@page import="com.persistencia.AdministradorCarro"%>
<%@page import="com.logica.Carro"%>
<%
	Object nombrePersona = session.getAttribute("nombrePersona");
	if (nombrePersona == null) {
		response.sendRedirect("index.jsp");
	}
	Carro carro = null;
	SessionDB.init();
	List<Marca> listaMarcas = AdministradorMarca.getListaMarcas();
	Marca marca = null;
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
	List<Persona> listaPersonas = AdministradorPersona
	.getListaPersonas();
	Persona propietario = null;
	List<Imagen> listaImagenes = null;
	boolean carroNuevo = true;
	if (request.getParameter("placaCarro") != null) {
		carroNuevo = false;
		carro = AdministradorCarro.getCarro(request
		.getParameter("placaCarro"));
		listaImagenes = AdministradorImagen.getListaImagenes(carro
		.getCodigoCarro());
	} else {
		carro = new Carro();
	}
	int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
	.toString());
	int tipoPersona = Integer.parseInt(session.getAttribute(
	"tipoPersona").toString());
	if (tipoMenu == 1) {
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<section id="editarAutomovil">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="editarAutomovil">
		<%
			}
		%>
		<h1>Información Automóvil</h1>
		<%
			if (request.getParameter("error") != null) {
				int numeroError = Integer.parseInt(request
				.getParameter("error"));
				if (numeroError == 1) {
		%>
		<h2>Nose pudo almacenar el automovil porque la placa ingresada ya
			existe.</h2>
		<%
			}
			}
		%>

		<div id="contact-form" class="clearfix">

			<ul id="errors" class="">
				<li id="info">There were some problems with your form
					submission:</li>
			</ul>
			<p id="success">Thanks for your message! We will get back to you
				ASAP!</p>
			<form method="post" enctype="multipart/form-data"
				action="guardarCarro.jsp">

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

					function cargarCombo(url, comboAnterior, element_id) {
						var element = document.getElementById(element_id);
						var valordepende = document
								.getElementById(comboAnterior);
						var x = valordepende.value;
						var fragment_url = url + '?marcaCarro=' + x;
						peticion.open("GET", fragment_url);
						peticion.onreadystatechange = function() {
							if (peticion.readyState == 4) {
								element.innerHTML = peticion.responseText;
							}
						}
						peticion.send(null);
					}

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
				</script>
				<label for="placa">Placa: <span class="required">*</span></label> <input
					type="text" name="placaCarro" required="required"
					value="<%=carro.getPlacaCarro()%>"> <label for="marca">Marca:
					<span class="required">*</span>
				</label> <select name="marcaCarro" id="marcaCarro"
					onchange="javascript:cargarCombo('modelos.jsp', 'marcaCarro', 'modeloCarro')">
					<option></option>
					<%
						for (int i = 0; i < listaMarcas.size(); i++) {
							marca = listaMarcas.get(i);
							if (marca.getIdMarca() == carro.getIdModeloCarro()
									.getIdMarcaModelo().getIdMarca()) {
					%>
					<option value="<%=marca.getIdMarca()%>" selected="selected"><%=marca.getNombreMarca()%></option>
					<%
						} else {
					%>
					<option value="<%=marca.getIdMarca()%>"><%=marca.getNombreMarca()%></option>
					<%
						}
						}
					%>
				</select> <label for="modelo">Modelo: <span class="required">*</span></label>
				<p id="modeloCarro"><jsp:include page="modelos.jsp"></jsp:include></p>

				<a href="agregarModelo.jsp">Agregar Modelo</a> <label for="color">Color:
					<span class="required">*</span>
				</label> <select name="colorCarro">
					<%
						for (int i = 0; i < listaColores.size(); i++) {
							color = listaColores.get(i);
							if (color.getIdColor() == carro.getIdColorCarro().getIdColor()) {
					%>
					<option value="<%=color.getIdColor()%>" selected="selected"><%=color.getNombreColor()%></option>
					<%
						} else {
					%>
					<option value="<%=color.getIdColor()%>"><%=color.getNombreColor()%></option>
					<%
						}
						}
					%>
				</select> <label for="vidrio">Vidrio: <span class="required">*</span></label>
				<select name="vidrioCarro">
					<%
						for (int i = 0; i < listaVidrios.size(); i++) {
							vidrio = listaVidrios.get(i);
							if (vidrio.getIdVidrio() == carro.getIdVidrioCarro()
									.getIdVidrio()) {
					%>
					<option value="<%=vidrio.getIdVidrio()%>" selected="selected"><%=vidrio.getNombreVidrio()%></option>
					<%
						} else {
					%>
					<option value="<%=vidrio.getIdVidrio()%>"><%=vidrio.getNombreVidrio()%></option>
					<%
						}
						}
					%>
				</select> <label for="combustible">Combustible: <span
					class="required">*</span></label> <select name="combustibleCarro">
					<%
						for (int i = 0; i < listaCombustibles.size(); i++) {
							combustible = listaCombustibles.get(i);
							if (combustible.getIdCombustible() == carro
									.getIdCombustibleCarro().getIdCombustible()) {
					%>
					<option value="<%=combustible.getIdCombustible()%>"
						selected="selected"><%=combustible.getNombreCombustible()%></option>
					<%
						} else {
					%>
					<option value="<%=combustible.getIdCombustible()%>"><%=combustible.getNombreCombustible()%></option>
					<%
						}
						}
					%>
				</select> <label for="direccion">Dirección: <span class="required">*</span></label>
				<select name="direccionCarro">
					<%
						for (int i = 0; i < listaDirecciones.size(); i++) {
							direccion = listaDirecciones.get(i);
							if (direccion.getIdDireccion() == carro.getIdDireccionCarro()
									.getIdDireccion()) {
					%>
					<option value="<%=direccion.getIdDireccion()%>" selected="selected"><%=direccion.getNombreDireccion()%></option>
					<%
						} else {
					%>
					<option value="<%=direccion.getIdDireccion()%>"><%=direccion.getNombreDireccion()%></option>
					<%
						}
						}
					%>
				</select> <label for="transmision">Transmisión: <span
					class="required">*</span></label> <select name="transmisionCarro">
					<%
						for (int i = 0; i < listaTransmisiones.size(); i++) {
							transmision = listaTransmisiones.get(i);
							if (transmision.getIdTransmision() == carro
									.getIdTransmisionCarro().getIdTransmision()) {
					%>
					<option value="<%=transmision.getIdTransmision()%>"
						selected="selected"><%=transmision.getNombreTransmision()%></option>
					<%
						} else {
					%>
					<option value="<%=transmision.getIdTransmision()%>"><%=transmision.getNombreTransmision()%></option>
					<%
						}
						}
					%>
				</select> <label for="cilindraje">Cilindraje: <span class="required">*</span></label>
				<input type="number" min="1" max="999999999" name="cilindrajeCarro"
					value="<%=carro.getCilindrajeCarro()%>"> <label for="anio">Año:
					<span class="required">*</span>
				</label> <input type="number" min="1800" max="3000" name="anioCarro"
					value="<%=carro.getAnioCarro()%>"> <label for="precio">Precio:
					<span class="required">*</span>
				</label> <input type="number" min="1" max="999999999" name="precioCarro"
					value="<%=carro.getPrecioCarro()%>">
				<%
					if (!carroNuevo && listaImagenes.size() > 0) {
				%>

				<%
					for (int i = 0; i < listaImagenes.size(); i++) {
				%>
				<a
					href="eliminarImagen.jsp?idImagen=<%=listaImagenes.get(i).getIdImagen()%>&placaCarro=<%=request.getParameter("placaCarro")%>"
					onclick="return confirm('Está seguro que desea eliminar la imagen.')">
					<img title="Eliminar"
					src="leerImagen.jsp?idImagen=<%=listaImagenes.get(i).getIdImagen()%>"
					width="150" height="150" border="1" />Eliminar
				</a>
				<%
					}
				%>

				<%
					}
				%>

				<label for="imagenes">Imágenes: <span class="required">*</span></label>
				<input type="file" name="imagen" multiple="multiple"> <label
					for="cedulaPropietario">Cédula propietario: <span
					class="required">*</span></label> <select name="propietarioCarro"
					id="propietarioCarro"
					onchange="javascript:cargarPersona('informacionPersona.jsp', 'propietarioCarro', 'informacionPersona')">
					<option></option>
					<%
						for (int i = 0; i < listaPersonas.size(); i++) {
							propietario = listaPersonas.get(i);
							if (propietario.getCedulaPersona() == carro
									.getIdPropietarioPersona().getCedulaPersona()) {
					%>
					<option value="<%=propietario.getCedulaPersona()%>"
						selected="selected"><%=propietario.getCedulaPersona()%></option>
					<%
						} else {
					%>
					<option value="<%=propietario.getCedulaPersona()%>"><%=propietario.getCedulaPersona()%></option>
					<%
						}
						}
					%>
				</select> <label for="nombrePropietario">Nombre propietario: <span
					class="required">*</span></label>
				<p id="informacionPersona"><jsp:include
						page="informacionPersona.jsp"></jsp:include></p>

				<a href="agregarPropietario.jsp">Agregar Propietario</a> <label
					for="fechaIngreso">Fecha ingreso: <span class="required">*</span></label>
				<input type="date" name="ingresoCarro" required="required"
					value="<%=carro.getFechaIngresoCarro()%>">
				<%
					if (carroNuevo) {
				%>
				<input type="submit" name="guardar" value="Crear"> <input
					type="hidden" name="accion" value="guardar">
				<%
					} else {
				%>
				<input type="submit" name="guardar" value="Guardar">
				<button
					onclick="window.location.href='reporteCarro.jsp?placaCarro=<%=carro.getCodigoCarro()%>'"
					type="button">Generar reporte</button>
				<button
					onclick="window.location.href='eliminarCarro.jsp?tipoPersona=<%=tipoPersona%>&placaCarro=<%=carro.getPlacaCarro()%>'"
					type="button">Eliminar</button>
				<input type="hidden" name="accion" value="editar">
				<%
					}
				%>
			</form>
		</div>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />