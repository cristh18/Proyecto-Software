<%@page import="com.persistencia.SessionDB"%>
<%@page import="com.persistencia.AdministradorPersona"%>
<%@page import="com.logica.Persona"%>
<%
	Object nombrePersona = session.getAttribute("nombrePersona");
	if (nombrePersona == null) {
		response.sendRedirect("index.jsp");
	}
	SessionDB.init();
	int tipoPersona = Integer.parseInt(session.getAttribute(
			"tipoPersona").toString());
	Persona persona = AdministradorPersona.getPersona(session
			.getAttribute("cedulaPersona").toString());
	int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
			.toString());
	if (tipoMenu == 1) {
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<section id="informacionPerfil">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="informacionPerfil">
		<%
			}
		%>
		<h1>Información perfil</h1>
		<%
			if (request.getParameter("aviso") != null) {
				int numeroMensaje = Integer.parseInt(request
						.getParameter("aviso"));
				if (numeroMensaje == 1) {
		%>
		<h2>Perfil editado correctamente.</h2>
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
			<label for="nombre">Nombre: <span class="required">*</span></label> <input
				type="text" readonly="readonly"
				value="<%=persona.getNombrePersona()%>"> <label
				for="apellido">Apellido: <span class="required">*</span></label> <input
				type="text" readonly="readonly"
				value="<%=persona.getApellidoPersona()%>"> <label
				for="cedula">Cédula: <span class="required">*</span></label> <input
				type="text" readonly="readonly"
				value="<%=persona.getCedulaPersona()%>"> <label
				for="telefono">Teléfono: <span class="required">*</span></label> <input
				type="text" readonly="readonly"
				value="<%=persona.getTelefonoPersona()%>"> <label
				for="direccion">Dirección: <span class="required">*</span></label> <input
				type="text" readonly="readonly"
				value="<%=persona.getDireccionPersona()%>"> <label
				for="correo">Correo: <span class="required">*</span></label> <input
				type="text" readonly="readonly"
				value="<%=persona.getCorreoPersona()%>">
			<%
				if (tipoPersona == 1) {
			%>
			<input
				onclick="window.location.href='editarPerfil.jsp?cedulaPersona=<%=persona.getCedulaPersona()%>'"
				type="button" value="Editar">
			<%
				}
			%>
		</div>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />