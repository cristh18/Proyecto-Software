package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logica.Persona;
import com.persistencia.AdministradorPersona;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class GuardarPersona
 */
@WebServlet("/guardarPersona.jsp")
public class GuardarPersona extends HttpServlet {

	private static final long serialVersionUID = 8507658904330081269L;
	private boolean personaEditable;
	public GuardarPersona() {
		personaEditable = false;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		int tipoPersona = 0;
		String accion = request.getParameter("accion");
		if(accion.equals("guardar")){
			tipoPersona = Integer.parseInt(request.getParameter("tipoPersona"));
			guardarPersona(request, response, tipoPersona);
		}else if(accion.equals("editarPerfil")){
			editarPersona(request, response, tipoPersona);
			response.sendRedirect("informacionPerfil.jsp?aviso=1");
		}else{
			tipoPersona = Integer.parseInt(request.getParameter("tipoPersona"));
			editarPersona(request, response, tipoPersona);
			response.sendRedirect("persona.jsp?tipoPersona=" + tipoPersona  + "&aviso=3");
		}
		SessionDB.close();
	}

	public void editarPersona(HttpServletRequest request, HttpServletResponse response, int tipoPersona) throws IOException{
		Persona persona = AdministradorPersona.getPersona(request.getParameter("cedulaPersona"));
		persona.setNombrePersona(request.getParameter("nombrePersona"));
		persona.setApellidoPersona(request.getParameter("apellidoPersona"));
		persona.setTelefonoPersona(request.getParameter("telefonoPersona"));
		persona.setDireccionPersona(request.getParameter("direccionPersona"));
		persona.setCorreoPersona(request.getParameter("correoPersona"));
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaIngresoPersona = null;
		try {
              fechaIngresoPersona = formatoDelTexto.parse(request.getParameter("fechaIngresoPersona"));
       } catch (java.text.ParseException e) {
              e.printStackTrace();
       }
		persona.setFechaIngresoPersona(fechaIngresoPersona);
		if(persona.getEstadoPersona() == 2){
			Date fechaCancelacionPersona = null;
			try {
	              fechaCancelacionPersona = formatoDelTexto.parse(request.getParameter("fechaCancelacionPersona"));
	       } catch (java.text.ParseException e) {
	              e.printStackTrace();
	       }	
			persona.setFechaCancelacionPersona(fechaCancelacionPersona);
		}
		persona.setSalarioPersona(Integer.parseInt(request.getParameter("salarioPersona")));
		AdministradorPersona.guardarPersona(persona);
		SessionDB.commit();
	}

	public void guardarPersona(HttpServletRequest request, HttpServletResponse response, int tipoPersona) throws IOException{
		String cedulaPersona = request.getParameter("cedulaPersona");
		if(validarCedula(cedulaPersona)){
			validacionesGuardar(request, cedulaPersona, tipoPersona, response);
		}else if(personaEditable){
			validacionesHabilitar(request, cedulaPersona, tipoPersona, response);
		}else{
			response.sendRedirect("editarPersona.jsp?tipoPersona=" + tipoPersona + "&error=1");			
		}	
	}

	public void validacionesGuardar(HttpServletRequest request, String cedulaPersona, int tipoPersona, HttpServletResponse response) throws IOException{
		String contraseniaPersona1 = request.getParameter("contraseniaPersona1");
		String contraseniaPersona2 = request.getParameter("contraseniaPersona2");
		if(validarContrasenia(contraseniaPersona1, contraseniaPersona2)){
			AdministradorPersona.guardarPersona(crearPersona(request, cedulaPersona, tipoPersona));
			SessionDB.commit();
			response.sendRedirect("persona.jsp?tipoPersona=" + tipoPersona + "&aviso=1");
		}else{
			response.sendRedirect("editarPersona.jsp?tipoPersona=" + tipoPersona + "&error=2");
		}
	}

	public void validacionesHabilitar(HttpServletRequest request, String cedulaPersona, int tipoPersona, HttpServletResponse response) throws IOException{
			String contraseniaPersona1 = request.getParameter("contraseniaPersona1");
			String contraseniaPersona2 = request.getParameter("contraseniaPersona2");
			if(validarContrasenia(contraseniaPersona1, contraseniaPersona2)){
				habilitarPersona(request, cedulaPersona, tipoPersona);
				response.sendRedirect("persona.jsp?tipoPersona=" + tipoPersona + "&aviso=1");
			}else{
				response.sendRedirect("editarPersona.jsp?tipoPersona=" + tipoPersona + "&error=2");
			}
	}	

	public Persona crearPersona(HttpServletRequest request, String cedulaPersona, int tipoPersona){
		Persona persona = null;
		String nombrePersona = request.getParameter("nombrePersona");
		String apellidoPersona = request.getParameter("apellidoPersona");
		String telefonoPersona = request.getParameter("telefonoPersona");
		String direccionPersona = request.getParameter("direccionPersona");
		String correoPersona = request.getParameter("correoPersona");
		String contraseniaPersona = request.getParameter("contraseniaPersona1");
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaIngresoPersona = null;
		try {
              fechaIngresoPersona = formatoDelTexto.parse(request.getParameter("fechaIngresoPersona"));
       } catch (java.text.ParseException e) {
              e.printStackTrace();
       }
		int salarioPersona = Integer.parseInt(request.getParameter("salarioPersona"));
		persona = new Persona(cedulaPersona, nombrePersona, apellidoPersona, telefonoPersona, direccionPersona, correoPersona, tipoPersona, contraseniaPersona, 1, 0, fechaIngresoPersona, salarioPersona);
		return persona;
	}

	public Persona habilitarPersona(HttpServletRequest request, String cedulaPersona, int tipoPersona){
		Persona persona = AdministradorPersona.getPersona(request.getParameter("cedulaPersona"));
		persona.setNombrePersona(request.getParameter("nombrePersona"));
		persona.setTipoPersona(tipoPersona);
		persona.setApellidoPersona(request.getParameter("apellidoPersona"));
		persona.setTelefonoPersona(request.getParameter("telefonoPersona"));
		persona.setDireccionPersona(request.getParameter("direccionPersona"));
		persona.setCorreoPersona(request.getParameter("correoPersona"));
		persona.setEstadoPersona(1);
		if(tipoPersona != 3){
			persona.setContraseniaPersona(request.getParameter("contraseniaPersona1"));
		}
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaIngresoPersona = null;
		try {
              fechaIngresoPersona = formatoDelTexto.parse(request.getParameter("fechaIngresoPersona"));
       } catch (java.text.ParseException e) {
              e.printStackTrace();
       }
		persona.setFechaIngresoPersona(fechaIngresoPersona);
		persona.setFechaCancelacionPersona(null);
		persona.setSalarioPersona(Integer.parseInt(request.getParameter("salarioPersona")));
		AdministradorPersona.guardarPersona(persona);
		SessionDB.commit();
		return persona;
	}

	public boolean validarContrasenia(String contrasenia1, String contrasenia2){
		boolean retorno = false;
		if(contrasenia1.equals(contrasenia2)){
			retorno = true;
		}
		return retorno;
	}

	public boolean validarCedula(String cedulaPersona){
		boolean retorno = false;
		personaEditable = false;
		Persona persona = AdministradorPersona.getPersona(cedulaPersona);
		if(persona == null){
			retorno = true;
		}else if(persona.getEstadoPersona() == 2){
			personaEditable = true;
		}
		return retorno;
	}
}