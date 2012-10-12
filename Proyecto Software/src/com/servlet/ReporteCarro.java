package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logica.Carro;
import com.logica.GenerarReporteCarro;
import com.persistencia.AdministradorCarro;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class ReporteCarro
 */
@WebServlet("/reporteCarro.jsp")
public class ReporteCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteCarro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		GenerarReporteCarro reporteador = new GenerarReporteCarro();
		Carro carro = AdministradorCarro.getCarro(Integer.parseInt(request.getParameter("placaCarro")));
		response.setContentType("application/pdf");
		ServletOutputStream ouputStream = response.getOutputStream();
		reporteador.generarReporteCarro(carro, ouputStream);
		SessionDB.close();
	}
}
