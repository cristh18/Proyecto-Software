<%@page import="com.persistencia.AdministradorVenta"%>
<%@page import="com.logica.Venta"%>
<%@page import="java.util.List"%>
<%@page import="com.persistencia.SessionDB"%>
<%
	Object nombrePersona = session.getAttribute("nombrePersona");
	if (nombrePersona == null) {
		response.sendRedirect("index.jsp");
	}
	String cedulaPersona = session.getAttribute("cedulaPersona")
			.toString();
	int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
			.toString());
	if (tipoMenu == 1) {
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<section id="cambioClave">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="cambioClave">
		<%
			}
		%>
		<h1>Cambio contraseña</h1>
		<%
			if (request.getParameter("error") != null) {
				int numeroError = Integer.parseInt(request
						.getParameter("error"));
				if (numeroError == 2) {
		%>
		<h2>Las contraseña nuevas son diferentes.</h2>
		<%
			} else if (numeroError == 1) {
		%>
		<h2>La contraseña no corresponde al usuario.</h2>
		<%
			} else if (numeroError == 3) {
		%>
		<h2>La contraseña se ha cambiado exitosamente.</h2>
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
			<form method="post" action="cambiarContrasenia.jsp">

				<label for="contraseniaActual">Contraseña actual: <span
					class="required">*</span></label> <input type="password"
					name="contraseniaActual" value="" required="required"> <label
					for="contraseniaNueva">Contraseña nueva: <span
					class="required">*</span></label> <input type="password"
					name="contraseniaNueva" value="" required="required"> <label
					for="repetirContrasenia">Repetir contraseña nueva: <span
					class="required">*</span></label> <input type="password"
					name="repetirContraseniaNueva" value="" required="required">
				<input type="submit" name="guardar" value="Guardar"> <input type="hidden"
					name="cedulaPersona" value=<%=cedulaPersona%>>
			</form>
		</div>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />