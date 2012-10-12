package com.persistencia;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.logica.Venta;

public class AdministradorVenta {
	@SuppressWarnings("unchecked")
	public static List<Venta> getListaVentas(){
		Session session = SessionDB.getSession();
		String hql = "from Venta";
		return session.createQuery(hql).list();
	}

	public static Venta getVenta(int idVenta){
		Session session = SessionDB.getSession();
		return (Venta)session.get(Venta.class, idVenta);
	}

	@SuppressWarnings("unchecked")
	public static List<Venta> getListaVentasFechas(String fechaInicial, String fechaFinal){
		Session session = SessionDB.getSession();
		String hql = "from Venta where fechaVenta >= '" + fechaInicial + "' and fechaVenta <= '" + fechaFinal + "'";
		return session.createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public static List<Venta> getListaVentasVendedor(String cedulaVendedor){
		Session session = SessionDB.getSession();
		String hql = "from Venta where idVendedorVenta = '" + cedulaVendedor + "'";
		return session.createQuery(hql).list();
	}

	public static Venta getCarro(int idPlacaCarro){
		Session session = SessionDB.getSession();
		String hql = "from Venta where idCarroVenta = " + idPlacaCarro;
		Query q= session.createQuery(hql);
		return (Venta) q.uniqueResult();
	}
	
	public static void guardarVenta(Venta venta){
		Session session = SessionDB.getSession();
		session.save(venta);
	}

	public static void eliminarVenta(Venta venta){
		Session session = SessionDB.getSession();
		session.delete(venta);
	}

}
