package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the ent_rolentidad database table.
 * 
 */
@Entity
@Table(name = "ent_rolentidad", catalog = "sigpi", schema = "public")
@NamedQueries({
		@NamedQuery(name = "rol.findAll", query = "SELECT ROL FROM EntRolentidad rol"),
		@NamedQuery(name = "rol.findById", query = "SELECT ROL FROM EntRolentidad rol WHERE rol.idRolEntidad = :idRolEntidad"),
		@NamedQuery(name = "rol.findByProEntNO", query = "SELECT ROL FROM EntRolentidad rol WHERE NOT EXISTS (SELECT EP FROM EntidadProyecto ep WHERE ep.proyecto=:proyecto AND ep.entEntidad=:entEntidad)"),
		@NamedQuery(name = "rol.findByProEntNOn", query = "SELECT ROL FROM EntRolentidad rol WHERE NOT EXISTS (SELECT EP FROM EntidadProyecto ep WHERE ep.proyecto=:proyecto AND ep.entEntidad=:entEntidad AND ep.entRolentidad=rol.idRolEntidad )") })
public class EntRolentidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ENT_ROLENTIDAD_IDROLENTIDAD_GENERATOR", sequenceName = "ENT_ROLENTIDAD_ID_ROL_ENTIDAD_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENT_ROLENTIDAD_IDROLENTIDAD_GENERATOR")
	@Column(name = "id_rol_entidad")
	private Integer idRolEntidad;

	@Column(name = "descripcion_rolentidad")
	private String descripcionRolentidad;

	@Column(name = "estado_rol_entidad")
	private Integer estadoRolEntidad;

	// bi-directional many-to-one association to EntidadProyecto
	@OneToMany(mappedBy = "entRolentidad")
	private List<EntidadProyecto> entidadProyecto;

	public EntRolentidad() {
	}

	public Integer getIdRolEntidad() {
		return this.idRolEntidad;
	}

	public void setIdRolEntidad(Integer idRolEntidad) {
		this.idRolEntidad = idRolEntidad;
	}

	public String getDescripcionRolentidad() {
		return this.descripcionRolentidad;
	}

	public void setDescripcionRolentidad(String descripcionRolentidad) {
		this.descripcionRolentidad = descripcionRolentidad;
	}

	public Integer getEstadoRolEntidad() {
		return this.estadoRolEntidad;
	}

	public void setEstadoRolEntidad(Integer estadoRolEntidad) {
		this.estadoRolEntidad = estadoRolEntidad;
	}

	public List<EntidadProyecto> getEntidadProyecto() {
		return this.entidadProyecto;
	}

	public void setEntidadProyecto(List<EntidadProyecto> entidadProyecto) {
		this.entidadProyecto = entidadProyecto;
	}

	public EntidadProyecto addEntidadProyecto(EntidadProyecto entidadProyecto) {
		getEntidadProyecto().add(entidadProyecto);
		entidadProyecto.setEntRolentidad(this);

		return entidadProyecto;
	}

	public EntidadProyecto removeEntidadProyecto(EntidadProyecto entidadProyecto) {
		getEntidadProyecto().remove(entidadProyecto);
		entidadProyecto.setEntRolentidad(null);

		return entidadProyecto;
	}

}