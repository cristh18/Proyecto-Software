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

public class GenerarReporteVentas {
	private Document document;
	private PdfWriter instance;
	
	public void generarReporteCarros(List<Venta> listaVentas, OutputStream ouputStream){
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
			document.add(configure("Ventas", 30, Font.NORMAL,	BaseColor.BLUE, Chunk.ALIGN_CENTER));
			document.add(new Paragraph(" "));
						
			String[] columnName= {"Codigo venta","Placa carro","Marca carro","Modelo carro","Precio carro","Nombre propietario", "Nombre comprador", "Nombre vendedor","Fecha venta"};
			dibujarTabla(columnName, getArrayCarros(listaVentas));

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
		float[] medidaCeldas = {2.25f, 2f, 2f, 1.25f, 2.25f, 2.5f, 2.5f, 2f,2f};
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

	public ArrayList<String[]> getArrayCarros(List<Venta> listaVentas){
		ArrayList<String[]> carros= new ArrayList<>();
		DateFormat sd = DateFormat.getDateInstance(DateFormat.SHORT);
		String vec[];
		for (Venta ca : listaVentas) {
			vec= new String[9];
			vec[0]= Integer.toString(ca.getIdVenta());
			vec[1]= ca.getIdCarroVenta().getPlacaCarro();
			vec[2]=ca.getIdCarroVenta().getIdModeloCarro().getIdMarcaModelo().getNombreMarca();
			vec[3]=ca.getIdCarroVenta().getIdModeloCarro().getNombreModelo();
			vec[4]= Integer.toString(ca.getIdCarroVenta().getPrecioCarro());
			vec[5]= ca.getIdCarroVenta().getIdPropietarioPersona().getApellidoPersona() + " " + ca.getIdCarroVenta().getIdPropietarioPersona().getNombrePersona();
			vec[6]= ca.getIdClienteVenta().getApellidoPersona() + " " + ca.getIdClienteVenta().getNombrePersona();
			vec[7]= ca.getIdVendedorVenta().getApellidoPersona() + " " + ca.getIdVendedorVenta().getNombrePersona();				
			vec[8]=sd.format(ca.getFechaVenta());
			carros.add(vec);
		}
		return carros; 
	}
}
