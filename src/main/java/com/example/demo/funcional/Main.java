package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		
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
		
		//********************************DEBER******************************************
		//1. Supplier
		Stream<String> nombre = Stream.generate(()-> "Cristina").limit(7);
		nombre.forEach(cadena->LOG.info(cadena));
		
		//2. Consummer
		List<Integer> num = Arrays.asList(1,7,8,9,3,0,2,5,4,6);
		listaNumeros.forEach(cadena -> {
			LOG.info(":3"+cadena+"<3");
		});
		
		//3.Predicate
		Stream<Integer> finalL =num.stream().filter(numeros -> numeros>=20);
		finalL.forEach(numeros-> LOG.info("Valor: "+numeros));
		
		//4.Function
		Stream<String> finalCambiada = listaNumeros.stream().map(numeros -> {
			Integer nums = 10;
			nums = numeros+nums;
			return "Numero "+nums;
		});
		finalCambiada.forEach(cadena->LOG.info(cadena));

		//5.Unary Operator
		Stream<Integer> finalCambiada2 = listaNumeros.stream().map(numeros -> {
			Integer nums = 13;
			nums = numeros+nums;
			return nums;
		});
		finalCambiada2.forEach(cadena->LOG.info(cadena.toString()));

	}
}
