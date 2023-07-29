package com.example.demo.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String>{//el tipo de dato puede ser un objeto creado o uno que este en JAVA

	@Override
	public String getId() {
		String cedula = "1726600537";
		cedula = cedula+"holis";
		return cedula;
	}

}
