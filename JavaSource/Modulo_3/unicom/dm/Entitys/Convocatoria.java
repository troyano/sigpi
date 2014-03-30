package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the convocatoria database table.
 * 
 */
@Entity
public class Convocatoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONVOCATORIA_IDCONVOCATORIA_GENERATOR", sequenceName="CONVOCATORIA_ID_CONVOCATORIA_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONVOCATORIA_IDCONVOCATORIA_GENERATOR")
	@Column(name="id_convocatoria")
	private Integer idConvocatoria;

	@Column(name="estado_convocatoria")
	private Integer estadoConvocatoria;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_apertura")
	private Date fechaApertura;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cierre")
	private Date fechaCierre;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_publicacion")
	private Date fechaPublicacion;

	@Column(name="nombre_convocatoria")
	private String nombreConvocatoria;

	//bi-directional many-to-one association to ProyectoConvocatoria
	@OneToMany(mappedBy="convocatoria")
	private List<ProyectoConvocatoria> proyectoConvocatoria;

	public Convocatoria() {
	}

	public Integer getIdConvocatoria() {
		return this.idConvocatoria;
	}

	public void setIdConvocatoria(Integer idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}

	public Integer getEstadoConvocatoria() {
		return this.estadoConvocatoria;
	}

	public void setEstadoConvocatoria(Integer estadoConvocatoria) {
		this.estadoConvocatoria = estadoConvocatoria;
	}

	public Date getFechaApertura() {
		return this.fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Date getFechaCierre() {
		return this.fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getNombreConvocatoria() {
		return this.nombreConvocatoria;
	}

	public void setNombreConvocatoria(String nombreConvocatoria) {
		this.nombreConvocatoria = nombreConvocatoria;
	}

	public List<ProyectoConvocatoria> getProyectoConvocatoria() {
		return this.proyectoConvocatoria;
	}

	public void setProyectoConvocatoria(List<ProyectoConvocatoria> proyectoConvocatoria) {
		this.proyectoConvocatoria = proyectoConvocatoria;
	}

	public ProyectoConvocatoria addProyectoConvocatoria(ProyectoConvocatoria proyectoConvocatoria) {
		getProyectoConvocatoria().add(proyectoConvocatoria);
		proyectoConvocatoria.setConvocatoria(this);

		return proyectoConvocatoria;
	}

	public ProyectoConvocatoria removeProyectoConvocatoria(ProyectoConvocatoria proyectoConvocatoria) {
		getProyectoConvocatoria().remove(proyectoConvocatoria);
		proyectoConvocatoria.setConvocatoria(null);

		return proyectoConvocatoria;
	}

}