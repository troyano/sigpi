package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sede_proyecto database table.
 * 
 */
@Entity
@Table(name="sede_proyecto")
public class SedeProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEDE_PROYECTO_IDSEDEPROYECTO_GENERATOR", sequenceName="SEDE_PROYECTO_ID_SEDE_PROYECTO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEDE_PROYECTO_IDSEDEPROYECTO_GENERATOR")
	@Column(name="id_sede_proyecto")
	private Integer idSedeProyecto;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	//bi-directional many-to-one association to Sede
	@ManyToOne
	@JoinColumn(name="id_sede")
	private Sede sede;

	public SedeProyecto() {
	}

	public Integer getIdSedeProyecto() {
		return this.idSedeProyecto;
	}

	public void setIdSedeProyecto(Integer idSedeProyecto) {
		this.idSedeProyecto = idSedeProyecto;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Sede getSede() {
		return this.sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

}