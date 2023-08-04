package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	
	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

	
	public static Integer getId() {
		return 8;
	}

	public static void aceptar(String arg) {
		String cadena = "Cris";
		LOG.info(cadena+ " " +arg);
	}
	
	public static boolean evaluar(String arg) {
        LOG.info("UwU"+arg);
        return true;
	}
	
	public static String getIdHO() {
		LOG.info("Metodos referenciados y HO");
		return "Cristina";
	}
	
	public static String aplica(Integer arg) {
		LOG.info("CR_MetodosRefernciado Function");
		return "LS_";
		
	}
	
	public static String aplicaUO(String val) {
		LOG.info("CR_MetodosRefernciado Function");
		return val;
		
	}
	
}
