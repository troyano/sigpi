package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ent_situacion_financiera database table.
 * 
 */
@Entity
@Table(name = "ent_situacion_financiera", catalog = "sigpi", schema = "public")
@NamedQueries({
		@NamedQuery(name = "sf.findAll", query = "SELECT SF FROM EntSituacionFinanciera sf"),
		@NamedQuery(name = "sf.findById", query = "SELECT SF FROM EntSituacionFinanciera sf WHERE sf.idEntidadVariable = :idEntidadVariable "),
		@NamedQuery(name = "sf.findByEntidad", query = "SELECT SF FROM EntSituacionFinanciera sf WHERE sf.entEntidad = :entEntidad "),
		@NamedQuery(name = "sf.findByMaxId", query = "SELECT SF FROM EntSituacionFinanciera sf WHERE sf.idEntidadVariable = (SELECT MAX(sff.idEntidadVariable) FROM EntSituacionFinanciera sff) ")})

public class EntSituacionFinanciera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_SITUACION_FINANCIERA_IDENTIDADVARIABLE_GENERATOR", sequenceName="ENT_SITUACION_FINANCIERA_ID_ENTIDAD_VARIABLE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_SITUACION_FINANCIERA_IDENTIDADVARIABLE_GENERATOR")
	@Column(name="id_entidad_variable")
	private Integer idEntidadVariable;

	//bi-directional many-to-one association to EntFinancieraAnio
	@OneToMany(mappedBy="entSituacionFinanciera")
	private List<EntFinancieraAnio> entFinancieraAnio;

	//bi-directional many-to-one association to EntEntidad
	@ManyToOne
	@JoinColumn(name="id_ent_entidad")
	private EntEntidad entEntidad;

	//bi-directional many-to-one association to EntIndicador
	@ManyToOne
	@JoinColumn(name="id_indicador")
	private EntIndicador entIndicador;

	public EntSituacionFinanciera() {
	}

	public Integer getIdEntidadVariable() {
		return this.idEntidadVariable;
	}

	public void setIdEntidadVariable(Integer idEntidadVariable) {
		this.idEntidadVariable = idEntidadVariable;
	}

	public List<EntFinancieraAnio> getEntFinancieraAnio() {
		return this.entFinancieraAnio;
	}

	public void setEntFinancieraAnio(List<EntFinancieraAnio> entFinancieraAnio) {
		this.entFinancieraAnio = entFinancieraAnio;
	}

	public EntFinancieraAnio addEntFinancieraAnio(EntFinancieraAnio entFinancieraAnio) {
		getEntFinancieraAnio().add(entFinancieraAnio);
		entFinancieraAnio.setEntSituacionFinanciera(this);

		return entFinancieraAnio;
	}

	public EntFinancieraAnio removeEntFinancieraAnio(EntFinancieraAnio entFinancieraAnio) {
		getEntFinancieraAnio().remove(entFinancieraAnio);
		entFinancieraAnio.setEntSituacionFinanciera(null);

		return entFinancieraAnio;
	}

	public EntEntidad getEntEntidad() {
		return this.entEntidad;
	}

	public void setEntEntidad(EntEntidad entEntidad) {
		this.entEntidad = entEntidad;
	}

	public EntIndicador getEntIndicador() {
		return this.entIndicador;
	}

	public void setEntIndicador(EntIndicador entIndicador) {
		this.entIndicador = entIndicador;
	}

}