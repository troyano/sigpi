package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the segui_res_aportes database table.
 * 
 */
@Entity
@Table(name="segui_res_aportes")
public class SeguiResAporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEGUI_RES_APORTES_IDACTIVIDADRESULTADOS_GENERATOR", sequenceName="SEGUI_RES_APORTES_ID_ACTIVIDAD_RESULTADOS_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEGUI_RES_APORTES_IDACTIVIDADRESULTADOS_GENERATOR")
	@Column(name="id_actividad_resultados")
	private Integer idActividadResultados;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_seg")
	private Date fechaSeg;

	private BigDecimal indicador;

	private String observaciones;

	@Column(name="resultados_obtenidos")
	private String resultadosObtenidos;

	//bi-directional many-to-one association to AnexosResultado
	@OneToMany(mappedBy="seguiResAportes")
	private List<AnexosResultado> anexosResultados;

	//bi-directional many-to-one association to Actividad
	@ManyToOne
	@JoinColumn(name="id_actividad")
	private Actividad actividad;

	//bi-directional many-to-one association to AptResultadosAporte
	@ManyToOne
	@JoinColumn(name="id_resultados_apt")
	private AptResultadosAporte aptResultadosAportes;

	public SeguiResAporte() {
	}

	public Integer getIdActividadResultados() {
		return this.idActividadResultados;
	}

	public void setIdActividadResultados(Integer idActividadResultados) {
		this.idActividadResultados = idActividadResultados;
	}

	public Date getFechaSeg() {
		return this.fechaSeg;
	}

	public void setFechaSeg(Date fechaSeg) {
		this.fechaSeg = fechaSeg;
	}

	public BigDecimal getIndicador() {
		return this.indicador;
	}

	public void setIndicador(BigDecimal indicador) {
		this.indicador = indicador;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getResultadosObtenidos() {
		return this.resultadosObtenidos;
	}

	public void setResultadosObtenidos(String resultadosObtenidos) {
		this.resultadosObtenidos = resultadosObtenidos;
	}

	public List<AnexosResultado> getAnexosResultados() {
		return this.anexosResultados;
	}

	public void setAnexosResultados(List<AnexosResultado> anexosResultados) {
		this.anexosResultados = anexosResultados;
	}

	public AnexosResultado addAnexosResultado(AnexosResultado anexosResultado) {
		getAnexosResultados().add(anexosResultado);
		anexosResultado.setSeguiResAportes(this);

		return anexosResultado;
	}

	public AnexosResultado removeAnexosResultado(AnexosResultado anexosResultado) {
		getAnexosResultados().remove(anexosResultado);
		anexosResultado.setSeguiResAportes(null);

		return anexosResultado;
	}

	public Actividad getActividad() {
		return this.actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public AptResultadosAporte getAptResultadosAportes() {
		return this.aptResultadosAportes;
	}

	public void setAptResultadosAportes(AptResultadosAporte aptResultadosAportes) {
		this.aptResultadosAportes = aptResultadosAportes;
	}

}