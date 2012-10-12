package com.persistencia;

import java.util.List;

import org.hibernate.Session;

import com.logica.Transmision;

public class AdministradorTransmision {
	@SuppressWarnings("unchecked")
	public static List<Transmision> getListaTransmisiones(){
		Session session = SessionDB.getSession();
		String hql = "from Transmision order by id";
		return session.createQuery(hql).list();
	}
	
	public static Transmision getTransmision(int idTransmision){
		Session session = SessionDB.getSession();
		return (Transmision)session.get(Transmision.class, idTransmision);
	}
	
	public static int getId(String nombreTransmision){
		List<Transmision> transmisiones = getListaTransmisiones();
		for (int i = 0; i < transmisiones.size(); i++) {
			Transmision transmision = transmisiones.get(i);
			if(transmision.equals(transmision.getNombreTransmision())){
				return transmision.getIdTransmision();
			}
		}
		return 0;
	}
	
	public static void guardarTransmision(Transmision transmision){
		Session session = SessionDB.getSession();
		session.save(transmision);
	}
	
	public static void eliminarTransmision(Transmision transmision){
		Session session = SessionDB.getSession();
		session.delete(transmision);
	}
}
