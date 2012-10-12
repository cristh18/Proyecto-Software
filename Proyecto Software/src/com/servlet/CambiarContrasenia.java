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
 * Servlet implementation class CambiarContrasenia
 */
@WebServlet("/cambiarContrasenia.jsp")
public class CambiarContrasenia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiarContrasenia() {
     
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		String cedulaPersona = request.getParameter("cedulaPersona");
		String contraseniaActual = request.getParameter("contraseniaActual");
		String contraseniaNueva = request.getParameter("contraseniaNueva");
		String repetirContraseniaNueva = request.getParameter("repetirContraseniaNueva");
		Persona persona = AdministradorPersona.getPersona(cedulaPersona);
		if(persona.getContraseniaPersona().equals(contraseniaActual)){
			if(validarContrasenia(contraseniaNueva, repetirContraseniaNueva)){
				persona.setContraseniaPersona(contraseniaNueva);
				AdministradorPersona.guardarPersona(persona);
				SessionDB.commit();
				response.sendRedirect("cambioContrasenia.jsp?error=3");
			}else{
				response.sendRedirect("cambioContrasenia.jsp?error=2");	
			}
		}else{
			response.sendRedirect("cambioContrasenia.jsp?error=1");
		}
		SessionDB.close();
	}
	
	public boolean validarContrasenia(String contrasenia1, String contrasenia2){
		boolean retorno = false;
		if(contrasenia1.equals(contrasenia2)){
			retorno = true;
		}
		return retorno;
	}
}
