package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the area_desempeno database table.
 * 
 */
@Entity
@Table(name="area_desempeno")
public class AreaDesempeno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AREA_DESEMPENO_IDAREADESEMPENO_GENERATOR", sequenceName="AREA_DESEMPENO_ID_AREA_DESEMPENO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AREA_DESEMPENO_IDAREADESEMPENO_GENERATOR")
	@Column(name="id_area_desempeno")
	private Integer idAreaDesempeno;

	@Column(name="descripcion_area")
	private String descripcionArea;

	@Column(name="estado_area_desem")
	private Integer estadoAreaDesem;

	//bi-directional many-to-one association to PersonalProyecto
	@OneToMany(mappedBy="areaDesempeno")
	private List<PersonalProyecto> personalProyecto;

	public AreaDesempeno() {
	}

	public Integer getIdAreaDesempeno() {
		return this.idAreaDesempeno;
	}

	public void setIdAreaDesempeno(Integer idAreaDesempeno) {
		this.idAreaDesempeno = idAreaDesempeno;
	}

	public String getDescripcionArea() {
		return this.descripcionArea;
	}

	public void setDescripcionArea(String descripcionArea) {
		this.descripcionArea = descripcionArea;
	}

	public Integer getEstadoAreaDesem() {
		return this.estadoAreaDesem;
	}

	public void setEstadoAreaDesem(Integer estadoAreaDesem) {
		this.estadoAreaDesem = estadoAreaDesem;
	}

	public List<PersonalProyecto> getPersonalProyecto() {
		return this.personalProyecto;
	}

	public void setPersonalProyecto(List<PersonalProyecto> personalProyecto) {
		this.personalProyecto = personalProyecto;
	}

	public PersonalProyecto addPersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().add(personalProyecto);
		personalProyecto.setAreaDesempeno(this);

		return personalProyecto;
	}

	public PersonalProyecto removePersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().remove(personalProyecto);
		personalProyecto.setAreaDesempeno(null);

		return personalProyecto;
	}

}