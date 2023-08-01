package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		IPersona per = new PersonaImpl();
		per.caminar();
		
		//1. Supplier
		
		//Clases:
		IPersonaSupplier<String>supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier clase: "+supplier1.getId());

		//Lambdas
		IPersonaSupplier<String> supplier2 = () -> "1726600537"; 
		LOG.info("Supplier lambda1: "+supplier2.getId());

		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "1726600537";
			cedula = cedula+"zzzzzz";
			return cedula;
		}; 
		LOG.info("Supplier lambda2: "+supplier3.getId());
		
		//Métodos Referenciados
		MetodosReferenciados metodos = new MetodosReferenciados();
		IPersonaSupplier<Integer> supplier4 = metodos::getId;
		LOG.info("Supplier MetodoReferenciado: "+supplier4.getId());
		
		
		//2. Consumer
		//Clases
		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		LOG.info("Consumer clase: ");
		consumer1.accept("Cristina Rivera");
		
		//Lambda
		IPersonaConsumer<String> consumer2 = cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		};
		LOG.info("Consumer lambda: ");
		consumer2.accept("Cristina Rivera_2");
		
		//Metodos Referenciados
		IPersonaConsumer<String> consumer3 = metodos::aceptar;
		LOG.info("Consumer MetodosReferenciados: ");
		consumer3.accept("<3");
		
		//3. Predicate
		//Lambdas
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8)==0;
		LOG.info("Predicate lambda1: "+predicate1.evaluar(4));

		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;
			valor = valor + valor2;
			if(valor.compareTo(100)>0) {
				return true;
			}else {
				return false;
			}
		};
		LOG.info("Predicate lambda2: "+predicate2.evaluar(95));
	
//si el nombre contiene un caracter	
		IPersonaPredicate<String> predicate3 = letra -> "Cristina".contains(letra);
		LOG.info("Predicate lambda3: "+predicate3.evaluar("h"));
		
//si me pide 2 argumentos
		IPersonaBiPredicate<String, String> predicate4 = (letra,cadena) -> cadena.contains(letra); 
		LOG.info("Predicate lambda4: "+predicate4.evaluar("P","Pablo"));
		
		//MetodosReferenciados
		IPersonaPredicate<Integer> predicate5 = metodos::evalua;
		LOG.info("Predicate MetodoReferenciado: "+predicate5.evaluar(10));

		
		//4. Function, sirve para funciones de casteo
		IPersonaFunction<String, Integer> function = numero ->numero.toString();
		LOG.info("Function lambda1: "+function.aplicar(8));
	
		IPersonaFunction<String, Integer> function2 = numero ->{
			String valorFinal = numero.toString().concat(" valor c:");
			return valorFinal;
		};
		LOG.info("Function lambda2: "+function2.aplicar(10));
		
		//5.Unary Operator
		IPersonaUnaryOperator<Integer> unaryOperator = numero -> numero+(numero*2);
		LOG.info("UnaryOperator lambda1: "+unaryOperator.aplicar(3));
		
		IPersonaUnaryOperatorFunction<Integer> unaryOperatorFunction = numero -> numero+(numero*2);
		LOG.info("UnaryOperatorFunction lambda1: "+unaryOperatorFunction.aplicar(3));
	
	}
}
