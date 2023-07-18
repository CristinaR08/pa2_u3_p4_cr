package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.Provincia;
import com.example.demo.repository.modelo.Semestre;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.IMatriculaService;

@SpringBootApplication
public class Pa2U3P4CrApplication implements CommandLineRunner{
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private IMatriculaService matriculaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4CrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Provincia pro = new Provincia();
		pro.setNombre("Pichincha");
		pro.setCanton("Quito");
		pro.setParroquia("Libertad");
		
		Estudiante est = new Estudiante();
		est.setCedula("1726600537");
		est.setNombre("Cristina");
		est.setApellido("Rivera");
		est.setProvincia(pro);
		
		Semestre s = new Semestre();
		s.setSemestre(5);
		s.setEstado("No regular");
		s.setPeriodo("2023-2023");
		
		Materia mat = new Materia();
		mat.setCodigo("PA2-04");
		mat.setNombre("Programacion Avanzada II");
		mat.setProfesor("Ing. Edison Cayambe");
		mat.setSemestre(s);
		
		Materia mat1 = new Materia();
		mat1.setCodigo("PA2-04");
		mat1.setNombre("Programacion Avanzada II");
		mat1.setProfesor("Ing. Edison Cayambe");
		mat1.setSemestre(s);
		
		Materia mat2 = new Materia();
		mat2.setCodigo("PA2-04");
		mat2.setNombre("Programacion Avanzada II");
		mat2.setProfesor("Ing. Edison Cayambe");
		mat2.setSemestre(s);
		
		Matricula matricula = new Matricula();
		matricula.setEstado("Primera");
		matricula.setFecha(LocalDateTime.now());
		matricula.setMonto(new BigDecimal(0.0));
		matricula.setEstudiante(est);
		//matricula.setMateria(mat);
		matricula.setMateria(mat1);
		matricula.setMateria(mat2);
		//this.matriculaService.matricularPorCedula("1785632012");
		//this.matriculaService.guardar(matricula);
		
		System.out.println(this.materiaService.reporteMaterias());
		
	}
}
