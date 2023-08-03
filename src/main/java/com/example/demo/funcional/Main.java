package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		//***********************METODOS HIGH ORDER***************************
		//Supplier
		//1. Clase
		IPersonaSupplier<String>supplierHO = new PersonaSupplierImpl();
		MetodosHighOrder.metodo(supplierHO);
		//2. Lambdas
		MetodosHighOrder.metodo(()-> "1726600537_HO");
		//3. Metodos referenciados
		MetodosHighOrder.metodo(MetodosReferenciados::getIdHO);
		
		//Consumer
		//1. Clase
		MetodosHighOrder.metodoConsummer(new PersonaConsumerImpl(), "ClaseConsummer");		
		//2. Lambdas
		MetodosHighOrder.metodoConsummer(cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		}, "Lambda Consummer");	
		//3.Metodos referenciados		
		MetodosHighOrder.metodoConsummer(MetodosReferenciados::aceptar, "Metodos referenciados Consummer");
	
		//Predicate
		//1.Clase
		MetodosHighOrder.metodoPredicate(new PersonaPredicateImpl(), "Clase Predicate");
		//2.Lambdas
		MetodosHighOrder.metodoPredicate(cadena -> {
		    LOG.info("Evaluar cadena: " + cadena);
		    return true; 
		}, "Lambda Predicate");
		//3.Metodos referenciados
		MetodosHighOrder.metodoPredicate(MetodosReferenciados::evaluar, "Metodos referenciados Predicate");
		//Function
		//1.Clase
		MetodosHighOrder.metodoFunction(new PersonaFunctionImpl(), "Clase Function");
		//2.Lambdas
		MetodosHighOrder.metodoFunction(cadena -> {
		    LOG.info("Lambda: " + cadena);
		    return null;
		    }, "Lambda Function");
		//3.Metedos Referenciados
		MetodosHighOrder.metodoFunction(MetodosReferenciados::aplica, "Metodos referenciados Function");
		//Unary Operator
		//1.Clase
		MetodosHighOrder.metodoUnaryOperator(new PersonaUnaryOperatorImpl(), "Clase Unary Operator");
		//2.Lambdas
		MetodosHighOrder.metodoUnaryOperator(numero -> numero+numero, "Lambda UnaryOperator");
		//3.Metedos Referenciados
		MetodosHighOrder.metodoUnaryOperator(MetodosReferenciados::aplicaUO, "MetodoReferenciado UnaryOperator");
		//***************************INTERFACES FUNCIONALES JAVA**********************************
		//1. Supplier
		Stream<String> lista = Stream.generate(()-> "1726600537").limit(10);
		lista.forEach(cadena->LOG.info(cadena));

		//2. Consummer
		List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
		listaNumeros.forEach(cadena -> {
			LOG.info(""+cadena);
		});
		
		//3.Predicate
		Stream<Integer> listaFinal =listaNumeros.stream().filter(numero -> numero>=5);
		listaFinal.forEach(numero-> LOG.info("Valor: "+numero));
		
		//4.Function
		Stream<String> listaCambiada = listaNumeros.stream().map(numero -> {
			Integer num = 10;
			num = numero+num;
			return "N: "+num;
		});
		listaCambiada.forEach(cadena->LOG.info(cadena));

		//5.Unary Operator
		Stream<Integer> listaCambiada2 = listaNumeros.stream().map(numero -> {
			Integer num = 10;
			num = numero+num;
			return num;
		});
		listaCambiada2.forEach(cadena->LOG.info(cadena.toString()));
		
	}
}
