package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logica.Carro;
import com.logica.Persona;
import com.logica.Venta;
import com.persistencia.AdministradorCarro;
import com.persistencia.AdministradorPersona;
import com.persistencia.AdministradorVenta;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class GuardarVenta
 */
@WebServlet("/guardarVenta.jsp")
public class GuardarVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarVenta() {
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		String accion = request.getParameter("accion");
		String placaCarro = request.getParameter("placaCarro");
		String cedulaComprador = request.getParameter("cedulaComprador");
		String fechaVenta = request.getParameter("fechaVenta");
		if(accion.equals("guardar")){
			String cedulaVendedor = request.getParameter("cedulaVendedor");
			guardarVenta(placaCarro, cedulaComprador, cedulaVendedor, fechaVenta);
			response.sendRedirect("venta.jsp?aviso=1");
		}else if(accion.equals("editarSin")){
			int idVenta = Integer.parseInt(request.getParameter("idVenta"));
			editarVenta2(placaCarro, cedulaComprador, idVenta, fechaVenta);
			response.sendRedirect("venta.jsp?aviso=2");
		}else{
			int idVenta = Integer.parseInt(request.getParameter("idVenta"));
			editarVenta(placaCarro, cedulaComprador, idVenta, fechaVenta);
			response.sendRedirect("venta.jsp?aviso=2");
		}
		SessionDB.close();
	}
	
	public void guardarVenta(String placaCarro, String cedulaComprador, String cedulaVendedor, String fecha){
		Persona idClienteVenta = AdministradorPersona.getPersona(cedulaComprador);
		Persona idVendedorVenta = AdministradorPersona.getPersona(cedulaVendedor);
		Carro idCarroVenta = AdministradorCarro.getCarro(placaCarro);
		idCarroVenta.setEstadoCarro(2);
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaVenta = null;
		try {
              fechaVenta = formatoDelTexto.parse(fecha);
       } catch (java.text.ParseException e) {
              e.printStackTrace();
       }
		idCarroVenta.setFechaVentaCarro(fechaVenta);
		AdministradorCarro.guardarCarro(idCarroVenta);
		Venta venta = new Venta(fechaVenta, idClienteVenta, idVendedorVenta, idCarroVenta);
		AdministradorVenta.guardarVenta(venta);
		SessionDB.commit();
	}
	
	public void editarVenta(String placaCarro, String cedulaComprador, int idVenta, String fecha){
		Venta venta = AdministradorVenta.getVenta(idVenta);
		venta.getIdCarroVenta().setEstadoCarro(1);
		venta.getIdCarroVenta().setFechaVentaCarro(null);
		AdministradorCarro.guardarCarro(venta.getIdCarroVenta());
		Persona idClienteVenta = AdministradorPersona.getPersona(cedulaComprador);
		Carro idCarroVenta = AdministradorCarro.getCarro(placaCarro);
		idCarroVenta.setEstadoCarro(2);
		AdministradorCarro.guardarCarro(idCarroVenta);
		venta.setIdCarroVenta(idCarroVenta);
		venta.setIdClienteVenta(idClienteVenta);
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat( "yyyy-MM-dd" );
		Date fechaVenta = null;
		try {
              fechaVenta = formatoDelTexto.parse(fecha);
       } catch (java.text.ParseException e) {
              e.printStackTrace();
       }
		venta.setFechaVenta(fechaVenta);
		AdministradorVenta.guardarVenta(venta);
		SessionDB.commit();
	}
	
	public void editarVenta2(String placaCarro, String cedulaComprador, int idVenta, String fecha){
		Venta venta = AdministradorVenta.getVenta(idVenta);
		Persona idClienteVenta = AdministradorPersona.getPersona(cedulaComprador);
		venta.setIdClienteVenta(idClienteVenta);
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaVenta = null;
		try {
              fechaVenta = formatoDelTexto.parse(fecha);
       } catch (java.text.ParseException e) {
              e.printStackTrace();
       }
		venta.setFechaVenta(fechaVenta);
		AdministradorVenta.guardarVenta(venta);
		SessionDB.commit();
	}	
}
