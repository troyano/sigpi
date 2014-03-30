package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity
@Table(name = "proyecto", catalog = "sigpi", schema = "public")
@NamedQueries({
		@NamedQuery(name = "pry.findAll", query = "SELECT PRY FROM Proyecto pry"),
		@NamedQuery(name = "pry.findById", query = "SELECT PRY FROM Proyecto pry WHERE pry.idProyecto = :idProyecto"),
		@NamedQuery(name = "pry.findByEstado", query = "SELECT PRY FROM Proyecto pry WHERE pry.estadoProyecto= :estadoProyecto") })

public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PROYECTO_IDPROYECTO_GENERATOR", sequenceName = "PROYECTO_ID_PROYECTO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROYECTO_IDPROYECTO_GENERATOR")
	@Column(name = "id_proyecto")
	private Integer idProyecto;

	@Column(name = "analisis_res_finales")
	private String analisisResFinales;

	@Column(name = "analisis_res_preliminares")
	private String analisisResPreliminares;

	@Column(name = "cmt_metodologia")
	private String cmtMetodologia;

	@Column(name = "cmto_estado_arte")
	private String cmtoEstadoArte;

	@Column(name = "cmto_innovacion")
	private String cmtoInnovacion;

	@Column(name = "cmto_justificacion")
	private String cmtoJustificacion;

	@Column(name = "cmto_marco_teorico")
	private String cmtoMarcoTeorico;

	@Column(name = "cmto_objetivos")
	private String cmtoObjetivos;

	@Column(name = "cmto_problema")
	private String cmtoProblema;

	@Column(name = "cmto_propiedad_intelectual")
	private String cmtoPropiedadIntelectual;

	@Column(name = "cmto_resena_grupo")
	private String cmtoResenaGrupo;

	@Column(name = "cmto_resumen")
	private String cmtoResumen;

	@Column(name = "conclusiones_finales")
	private String conclusionesFinales;

	@Column(name = "concuclisiones_preliminares")
	private String concuclisionesPreliminares;

	private Integer duracion;

	private Integer ejecucion;

	@Column(name = "estado_arte")
	private String estadoArte;

	@Column(name = "estado_proyecto")
	private Integer estadoProyecto;

	@Column(name = "experimentos_estudios")
	private String experimentosEstudios;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio_formulacion")
	private Date fechaInicioFormulacion;

	private String innovacion;

	private String justificacion;

	@Column(name = "marco_teorico")
	private String marcoTeorico;

	private String metodologia;

	@Column(name = "nombre_proyecto")
	private String nombreProyecto;

	private String objetivos;

	private String problema;

	@Column(name = "propiedad_intelectual")
	private String propiedadIntelectual;

	@Column(name = "resena_grupo")
	private String resenaGrupo;

	private String resumen;

	@Column(name = "total_investigadores")
	private Integer totalInvestigadores;

	@Column(name = "trabajos_futuros")
	private String trabajosFuturos;

	@Column(name = "validacion_hipotesis")
	private String validacionHipotesis;

	@Column(name = "valor_total")
	private double valorTotal;

	@Column(name = "ventajas_limitadiones")
	private String ventajasLimitadiones;

	// bi-directional many-to-one association to AnexosGeneral
	@OneToMany(mappedBy = "proyecto")
	private List<AnexosGeneral> anexosGeneral;

	// bi-directional many-to-one association to AptCobertura
	@OneToMany(mappedBy = "proyecto")
	private List<AptCobertura> aptCobertura;

	// bi-directional many-to-one association to AptImpacto
	@OneToMany(mappedBy = "proyecto")
	private List<AptImpacto> aptImpacto;

	// bi-directional many-to-one association to AptResultadosAporte
	@OneToMany(mappedBy = "proyecto")
	private List<AptResultadosAporte> aptResultadosAportes;

	// bi-directional many-to-one association to DisenioMetodo
	@OneToMany(mappedBy = "proyecto")
	private List<DisenioMetodo> disenioMetodo;

	// bi-directional many-to-one association to EntidadProyecto
	@OneToMany(mappedBy = "proyecto")
	private List<EntidadProyecto> entidadProyecto;

	// bi-directional many-to-one association to Fase
	@OneToMany(mappedBy = "proyecto")
	private List<Fase> fase;

	// bi-directional many-to-one association to PalabraClave
	@OneToMany(mappedBy = "proyecto")
	private List<PalabraClave> palabraClave;

	// bi-directional many-to-one association to PersonalEvaluacionProyecto
	@OneToMany(mappedBy = "proyecto")
	private List<PersonalEvaluacionProyecto> personalEvaluacionProyecto;

	// bi-directional many-to-one association to PersonalProyecto
	@OneToMany(mappedBy = "proyecto")
	private List<PersonalProyecto> personalProyecto;

	// bi-directional many-to-one association to EjecucionCronograma
	@ManyToOne
	@JoinColumn(name = "id_ejecucion_cronograma")
	private EjecucionCronograma ejecucionCronograma;

	// bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name = "id_municipio")
	private Municipio municipio;

	// bi-directional many-to-one association to TipoProyecto
	@ManyToOne
	@JoinColumn(name = "id_tipoproyecto")
	private TipoProyecto tipoProyecto;

	// bi-directional many-to-one association to ProyectoAreaInvestigacion
	@OneToMany(mappedBy = "proyecto")
	private List<ProyectoAreaInvestigacion> proyectoAreaInvestigacion;

	// bi-directional many-to-one association to ProyectoConvocatoria
	@OneToMany(mappedBy = "proyecto")
	private List<ProyectoConvocatoria> proyectoConvocatoria;

	// bi-directional many-to-one association to ProyectoGrupo
	@OneToMany(mappedBy = "proyecto")
	private List<ProyectoGrupo> proyectoGrupo;

	// bi-directional many-to-one association to ReferenciaBibliografica
	@OneToMany(mappedBy = "proyecto")
	private List<ReferenciaBibliografica> referenciaBibliografica;

	// bi-directional many-to-one association to SedeProyecto
	@OneToMany(mappedBy = "proyecto")
	private List<SedeProyecto> sedeProyecto;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	public Proyecto() {
	}

	public Integer getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getAnalisisResFinales() {
		return this.analisisResFinales;
	}

	public void setAnalisisResFinales(String analisisResFinales) {
		this.analisisResFinales = analisisResFinales;
	}

	public String getAnalisisResPreliminares() {
		return this.analisisResPreliminares;
	}

	public void setAnalisisResPreliminares(String analisisResPreliminares) {
		this.analisisResPreliminares = analisisResPreliminares;
	}

	public String getCmtMetodologia() {
		return this.cmtMetodologia;
	}

	public void setCmtMetodologia(String cmtMetodologia) {
		this.cmtMetodologia = cmtMetodologia;
	}

	public String getCmtoEstadoArte() {
		return this.cmtoEstadoArte;
	}

	public void setCmtoEstadoArte(String cmtoEstadoArte) {
		this.cmtoEstadoArte = cmtoEstadoArte;
	}

	public String getCmtoInnovacion() {
		return this.cmtoInnovacion;
	}

	public void setCmtoInnovacion(String cmtoInnovacion) {
		this.cmtoInnovacion = cmtoInnovacion;
	}

	public String getCmtoJustificacion() {
		return this.cmtoJustificacion;
	}

	public void setCmtoJustificacion(String cmtoJustificacion) {
		this.cmtoJustificacion = cmtoJustificacion;
	}

	public String getCmtoMarcoTeorico() {
		return this.cmtoMarcoTeorico;
	}

	public void setCmtoMarcoTeorico(String cmtoMarcoTeorico) {
		this.cmtoMarcoTeorico = cmtoMarcoTeorico;
	}

	public String getCmtoObjetivos() {
		return this.cmtoObjetivos;
	}

	public void setCmtoObjetivos(String cmtoObjetivos) {
		this.cmtoObjetivos = cmtoObjetivos;
	}

	public String getCmtoProblema() {
		return this.cmtoProblema;
	}

	public void setCmtoProblema(String cmtoProblema) {
		this.cmtoProblema = cmtoProblema;
	}

	public String getCmtoPropiedadIntelectual() {
		return this.cmtoPropiedadIntelectual;
	}

	public void setCmtoPropiedadIntelectual(String cmtoPropiedadIntelectual) {
		this.cmtoPropiedadIntelectual = cmtoPropiedadIntelectual;
	}

	public String getCmtoResenaGrupo() {
		return this.cmtoResenaGrupo;
	}

	public void setCmtoResenaGrupo(String cmtoResenaGrupo) {
		this.cmtoResenaGrupo = cmtoResenaGrupo;
	}

	public String getCmtoResumen() {
		return this.cmtoResumen;
	}

	public void setCmtoResumen(String cmtoResumen) {
		this.cmtoResumen = cmtoResumen;
	}

	public String getConclusionesFinales() {
		return this.conclusionesFinales;
	}

	public void setConclusionesFinales(String conclusionesFinales) {
		this.conclusionesFinales = conclusionesFinales;
	}

	public String getConcuclisionesPreliminares() {
		return this.concuclisionesPreliminares;
	}

	public void setConcuclisionesPreliminares(String concuclisionesPreliminares) {
		this.concuclisionesPreliminares = concuclisionesPreliminares;
	}

	public Integer getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getEjecucion() {
		return this.ejecucion;
	}

	public void setEjecucion(Integer ejecucion) {
		this.ejecucion = ejecucion;
	}

	public String getEstadoArte() {
		return this.estadoArte;
	}

	public void setEstadoArte(String estadoArte) {
		this.estadoArte = estadoArte;
	}

	public Integer getEstadoProyecto() {
		return this.estadoProyecto;
	}

	public void setEstadoProyecto(Integer estadoProyecto) {
		this.estadoProyecto = estadoProyecto;
	}

	public String getExperimentosEstudios() {
		return this.experimentosEstudios;
	}

	public void setExperimentosEstudios(String experimentosEstudios) {
		this.experimentosEstudios = experimentosEstudios;
	}

	public Date getFechaInicioFormulacion() {
		return this.fechaInicioFormulacion;
	}

	public void setFechaInicioFormulacion(Date fechaInicioFormulacion) {
		this.fechaInicioFormulacion = fechaInicioFormulacion;
	}

	public String getInnovacion() {
		return this.innovacion;
	}

	public void setInnovacion(String innovacion) {
		this.innovacion = innovacion;
	}

	public String getJustificacion() {
		return this.justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	public String getMarcoTeorico() {
		return this.marcoTeorico;
	}

	public void setMarcoTeorico(String marcoTeorico) {
		this.marcoTeorico = marcoTeorico;
	}

	public String getMetodologia() {
		return this.metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public String getNombreProyecto() {
		return this.nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public String getObjetivos() {
		return this.objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getProblema() {
		return this.problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getPropiedadIntelectual() {
		return this.propiedadIntelectual;
	}

	public void setPropiedadIntelectual(String propiedadIntelectual) {
		this.propiedadIntelectual = propiedadIntelectual;
	}

	public String getResenaGrupo() {
		return this.resenaGrupo;
	}

	public void setResenaGrupo(String resenaGrupo) {
		this.resenaGrupo = resenaGrupo;
	}

	public String getResumen() {
		return this.resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public Integer getTotalInvestigadores() {
		return this.totalInvestigadores;
	}

	public void setTotalInvestigadores(Integer totalInvestigadores) {
		this.totalInvestigadores = totalInvestigadores;
	}

	public String getTrabajosFuturos() {
		return this.trabajosFuturos;
	}

	public void setTrabajosFuturos(String trabajosFuturos) {
		this.trabajosFuturos = trabajosFuturos;
	}

	public String getValidacionHipotesis() {
		return this.validacionHipotesis;
	}

	public void setValidacionHipotesis(String validacionHipotesis) {
		this.validacionHipotesis = validacionHipotesis;
	}

	public double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getVentajasLimitadiones() {
		return this.ventajasLimitadiones;
	}

	public void setVentajasLimitadiones(String ventajasLimitadiones) {
		this.ventajasLimitadiones = ventajasLimitadiones;
	}

	public List<AnexosGeneral> getAnexosGeneral() {
		return this.anexosGeneral;
	}

	public void setAnexosGeneral(List<AnexosGeneral> anexosGeneral) {
		this.anexosGeneral = anexosGeneral;
	}

	public AnexosGeneral addAnexosGeneral(AnexosGeneral anexosGeneral) {
		getAnexosGeneral().add(anexosGeneral);
		anexosGeneral.setProyecto(this);

		return anexosGeneral;
	}

	public AnexosGeneral removeAnexosGeneral(AnexosGeneral anexosGeneral) {
		getAnexosGeneral().remove(anexosGeneral);
		anexosGeneral.setProyecto(null);

		return anexosGeneral;
	}

	public List<AptCobertura> getAptCobertura() {
		return this.aptCobertura;
	}

	public void setAptCobertura(List<AptCobertura> aptCobertura) {
		this.aptCobertura = aptCobertura;
	}

	public AptCobertura addAptCobertura(AptCobertura aptCobertura) {
		getAptCobertura().add(aptCobertura);
		aptCobertura.setProyecto(this);

		return aptCobertura;
	}

	public AptCobertura removeAptCobertura(AptCobertura aptCobertura) {
		getAptCobertura().remove(aptCobertura);
		aptCobertura.setProyecto(null);

		return aptCobertura;
	}

	public List<AptImpacto> getAptImpacto() {
		return this.aptImpacto;
	}

	public void setAptImpacto(List<AptImpacto> aptImpacto) {
		this.aptImpacto = aptImpacto;
	}

	public AptImpacto addAptImpacto(AptImpacto aptImpacto) {
		getAptImpacto().add(aptImpacto);
		aptImpacto.setProyecto(this);

		return aptImpacto;
	}

	public AptImpacto removeAptImpacto(AptImpacto aptImpacto) {
		getAptImpacto().remove(aptImpacto);
		aptImpacto.setProyecto(null);

		return aptImpacto;
	}

	public List<AptResultadosAporte> getAptResultadosAportes() {
		return this.aptResultadosAportes;
	}

	public void setAptResultadosAportes(
			List<AptResultadosAporte> aptResultadosAportes) {
		this.aptResultadosAportes = aptResultadosAportes;
	}

	public AptResultadosAporte addAptResultadosAporte(
			AptResultadosAporte aptResultadosAporte) {
		getAptResultadosAportes().add(aptResultadosAporte);
		aptResultadosAporte.setProyecto(this);

		return aptResultadosAporte;
	}

	public AptResultadosAporte removeAptResultadosAporte(
			AptResultadosAporte aptResultadosAporte) {
		getAptResultadosAportes().remove(aptResultadosAporte);
		aptResultadosAporte.setProyecto(null);

		return aptResultadosAporte;
	}

	public List<DisenioMetodo> getDisenioMetodo() {
		return this.disenioMetodo;
	}

	public void setDisenioMetodo(List<DisenioMetodo> disenioMetodo) {
		this.disenioMetodo = disenioMetodo;
	}

	public DisenioMetodo addDisenioMetodo(DisenioMetodo disenioMetodo) {
		getDisenioMetodo().add(disenioMetodo);
		disenioMetodo.setProyecto(this);

		return disenioMetodo;
	}

	public DisenioMetodo removeDisenioMetodo(DisenioMetodo disenioMetodo) {
		getDisenioMetodo().remove(disenioMetodo);
		disenioMetodo.setProyecto(null);

		return disenioMetodo;
	}

	public List<EntidadProyecto> getEntidadProyecto() {
		return this.entidadProyecto;
	}

	public void setEntidadProyecto(List<EntidadProyecto> entidadProyecto) {
		this.entidadProyecto = entidadProyecto;
	}

	public EntidadProyecto addEntidadProyecto(EntidadProyecto entidadProyecto) {
		getEntidadProyecto().add(entidadProyecto);
		entidadProyecto.setProyecto(this);

		return entidadProyecto;
	}

	public EntidadProyecto removeEntidadProyecto(EntidadProyecto entidadProyecto) {
		getEntidadProyecto().remove(entidadProyecto);
		entidadProyecto.setProyecto(null);

		return entidadProyecto;
	}

	public List<Fase> getFase() {
		return this.fase;
	}

	public void setFase(List<Fase> fase) {
		this.fase = fase;
	}

	public Fase addFase(Fase fase) {
		getFase().add(fase);
		fase.setProyecto(this);

		return fase;
	}

	public Fase removeFase(Fase fase) {
		getFase().remove(fase);
		fase.setProyecto(null);

		return fase;
	}

	public List<PalabraClave> getPalabraClave() {
		return this.palabraClave;
	}

	public void setPalabraClave(List<PalabraClave> palabraClave) {
		this.palabraClave = palabraClave;
	}

	public PalabraClave addPalabraClave(PalabraClave palabraClave) {
		getPalabraClave().add(palabraClave);
		palabraClave.setProyecto(this);

		return palabraClave;
	}

	public PalabraClave removePalabraClave(PalabraClave palabraClave) {
		getPalabraClave().remove(palabraClave);
		palabraClave.setProyecto(null);

		return palabraClave;
	}

	public List<PersonalEvaluacionProyecto> getPersonalEvaluacionProyecto() {
		return this.personalEvaluacionProyecto;
	}

	public void setPersonalEvaluacionProyecto(
			List<PersonalEvaluacionProyecto> personalEvaluacionProyecto) {
		this.personalEvaluacionProyecto = personalEvaluacionProyecto;
	}

	public PersonalEvaluacionProyecto addPersonalEvaluacionProyecto(
			PersonalEvaluacionProyecto personalEvaluacionProyecto) {
		getPersonalEvaluacionProyecto().add(personalEvaluacionProyecto);
		personalEvaluacionProyecto.setProyecto(this);

		return personalEvaluacionProyecto;
	}

	public PersonalEvaluacionProyecto removePersonalEvaluacionProyecto(
			PersonalEvaluacionProyecto personalEvaluacionProyecto) {
		getPersonalEvaluacionProyecto().remove(personalEvaluacionProyecto);
		personalEvaluacionProyecto.setProyecto(null);

		return personalEvaluacionProyecto;
	}

	public List<PersonalProyecto> getPersonalProyecto() {
		return this.personalProyecto;
	}

	public void setPersonalProyecto(List<PersonalProyecto> personalProyecto) {
		this.personalProyecto = personalProyecto;
	}

	public PersonalProyecto addPersonalProyecto(
			PersonalProyecto personalProyecto) {
		getPersonalProyecto().add(personalProyecto);
		personalProyecto.setProyecto(this);

		return personalProyecto;
	}

	public PersonalProyecto removePersonalProyecto(
			PersonalProyecto personalProyecto) {
		getPersonalProyecto().remove(personalProyecto);
		personalProyecto.setProyecto(null);

		return personalProyecto;
	}

	public EjecucionCronograma getEjecucionCronograma() {
		return this.ejecucionCronograma;
	}

	public void setEjecucionCronograma(EjecucionCronograma ejecucionCronograma) {
		this.ejecucionCronograma = ejecucionCronograma;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public TipoProyecto getTipoProyecto() {
		return this.tipoProyecto;
	}

	public void setTipoProyecto(TipoProyecto tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}

	public List<ProyectoAreaInvestigacion> getProyectoAreaInvestigacion() {
		return this.proyectoAreaInvestigacion;
	}

	public void setProyectoAreaInvestigacion(
			List<ProyectoAreaInvestigacion> proyectoAreaInvestigacion) {
		this.proyectoAreaInvestigacion = proyectoAreaInvestigacion;
	}

	public ProyectoAreaInvestigacion addProyectoAreaInvestigacion(
			ProyectoAreaInvestigacion proyectoAreaInvestigacion) {
		getProyectoAreaInvestigacion().add(proyectoAreaInvestigacion);
		proyectoAreaInvestigacion.setProyecto(this);

		return proyectoAreaInvestigacion;
	}

	public ProyectoAreaInvestigacion removeProyectoAreaInvestigacion(
			ProyectoAreaInvestigacion proyectoAreaInvestigacion) {
		getProyectoAreaInvestigacion().remove(proyectoAreaInvestigacion);
		proyectoAreaInvestigacion.setProyecto(null);

		return proyectoAreaInvestigacion;
	}

	public List<ProyectoConvocatoria> getProyectoConvocatoria() {
		return this.proyectoConvocatoria;
	}

	public void setProyectoConvocatoria(
			List<ProyectoConvocatoria> proyectoConvocatoria) {
		this.proyectoConvocatoria = proyectoConvocatoria;
	}

	public ProyectoConvocatoria addProyectoConvocatoria(
			ProyectoConvocatoria proyectoConvocatoria) {
		getProyectoConvocatoria().add(proyectoConvocatoria);
		proyectoConvocatoria.setProyecto(this);

		return proyectoConvocatoria;
	}

	public ProyectoConvocatoria removeProyectoConvocatoria(
			ProyectoConvocatoria proyectoConvocatoria) {
		getProyectoConvocatoria().remove(proyectoConvocatoria);
		proyectoConvocatoria.setProyecto(null);

		return proyectoConvocatoria;
	}

	public List<ProyectoGrupo> getProyectoGrupo() {
		return this.proyectoGrupo;
	}

	public void setProyectoGrupo(List<ProyectoGrupo> proyectoGrupo) {
		this.proyectoGrupo = proyectoGrupo;
	}

	public ProyectoGrupo addProyectoGrupo(ProyectoGrupo proyectoGrupo) {
		getProyectoGrupo().add(proyectoGrupo);
		proyectoGrupo.setProyecto(this);

		return proyectoGrupo;
	}

	public ProyectoGrupo removeProyectoGrupo(ProyectoGrupo proyectoGrupo) {
		getProyectoGrupo().remove(proyectoGrupo);
		proyectoGrupo.setProyecto(null);

		return proyectoGrupo;
	}

	public List<ReferenciaBibliografica> getReferenciaBibliografica() {
		return this.referenciaBibliografica;
	}

	public void setReferenciaBibliografica(
			List<ReferenciaBibliografica> referenciaBibliografica) {
		this.referenciaBibliografica = referenciaBibliografica;
	}

	public ReferenciaBibliografica addReferenciaBibliografica(
			ReferenciaBibliografica referenciaBibliografica) {
		getReferenciaBibliografica().add(referenciaBibliografica);
		referenciaBibliografica.setProyecto(this);

		return referenciaBibliografica;
	}

	public ReferenciaBibliografica removeReferenciaBibliografica(
			ReferenciaBibliografica referenciaBibliografica) {
		getReferenciaBibliografica().remove(referenciaBibliografica);
		referenciaBibliografica.setProyecto(null);

		return referenciaBibliografica;
	}

	public List<SedeProyecto> getSedeProyecto() {
		return this.sedeProyecto;
	}

	public void setSedeProyecto(List<SedeProyecto> sedeProyecto) {
		this.sedeProyecto = sedeProyecto;
	}

	public SedeProyecto addSedeProyecto(SedeProyecto sedeProyecto) {
		getSedeProyecto().add(sedeProyecto);
		sedeProyecto.setProyecto(this);

		return sedeProyecto;
	}

	public SedeProyecto removeSedeProyecto(SedeProyecto sedeProyecto) {
		getSedeProyecto().remove(sedeProyecto);
		sedeProyecto.setProyecto(null);

		return sedeProyecto;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}