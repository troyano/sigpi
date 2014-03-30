package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the grupo_investigacion database table.
 * 
 */
@Entity
@Table(name="grupo_investigacion")
public class GrupoInvestigacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GRUPO_INVESTIGACION_IDGRUPOINVESTIGACION_GENERATOR", sequenceName="GRUPO_INVESTIGACION_ID_GRUPO_INVESTIGACION_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRUPO_INVESTIGACION_IDGRUPOINVESTIGACION_GENERATOR")
	@Column(name="id_grupo_investigacion")
	private Integer idGrupoInvestigacion;

	@Column(name="descripcion_grupo")
	private String descripcionGrupo;

	@Column(name="estado_grupo")
	private Integer estadoGrupo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_finalizacion")
	private Date fechaFinalizacion;

	@Column(name="nombre_grupo")
	private String nombreGrupo;

	//bi-directional many-to-one association to GrupoClasificacion
	@OneToMany(mappedBy="grupoInvestigacion")
	private List<GrupoClasificacion> grupoClasificacion;

	//bi-directional many-to-one association to ProyectoGrupo
	@OneToMany(mappedBy="grupoInvestigacion")
	private List<ProyectoGrupo> proyectoGrupo;

	//bi-directional many-to-one association to SemilleroInvestigacion
	@OneToMany(mappedBy="grupoInvestigacion")
	private List<SemilleroInvestigacion> semilleroInvestigacion;

	public GrupoInvestigacion() {
	}

	public Integer getIdGrupoInvestigacion() {
		return this.idGrupoInvestigacion;
	}

	public void setIdGrupoInvestigacion(Integer idGrupoInvestigacion) {
		this.idGrupoInvestigacion = idGrupoInvestigacion;
	}

	public String getDescripcionGrupo() {
		return this.descripcionGrupo;
	}

	public void setDescripcionGrupo(String descripcionGrupo) {
		this.descripcionGrupo = descripcionGrupo;
	}

	public Integer getEstadoGrupo() {
		return this.estadoGrupo;
	}

	public void setEstadoGrupo(Integer estadoGrupo) {
		this.estadoGrupo = estadoGrupo;
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

	public String getNombreGrupo() {
		return this.nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public List<GrupoClasificacion> getGrupoClasificacion() {
		return this.grupoClasificacion;
	}

	public void setGrupoClasificacion(List<GrupoClasificacion> grupoClasificacion) {
		this.grupoClasificacion = grupoClasificacion;
	}

	public GrupoClasificacion addGrupoClasificacion(GrupoClasificacion grupoClasificacion) {
		getGrupoClasificacion().add(grupoClasificacion);
		grupoClasificacion.setGrupoInvestigacion(this);

		return grupoClasificacion;
	}

	public GrupoClasificacion removeGrupoClasificacion(GrupoClasificacion grupoClasificacion) {
		getGrupoClasificacion().remove(grupoClasificacion);
		grupoClasificacion.setGrupoInvestigacion(null);

		return grupoClasificacion;
	}

	public List<ProyectoGrupo> getProyectoGrupo() {
		return this.proyectoGrupo;
	}

	public void setProyectoGrupo(List<ProyectoGrupo> proyectoGrupo) {
		this.proyectoGrupo = proyectoGrupo;
	}

	public ProyectoGrupo addProyectoGrupo(ProyectoGrupo proyectoGrupo) {
		getProyectoGrupo().add(proyectoGrupo);
		proyectoGrupo.setGrupoInvestigacion(this);

		return proyectoGrupo;
	}

	public ProyectoGrupo removeProyectoGrupo(ProyectoGrupo proyectoGrupo) {
		getProyectoGrupo().remove(proyectoGrupo);
		proyectoGrupo.setGrupoInvestigacion(null);

		return proyectoGrupo;
	}

	public List<SemilleroInvestigacion> getSemilleroInvestigacion() {
		return this.semilleroInvestigacion;
	}

	public void setSemilleroInvestigacion(List<SemilleroInvestigacion> semilleroInvestigacion) {
		this.semilleroInvestigacion = semilleroInvestigacion;
	}

	public SemilleroInvestigacion addSemilleroInvestigacion(SemilleroInvestigacion semilleroInvestigacion) {
		getSemilleroInvestigacion().add(semilleroInvestigacion);
		semilleroInvestigacion.setGrupoInvestigacion(this);

		return semilleroInvestigacion;
	}

	public SemilleroInvestigacion removeSemilleroInvestigacion(SemilleroInvestigacion semilleroInvestigacion) {
		getSemilleroInvestigacion().remove(semilleroInvestigacion);
		semilleroInvestigacion.setGrupoInvestigacion(null);

		return semilleroInvestigacion;
	}

}