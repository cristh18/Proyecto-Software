package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logica.Persona;
import com.persistencia.AdministradorPersona;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class EliminarPersona
 */
@WebServlet("/eliminarPersona.jsp")
public class EliminarPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		String cedulaPersona = request.getParameter("cedulaPersona");
		String tipoPersona = request.getParameter("tipoPersona");
		Persona persona = AdministradorPersona.getPersona(cedulaPersona);
		Date fechaCancelacionPersona = new Date();
		if(persona != null){			
			persona.setEstadoPersona(2);
			persona.setTipoCliente(0);
			persona.setFechaCancelacionPersona(fechaCancelacionPersona);
			AdministradorPersona.guardarPersona(persona);
			SessionDB.commit();
			response.sendRedirect("persona.jsp?tipoPersona=" + tipoPersona + "&aviso=2");
		}
		SessionDB.close();
	}

}
