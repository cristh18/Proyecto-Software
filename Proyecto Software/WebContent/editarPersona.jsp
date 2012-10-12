<%@page import="com.persistencia.SessionDB"%>
<%@page import="com.persistencia.AdministradorPersona"%>
<%@page import="com.logica.Persona"%>
<%
	Object nombrePersona = session.getAttribute("nombrePersona");
	if (nombrePersona == null) {
		response.sendRedirect("index.jsp");
	}
	int tipoPersona = 0;
	Persona persona = null;
	boolean nuevaPersona = true;
	if (request.getParameter("cedulaPersona") != null
			&& request.getParameter("tipoPersona") != null) {
		tipoPersona = Integer.parseInt(request
				.getParameter("tipoPersona"));
		SessionDB.init();
		persona = AdministradorPersona.getPersona(request
				.getParameter("cedulaPersona"));
		nuevaPersona = false;
	} else if (request.getParameter("tipoPersona") != null) {
		tipoPersona = Integer.parseInt(request
				.getParameter("tipoPersona"));
		persona = new Persona();
	}
	int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
			.toString());
	String cedulaPersona = session.getAttribute("cedulaPersona")
			.toString();
	if (tipoMenu == 1) {
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<section id="editarPersona">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="editarPersona">
		<%
			}
			if (tipoPersona == 1) {
		%>
		<h1>Información Administrador</h1>
		<%
			} else if (tipoPersona == 2) {
		%>
		<h1>Información Vendedor</h1>
		<%
			}
			if (request.getParameter("error") != null) {
				int numeroError = Integer.parseInt(request
						.getParameter("error"));
				if (numeroError == 2) {
		%>
		<h2>La informacion no se a almacenado porque las contrasenias son
			diferentes.</h2>
		<%
			} else if (numeroError == 1) {
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

			<form method="post" action="guardarPersona.jsp">
				<label for="name">Nombre: <span class="required">*</span></label> <input
					type="text" name="nombrePersona"
					value="<%=persona.getNombrePersona()%>" required="required">

				<label for="apellido">Apellido: <span class="required">*</span></label>
				<input type="text" name="apellidoPersona"
					value="<%=persona.getApellidoPersona()%>" required="required">

				<%
					if (nuevaPersona) {
				%>
				<label for="cedula">Cédula: <span class="required">*</span></label>
				<input type="number" name="cedulaPersona" required="required">
				<%
					} else {
				%>

				<label for="cedula">Cédula: <span class="required">*</span></label>
				<input type="text" name="cedulaPersona" readonly="readonly"
					value="<%=persona.getCedulaPersona()%>">
				<%
					}
				%>
				<label for="telefono">Teléfono: <span class="required">*</span></label>
				<input type="text" name="telefonoPersona"
					value="<%=persona.getTelefonoPersona()%>" required="required">


				<label for="direccion">Dirección: <span class="required">*</span></label>
				<input type="text" name="direccionPersona"
					value="<%=persona.getDireccionPersona()%>"> <label
					for="correo">Correo: <span class="required">*</span></label> <input
					type="email" name="correoPersona"
					value="<%=persona.getCorreoPersona()%>">
				<%
					if (nuevaPersona) {
				%>
				<label for="contrasenia">Contraseña: <span class="required">*</span></label>
				<input type="password" name="contraseniaPersona1" value=""
					required="required"> <label for="repetirContrasenia">Repetir
					contraseña: <span class="required">*</span>
				</label> <input type="password" name="contraseniaPersona2" value=""
					required="required">
				<%
					}
				%>
				<label for="salario">Salario: <span class="required">*</span></label>
				<input type="number" min="1" max="999999999" name="salarioPersona"
					required="required" value="<%=persona.getSalarioPersona()%>">

				<label for="fechaIngreso">Fecha ingreso: <span
					class="required">*</span></label> <input type="date"
					name="fechaIngresoPersona" required="required"
					value="<%=persona.getFechaIngresoPersona()%>">
				<%
					if (persona.getEstadoPersona() == 2) {
				%>
				<label for="fechaCancelacion">Fecha cancelación: <span
					class="required">*</span></label> <input type="date"
					name="fechaCancelacionPersona" required="required"
					value="<%=persona.getFechaCancelacionPersona()%>">
				<%
					}
				%>

				<%
					if (nuevaPersona) {
				%>
				<input type="submit" name="guardar" value="Crear"> <input
					type="hidden" name="accion" value="guardar">
				<%
					} else {
				%>
				<input type="submit" name="guardar" value="Guardar"> <input
					type="hidden" name="accion" value="editar">
				<button
					onclick="window.location.href='reportePersona.jsp?cedulaPersona=<%=persona.getCedulaPersona()%>'"
					type="button">Generar reporte</button>
				<%
					if (!cedulaPersona.equals(persona.getCedulaPersona())
								&& persona.getEstadoPersona() == 1) {
				%>
				<button
					onclick="window.location.href='eliminarPersona.jsp?tipoPersona=<%=tipoPersona%>&cedulaPersona=<%=persona.getCedulaPersona()%>'"
					type="button">Eliminar</button>
				<%
					}
					}
				%>
				<input type="hidden" name="tipoPersona" value="<%=tipoPersona%>">
			</form>
		</div>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />