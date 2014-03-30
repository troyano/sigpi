package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the ent_entidad database table.
 * 
 */
@Entity
@Table(name = "ent_entidad",catalog="sigpi",schema="public")
@NamedQueries({
		@NamedQuery(name = "e.findAll", query = "SELECT E FROM EntEntidad e"),
		@NamedQuery(name = "e.findById", query = "SELECT E FROM EntEntidad e WHERE e.idEntEntidad = :idEntEntidad"),
		@NamedQuery(name = "e.findByNombreYNumeroId", query = "SELECT E FROM EntEntidad e WHERE e.numeroIdentificacion like :numeroIdentificacion AND  e.nombreEntidad like :nombreEntidad"),
		@NamedQuery(name = "e.findByNumeroId", query = "SELECT E FROM EntEntidad e WHERE e.numeroIdentificacion like :numeroIdentificacion"),
		@NamedQuery(name = "e.findByNombre", query = "SELECT E FROM EntEntidad e WHERE  e.nombreEntidad like :nombreEntidad")})

public class EntEntidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_ENTIDAD_IDENTENTIDAD_GENERATOR", sequenceName="ENT_ENTIDAD_ID_ENT_ENTIDAD_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_ENTIDAD_IDENTENTIDAD_GENERATOR")
	@Column(name="id_ent_entidad")
	private Integer idEntEntidad;

	private String direccion;

	private String email;

	@Column(name="estado_entidad")
	private Integer estadoEntidad;

	private String exporta;

	private Integer fax;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_constitucion")
	private Date fechaConstitucion;

	@Column(name="matricula_camara")
	private String matriculaCamara;

	@Column(name="nombre_entidad")
	private String nombreEntidad;

	@Column(name="numero_empleados")
	private Integer numeroEmpleados;

	@Column(name="numero_identificacion")
	private String numeroIdentificacion;

	@Column(name="privado_extranjero")
	private BigDecimal privadoExtranjero;

	@Column(name="privado_nacional")
	private BigDecimal privadoNacional;

	@Column(name="publico_extranjero")
	private BigDecimal publicoExtranjero;

	@Column(name="publico_nacional")
	private BigDecimal publicoNacional;

	private Integer telefono;

	@Column(name="venta_untimo_anio")
	private BigDecimal ventaUntimoAnio;

	private String website;

	//bi-directional many-to-one association to EntContacto
	@OneToMany(mappedBy="entEntidad")
	private List<EntContacto> entContacto;

	//bi-directional many-to-one association to EntCiiu
	@ManyToOne
	@JoinColumn(name="id_ciiu")
	private EntCiiu entCiiu;

	//bi-directional many-to-one association to EntContribuyente
	@ManyToOne
	@JoinColumn(name="id_contribuyente")
	private EntContribuyente entContribuyente;

	//bi-directional many-to-one association to EntRepresentantelegal
	@ManyToOne
	@JoinColumn(name="id_representante")
	private EntRepresentantelegal entRepresentantelegal;

	//bi-directional many-to-one association to EntTamanoEntidad
	@ManyToOne
	@JoinColumn(name="id_tamano_entidad")
	private EntTamanoEntidad entTamanoEntidad;

	//bi-directional many-to-one association to EntTipoEmpresa
	@ManyToOne
	@JoinColumn(name="id_tipo_empresa")
	private EntTipoEmpresa entTipoEmpresa;

	//bi-directional many-to-one association to EntTipoEntidad
	@ManyToOne
	@JoinColumn(name="id_ent_tipo_entidad")
	private EntTipoEntidad entTipoEntidad;

	//bi-directional many-to-one association to EntTipoIdentificacion
	@ManyToOne
	@JoinColumn(name="id_tipo_identificacion")
	private EntTipoIdentificacion entTipoIdentificacion;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private Municipio municipio;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Pais pais;

	//bi-directional many-to-one association to EntProductosservicio
	@OneToMany(mappedBy="entEntidad")
	private List<EntProductosservicio> entProductosservicios;

	//bi-directional many-to-one association to EntSituacionFinanciera
	@OneToMany(mappedBy="entEntidad")
	private List<EntSituacionFinanciera> entSituacionFinanciera;

	//bi-directional many-to-one association to EntidadProyecto
	@OneToMany(mappedBy="entEntidad")
	private List<EntidadProyecto> entidadProyecto;

	public EntEntidad() {
	}

	public Integer getIdEntEntidad() {
		return this.idEntEntidad;
	}

	public void setIdEntEntidad(Integer idEntEntidad) {
		this.idEntEntidad = idEntEntidad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEstadoEntidad() {
		return this.estadoEntidad;
	}

	public void setEstadoEntidad(Integer estadoEntidad) {
		this.estadoEntidad = estadoEntidad;
	}

	public String getExporta() {
		return this.exporta;
	}

	public void setExporta(String exporta) {
		this.exporta = exporta;
	}

	public Integer getFax() {
		return this.fax;
	}

	public void setFax(Integer fax) {
		this.fax = fax;
	}

	public Date getFechaConstitucion() {
		return this.fechaConstitucion;
	}

	public void setFechaConstitucion(Date fechaConstitucion) {
		this.fechaConstitucion = fechaConstitucion;
	}

	public String getMatriculaCamara() {
		return this.matriculaCamara;
	}

	public void setMatriculaCamara(String matriculaCamara) {
		this.matriculaCamara = matriculaCamara;
	}

	public String getNombreEntidad() {
		return this.nombreEntidad;
	}

	public void setNombreEntidad(String nombreEntidad) {
		this.nombreEntidad = nombreEntidad;
	}

	public Integer getNumeroEmpleados() {
		return this.numeroEmpleados;
	}

	public void setNumeroEmpleados(Integer numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	public String getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public BigDecimal getPrivadoExtranjero() {
		return this.privadoExtranjero;
	}

	public void setPrivadoExtranjero(BigDecimal privadoExtranjero) {
		this.privadoExtranjero = privadoExtranjero;
	}

	public BigDecimal getPrivadoNacional() {
		return this.privadoNacional;
	}

	public void setPrivadoNacional(BigDecimal privadoNacional) {
		this.privadoNacional = privadoNacional;
	}

	public BigDecimal getPublicoExtranjero() {
		return this.publicoExtranjero;
	}

	public void setPublicoExtranjero(BigDecimal publicoExtranjero) {
		this.publicoExtranjero = publicoExtranjero;
	}

	public BigDecimal getPublicoNacional() {
		return this.publicoNacional;
	}

	public void setPublicoNacional(BigDecimal publicoNacional) {
		this.publicoNacional = publicoNacional;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public BigDecimal getVentaUntimoAnio() {
		return this.ventaUntimoAnio;
	}

	public void setVentaUntimoAnio(BigDecimal ventaUntimoAnio) {
		this.ventaUntimoAnio = ventaUntimoAnio;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<EntContacto> getEntContacto() {
		return this.entContacto;
	}

	public void setEntContacto(List<EntContacto> entContacto) {
		this.entContacto = entContacto;
	}

	public EntContacto addEntContacto(EntContacto entContacto) {
		getEntContacto().add(entContacto);
		entContacto.setEntEntidad(this);

		return entContacto;
	}

	public EntContacto removeEntContacto(EntContacto entContacto) {
		getEntContacto().remove(entContacto);
		entContacto.setEntEntidad(null);

		return entContacto;
	}

	public EntCiiu getEntCiiu() {
		return this.entCiiu;
	}

	public void setEntCiiu(EntCiiu entCiiu) {
		this.entCiiu = entCiiu;
	}

	public EntContribuyente getEntContribuyente() {
		return this.entContribuyente;
	}

	public void setEntContribuyente(EntContribuyente entContribuyente) {
		this.entContribuyente = entContribuyente;
	}

	public EntRepresentantelegal getEntRepresentantelegal() {
		return this.entRepresentantelegal;
	}

	public void setEntRepresentantelegal(EntRepresentantelegal entRepresentantelegal) {
		this.entRepresentantelegal = entRepresentantelegal;
	}

	public EntTamanoEntidad getEntTamanoEntidad() {
		return this.entTamanoEntidad;
	}

	public void setEntTamanoEntidad(EntTamanoEntidad entTamanoEntidad) {
		this.entTamanoEntidad = entTamanoEntidad;
	}

	public EntTipoEmpresa getEntTipoEmpresa() {
		return this.entTipoEmpresa;
	}

	public void setEntTipoEmpresa(EntTipoEmpresa entTipoEmpresa) {
		this.entTipoEmpresa = entTipoEmpresa;
	}

	public EntTipoEntidad getEntTipoEntidad() {
		return this.entTipoEntidad;
	}

	public void setEntTipoEntidad(EntTipoEntidad entTipoEntidad) {
		this.entTipoEntidad = entTipoEntidad;
	}

	public EntTipoIdentificacion getEntTipoIdentificacion() {
		return this.entTipoIdentificacion;
	}

	public void setEntTipoIdentificacion(EntTipoIdentificacion entTipoIdentificacion) {
		this.entTipoIdentificacion = entTipoIdentificacion;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<EntProductosservicio> getEntProductosservicios() {
		return this.entProductosservicios;
	}

	public void setEntProductosservicios(List<EntProductosservicio> entProductosservicios) {
		this.entProductosservicios = entProductosservicios;
	}

	public EntProductosservicio addEntProductosservicio(EntProductosservicio entProductosservicio) {
		getEntProductosservicios().add(entProductosservicio);
		entProductosservicio.setEntEntidad(this);

		return entProductosservicio;
	}

	public EntProductosservicio removeEntProductosservicio(EntProductosservicio entProductosservicio) {
		getEntProductosservicios().remove(entProductosservicio);
		entProductosservicio.setEntEntidad(null);

		return entProductosservicio;
	}

	public List<EntSituacionFinanciera> getEntSituacionFinanciera() {
		return this.entSituacionFinanciera;
	}

	public void setEntSituacionFinanciera(List<EntSituacionFinanciera> entSituacionFinanciera) {
		this.entSituacionFinanciera = entSituacionFinanciera;
	}

	public EntSituacionFinanciera addEntSituacionFinanciera(EntSituacionFinanciera entSituacionFinanciera) {
		getEntSituacionFinanciera().add(entSituacionFinanciera);
		entSituacionFinanciera.setEntEntidad(this);

		return entSituacionFinanciera;
	}

	public EntSituacionFinanciera removeEntSituacionFinanciera(EntSituacionFinanciera entSituacionFinanciera) {
		getEntSituacionFinanciera().remove(entSituacionFinanciera);
		entSituacionFinanciera.setEntEntidad(null);

		return entSituacionFinanciera;
	}

	public List<EntidadProyecto> getEntidadProyecto() {
		return this.entidadProyecto;
	}

	public void setEntidadProyecto(List<EntidadProyecto> entidadProyecto) {
		this.entidadProyecto = entidadProyecto;
	}

	public EntidadProyecto addEntidadProyecto(EntidadProyecto entidadProyecto) {
		getEntidadProyecto().add(entidadProyecto);
		entidadProyecto.setEntEntidad(this);

		return entidadProyecto;
	}

	public EntidadProyecto removeEntidadProyecto(EntidadProyecto entidadProyecto) {
		getEntidadProyecto().remove(entidadProyecto);
		entidadProyecto.setEntEntidad(null);

		return entidadProyecto;
	}

}