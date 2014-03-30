package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the ent_indicador database table.
 * 
 */
@Entity
@Table(name="ent_indicador",catalog="sigpi",schema="public")
@NamedQueries({
	@NamedQuery(name = "ind.findAll", query = "SELECT IND FROM EntIndicador ind"),
	@NamedQuery(name = "ind.findById", query = "SELECT IND FROM EntIndicador ind WHERE ind.idIndicador = :idIndicador"),
	@NamedQuery(name = "ind.findByVariable", query = "SELECT IND FROM EntIndicador ind  WHERE ind.entVariable = :entVariable"),
	@NamedQuery(name = "ind.findByVariableNoR", query = "SELECT IND FROM EntIndicador ind  WHERE ind.entVariable = :entVariable AND NOT EXISTS (SELECT SF FROM EntSituacionFinanciera sf WHERE ind.idIndicador = sf.entIndicador AND sf.entEntidad = :entEntidad)")})

public class EntIndicador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_INDICADOR_IDINDICADOR_GENERATOR", sequenceName="ENT_INDICADOR_ID_INDICADOR_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_INDICADOR_IDINDICADOR_GENERATOR")
	@Column(name="id_indicador")
	private Integer idIndicador;

	@Column(name="descripcion_indicador")
	private String descripcionIndicador;

	@Column(name="estado_indicador")
	private Integer estadoIndicador;

	//bi-directional many-to-one association to EntVariable
	@ManyToOne
	@JoinColumn(name="id_variable")
	private EntVariable entVariable;

	//bi-directional many-to-one association to EntSituacionFinanciera
	@OneToMany(mappedBy="entIndicador")
	private List<EntSituacionFinanciera> entSituacionFinanciera;

	public EntIndicador() {
	}

	public Integer getIdIndicador() {
		return this.idIndicador;
	}

	public void setIdIndicador(Integer idIndicador) {
		this.idIndicador = idIndicador;
	}

	public String getDescripcionIndicador() {
		return this.descripcionIndicador;
	}

	public void setDescripcionIndicador(String descripcionIndicador) {
		this.descripcionIndicador = descripcionIndicador;
	}

	public Integer getEstadoIndicador() {
		return this.estadoIndicador;
	}

	public void setEstadoIndicador(Integer estadoIndicador) {
		this.estadoIndicador = estadoIndicador;
	}

	public EntVariable getEntVariable() {
		return this.entVariable;
	}

	public void setEntVariable(EntVariable entVariable) {
		this.entVariable = entVariable;
	}

	public List<EntSituacionFinanciera> getEntSituacionFinanciera() {
		return this.entSituacionFinanciera;
	}

	public void setEntSituacionFinanciera(List<EntSituacionFinanciera> entSituacionFinanciera) {
		this.entSituacionFinanciera = entSituacionFinanciera;
	}

	public EntSituacionFinanciera addEntSituacionFinanciera(EntSituacionFinanciera entSituacionFinanciera) {
		getEntSituacionFinanciera().add(entSituacionFinanciera);
		entSituacionFinanciera.setEntIndicador(this);

		return entSituacionFinanciera;
	}

	public EntSituacionFinanciera removeEntSituacionFinanciera(EntSituacionFinanciera entSituacionFinanciera) {
		getEntSituacionFinanciera().remove(entSituacionFinanciera);
		entSituacionFinanciera.setEntIndicador(null);

		return entSituacionFinanciera;
	}

}