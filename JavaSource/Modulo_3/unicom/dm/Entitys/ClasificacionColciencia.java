package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clasificacion_colciencias database table.
 * 
 */
@Entity
@Table(name="clasificacion_colciencias")
public class ClasificacionColciencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLASIFICACION_COLCIENCIAS_IDCLASIFICACIONCOLCIENCIAS_GENERATOR", sequenceName="CLASIFICACION_COLCIENCIAS_ID_CLASIFICACION_COLCIENCIAS_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLASIFICACION_COLCIENCIAS_IDCLASIFICACIONCOLCIENCIAS_GENERATOR")
	@Column(name="id_clasificacion_colciencias")
	private Integer idClasificacionColciencias;

	private String clasificacion;

	@Column(name="estado_clasificacion_col")
	private Integer estadoClasificacionCol;

	//bi-directional many-to-one association to GrupoClasificacion
	@OneToMany(mappedBy="clasificacionColciencia")
	private List<GrupoClasificacion> grupoClasificacions;

	public ClasificacionColciencia() {
	}

	public Integer getIdClasificacionColciencias() {
		return this.idClasificacionColciencias;
	}

	public void setIdClasificacionColciencias(Integer idClasificacionColciencias) {
		this.idClasificacionColciencias = idClasificacionColciencias;
	}

	public String getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Integer getEstadoClasificacionCol() {
		return this.estadoClasificacionCol;
	}

	public void setEstadoClasificacionCol(Integer estadoClasificacionCol) {
		this.estadoClasificacionCol = estadoClasificacionCol;
	}

	public List<GrupoClasificacion> getGrupoClasificacions() {
		return this.grupoClasificacions;
	}

	public void setGrupoClasificacions(List<GrupoClasificacion> grupoClasificacions) {
		this.grupoClasificacions = grupoClasificacions;
	}

	public GrupoClasificacion addGrupoClasificacion(GrupoClasificacion grupoClasificacion) {
		getGrupoClasificacions().add(grupoClasificacion);
		grupoClasificacion.setClasificacionColciencia(this);

		return grupoClasificacion;
	}

	public GrupoClasificacion removeGrupoClasificacion(GrupoClasificacion grupoClasificacion) {
		getGrupoClasificacions().remove(grupoClasificacion);
		grupoClasificacion.setClasificacionColciencia(null);

		return grupoClasificacion;
	}

}