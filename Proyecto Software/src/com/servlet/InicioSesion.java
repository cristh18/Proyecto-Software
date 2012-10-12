package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logica.Persona;
import com.persistencia.AdministradorPersona;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class InicioSesion
 */
@WebServlet("/inicioSesion.jsp")
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InicioSesion() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		String cedulaPersona = request.getParameter("cedulaPersona");
		String contraseniaPersona = request.getParameter("contraseniaPersona");
		Persona persona = AdministradorPersona.getPersona(cedulaPersona);
		if (persona != null ){				
			if(persona.getTipoPersona() != 3){
				if(persona.getEstadoPersona() == 1){					
					if(persona.getContraseniaPersona().equals(contraseniaPersona)){
						HttpSession session = request.getSession(true);
						session.setAttribute("nombrePersona", persona.getNombrePersona());
						session.setAttribute("tipoPersona", persona.getTipoPersona());
						session.setAttribute("tipoMenu", persona.getTipoPersona());
						session.setAttribute("cedulaPersona", persona.getCedulaPersona());
						response.sendRedirect("inicioEmpleado.jsp");
					}else{
						response.sendRedirect("iniciarSesion.jsp?error=2");
					}	
				}else{
					response.sendRedirect("iniciarSesion.jsp?error=1");
				}
			}else{
				response.sendRedirect("iniciarSesion.jsp?error=1");
			}
		} else {
			response.sendRedirect("iniciarSesion.jsp?error=1");
		}
		SessionDB.close();
	}

}
