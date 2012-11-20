
<%
	Object nombrePersona = session.getAttribute("nombrePersona");
	if (nombrePersona == null) {
		response.sendRedirect("index.jsp");
	}
	int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
			.toString());
	if (tipoMenu == 1) {
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<h1>Bienvenido Administrador</h1>
<section>
	<img id="imgEmpleado" alt="administrador"
		src="imagenes/administrador.png">
</section>
<%
	} else if (tipoMenu == 2) {
%>
<jsp:include page="encabezadoVendedor.jsp" />
<h1>Bienvenido Vendedor</h1>
<section>
	<img id="imgEmpleado" alt="vendedor" src="imagenes/vendedor.jpg">
</section>
<%
	}
%>
<jsp:include page="pieDePagina.jsp" />