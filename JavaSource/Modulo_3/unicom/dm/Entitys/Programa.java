package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the programa database table.
 * 
 */
@Entity
public class Programa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROGRAMA_IDPROGRAMA_GENERATOR", sequenceName="PROGRAMA_ID_PROGRAMA_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROGRAMA_IDPROGRAMA_GENERATOR")
	@Column(name="id_programa")
	private Integer idPrograma;

	@Column(name="estado_programa")
	private Integer estadoPrograma;

	@Column(name="nombre_corto")
	private String nombreCorto;

	@Column(name="nombre_programa")
	private String nombrePrograma;

	//bi-directional many-to-one association to SedePrograma
	@OneToMany(mappedBy="programa")
	private List<SedePrograma> sedePrograma;

	public Programa() {
	}

	public Integer getIdPrograma() {
		return this.idPrograma;
	}

	public void setIdPrograma(Integer idPrograma) {
		this.idPrograma = idPrograma;
	}

	public Integer getEstadoPrograma() {
		return this.estadoPrograma;
	}

	public void setEstadoPrograma(Integer estadoPrograma) {
		this.estadoPrograma = estadoPrograma;
	}

	public String getNombreCorto() {
		return this.nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombrePrograma() {
		return this.nombrePrograma;
	}

	public void setNombrePrograma(String nombrePrograma) {
		this.nombrePrograma = nombrePrograma;
	}

	public List<SedePrograma> getSedePrograma() {
		return this.sedePrograma;
	}

	public void setSedePrograma(List<SedePrograma> sedePrograma) {
		this.sedePrograma = sedePrograma;
	}

	public SedePrograma addSedePrograma(SedePrograma sedePrograma) {
		getSedePrograma().add(sedePrograma);
		sedePrograma.setPrograma(this);

		return sedePrograma;
	}

	public SedePrograma removeSedePrograma(SedePrograma sedePrograma) {
		getSedePrograma().remove(sedePrograma);
		sedePrograma.setPrograma(null);

		return sedePrograma;
	}

}