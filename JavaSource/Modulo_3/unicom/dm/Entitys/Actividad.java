package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the actividad database table.
 * 
 */
@Entity
@Table(name = "actividad", catalog = "sigpi", schema = "public")
@NamedQueries({
		@NamedQuery(name = "act.findAll", query = "SELECT A FROM Actividad a "),
		@NamedQuery(name = "act.findById", query = "SELECT A FROM Actividad a WHERE a.idActividad=:idActividad "),
		@NamedQuery(name = "act.findByFase", query = "SELECT A FROM Actividad a WHERE a.fase=:fase ORDER BY a.inicio ") })

public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ACTIVIDAD_IDACTIVIDAD_GENERATOR", sequenceName = "ACTIVIDAD_ID_ACTIVIDAD_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTIVIDAD_IDACTIVIDAD_GENERATOR")
	@Column(name = "id_actividad")
	private Integer idActividad;

	@Column(name = "descripcion_actividad")
	private String descripcionActividad;

	@Column(name = "estado_actividad")
	private Integer estadoActividad;

	private Integer fin;

	private Integer inicio;

	@Column(name = "nombre_actividad")
	private String nombreActividad;

	private String observaciones;

	// bi-directional many-to-one association to Fase
	@ManyToOne
	@JoinColumn(name = "id_fase")
	private Fase fase;

	// bi-directional many-to-one association to SeguiResAporte
	@OneToMany(mappedBy = "actividad")
	private List<SeguiResAporte> seguiResAportes;

	public Actividad() {
	}

	public Integer getIdActividad() {
		return this.idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public String getDescripcionActividad() {
		return this.descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	public Integer getEstadoActividad() {
		return this.estadoActividad;
	}

	public void setEstadoActividad(Integer estadoActividad) {
		this.estadoActividad = estadoActividad;
	}

	public Integer getFin() {
		return this.fin;
	}

	public void setFin(Integer fin) {
		this.fin = fin;
	}

	public Integer getInicio() {
		return this.inicio;
	}

	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}

	public String getNombreActividad() {
		return this.nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Fase getFase() {
		return this.fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public List<SeguiResAporte> getSeguiResAportes() {
		return this.seguiResAportes;
	}

	public void setSeguiResAportes(List<SeguiResAporte> seguiResAportes) {
		this.seguiResAportes = seguiResAportes;
	}

	public SeguiResAporte addSeguiResAporte(SeguiResAporte seguiResAporte) {
		getSeguiResAportes().add(seguiResAporte);
		seguiResAporte.setActividad(this);

		return seguiResAporte;
	}

	public SeguiResAporte removeSeguiResAporte(SeguiResAporte seguiResAporte) {
		getSeguiResAportes().remove(seguiResAporte);
		seguiResAporte.setActividad(null);

		return seguiResAporte;
	}

}