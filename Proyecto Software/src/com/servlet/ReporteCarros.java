package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logica.Carro;
import com.logica.GenerarReporteCarros;
import com.persistencia.AdministradorCarro;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class ReporteCarros
 */
@WebServlet("/reporteCarros.jsp")
public class ReporteCarros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenerarReporteCarros reporteador = new GenerarReporteCarros();
		SessionDB.init();
		List<Carro> lcarro= null;
		int estado = Integer.parseInt(request.getParameter("estado"));
		if(estado == 1){
			lcarro = AdministradorCarro.getListaCarroVendidos();
		}else if(estado == 2){
			lcarro = AdministradorCarro.getListaCarro();
		}else if(estado == 3){
			lcarro = AdministradorCarro.getListaCarrosTodos();
		}
		response.setContentType("application/pdf");
		ServletOutputStream ouputStream = response.getOutputStream();
		reporteador.generarReporteCarros(lcarro, ouputStream);
		SessionDB.close();
	}
}
