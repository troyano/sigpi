package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the apt_tipo_resultado database table.
 * 
 */
@Entity
@Table(name="apt_tipo_resultado")
public class AptTipoResultado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="APT_TIPO_RESULTADO_IDTIPORESULTADO_GENERATOR", sequenceName="APT_TIPO_RESULTADO_ID_TIPO_RESULTADO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APT_TIPO_RESULTADO_IDTIPORESULTADO_GENERATOR")
	@Column(name="id_tipo_resultado")
	private Integer idTipoResultado;

	@Column(name="descripcion_resultado")
	private String descripcionResultado;

	@Column(name="estado_tipo_resul")
	private Integer estadoTipoResul;

	//bi-directional many-to-one association to AptResultadosAporte
	@OneToMany(mappedBy="aptTipoResultado")
	private List<AptResultadosAporte> aptResultadosAportes;

	public AptTipoResultado() {
	}

	public Integer getIdTipoResultado() {
		return this.idTipoResultado;
	}

	public void setIdTipoResultado(Integer idTipoResultado) {
		this.idTipoResultado = idTipoResultado;
	}

	public String getDescripcionResultado() {
		return this.descripcionResultado;
	}

	public void setDescripcionResultado(String descripcionResultado) {
		this.descripcionResultado = descripcionResultado;
	}

	public Integer getEstadoTipoResul() {
		return this.estadoTipoResul;
	}

	public void setEstadoTipoResul(Integer estadoTipoResul) {
		this.estadoTipoResul = estadoTipoResul;
	}

	public List<AptResultadosAporte> getAptResultadosAportes() {
		return this.aptResultadosAportes;
	}

	public void setAptResultadosAportes(List<AptResultadosAporte> aptResultadosAportes) {
		this.aptResultadosAportes = aptResultadosAportes;
	}

	public AptResultadosAporte addAptResultadosAporte(AptResultadosAporte aptResultadosAporte) {
		getAptResultadosAportes().add(aptResultadosAporte);
		aptResultadosAporte.setAptTipoResultado(this);

		return aptResultadosAporte;
	}

	public AptResultadosAporte removeAptResultadosAporte(AptResultadosAporte aptResultadosAporte) {
		getAptResultadosAportes().remove(aptResultadosAporte);
		aptResultadosAporte.setAptTipoResultado(null);

		return aptResultadosAporte;
	}

}