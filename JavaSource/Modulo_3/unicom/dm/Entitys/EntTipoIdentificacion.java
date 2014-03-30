package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ent_tipo_identificacion database table.
 * 
 */
@Entity
@Table(name="ent_tipo_identificacion")
public class EntTipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_TIPO_IDENTIFICACION_IDTIPOIDENTIFICACION_GENERATOR", sequenceName="ENT_TIPO_IDENTIFICACION_ID_TIPO_IDENTIFICACION_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_TIPO_IDENTIFICACION_IDTIPOIDENTIFICACION_GENERATOR")
	@Column(name="id_tipo_identificacion")
	private Integer idTipoIdentificacion;

	@Column(name="descripcion_tipo")
	private String descripcionTipo;

	@Column(name="estado_tipo_identifi")
	private Integer estadoTipoIdentifi;

	@Column(name="tipo_identificacion")
	private String tipoIdentificacion;

	//bi-directional many-to-one association to EntEntidad
	@OneToMany(mappedBy="entTipoIdentificacion")
	private List<EntEntidad> entEntidad;

	//bi-directional many-to-one association to EntRepresentantelegal
	@OneToMany(mappedBy="entTipoIdentificacion")
	private List<EntRepresentantelegal> entRepresentantelegal;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="entTipoIdentificacion")
	private List<Personal> personal;

	public EntTipoIdentificacion() {
	}

	public Integer getIdTipoIdentificacion() {
		return this.idTipoIdentificacion;
	}

	public void setIdTipoIdentificacion(Integer idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public String getDescripcionTipo() {
		return this.descripcionTipo;
	}

	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}

	public Integer getEstadoTipoIdentifi() {
		return this.estadoTipoIdentifi;
	}

	public void setEstadoTipoIdentifi(Integer estadoTipoIdentifi) {
		this.estadoTipoIdentifi = estadoTipoIdentifi;
	}

	public String getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public List<EntEntidad> getEntEntidad() {
		return this.entEntidad;
	}

	public void setEntEntidad(List<EntEntidad> entEntidad) {
		this.entEntidad = entEntidad;
	}

	public EntEntidad addEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().add(entEntidad);
		entEntidad.setEntTipoIdentificacion(this);

		return entEntidad;
	}

	public EntEntidad removeEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().remove(entEntidad);
		entEntidad.setEntTipoIdentificacion(null);

		return entEntidad;
	}

	public List<EntRepresentantelegal> getEntRepresentantelegal() {
		return this.entRepresentantelegal;
	}

	public void setEntRepresentantelegal(List<EntRepresentantelegal> entRepresentantelegal) {
		this.entRepresentantelegal = entRepresentantelegal;
	}

	public EntRepresentantelegal addEntRepresentantelegal(EntRepresentantelegal entRepresentantelegal) {
		getEntRepresentantelegal().add(entRepresentantelegal);
		entRepresentantelegal.setEntTipoIdentificacion(this);

		return entRepresentantelegal;
	}

	public EntRepresentantelegal removeEntRepresentantelegal(EntRepresentantelegal entRepresentantelegal) {
		getEntRepresentantelegal().remove(entRepresentantelegal);
		entRepresentantelegal.setEntTipoIdentificacion(null);

		return entRepresentantelegal;
	}

	public List<Personal> getPersonal() {
		return this.personal;
	}

	public void setPersonal(List<Personal> personal) {
		this.personal = personal;
	}

	public Personal addPersonal(Personal personal) {
		getPersonal().add(personal);
		personal.setEntTipoIdentificacion(this);

		return personal;
	}

	public Personal removePersonal(Personal personal) {
		getPersonal().remove(personal);
		personal.setEntTipoIdentificacion(null);

		return personal;
	}

}