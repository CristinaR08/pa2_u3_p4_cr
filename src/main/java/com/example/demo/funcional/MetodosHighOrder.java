package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {
	
	private static final Logger LOG = LoggerFactory.getLogger(MetodosHighOrder.class);

	public static void metodo(IPersonaSupplier<String> funcion) {
		//especifico la interfaz funcional
		LOG.info("High order Supplier..."+funcion.getId());
	}

	public static void metodoConsummer(IPersonaConsumer<String> funcion, String cadena) {
		//especifico la interfaz funcional
		funcion.accept(cadena);
	}
	
}
