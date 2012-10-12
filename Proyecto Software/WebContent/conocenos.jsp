<%@page import="com.persistencia.AdministradorEmpresa"%>
<%@page import="com.logica.Empresa"%>
<%@page import="com.persistencia.SessionDB"%>
<%
	SessionDB.init();
	Empresa empresa = AdministradorEmpresa.getEmpresa(1);
%>
<jsp:include page="encabezadoGeneral.jsp" />
<section id="conocenos">
	<h1>Informacion empresa.</h1>
	<section id="tablasInformacion">
		<table>
			<tbody>
				<tr>
					<th>NIT</th>
					<td><input type="text" readonly="readonly"
						value="<%=empresa.getNitEmpresa()%>"></td>
				</tr>
				<tr>
					<th>Razón social</th>
					<td><input type="text" readonly="readonly"
						value="<%=empresa.getRazonSocialEmpresa()%>"></td>
				</tr>
				<tr>
					<th>Mision</th>
					<td><textarea name="mision" readonly="readonly"><%=empresa.getMisionEmpresa()%></textarea></td>
				</tr>
				<tr>
					<th>Vision</th>
					<td><textarea name="mision" readonly="readonly"><%=empresa.getVisionEmpresa()%></textarea></td>
				</tr>
			</tbody>
		</table>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />