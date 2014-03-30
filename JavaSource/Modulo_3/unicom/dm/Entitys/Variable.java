package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the variable database table.
 * 
 */
@Entity
public class Variable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VARIABLE_IDVARIABLE_GENERATOR", sequenceName="VARIABLE_ID_VARIABLE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VARIABLE_IDVARIABLE_GENERATOR")
	@Column(name="id_variable")
	private Integer idVariable;

	@Column(name="descripcion_variable")
	private String descripcionVariable;

	@Column(name="estado_variable")
	private Integer estadoVariable;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_estado")
	private Date fechaEstado;

	@Column(name="puntaje_max")
	private Integer puntajeMax;

	//bi-directional many-to-one association to Descriptore
	@OneToMany(mappedBy="variable")
	private List<Descriptores> descriptores;

	//bi-directional many-to-one association to TipoVariableEvaluacion
	@ManyToOne
	@JoinColumn(name="id_tipo_variable")
	private TipoVariableEvaluacion tipoVariableEvaluacion;

	//bi-directional many-to-one association to Variable
	@ManyToOne
	@JoinColumn(name="var_id_variable")
	private Variable variable;

	//bi-directional many-to-one association to Variable
	@OneToMany(mappedBy="variable")
	private List<Variable> variables;

	public Variable() {
	}

	public Integer getIdVariable() {
		return this.idVariable;
	}

	public void setIdVariable(Integer idVariable) {
		this.idVariable = idVariable;
	}

	public String getDescripcionVariable() {
		return this.descripcionVariable;
	}

	public void setDescripcionVariable(String descripcionVariable) {
		this.descripcionVariable = descripcionVariable;
	}

	public Integer getEstadoVariable() {
		return this.estadoVariable;
	}

	public void setEstadoVariable(Integer estadoVariable) {
		this.estadoVariable = estadoVariable;
	}

	public Date getFechaEstado() {
		return this.fechaEstado;
	}

	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	public Integer getPuntajeMax() {
		return this.puntajeMax;
	}

	public void setPuntajeMax(Integer puntajeMax) {
		this.puntajeMax = puntajeMax;
	}

	public List<Descriptores> getDescriptores() {
		return this.descriptores;
	}

	public void setDescriptores(List<Descriptores> descriptores) {
		this.descriptores = descriptores;
	}

	public Descriptores addDescriptore(Descriptores descriptore) {
		getDescriptores().add(descriptore);
		descriptore.setVariable(this);

		return descriptore;
	}

	public Descriptores removeDescriptore(Descriptores descriptore) {
		getDescriptores().remove(descriptore);
		descriptore.setVariable(null);

		return descriptore;
	}

	public TipoVariableEvaluacion getTipoVariableEvaluacion() {
		return this.tipoVariableEvaluacion;
	}

	public void setTipoVariableEvaluacion(TipoVariableEvaluacion tipoVariableEvaluacion) {
		this.tipoVariableEvaluacion = tipoVariableEvaluacion;
	}

	public Variable getVariable() {
		return this.variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	public List<Variable> getVariables() {
		return this.variables;
	}

	public void setVariables(List<Variable> variables) {
		this.variables = variables;
	}

	public Variable addVariable(Variable variable) {
		getVariables().add(variable);
		variable.setVariable(this);

		return variable;
	}

	public Variable removeVariable(Variable variable) {
		getVariables().remove(variable);
		variable.setVariable(null);

		return variable;
	}

}