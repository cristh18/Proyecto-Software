package com.logica;

import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.persistencia.AdministradorEmpresa;
import com.persistencia.SessionDB;

public class GenerarReportePersona {
	private Document document;
	private PdfWriter instance;

	public void generarReporteCarro(Persona persona, OutputStream ouputStream){
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
			document.add(configure("PERSONA", 30, Font.NORMAL,	BaseColor.BLUE, Chunk.ALIGN_CENTER));
			document.add(new Paragraph(" "));
			document.add(configure("Nombre / Razon social: " + persona.getNombrePersona(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Apellido: " + persona.getApellidoPersona(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Cédula: " + persona.getCedulaPersona(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Salario: " + persona.getSalarioPersona(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			if(persona.getFechaIngresoPersona() != null){
				document.add(configure("Fecha de ingreso: " + sd.format(persona.getFechaIngresoPersona()), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
				}
			if(persona.getFechaCancelacionPersona() != null){
			document.add(configure("Fecha de salida: " + sd.format(persona.getFechaCancelacionPersona()), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			}
			if(persona.getEstadoPersona() == 1){
				document.add(configure("Estado: Activada", 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));				
			}else{
				document.add(configure("Estado: Desactivada", 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			}
			document.add(configure("Teléfono: " + persona.getTelefonoPersona(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Direccion: " + persona.getDireccionPersona(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Correo: " + persona.getCorreoPersona(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
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
}
