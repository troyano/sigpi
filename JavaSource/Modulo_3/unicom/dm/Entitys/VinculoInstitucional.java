package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vinculo_institucional database table.
 * 
 */
@Entity
@Table(name="vinculo_institucional")
public class VinculoInstitucional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VINCULO_INSTITUCIONAL_IDVINCULO_GENERATOR", sequenceName="VINCULO_INSTITUCIONAL_ID_VINCULO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VINCULO_INSTITUCIONAL_IDVINCULO_GENERATOR")
	@Column(name="id_vinculo")
	private Integer idVinculo;

	@Column(name="descripcion_vinculo")
	private String descripcionVinculo;

	@Column(name="estado_vinculo")
	private Integer estadoVinculo;

	//bi-directional many-to-one association to PersonalProyecto
	@OneToMany(mappedBy="vinculoInstitucional")
	private List<PersonalProyecto> personalProyecto;

	public VinculoInstitucional() {
	}

	public Integer getIdVinculo() {
		return this.idVinculo;
	}

	public void setIdVinculo(Integer idVinculo) {
		this.idVinculo = idVinculo;
	}

	public String getDescripcionVinculo() {
		return this.descripcionVinculo;
	}

	public void setDescripcionVinculo(String descripcionVinculo) {
		this.descripcionVinculo = descripcionVinculo;
	}

	public Integer getEstadoVinculo() {
		return this.estadoVinculo;
	}

	public void setEstadoVinculo(Integer estadoVinculo) {
		this.estadoVinculo = estadoVinculo;
	}

	public List<PersonalProyecto> getPersonalProyecto() {
		return this.personalProyecto;
	}

	public void setPersonalProyecto(List<PersonalProyecto> personalProyecto) {
		this.personalProyecto = personalProyecto;
	}

	public PersonalProyecto addPersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().add(personalProyecto);
		personalProyecto.setVinculoInstitucional(this);

		return personalProyecto;
	}

	public PersonalProyecto removePersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().remove(personalProyecto);
		personalProyecto.setVinculoInstitucional(null);

		return personalProyecto;
	}

}