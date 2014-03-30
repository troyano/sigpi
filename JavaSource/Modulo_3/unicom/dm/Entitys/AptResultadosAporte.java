package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the apt_resultados_aportes database table.
 * 
 */
@Entity
@Table(name="apt_resultados_aportes")
public class AptResultadosAporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="APT_RESULTADOS_APORTES_IDRESULTADOSAPT_GENERATOR", sequenceName="APT_RESULTADOS_APORTES_ID_RESULTADOS_APT_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APT_RESULTADOS_APORTES_IDRESULTADOSAPT_GENERATOR")
	@Column(name="id_resultados_apt")
	private Integer idResultadosApt;

	private String beneficiario;

	private String cantidad;

	@Column(name="descripcion_res_con")
	private String descripcionResCon;

	//bi-directional many-to-one association to AptEspesificacion
	@ManyToOne
	@JoinColumn(name="id_especificacion")
	private AptEspesificacion aptEspesificacion;

	//bi-directional many-to-one association to AptTipoResultado
	@ManyToOne
	@JoinColumn(name="id_tipo_resultado")
	private AptTipoResultado aptTipoResultado;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	//bi-directional many-to-one association to SeguiResAporte
	@OneToMany(mappedBy="aptResultadosAportes")
	private List<SeguiResAporte> seguiResAportes;

	public AptResultadosAporte() {
	}

	public Integer getIdResultadosApt() {
		return this.idResultadosApt;
	}

	public void setIdResultadosApt(Integer idResultadosApt) {
		this.idResultadosApt = idResultadosApt;
	}

	public String getBeneficiario() {
		return this.beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcionResCon() {
		return this.descripcionResCon;
	}

	public void setDescripcionResCon(String descripcionResCon) {
		this.descripcionResCon = descripcionResCon;
	}

	public AptEspesificacion getAptEspesificacion() {
		return this.aptEspesificacion;
	}

	public void setAptEspesificacion(AptEspesificacion aptEspesificacion) {
		this.aptEspesificacion = aptEspesificacion;
	}

	public AptTipoResultado getAptTipoResultado() {
		return this.aptTipoResultado;
	}

	public void setAptTipoResultado(AptTipoResultado aptTipoResultado) {
		this.aptTipoResultado = aptTipoResultado;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<SeguiResAporte> getSeguiResAportes() {
		return this.seguiResAportes;
	}

	public void setSeguiResAportes(List<SeguiResAporte> seguiResAportes) {
		this.seguiResAportes = seguiResAportes;
	}

	public SeguiResAporte addSeguiResAporte(SeguiResAporte seguiResAporte) {
		getSeguiResAportes().add(seguiResAporte);
		seguiResAporte.setAptResultadosAportes(this);

		return seguiResAporte;
	}

	public SeguiResAporte removeSeguiResAporte(SeguiResAporte seguiResAporte) {
		getSeguiResAportes().remove(seguiResAporte);
		seguiResAporte.setAptResultadosAportes(null);

		return seguiResAporte;
	}

}