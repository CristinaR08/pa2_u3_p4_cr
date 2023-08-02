package com.example.demo.funcional;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class PersonaConsumerImpl implements IPersonaConsumer<String>{

	private static final Logger LOG = (Logger) LoggerFactory.getLogger(PersonaConsumerImpl.class);
	
	@Override
	public void accept(String arg) {
		LOG.info(arg);
		
	}

}
