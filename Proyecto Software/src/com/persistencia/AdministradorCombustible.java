package com.persistencia;

import java.util.List;
import org.hibernate.Session;
import com.logica.Combustible;

public class AdministradorCombustible {
	@SuppressWarnings("unchecked")
	public static List<Combustible> getListaCombustibles(){
		Session session = SessionDB.getSession();
		String hql = "from Combustible order by id";
		return session.createQuery(hql).list();
	}
	
	public static Combustible getCombustible(int idCombustible){
		Session session = SessionDB.getSession();
		return (Combustible)session.get(Combustible.class, idCombustible);
	}
	
	public static int getId(String nombreCombustible){
		List<Combustible> combustibles = getListaCombustibles();
		for (int i = 0; i < combustibles.size(); i++) {
			Combustible combustible = combustibles.get(i);
			if(nombreCombustible.equals(combustible.getNombreCombustible())){
				return combustible.getIdCombustible();
			}
		}
		return 0;
	}
	
	public static void guardarCombustible(Combustible combustible){
		Session session = SessionDB.getSession();
		session.save(combustible);
	}
	
	public static void eliminarCombustible(Combustible combustible){
		Session session = SessionDB.getSession();
		session.delete(combustible);
	}
}
