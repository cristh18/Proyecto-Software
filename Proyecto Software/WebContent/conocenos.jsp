<%@page import="com.persistencia.AdministradorEmpresa"%>
<%@page import="com.logica.Empresa"%>
<%@page import="com.persistencia.SessionDB"%>
<%
	SessionDB.init();
	Empresa empresa = AdministradorEmpresa.getEmpresa(1);
%>
<jsp:include page="encabezadoGeneral.jsp" />
<section id="conocenos">
	<h1>Informaci�n empresa.</h1>
	<div id="contact-form" class="clearfix">
		<ul id="errors" class="">
			<li id="info">There were some problems with your form
				submission:</li>
		</ul>
		<p id="success">Thanks for your message! We will get back to you
			ASAP!</p>

		<label for="nit">NIT: </label> 
		<input type="text" readonly="readonly" value="<%=empresa.getNitEmpresa()%>"> 
			
		<label for="razonSocial">Raz�n social: </label>
		<input type="text" readonly="readonly" value="<%=empresa.getRazonSocialEmpresa()%>">

		<label for="mision">Misi�n: </label>
		<textarea name="mision" readonly="readonly"><%=empresa.getMisionEmpresa()%></textarea>
			
		<label for="vision">Visi�n: </label>
		<textarea name="vision" readonly="readonly"><%=empresa.getVisionEmpresa()%></textarea>
		
	</div>
</section>
<jsp:include page="pieDePagina.jsp" />