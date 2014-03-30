package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the linea_investigacion database table.
 * 
 */
@Entity
@Table(name="linea_investigacion")
public class LineaInvestigacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LINEA_INVESTIGACION_IDLINEAINVESTIGACION_GENERATOR", sequenceName="LINEA_INVESTIGACION_ID_LINEA_INVESTIGACION_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LINEA_INVESTIGACION_IDLINEAINVESTIGACION_GENERATOR")
	@Column(name="id_linea_investigacion")
	private Integer idLineaInvestigacion;

	@Column(name="descripcion_linea_investigacion")
	private String descripcionLineaInvestigacion;

	@Column(name="estado_linea_inv")
	private Integer estadoLineaInv;

	@Column(name="nombre_linea_investigacion")
	private String nombreLineaInvestigacion;

	//bi-directional many-to-one association to AreaInvestigacion
	@ManyToOne
	@JoinColumn(name="id_area_investigacion")
	private AreaInvestigacion areaInvestigacion;

	public LineaInvestigacion() {
	}

	public Integer getIdLineaInvestigacion() {
		return this.idLineaInvestigacion;
	}

	public void setIdLineaInvestigacion(Integer idLineaInvestigacion) {
		this.idLineaInvestigacion = idLineaInvestigacion;
	}

	public String getDescripcionLineaInvestigacion() {
		return this.descripcionLineaInvestigacion;
	}

	public void setDescripcionLineaInvestigacion(String descripcionLineaInvestigacion) {
		this.descripcionLineaInvestigacion = descripcionLineaInvestigacion;
	}

	public Integer getEstadoLineaInv() {
		return this.estadoLineaInv;
	}

	public void setEstadoLineaInv(Integer estadoLineaInv) {
		this.estadoLineaInv = estadoLineaInv;
	}

	public String getNombreLineaInvestigacion() {
		return this.nombreLineaInvestigacion;
	}

	public void setNombreLineaInvestigacion(String nombreLineaInvestigacion) {
		this.nombreLineaInvestigacion = nombreLineaInvestigacion;
	}

	public AreaInvestigacion getAreaInvestigacion() {
		return this.areaInvestigacion;
	}

	public void setAreaInvestigacion(AreaInvestigacion areaInvestigacion) {
		this.areaInvestigacion = areaInvestigacion;
	}

}