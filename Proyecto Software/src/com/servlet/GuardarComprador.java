package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logica.Persona;
import com.persistencia.AdministradorPersona;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class GuardarComprador
 */
@WebServlet("/guardarComprador.jsp")
public class GuardarComprador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean personaEditable;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarComprador() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		String cedulaPersona = request.getParameter("cedulaPersona");
		String nombrePersona = request.getParameter("nombrePersona");
		String apellidoPersona = request.getParameter("apellidoPersona");
		String telefonoPersona = request.getParameter("telefonoPersona");
		String direccionPersona = request.getParameter("direccionPersona");
		String correoPersona = request.getParameter("correoPersona");
		int tipoCliente = Integer.parseInt(request.getParameter("tipoPersona"));
		if(validarCedula(cedulaPersona)){
			Persona persona = new Persona(cedulaPersona, nombrePersona, apellidoPersona, telefonoPersona, direccionPersona, correoPersona, 3, "", 1, tipoCliente, null, 0);
			AdministradorPersona.guardarPersona(persona);
			SessionDB.commit();
			response.sendRedirect("editarVenta.jsp");			
		}else if(personaEditable){
			habilitarPersona(request, cedulaPersona, 3);
			response.sendRedirect("editarVenta.jsp");
		}else{
			response.sendRedirect("agregarComprador.jsp?error=1");
		}	
		SessionDB.close();
	}

	public Persona habilitarPersona(HttpServletRequest request, String cedulaPersona, int tipoPersona){
		Persona persona = AdministradorPersona.getPersona(request.getParameter("cedulaPersona"));
		persona.setNombrePersona(request.getParameter("nombrePersona"));
		persona.setTipoPersona(tipoPersona);
		persona.setApellidoPersona(request.getParameter("apellidoPersona"));
		persona.setTelefonoPersona(request.getParameter("telefonoPersona"));
		persona.setDireccionPersona(request.getParameter("direccionPersona"));
		persona.setCorreoPersona(request.getParameter("correoPersona"));
		persona.setEstadoPersona(1);
		AdministradorPersona.guardarPersona(persona);
		SessionDB.commit();
		return persona;
	}
	
	public boolean validarCedula(String cedulaPersona){
		boolean retorno = false;
		personaEditable = false;
		Persona persona = AdministradorPersona.getPersona(cedulaPersona);
		if(persona == null){
			retorno = true;
		}else if(persona.getEstadoPersona() == 2){
			personaEditable = true;
		}
		return retorno;
	}
}
