<%@page import="com.logica.Modelo"%>
<%@page import="java.util.List"%>
<%@page import="com.persistencia.AdministradorModelo"%>
<%@page import="com.persistencia.SessionDB"%>
<select name="modeloCarro" id="modelo">
	<%  
if(request.getParameter("marcaCarro")!=null){
String id_calificador =  request.getParameter("marcaCarro").toString();
	if(!id_calificador.isEmpty()){
		SessionDB.init();
		List<Modelo> listaModelos = AdministradorModelo.getListaModelo(Integer
				.parseInt(request.getParameter("marcaCarro")));
		for (Modelo modelo : listaModelos) {
			out.println("<option value='" + modelo.getIdModelo() + "'>"+modelo.getNombreModelo()+"</option>");
        
		}

SessionDB.close();
	}
}
%>
</select>