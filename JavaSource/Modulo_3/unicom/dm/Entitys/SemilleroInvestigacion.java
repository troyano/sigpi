package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the semillero_investigacion database table.
 * 
 */
@Entity
@Table(name="semillero_investigacion")
public class SemilleroInvestigacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEMILLERO_INVESTIGACION_IDSEMILLERO_GENERATOR", sequenceName="SEMILLERO_INVESTIGACION_ID_SEMILLERO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEMILLERO_INVESTIGACION_IDSEMILLERO_GENERATOR")
	@Column(name="id_semillero")
	private Integer idSemillero;

	@Column(name="descripcion_semillero")
	private String descripcionSemillero;

	@Column(name="estado_semillero")
	private String estadoSemillero;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_finalizacion")
	private Date fechaFinalizacion;

	@Column(name="nombre_semillero")
	private String nombreSemillero;

	//bi-directional many-to-one association to GrupoInvestigacion
	@ManyToOne
	@JoinColumn(name="id_grupo_investigacion")
	private GrupoInvestigacion grupoInvestigacion;

	public SemilleroInvestigacion() {
	}

	public Integer getIdSemillero() {
		return this.idSemillero;
	}

	public void setIdSemillero(Integer idSemillero) {
		this.idSemillero = idSemillero;
	}

	public String getDescripcionSemillero() {
		return this.descripcionSemillero;
	}

	public void setDescripcionSemillero(String descripcionSemillero) {
		this.descripcionSemillero = descripcionSemillero;
	}

	public String getEstadoSemillero() {
		return this.estadoSemillero;
	}

	public void setEstadoSemillero(String estadoSemillero) {
		this.estadoSemillero = estadoSemillero;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFinalizacion() {
		return this.fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getNombreSemillero() {
		return this.nombreSemillero;
	}

	public void setNombreSemillero(String nombreSemillero) {
		this.nombreSemillero = nombreSemillero;
	}

	public GrupoInvestigacion getGrupoInvestigacion() {
		return this.grupoInvestigacion;
	}

	public void setGrupoInvestigacion(GrupoInvestigacion grupoInvestigacion) {
		this.grupoInvestigacion = grupoInvestigacion;
	}

}