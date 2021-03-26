package com.example.Materia;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.example.Alumno.Alumno;
import com.example.Profesor.Profesor;




/*@Entity
@Table(name="subject")*/
public class Materia {
	@Id
	@SequenceGenerator(
			name = "subject_sequence",
			sequenceName = "subject_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "subject_sequence")
	private int id;
	/*
	 * @Column(name="name", nullable = false, unique = true, length = 50)
	 */
	private String nombre;
	/* @Column(name="schedule") */
	private LocalTime horario;
	/*
	 * @Column(name="description", nullable = false, length = 120)
	 */
	private String descripcion;
	/*@ElementCollection(targetClass = java.util.ArrayList.class)
	@CollectionTable(name = "subject",
			uniqueConstraints = {
					@UniqueConstraint(name = "subject_professor", columnNames = "subject_lstProfesor")
			})*/
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "Profesor_dni")
	 */
	private List<Profesor> lstProfesor;
	/*@ElementCollection(targetClass = java.util.ArrayList.class)
	@CollectionTable(name = "subject",
	uniqueConstraints = {
			@UniqueConstraint(name = "subject_student", columnNames = "subject_lstStudent")
	})*/
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "Student_dni")
	 */
	private List<Alumno> lstAlumno;
	/* @Column(name="quota") */
	private int cupoActual;
	/* @Column(name="max_quota") */
	private int cupoMaximo;
	
	public Materia(String nombre, LocalTime horario, String descripcion, List<Profesor> lstProfesor,
			List<Alumno> lstAlumno,int cupoActual ,int cupoMaximo) {
		super();
		this.nombre = nombre;
		this.horario = horario;
		this.descripcion = descripcion;
		this.lstProfesor = new ArrayList<>();
		this.lstAlumno = new ArrayList<>();
		this.cupoActual = cupoActual;
		this.cupoMaximo = cupoMaximo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Profesor> getLstProfesor() {
		return lstProfesor;
	}
	public void setLstProfesor(List<Profesor> lstProfesor) {
		this.lstProfesor = lstProfesor;
	}

	public List<Alumno> getLstAlumno() {
		return lstAlumno;
	}
	public void setLstAlumno(List<Alumno> lstAlumno) {
		this.lstAlumno = lstAlumno;
	}
	
	public int getCupoActual() {
		return cupoActual;
	}
	public void setCupoActual(int cupoActual) {
		this.cupoActual = cupoActual;
	}
	public int getCupoMaximo() {
		return cupoMaximo;
	}
	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}
	
	public Alumno traerAlumno(long legajo) {
		int contador = 0;
		Alumno alumno = null;
		while(alumno == null) {
			if(this.lstAlumno.get(contador).getLegajo() == legajo) {
				alumno = this.lstAlumno.get(contador);
			}
			contador++;
		}
		return alumno;
	}
	
	boolean inscribirseMateria(Materia materia, Alumno alumno) throws Exception {
		if(traerAlumno(alumno.getLegajo()) != null) {
			throw new Exception("El alumno ya esta inscripto");
		}
		cupoActual++;
		return materia.getLstAlumno().add(alumno);
	}
}
