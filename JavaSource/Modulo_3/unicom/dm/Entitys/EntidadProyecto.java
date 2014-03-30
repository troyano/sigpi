package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the entidad_proyecto database table.
 * 
 */
@Entity
@Table(name = "entidad_proyecto", catalog = "sigpi", schema = "public")
@NamedQueries({
		@NamedQuery(name = "enp.findAll", query = "SELECT ENP FROM EntidadProyecto enp "),
		@NamedQuery(name = "enp.findById", query = "SELECT ENP FROM EntidadProyecto enp WHERE enp.idEntidadProyecto=:idEntidadProyecto "),
		@NamedQuery(name = "enp.findByProyecto", query = "SELECT ENP FROM EntidadProyecto enp WHERE enp.proyecto=:proyecto ") })
public class EntidadProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ENTIDAD_PROYECTO_IDENTIDADPROYECTO_GENERATOR", sequenceName = "ENTIDAD_PROYECTO_ID_ENTIDAD_PROYECTO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTIDAD_PROYECTO_IDENTIDADPROYECTO_GENERATOR")
	@Column(name = "id_entidad_proyecto")
	private Integer idEntidadProyecto;

	// bi-directional many-to-one association to EntidadPPresupuesto
	@OneToMany(mappedBy = "entidadProyecto")
	private List<EntidadPPresupuesto> entidadPPresupuesto;

	// bi-directional many-to-one association to EntEntidad
	@ManyToOne
	@JoinColumn(name = "id_ent_entidad")
	private EntEntidad entEntidad;

	// bi-directional many-to-one association to EntRolentidad
	@ManyToOne
	@JoinColumn(name = "id_rol_entidad")
	private EntRolentidad entRolentidad;

	// bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	private Proyecto proyecto;

	public EntidadProyecto() {
	}

	public Integer getIdEntidadProyecto() {
		return this.idEntidadProyecto;
	}

	public void setIdEntidadProyecto(Integer idEntidadProyecto) {
		this.idEntidadProyecto = idEntidadProyecto;
	}

	public List<EntidadPPresupuesto> getEntidadPPresupuesto() {
		return this.entidadPPresupuesto;
	}

	public void setEntidadPPresupuesto(
			List<EntidadPPresupuesto> entidadPPresupuesto) {
		this.entidadPPresupuesto = entidadPPresupuesto;
	}

	public EntidadPPresupuesto addEntidadPPresupuesto(
			EntidadPPresupuesto entidadPPresupuesto) {
		getEntidadPPresupuesto().add(entidadPPresupuesto);
		entidadPPresupuesto.setEntidadProyecto(this);

		return entidadPPresupuesto;
	}

	public EntidadPPresupuesto removeEntidadPPresupuesto(
			EntidadPPresupuesto entidadPPresupuesto) {
		getEntidadPPresupuesto().remove(entidadPPresupuesto);
		entidadPPresupuesto.setEntidadProyecto(null);

		return entidadPPresupuesto;
	}

	public EntEntidad getEntEntidad() {
		return this.entEntidad;
	}

	public void setEntEntidad(EntEntidad entEntidad) {
		this.entEntidad = entEntidad;
	}

	public EntRolentidad getEntRolentidad() {
		return this.entRolentidad;
	}

	public void setEntRolentidad(EntRolentidad entRolentidad) {
		this.entRolentidad = entRolentidad;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}