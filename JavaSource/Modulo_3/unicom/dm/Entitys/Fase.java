package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the fase database table.
 * 
 */
@Entity
@Table(name = "fase", catalog = "sigpi", schema = "public")
@NamedQueries({
		@NamedQuery(name = "fase.findAll", query = "SELECT F FROM Fase f "),
		@NamedQuery(name = "fase.findById", query = "SELECT F FROM Fase f WHERE f.idFase=:idFase "),
		@NamedQuery(name = "fase.findByProyecto", query = "SELECT F FROM Fase f WHERE f.proyecto=:proyecto ORDER BY f.consecutivoFase ") })
public class Fase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "FASE_IDFASE_GENERATOR", sequenceName = "FASE_ID_FASE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FASE_IDFASE_GENERATOR")
	@Column(name = "id_fase")
	private Integer idFase;

	@Column(name = "consecutivo_fase")
	private String consecutivoFase;

	@Column(name = "descripcion_fase")
	private String descripcionFase;

	@Column(name = "estado_fase")
	private Integer estadoFase;

	@Temporal(TemporalType.DATE)
	@Column(name = "fas_fechafin")
	private Date fasFechafin;

	@Temporal(TemporalType.DATE)
	@Column(name = "fas_fechainicio")
	private Date fasFechainicio;

	@Column(name = "nombre_fase")
	private String nombreFase;

	// bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy = "fase", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Actividad> actividad;

	// bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	private Proyecto proyecto;

	public Fase() {
	}

	public Integer getIdFase() {
		return this.idFase;
	}

	public void setIdFase(Integer idFase) {
		this.idFase = idFase;
	}

	public String getConsecutivoFase() {
		return this.consecutivoFase;
	}

	public void setConsecutivoFase(String consecutivoFase) {
		this.consecutivoFase = consecutivoFase;
	}

	public String getDescripcionFase() {
		return this.descripcionFase;
	}

	public void setDescripcionFase(String descripcionFase) {
		this.descripcionFase = descripcionFase;
	}

	public Integer getEstadoFase() {
		return this.estadoFase;
	}

	public void setEstadoFase(Integer estadoFase) {
		this.estadoFase = estadoFase;
	}

	public Date getFasFechafin() {
		return this.fasFechafin;
	}

	public void setFasFechafin(Date fasFechafin) {
		this.fasFechafin = fasFechafin;
	}

	public Date getFasFechainicio() {
		return this.fasFechainicio;
	}

	public void setFasFechainicio(Date fasFechainicio) {
		this.fasFechainicio = fasFechainicio;
	}

	public String getNombreFase() {
		return this.nombreFase;
	}

	public void setNombreFase(String nombreFase) {
		this.nombreFase = nombreFase;
	}

	public List<Actividad> getActividad() {
		return this.actividad;
	}

	public void setActividad(List<Actividad> actividad) {
		this.actividad = actividad;
	}

	public Actividad addActividad(Actividad actividad) {
		getActividad().add(actividad);
		actividad.setFase(this);

		return actividad;
	}

	public Actividad removeActividad(Actividad actividad) {
		getActividad().remove(actividad);
		actividad.setFase(null);

		return actividad;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}