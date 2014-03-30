package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sede_programa database table.
 * 
 */
@Entity
@Table(name="sede_programa")
public class SedePrograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEDE_PROGRAMA_IDSEDEPROGRAMA_GENERATOR", sequenceName="SEDE_PROGRAMA_ID_SEDE_PROGRAMA_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEDE_PROGRAMA_IDSEDEPROGRAMA_GENERATOR")
	@Column(name="id_sede_programa")
	private Integer idSedePrograma;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="sedePrograma")
	private List<Personal> personal;

	//bi-directional many-to-one association to PersonalProyecto
	@OneToMany(mappedBy="sedePrograma")
	private List<PersonalProyecto> personalProyecto;

	//bi-directional many-to-one association to Programa
	@ManyToOne
	@JoinColumn(name="id_programa")
	private Programa programa;

	//bi-directional many-to-one association to Sede
	@ManyToOne
	@JoinColumn(name="id_sede")
	private Sede sede;

	public SedePrograma() {
	}

	public Integer getIdSedePrograma() {
		return this.idSedePrograma;
	}

	public void setIdSedePrograma(Integer idSedePrograma) {
		this.idSedePrograma = idSedePrograma;
	}

	public List<Personal> getPersonal() {
		return this.personal;
	}

	public void setPersonal(List<Personal> personal) {
		this.personal = personal;
	}

	public Personal addPersonal(Personal personal) {
		getPersonal().add(personal);
		personal.setSedePrograma(this);

		return personal;
	}

	public Personal removePersonal(Personal personal) {
		getPersonal().remove(personal);
		personal.setSedePrograma(null);

		return personal;
	}

	public List<PersonalProyecto> getPersonalProyecto() {
		return this.personalProyecto;
	}

	public void setPersonalProyecto(List<PersonalProyecto> personalProyecto) {
		this.personalProyecto = personalProyecto;
	}

	public PersonalProyecto addPersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().add(personalProyecto);
		personalProyecto.setSedePrograma(this);

		return personalProyecto;
	}

	public PersonalProyecto removePersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().remove(personalProyecto);
		personalProyecto.setSedePrograma(null);

		return personalProyecto;
	}

	public Programa getPrograma() {
		return this.programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Sede getSede() {
		return this.sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

}