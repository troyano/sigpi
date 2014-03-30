package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ent_tamano_entidad database table.
 * 
 */
@Entity
@Table(name="ent_tamano_entidad")
public class EntTamanoEntidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_TAMANO_ENTIDAD_IDTAMANOENTIDAD_GENERATOR", sequenceName="ENT_TAMANO_ENTIDAD_ID_TAMANO_ENTIDAD_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_TAMANO_ENTIDAD_IDTAMANOENTIDAD_GENERATOR")
	@Column(name="id_tamano_entidad")
	private Integer idTamanoEntidad;

	@Column(name="estado_tamano_entid")
	private Integer estadoTamanoEntid;

	private String tamano;

	//bi-directional many-to-one association to EntEntidad
	@OneToMany(mappedBy="entTamanoEntidad")
	private List<EntEntidad> entEntidad;

	public EntTamanoEntidad() {
	}

	public Integer getIdTamanoEntidad() {
		return this.idTamanoEntidad;
	}

	public void setIdTamanoEntidad(Integer idTamanoEntidad) {
		this.idTamanoEntidad = idTamanoEntidad;
	}

	public Integer getEstadoTamanoEntid() {
		return this.estadoTamanoEntid;
	}

	public void setEstadoTamanoEntid(Integer estadoTamanoEntid) {
		this.estadoTamanoEntid = estadoTamanoEntid;
	}

	public String getTamano() {
		return this.tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public List<EntEntidad> getEntEntidad() {
		return this.entEntidad;
	}

	public void setEntEntidad(List<EntEntidad> entEntidad) {
		this.entEntidad = entEntidad;
	}

	public EntEntidad addEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().add(entEntidad);
		entEntidad.setEntTamanoEntidad(this);

		return entEntidad;
	}

	public EntEntidad removeEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().remove(entEntidad);
		entEntidad.setEntTamanoEntidad(null);

		return entEntidad;
	}

}