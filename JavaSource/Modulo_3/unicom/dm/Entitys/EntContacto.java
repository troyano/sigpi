package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ent_contacto database table.
 * 
 */
@Entity
@Table(name="ent_contacto",catalog="sigpi",schema="public")
@NamedQueries({
		@NamedQuery(name = "c.findAll", query = "SELECT C FROM EntContacto c"),
		@NamedQuery(name = "c.findById", query = "SELECT C FROM EntContacto c WHERE c.idContacto = :idContacto"),
		@NamedQuery(name = "c.buscarPorEntidadYOrden", query = "SELECT C FROM EntContacto c WHERE c.entEntidad = :entEntidad AND c.orden = :orden ")})

public class EntContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_CONTACTO_IDCONTACTO_GENERATOR", sequenceName="ENT_CONTACTO_ID_CONTACTO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_CONTACTO_IDCONTACTO_GENERATOR")
	@Column(name="id_contacto")
	private Integer idContacto;

	@Column(name="cargo_contacto")
	private String cargoContacto;

	@Column(name="email_contacto")
	private String emailContacto;

	@Column(name="estado_contacto")
	private Integer estadoContacto;

	private String orden;

	@Column(name="\"Papellido_contacto\"")
	private String papellido_contacto;

	@Column(name="\"Pnombre_contacto\"")
	private String pnombre_contacto;

	@Column(name="\"Sapellido_contacto\"")
	private String sapellido_contacto;

	@Column(name="\"Snombre_contacto\"")
	private String snombre_contacto;

	@Column(name="telefono_contacto")
	private Integer telefonoContacto;

	//bi-directional many-to-one association to EntEntidad
	@ManyToOne
	@JoinColumn(name="id_ent_entidad")
	private EntEntidad entEntidad;

	public EntContacto() {
	}

	public Integer getIdContacto() {
		return this.idContacto;
	}

	public void setIdContacto(Integer idContacto) {
		this.idContacto = idContacto;
	}

	public String getCargoContacto() {
		return this.cargoContacto;
	}

	public void setCargoContacto(String cargoContacto) {
		this.cargoContacto = cargoContacto;
	}

	public String getEmailContacto() {
		return this.emailContacto;
	}

	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}

	public Integer getEstadoContacto() {
		return this.estadoContacto;
	}

	public void setEstadoContacto(Integer estadoContacto) {
		this.estadoContacto = estadoContacto;
	}

	public String getOrden() {
		return this.orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getPapellido_contacto() {
		return this.papellido_contacto;
	}

	public void setPapellido_contacto(String papellido_contacto) {
		this.papellido_contacto = papellido_contacto;
	}

	public String getPnombre_contacto() {
		return this.pnombre_contacto;
	}

	public void setPnombre_contacto(String pnombre_contacto) {
		this.pnombre_contacto = pnombre_contacto;
	}

	public String getSapellido_contacto() {
		return this.sapellido_contacto;
	}

	public void setSapellido_contacto(String sapellido_contacto) {
		this.sapellido_contacto = sapellido_contacto;
	}

	public String getSnombre_contacto() {
		return this.snombre_contacto;
	}

	public void setSnombre_contacto(String snombre_contacto) {
		this.snombre_contacto = snombre_contacto;
	}

	public Integer getTelefonoContacto() {
		return this.telefonoContacto;
	}

	public void setTelefonoContacto(Integer telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public EntEntidad getEntEntidad() {
		return this.entEntidad;
	}

	public void setEntEntidad(EntEntidad entEntidad) {
		this.entEntidad = entEntidad;
	}

}