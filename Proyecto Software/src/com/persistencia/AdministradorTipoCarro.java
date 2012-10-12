package com.persistencia;

import java.util.List;

import org.hibernate.Session;

import com.logica.TipoCarro;

public class AdministradorTipoCarro {
	@SuppressWarnings("unchecked")
	public static List<TipoCarro> getTipoCarro(){
		Session session = SessionDB.getSession();
		String hql = "from TipoCarro order by id";
		return session.createQuery(hql).list();
	}
	
	public static TipoCarro getTipoCarro(int idTipoCarro){
		Session session = SessionDB.getSession();
		return (TipoCarro)session.get(TipoCarro.class, idTipoCarro);
	}
	
	public static int getId(String nombreTipoCarro){
		List<TipoCarro> tipoCarros = getTipoCarro();
		for (int i = 0; i < tipoCarros.size(); i++) {
			TipoCarro tipoCarro = tipoCarros.get(i);
			if(nombreTipoCarro.equals(tipoCarro.getNombreTipoCarro())){
				return tipoCarro.getIdTipoCarro();
			}
		}
		return 0;
	}
	
	public static void guardarTipocarro(TipoCarro tipoCarro){
		Session session = SessionDB.getSession();
		session.save(tipoCarro);
	}
	
	public static void eliminarTipoCarro(TipoCarro tipoCarro){
		Session session = SessionDB.getSession();
		session.delete(tipoCarro);
	}
}
