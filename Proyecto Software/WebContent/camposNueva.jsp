
<%
	if (request.getParameter("tipoPersona") != null) {
		String id_calificador = request.getParameter("tipoPersona")
				.toString();
		if(id_calificador.equals("1")){
%>
<label for="nombre">Nombre: <span class="required">*</span></label>
<input type="text" name="nombrePersona" required="required">

<label for="apellido">Apellido: <span class="required">*</span></label>
<input type="text" name="apellidoPersona" required="required">

<label for="cedula">Cédula: <span class="required">*</span></label>
<input type="number" name="cedulaPersona" required="required">
<%
		}else{
			%>
<label for="razonSocial">Razón social: <span class="required">*</span></label>
<input type="text" name="nombrePersona" required="required">

<input type="hidden" name="apellidoPersona" value="">

<label for="nit">NIT: <span class="required">*</span></label>
<input type="text" name="cedulaPersona" required="required">
<%
		}
	}
%>
