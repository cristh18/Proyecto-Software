<%@page import="com.persistencia.AdministradorEmpresa"%>
<%@page import="com.logica.Empresa"%>
<%@page import="com.persistencia.SessionDB"%>
<%
	Object nombrePersona = session.getAttribute("nombrePersona");
	if (nombrePersona == null) {
		response.sendRedirect("index.jsp");
	}
	SessionDB.init();
	Empresa empresa = AdministradorEmpresa.getEmpresa(1);
	int tipoPersona = Integer.parseInt(session.getAttribute(
			"tipoPersona").toString());
	int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
			.toString());
	if (tipoMenu == 1) {
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<section id="empresa">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="empresa">
		<%
			}
		%>
		<h1>Información empresa</h1>
		<%
			if (request.getParameter("aviso") != null) {
				int numeroMensaje = Integer.parseInt(request
						.getParameter("aviso"));
				if (numeroMensaje == 1) {
		%>
		<h2>Empresa editada correctamente.</h2>
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

			<label for="nit">NIT: <span class="required">*</span></label> <input
				type="text" readonly="readonly" value="<%=empresa.getNitEmpresa()%>">

			<label for="razonSocial">Razón social: <span class="required">*</span></label>
			<input type="text" readonly="readonly"
				value="<%=empresa.getRazonSocialEmpresa()%>"> <label
				for="mision">Misión: <span class="required">*</span></label>
			<textarea name="mision" readonly="readonly"><%=empresa.getMisionEmpresa()%></textarea>

			<label for="vision">Visión: <span class="required">*</span></label>
			<textarea name="mision" readonly="readonly"><%=empresa.getVisionEmpresa()%></textarea>
			<input onclick="window.location.href='editarEmpresa.jsp'"
				type="button" value="Editar">
		</div>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />