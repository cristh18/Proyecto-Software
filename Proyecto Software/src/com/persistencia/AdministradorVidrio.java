package com.persistencia;

import java.util.List;

import org.hibernate.Session;

import com.logica.Vidrio;

public class AdministradorVidrio {
	@SuppressWarnings("unchecked")
	public static List<Vidrio> getListaVidrios(){
		Session session = SessionDB.getSession();
		String hql = "from Vidrio order by id";
		return session.createQuery(hql).list();
	}
	
	public static Vidrio getVidrio(int idVidrio){
		Session session = SessionDB.getSession();
		return (Vidrio)session.get(Vidrio.class, idVidrio);
	}
	
	public static int getId(String nombreVidrio){
		List<Vidrio> vidrios = getListaVidrios();
		for (int i = 0; i < vidrios.size(); i++) {
			Vidrio vidrio = vidrios.get(i);
			if(nombreVidrio.equals(vidrio.getNombreVidrio())){
				return vidrio.getIdVidrio();
			}
		}
		return 0;
	}
	
	public static void guardarVidrio(Vidrio vidrio){
		Session session = SessionDB.getSession();
		session.save(vidrio);
	}
	
	public static void eliminarVidrio(Vidrio vidrio){
		Session session = SessionDB.getSession();
		session.delete(vidrio);
	}
}
