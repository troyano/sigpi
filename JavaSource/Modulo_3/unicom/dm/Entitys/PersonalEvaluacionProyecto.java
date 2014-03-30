package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the personal_evaluacion_proyecto database table.
 * 
 */
@Entity
@Table(name="personal_evaluacion_proyecto")
public class PersonalEvaluacionProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSONAL_EVALUACION_PROYECTO_IDPERSONALEVALPROYECTO_GENERATOR", sequenceName="PERSONAL_EVALUACION_PROYECTO_ID_PERSONAL_EVAL_PROYECTO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONAL_EVALUACION_PROYECTO_IDPERSONALEVALPROYECTO_GENERATOR")
	@Column(name="id_personal_eval_proyecto")
	private Integer idPersonalEvalProyecto;

	@Column(name="calidad_coerencia")
	private String calidadCoerencia;

	private String cargo;

	private String empresa;

	@Column(name="estado_envio")
	private Integer estadoEnvio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_asignacion")
	private Date fechaInicioAsignacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_respuesta")
	private Date fechaRespuesta;

	private String observaciones;

	private String pertinencia;

	@Column(name="valor_agregado")
	private String valorAgregado;

	private String viabilidad;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="id_personal")
	private Personal personal;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	//bi-directional many-to-one association to PuntajeRevisor
	@OneToMany(mappedBy="personalEvaluacionProyecto")
	private List<PuntajeRevisor> puntajeRevisor;

	public PersonalEvaluacionProyecto() {
	}

	public Integer getIdPersonalEvalProyecto() {
		return this.idPersonalEvalProyecto;
	}

	public void setIdPersonalEvalProyecto(Integer idPersonalEvalProyecto) {
		this.idPersonalEvalProyecto = idPersonalEvalProyecto;
	}

	public String getCalidadCoerencia() {
		return this.calidadCoerencia;
	}

	public void setCalidadCoerencia(String calidadCoerencia) {
		this.calidadCoerencia = calidadCoerencia;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Integer getEstadoEnvio() {
		return this.estadoEnvio;
	}

	public void setEstadoEnvio(Integer estadoEnvio) {
		this.estadoEnvio = estadoEnvio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicioAsignacion() {
		return this.fechaInicioAsignacion;
	}

	public void setFechaInicioAsignacion(Date fechaInicioAsignacion) {
		this.fechaInicioAsignacion = fechaInicioAsignacion;
	}

	public Date getFechaRespuesta() {
		return this.fechaRespuesta;
	}

	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPertinencia() {
		return this.pertinencia;
	}

	public void setPertinencia(String pertinencia) {
		this.pertinencia = pertinencia;
	}

	public String getValorAgregado() {
		return this.valorAgregado;
	}

	public void setValorAgregado(String valorAgregado) {
		this.valorAgregado = valorAgregado;
	}

	public String getViabilidad() {
		return this.viabilidad;
	}

	public void setViabilidad(String viabilidad) {
		this.viabilidad = viabilidad;
	}

	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<PuntajeRevisor> getPuntajeRevisor() {
		return this.puntajeRevisor;
	}

	public void setPuntajeRevisor(List<PuntajeRevisor> puntajeRevisor) {
		this.puntajeRevisor = puntajeRevisor;
	}

	public PuntajeRevisor addPuntajeRevisor(PuntajeRevisor puntajeRevisor) {
		getPuntajeRevisor().add(puntajeRevisor);
		puntajeRevisor.setPersonalEvaluacionProyecto(this);

		return puntajeRevisor;
	}

	public PuntajeRevisor removePuntajeRevisor(PuntajeRevisor puntajeRevisor) {
		getPuntajeRevisor().remove(puntajeRevisor);
		puntajeRevisor.setPersonalEvaluacionProyecto(null);

		return puntajeRevisor;
	}

}