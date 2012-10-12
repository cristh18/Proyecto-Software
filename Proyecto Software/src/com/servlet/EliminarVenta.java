package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logica.Venta;
import com.persistencia.AdministradorCarro;
import com.persistencia.AdministradorVenta;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class EliminarVenta
 */
@WebServlet("/eliminarVenta.jsp")
public class EliminarVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarVenta() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		Venta venta = AdministradorVenta.getVenta(Integer.parseInt(request.getParameter("idVenta")));
		venta.getIdCarroVenta().setEstadoCarro(1);
		venta.getIdCarroVenta().setFechaVentaCarro(null);
		AdministradorCarro.guardarCarro(venta.getIdCarroVenta());
		AdministradorVenta.eliminarVenta(venta);
		SessionDB.commit();
		response.sendRedirect("venta.jsp");
		SessionDB.close();
	}
}
