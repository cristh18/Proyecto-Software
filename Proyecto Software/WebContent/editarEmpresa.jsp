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
<section id="editarEmpresa">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="editarEmpresa">
		<%
			}
		%>
		<h1>Informacion empresa.</h1>
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
		<form method="post" action="guardarEmpresa.jsp">
			<table>
				<tbody>
					<tr>
						<td>NIT</td>
						<td><input name="nit" type="text"
							value="<%=empresa.getNitEmpresa()%>"></td>
					</tr>
					<tr>
						<td>Razon social</td>
						<td><input name="razonSocial" type="text"
							value="<%=empresa.getRazonSocialEmpresa()%>"></td>
					</tr>
					<tr>
						<td>Mision</td>
						<td><textarea name="mision"><%=empresa.getMisionEmpresa()%></textarea></td>
					</tr>
					<tr>
						<td>Vision</td>
						<td><textarea name="vision"><%=empresa.getVisionEmpresa()%></textarea></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" name="guardar" value="Guardar"> <input
				type="hidden" name="accion" value="editarPerfil">
		</form>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />