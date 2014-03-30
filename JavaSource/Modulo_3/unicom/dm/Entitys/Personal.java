package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the personal database table.
 * 
 */
@Entity
@Table(name = "personal",catalog="sigpi",schema="public")
@NamedQueries({
		@NamedQuery(name = "per.findAll", query = "SELECT PER FROM Personal per"),
		@NamedQuery(name = "per.findById", query = "SELECT PER FROM Personal per WHERE per.idPersonal = :idPersonal")})

public class Personal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSONAL_IDPERSONAL_GENERATOR", sequenceName="PERSONAL_ID_PERSONAL_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONAL_IDPERSONAL_GENERATOR")
	@Column(name="id_personal")
	private Integer idPersonal;

	private String clave;

	private String direccion;

	@Column(name="e_mail")
	private String eMail;

	@Column(name="estado_personal")
	private Integer estadoPersonal;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String identificacion;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="primer_nombre")
	private String primerNombre;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	@Column(name="segundo_nombre")
	private String segundoNombre;

	private String telefono;

	//bi-directional many-to-one association to EntTipoIdentificacion
	@ManyToOne
	@JoinColumn(name="id_tipo_identificacion")
	private EntTipoIdentificacion entTipoIdentificacion;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Pais pais;

	//bi-directional many-to-one association to SedePrograma
	@ManyToOne
	@JoinColumn(name="id_sede_programa")
	private SedePrograma sedePrograma;

	//bi-directional many-to-one association to SegRol
	@ManyToOne
	@JoinColumn(name="seg_rol")
	private SegRol segRol;

	//bi-directional many-to-one association to PersonalEvaluacionProyecto
	@OneToMany(mappedBy="personal")
	private List<PersonalEvaluacionProyecto> personalEvaluacionProyecto;

	//bi-directional many-to-one association to PersonalProyecto
	@OneToMany(mappedBy="personal")
	private List<PersonalProyecto> personalProyecto;

	public Personal() {
	}

	public Integer getIdPersonal() {
		return this.idPersonal;
	}

	public void setIdPersonal(Integer idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public Integer getEstadoPersonal() {
		return this.estadoPersonal;
	}

	public void setEstadoPersonal(Integer estadoPersonal) {
		this.estadoPersonal = estadoPersonal;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public EntTipoIdentificacion getEntTipoIdentificacion() {
		return this.entTipoIdentificacion;
	}

	public void setEntTipoIdentificacion(EntTipoIdentificacion entTipoIdentificacion) {
		this.entTipoIdentificacion = entTipoIdentificacion;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public SedePrograma getSedePrograma() {
		return this.sedePrograma;
	}

	public void setSedePrograma(SedePrograma sedePrograma) {
		this.sedePrograma = sedePrograma;
	}

	public SegRol getSegRol() {
		return this.segRol;
	}

	public void setSegRol(SegRol segRol) {
		this.segRol = segRol;
	}

	public List<PersonalEvaluacionProyecto> getPersonalEvaluacionProyecto() {
		return this.personalEvaluacionProyecto;
	}

	public void setPersonalEvaluacionProyecto(List<PersonalEvaluacionProyecto> personalEvaluacionProyecto) {
		this.personalEvaluacionProyecto = personalEvaluacionProyecto;
	}

	public PersonalEvaluacionProyecto addPersonalEvaluacionProyecto(PersonalEvaluacionProyecto personalEvaluacionProyecto) {
		getPersonalEvaluacionProyecto().add(personalEvaluacionProyecto);
		personalEvaluacionProyecto.setPersonal(this);

		return personalEvaluacionProyecto;
	}

	public PersonalEvaluacionProyecto removePersonalEvaluacionProyecto(PersonalEvaluacionProyecto personalEvaluacionProyecto) {
		getPersonalEvaluacionProyecto().remove(personalEvaluacionProyecto);
		personalEvaluacionProyecto.setPersonal(null);

		return personalEvaluacionProyecto;
	}

	public List<PersonalProyecto> getPersonalProyecto() {
		return this.personalProyecto;
	}

	public void setPersonalProyecto(List<PersonalProyecto> personalProyecto) {
		this.personalProyecto = personalProyecto;
	}

	public PersonalProyecto addPersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().add(personalProyecto);
		personalProyecto.setPersonal(this);

		return personalProyecto;
	}

	public PersonalProyecto removePersonalProyecto(PersonalProyecto personalProyecto) {
		getPersonalProyecto().remove(personalProyecto);
		personalProyecto.setPersonal(null);

		return personalProyecto;
	}

}