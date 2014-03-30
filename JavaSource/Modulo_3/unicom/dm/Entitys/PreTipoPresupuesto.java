package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pre_tipo_presupuesto database table.
 * 
 */
@Entity
@Table(name="pre_tipo_presupuesto")
public class PreTipoPresupuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_TIPO_PRESUPUESTO_IDTIPOPRESUPUESTO_GENERATOR", sequenceName="PRE_TIPO_PRESUPUESTO_ID_TIPO_PRESUPUESTO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_TIPO_PRESUPUESTO_IDTIPOPRESUPUESTO_GENERATOR")
	@Column(name="id_tipo_presupuesto")
	private Integer idTipoPresupuesto;

	@Column(name="descripcion_tipo_presupuesto")
	private String descripcionTipoPresupuesto;

	@Column(name="estado_tipo_presupuesto")
	private Integer estadoTipoPresupuesto;

	//bi-directional many-to-one association to Presupuesto
	@OneToMany(mappedBy="preTipoPresupuesto")
	private List<Presupuesto> presupuesto;

	public PreTipoPresupuesto() {
	}

	public Integer getIdTipoPresupuesto() {
		return this.idTipoPresupuesto;
	}

	public void setIdTipoPresupuesto(Integer idTipoPresupuesto) {
		this.idTipoPresupuesto = idTipoPresupuesto;
	}

	public String getDescripcionTipoPresupuesto() {
		return this.descripcionTipoPresupuesto;
	}

	public void setDescripcionTipoPresupuesto(String descripcionTipoPresupuesto) {
		this.descripcionTipoPresupuesto = descripcionTipoPresupuesto;
	}

	public Integer getEstadoTipoPresupuesto() {
		return this.estadoTipoPresupuesto;
	}

	public void setEstadoTipoPresupuesto(Integer estadoTipoPresupuesto) {
		this.estadoTipoPresupuesto = estadoTipoPresupuesto;
	}

	public List<Presupuesto> getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(List<Presupuesto> presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Presupuesto addPresupuesto(Presupuesto presupuesto) {
		getPresupuesto().add(presupuesto);
		presupuesto.setPreTipoPresupuesto(this);

		return presupuesto;
	}

	public Presupuesto removePresupuesto(Presupuesto presupuesto) {
		getPresupuesto().remove(presupuesto);
		presupuesto.setPreTipoPresupuesto(null);

		return presupuesto;
	}

}