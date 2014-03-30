package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the proyecto_area_investigacion database table.
 * 
 */
@Entity
@Table(name="proyecto_area_investigacion")
public class ProyectoAreaInvestigacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROYECTO_AREA_INVESTIGACION_IDPROYAREA_GENERATOR", sequenceName="PROYECTO_AREA_INVESTIGACION_ID_PROY_AREA_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROYECTO_AREA_INVESTIGACION_IDPROYAREA_GENERATOR")
	@Column(name="id_proy_area")
	private Integer idProyArea;

	@Column(name="id_linea_investigacion")
	private Integer idLineaInvestigacion;

	//bi-directional many-to-one association to AreaInvestigacion
	@ManyToOne
	@JoinColumn(name="id_area_investigacion")
	private AreaInvestigacion areaInvestigacion;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	public ProyectoAreaInvestigacion() {
	}

	public Integer getIdProyArea() {
		return this.idProyArea;
	}

	public void setIdProyArea(Integer idProyArea) {
		this.idProyArea = idProyArea;
	}

	public Integer getIdLineaInvestigacion() {
		return this.idLineaInvestigacion;
	}

	public void setIdLineaInvestigacion(Integer idLineaInvestigacion) {
		this.idLineaInvestigacion = idLineaInvestigacion;
	}

	public AreaInvestigacion getAreaInvestigacion() {
		return this.areaInvestigacion;
	}

	public void setAreaInvestigacion(AreaInvestigacion areaInvestigacion) {
		this.areaInvestigacion = areaInvestigacion;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}