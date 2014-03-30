package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pais")
	private String idPais;

	@Column(name="estado_pais")
	private Integer estadoPais;

	@Column(name="nombre_pais")
	private String nombrePais;

	//bi-directional many-to-one association to Departamento
	@OneToMany(mappedBy="pais")
	private List<Departamento> departamento;

	//bi-directional many-to-one association to EntEntidad
	@OneToMany(mappedBy="pais")
	private List<EntEntidad> entEntidad;

	//bi-directional many-to-one association to EntProductosservicio
	@OneToMany(mappedBy="pais")
	private List<EntProductosservicio> entProductosservicios;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="pais")
	private List<Personal> personal;

	public Pais() {
	}

	public String getIdPais() {
		return this.idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	public Integer getEstadoPais() {
		return this.estadoPais;
	}

	public void setEstadoPais(Integer estadoPais) {
		this.estadoPais = estadoPais;
	}

	public String getNombrePais() {
		return this.nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public List<Departamento> getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(List<Departamento> departamento) {
		this.departamento = departamento;
	}

	public Departamento addDepartamento(Departamento departamento) {
		getDepartamento().add(departamento);
		departamento.setPais(this);

		return departamento;
	}

	public Departamento removeDepartamento(Departamento departamento) {
		getDepartamento().remove(departamento);
		departamento.setPais(null);

		return departamento;
	}

	public List<EntEntidad> getEntEntidad() {
		return this.entEntidad;
	}

	public void setEntEntidad(List<EntEntidad> entEntidad) {
		this.entEntidad = entEntidad;
	}

	public EntEntidad addEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().add(entEntidad);
		entEntidad.setPais(this);

		return entEntidad;
	}

	public EntEntidad removeEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().remove(entEntidad);
		entEntidad.setPais(null);

		return entEntidad;
	}

	public List<EntProductosservicio> getEntProductosservicios() {
		return this.entProductosservicios;
	}

	public void setEntProductosservicios(List<EntProductosservicio> entProductosservicios) {
		this.entProductosservicios = entProductosservicios;
	}

	public EntProductosservicio addEntProductosservicio(EntProductosservicio entProductosservicio) {
		getEntProductosservicios().add(entProductosservicio);
		entProductosservicio.setPais(this);

		return entProductosservicio;
	}

	public EntProductosservicio removeEntProductosservicio(EntProductosservicio entProductosservicio) {
		getEntProductosservicios().remove(entProductosservicio);
		entProductosservicio.setPais(null);

		return entProductosservicio;
	}

	public List<Personal> getPersonal() {
		return this.personal;
	}

	public void setPersonal(List<Personal> personal) {
		this.personal = personal;
	}

	public Personal addPersonal(Personal personal) {
		getPersonal().add(personal);
		personal.setPais(this);

		return personal;
	}

	public Personal removePersonal(Personal personal) {
		getPersonal().remove(personal);
		personal.setPais(null);

		return personal;
	}

}