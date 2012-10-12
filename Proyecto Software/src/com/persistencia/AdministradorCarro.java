package com.persistencia;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.logica.Carro;

public class AdministradorCarro {
	@SuppressWarnings("unchecked")
	public static List<Carro> getListaCarro(){
		Session session = SessionDB.getSession();
		String hql = "from Carro where estadoCarro = 1";
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Carro> getListaCarrosTodos(){
		Session session = SessionDB.getSession();
		String hql = "from Carro";
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Carro> getListaCarroVendidos(){
		Session session = SessionDB.getSession();
		String hql = "from Carro where estadoCarro = 2";
		return session.createQuery(hql).list();
	}
	
	public static Carro getCarro(int codigoCarro){
		Session session = SessionDB.getSession();
		return (Carro)session.get(Carro.class, codigoCarro);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Carro> getListaCarroUltimos(){
		Session session = SessionDB.getSession();
		String hql = "from Carro where estadoCarro = 1 order by fechaIngresoCarro";
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Carro> getListaCarroParametro(int consulta, int valor){
		Session session = SessionDB.getSession();
		String hql = "from Carro c where c.estadoCarro = 1 and ";
		switch (consulta) {
		case 1:
			hql += "c.idModeloCarro.idMarcaModelo = " + valor;
			break;
		case 2:
			hql += "c.idModeloCarro = " + valor;
			break;
		case 3:
			hql += "c.idColorCarro = " + valor;
			break;
		case 4:
			hql += "c.idVidrioCarro = " + valor;
			break;
		case 5:
			hql += "c.idCombustibleCarro = " + valor;
			break;
		case 6:
			hql += "c.idDireccionCarro = " + valor;
			break;
		case 7:
			hql += "c.idTransmisionCarro = " + valor;
			break;
		}
		return session.createQuery(hql).list();
	}
	
	public static Carro getCarro(String placaCarro){
		Session session = SessionDB.getSession();
		String hql = "from Carro where placaCarro = '" + placaCarro + "' and estadoCarro = 1";
		Query q= session.createQuery(hql);
		return (Carro) q.uniqueResult();
	}
	
	
	
	public static void guardarCarro(Carro carro){
		Session session = SessionDB.getSession();
		session.save(carro);
	}
	
	public static void eliminarCombustible(Carro carro){
		Session session = SessionDB.getSession();
		session.delete(carro);
	}
}
