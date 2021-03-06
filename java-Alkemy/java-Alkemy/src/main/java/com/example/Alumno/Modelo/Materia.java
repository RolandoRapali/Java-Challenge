package com.example.Alumno.Modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "subject",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "name", name = "subject_name_unique")
		}
)
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false, length = 50)
	private String nombre;
	@Column(name = "schedule")
	private LocalTime horario;

	@Column(name = "description", nullable = false, length = 120)

	private String descripcion;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "registration_professor",
			joinColumns = @JoinColumn(name = "professor_dni"),
			inverseJoinColumns = @JoinColumn(name = "subject_id")
			)
	
	private List<Profesor> lstProfesor;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "registration_student",
			joinColumns = @JoinColumn(name = "student_dni"),
			inverseJoinColumns = @JoinColumn(name = "subject_id")
			)
	private List<Alumno> lstAlumno;
	@Column(name = "quota")
	private int cupoActual;
	@Column(name = "max_quota")
	private int cupoMaximo;

	public Materia() {
	}
	
	public Materia(String nombre, LocalTime horario, String descripcion, int cupoActual, int cupoMaximo) {
		super();
		this.nombre = nombre;
		this.horario = horario;
		this.descripcion = descripcion;
		this.lstProfesor = new ArrayList<>();
		this.lstAlumno = new ArrayList<>();
		this.cupoActual = cupoActual;
		this.cupoMaximo = cupoMaximo;
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", horario=" + horario + ", descripcion=" + descripcion
				+ ", lstProfesor=" + lstProfesor + ", lstAlumno=" + lstAlumno + ", cupoActual=" + cupoActual
				+ ", cupoMaximo=" + cupoMaximo + "]";
	}

	
	
}
