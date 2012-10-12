package com.persistencia;

import java.util.List;

import org.hibernate.Session;

import com.logica.Persona;

public class AdministradorPersona {
	@SuppressWarnings("unchecked")
	public static List<Persona> getListaPersonas(int tipoPersona){
		Session session = SessionDB.getSession();
		return session.createQuery("from Persona where tipoPersona = " +
		tipoPersona + " and estadoPersona = 1").list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Persona> getListaPersonasTodas(int tipoPersona){
		Session session = SessionDB.getSession();
		return session.createQuery("from Persona where tipoPersona = " + tipoPersona).list();
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Persona> getListaVendedores(){
		Session session = SessionDB.getSession();
		return session.createQuery("from Persona where tipoPersona != 3").list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Persona> getListaPersonas(){
		Session session = SessionDB.getSession();
		return session.createQuery("from Persona where estadoPersona = 1").list();
	}
	
	public static Persona getPersona(String cedulaPersona){
		Session session = SessionDB.getSession();
		return (Persona)session.get(Persona.class, cedulaPersona);
	}
	
	public static void guardarPersona(Persona persona){
		Session session = SessionDB.getSession();
		session.save(persona);
	}
	
	public static void eliminarPersona(Persona persona){
		Session session = SessionDB.getSession();
		session.delete(persona);
	}
}
