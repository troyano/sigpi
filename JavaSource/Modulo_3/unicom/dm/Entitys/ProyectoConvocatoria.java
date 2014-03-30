package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the proyecto_convocatoria database table.
 * 
 */
@Entity
@Table(name="proyecto_convocatoria")
public class ProyectoConvocatoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROYECTO_CONVOCATORIA_IDPROYECTOCONVOCATORIA_GENERATOR", sequenceName="PROYECTO_CONVOCATORIA_ID_PROYECTO_CONVOCATORIA_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROYECTO_CONVOCATORIA_IDPROYECTOCONVOCATORIA_GENERATOR")
	@Column(name="id_proyecto_convocatoria")
	private Integer idProyectoConvocatoria;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_presentacion")
	private Date fechaPresentacion;

	//bi-directional many-to-one association to Convocatoria
	@ManyToOne
	@JoinColumn(name="id_convocatoria")
	private Convocatoria convocatoria;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	public ProyectoConvocatoria() {
	}

	public Integer getIdProyectoConvocatoria() {
		return this.idProyectoConvocatoria;
	}

	public void setIdProyectoConvocatoria(Integer idProyectoConvocatoria) {
		this.idProyectoConvocatoria = idProyectoConvocatoria;
	}

	public Date getFechaPresentacion() {
		return this.fechaPresentacion;
	}

	public void setFechaPresentacion(Date fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

	public Convocatoria getConvocatoria() {
		return this.convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}