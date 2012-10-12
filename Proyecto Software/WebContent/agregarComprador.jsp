
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
<section id="agregarComprador">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="agregarComprador">
		<%
			}
		%>
		<h1>Información Cliente</h1>
		<%
			if (request.getParameter("error") != null) {
				int numeroError = Integer.parseInt(request
						.getParameter("error"));
				if (numeroError == 1) {
		%>
		<h2>La informacion no se a almacenado porque la cedula ya ha sido
			ingresada.</h2>
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
			<form method="post" action="guardarComprador.jsp">
				<script type="text/javascript">
				var peticion = false;
				var testPasado = false;
				try {
					peticion = new XMLHttpRequest();
				} catch (trymicrosoft) {
					try {
						peticion = new ActiveXObject("Msxml2.XMLHTTP");
					} catch (othermicrosoft) {
						try {
							peticion = new ActiveXObject("Microsoft.XMLHTTP");
						} catch (failed) {
							peticion = false;
						}
					}
				}

				if (!peticion)
					alert("ERROR AL INICIALIZAR!");
				function cargarCampos(url, comboAnterior, element_id) {
					var element = document.getElementById(element_id);
					var valordepende = document.getElementById(comboAnterior);
					var x = valordepende.value;
					var fragment_url = url + '?tipoPersona=' + x;
					peticion.open("GET", fragment_url);
					peticion.onreadystatechange = function() {
						if (peticion.readyState == 4) {
							element.innerHTML = peticion.responseText;
						}
					}
					peticion.send(null);
				}
			</script>
				<label for="tipoPersona">Tipo persona: <span
					class="required">*</span></label> <select name="tipoPersona"
					id="tipoPersona"
					onchange="javascript:cargarCampos('camposNueva.jsp', 'tipoPersona', 'informacionPersona')">
					<option></option>
					<option value="1">Persona natural</option>
					<option value="2">Persona juridica</option>
				</select>

				<table id="informacionPersona">
					<tbody>
						<jsp:include page="camposNueva.jsp"></jsp:include>
					</tbody>
				</table>

				<label for="telefono">Teléfono: <span class="required">*</span></label>
				<input type="text" name="telefonoPersona" required="required">

				<label for="direccion">Dirección: <span class="required">*</span></label>
				<input type="text" name="direccionPersona"> <label
					for="correo">Correo: <span class="required">*</span></label> <input
					type="email" name="correoPersona"> <input type="submit"
					name="guardar" value="Guardar"> <input
					onclick="window.location.href='editarVenta.jsp'" type="button"
					value="Atras">
			</form>
		</div>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />