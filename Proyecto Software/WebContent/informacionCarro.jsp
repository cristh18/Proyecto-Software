<%@page import="com.persistencia.AdministradorCarro"%>
<%@page import="com.logica.Carro"%>
<%@page import="com.persistencia.SessionDB"%>
<%
Carro carro = null;
	if (request.getParameter("placaCarro") != null) {
		String id_calificador = request.getParameter("placaCarro")
				.toString();
		if (!id_calificador.isEmpty()) {
			SessionDB.init();
			carro = AdministradorCarro.getCarro(request
					.getParameter("placaCarro"));
		}
%>
<input type="text"
	value="<%=carro.getIdModeloCarro().getIdMarcaModelo().getNombreMarca() + " "
						+ carro.getIdModeloCarro().getNombreModelo() + " " + carro.getAnioCarro()%>"
	readonly="readonly">
<%
	}
%>