package com.example.demo.funcional;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class PersonaPredicateImpl implements IPersonaPredicate<String>{
	
	private static final Logger LOG = (Logger) LoggerFactory.getLogger(PersonaPredicateImpl.class);

	@Override
	public boolean evaluar(String arg) {
		LOG.info("Cc"+arg);
		return true;
	}

}
