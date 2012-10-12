package com.persistencia;

import java.util.List;

import org.hibernate.Session;

import com.logica.Marca;

public class AdministradorMarca {
	@SuppressWarnings("unchecked")
	public static List<Marca> getListaMarcas(){
		Session session = SessionDB.getSession();
		String hql = "from Marca order by id";
		return session.createQuery(hql).list();
	}
	
	public static int getId(String nombreMarca){
		List<Marca> marcas = getListaMarcas();
		for (int i = 0; i < marcas.size(); i++) {
			Marca marca = marcas.get(i);
			if(nombreMarca.equals(marca.getNombreMarca())){
				return marca.getIdMarca();
			}
		}
		return 0;
	}
	
	public static Marca getMarca(int idMarca){
		Session session = SessionDB.getSession();
		return (Marca)session.get(Marca.class, idMarca);
	}
	
	public static void guardarMarca(Marca marca){
		Session session = SessionDB.getSession();
		session.save(marca);
	}
	
	public static void eliminarMarca(Marca marca){
		Session session = SessionDB.getSession();
		session.delete(marca);
	}
}
