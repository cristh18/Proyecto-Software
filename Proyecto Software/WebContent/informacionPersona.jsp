<%@page import="com.persistencia.AdministradorPersona"%>
<%@page import="com.logica.Persona"%>
<%@page import="com.persistencia.SessionDB"%>
<%
	Persona persona = null;
	if (request.getParameter("cedulaPersona") != null) {
		String id_calificador = request.getParameter("cedulaPersona")
				.toString();
		if (!id_calificador.isEmpty()) {
			SessionDB.init();
			persona = AdministradorPersona.getPersona(request
					.getParameter("cedulaPersona"));
		}
%>
<input type="text"
	value="<%=persona.getNombrePersona() + " "
						+ persona.getApellidoPersona()%>"
	readonly="readonly">
<%
	}
%>
