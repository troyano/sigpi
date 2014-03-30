package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the apt_espesificacion database table.
 * 
 */
@Entity
@Table(name="apt_espesificacion")
public class AptEspesificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="APT_ESPESIFICACION_IDESPECIFICACION_GENERATOR", sequenceName="APT_ESPESIFICACION_ID_ESPECIFICACION_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APT_ESPESIFICACION_IDESPECIFICACION_GENERATOR")
	@Column(name="id_especificacion")
	private Integer idEspecificacion;

	@Column(name="descripcion_especificacion")
	private String descripcionEspecificacion;

	@Column(name="estado_especificacion")
	private Integer estadoEspecificacion;

	@Column(name="resultado_apt")
	private Integer resultadoApt;

	//bi-directional many-to-one association to AptResultadosAporte
	@OneToMany(mappedBy="aptEspesificacion")
	private List<AptResultadosAporte> aptResultadosAportes;

	public AptEspesificacion() {
	}

	public Integer getIdEspecificacion() {
		return this.idEspecificacion;
	}

	public void setIdEspecificacion(Integer idEspecificacion) {
		this.idEspecificacion = idEspecificacion;
	}

	public String getDescripcionEspecificacion() {
		return this.descripcionEspecificacion;
	}

	public void setDescripcionEspecificacion(String descripcionEspecificacion) {
		this.descripcionEspecificacion = descripcionEspecificacion;
	}

	public Integer getEstadoEspecificacion() {
		return this.estadoEspecificacion;
	}

	public void setEstadoEspecificacion(Integer estadoEspecificacion) {
		this.estadoEspecificacion = estadoEspecificacion;
	}

	public Integer getResultadoApt() {
		return this.resultadoApt;
	}

	public void setResultadoApt(Integer resultadoApt) {
		this.resultadoApt = resultadoApt;
	}

	public List<AptResultadosAporte> getAptResultadosAportes() {
		return this.aptResultadosAportes;
	}

	public void setAptResultadosAportes(List<AptResultadosAporte> aptResultadosAportes) {
		this.aptResultadosAportes = aptResultadosAportes;
	}

	public AptResultadosAporte addAptResultadosAporte(AptResultadosAporte aptResultadosAporte) {
		getAptResultadosAportes().add(aptResultadosAporte);
		aptResultadosAporte.setAptEspesificacion(this);

		return aptResultadosAporte;
	}

	public AptResultadosAporte removeAptResultadosAporte(AptResultadosAporte aptResultadosAporte) {
		getAptResultadosAportes().remove(aptResultadosAporte);
		aptResultadosAporte.setAptEspesificacion(null);

		return aptResultadosAporte;
	}

}