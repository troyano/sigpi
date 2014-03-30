package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the apt_cobertura database table.
 * 
 */
@Entity
@Table(name="apt_cobertura")
public class AptCobertura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="APT_COBERTURA_IDCOBERTURA_GENERATOR", sequenceName="APT_COBERTURA_ID_COBERTURA_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APT_COBERTURA_IDCOBERTURA_GENERATOR")
	@Column(name="id_cobertura")
	private Integer idCobertura;

	@Column(name="estado_cobertura")
	private Integer estadoCobertura;

	private BigDecimal porcentaje;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private Municipio municipio;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	public AptCobertura() {
	}

	public Integer getIdCobertura() {
		return this.idCobertura;
	}

	public void setIdCobertura(Integer idCobertura) {
		this.idCobertura = idCobertura;
	}

	public Integer getEstadoCobertura() {
		return this.estadoCobertura;
	}

	public void setEstadoCobertura(Integer estadoCobertura) {
		this.estadoCobertura = estadoCobertura;
	}

	public BigDecimal getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}