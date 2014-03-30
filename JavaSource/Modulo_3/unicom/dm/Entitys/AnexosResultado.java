package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the anexos_resultados database table.
 * 
 */
@Entity
@Table(name="anexos_resultados")
public class AnexosResultado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ANEXOS_RESULTADOS_IDRESULTADOS_GENERATOR", sequenceName="ANEXOS_RESULTADOS_ID_RESULTADOS_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANEXOS_RESULTADOS_IDRESULTADOS_GENERATOR")
	@Column(name="id_resultados")
	private Integer idResultados;

	private String documento;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	//bi-directional many-to-one association to SeguiResAporte
	@ManyToOne
	@JoinColumn(name="id_actividad_resultados")
	private SeguiResAporte seguiResAportes;

	public AnexosResultado() {
	}

	public Integer getIdResultados() {
		return this.idResultados;
	}

	public void setIdResultados(Integer idResultados) {
		this.idResultados = idResultados;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public SeguiResAporte getSeguiResAportes() {
		return this.seguiResAportes;
	}

	public void setSeguiResAportes(SeguiResAporte seguiResAportes) {
		this.seguiResAportes = seguiResAportes;
	}

}