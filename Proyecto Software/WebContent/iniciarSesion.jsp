<jsp:include page="encabezadoGeneral.jsp" />
<section>

	<h1>Iniciar sesi�n</h1>
	<%
			if (request.getParameter("error") != null) {
				int numeroError = Integer.parseInt(request
						.getParameter("error"));
				if (numeroError == 1) {
		%>
	<h2>La c�dula no existe.</h2>
	<%
			} else if (numeroError == 2) {
		%>
	<h2>La contrase�a no corresponde a la c�dula.</h2>
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

		<form method="post" action="inicioSesion.jsp">
			<label for="cedula">C�dula: <span class="required">*</span></label> <input
				type="text" name="cedulaPersona" value="" required="required">

			<label for="contrasenia">Contrase�a: <span class="required">*</span></label>

			<input type="password" name="contraseniaPersona" value=""
				required="required"> <input type="submit"
				name="iniciarSesion" value="Iniciar sesi�n">
		</form>
	</div>

</section>
</body>
</html>
<jsp:include page="pieDePagina.jsp" />