package com.persistencia;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.logica.Modelo;

public class AdministradorModelo {

	@SuppressWarnings("unchecked")
	public static List<Modelo> getListaModelo(int idMarca){
		Session session = SessionDB.getSession();
		String hql = "from Modelo where idMarcaModelo = " + idMarca;
		return session.createQuery(hql).list();
	}
	
	public static Modelo getModelo(int idModelo){
		Session session = SessionDB.getSession();
		return (Modelo)session.get(Modelo.class, idModelo);
	}
	
	public static Modelo getModeloNombre(String nombreModelo){
		Session session = SessionDB.getSession();
		String hql = "from Modelo where nombreModelo = '" + nombreModelo + "'";
		Query q= session.createQuery(hql);
		return (Modelo) q.uniqueResult();
	}
	
	public static void guardarModelo(Modelo modelo){
		Session session = SessionDB.getSession();
		session.save(modelo);
	}
	
	public static void eliminarModelo(Modelo modelo){
		Session session = SessionDB.getSession();
		session.delete(modelo);
	}
}
