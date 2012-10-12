package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logica.Imagen;
import com.persistencia.AdministradorImagen;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class EliminarImagen
 */
@WebServlet("/eliminarImagen.jsp")
public class EliminarImagen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarImagen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		int idImagen = Integer.parseInt(request.getParameter("idImagen"));
		Imagen imagen = AdministradorImagen.getImagen(idImagen);
		AdministradorImagen.borrarImagen(imagen);
		SessionDB.commit();
		response.sendRedirect("editarAutomovil.jsp?placaCarro=" + request.getParameter("placaCarro"));
		SessionDB.close();
	}

}
