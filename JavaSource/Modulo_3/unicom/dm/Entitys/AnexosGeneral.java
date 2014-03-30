package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the anexos_general database table.
 * 
 */
@Entity
@Table(name="anexos_general")
public class AnexosGeneral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ANEXOS_GENERAL_IDANEXONGENERAL_GENERATOR", sequenceName="ANEXOS_GENERAL_ID_ANEXON_GENERAL_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANEXOS_GENERAL_IDANEXONGENERAL_GENERATOR")
	@Column(name="id_anexon_general")
	private Integer idAnexonGeneral;

	@Column(name="descripcion_anexo_g")
	private String descripcionAnexoG;

	@Column(name="documento_g")
	private String documentoG;

	@Column(name="estado_anexo_g")
	private Integer estadoAnexoG;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_g")
	private Date fechaG;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	public AnexosGeneral() {
	}

	public Integer getIdAnexonGeneral() {
		return this.idAnexonGeneral;
	}

	public void setIdAnexonGeneral(Integer idAnexonGeneral) {
		this.idAnexonGeneral = idAnexonGeneral;
	}

	public String getDescripcionAnexoG() {
		return this.descripcionAnexoG;
	}

	public void setDescripcionAnexoG(String descripcionAnexoG) {
		this.descripcionAnexoG = descripcionAnexoG;
	}

	public String getDocumentoG() {
		return this.documentoG;
	}

	public void setDocumentoG(String documentoG) {
		this.documentoG = documentoG;
	}

	public Integer getEstadoAnexoG() {
		return this.estadoAnexoG;
	}

	public void setEstadoAnexoG(Integer estadoAnexoG) {
		this.estadoAnexoG = estadoAnexoG;
	}

	public Date getFechaG() {
		return this.fechaG;
	}

	public void setFechaG(Date fechaG) {
		this.fechaG = fechaG;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}