package com.persistencia;

import java.util.List;

import org.hibernate.Session;
import com.logica.Direccion;

public class AdministradorDireccion {
	@SuppressWarnings("unchecked")
	public static List<Direccion> getListaDireccion(){
		Session session = SessionDB.getSession();
		String hql = "from Direccion order by id";
		return session.createQuery(hql).list();
	}
	
	public static Direccion getDireccion(int idDireccion){
		Session session = SessionDB.getSession();
		return (Direccion)session.get(Direccion.class, idDireccion);
	}
	
	public static int getId(String nombreDireccion){
		List<Direccion> direcciones = getListaDireccion();
		for (int i = 0; i < direcciones.size(); i++) {
			Direccion direccion = direcciones.get(i);
			if(nombreDireccion.equals(direccion.getNombreDireccion())){
				return direccion.getIdDireccion();
			}
		}
		return 0;
	}
	
	public static void guardarDireccion(Direccion direccion){
		Session session = SessionDB.getSession();
		session.save(direccion);
	}
	
	public static void eliminarDireccion(Direccion direccion){
		Session session = SessionDB.getSession();
		session.delete(direccion);
	}
}
