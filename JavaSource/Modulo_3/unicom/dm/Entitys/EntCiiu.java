package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ent_ciiu database table.
 * 
 */
@Entity
@Table(name="ent_ciiu")
public class EntCiiu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_CIIU_IDCIIU_GENERATOR", sequenceName="ENT_CIIU_ID_CIIU_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_CIIU_IDCIIU_GENERATOR")
	@Column(name="id_ciiu")
	private Integer idCiiu;

	private String clase;

	@Column(name="descripcion_ciiu")
	private String descripcionCiiu;

	private String division;

	@Column(name="estado_ciiu")
	private Integer estadoCiiu;

	private String grupo;

	@Column(name="seccion_ciiu")
	private String seccionCiiu;

	//bi-directional many-to-one association to EntEntidad
	@OneToMany(mappedBy="entCiiu")
	private List<EntEntidad> entEntidad;

	//bi-directional many-to-one association to EntProductosservicio
	@OneToMany(mappedBy="entCiiu")
	private List<EntProductosservicio> entProductosservicios;

	public EntCiiu() {
	}

	public Integer getIdCiiu() {
		return this.idCiiu;
	}

	public void setIdCiiu(Integer idCiiu) {
		this.idCiiu = idCiiu;
	}

	public String getClase() {
		return this.clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getDescripcionCiiu() {
		return this.descripcionCiiu;
	}

	public void setDescripcionCiiu(String descripcionCiiu) {
		this.descripcionCiiu = descripcionCiiu;
	}

	public String getDivision() {
		return this.division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Integer getEstadoCiiu() {
		return this.estadoCiiu;
	}

	public void setEstadoCiiu(Integer estadoCiiu) {
		this.estadoCiiu = estadoCiiu;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSeccionCiiu() {
		return this.seccionCiiu;
	}

	public void setSeccionCiiu(String seccionCiiu) {
		this.seccionCiiu = seccionCiiu;
	}

	public List<EntEntidad> getEntEntidad() {
		return this.entEntidad;
	}

	public void setEntEntidad(List<EntEntidad> entEntidad) {
		this.entEntidad = entEntidad;
	}

	public EntEntidad addEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().add(entEntidad);
		entEntidad.setEntCiiu(this);

		return entEntidad;
	}

	public EntEntidad removeEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().remove(entEntidad);
		entEntidad.setEntCiiu(null);

		return entEntidad;
	}

	public List<EntProductosservicio> getEntProductosservicios() {
		return this.entProductosservicios;
	}

	public void setEntProductosservicios(List<EntProductosservicio> entProductosservicios) {
		this.entProductosservicios = entProductosservicios;
	}

	public EntProductosservicio addEntProductosservicio(EntProductosservicio entProductosservicio) {
		getEntProductosservicios().add(entProductosservicio);
		entProductosservicio.setEntCiiu(this);

		return entProductosservicio;
	}

	public EntProductosservicio removeEntProductosservicio(EntProductosservicio entProductosservicio) {
		getEntProductosservicios().remove(entProductosservicio);
		entProductosservicio.setEntCiiu(null);

		return entProductosservicio;
	}

}