<%@page import="com.persistencia.AdministradorMarca"%>
<%@page import="com.logica.Marca"%>
<%@page import="java.util.List"%>
<%@page import="com.persistencia.SessionDB"%>
<%
	SessionDB.init();
	List<Marca> listaMarcas = AdministradorMarca.getListaMarcas();
	Marca marca = null;
	int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
			.toString());
	if (tipoMenu == 1) {
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<section id="agregarModelo">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="agregarModelo">
		<%
			}
		%>
		<h1>Información Modelo</h1>
		<%
			if (request.getParameter("error") != null) {
				int numeroError = Integer.parseInt(request
						.getParameter("error"));
				if (numeroError == 1) {
		%>
		<h2>La informacion no se a almacenado porque el modelo ya ha sido
			ingresado.</h2>
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
			<form method="post" action="guardarModelo.jsp">
				<label for="marca">Marca: <span class="required">*</span></label> <select
					name="marcaCarro" id="marcaCarro">
					<%
						for (int i = 0; i < listaMarcas.size(); i++) {
							marca = listaMarcas.get(i);
					%>
					<option value="<%=marca.getIdMarca()%>"><%=marca.getNombreMarca()%></option>
					<%
						}
					%>
				</select> <label for="nombreModelo">Nombre modelo: <span
					class="required">*</span></label> <input type="text" name="nombreModelo"
					required="required"> <input type="submit" name="guardar"
					value="Guardar"> <input
					onclick="window.location.href='editarAutomovil.jsp'" type="button"
					value="Atras">
			</form>
		</div>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />