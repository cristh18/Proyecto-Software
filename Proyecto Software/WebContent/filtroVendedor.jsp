
<%@page import="com.persistencia.AdministradorPersona"%>
<%@page import="com.logica.Persona"%>
<%@page import="java.util.List"%>
<%@page import="com.persistencia.SessionDB"%>
<%
	Object nombrePersona = session.getAttribute("nombrePersona");
	if (nombrePersona == null) {
		response.sendRedirect("index.jsp");
	}
	SessionDB.init();
	List<Persona> listaVendedores = AdministradorPersona.getListaVendedores();
	Persona persona = null;
	int tipoMenu = Integer.parseInt(session.getAttribute("tipoMenu")
	.toString());
	if (tipoMenu == 1) {
%>
<jsp:include page="encabezadoAdministrador.jsp" />
<section id="filtroVendedor">
	<%
		} else if (tipoMenu == 2) {
	%>
	<jsp:include page="encabezadoVendedor.jsp" />
	<section id="filtroVendedor">
		<%
			}
		%>
		<h1>Consultar fechas por vendedor.</h1>

		<div id="contact-form" class="clearfix">
			<ul id="errors" class="">
				<li id="info">There were some problems with your form
					submission:</li>
			</ul>
			<p id="success">Thanks for your message! We will get back to you
				ASAP!</p>


			<form action="venta.jsp" method="get">
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
								peticion = new ActiveXObject(
										"Microsoft.XMLHTTP");
							} catch (failed) {
								peticion = false;
							}
						}
					}

					if (!peticion)
						alert("ERROR AL INICIALIZAR!");
					function cargarPersona(url, comboAnterior, element_id) {
						var element = document.getElementById(element_id);
						var valordepende = document
								.getElementById(comboAnterior);
						var x = valordepende.value;
						var fragment_url = url + '?cedulaPersona=' + x;
						peticion.open("GET", fragment_url);
						peticion.onreadystatechange = function() {
							if (peticion.readyState == 4) {
								element.innerHTML = peticion.responseText;
							}
						}
						peticion.send(null);
					}
				</script>
				<label for="cedulaVendedor">Cédula vendedor: <span
					class="required">*</span></label> <select name="cedulaVendedor"
					id="cedulaVendedor"
					onchange="javascript:cargarPersona('informacionPersona.jsp', 'cedulaVendedor', 'informacionPersona')">
					<%
										for (int i = 0; i < listaVendedores.size(); i++) {
											persona = listaVendedores.get(i);
									%>
					<option value="<%=persona.getCedulaPersona()%>"><%=persona.getCedulaPersona()%></option>
					<%
										}
									%>
				</select> <label for="nombreVendedor">Nombre vendedor: <span
					class="required">*</span></label>
				<p id="informacionPersona"><jsp:include
						page="informacionPersona.jsp"></jsp:include></p>

				<input type="submit" name="consultar" value="Consultar">
			</form>
		</div>
	</section>
</section>
<jsp:include page="pieDePagina.jsp" />