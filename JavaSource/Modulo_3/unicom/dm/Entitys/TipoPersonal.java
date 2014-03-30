package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_personal database table.
 * 
 */
@Entity
@Table(name="tipo_personal")
public class TipoPersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_PERSONAL_IDTIPOPERSONAL_GENERATOR", sequenceName="TIPO_PERSONAL_ID_TIPO_PERSONAL_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_PERSONAL_IDTIPOPERSONAL_GENERATOR")
	@Column(name="id_tipo_personal")
	private Integer idTipoPersonal;

	@Column(name="descripcion_personal")
	private String descripcionPersonal;

	@Column(name="estado_tipo_personal")
	private Integer estadoTipoPersonal;

	//bi-directional many-to-one association to PersonalProyecto
	@OneToMany(mappedBy="tipoPersonal")
	private List<PersonalProyecto> personalProyecto;

	public TipoPersonal() {
	}

	public Integer getIdTipoPersonal() {
		return this.idTipoPersonal;
	}

	public void setIdTipoPersonal(Integer idTipoPersonal) {
		this.idTipoPersonal = idTipoPersonal;
	}

	public String getDescripcionPersonal() {
		return this.descripcionPersonal;
	}

	public void setDescripcionPersonal(String descripcionPersonal) {
		this.descripcionPersonal = descripcionPersonal;
	}

	public Integer getEstadoTipoPersonal() {
		return this.estadoTipoPersonal;
	}

	public void setEstadoTipoPersonal(Integer estadoTipoPersonal) {
		this.estadoTipoPersonal = estadoTipoPersonal;
	}

	public List<PersonalProyecto> getPersonalProyecto() {
		return this.personalProyecto;
	}

	public void setPersonalProyecto(List<PersonalProyecto> personalProyecto) {
		this.personalProyecto = personalProyecto;
	}

	public PersonalProyecto addPersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().add(personalProyecto);
		personalProyecto.setTipoPersonal(this);

		return personalProyecto;
	}

	public PersonalProyecto removePersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().remove(personalProyecto);
		personalProyecto.setTipoPersonal(null);

		return personalProyecto;
	}

}