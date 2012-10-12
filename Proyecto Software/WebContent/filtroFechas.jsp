
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
<section id="filtroFechas">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="filtroFechas">
		<%
			}
		%>
		<h1>Consultar ventas por periodo de tiempo.</h1>

		<div id="contact-form" class="clearfix">
			<ul id="errors" class="">
				<li id="info">There were some problems with your form
					submission:</li>
			</ul>
			<p id="success">Thanks for your message! We will get back to you
				ASAP!</p>


			<form action="venta.jsp" method="get">
				<label for="fechaInicial">Fecha inicial: <span
					class="required">*</span></label> <input type="date" name="fechaInicial"
					required="required"> <label for="fechaFinal">Fecha
					final: <span class="required">*</span>
				</label> <input type="date" name="fechaFinal" required="required"> <input
					type="submit" name="consultar" value="Consultar">
			</form>
		</div>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />