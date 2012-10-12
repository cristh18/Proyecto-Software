package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.logica.Carro;
import com.logica.Color;
import com.logica.Combustible;
import com.logica.Direccion;
import com.logica.Imagen;
import com.logica.Modelo;
import com.logica.Persona;
import com.logica.TipoCarro;
import com.logica.Transmision;
import com.logica.Vidrio;
import com.persistencia.AdministradorCarro;
import com.persistencia.AdministradorColor;
import com.persistencia.AdministradorCombustible;
import com.persistencia.AdministradorDireccion;
import com.persistencia.AdministradorImagen;
import com.persistencia.AdministradorModelo;
import com.persistencia.AdministradorPersona;
import com.persistencia.AdministradorTransmision;
import com.persistencia.AdministradorVidrio;
import com.persistencia.SessionDB;

/**
 * Servlet implementation class GuardarCarro
 */
@WebServlet("/guardarCarro.jsp")
public class GuardarCarro extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ArrayList<byte[]> listaImagenes;
	private HashMap<String,String> parametros;

	public GuardarCarro() {
		parametros = new HashMap<>();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionDB.init();
		leerDatos(request);
		String accion = parametros.get("accion");
		String placaCarro = parametros.get("placacarro");
		System.out.println(parametros);
		Modelo idModeloCarro = AdministradorModelo.getModelo(Integer.parseInt(parametros.get("modelocarro")));
		Color idColorCarro = AdministradorColor.getColor(Integer.parseInt(parametros.get("colorcarro")));
		Vidrio idVidrioCarro = AdministradorVidrio.getVidrio(Integer.parseInt(parametros.get("vidriocarro")));
		Combustible idCombustibleCarro = AdministradorCombustible.getCombustible(Integer.parseInt(parametros.get("combustiblecarro")));
		Direccion idDireccionCarro = AdministradorDireccion.getDireccion(Integer.parseInt(parametros.get("direccioncarro")));
		Transmision idTransmisionCarro = AdministradorTransmision.getTransmision(Integer.parseInt(parametros.get("transmisioncarro")));
		TipoCarro idTipoCarroCarro = null;
		int cilindrajeCarro = Integer.parseInt(parametros.get("cilindrajecarro"));
		int anioCarro = Integer.parseInt(parametros.get("aniocarro"));
		int precioCarro = Integer.parseInt(parametros.get("preciocarro"));
		Persona idPropietarioPersona = AdministradorPersona.getPersona(parametros.get("propietariocarro"));
		String ingresoCarro = parametros.get("ingresocarro");
		System.out.println(ingresoCarro);
		if(accion.equals("guardar")){
			guardarCarro(placaCarro, cilindrajeCarro, anioCarro, precioCarro, idPropietarioPersona, idColorCarro, idVidrioCarro, idCombustibleCarro, idDireccionCarro, idTransmisionCarro, idTipoCarroCarro, idModeloCarro, response, ingresoCarro);
		}else{
			editarCarro(placaCarro, cilindrajeCarro, anioCarro, precioCarro, idPropietarioPersona, idColorCarro, idVidrioCarro, idCombustibleCarro, idDireccionCarro, idTransmisionCarro, idTipoCarroCarro, idModeloCarro, response, ingresoCarro);
		}
		SessionDB.close();
	}

	public void borrarFotos(int codigoCarro){
		List<Imagen> lista = AdministradorImagen.getListaImagenes(codigoCarro);
		Imagen imagen = null;
		for (int i = 0; i < lista.size(); i++) {
			imagen = lista.get(i);
			AdministradorImagen.borrarImagen(imagen);
		}
	}

	@SuppressWarnings("rawtypes")
	public void leerDatos(HttpServletRequest request){
		listaImagenes = new ArrayList<>();
		FileItemFactory file_factory = new DiskFileItemFactory();
		ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
		List items = null;
		try {
			items = servlet_up.parseRequest(request);
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		byte[]imagen = null;
		FileItem item = null;
		for(int i=0;i<items.size();i++){
			item = (FileItem) items.get(i);
			String valor="";
			if (item.isFormField()){
				valor = item.getString();
				parametros.put(item.getFieldName().toLowerCase(),valor);
			}else{
				imagen = item.get();
				System.out.println(imagen.length);
				if(imagen.length > 0){
					listaImagenes.add(imagen);
				}
			}
		}
	}

	public void guardarImagen(Carro idCarroImagen){
		Imagen imagen = null;
		for (int i = 0; i < listaImagenes.size(); i++) {
			imagen = new Imagen(listaImagenes.get(i), idCarroImagen);
			AdministradorImagen.guardarImagen(imagen);
		}
		SessionDB.commit();
	}

	public void guardarCarro(String placaCarro, int cilindrajeCarro, int anioCarro,
			int precioCarro, Persona idPropietarioPersona, Color idColorCarro, 
			Vidrio idVidrioCarro, Combustible idCombustibleCarro,
			Direccion idDireccionCarro, Transmision idTransmisionCarro, 
			TipoCarro idTipoCarroCarro, Modelo idModeloCarro, HttpServletResponse response, String ingresoCarro) throws ServletException, IOException{
		if(validarPlaca(placaCarro)){
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaIngresoCarro = null;
			try {
	              fechaIngresoCarro = formatoDelTexto.parse(ingresoCarro);
	       } catch (java.text.ParseException e) {
	              e.printStackTrace();
	       }
			Carro carro = new Carro(placaCarro, cilindrajeCarro, anioCarro, precioCarro, idPropietarioPersona, idColorCarro, idVidrioCarro, idCombustibleCarro, idDireccionCarro, idTransmisionCarro, idTipoCarroCarro, idModeloCarro, 1, fechaIngresoCarro);
			AdministradorCarro.guardarCarro(carro);
			if(listaImagenes.size()>0){
				guardarImagen(carro);
			}else{
				SessionDB.commit();
			}
			response.sendRedirect("automovil.jsp?aviso=1");
		}else{
			response.sendRedirect("editarAutomovil.jsp?error=1");
		}
	}

	public void editarCarro(String placaCarro, int cilindrajeCarro, int anioCarro,
			int precioCarro, Persona idPropietarioPersona, Color idColorCarro, 
			Vidrio idVidrioCarro, Combustible idCombustibleCarro,
			Direccion idDireccionCarro, Transmision idTransmisionCarro, 
			TipoCarro idTipoCarroCarro, Modelo idModeloCarro, HttpServletResponse response, String ingresoCarro) throws ServletException, IOException{
		Carro carro = AdministradorCarro.getCarro(placaCarro);
		carro.setIdModeloCarro(idModeloCarro);
		carro.setIdColorCarro(idColorCarro);
		carro.setIdVidrioCarro(idVidrioCarro);
		carro.setIdCombustibleCarro(idCombustibleCarro);
		carro.setIdDireccionCarro(idDireccionCarro);
		carro.setIdTransmisionCarro(idTransmisionCarro);
		carro.setCilindrajeCarro(cilindrajeCarro);
		carro.setAnioCarro(anioCarro);
		carro.setPrecioCarro(precioCarro);
		carro.setIdPropietarioPersona(idPropietarioPersona);
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaIngresoCarro = null;
		try {
              fechaIngresoCarro = formatoDelTexto.parse(ingresoCarro);
       } catch (java.text.ParseException e) {
              e.printStackTrace();
       }
		carro.setFechaIngresoCarro(fechaIngresoCarro);
		AdministradorCarro.guardarCarro(carro);
		if(listaImagenes.size()>0){
			borrarFotos(carro.getCodigoCarro());
			guardarImagen(carro);
		}else{
			SessionDB.commit();
		}

		response.sendRedirect("automovil.jsp?aviso=3");
	}

	public boolean validarPlaca(String placaCarro){
		boolean retorno = false;
		Carro carro = AdministradorCarro.getCarro(placaCarro);
		if(carro == null){
			retorno = true;
		}else{
			if(carro.getEstadoCarro() == 2){
				retorno = true;
			}
		}
		return retorno;
	}
}