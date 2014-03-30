package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sede database table.
 * 
 */
@Entity
public class Sede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEDE_IDSEDE_GENERATOR", sequenceName="SEDE_ID_SEDE_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEDE_IDSEDE_GENERATOR")
	@Column(name="id_sede")
	private Integer idSede;

	@Column(name="estado_sede")
	private Integer estadoSede;

	@Column(name="nombre_sede")
	private String nombreSede;

	//bi-directional many-to-one association to SedePrograma
	@OneToMany(mappedBy="sede")
	private List<SedePrograma> sedePrograma;

	//bi-directional many-to-one association to SedeProyecto
	@OneToMany(mappedBy="sede")
	private List<SedeProyecto> sedeProyecto;

	public Sede() {
	}

	public Integer getIdSede() {
		return this.idSede;
	}

	public void setIdSede(Integer idSede) {
		this.idSede = idSede;
	}

	public Integer getEstadoSede() {
		return this.estadoSede;
	}

	public void setEstadoSede(Integer estadoSede) {
		this.estadoSede = estadoSede;
	}

	public String getNombreSede() {
		return this.nombreSede;
	}

	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	public List<SedePrograma> getSedePrograma() {
		return this.sedePrograma;
	}

	public void setSedePrograma(List<SedePrograma> sedePrograma) {
		this.sedePrograma = sedePrograma;
	}

	public SedePrograma addSedePrograma(SedePrograma sedePrograma) {
		getSedePrograma().add(sedePrograma);
		sedePrograma.setSede(this);

		return sedePrograma;
	}

	public SedePrograma removeSedePrograma(SedePrograma sedePrograma) {
		getSedePrograma().remove(sedePrograma);
		sedePrograma.setSede(null);

		return sedePrograma;
	}

	public List<SedeProyecto> getSedeProyecto() {
		return this.sedeProyecto;
	}

	public void setSedeProyecto(List<SedeProyecto> sedeProyecto) {
		this.sedeProyecto = sedeProyecto;
	}

	public SedeProyecto addSedeProyecto(SedeProyecto sedeProyecto) {
		getSedeProyecto().add(sedeProyecto);
		sedeProyecto.setSede(this);

		return sedeProyecto;
	}

	public SedeProyecto removeSedeProyecto(SedeProyecto sedeProyecto) {
		getSedeProyecto().remove(sedeProyecto);
		sedeProyecto.setSede(null);

		return sedeProyecto;
	}

}