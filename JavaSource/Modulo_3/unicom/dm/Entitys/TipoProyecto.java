package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_proyecto database table.
 * 
 */
@Entity
@Table(name="tipo_proyecto")
public class TipoProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_PROYECTO_IDTIPOPROYECTO_GENERATOR", sequenceName="TIPO_PROYECTO_ID_TIPOPROYECTO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_PROYECTO_IDTIPOPROYECTO_GENERATOR")
	@Column(name="id_tipoproyecto")
	private Integer idTipoproyecto;

	@Column(name="descripcion_tipo_proyecto")
	private String descripcionTipoProyecto;

	@Column(name="estado_tipo_proy")
	private Integer estadoTipoProy;

	//bi-directional many-to-one association to Proyecto
	@OneToMany(mappedBy="tipoProyecto")
	private List<Proyecto> proyecto;

	public TipoProyecto() {
	}

	public Integer getIdTipoproyecto() {
		return this.idTipoproyecto;
	}

	public void setIdTipoproyecto(Integer idTipoproyecto) {
		this.idTipoproyecto = idTipoproyecto;
	}

	public String getDescripcionTipoProyecto() {
		return this.descripcionTipoProyecto;
	}

	public void setDescripcionTipoProyecto(String descripcionTipoProyecto) {
		this.descripcionTipoProyecto = descripcionTipoProyecto;
	}

	public Integer getEstadoTipoProy() {
		return this.estadoTipoProy;
	}

	public void setEstadoTipoProy(Integer estadoTipoProy) {
		this.estadoTipoProy = estadoTipoProy;
	}

	public List<Proyecto> getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(List<Proyecto> proyecto) {
		this.proyecto = proyecto;
	}

	public Proyecto addProyecto(Proyecto proyecto) {
		getProyecto().add(proyecto);
		proyecto.setTipoProyecto(this);

		return proyecto;
	}

	public Proyecto removeProyecto(Proyecto proyecto) {
		getProyecto().remove(proyecto);
		proyecto.setTipoProyecto(null);

		return proyecto;
	}

}