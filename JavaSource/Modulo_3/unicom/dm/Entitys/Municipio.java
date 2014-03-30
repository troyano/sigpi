package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the municipio database table.
 * 
 */
@Entity
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_municipio")
	private Integer idMunicipio;

	private String ciudad;

	@Column(name="estado_ciudad")
	private Integer estadoCiudad;

	//bi-directional many-to-one association to AptCobertura
	@OneToMany(mappedBy="municipio")
	private List<AptCobertura> aptCobertura;

	//bi-directional many-to-one association to EntEntidad
	@OneToMany(mappedBy="municipio")
	private List<EntEntidad> entEntidad;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento departamento;

	//bi-directional many-to-one association to Proyecto
	@OneToMany(mappedBy="municipio")
	private List<Proyecto> proyecto;

	public Municipio() {
	}

	public Integer getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getEstadoCiudad() {
		return this.estadoCiudad;
	}

	public void setEstadoCiudad(Integer estadoCiudad) {
		this.estadoCiudad = estadoCiudad;
	}

	public List<AptCobertura> getAptCobertura() {
		return this.aptCobertura;
	}

	public void setAptCobertura(List<AptCobertura> aptCobertura) {
		this.aptCobertura = aptCobertura;
	}

	public AptCobertura addAptCobertura(AptCobertura aptCobertura) {
		getAptCobertura().add(aptCobertura);
		aptCobertura.setMunicipio(this);

		return aptCobertura;
	}

	public AptCobertura removeAptCobertura(AptCobertura aptCobertura) {
		getAptCobertura().remove(aptCobertura);
		aptCobertura.setMunicipio(null);

		return aptCobertura;
	}

	public List<EntEntidad> getEntEntidad() {
		return this.entEntidad;
	}

	public void setEntEntidad(List<EntEntidad> entEntidad) {
		this.entEntidad = entEntidad;
	}

	public EntEntidad addEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().add(entEntidad);
		entEntidad.setMunicipio(this);

		return entEntidad;
	}

	public EntEntidad removeEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().remove(entEntidad);
		entEntidad.setMunicipio(null);

		return entEntidad;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Proyecto> getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(List<Proyecto> proyecto) {
		this.proyecto = proyecto;
	}

	public Proyecto addProyecto(Proyecto proyecto) {
		getProyecto().add(proyecto);
		proyecto.setMunicipio(this);

		return proyecto;
	}

	public Proyecto removeProyecto(Proyecto proyecto) {
		getProyecto().remove(proyecto);
		proyecto.setMunicipio(null);

		return proyecto;
	}

}