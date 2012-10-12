package com.persistencia;

import org.hibernate.Session;

import com.logica.Empresa;

public class AdministradorEmpresa {
	public static Empresa getEmpresa(int idEmpresa){
		Session session = SessionDB.getSession();
		return (Empresa)session.get(Empresa.class, idEmpresa);
	}
	
	public static void guardarEmpresa(Empresa empresa){
		Session session = SessionDB.getSession();
		session.save(empresa);
	}
}
