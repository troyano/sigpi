package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ent_representantelegal database table.
 * 
 */
@Entity
@Table(name="ent_representantelegal",catalog="sigpi",schema="public")
@NamedQueries({
	@NamedQuery(name = "re.findAll", query = "SELECT RE FROM EntRepresentantelegal re"),
	@NamedQuery(name = "re.findById", query = "SELECT RE FROM EntRepresentantelegal re WHERE re.idRepresentante = :idRepresentante")})

public class EntRepresentantelegal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_REPRESENTANTELEGAL_IDREPRESENTANTE_GENERATOR", sequenceName="ENT_REPRESENTANTELEGAL_ID_REPRESENTANTE_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_REPRESENTANTELEGAL_IDREPRESENTANTE_GENERATOR")
	@Column(name="id_representante")
	private Integer idRepresentante;

	@Column(name="estado_representante")
	private Integer estadoRepresentante;

	@Column(name="numero_representante")
	private Integer numeroRepresentante;

	@Column(name="\"Papellido_representante_legal\"")
	private String papellido_representante_legal;

	@Column(name="\"Pnombre_representante_legal\"")
	private String pnombre_representante_legal;

	@Column(name="\"Sapellido_representante_legal\"")
	private String sapellido_representante_legal;

	@Column(name="\"Snombre_representante_legal\"")
	private String snombre_representante_legal;

	//bi-directional many-to-one association to EntEntidad
	@OneToMany(mappedBy="entRepresentantelegal")
	private List<EntEntidad> entEntidad;

	//bi-directional many-to-one association to EntTipoIdentificacion
	@ManyToOne
	@JoinColumn(name="id_tipo_identificacion")
	private EntTipoIdentificacion entTipoIdentificacion;

	public EntRepresentantelegal() {
	}

	public Integer getIdRepresentante() {
		return this.idRepresentante;
	}

	public void setIdRepresentante(Integer idRepresentante) {
		this.idRepresentante = idRepresentante;
	}

	public Integer getEstadoRepresentante() {
		return this.estadoRepresentante;
	}

	public void setEstadoRepresentante(Integer estadoRepresentante) {
		this.estadoRepresentante = estadoRepresentante;
	}

	public Integer getNumeroRepresentante() {
		return this.numeroRepresentante;
	}

	public void setNumeroRepresentante(Integer numeroRepresentante) {
		this.numeroRepresentante = numeroRepresentante;
	}

	public String getPapellido_representante_legal() {
		return this.papellido_representante_legal;
	}

	public void setPapellido_representante_legal(String papellido_representante_legal) {
		this.papellido_representante_legal = papellido_representante_legal;
	}

	public String getPnombre_representante_legal() {
		return this.pnombre_representante_legal;
	}

	public void setPnombre_representante_legal(String pnombre_representante_legal) {
		this.pnombre_representante_legal = pnombre_representante_legal;
	}

	public String getSapellido_representante_legal() {
		return this.sapellido_representante_legal;
	}

	public void setSapellido_representante_legal(String sapellido_representante_legal) {
		this.sapellido_representante_legal = sapellido_representante_legal;
	}

	public String getSnombre_representante_legal() {
		return this.snombre_representante_legal;
	}

	public void setSnombre_representante_legal(String snombre_representante_legal) {
		this.snombre_representante_legal = snombre_representante_legal;
	}

	public List<EntEntidad> getEntEntidad() {
		return this.entEntidad;
	}

	public void setEntEntidad(List<EntEntidad> entEntidad) {
		this.entEntidad = entEntidad;
	}

	public EntEntidad addEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().add(entEntidad);
		entEntidad.setEntRepresentantelegal(this);

		return entEntidad;
	}

	public EntEntidad removeEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().remove(entEntidad);
		entEntidad.setEntRepresentantelegal(null);

		return entEntidad;
	}

	public EntTipoIdentificacion getEntTipoIdentificacion() {
		return this.entTipoIdentificacion;
	}

	public void setEntTipoIdentificacion(EntTipoIdentificacion entTipoIdentificacion) {
		this.entTipoIdentificacion = entTipoIdentificacion;
	}

}