package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CARGO_IDCARGO_GENERATOR", sequenceName="CARGO_ID_CARGO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARGO_IDCARGO_GENERATOR")
	@Column(name="id_cargo")
	private Integer idCargo;

	@Column(name="estado_cargo")
	private Integer estadoCargo;

	@Column(name="nombre_cargo")
	private String nombreCargo;

	//bi-directional many-to-one association to PersonalProyecto
	@OneToMany(mappedBy="cargo")
	private List<PersonalProyecto> personalProyecto;

	public Cargo() {
	}

	public Integer getIdCargo() {
		return this.idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public Integer getEstadoCargo() {
		return this.estadoCargo;
	}

	public void setEstadoCargo(Integer estadoCargo) {
		this.estadoCargo = estadoCargo;
	}

	public String getNombreCargo() {
		return this.nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

	public List<PersonalProyecto> getPersonalProyecto() {
		return this.personalProyecto;
	}

	public void setPersonalProyecto(List<PersonalProyecto> personalProyecto) {
		this.personalProyecto = personalProyecto;
	}

	public PersonalProyecto addPersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().add(personalProyecto);
		personalProyecto.setCargo(this);

		return personalProyecto;
	}

	public PersonalProyecto removePersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().remove(personalProyecto);
		personalProyecto.setCargo(null);

		return personalProyecto;
	}

}