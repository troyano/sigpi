package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ent_tipo_entidad database table.
 * 
 */
@Entity
@Table(name="ent_tipo_entidad",catalog="sigpi",schema="public")
@NamedQueries({
	@NamedQuery(name = "te.findAll", query = "SELECT TE FROM EntTipoEntidad te"),
	@NamedQuery(name = "te.findById", query = "SELECT TE FROM EntTipoEntidad te WHERE te.idTipoentidad = :idTipoentidad"),
	@NamedQuery(name = "te.findBySector", query = "SELECT TE FROM EntTipoEntidad te WHERE  te.entSector = :entSector")})

public class EntTipoEntidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_TIPO_ENTIDAD_IDTIPOENTIDAD_GENERATOR", sequenceName="ENT_TIPO_ENTIDAD_ID_TIPOENTIDAD_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_TIPO_ENTIDAD_IDTIPOENTIDAD_GENERATOR")
	@Column(name="id_tipoentidad")
	private Integer idTipoentidad;

	@Column(name="descripcion_entidad")
	private String descripcionEntidad;

	@Column(name="estado_tipo_entidad")
	private Integer estadoTipoEntidad;

	//bi-directional many-to-one association to EntEntidad
	@OneToMany(mappedBy="entTipoEntidad")
	private List<EntEntidad> entEntidad;

	//bi-directional many-to-one association to EntSector
	@ManyToOne
	@JoinColumn(name="id_sector")
	private EntSector entSector;

	public EntTipoEntidad() {
	}

	public Integer getIdTipoentidad() {
		return this.idTipoentidad;
	}

	public void setIdTipoentidad(Integer idTipoentidad) {
		this.idTipoentidad = idTipoentidad;
	}

	public String getDescripcionEntidad() {
		return this.descripcionEntidad;
	}

	public void setDescripcionEntidad(String descripcionEntidad) {
		this.descripcionEntidad = descripcionEntidad;
	}

	public Integer getEstadoTipoEntidad() {
		return this.estadoTipoEntidad;
	}

	public void setEstadoTipoEntidad(Integer estadoTipoEntidad) {
		this.estadoTipoEntidad = estadoTipoEntidad;
	}

	public List<EntEntidad> getEntEntidad() {
		return this.entEntidad;
	}

	public void setEntEntidad(List<EntEntidad> entEntidad) {
		this.entEntidad = entEntidad;
	}

	public EntEntidad addEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().add(entEntidad);
		entEntidad.setEntTipoEntidad(this);

		return entEntidad;
	}

	public EntEntidad removeEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().remove(entEntidad);
		entEntidad.setEntTipoEntidad(null);

		return entEntidad;
	}

	public EntSector getEntSector() {
		return this.entSector;
	}

	public void setEntSector(EntSector entSector) {
		this.entSector = entSector;
	}

}