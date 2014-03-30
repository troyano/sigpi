package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the apt_tipo_impacto database table.
 * 
 */
@Entity
@Table(name="apt_tipo_impacto")
public class AptTipoImpacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="APT_TIPO_IMPACTO_IDTIPOIMPACTO_GENERATOR", sequenceName="APT_TIPO_IMPACTO_ID_TIPO_IMPACTO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APT_TIPO_IMPACTO_IDTIPOIMPACTO_GENERATOR")
	@Column(name="id_tipo_impacto")
	private Integer idTipoImpacto;

	@Column(name="descripcion_tipo_imp")
	private String descripcionTipoImp;

	@Column(name="estado_tipo_imp")
	private Integer estadoTipoImp;

	//bi-directional many-to-one association to AptImpacto
	@OneToMany(mappedBy="aptTipoImpacto")
	private List<AptImpacto> aptImpacto;

	public AptTipoImpacto() {
	}

	public Integer getIdTipoImpacto() {
		return this.idTipoImpacto;
	}

	public void setIdTipoImpacto(Integer idTipoImpacto) {
		this.idTipoImpacto = idTipoImpacto;
	}

	public String getDescripcionTipoImp() {
		return this.descripcionTipoImp;
	}

	public void setDescripcionTipoImp(String descripcionTipoImp) {
		this.descripcionTipoImp = descripcionTipoImp;
	}

	public Integer getEstadoTipoImp() {
		return this.estadoTipoImp;
	}

	public void setEstadoTipoImp(Integer estadoTipoImp) {
		this.estadoTipoImp = estadoTipoImp;
	}

	public List<AptImpacto> getAptImpacto() {
		return this.aptImpacto;
	}

	public void setAptImpacto(List<AptImpacto> aptImpacto) {
		this.aptImpacto = aptImpacto;
	}

	public AptImpacto addAptImpacto(AptImpacto aptImpacto) {
		getAptImpacto().add(aptImpacto);
		aptImpacto.setAptTipoImpacto(this);

		return aptImpacto;
	}

	public AptImpacto removeAptImpacto(AptImpacto aptImpacto) {
		getAptImpacto().remove(aptImpacto);
		aptImpacto.setAptTipoImpacto(null);

		return aptImpacto;
	}

}