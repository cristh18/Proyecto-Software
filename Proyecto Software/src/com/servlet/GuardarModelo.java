package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logica.Marca;
import com.logica.Modelo;
import com.persistencia.AdministradorMarca;
import com.persistencia.AdministradorModelo;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class GuardarModelo
 */
@WebServlet("/guardarModelo.jsp")
public class GuardarModelo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarModelo() {
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		Marca idMarcaModelo = AdministradorMarca.getMarca(Integer.parseInt(request.getParameter("marcaCarro")));
		String nombreModelo = request.getParameter("nombreModelo");
		if(validarModelo(nombreModelo)){
			Modelo modelo = new Modelo(nombreModelo, idMarcaModelo);
			AdministradorModelo.guardarModelo(modelo);
			SessionDB.commit();
			response.sendRedirect("editarAutomovil.jsp");			
		}else{
			response.sendRedirect("agregarModelo.jsp?error=1");
		}
		SessionDB.close();
	}
	
	public boolean validarModelo(String nombreModelo){
		boolean retorno = false;
		Modelo modelo = AdministradorModelo.getModeloNombre(nombreModelo);
		if(modelo == null){
			retorno = true;
		}
		return retorno;
	}

}
