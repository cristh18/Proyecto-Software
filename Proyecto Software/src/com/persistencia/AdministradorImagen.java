package com.persistencia;

import java.util.List;

import org.hibernate.Session;

import com.logica.Imagen;

public class AdministradorImagen {
	public static void guardarImagen(Imagen imagen){
		Session session = SessionDB.getSession();
		session.save(imagen);
	}
	
	public static Imagen getImagen(int idImagen){
		Session session = SessionDB.getSession();
		return (Imagen)session.get(Imagen.class, idImagen);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Imagen> getListaImagenes(int codigoCarro){
		Session session = SessionDB.getSession();
		String hql = "from Imagen where idCarroImagen = " +
		codigoCarro;
		return session.createQuery(hql).list();
	}
	
	public static void borrarImagen(Imagen imagen){
		Session session = SessionDB.getSession();
		session.delete(imagen);
	}
}
