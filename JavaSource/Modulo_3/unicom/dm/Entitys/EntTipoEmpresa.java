package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ent_tipo_empresa database table.
 * 
 */
@Entity
@Table(name="ent_tipo_empresa")
public class EntTipoEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_TIPO_EMPRESA_IDTIPOEMPRESA_GENERATOR", sequenceName="ENT_TIPO_EMPRESA_ID_TIPO_EMPRESA_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_TIPO_EMPRESA_IDTIPOEMPRESA_GENERATOR")
	@Column(name="id_tipo_empresa")
	private Integer idTipoEmpresa;

	@Column(name="descripcion_tipo")
	private String descripcionTipo;

	@Column(name="estado_tipo_empre")
	private Integer estadoTipoEmpre;

	//bi-directional many-to-one association to EntEntidad
	@OneToMany(mappedBy="entTipoEmpresa")
	private List<EntEntidad> entEntidad;

	public EntTipoEmpresa() {
	}

	public Integer getIdTipoEmpresa() {
		return this.idTipoEmpresa;
	}

	public void setIdTipoEmpresa(Integer idTipoEmpresa) {
		this.idTipoEmpresa = idTipoEmpresa;
	}

	public String getDescripcionTipo() {
		return this.descripcionTipo;
	}

	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}

	public Integer getEstadoTipoEmpre() {
		return this.estadoTipoEmpre;
	}

	public void setEstadoTipoEmpre(Integer estadoTipoEmpre) {
		this.estadoTipoEmpre = estadoTipoEmpre;
	}

	public List<EntEntidad> getEntEntidad() {
		return this.entEntidad;
	}

	public void setEntEntidad(List<EntEntidad> entEntidad) {
		this.entEntidad = entEntidad;
	}

	public EntEntidad addEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().add(entEntidad);
		entEntidad.setEntTipoEmpresa(this);

		return entEntidad;
	}

	public EntEntidad removeEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().remove(entEntidad);
		entEntidad.setEntTipoEmpresa(null);

		return entEntidad;
	}

}