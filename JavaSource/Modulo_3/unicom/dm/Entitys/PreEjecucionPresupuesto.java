package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the pre_ejecucion_presupuesto database table.
 * 
 */
@Entity
@Table(name="pre_ejecucion_presupuesto")
public class PreEjecucionPresupuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_EJECUCION_PRESUPUESTO_IDEJECUCIONPRESUPUESTO_GENERATOR", sequenceName="PRE_EJECUCION_PRESUPUESTO_ID_EJECUCION_PRESUPUESTO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_EJECUCION_PRESUPUESTO_IDEJECUCIONPRESUPUESTO_GENERATOR")
	@Column(name="id_ejecucion_presupuesto")
	private Integer idEjecucionPresupuesto;

	@Column(name="detalle_gasto")
	private String detalleGasto;

	@Column(name="monto_aprobado")
	private BigDecimal montoAprobado;

	private BigDecimal montoejecutado;

	@Column(name="observaciones_eje_pre")
	private String observacionesEjePre;

	//bi-directional many-to-one association to Presupuesto
	@ManyToOne
	@JoinColumn(name="id_presupuesto")
	private Presupuesto presupuesto;

	public PreEjecucionPresupuesto() {
	}

	public Integer getIdEjecucionPresupuesto() {
		return this.idEjecucionPresupuesto;
	}

	public void setIdEjecucionPresupuesto(Integer idEjecucionPresupuesto) {
		this.idEjecucionPresupuesto = idEjecucionPresupuesto;
	}

	public String getDetalleGasto() {
		return this.detalleGasto;
	}

	public void setDetalleGasto(String detalleGasto) {
		this.detalleGasto = detalleGasto;
	}

	public BigDecimal getMontoAprobado() {
		return this.montoAprobado;
	}

	public void setMontoAprobado(BigDecimal montoAprobado) {
		this.montoAprobado = montoAprobado;
	}

	public BigDecimal getMontoejecutado() {
		return this.montoejecutado;
	}

	public void setMontoejecutado(BigDecimal montoejecutado) {
		this.montoejecutado = montoejecutado;
	}

	public String getObservacionesEjePre() {
		return this.observacionesEjePre;
	}

	public void setObservacionesEjePre(String observacionesEjePre) {
		this.observacionesEjePre = observacionesEjePre;
	}

	public Presupuesto getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

}