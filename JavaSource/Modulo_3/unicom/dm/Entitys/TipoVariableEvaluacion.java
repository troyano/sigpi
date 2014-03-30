package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_variable_evaluacion database table.
 * 
 */
@Entity
@Table(name="tipo_variable_evaluacion")
public class TipoVariableEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_VARIABLE_EVALUACION_IDTIPOVARIABLE_GENERATOR", sequenceName="TIPO_VARIABLE_EVALUACION_ID_TIPO_VARIABLE_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_VARIABLE_EVALUACION_IDTIPOVARIABLE_GENERATOR")
	@Column(name="id_tipo_variable")
	private Integer idTipoVariable;

	@Column(name="descripcion_tipo_v")
	private String descripcionTipoV;

	@Column(name="estado_tipo_v")
	private Integer estadoTipoV;

	//bi-directional many-to-one association to Variable
	@OneToMany(mappedBy="tipoVariableEvaluacion", cascade={CascadeType.ALL})
	private List<Variable> variable;

	public TipoVariableEvaluacion() {
	}

	public Integer getIdTipoVariable() {
		return this.idTipoVariable;
	}

	public void setIdTipoVariable(Integer idTipoVariable) {
		this.idTipoVariable = idTipoVariable;
	}

	public String getDescripcionTipoV() {
		return this.descripcionTipoV;
	}

	public void setDescripcionTipoV(String descripcionTipoV) {
		this.descripcionTipoV = descripcionTipoV;
	}

	public Integer getEstadoTipoV() {
		return this.estadoTipoV;
	}

	public void setEstadoTipoV(Integer estadoTipoV) {
		this.estadoTipoV = estadoTipoV;
	}

	public List<Variable> getVariable() {
		return this.variable;
	}

	public void setVariable(List<Variable> variable) {
		this.variable = variable;
	}

	public Variable addVariable(Variable variable) {
		getVariable().add(variable);
		variable.setTipoVariableEvaluacion(this);

		return variable;
	}

	public Variable removeVariable(Variable variable) {
		getVariable().remove(variable);
		variable.setTipoVariableEvaluacion(null);

		return variable;
	}

}