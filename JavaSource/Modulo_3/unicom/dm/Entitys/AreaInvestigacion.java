package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the area_investigacion database table.
 * 
 */
@Entity
@Table(name="area_investigacion")
public class AreaInvestigacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AREA_INVESTIGACION_IDAREAINVESTIGACION_GENERATOR", sequenceName="AREA_INVESTIGACION_ID_AREA_INVESTIGACION_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AREA_INVESTIGACION_IDAREAINVESTIGACION_GENERATOR")
	@Column(name="id_area_investigacion")
	private Integer idAreaInvestigacion;

	@Column(name="estado_area_inves")
	private Integer estadoAreaInves;

	@Column(name="nombre_area_investigacion")
	private String nombreAreaInvestigacion;

	//bi-directional many-to-one association to LineaInvestigacion
	@OneToMany(mappedBy="areaInvestigacion")
	private List<LineaInvestigacion> lineaInvestigacion;

	//bi-directional many-to-one association to ProyectoAreaInvestigacion
	@OneToMany(mappedBy="areaInvestigacion")
	private List<ProyectoAreaInvestigacion> proyectoAreaInvestigacion;

	public AreaInvestigacion() {
	}

	public Integer getIdAreaInvestigacion() {
		return this.idAreaInvestigacion;
	}

	public void setIdAreaInvestigacion(Integer idAreaInvestigacion) {
		this.idAreaInvestigacion = idAreaInvestigacion;
	}

	public Integer getEstadoAreaInves() {
		return this.estadoAreaInves;
	}

	public void setEstadoAreaInves(Integer estadoAreaInves) {
		this.estadoAreaInves = estadoAreaInves;
	}

	public String getNombreAreaInvestigacion() {
		return this.nombreAreaInvestigacion;
	}

	public void setNombreAreaInvestigacion(String nombreAreaInvestigacion) {
		this.nombreAreaInvestigacion = nombreAreaInvestigacion;
	}

	public List<LineaInvestigacion> getLineaInvestigacion() {
		return this.lineaInvestigacion;
	}

	public void setLineaInvestigacion(List<LineaInvestigacion> lineaInvestigacion) {
		this.lineaInvestigacion = lineaInvestigacion;
	}

	public LineaInvestigacion addLineaInvestigacion(LineaInvestigacion lineaInvestigacion) {
		getLineaInvestigacion().add(lineaInvestigacion);
		lineaInvestigacion.setAreaInvestigacion(this);

		return lineaInvestigacion;
	}

	public LineaInvestigacion removeLineaInvestigacion(LineaInvestigacion lineaInvestigacion) {
		getLineaInvestigacion().remove(lineaInvestigacion);
		lineaInvestigacion.setAreaInvestigacion(null);

		return lineaInvestigacion;
	}

	public List<ProyectoAreaInvestigacion> getProyectoAreaInvestigacion() {
		return this.proyectoAreaInvestigacion;
	}

	public void setProyectoAreaInvestigacion(List<ProyectoAreaInvestigacion> proyectoAreaInvestigacion) {
		this.proyectoAreaInvestigacion = proyectoAreaInvestigacion;
	}

	public ProyectoAreaInvestigacion addProyectoAreaInvestigacion(ProyectoAreaInvestigacion proyectoAreaInvestigacion) {
		getProyectoAreaInvestigacion().add(proyectoAreaInvestigacion);
		proyectoAreaInvestigacion.setAreaInvestigacion(this);

		return proyectoAreaInvestigacion;
	}

	public ProyectoAreaInvestigacion removeProyectoAreaInvestigacion(ProyectoAreaInvestigacion proyectoAreaInvestigacion) {
		getProyectoAreaInvestigacion().remove(proyectoAreaInvestigacion);
		proyectoAreaInvestigacion.setAreaInvestigacion(null);

		return proyectoAreaInvestigacion;
	}

}