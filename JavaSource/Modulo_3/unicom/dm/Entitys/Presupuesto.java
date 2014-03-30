package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the presupuesto database table.
 * 
 */
@Entity
public class Presupuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRESUPUESTO_IDPRESUPUESTO_GENERATOR", sequenceName="PRESUPUESTO_ID_PRESUPUESTO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRESUPUESTO_IDPRESUPUESTO_GENERATOR")
	@Column(name="id_presupuesto")
	private Integer idPresupuesto;

	@Column(name="costo_alimentacion")
	private BigDecimal costoAlimentacion;

	@Column(name="costo_capacitacion")
	private BigDecimal costoCapacitacion;

	@Column(name="costo_estadia")
	private BigDecimal costoEstadia;

	@Column(name="costo_inscripcion")
	private BigDecimal costoInscripcion;

	@Column(name="costo_pasaje")
	private BigDecimal costoPasaje;

	@Column(name="descripcion_presupuesto")
	private String descripcionPresupuesto;

	@Column(name="eventos_divulgacion")
	private String eventosDivulgacion;

	@Column(name="justificacion_presupuesto")
	private String justificacionPresupuesto;

	private String lugar;

	@Column(name="n_personas_cantidad")
	private Integer nPersonasCantidad;

	@Column(name="num_dias")
	private Integer numDias;

	private BigDecimal total;

	@Column(name="valor_hora")
	private BigDecimal valorHora;

	@Column(name="valor_unitario")
	private BigDecimal valorUnitario;

	//bi-directional many-to-one association to EntidadPPresupuesto
	@OneToMany(mappedBy="presupuesto")
	private List<EntidadPPresupuesto> entidadPPresupuesto;

	//bi-directional many-to-one association to PreEjecucionPresupuesto
	@OneToMany(mappedBy="presupuesto")
	private List<PreEjecucionPresupuesto> preEjecucionPresupuesto;

	//bi-directional many-to-one association to PersonalProyecto
	@ManyToOne
	@JoinColumn(name="id_personal_proyecto")
	private PersonalProyecto personalProyecto;

	//bi-directional many-to-one association to PreTipoContrato
	@ManyToOne
	@JoinColumn(name="id_ti_contrato")
	private PreTipoContrato preTipoContrato;

	//bi-directional many-to-one association to PreTipoPresupuesto
	@ManyToOne
	@JoinColumn(name="id_tipo_presupuesto")
	private PreTipoPresupuesto preTipoPresupuesto;

	public Presupuesto() {
	}

	public Integer getIdPresupuesto() {
		return this.idPresupuesto;
	}

	public void setIdPresupuesto(Integer idPresupuesto) {
		this.idPresupuesto = idPresupuesto;
	}

	public BigDecimal getCostoAlimentacion() {
		return this.costoAlimentacion;
	}

	public void setCostoAlimentacion(BigDecimal costoAlimentacion) {
		this.costoAlimentacion = costoAlimentacion;
	}

	public BigDecimal getCostoCapacitacion() {
		return this.costoCapacitacion;
	}

	public void setCostoCapacitacion(BigDecimal costoCapacitacion) {
		this.costoCapacitacion = costoCapacitacion;
	}

	public BigDecimal getCostoEstadia() {
		return this.costoEstadia;
	}

	public void setCostoEstadia(BigDecimal costoEstadia) {
		this.costoEstadia = costoEstadia;
	}

	public BigDecimal getCostoInscripcion() {
		return this.costoInscripcion;
	}

	public void setCostoInscripcion(BigDecimal costoInscripcion) {
		this.costoInscripcion = costoInscripcion;
	}

	public BigDecimal getCostoPasaje() {
		return this.costoPasaje;
	}

	public void setCostoPasaje(BigDecimal costoPasaje) {
		this.costoPasaje = costoPasaje;
	}

	public String getDescripcionPresupuesto() {
		return this.descripcionPresupuesto;
	}

	public void setDescripcionPresupuesto(String descripcionPresupuesto) {
		this.descripcionPresupuesto = descripcionPresupuesto;
	}

	public String getEventosDivulgacion() {
		return this.eventosDivulgacion;
	}

	public void setEventosDivulgacion(String eventosDivulgacion) {
		this.eventosDivulgacion = eventosDivulgacion;
	}

	public String getJustificacionPresupuesto() {
		return this.justificacionPresupuesto;
	}

	public void setJustificacionPresupuesto(String justificacionPresupuesto) {
		this.justificacionPresupuesto = justificacionPresupuesto;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Integer getNPersonasCantidad() {
		return this.nPersonasCantidad;
	}

	public void setNPersonasCantidad(Integer nPersonasCantidad) {
		this.nPersonasCantidad = nPersonasCantidad;
	}

	public Integer getNumDias() {
		return this.numDias;
	}

	public void setNumDias(Integer numDias) {
		this.numDias = numDias;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getValorHora() {
		return this.valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public List<EntidadPPresupuesto> getEntidadPPresupuesto() {
		return this.entidadPPresupuesto;
	}

	public void setEntidadPPresupuesto(List<EntidadPPresupuesto> entidadPPresupuesto) {
		this.entidadPPresupuesto = entidadPPresupuesto;
	}

	public EntidadPPresupuesto addEntidadPPresupuesto(EntidadPPresupuesto entidadPPresupuesto) {
		getEntidadPPresupuesto().add(entidadPPresupuesto);
		entidadPPresupuesto.setPresupuesto(this);

		return entidadPPresupuesto;
	}

	public EntidadPPresupuesto removeEntidadPPresupuesto(EntidadPPresupuesto entidadPPresupuesto) {
		getEntidadPPresupuesto().remove(entidadPPresupuesto);
		entidadPPresupuesto.setPresupuesto(null);

		return entidadPPresupuesto;
	}

	public List<PreEjecucionPresupuesto> getPreEjecucionPresupuesto() {
		return this.preEjecucionPresupuesto;
	}

	public void setPreEjecucionPresupuesto(List<PreEjecucionPresupuesto> preEjecucionPresupuesto) {
		this.preEjecucionPresupuesto = preEjecucionPresupuesto;
	}

	public PreEjecucionPresupuesto addPreEjecucionPresupuesto(PreEjecucionPresupuesto preEjecucionPresupuesto) {
		getPreEjecucionPresupuesto().add(preEjecucionPresupuesto);
		preEjecucionPresupuesto.setPresupuesto(this);

		return preEjecucionPresupuesto;
	}

	public PreEjecucionPresupuesto removePreEjecucionPresupuesto(PreEjecucionPresupuesto preEjecucionPresupuesto) {
		getPreEjecucionPresupuesto().remove(preEjecucionPresupuesto);
		preEjecucionPresupuesto.setPresupuesto(null);

		return preEjecucionPresupuesto;
	}

	public PersonalProyecto getPersonalProyecto() {
		return this.personalProyecto;
	}

	public void setPersonalProyecto(PersonalProyecto personalProyecto) {
		this.personalProyecto = personalProyecto;
	}

	public PreTipoContrato getPreTipoContrato() {
		return this.preTipoContrato;
	}

	public void setPreTipoContrato(PreTipoContrato preTipoContrato) {
		this.preTipoContrato = preTipoContrato;
	}

	public PreTipoPresupuesto getPreTipoPresupuesto() {
		return this.preTipoPresupuesto;
	}

	public void setPreTipoPresupuesto(PreTipoPresupuesto preTipoPresupuesto) {
		this.preTipoPresupuesto = preTipoPresupuesto;
	}

}