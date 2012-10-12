package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logica.GenerarReportePersona;
import com.logica.Persona;
import com.persistencia.AdministradorPersona;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class ReportePersona
 */
@WebServlet("/reportePersona.jsp")
public class ReportePersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportePersona() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		Persona persona = AdministradorPersona.getPersona(request.getParameter("cedulaPersona"));
		GenerarReportePersona reporteador = new GenerarReportePersona();
		response.setContentType("application/pdf");
		ServletOutputStream ouputStream = response.getOutputStream();
		reporteador.generarReporteCarro(persona, ouputStream);
		SessionDB.close();
	}
}
