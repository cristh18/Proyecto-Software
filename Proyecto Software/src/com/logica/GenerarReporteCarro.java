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
import com.persistencia.AdministradorVenta;
import com.persistencia.SessionDB;

public class GenerarReporteCarro {
	private Document document;
	private PdfWriter instance;

	public void generarReporteCarro(Carro carro, OutputStream ouputStream){
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
			document.add(configure("CARRO", 30, Font.NORMAL,	BaseColor.BLUE, Chunk.ALIGN_CENTER));
			document.add(new Paragraph(" "));
			document.add(configure("Placa: " + carro.getPlacaCarro(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Marca: " + carro.getIdModeloCarro().getIdMarcaModelo().getNombreMarca(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Modelo: " + carro.getIdModeloCarro().getNombreModelo(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Color: " + carro.getIdColorCarro().getNombreColor(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Vidrio: " + carro.getIdVidrioCarro().getNombreVidrio(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Combustible: " + carro.getIdCombustibleCarro().getNombreCombustible(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Direcció: " + carro.getIdDireccionCarro().getNombreDireccion(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Transmision: " + carro.getIdTransmisionCarro().getNombreTransmision(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Cilindraje: " + carro.getCilindrajeCarro(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Año: " + carro.getAnioCarro(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Precio: " + carro.getPrecioCarro(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Propietario: " + carro.getIdPropietarioPersona().getApellidoPersona() + " " +
			carro.getIdPropietarioPersona().getNombrePersona(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Fecha ingreso: " + carro.getFechaIngresoCarro(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			Venta venta = null;
			if(carro.getFechaVentaCarro() != null){
				venta = AdministradorVenta.getCarro(carro.getCodigoCarro());
			document.add(configure("Comprador: " + venta.getIdClienteVenta().getApellidoPersona() + " " + 
				venta.getIdClienteVenta().getNombrePersona(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			document.add(configure("Fecha venta: " + carro.getFechaVentaCarro(), 20, Font.NORMAL,	BaseColor.BLACK, Chunk.ALIGN_LEFT));
			}
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
