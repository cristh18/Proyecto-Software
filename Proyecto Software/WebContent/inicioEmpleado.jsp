
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
<%
	} else if (tipoMenu == 2) {
%>
<jsp:include page="encabezadoVendedor.jsp" />
<%
	}
%>
<jsp:include page="pieDePagina.jsp" />