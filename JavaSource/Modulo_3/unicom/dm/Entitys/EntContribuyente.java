package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ent_contribuyente database table.
 * 
 */
@Entity
@Table(name="ent_contribuyente")
public class EntContribuyente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENT_CONTRIBUYENTE_IDCONTRIBUYENTE_GENERATOR", sequenceName="ENT_CONTRIBUYENTE_ID_CONTRIBUYENTE_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENT_CONTRIBUYENTE_IDCONTRIBUYENTE_GENERATOR")
	@Column(name="id_contribuyente")
	private Integer idContribuyente;

	@Column(name="estado_contribuyente")
	private Integer estadoContribuyente;

	@Column(name="nombre_contribuyente")
	private String nombreContribuyente;

	//bi-directional many-to-one association to EntEntidad
	@OneToMany(mappedBy="entContribuyente")
	private List<EntEntidad> entEntidad;

	public EntContribuyente() {
	}

	public Integer getIdContribuyente() {
		return this.idContribuyente;
	}

	public void setIdContribuyente(Integer idContribuyente) {
		this.idContribuyente = idContribuyente;
	}

	public Integer getEstadoContribuyente() {
		return this.estadoContribuyente;
	}

	public void setEstadoContribuyente(Integer estadoContribuyente) {
		this.estadoContribuyente = estadoContribuyente;
	}

	public String getNombreContribuyente() {
		return this.nombreContribuyente;
	}

	public void setNombreContribuyente(String nombreContribuyente) {
		this.nombreContribuyente = nombreContribuyente;
	}

	public List<EntEntidad> getEntEntidad() {
		return this.entEntidad;
	}

	public void setEntEntidad(List<EntEntidad> entEntidad) {
		this.entEntidad = entEntidad;
	}

	public EntEntidad addEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().add(entEntidad);
		entEntidad.setEntContribuyente(this);

		return entEntidad;
	}

	public EntEntidad removeEntEntidad(EntEntidad entEntidad) {
		getEntEntidad().remove(entEntidad);
		entEntidad.setEntContribuyente(null);

		return entEntidad;
	}

}