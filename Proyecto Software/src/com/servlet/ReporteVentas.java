package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logica.GenerarReporteVentas;
import com.logica.Venta;
import com.persistencia.AdministradorVenta;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class ReporteVentas
 */
@WebServlet("/reporteVentas.jsp")
public class ReporteVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReporteVentas() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		List<Venta> listaVentas = null;
		if (request.getParameter("fechaInicial") != null
				&& request.getParameter("fechaFinal") != null) {
			listaVentas = AdministradorVenta.getListaVentasFechas(
					request.getParameter("fechaInicial"),
					request.getParameter("fechaFinal"));
		} else if (request.getParameter("cedulaVendedor") != null) {
			listaVentas = AdministradorVenta
					.getListaVentasVendedor(request
							.getParameter("cedulaVendedor"));
		} else {

			listaVentas = AdministradorVenta.getListaVentas();
		}
		GenerarReporteVentas reporteador = new GenerarReporteVentas();
		response.setContentType("application/pdf");
		ServletOutputStream ouputStream = response.getOutputStream();
		reporteador.generarReporteCarros(listaVentas, ouputStream);
		SessionDB.close();
	}
}
