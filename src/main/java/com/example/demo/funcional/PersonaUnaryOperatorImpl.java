package com.example.demo.funcional;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class PersonaUnaryOperatorImpl implements IPersonaUnaryOperator<String>{

	private static final Logger LOG = (Logger) LoggerFactory.getLogger(PersonaUnaryOperatorImpl.class);

	@Override
	public String aplicar(String arg) {
		String valor = arg+arg;
		LOG.info(valor);
		return valor;
	}

}
