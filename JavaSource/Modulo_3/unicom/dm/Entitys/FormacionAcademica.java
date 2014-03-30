package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the formacion_academica database table.
 * 
 */
@Entity
@Table(name="formacion_academica")
public class FormacionAcademica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FORMACION_ACADEMICA_IDFORMACIONACADEMICA_GENERATOR", sequenceName="FORMACION_ACADEMICA_ID_FORMACION_ACADEMICA_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORMACION_ACADEMICA_IDFORMACIONACADEMICA_GENERATOR")
	@Column(name="id_formacion_academica")
	private Integer idFormacionAcademica;

	@Column(name="descripcion_formacion_academica")
	private String descripcionFormacionAcademica;

	@Column(name="estado_form_acade")
	private Integer estadoFormAcade;

	//bi-directional many-to-one association to PersonalProyecto
	@OneToMany(mappedBy="formacionAcademica")
	private List<PersonalProyecto> personalProyecto;

	public FormacionAcademica() {
	}

	public Integer getIdFormacionAcademica() {
		return this.idFormacionAcademica;
	}

	public void setIdFormacionAcademica(Integer idFormacionAcademica) {
		this.idFormacionAcademica = idFormacionAcademica;
	}

	public String getDescripcionFormacionAcademica() {
		return this.descripcionFormacionAcademica;
	}

	public void setDescripcionFormacionAcademica(String descripcionFormacionAcademica) {
		this.descripcionFormacionAcademica = descripcionFormacionAcademica;
	}

	public Integer getEstadoFormAcade() {
		return this.estadoFormAcade;
	}

	public void setEstadoFormAcade(Integer estadoFormAcade) {
		this.estadoFormAcade = estadoFormAcade;
	}

	public List<PersonalProyecto> getPersonalProyecto() {
		return this.personalProyecto;
	}

	public void setPersonalProyecto(List<PersonalProyecto> personalProyecto) {
		this.personalProyecto = personalProyecto;
	}

	public PersonalProyecto addPersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().add(personalProyecto);
		personalProyecto.setFormacionAcademica(this);

		return personalProyecto;
	}

	public PersonalProyecto removePersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().remove(personalProyecto);
		personalProyecto.setFormacionAcademica(null);

		return personalProyecto;
	}

}