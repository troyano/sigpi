package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ent_variable database table.
 * 
 */
@Entity
@Table(name="ent_variable")
public class EntVariable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_VARIABLE_IDVARIABLE_GENERATOR", sequenceName="ENT_VARIABLE_ID_VARIABLE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_VARIABLE_IDVARIABLE_GENERATOR")
	@Column(name="id_variable")
	private Integer idVariable;

	@Column(name="descripcion_variable")
	private String descripcionVariable;

	@Column(name="estado_variable")
	private Integer estadoVariable;

	//bi-directional many-to-one association to EntIndicador
	@OneToMany(mappedBy="entVariable")
	private List<EntIndicador> entIndicador;

	public EntVariable() {
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

	public List<EntIndicador> getEntIndicador() {
		return this.entIndicador;
	}

	public void setEntIndicador(List<EntIndicador> entIndicador) {
		this.entIndicador = entIndicador;
	}

	public EntIndicador addEntIndicador(EntIndicador entIndicador) {
		getEntIndicador().add(entIndicador);
		entIndicador.setEntVariable(this);

		return entIndicador;
	}

	public EntIndicador removeEntIndicador(EntIndicador entIndicador) {
		getEntIndicador().remove(entIndicador);
		entIndicador.setEntVariable(null);

		return entIndicador;
	}

}