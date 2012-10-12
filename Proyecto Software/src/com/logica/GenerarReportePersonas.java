package com.logica;

import java.io.OutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.persistencia.AdministradorEmpresa;
import com.persistencia.SessionDB;

public class GenerarReportePersonas {
	private Document document;
	private PdfWriter instance;
	
	public void generarReporteCarros(List<Persona> listaPersonas, OutputStream ouputStream){
		try {
			SessionDB.init();
			Empresa empresa = AdministradorEmpresa.getEmpresa(1);
			document = new Document(PageSize.LETTER, 20, 10, 20, 10);
			instance = PdfWriter.getInstance(document, ouputStream);
			instance.setInitialLeading(200);
			document.open();
			document.add(configure(empresa.getRazonSocialEmpresa(), 40, Font.NORMAL,	BaseColor.BLUE, Chunk.ALIGN_CENTER));
			document.add(configure("NIT: " + empresa.getNitEmpresa(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			Date date = new Date();
			DateFormat sd = DateFormat.getDateInstance(DateFormat.SHORT);
			document.add(configure("Fecha: " + sd.format(date), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(new Paragraph(" "));
			document.add(configure("Personas", 30, Font.NORMAL,	BaseColor.BLUE, Chunk.ALIGN_CENTER));
			document.add(new Paragraph(" "));
						
			String[] columnName= {"Nombre/Razon Social","Apellido","Cedula/ NIT","Salario","FechaIngreso","FechaSalida", "Estado", "Telefono","Direccion","Correo"};
			dibujarTabla(columnName, getArrayCarros(listaPersonas));

			document.close();

		} catch (DocumentException e) {
			e.printStackTrace();
		}		

	}

	public Paragraph configure(String string, int size, int style, BaseColor color, int alinear){
		Paragraph p = new Paragraph(size+10, string, FontFactory.getFont("Arial", size, style, color));
		p.setAlignment(alinear);
		return p;
	}

	private void dibujarTabla(String[] strings, ArrayList<String[]> j) throws DocumentException {
		PdfPTable table = new PdfPTable(strings.length);
		float[] medidaCeldas = {2.25f, 2f, 2f, 1.25f, 2.25f, 2.5f, 2.5f, 2f,2f,2f};
		table.setWidths(medidaCeldas);
		for (int i = 0; i < strings.length; i++) {
			table.addCell(strings[i]);
		}
		for (int i = 0; i < j.size(); i++) {
			for (int k = 0; k < strings.length; k++) {
				table.addCell(j.get(i)[k]);
			}
		}
		document.add(table);
	}

	public ArrayList<String[]> getArrayCarros(List<Persona> listaPersonas){
		ArrayList<String[]> carros= new ArrayList<>();
		DateFormat sd = DateFormat.getDateInstance(DateFormat.SHORT);
		String vec[];
		for (Persona ca : listaPersonas) {
			vec= new String[10];
			vec[0]=ca.getNombrePersona();
			vec[1]=ca.getApellidoPersona();
			vec[2]=ca.getCedulaPersona();
			vec[3]= Integer.toString(ca.getSalarioPersona());
			vec[4]= ca.getFechaIngresoPersona() != null ? sd.format(ca.getFechaIngresoPersona()):"";
			vec[5]= ca.getFechaCancelacionPersona() != null ? sd.format(ca.getFechaCancelacionPersona()):"";
			if(ca.getEstadoPersona() == 1){
				vec[6]= "Activada";				
			}else{
				vec[6]= "Desactivada";
			}
			vec[7]=ca.getTelefonoPersona();
			vec[8]= ca.getDireccionPersona();
			vec[9]= ca.getCorreoPersona();
			carros.add(vec);
		}
		return carros; 
	}

}
