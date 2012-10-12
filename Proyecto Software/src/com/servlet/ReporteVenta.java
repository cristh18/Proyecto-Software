package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logica.GenerarReporteVenta;
import com.logica.Venta;
import com.persistencia.AdministradorVenta;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class ReporteVenta
 */
@WebServlet("/reporteVenta.jsp")
public class ReporteVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteVenta() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		Venta venta = AdministradorVenta.getVenta(Integer.parseInt(request.getParameter("idVenta")));
		GenerarReporteVenta reporteador = new GenerarReporteVenta();
		response.setContentType("application/pdf");
		ServletOutputStream ouputStream = response.getOutputStream();
		reporteador.generarReporteCarro(venta, ouputStream);
		SessionDB.close();
	}
}
