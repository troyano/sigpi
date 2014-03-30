package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the apt_impacto database table.
 * 
 */
@Entity
@Table(name="apt_impacto")
public class AptImpacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="APT_IMPACTO_IDIMPACTO_GENERATOR", sequenceName="APT_IMPACTO_ID_IMPACTO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APT_IMPACTO_IDIMPACTO_GENERATOR")
	@Column(name="id_impacto")
	private Integer idImpacto;

	@Temporal(TemporalType.DATE)
	@Column(name="anio_c")
	private Date anioC;

	@Temporal(TemporalType.DATE)
	@Column(name="anio_l")
	private Date anioL;

	@Temporal(TemporalType.DATE)
	@Column(name="anio_m")
	private Date anioM;

	@Column(name="descripcion_c")
	private String descripcionC;

	@Column(name="descripcion_l")
	private String descripcionL;

	@Column(name="descripcion_m")
	private String descripcionM;

	@Column(name="estado_impacto")
	private Integer estadoImpacto;

	private String evidencias;

	//bi-directional one-to-one association to AnexosImpacto
	@OneToOne(mappedBy="aptImpacto")
	private AnexosImpacto anexosImpacto;

	//bi-directional many-to-one association to AptTipoImpacto
	@ManyToOne
	@JoinColumn(name="id_tipo_impacto")
	private AptTipoImpacto aptTipoImpacto;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	public AptImpacto() {
	}

	public Integer getIdImpacto() {
		return this.idImpacto;
	}

	public void setIdImpacto(Integer idImpacto) {
		this.idImpacto = idImpacto;
	}

	public Date getAnioC() {
		return this.anioC;
	}

	public void setAnioC(Date anioC) {
		this.anioC = anioC;
	}

	public Date getAnioL() {
		return this.anioL;
	}

	public void setAnioL(Date anioL) {
		this.anioL = anioL;
	}

	public Date getAnioM() {
		return this.anioM;
	}

	public void setAnioM(Date anioM) {
		this.anioM = anioM;
	}

	public String getDescripcionC() {
		return this.descripcionC;
	}

	public void setDescripcionC(String descripcionC) {
		this.descripcionC = descripcionC;
	}

	public String getDescripcionL() {
		return this.descripcionL;
	}

	public void setDescripcionL(String descripcionL) {
		this.descripcionL = descripcionL;
	}

	public String getDescripcionM() {
		return this.descripcionM;
	}

	public void setDescripcionM(String descripcionM) {
		this.descripcionM = descripcionM;
	}

	public Integer getEstadoImpacto() {
		return this.estadoImpacto;
	}

	public void setEstadoImpacto(Integer estadoImpacto) {
		this.estadoImpacto = estadoImpacto;
	}

	public String getEvidencias() {
		return this.evidencias;
	}

	public void setEvidencias(String evidencias) {
		this.evidencias = evidencias;
	}

	public AnexosImpacto getAnexosImpacto() {
		return this.anexosImpacto;
	}

	public void setAnexosImpacto(AnexosImpacto anexosImpacto) {
		this.anexosImpacto = anexosImpacto;
	}

	public AptTipoImpacto getAptTipoImpacto() {
		return this.aptTipoImpacto;
	}

	public void setAptTipoImpacto(AptTipoImpacto aptTipoImpacto) {
		this.aptTipoImpacto = aptTipoImpacto;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}