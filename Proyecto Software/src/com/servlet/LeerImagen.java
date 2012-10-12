package com.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.persistencia.AdministradorImagen;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class LeerImagen
 */
@WebServlet("/leerImagen.jsp")
public class LeerImagen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LeerImagen() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		int idImagen= Integer.parseInt(request.getParameter("idImagen"));
		//		SessionDB.close();
		byte [] imagen = AdministradorImagen.getImagen(idImagen).getImagen();  
		if (imagen!=null) {		
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			output.write(imagen, 0, imagen.length);
			response.setContentType("image/jpg ");
			OutputStream out = response.getOutputStream();
			output.writeTo(out);
			out.flush();
			out.close();
		}
	}
}