package com.example.demo.funcional;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class PersonaFunctionImpl implements IPersonaFunction<String, Integer> {

	private static final Logger LOG = (Logger) LoggerFactory.getLogger(PersonaFunctionImpl.class);

	@Override
	public String aplicar(Integer arg) {  
		if (arg % 2 == 0) {
			LOG.info("A");
	            return "El número es par.";
	        } else {
	            return "El número es impar.";
	        }
	    }
}
