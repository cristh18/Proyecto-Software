<%@page import="com.persistencia.AdministradorPersona"%>
<%@page import="com.logica.Persona"%>
<%
	Object nombrePersona = session.getAttribute("nombrePersona");
	if (nombrePersona == null) {
		response.sendRedirect("index.jsp");
	}
	boolean nuevoCliente = true;
	Persona persona = null;
	if (request.getParameter("cedulaPersona") != null) {
		persona = AdministradorPersona.getPersona(request
				.getParameter("cedulaPersona"));
		nuevoCliente = false;
	} else {
		persona = new Persona();
	}
	int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
			.toString());
	if (tipoMenu == 1) {
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<section id="agregarCliente">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="agregarCliente">
		<%
			}
		%>
		<img alt="Cliente" src="imagenes/cliente.jpg" id="imagenCliente">
		<%
			if (request.getParameter("error") != null) {
				int numeroError = Integer.parseInt(request
						.getParameter("error"));
				if (numeroError == 1) {
		%>
		<h2>La informacion no se a almacenado porque la cedula ya ha sido
			ingresada.</h2>
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
			<form method="post" action="guardarCliente.jsp">
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
					function cargarCampos(url, comboAnterior, element_id) {
						var element = document.getElementById(element_id);
						var valordepende = document
								.getElementById(comboAnterior);
						var x = valordepende.value;
						var fragment_url = url + '?tipoPersona=' + x;
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
					if (nuevoCliente) {
				%>
				<label for="tipoPersona">Tipo persona: <span
					class="required">*</span></label> <select name="tipoPersona"
					id="tipoPersona"
					onchange="javascript:cargarCampos('camposNueva.jsp', 'tipoPersona', 'informacionPersona')">
					<option></option>
					<option value="1">Persona natural</option>
					<option value="2">Persona juridica</option>
				</select>
				<table id="informacionPersona">
					<tbody>
						<jsp:include page="camposNueva.jsp"></jsp:include>
					</tbody>
				</table>
				<%
					} else {
				%>
				<input type="hidden" name="tipoPersona"
					value="<%=persona.getTipoPersona()%>">

				<%
							if (persona.getTipoCliente() == 1) {
						%>
				<label for="nombre">Nombre: <span class="required">*</span></label>

				<input type="text" name="nombrePersona"
					value="<%=persona.getNombrePersona()%>" required="required">

				<label for="apellido">Apellido: <span class="required">*</span></label>
				<input type="text" name="apellidoPersona"
					value="<%=persona.getApellidoPersona()%>" required="required">

				<label for="cedula">Cédula: <span class="required">*</span></label>
				<input type="text" name="cedulaPersona"
					value="<%=persona.getCedulaPersona()%>" readonly="readonly">
				<%
							} else {
						%>
				<label for="razonSocial">Razón social: <span
					class="required">*</span></label> <input type="text" name="nombrePersona"
					value="<%=persona.getNombrePersona()%>" required="required">

				<input type="hidden" name="apellidoPersona" value=""> <label
					for="nit">NIT: <span class="required">*</span></label> <input
					type="text" name="cedulaPersona"
					value="<%=persona.getCedulaPersona()%>" readonly="readonly">
				<%
							}
						%>

				<%
					}
				%>

				<label for="telefono">Teléfono: <span class="required">*</span></label>
				<input type="text" name="telefonoPersona" required="required"
					value="<%=persona.getTelefonoPersona()%>"> <label
					for="direccion">Direccion: <span class="required">*</span></label>
				<input type="text" name="direccionPersona"
					value="<%=persona.getDireccionPersona()%>"> <label
					for="correo">Correo: <span class="required">*</span></label> <input
					type="email" name="correoPersona"
					value="<%=persona.getCorreoPersona()%>">


				<%
					if (nuevoCliente) {
				%>
				<input type="submit" name="guardar" value="Crear">
				<input type="hidden" name="accion" value="guardar">
				<%
					} else {
				%>
				<input type="submit" name="guardar" value="Guardar"> <input type="hidden" name="accion"
					value="editar">
					<button
	onclick="window.location.href='reportePersona.jsp?cedulaPersona=<%=persona.getCedulaPersona()%>'"
	type="button">Generar reporte</button>
				<button
					onclick="window.location.href='eliminarPersona.jsp?tipoPersona=<%=3%>&cedulaPersona=<%=persona.getCedulaPersona()%>'"
					type="button">Eliminar</button>
				<%
					}
				%>

			</form>
		</div>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />