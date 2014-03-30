package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the referencia_bibliografica database table.
 * 
 */
@Entity
@Table(name="referencia_bibliografica")
public class ReferenciaBibliografica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REFERENCIA_BIBLIOGRAFICA_IDREFERENCIA_GENERATOR", sequenceName="REFERENCIA_BIBLIOGRAFICA_ID_REFERENCIA_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REFERENCIA_BIBLIOGRAFICA_IDREFERENCIA_GENERATOR")
	@Column(name="id_referencia")
	private Integer idReferencia;

	@Column(name="descripcion_referencia")
	private String descripcionReferencia;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	public ReferenciaBibliografica() {
	}

	public Integer getIdReferencia() {
		return this.idReferencia;
	}

	public void setIdReferencia(Integer idReferencia) {
		this.idReferencia = idReferencia;
	}

	public String getDescripcionReferencia() {
		return this.descripcionReferencia;
	}

	public void setDescripcionReferencia(String descripcionReferencia) {
		this.descripcionReferencia = descripcionReferencia;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}