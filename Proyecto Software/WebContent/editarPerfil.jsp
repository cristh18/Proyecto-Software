<%@page import="com.persistencia.AdministradorPersona"%>
<%@page import="com.logica.Persona"%>
<%@page import="com.persistencia.SessionDB"%>
<%
	Object nombrePersona = session.getAttribute("nombrePersona");
	if (nombrePersona == null) {
		response.sendRedirect("index.jsp");
	}
	SessionDB.init();
	Persona persona = AdministradorPersona.getPersona(request
			.getParameter("cedulaPersona"));
	int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
			.toString());
	if (tipoMenu == 1) {
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<section id="editarPerfil">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="editarPerfil">
		<%
			}
		%>
		<h1>Informacion perfil.</h1>
		<div id="contact-form" class="clearfix">
			<ul id="errors" class="">
				<li id="info">There were some problems with your form
					submission:</li>
			</ul>
			<p id="success">Thanks for your message! We will get back to you
				ASAP!</p>
			<form method="post" action="guardarPersona.jsp">

				<label for="nombre">Nombre: <span class="required">*</span></label>
				<input type="text" name="nombrePersona"
					value="<%=persona.getNombrePersona()%>" required="required">

				<label for="apellido">Apellido: <span class="required">*</span></label>
				<input type="text" name="apellidoPersona"
					value="<%=persona.getApellidoPersona()%>" required="required">

				<label for="cedula">Cédula: <span class="required">*</span></label>
				<input type="text" name="cedulaPersona" readonly="readonly"
					value="<%=persona.getCedulaPersona()%>"> <label
					for="telefono">Teléfono: <span class="required">*</span></label> <input
					type="text" name="telefonoPersona"
					value="<%=persona.getTelefonoPersona()%>" required="required">

				<label for="direccion">Dirección: <span class="required">*</span></label>
				<input type="text" name="direccionPersona"
					value="<%=persona.getDireccionPersona()%>"> <label
					for="correo">Correo: <span class="required">*</span></label> <input
					type="email" name="correoPersona"
					value="<%=persona.getCorreoPersona()%>"> <input
					type="submit" name="guardar" value="Guardar">
				<input type="hidden" name="accion" value="editarPerfil">
			</form>
		</div>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />