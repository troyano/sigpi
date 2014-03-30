package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ent_sector database table.
 * 
 */
@Entity
@Table(name="ent_sector")
public class EntSector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_SECTOR_IDSECTOR_GENERATOR", sequenceName="ENT_SECTOR_ID_SECTOR_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_SECTOR_IDSECTOR_GENERATOR")
	@Column(name="id_sector")
	private Integer idSector;

	@Column(name="estado_sector")
	private Integer estadoSector;

	@Column(name="nombre_sector")
	private String nombreSector;

	//bi-directional many-to-one association to EntTipoEntidad
	@OneToMany(mappedBy="entSector")
	private List<EntTipoEntidad> entTipoEntidad;

	public EntSector() {
	}

	public Integer getIdSector() {
		return this.idSector;
	}

	public void setIdSector(Integer idSector) {
		this.idSector = idSector;
	}

	public Integer getEstadoSector() {
		return this.estadoSector;
	}

	public void setEstadoSector(Integer estadoSector) {
		this.estadoSector = estadoSector;
	}

	public String getNombreSector() {
		return this.nombreSector;
	}

	public void setNombreSector(String nombreSector) {
		this.nombreSector = nombreSector;
	}

	public List<EntTipoEntidad> getEntTipoEntidad() {
		return this.entTipoEntidad;
	}

	public void setEntTipoEntidad(List<EntTipoEntidad> entTipoEntidad) {
		this.entTipoEntidad = entTipoEntidad;
	}

	public EntTipoEntidad addEntTipoEntidad(EntTipoEntidad entTipoEntidad) {
		getEntTipoEntidad().add(entTipoEntidad);
		entTipoEntidad.setEntSector(this);

		return entTipoEntidad;
	}

	public EntTipoEntidad removeEntTipoEntidad(EntTipoEntidad entTipoEntidad) {
		getEntTipoEntidad().remove(entTipoEntidad);
		entTipoEntidad.setEntSector(null);

		return entTipoEntidad;
	}

}