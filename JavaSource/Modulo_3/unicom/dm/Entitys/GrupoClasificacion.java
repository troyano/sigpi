package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the grupo_clasificacion database table.
 * 
 */
@Entity
@Table(name="grupo_clasificacion")
public class GrupoClasificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GRUPO_CLASIFICACION_IDGRUPOCLASIFICACION_GENERATOR", sequenceName="GRUPO_CLASIFICACION_ID_GRUPO_CLASIFICACION_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRUPO_CLASIFICACION_IDGRUPOCLASIFICACION_GENERATOR")
	@Column(name="id_grupo_clasificacion")
	private Integer idGrupoClasificacion;

	@Column(name="estado_actual")
	private Integer estadoActual;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cambio")
	private Date fechaCambio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	//bi-directional many-to-one association to ClasificacionColciencia
	@ManyToOne
	@JoinColumn(name="id_clasificacion_colciencias")
	private ClasificacionColciencia clasificacionColciencia;

	//bi-directional many-to-one association to GrupoInvestigacion
	@ManyToOne
	@JoinColumn(name="id_grupo_investigacion")
	private GrupoInvestigacion grupoInvestigacion;

	public GrupoClasificacion() {
	}

	public Integer getIdGrupoClasificacion() {
		return this.idGrupoClasificacion;
	}

	public void setIdGrupoClasificacion(Integer idGrupoClasificacion) {
		this.idGrupoClasificacion = idGrupoClasificacion;
	}

	public Integer getEstadoActual() {
		return this.estadoActual;
	}

	public void setEstadoActual(Integer estadoActual) {
		this.estadoActual = estadoActual;
	}

	public Date getFechaCambio() {
		return this.fechaCambio;
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public ClasificacionColciencia getClasificacionColciencia() {
		return this.clasificacionColciencia;
	}

	public void setClasificacionColciencia(ClasificacionColciencia clasificacionColciencia) {
		this.clasificacionColciencia = clasificacionColciencia;
	}

	public GrupoInvestigacion getGrupoInvestigacion() {
		return this.grupoInvestigacion;
	}

	public void setGrupoInvestigacion(GrupoInvestigacion grupoInvestigacion) {
		this.grupoInvestigacion = grupoInvestigacion;
	}

}