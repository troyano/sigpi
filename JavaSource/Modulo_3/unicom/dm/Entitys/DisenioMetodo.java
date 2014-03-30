package Modulo_3.unicom.dm.Entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the disenio_metodo database table.
 * 
 */
@Entity
@Table(name="disenio_metodo")
public class DisenioMetodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DISENIO_METODO_IDDISENIO_GENERATOR", sequenceName="DISENIO_METODO_ID_DISENIO_SEQ", allocationSize =1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DISENIO_METODO_IDDISENIO_GENERATOR")
	@Column(name="id_disenio")
	private Integer idDisenio;

	@Column(name="descripcion_disenio")
	private String descripcionDisenio;

	@Column(name="estado_disenio")
	private Integer estadoDisenio;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	//bi-directional many-to-one association to TipoDisenioMetodo
	@ManyToOne
	@JoinColumn(name="id_tipo_disenio")
	private TipoDisenioMetodo tipoDisenioMetodo;

	public DisenioMetodo() {
	}

	public Integer getIdDisenio() {
		return this.idDisenio;
	}

	public void setIdDisenio(Integer idDisenio) {
		this.idDisenio = idDisenio;
	}

	public String getDescripcionDisenio() {
		return this.descripcionDisenio;
	}

	public void setDescripcionDisenio(String descripcionDisenio) {
		this.descripcionDisenio = descripcionDisenio;
	}

	public Integer getEstadoDisenio() {
		return this.estadoDisenio;
	}

	public void setEstadoDisenio(Integer estadoDisenio) {
		this.estadoDisenio = estadoDisenio;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public TipoDisenioMetodo getTipoDisenioMetodo() {
		return this.tipoDisenioMetodo;
	}

	public void setTipoDisenioMetodo(TipoDisenioMetodo tipoDisenioMetodo) {
		this.tipoDisenioMetodo = tipoDisenioMetodo;
	}

}