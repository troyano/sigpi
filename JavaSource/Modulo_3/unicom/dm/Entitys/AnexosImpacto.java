package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the anexos_impacto database table.
 * 
 */
@Entity
@Table(name="anexos_impacto")
public class AnexosImpacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ANEXOS_IMPACTO_IDANEXOIMPACTO_GENERATOR", sequenceName="ANEXOS_IMPACTO_SEG", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANEXOS_IMPACTO_IDANEXOIMPACTO_GENERATOR")
	@Column(name="id_anexo_impacto")
	private Integer idAnexoImpacto;

	@Column(name="documento_i")
	private String documentoI;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_anexo_i")
	private Date fechaAnexoI;

	//bi-directional one-to-one association to AptImpacto
	@OneToOne
	@JoinColumn(name="id_anexo_impacto")
	private AptImpacto aptImpacto;

	public AnexosImpacto() {
	}

	public Integer getIdAnexoImpacto() {
		return this.idAnexoImpacto;
	}

	public void setIdAnexoImpacto(Integer idAnexoImpacto) {
		this.idAnexoImpacto = idAnexoImpacto;
	}

	public String getDocumentoI() {
		return this.documentoI;
	}

	public void setDocumentoI(String documentoI) {
		this.documentoI = documentoI;
	}

	public Date getFechaAnexoI() {
		return this.fechaAnexoI;
	}

	public void setFechaAnexoI(Date fechaAnexoI) {
		this.fechaAnexoI = fechaAnexoI;
	}

	public AptImpacto getAptImpacto() {
		return this.aptImpacto;
	}

	public void setAptImpacto(AptImpacto aptImpacto) {
		this.aptImpacto = aptImpacto;
	}

}