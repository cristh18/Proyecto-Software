package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logica.Carro;
import com.persistencia.AdministradorCarro;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class EliminarCarro
 */
@WebServlet("/eliminarCarro.jsp")
public class EliminarCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarCarro() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		String placaCarro = request.getParameter("placaCarro");
		Carro carro = AdministradorCarro.getCarro(placaCarro);
		if(carro != null){			
			carro.setEstadoCarro(2);
			AdministradorCarro.guardarCarro(carro);
			SessionDB.commit();
			response.sendRedirect("automovil.jsp?aviso=2");
		}
		SessionDB.close();
	}
}
