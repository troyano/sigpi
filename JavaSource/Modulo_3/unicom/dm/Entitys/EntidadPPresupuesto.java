package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the entidad_p_presupuesto database table.
 * 
 */
@Entity
@Table(name="entidad_p_presupuesto")
public class EntidadPPresupuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENTIDAD_P_PRESUPUESTO_IDENTIDADPPRESUPUESTO_GENERATOR", sequenceName="ENTIDAD_P_PRESUPUESTO_ID_ENTIDAD_P_PRESUPUESTO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENTIDAD_P_PRESUPUESTO_IDENTIDADPPRESUPUESTO_GENERATOR")
	@Column(name="id_entidad_p_presupuesto")
	private Integer idEntidadPPresupuesto;

	private BigDecimal efectivo;

	private BigDecimal especie;

	@Column(name="valor_total_entidad")
	private BigDecimal valorTotalEntidad;

	//bi-directional many-to-one association to EntidadProyecto
	@ManyToOne
	@JoinColumn(name="id_entidad_proyecto")
	private EntidadProyecto entidadProyecto;

	//bi-directional many-to-one association to Presupuesto
	@ManyToOne
	@JoinColumn(name="id_presupuesto")
	private Presupuesto presupuesto;

	public EntidadPPresupuesto() {
	}

	public Integer getIdEntidadPPresupuesto() {
		return this.idEntidadPPresupuesto;
	}

	public void setIdEntidadPPresupuesto(Integer idEntidadPPresupuesto) {
		this.idEntidadPPresupuesto = idEntidadPPresupuesto;
	}

	public BigDecimal getEfectivo() {
		return this.efectivo;
	}

	public void setEfectivo(BigDecimal efectivo) {
		this.efectivo = efectivo;
	}

	public BigDecimal getEspecie() {
		return this.especie;
	}

	public void setEspecie(BigDecimal especie) {
		this.especie = especie;
	}

	public BigDecimal getValorTotalEntidad() {
		return this.valorTotalEntidad;
	}

	public void setValorTotalEntidad(BigDecimal valorTotalEntidad) {
		this.valorTotalEntidad = valorTotalEntidad;
	}

	public EntidadProyecto getEntidadProyecto() {
		return this.entidadProyecto;
	}

	public void setEntidadProyecto(EntidadProyecto entidadProyecto) {
		this.entidadProyecto = entidadProyecto;
	}

	public Presupuesto getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

}