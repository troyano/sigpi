package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the personal_proyecto database table.
 * 
 */
@Entity
@Table(name = "personal_proyecto", catalog = "sigpi", schema = "public")
@NamedQueries({
		@NamedQuery(name = "pp.findAll", query = "SELECT PP FROM PersonalProyecto pp"),
		@NamedQuery(name = "pp.findById", query = "SELECT PP FROM PersonalProyecto pp WHERE pp.idPersonalProyecto = :idPersonalProyecto"),
//
//		@NamedQuery(name = "pp.findBySedePrograma", query = "SELECT PP FROM PersonalProyecto pp WHERE pp.sedePrograma = :sedePrograma"),
//
//		@NamedQuery(name = "pp.findByNombreProyecto", query = "SELECT PP FROM PersonalProyecto pp JOIN pp.proyecto pro WHERE pro.nombreProyecto like :nombreProyecto"),
//
//		@NamedQuery(name = "pp.findByIdenPersonal", query = "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per WHERE per.identificacion like :identificacion"),
//		@NamedQuery(name = "pp.findByPnombrePersonal", query = "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per WHERE per.primerNombre like :primerNombre"),
//		@NamedQuery(name = "pp.findByPapellidoPersonal", query = "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per WHERE per.primerApellido like :primerApellido"),
//
//		@NamedQuery(name = "pp.findByIdenApellNomPersonal", query = "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per "
//				+ "WHERE per.identificacion like :identificacion "
//				+ "AND per.primerNombre like :primerNombre "
//				+ "AND per.primerApellido like :primerApellido "),
//				@NamedQuery(name = "pp.findByIdenApellNomPersonal", query = "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per "
//						+ "WHERE per.identificacion like :identificacion "
//						+ "AND per.primerNombre like :primerNombre "),
//						@NamedQuery(name = "pp.findByIdenApellNomPersonal", query = "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per "
//								+ "WHERE per.identificacion like :identificacion "
//								+ "AND per.primerApellido like :primerApellido "),
//								@NamedQuery(name = "pp.findByIdenApellNomPersonal", query = "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per "
//										+ "WHERE per.primerNombre like :primerNombre "
//										+ "AND per.primerApellido like :primerApellido "),

		@NamedQuery(name = "pp.findByCatalogoAll", query = "SELECT PP FROM PersonalProyecto pp JOIN pp.personal per JOIN pp.proyecto pro "
				+ "WHERE per.identificacion like :identificacion "
				+ "AND per.primerNombre like :primerNombre "
				+ "AND per.primerApellido like :primerApellido "
				+ "AND pro.nombreProyecto like :nombreProyecto "
				+ "AND pp.sedePrograma = :sedePrograma") })

public class PersonalProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PERSONAL_PROYECTO_IDPERSONALPROYECTO_GENERATOR", sequenceName = "PERSONAL_PROYECTO_ID_PERSONAL_PROYECTO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONAL_PROYECTO_IDPERSONALPROYECTO_GENERATOR")
	@Column(name = "id_personal_proyecto")
	private Integer idPersonalProyecto;

	@Column(name = "dedicacion_horas")
	private Integer dedicacionHoras;

	private String funcion;

	private Integer meses;

	// bi-directional many-to-one association to AreaDesempeno
	@ManyToOne
	@JoinColumn(name = "id_area_desempeno")
	private AreaDesempeno areaDesempeno;

	// bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name = "id_cargo")
	private Cargo cargo;

	// bi-directional many-to-one association to FormacionAcademica
	@ManyToOne
	@JoinColumn(name = "id_formacion_academica")
	private FormacionAcademica formacionAcademica;

	// bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name = "id_personal")
	private Personal personal;

	// bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	private Proyecto proyecto;

	// bi-directional many-to-one association to SedePrograma
	@ManyToOne
	@JoinColumn(name = "id_sede_programa")
	private SedePrograma sedePrograma;

	// bi-directional many-to-one association to TipoPersonal
	@ManyToOne
	@JoinColumn(name = "id_tipo_personal")
	private TipoPersonal tipoPersonal;

	// bi-directional many-to-one association to VinculoInstitucional
	@ManyToOne
	@JoinColumn(name = "id_vinculo")
	private VinculoInstitucional vinculoInstitucional;

	// bi-directional many-to-one association to Presupuesto
	@OneToMany(mappedBy = "personalProyecto")
	private List<Presupuesto> presupuesto;

	public PersonalProyecto() {
	}

	public Integer getIdPersonalProyecto() {
		return this.idPersonalProyecto;
	}

	public void setIdPersonalProyecto(Integer idPersonalProyecto) {
		this.idPersonalProyecto = idPersonalProyecto;
	}

	public Integer getDedicacionHoras() {
		return this.dedicacionHoras;
	}

	public void setDedicacionHoras(Integer dedicacionHoras) {
		this.dedicacionHoras = dedicacionHoras;
	}

	public String getFuncion() {
		return this.funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public Integer getMeses() {
		return this.meses;
	}

	public void setMeses(Integer meses) {
		this.meses = meses;
	}

	public AreaDesempeno getAreaDesempeno() {
		return this.areaDesempeno;
	}

	public void setAreaDesempeno(AreaDesempeno areaDesempeno) {
		this.areaDesempeno = areaDesempeno;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public FormacionAcademica getFormacionAcademica() {
		return this.formacionAcademica;
	}

	public void setFormacionAcademica(FormacionAcademica formacionAcademica) {
		this.formacionAcademica = formacionAcademica;
	}

	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public SedePrograma getSedePrograma() {
		return this.sedePrograma;
	}

	public void setSedePrograma(SedePrograma sedePrograma) {
		this.sedePrograma = sedePrograma;
	}

	public TipoPersonal getTipoPersonal() {
		return this.tipoPersonal;
	}

	public void setTipoPersonal(TipoPersonal tipoPersonal) {
		this.tipoPersonal = tipoPersonal;
	}

	public VinculoInstitucional getVinculoInstitucional() {
		return this.vinculoInstitucional;
	}

	public void setVinculoInstitucional(
			VinculoInstitucional vinculoInstitucional) {
		this.vinculoInstitucional = vinculoInstitucional;
	}

	public List<Presupuesto> getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(List<Presupuesto> presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Presupuesto addPresupuesto(Presupuesto presupuesto) {
		getPresupuesto().add(presupuesto);
		presupuesto.setPersonalProyecto(this);

		return presupuesto;
	}

	public Presupuesto removePresupuesto(Presupuesto presupuesto) {
		getPresupuesto().remove(presupuesto);
		presupuesto.setPersonalProyecto(null);

		return presupuesto;
	}

}