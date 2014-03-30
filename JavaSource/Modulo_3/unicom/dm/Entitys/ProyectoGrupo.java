package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the proyecto_grupo database table.
 * 
 */
@Entity
@Table(name="proyecto_grupo")
public class ProyectoGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROYECTO_GRUPO_IDPROYECTOGRUPO_GENERATOR", sequenceName="PROYECTO_GRUPO_ID_PROYECTO_GRUPO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROYECTO_GRUPO_IDPROYECTOGRUPO_GENERATOR")
	@Column(name="id_proyecto_grupo")
	private Integer idProyectoGrupo;

	//bi-directional many-to-one association to GrupoInvestigacion
	@ManyToOne
	@JoinColumn(name="id_grupo_investigacion")
	private GrupoInvestigacion grupoInvestigacion;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	public ProyectoGrupo() {
	}

	public Integer getIdProyectoGrupo() {
		return this.idProyectoGrupo;
	}

	public void setIdProyectoGrupo(Integer idProyectoGrupo) {
		this.idProyectoGrupo = idProyectoGrupo;
	}

	public GrupoInvestigacion getGrupoInvestigacion() {
		return this.grupoInvestigacion;
	}

	public void setGrupoInvestigacion(GrupoInvestigacion grupoInvestigacion) {
		this.grupoInvestigacion = grupoInvestigacion;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}