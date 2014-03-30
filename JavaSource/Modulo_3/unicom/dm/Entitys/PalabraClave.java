package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the palabra_clave database table.
 * 
 */
@Entity
@Table(name="palabra_clave")
public class PalabraClave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PALABRA_CLAVE_IDPALABRACLAVE_GENERATOR", sequenceName="PALABRA_CLAVE_ID_PALABRA_CLAVE_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PALABRA_CLAVE_IDPALABRACLAVE_GENERATOR")
	@Column(name="id_palabra_clave")
	private Integer idPalabraClave;

	private String palabra;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	public PalabraClave() {
	}

	public Integer getIdPalabraClave() {
		return this.idPalabraClave;
	}

	public void setIdPalabraClave(Integer idPalabraClave) {
		this.idPalabraClave = idPalabraClave;
	}

	public String getPalabra() {
		return this.palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}