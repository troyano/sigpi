package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the puntaje_revisor database table.
 * 
 */
@Entity
@Table(name="puntaje_revisor")
public class PuntajeRevisor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PUNTAJE_REVISOR_IDEVALUACION_GENERATOR", sequenceName="PUNTAJE_REVISOR_ID_EVALUACION_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PUNTAJE_REVISOR_IDEVALUACION_GENERATOR")
	@Column(name="id_evaluacion")
	private Integer idEvaluacion;

	private String observacion;

	@Column(name="puntaje_asignado")
	private Integer puntajeAsignado;

	//bi-directional many-to-one association to Descriptore
	@ManyToOne
	@JoinColumn(name="id_descriptores")
	private Descriptores descriptores;

	//bi-directional many-to-one association to PersonalEvaluacionProyecto
	@ManyToOne
	@JoinColumn(name="id_personal_eval_proyecto")
	private PersonalEvaluacionProyecto personalEvaluacionProyecto;

	public PuntajeRevisor() {
	}

	public Integer getIdEvaluacion() {
		return this.idEvaluacion;
	}

	public void setIdEvaluacion(Integer idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getPuntajeAsignado() {
		return this.puntajeAsignado;
	}

	public void setPuntajeAsignado(Integer puntajeAsignado) {
		this.puntajeAsignado = puntajeAsignado;
	}

	public Descriptores getDescriptores() {
		return this.descriptores;
	}

	public void setDescriptores(Descriptores descriptores) {
		this.descriptores = descriptores;
	}

	public PersonalEvaluacionProyecto getPersonalEvaluacionProyecto() {
		return this.personalEvaluacionProyecto;
	}

	public void setPersonalEvaluacionProyecto(PersonalEvaluacionProyecto personalEvaluacionProyecto) {
		this.personalEvaluacionProyecto = personalEvaluacionProyecto;
	}

}