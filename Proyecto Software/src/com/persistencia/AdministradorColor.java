package com.persistencia;

import java.util.List;

import org.hibernate.Session;

import com.logica.Color;

public class AdministradorColor {
	@SuppressWarnings("unchecked")
	public static List<Color> getListaColor(){
		Session session = SessionDB.getSession();
		String hql = "from Color order by id";
		return session.createQuery(hql).list();
	}
	
	public static Color getColor(int idColor){
		Session session = SessionDB.getSession();
		return (Color)session.get(Color.class, idColor);
	}
	
	public static int getId(String nombreColor){
		List<Color> colores = getListaColor();
		for (int i = 0; i < colores.size(); i++) {
			Color color = colores.get(i);
			if(nombreColor.equals(color.getNombreColor())){
				return color.getIdColor();
			}
		}
		return 0;
	}
	
	public static void guardarColor(Color color){
		Session session = SessionDB.getSession();
		session.save(color);
	}
	
	public static void eliminarColor(Color color){
		Session session = SessionDB.getSession();
		session.delete(color);
	}
}
