package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pre_tipo_contrato database table.
 * 
 */
@Entity
@Table(name="pre_tipo_contrato")
public class PreTipoContrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_TIPO_CONTRATO_IDTICONTRATO_GENERATOR", sequenceName="PRE_TIPO_CONTRATO_ID_TI_CONTRATO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_TIPO_CONTRATO_IDTICONTRATO_GENERATOR")
	@Column(name="id_ti_contrato")
	private Integer idTiContrato;

	@Column(name="descripcion_contrato")
	private String descripcionContrato;

	@Column(name="estado__tipo_contrac")
	private Integer estadoTipoContrac;

	//bi-directional many-to-one association to Presupuesto
	@OneToMany(mappedBy="preTipoContrato")
	private List<Presupuesto> presupuesto;

	public PreTipoContrato() {
	}

	public Integer getIdTiContrato() {
		return this.idTiContrato;
	}

	public void setIdTiContrato(Integer idTiContrato) {
		this.idTiContrato = idTiContrato;
	}

	public String getDescripcionContrato() {
		return this.descripcionContrato;
	}

	public void setDescripcionContrato(String descripcionContrato) {
		this.descripcionContrato = descripcionContrato;
	}

	public Integer getEstadoTipoContrac() {
		return this.estadoTipoContrac;
	}

	public void setEstadoTipoContrac(Integer estadoTipoContrac) {
		this.estadoTipoContrac = estadoTipoContrac;
	}

	public List<Presupuesto> getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(List<Presupuesto> presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Presupuesto addPresupuesto(Presupuesto presupuesto) {
		getPresupuesto().add(presupuesto);
		presupuesto.setPreTipoContrato(this);

		return presupuesto;
	}

	public Presupuesto removePresupuesto(Presupuesto presupuesto) {
		getPresupuesto().remove(presupuesto);
		presupuesto.setPreTipoContrato(null);

		return presupuesto;
	}

}