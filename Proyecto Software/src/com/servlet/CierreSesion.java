package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CierreSesion
 */
@WebServlet("/cierreSesion.jsp")
public class CierreSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CierreSesion() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("nombrePersona");
		session.removeAttribute("tipoPersona");
		session.removeAttribute("tipoMenu");
		session.removeAttribute("cedulaPersona");
		response.sendRedirect("index.jsp");
	}
}
